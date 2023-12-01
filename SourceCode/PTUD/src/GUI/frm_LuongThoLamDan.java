package GUI;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import com.toedter.calendar.JYearChooser;
import Connection.MyConnection;
import DAO.DAO_LuongThoLamDan;
import DAO.DAO_ThoLamDan;
import Entity.BangLuongThoLamDan;
import Entity.ThoLamDan;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class frm_LuongThoLamDan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tbl_BangLuong;
	private JTextField txtTen;
	private JYearChooser yearChooser;
	private JComboBox<Object> cmbThang;
	private DefaultTableModel modelDanhSachLuong;
	private DAO_ThoLamDan dao_ThoLamDan = new DAO_ThoLamDan();
	private DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();

	/**
	 * Create the panel.
	 */
	public frm_LuongThoLamDan() {
		MyConnection.getInstance().MyConnection();

		setBackground(new Color(221, 242, 251));
		setLayout(null);

		JLabel lblTieuDe = new JLabel("Lương Thợ Làm Đàn");
		lblTieuDe.setForeground(new Color(0, 27, 72));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(301, 0, 850, 90);
		add(lblTieuDe);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(2, 104, 156));
		separator.setForeground(new Color(2, 104, 156));
		separator.setBounds(15, 183, 1420, 2);
		add(separator);

		JPanel panel_ThongTinLuong = new JPanel();
		panel_ThongTinLuong.setBackground(Color.WHITE);
		panel_ThongTinLuong.setLayout(null);
		panel_ThongTinLuong.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_ThongTinLuong.setBounds(15, 210, 1420, 480);
		add(panel_ThongTinLuong);

		JLabel lblBngLngNhn = new JLabel("Danh sách tiền lương thợ làm đàn");
		lblBngLngNhn.setForeground(new Color(0, 27, 72));
		lblBngLngNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBngLngNhn.setBounds(30, 10, 340, 30);
		panel_ThongTinLuong.add(lblBngLngNhn);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 50, 1360, 401);
		panel_ThongTinLuong.add(scrollPane_1);

		tbl_BangLuong = new JTable();
		scrollPane_1.setViewportView(tbl_BangLuong);
		String[] colHeader = { "M\u00E3 Th\u1EE3 L\u00E0m \u0110\u00E0n", "H\u1ECD T\u00EAn",
				"Ph\u1EE5 c\u1EA5p th\u00E2m ni\u00EAn", "Ti\u1EC1n L\u01B0\u01A1ng",
				"T\u1ED5ng Ti\u1EC1n L\u01B0\u01A1ng" };

		modelDanhSachLuong = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		tbl_BangLuong.setModel(modelDanhSachLuong);

		TableColumnModel columnModel = tbl_BangLuong.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tbl_BangLuong.getTableHeader().setReorderingAllowed(false);
		tbl_BangLuong.getColumnModel().getColumn(0).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(1).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(2).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(3).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(4).setResizable(false);

		JTableHeader tbBangLuong = tbl_BangLuong.getTableHeader();
		tbBangLuong.setBackground(new Color(151, 201, 219));
		tbBangLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		tbl_BangLuong.setRowHeight(rowHeight);
		tbl_BangLuong.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBackground(Color.WHITE);
		txtTen.setBounds(569, 10, 210, 25);
		panel_ThongTinLuong.add(txtTen);
		txtTen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ten = txtTen.getText().trim();
				if (ten.equals("")) {
					loadDataLuong();
					modelDanhSachLuong.fireTableDataChanged();
				} else {
					loadDataLuongTheoTen(ten);
					modelDanhSachLuong.fireTableDataChanged();
				}
			}
		});
		JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo tên");
		lblTmKimTheo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTmKimTheo.setBounds(393, 10, 176, 30);
		panel_ThongTinLuong.add(lblTmKimTheo);

		JButton btnTimTheoTen = new JButton("");
		btnTimTheoTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = txtTen.getText().trim();
				if (ten.equals("")) {
					loadDataLuong();
					modelDanhSachLuong.fireTableDataChanged();
				} else {
					loadDataLuongTheoTen(ten);
					modelDanhSachLuong.fireTableDataChanged();
				}
			}
		});
		btnTimTheoTen.setIcon(new ImageIcon(frm_LuongThoLamDan.class.getResource("/icons/search_icon.png")));
		btnTimTheoTen.setForeground(Color.WHITE);
		btnTimTheoTen.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTimTheoTen.setBackground(new Color(2, 104, 156));
		btnTimTheoTen.setBounds(804, 10, 61, 25);
		panel_ThongTinLuong.add(btnTimTheoTen);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(2, 104, 156));
		separator_1.setBackground(new Color(2, 104, 156));
		separator_1.setBounds(385, 10, 21, 30);
		panel_ThongTinLuong.add(separator_1);

		JButton btnXuat = new JButton("Xuất Excel");
		btnXuat.setForeground(Color.WHITE);
		btnXuat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXuat.setBackground(new Color(2, 104, 156));
		btnXuat.setBounds(1220, 12, 170, 25);
		panel_ThongTinLuong.add(btnXuat);
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel(tbl_BangLuong);
			}
		});
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(15, 90, 1420, 67);
		add(panel_1);

		JLabel lblThang = new JLabel("Tháng");
		lblThang.setBounds(30, 20, 80, 30);
		panel_1.add(lblThang);
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 16));

		yearChooser = new JYearChooser();
		yearChooser.setLocation(250, 20);
		yearChooser.setSize(60, 30);
		panel_1.add(yearChooser);

		String[] thang = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cmbThang = new JComboBox<Object>(thang);
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		int monthValue = currentMonth.getValue();
		cmbThang.setSelectedIndex(monthValue - 1);
		cmbThang.setBounds(110, 20, 56, 30);
		panel_1.add(cmbThang);

		JLabel lblNam = new JLabel("Năm");
		lblNam.setBounds(190, 20, 80, 30);
		panel_1.add(lblNam);
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnXemLuong = new JButton("Tính Lương");
		btnXemLuong.setIcon(null);
		btnXemLuong.setForeground(Color.WHITE);
		btnXemLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXemLuong.setBackground(new Color(2, 104, 156));
		btnXemLuong.setBounds(340, 20, 130, 30);
		panel_1.add(btnXemLuong);
		btnXemLuong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_ThongTinLuong.setEnabled(true);
				for (Component component : panel_ThongTinLuong.getComponents()) {
					component.setEnabled(true);
				}
				loadDataLuong();
			}
		});

		panel_ThongTinLuong.setEnabled(false);
		for (Component component : panel_ThongTinLuong.getComponents()) {
			component.setEnabled(false);
		}

		tbl_BangLuong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl_BangLuong.getSelectedRow();
				int nam = yearChooser.getYear();
				int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
				String maBangLuong = dao_LuongThoLamDan.getMaBangLuong(thang, nam,
						(String) modelDanhSachLuong.getValueAt(row, 0));
				BangLuongThoLamDan bangLuongThoLamDan = dao_LuongThoLamDan.getBangLuongTheoMa(maBangLuong);
				frm_ChiTietBangThoLamDan bangLuong = new frm_ChiTietBangThoLamDan(bangLuongThoLamDan);
				bangLuong.setVisible(true);
			}
		});
	}

	private void loadDataLuong() {
		modelDanhSachLuong.setRowCount(0);
		int nam = yearChooser.getYear();
		int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
		int slSanPham = 0;
		for (ThoLamDan thoLamDan : dao_ThoLamDan.getAlListThoLamDan()) {
			BangLuongThoLamDan bl = new BangLuongThoLamDan();
			bl.setNam(nam);
			bl.setThang(thang);
			slSanPham = dao_LuongThoLamDan.laySoSanPham(thoLamDan.getMaThoLamDan(), thang, nam);
			bl.setSoLuongSanPham(slSanPham);
			String maBangLuong = dao_LuongThoLamDan.getMaBangLuong(thang, nam, thoLamDan.getMaThoLamDan());
			bl.setMaBangLuong(maBangLuong);
			bl.setThoLamDan(thoLamDan);
			dao_LuongThoLamDan.updateBangLuongThoLamDan(bl);
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
			double luong = dao_LuongThoLamDan.layTongThuNhapTungThang(thoLamDan.getMaThoLamDan(), thang, nam);
			Object[] objects = { thoLamDan.getMaThoLamDan(), thoLamDan.getCongNhanVien().getHoTen(),
					decimalFormat.format(thoLamDan.getCongNhanVien().tinhPhuCapThamNien(thoLamDan.tinhHeSoLuong())),
					decimalFormat.format(luong), decimalFormat.format(bl.tinhLuongThucLinh(luong)) };
			modelDanhSachLuong.addRow(objects);
		}
	}

	public static void exportExcel(JTable table) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn nơi lưu tệp Excel");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Tệp Excel (.xls)", "xls");
		fileChooser.setFileFilter(filter);

		int userSelection = fileChooser.showSaveDialog(null);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			try {
				File fileToSave = fileChooser.getSelectedFile();
				String filePath = fileToSave.getAbsolutePath();
				if (!filePath.endsWith(".xls")) {
					filePath += ".xls";
				}

				Workbook workbook = new HSSFWorkbook();
				Sheet sheet = workbook.createSheet("DanhSachThoLamDan");

				Row headerRow = sheet.createRow(0);
				for (int col = 0; col < table.getColumnCount(); col++) {
					headerRow.createCell(col).setCellValue(table.getColumnName(col));
				}

				for (int row = 0; row < table.getRowCount(); row++) {
					Row dataRow = sheet.createRow(row + 1);
					for (int col = 0; col < table.getColumnCount(); col++) {
						Object cellValue = table.getValueAt(row, col);
						if (cellValue != null) {
							if (cellValue instanceof String) {
								dataRow.createCell(col).setCellValue((String) cellValue);
							} else if (cellValue instanceof Number) {
								dataRow.createCell(col).setCellValue(((Number) cellValue).doubleValue());
							} else {
								dataRow.createCell(col).setCellValue(cellValue.toString());
							}
						}
					}
				}

				try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
					workbook.write(fileOut);
					JOptionPane.showMessageDialog(null, "Tạo và lưu tệp Excel thành công!");
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi khi tạo và lưu tệp Excel!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//	private void themBangLuong(ThoLamDan thoLamDan) {
//		LocalDate currentDate = LocalDate.now();
//		Month currentMonth = currentDate.getMonth();
//		int thang = currentMonth.getValue();
//		int nam = currentDate.getYear();
//		BangLuongThoLamDan bl = new BangLuongThoLamDan();
//		bl.setNam(nam);
//		bl.setThang(thang);
//		bl.setThoLamDan(thoLamDan);
//		String maBangLuong = dao_LuongThoLamDan.getMaBangLuong(thang, nam, thoLamDan.getMaThoLamDan());
//		bl.setMaBangLuong(maBangLuong);
//		bl.setSoLuongSanPham(0);
//		DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();
//		dao_LuongThoLamDan.themBangLuongThoLamDan(bl);
//	}

	private void loadDataLuongTheoTen(String tenThoLamDan) {

		try {
			int sl = dao_LuongThoLamDan.kiemTraTimKiemTheoTen(tenThoLamDan);
			if (sl == 0) {
				modelDanhSachLuong.setRowCount(0);
				JOptionPane.showMessageDialog(null, "Không có tên nhân viên tìm kiếm");
			} else {
				modelDanhSachLuong.setRowCount(0);
				DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
				int nam = yearChooser.getYear();
				int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
				ArrayList<BangLuongThoLamDan> listBL = dao_LuongThoLamDan.getBangLuongTheoTen(tenThoLamDan, thang, nam);
				for (BangLuongThoLamDan bangLuongThoLamDan : listBL) {
					double luong = dao_LuongThoLamDan.layTongThuNhapTungThang(
							bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(), bangLuongThoLamDan.getThang(),
							bangLuongThoLamDan.getNam());

					Object[] objects = { bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(),
							bangLuongThoLamDan.getThoLamDan().getCongNhanVien().getHoTen(),
							decimalFormat.format(bangLuongThoLamDan.getThoLamDan().getCongNhanVien()
									.tinhPhuCapThamNien(bangLuongThoLamDan.getThoLamDan().tinhHeSoLuong())),
							decimalFormat.format(luong),
							decimalFormat.format(bangLuongThoLamDan.tinhLuongThucLinh(luong)) };
					modelDanhSachLuong.addRow(objects);

				}

			}
			modelDanhSachLuong.fireTableDataChanged();
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
