package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Connection.MyConnection;
import DAO.DAO_ChamCongNhanVien;
import DAO.DAO_LuongNhanVien;
import DAO.DAO_NhanVien;
import Entity.BangChamCongNhanVien;
import Entity.BangLuongNhanVien;
import Entity.NhanVien;

import javax.swing.JScrollPane;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChamCongNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableChamCong;
	private DefaultTableModel modelChamCong;
	private JButton btnChamCong;
	private DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	private DAO_ChamCongNhanVien dao_ChamCongNhanVien = new DAO_ChamCongNhanVien();
	private DAO_LuongNhanVien dao_LuongNhanVien = new DAO_LuongNhanVien();


	/**
	 * Create the panel.
	 */
	public ChamCongNhanVien() {
		MyConnection.getInstance().MyConnection();
		setBackground(new Color(221, 242, 251));
		setLayout(null);
		JLabel lblNewLabel = new JLabel("BẢNG CHẤM CÔNG NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setForeground((new Color(0, 27, 72)));

		lblNewLabel.setBounds(300, 5, 850, 90);
		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 1430, 500);
		add(scrollPane);

		tableChamCong = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column >= 3;
			}
		};
		tableChamCong.setBackground(new Color(255, 255, 255));
		tableChamCong.setEditingRow(0);
		tableChamCong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableChamCong);

		scrollPane.setViewportView(tableChamCong);
		tableChamCong.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, },
				new String[] { "Ng\u00E0y ch\u1EA5m c\u00F4ng", "M\u00E3 Nh\u00E2n Vi\u00EAn",
						"T\u00EAn Nh\u00E2n Vi\u00EAn", "Tr\u1EA1ng Th\u00E1i", "S\u1ED1 gi\u1EDD t\u0103ng ca" }));
		String[] gioTangCaLuaChon = { "0", "1", "2", "3", "4" };
		JComboBox<String> gioTangCaComboBox = new JComboBox<>(gioTangCaLuaChon);
		DefaultCellEditor editorGioTangCa = new DefaultCellEditor(gioTangCaComboBox);
		TableColumn gioTangCaColumn = tableChamCong.getColumnModel().getColumn(4);
		gioTangCaColumn.setCellEditor(editorGioTangCa);
		gioTangCaComboBox.setSelectedItem("0");

		String[] trangThaiLuaChon = { "Chưa ghi nhận công", "Làm nguyên ca", "Làm nửa ca", "Nghỉ có phép",
				"Nghỉ không phép" };
		JComboBox<String> trangThaiComboBox = new JComboBox<>(trangThaiLuaChon);
		DefaultCellEditor editorTrangThai = new DefaultCellEditor(trangThaiComboBox);
		TableColumn trangThaiColumn = tableChamCong.getColumnModel().getColumn(3);
		trangThaiColumn.setCellEditor(editorTrangThai);
		trangThaiComboBox.setSelectedItem("Chưa ghi nhận công");

		modelChamCong = (DefaultTableModel) tableChamCong.getModel();

		JTableHeader tb = tableChamCong.getTableHeader();
		tb.setBackground(new Color(151, 201, 219));
		tb.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		tableChamCong.setRowHeight(rowHeight);
		tableChamCong.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));

		btnChamCong = new JButton("Chấm Công");
		btnChamCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = 0;
				for (int i = 0; i < modelChamCong.getRowCount(); i++) {
					String trangThaiDiLam = (String) modelChamCong.getValueAt(i, 3);
					if (trangThaiDiLam.equals("Chưa ghi nhận công")) {
						check++;
					}
				}

				if (check != 0) {
					JOptionPane.showMessageDialog(null, "Chưa hoàn thành chấm công cho nhân viên");
				} else {
					int output = JOptionPane.showConfirmDialog(null, "Bạn xác nhận chấm công", "Thông báo xác nhận",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (output == JOptionPane.YES_OPTION) {
						for (int row = 0; row < modelChamCong.getRowCount(); row++) {
							String maNhanVien = (String) modelChamCong.getValueAt(row, 1);
							NhanVien nhanVien = dao_NhanVien.getNhanVienTheoMa(maNhanVien);
							BangChamCongNhanVien bangChamCong = new BangChamCongNhanVien();
							long currentTimeMillis = System.currentTimeMillis();
							Date currentDate = new Date(currentTimeMillis);
							bangChamCong.setNhanVien(nhanVien);
							bangChamCong.setSoGioTangCa(Integer.parseInt((String) modelChamCong.getValueAt(row, 4)));
							bangChamCong.setTrangThaiDiLam((String) modelChamCong.getValueAt(row, 3));
							bangChamCong.setNgayChamCong(currentDate);
							
							LocalDate currentDate1 = LocalDate.now();
							Month currentMonth = currentDate1.getMonth();
							int thang = currentMonth.getValue();
							int nam = currentDate1.getYear();
							boolean KT =  dao_LuongNhanVien.kiemTraTrungMa(thang, nam, nhanVien.getMaNhanVien());
							if (!KT) {
								themBangLuong(nhanVien);
							}
							bangChamCong.setBangLuong(null);
							String maBangLuong = dao_LuongNhanVien.getMaBangLuong(thang, nam, nhanVien.getMaNhanVien());
//							try {
//								if (dao_ChamCongNhanVien.KiemTraTrung(bangChamCong)) {
//									dao_ChamCongNhanVien.themBangChamCong(bangChamCong);
//								} else {
//									SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//									String tb = "Đã Chấm Công Cho " + bangChamCong.getNhanVien().getMaNhanVien()
//											+ " ở ngày " + dateFormat.format(bangChamCong.getNgayChamCong());
//									JOptionPane.showMessageDialog(null, tb);
//								}
//
//							} catch (SQLException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//								JOptionPane.showMessageDialog(null, "Chấm Công Thất Bại");
//							}
						}

					}
				}
			}
		});
		btnChamCong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChamCong.setForeground(Color.WHITE);
		btnChamCong.setBackground(new Color(2, 104, 156));
		btnChamCong.setBounds(525, 630, 170, 50);
		add(btnChamCong);

		JButton btnMacDinh = new JButton("Tất cả");
		btnMacDinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int row = 0; row < modelChamCong.getRowCount(); row++) {
					modelChamCong.setValueAt("Làm nguyên ca", row, 3);
				}
			}
		});
		btnMacDinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMacDinh.setForeground(Color.WHITE);
		btnMacDinh.setBackground(new Color(120, 186, 219));
		btnMacDinh.setBounds(755, 630, 170, 50);
		add(btnMacDinh);

		loadDataIntoTableChamCong();
	}

	private void loadDataIntoTableChamCong() {
		modelChamCong.setRowCount(0);
		long currentTimeMillis = System.currentTimeMillis();
		Date currentDate = new Date(currentTimeMillis);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		for (NhanVien nhanVien : dao_NhanVien.getAllListNhanVien()) {
			Object[] objects = { dateFormat.format(currentDate).toString(), nhanVien.getMaNhanVien(),
					nhanVien.getCongNhanVien().getHoTen(), "Chưa ghi nhận công", "0" };
			modelChamCong.addRow(objects);
		}
	}
	
	private void themBangLuong(NhanVien nhanVien) {
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		int thang = currentMonth.getValue();
		int nam = currentDate.getYear();
		BangLuongNhanVien bl = new BangLuongNhanVien();
		bl.setNam(nam);
		bl.setThang(thang);
		bl.setNhanVien(nhanVien);
		bl.setSoGioTangCaChuNhat(0);
		bl.setSoGioTangCaNgayThuong(0);
		bl.setSoNgayLamChuNhat(0);
		bl.setSoNgayThuongDiLam(0);
		bl.setSoNgayNghiCoPhep(0);
		bl.setSoNgayNghiKhongPhep(0);
		String maBangLuong = dao_LuongNhanVien.getMaBangLuong(thang, nam, nhanVien.getMaNhanVien());
		bl.setMaBangLuong(maBangLuong);
		DAO_LuongNhanVien dao_LuongNhanVien = new DAO_LuongNhanVien();
		dao_LuongNhanVien.themBangLuongNhanVien(bl);
	}

}
