package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JDateChooser;

import Connection.MyConnection;
import DAO.DAO_BangPhanCong;
import DAO.DAO_ChamCongThoLamDan;
import DAO.DAO_CongDoan;
import DAO.DAO_Dan;
import DAO.DAO_LuongThoLamDan;
import DAO.DAO_ThoLamDan;
import Entity.BangChamCongThoLamDan;
import Entity.BangLuongThoLamDan;
import Entity.BangPhanCong;
import Entity.CongDoan;
import Entity.Dan;
import Entity.ThoLamDan;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;

public class frm_ChamCongThoLamDan extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable tbl_BangChamCong;
	private JTextField txtTen;
	private JDateChooser ngayPhanCong;

	private DefaultTableModel model_BagPhanCong;
	private DAO_ChamCongThoLamDan dao_ChamCongThoLamDan = new DAO_ChamCongThoLamDan();
	private DAO_ThoLamDan dao_ThoLamDan = new DAO_ThoLamDan();
	private DAO_CongDoan dao_congDoan = new DAO_CongDoan();
	private DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();
	private DAO_Dan dao_dan = new DAO_Dan();
	private DAO_BangPhanCong dao_BangPhanCong = new DAO_BangPhanCong();

	/**
	 * Create the panel.
	 */
	public frm_ChamCongThoLamDan() {
		MyConnection.getInstance().MyConnection();

		setBackground(new Color(221, 242, 251));
		setLayout(null);

		JLabel lblTieuDe = new JLabel("Chấm Công Thợ Làm Đàn");
		lblTieuDe.setForeground(new Color(0, 27, 72));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(301, 0, 850, 90);
		add(lblTieuDe);

		int rowHeight = 30;
		int rowMargin = 10;

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_2.setBounds(27, 85, 1413, 579);
		add(panel_1_2);

		JLabel lblThongTinDSCC = new JLabel("Danh Sách Chấm Công");
		lblThongTinDSCC.setForeground(new Color(0, 27, 72));
		lblThongTinDSCC.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblThongTinDSCC.setBounds(568, 70, 318, 25);
		panel_1_2.add(lblThongTinDSCC);
		ngayPhanCong = new JDateChooser();
		ngayPhanCong.setSize(new Dimension(30, 20));
		ngayPhanCong.setDateFormatString("dd-MM-yyyy");
		try {
			Date date = Date.valueOf(LocalDate.now());
			ngayPhanCong.setDate(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ngayPhanCong.setBounds(206, 20, 130, 25);
		ngayPhanCong.setEnabled(false);
		panel_1_2.add(ngayPhanCong);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 128, 1365, 376);
		panel_1_2.add(scrollPane);
		model_BagPhanCong = new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "Mã TLD", "Họ Tên", "Sản Phẩm", "Công đoạn", "Số lượng được phân công",
						"Số lượng làm được", "Trạng Thái" }) {
			/**
			 * s
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbl_BangChamCong = new JTable(model_BagPhanCong);
		tbl_BangChamCong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbl_BangChamCong);
		TableColumnModel columnModel = tbl_BangChamCong.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tbl_BangChamCong.getTableHeader().setReorderingAllowed(false);
		tbl_BangChamCong.getColumnModel().getColumn(0).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(1).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(2).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(3).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(4).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(5).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(6).setResizable(false);

		String[] trangThaiLuaChon = { "Chưa ghi nhận chấm công", "Có mặt", "Vắng mặt" };
		JComboBox<String> trangThaiComboBox = new JComboBox<>(trangThaiLuaChon);
		DefaultCellEditor editorTrangThai = new DefaultCellEditor(trangThaiComboBox);
		TableColumn trangThaiColumn = tbl_BangChamCong.getColumnModel().getColumn(6);
		trangThaiColumn.setCellEditor(editorTrangThai);
		trangThaiComboBox.setSelectedItem("Chưa ghi nhận công");

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBackground(new Color(255, 255, 255));
		txtTen.setBounds(591, 20, 210, 25);
		panel_1_2.add(txtTen);
		txtTen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ten = txtTen.getText().trim();
				if (ten.equals("")) {
					loadDataIntoTableChamCong();
					model_BagPhanCong.fireTableDataChanged();
				} else {
					loadDataIntoTableChamCongTheoTen(ten);
					model_BagPhanCong.fireTableDataChanged();
				}
			}
		});
		JButton btnTimKiemTen = new JButton("");
		btnTimKiemTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = txtTen.getText().trim();
				if (ten.equals("")) {
					loadDataIntoTableChamCong();
					model_BagPhanCong.fireTableDataChanged();
				} else {
					loadDataIntoTableChamCongTheoTen(ten);
					model_BagPhanCong.fireTableDataChanged();
				}
			}
		});

		model_BagPhanCong.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub

				if (e.getType() == TableModelEvent.UPDATE) {
					int row = e.getFirstRow();
					int column = e.getColumn();

					if (column == 6) {
						String status = (String) model_BagPhanCong.getValueAt(row, 6);
						Object vaObject = model_BagPhanCong.getValueAt(row, 4);
						int defaultValue = (int) vaObject;
						if (status.equals("Có mặt")) {
							model_BagPhanCong.setValueAt(defaultValue, row, 5);
						} else if (status.equals("Vắng mặt")) {
							model_BagPhanCong.setValueAt(0, row, 5);
						}
					}

					if (column == 5) {
						String status = (String) model_BagPhanCong.getValueAt(row, 6);
						if (status.equals("Có mặt")) {
							Object oldValue = model_BagPhanCong.getValueAt(row, 4);
							int soLuongPC = (int) oldValue;
							String newValue = model_BagPhanCong.getValueAt(row, 5).toString();
							try {
								int slHT = Integer.parseInt(newValue);
								if (slHT > soLuongPC && slHT > 0) {
									model_BagPhanCong.setValueAt(oldValue, row, 5);
									JOptionPane.showMessageDialog(null,
											"Số lượng hoàn thành phải nhỏ hơn số lượng được phân công và phải lớn hơn 0");
								}
							} catch (Exception e2) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(null, "Số lượng hoàn thành phải là số");
							}
						} else if (status.equals("Chưa ghi nhận chấm công")) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn trạng thái trước khi nhập số lượng");
						}

					}
				}
			}
		});

		JTableHeader tbNhanVien = tbl_BangChamCong.getTableHeader();
		tbNhanVien.setBackground(new Color(151, 201, 219));
		tbNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		tbl_BangChamCong.setRowHeight(rowHeight);
		tbl_BangChamCong.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));

		btnTimKiemTen.setIcon(new ImageIcon(frm_ChamCongThoLamDan.class.getResource("/icons/search_icon.png")));
		btnTimKiemTen.setForeground(Color.WHITE);
		btnTimKiemTen.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTimKiemTen.setBackground(new Color(2, 104, 156));
		btnTimKiemTen.setBounds(812, 20, 61, 25);
		panel_1_2.add(btnTimKiemTen);

		JButton btnChamCong = new JButton("Chấm Công");
		btnChamCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(null, "Bạn xác nhận chấm công", "Thông báo xác nhận",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (output == JOptionPane.YES_OPTION) {
					try {
						java.util.Date utilDate = new java.util.Date();
						Date date = new Date(utilDate.getTime());
						int check = 0;
						ArrayList<BangChamCongThoLamDan> listBCC = dao_ChamCongThoLamDan.layDanhSachChamCong(date);
						ArrayList<String> listtld = new ArrayList<>();
						for (BangChamCongThoLamDan bangChamCongThoLamDan : listBCC) {
							listtld.add(bangChamCongThoLamDan.getThoLamDan().getMaThoLamDan());
						}

						for (int row = 0; row < model_BagPhanCong.getRowCount(); row++) {
							if (listtld.contains((String) model_BagPhanCong.getValueAt(row, 0))) {

							} else {
								String trangThaiDiLam = (String) model_BagPhanCong.getValueAt(row, 6);
								if (!trangThaiDiLam.equals("Chưa ghi nhận chấm công")) {
									check++;
									String maThoLamDan = (String) model_BagPhanCong.getValueAt(row, 0);
									ThoLamDan thoLamDan = dao_ThoLamDan.getTLDTheoMaThoLamDan(maThoLamDan);
									BangChamCongThoLamDan bccThoLamDan = new BangChamCongThoLamDan();
									bccThoLamDan.setThoLamDan(thoLamDan);
									long currentTimeMillis = System.currentTimeMillis();
									Date currentDate = new Date(currentTimeMillis);
									bccThoLamDan.setNgayChamCong(currentDate);
									String tenSP = (String) model_BagPhanCong.getValueAt(row, 2);
									Dan dan = dao_dan.getDanTheoTenSanPham(tenSP);
									String tenCongDoan = (String) model_BagPhanCong.getValueAt(row, 3);

									CongDoan congdoan = dao_congDoan.getCongDoanTheoCDSP(tenCongDoan,
											dan.getMaSanPham());
									bccThoLamDan.setCongDoan(congdoan);
									LocalDate currentDate1 = LocalDate.now();
									Month currentMonth = currentDate1.getMonth();
									int thang = currentMonth.getValue();
									int nam = currentDate1.getYear();
									int sl = 0;
									if (trangThaiDiLam.equals("Có mặt")) {
										String soLuongSanPham = model_BagPhanCong.getValueAt(row, 5).toString();
										sl = Integer.parseInt(soLuongSanPham);
									} else {
										sl = 0;
									}

									bccThoLamDan.setSoLuongSanPham(sl);
									String ma = thoLamDan.getMaThoLamDan();
									boolean KT = dao_LuongThoLamDan.kiemTraTrungMa(thang, nam, ma);

									if (!KT) {
										themBangLuong(thoLamDan);
									}

									String maBangLuong = dao_LuongThoLamDan.getMaBangLuong(thang, nam,
											thoLamDan.getMaThoLamDan());
									BangLuongThoLamDan bangLuong = dao_LuongThoLamDan.getBangLuongTheoMa(maBangLuong);
									bccThoLamDan.setBangLuong(bangLuong);
									try {
										dao_ChamCongThoLamDan.themBangChamCong(bccThoLamDan);
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
								}
							}
						}
						if (check != 0) {
							JOptionPane.showMessageDialog(null, "Chấm Công Thành Công");
						} else {
							JOptionPane.showMessageDialog(null, "Không có thợ làm đàn nào để chấm công");

						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Chấm Công Thất Bại");
						e2.printStackTrace();
					}
				}
			}
		}

		);
		btnChamCong.setForeground(Color.WHITE);
		btnChamCong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChamCong.setBackground(new Color(2, 104, 156));
		btnChamCong.setBounds(1259, 528, 129, 30);
		panel_1_2.add(btnChamCong);

		JLabel lblTimKiemTheoTen = new JLabel("Tìm kiếm theo tên");
		lblTimKiemTheoTen.setForeground(new Color(0, 27, 72));
		lblTimKiemTheoTen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimKiemTheoTen.setBounds(394, 20, 187, 25);
		panel_1_2.add(lblTimKiemTheoTen);

		JLabel lblSP = new JLabel("Sản Phẩm");
		lblSP.setForeground(new Color(0, 27, 72));
		lblSP.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSP.setBounds(899, 20, 116, 25);
		panel_1_2.add(lblSP);

		JComboBox<String> comboBoxSP = new JComboBox<String>();
		comboBoxSP.setBounds(1017, 20, 100, 25);
		panel_1_2.add(comboBoxSP);
		comboBoxSP.addItem("Tất cả");
		for (Dan dan : dao_dan.getAlListDan()) {
			comboBoxSP.addItem(dan.getTenSanPham());
		}
		comboBoxSP.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selectedValue = (String) comboBoxSP.getSelectedItem();
					if (selectedValue.equals("Tất cả")) {
						loadDataIntoTableChamCong();
						model_BagPhanCong.fireTableDataChanged();
					} else {
						Dan dan = dao_dan.getDanTheoTenSanPham(selectedValue);
						loadDataIntoTableChamCongTheoSanPham(dan.getMaSanPham());
					}
				}
			}
		});

		JComboBox<String> comboBoxCongDoan = new JComboBox<String>();
		comboBoxCongDoan.setBounds(1287, 20, 100, 25);
		panel_1_2.add(comboBoxCongDoan);
		comboBoxCongDoan.addItem("Tất cả");
		String[] tenCongDoan = { "Lựa chọn chất liệu gỗ", "Xử lý độ ẩm", "Chế tác mặt đàn", "Chế tác eo lưng",
				"Chế tác cần đàn", "Chế tác mặt phím", "Chế tác dây đàn", "Chế tác khóa đàn", "Chế tác cầu ngựa",
				"Cảm âm", "Thiết kế lỗ thoát âm", "Kiểm tra và điều chỉnh", "Tinh chỉnh âm thanh",
				"Hoàn thiện và làm đẹp" };
		for (String congDoan : tenCongDoan) {
			comboBoxCongDoan.addItem(congDoan);
		}

		comboBoxCongDoan.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selectedValue = (String) comboBoxCongDoan.getSelectedItem();
					if (selectedValue.equals("Tất cả")) {
						loadDataIntoTableChamCong();
						model_BagPhanCong.fireTableDataChanged();
					} else {
						loadDataIntoTableChamCongTheoTenCongDoan(selectedValue);
						model_BagPhanCong.fireTableDataChanged();
					}
				}
			}
		});
		JLabel lblCongDoan = new JLabel("Công Đoạn");
		lblCongDoan.setForeground(new Color(0, 27, 72));
		lblCongDoan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCongDoan.setBounds(1144, 20, 116, 25);
		panel_1_2.add(lblCongDoan);

		JLabel lblNgayChamCong = new JLabel("Ngày Chấm Công");
		lblNgayChamCong.setForeground(new Color(0, 27, 72));
		lblNgayChamCong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNgayChamCong.setBounds(20, 20, 270, 25);
		panel_1_2.add(lblNgayChamCong);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 128));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(366, 20, 5, 25);
		panel_1_2.add(separator);

		JButton btnMacDinh = new JButton("Mặc định");
		btnMacDinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.util.Date utilDate = new java.util.Date();
					Date date = new Date(utilDate.getTime());
					ArrayList<BangChamCongThoLamDan> listBCC = dao_ChamCongThoLamDan.layDanhSachChamCong(date);
					ArrayList<String> listtld = new ArrayList<>();
					for (BangChamCongThoLamDan bangChamCongThoLamDan : listBCC) {
						listtld.add(bangChamCongThoLamDan.getThoLamDan().getMaThoLamDan());
					}

					for (int row = 0; row < model_BagPhanCong.getRowCount(); row++) {
						if (listtld.contains((String) model_BagPhanCong.getValueAt(row, 0))) {

						} else {

							Object slValue = model_BagPhanCong.getValueAt(row, 4);
							int sl = (int) slValue;
							model_BagPhanCong.setValueAt("Có mặt", row, 6);
							model_BagPhanCong.setValueAt(sl, row, 5);
						}
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnMacDinh.setForeground(Color.WHITE);
		btnMacDinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMacDinh.setBackground(new Color(120, 186, 219));
		btnMacDinh.setBounds(1104, 528, 129, 30);
		panel_1_2.add(btnMacDinh);
		loadDataIntoTableChamCong();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private void loadDataIntoTableChamCong() {
		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());
		try {
			model_BagPhanCong.setRowCount(0);
			ArrayList<BangChamCongThoLamDan> listBCC = dao_ChamCongThoLamDan.layDanhSachChamCong(date);
			ArrayList<String> listtld = new ArrayList<>();
			for (BangChamCongThoLamDan bangChamCongThoLamDan : listBCC) {
				listtld.add(bangChamCongThoLamDan.getThoLamDan().getMaThoLamDan());
			}
			ArrayList<BangPhanCong> listBangPhanCong = dao_ChamCongThoLamDan.listAllBangPhanCongTheoNgayHienTai();
			for (BangPhanCong bangPhanCong : listBangPhanCong) {
				if (listtld.contains(bangPhanCong.getThoLamDan().getMaThoLamDan())) {
					Object[] objects = { bangPhanCong.getThoLamDan().getMaThoLamDan(),
							bangPhanCong.getThoLamDan().getCongNhanVien().getHoTen(),
							bangPhanCong.getCongDoan().getDan().getTenSanPham(),
							bangPhanCong.getCongDoan().getTenCongDoan(), bangPhanCong.getSoLuongSanPham(),
							bangPhanCong.getSoLuongSanPham(), "Có mặt" };
					model_BagPhanCong.addRow(objects);
				} else {
					Object[] objects = { bangPhanCong.getThoLamDan().getMaThoLamDan(),
							bangPhanCong.getThoLamDan().getCongNhanVien().getHoTen(),
							bangPhanCong.getCongDoan().getDan().getTenSanPham(),
							bangPhanCong.getCongDoan().getTenCongDoan(), bangPhanCong.getSoLuongSanPham(),
							bangPhanCong.getSoLuongSanPham(), "Chưa ghi nhận chấm công" };
					model_BagPhanCong.addRow(objects);

				}
			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

	}

	private void loadDataIntoTableChamCongTheoTen(String ten) {
		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());
		try {
			int sl = dao_ChamCongThoLamDan.kiemTraTimKiemTheoTen(ten);
			if (sl == 0) {
				model_BagPhanCong.setRowCount(0);
				JOptionPane.showMessageDialog(null, "Không có tên nhân viên tìm kiếm");
			} else {
				model_BagPhanCong.setRowCount(0);

				ArrayList<BangPhanCong> listBangPhanCong = dao_ChamCongThoLamDan.listAllBangPhanCongTheoNgayHienTai();
				ArrayList<String> listmatld = new ArrayList<>();
				for (BangPhanCong bangPhanCong : listBangPhanCong) {
					listmatld.add(bangPhanCong.getThoLamDan().getMaThoLamDan());
				}
				ArrayList<BangChamCongThoLamDan> listBCC = dao_ChamCongThoLamDan.layDanhSachChamCongTheoTen(date, ten);
				ArrayList<String> listtld = new ArrayList<>();
				for (BangChamCongThoLamDan bangChamCongThoLamDan : listBCC) {
					listtld.add(bangChamCongThoLamDan.getThoLamDan().getMaThoLamDan());
				}

				for (ThoLamDan thoLamDan : dao_ThoLamDan.getAlListThoLamDanTheoTen(ten)) {
					if (listtld.contains(thoLamDan.getMaThoLamDan())) {
						int position = listtld.indexOf(thoLamDan.getMaThoLamDan());
						BangPhanCong bpc = dao_BangPhanCong.getBangPhanCongTheoNgayTLDSP(
								listBCC.get(position).getNgayChamCong(),
								listBCC.get(position).getThoLamDan().getMaThoLamDan(),
								listBCC.get(position).getCongDoan().getMaCongDoan());
						Object[] objects = { listBCC.get(position).getThoLamDan().getMaThoLamDan(),
								listBCC.get(position).getThoLamDan().getCongNhanVien().getHoTen(),
								listBCC.get(position).getCongDoan().getDan().getTenSanPham(),
								listBCC.get(position).getCongDoan().getTenCongDoan(), bpc.getSoLuongSanPham(),
								listBCC.get(position).getSoLuongSanPham(), "Có mặt" };
						model_BagPhanCong.addRow(objects);
					} else {
						if (listmatld.contains(thoLamDan.getMaThoLamDan())) {
							BangPhanCong bpc1 = dao_BangPhanCong.getBangPhanCongTheoNgayTLD(date,
									thoLamDan.getMaThoLamDan());
							Object[] objects = { bpc1.getThoLamDan().getMaThoLamDan(),
									bpc1.getThoLamDan().getCongNhanVien().getHoTen(),
									bpc1.getCongDoan().getDan().getTenSanPham(), bpc1.getCongDoan().getTenCongDoan(),
									bpc1.getSoLuongSanPham(), bpc1.getSoLuongSanPham(), "Chưa ghi nhận chấm công" };
							model_BagPhanCong.addRow(objects);
						}

					}

				}
			}
			model_BagPhanCong.fireTableDataChanged();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

	}

	private void loadDataIntoTableChamCongTheoSanPham(String maSanPham) {
		model_BagPhanCong.setRowCount(0);
		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());
		try {
			ArrayList<BangChamCongThoLamDan> listBCC = dao_ChamCongThoLamDan.layDanhSachChamCongTheoSP(date, maSanPham);
			ArrayList<String> listtld = new ArrayList<>();
			for (BangChamCongThoLamDan bangChamCongThoLamDan : listBCC) {
				listtld.add(bangChamCongThoLamDan.getThoLamDan().getMaThoLamDan());
			}

			ArrayList<BangPhanCong> listBangPhanCong = dao_ChamCongThoLamDan
					.listAllBangPhanCongTheoNgayHienTaiVaSP(maSanPham);

			for (BangPhanCong bangPhanCong : listBangPhanCong) {
				if (listtld.contains(bangPhanCong.getThoLamDan().getMaThoLamDan())) {
					int position = listtld.indexOf(bangPhanCong.getThoLamDan().getMaThoLamDan());
					BangPhanCong bpc = dao_BangPhanCong.getBangPhanCongTheoNgayTLDSP(
							listBCC.get(position).getNgayChamCong(),
							listBCC.get(position).getThoLamDan().getMaThoLamDan(),
							listBCC.get(position).getCongDoan().getMaCongDoan());
					Object[] objects = { listBCC.get(position).getThoLamDan().getMaThoLamDan(),
							listBCC.get(position).getThoLamDan().getCongNhanVien().getHoTen(),
							listBCC.get(position).getCongDoan().getDan().getTenSanPham(),
							listBCC.get(position).getCongDoan().getTenCongDoan(), bpc.getSoLuongSanPham(),
							listBCC.get(position).getSoLuongSanPham(), "Có mặt" };
					model_BagPhanCong.addRow(objects);
				} else {

					Object[] objects = { bangPhanCong.getThoLamDan().getMaThoLamDan(),
							bangPhanCong.getThoLamDan().getCongNhanVien().getHoTen(),
							bangPhanCong.getCongDoan().getDan().getTenSanPham(),
							bangPhanCong.getCongDoan().getTenCongDoan(), bangPhanCong.getSoLuongSanPham(),
							bangPhanCong.getSoLuongSanPham(), "Chưa ghi nhận chấm công" };
					model_BagPhanCong.addRow(objects);

				}
			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

	}

	private void loadDataIntoTableChamCongTheoTenCongDoan(String tenCongDoan) {
		model_BagPhanCong.setRowCount(0);
		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());
		try {
			ArrayList<BangChamCongThoLamDan> listBCC = dao_ChamCongThoLamDan.layDanhSachChamCongTheoTenCongDoan(date,
					tenCongDoan);
			ArrayList<String> listtld = new ArrayList<>();
			for (BangChamCongThoLamDan bangChamCongThoLamDan : listBCC) {
				listtld.add(bangChamCongThoLamDan.getThoLamDan().getMaThoLamDan());
			}
			ArrayList<BangPhanCong> listBangPhanCong = dao_ChamCongThoLamDan
					.listAllBangPhanCongTheoNgayHienTaiVaTenCongDoan(tenCongDoan);
			for (BangPhanCong bangPhanCong : listBangPhanCong) {
				if (listtld.contains(bangPhanCong.getThoLamDan().getMaThoLamDan())) {
					int position = listtld.indexOf(bangPhanCong.getThoLamDan().getMaThoLamDan());
					BangPhanCong bpc = dao_BangPhanCong.getBangPhanCongTheoNgayTLDSP(
							listBCC.get(position).getNgayChamCong(),
							listBCC.get(position).getThoLamDan().getMaThoLamDan(),
							listBCC.get(position).getCongDoan().getMaCongDoan());
					System.out.println(listBCC.get(position).getCongDoan().getMaCongDoan());
					Object[] objects = { listBCC.get(position).getThoLamDan().getMaThoLamDan(),
							listBCC.get(position).getThoLamDan().getCongNhanVien().getHoTen(),
							listBCC.get(position).getCongDoan().getDan().getTenSanPham(),
							listBCC.get(position).getCongDoan().getTenCongDoan(), bpc.getSoLuongSanPham(),
							listBCC.get(position).getSoLuongSanPham(), "Có mặt" };
					model_BagPhanCong.addRow(objects);
				} else {

					Object[] objects = { bangPhanCong.getThoLamDan().getMaThoLamDan(),
							bangPhanCong.getThoLamDan().getCongNhanVien().getHoTen(),
							bangPhanCong.getCongDoan().getDan().getTenSanPham(),
							bangPhanCong.getCongDoan().getTenCongDoan(), bangPhanCong.getSoLuongSanPham(),
							bangPhanCong.getSoLuongSanPham(), "Chưa ghi nhận chấm công" };
					model_BagPhanCong.addRow(objects);

				}
			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

	}

	private void themBangLuong(ThoLamDan thoLamDan) {
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		int thang = currentMonth.getValue();
		int nam = currentDate.getYear();
		BangLuongThoLamDan bl = new BangLuongThoLamDan();
		bl.setNam(nam);
		bl.setThang(thang);
		bl.setThoLamDan(thoLamDan);
		String maBangLuong = dao_LuongThoLamDan.getMaBangLuong(thang, nam, thoLamDan.getMaThoLamDan());
		bl.setMaBangLuong(maBangLuong);
		bl.setSoLuongSanPham(0);
		DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();
		dao_LuongThoLamDan.themBangLuongThoLamDan(bl);
	}
}
