package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import Connection.MyConnection;
import DAO.DAO_BangPhanCong;
import DAO.DAO_CongDoan;
import DAO.DAO_ThoLamDan;
import Entity.CongDoan;
import Entity.Dan;
import Entity.ThoLamDan;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class frm_PhanCong extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tblDSCD;
	private JTable tblDSTLD;
	private JDateChooser ngayPhanCong;

	private JTextField txtSoLuongSanPham;
	private DefaultTableModel modelDSCD;
	private DAO_CongDoan congDoan_DAO;
	private DefaultTableModel modelDSTLD;
	private DAO_ThoLamDan thoLamDan_DAO;
	private DefaultTableModel modelDSPC;
	private DAO_BangPhanCong bangPhanCong_DAO;
	private JTable tblDSPC;
	private JTextField txtTenCongDoan;
	private JTextField txtTenThoLamDan;
	private JTextField txtMaThoLamDan;
	private int selectedRowInDSCD = -1;
	private int selectedRowInDSTLD = -1;

	/**
	 * Create the panel.
	 */
	public frm_PhanCong() {
		MyConnection.getInstance().MyConnection();
		congDoan_DAO = new DAO_CongDoan();
		thoLamDan_DAO = new DAO_ThoLamDan();
		bangPhanCong_DAO = new DAO_BangPhanCong();

		setBackground(new Color(221, 242, 251));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(550, 5, 375, 70);
		add(lblNewLabel);
		lblNewLabel.setText("BẢNG PHÂN CÔNG");

		JPanel pnlThongTinCongDoan = new JPanel();
		pnlThongTinCongDoan.setBounds(990, 90, 450, 315);
		pnlThongTinCongDoan.setBackground(Color.WHITE);
		add(pnlThongTinCongDoan);
		pnlThongTinCongDoan.setLayout(null);

		JButton btnPhanCong = new JButton("Phân công");
		btnPhanCong.setBounds(30, 265, 150, 40);
		pnlThongTinCongDoan.add(btnPhanCong);
		btnPhanCong.setForeground(Color.WHITE);
		btnPhanCong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPhanCong.setBackground(new Color(2, 104, 156));

		JButton btnXoaRong = new JButton("New button");
		btnXoaRong.setBounds(250, 265, 150, 40);
		pnlThongTinCongDoan.add(btnXoaRong);
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setBackground(new Color(2, 104, 156));
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaRong.setText("Xoá rỗng");

		ngayPhanCong = new JDateChooser();
		ngayPhanCong.setBounds(200, 225, 200, 25);
		ngayPhanCong.setDateFormatString("dd-MM-yyyy");
		try {
			Date date = Date.valueOf(LocalDate.now());
			ngayPhanCong.setDate(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ngayPhanCong.setEnabled(false);
		pnlThongTinCongDoan.add(ngayPhanCong);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(20, 225, 170, 25);
		pnlThongTinCongDoan.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setText("Ngày phân công");

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(20, 65, 170, 25);
		pnlThongTinCongDoan.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setText("Mã thợ làm đàn\r\n");

		txtSoLuongSanPham = new JTextField();
		txtSoLuongSanPham.setBounds(200, 185, 200, 25);
		pnlThongTinCongDoan.add(txtSoLuongSanPham);
		txtSoLuongSanPham.setColumns(10);
		lblNewLabel_2.setLabelFor(txtSoLuongSanPham);
		txtSoLuongSanPham.setEnabled(false);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(35, 15, 220, 25);
		pnlThongTinCongDoan.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setText("Thông tin phân công");

		JLabel lblNewLabel_2_1 = new JLabel("Số lượng sản phẩm\r\n");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(20, 185, 170, 25);
		pnlThongTinCongDoan.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Tên thợ làm đàn");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(20, 105, 170, 25);
		pnlThongTinCongDoan.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("Tên công đoạn\r\n");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_2.setBounds(20, 145, 170, 25);
		pnlThongTinCongDoan.add(lblNewLabel_2_1_2);

		txtTenCongDoan = new JTextField();
		txtTenCongDoan.setEnabled(false);
		txtTenCongDoan.setText("");
		txtTenCongDoan.setColumns(10);
		txtTenCongDoan.setBounds(200, 145, 200, 25);
		pnlThongTinCongDoan.add(txtTenCongDoan);

		txtTenThoLamDan = new JTextField();
		txtTenThoLamDan.setEnabled(false);
		txtTenThoLamDan.setText("");
		txtTenThoLamDan.setColumns(10);
		txtTenThoLamDan.setBounds(200, 105, 200, 25);
		pnlThongTinCongDoan.add(txtTenThoLamDan);

		txtMaThoLamDan = new JTextField();
		txtMaThoLamDan.setEnabled(false);
		txtMaThoLamDan.setText("");
		txtMaThoLamDan.setColumns(10);
		txtMaThoLamDan.setBounds(200, 65, 200, 25);
		pnlThongTinCongDoan.add(txtMaThoLamDan);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(500, 90, 450, 315);
		panel_1.setBackground(Color.WHITE);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(35, 15, 249, 25);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setText("Danh sách thợ làm đàn\r\n");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 65, 410, 230);
		panel_1.add(scrollPane);

		String[] cols = { "M\u00E3 Th\u1EE3 L\u00E0m \u0110\u00E0n", "T\u00EAn Th\u1EE3 L\u00E0m \u0110\u00E0n" };
		modelDSTLD = new DefaultTableModel(cols, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = { false, false };

			public boolean isCellEditable(int row, int cols) {
				return columnEditables[cols];
			}
		};
		tblDSTLD = new JTable(modelDSTLD);

		TableColumnModel columnModel = tblDSTLD.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tblDSTLD.getTableHeader().setReorderingAllowed(false);

		loadDataTLD(DAO_ThoLamDan.getAlListThoLamDan());

		scrollPane.setViewportView(tblDSTLD);
		JTableHeader tb = tblDSTLD.getTableHeader();
		tb.setBackground(new Color(221, 242, 251));
		tb.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		tblDSTLD.setRowHeight(rowHeight);
		tblDSTLD.setIntercellSpacing(new Dimension(0, rowMargin));

		ListSelectionModel listSelectionModel = tblDSTLD.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(15, 430, 1420, 3);
		add(separator_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(15, 490, 1420, 200);
		add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 10, 1380, 180);
		panel_2.add(scrollPane_1);

		String[] col = { "M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n",
				"M\u00E3 Th\u1EE3 L\u00E0m \u0110\u00E0n", "T\u00EAn Th\u1EE3 L\u00E0m \u0110\u00E0n",
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m" };
		modelDSPC = new DefaultTableModel(col, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int col) {
				return columnEditables[col];
			}
		};
		tblDSPC = new JTable(modelDSPC);

		TableColumnModel columnModel2 = tblDSPC.getColumnModel();
		columnModel2.setColumnSelectionAllowed(false);
		columnModel2.setColumnMargin(0);
		tblDSPC.getTableHeader().setReorderingAllowed(false);

		loadDataPC(DAO_BangPhanCong.getBangPhanCongTheoNgayPhanCong(ngayPhanCong));

		scrollPane_1.setViewportView(tblDSPC);
		JTableHeader tb1 = tblDSPC.getTableHeader();
		tb1.setBackground(new Color(221, 242, 251));
		tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		tblDSPC.setRowHeight(rowHeight);
		tblDSPC.setIntercellSpacing(new Dimension(0, rowMargin));

		ListSelectionModel listSelectionModel2 = tblDSPC.getSelectionModel();
		listSelectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(49, 450, 217, 25);
		add(lblNewLabel_6);
		lblNewLabel_6.setText("Danh sách phân công\r\n");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(15, 90, 450, 315);
		add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 60, 410, 230);
		panel_3.add(scrollPane_2);

		String[] column = { "M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n" };
		modelDSCD = new DefaultTableModel(column, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tblDSCD = new JTable(modelDSCD);

		TableColumnModel columnModel1 = tblDSCD.getColumnModel();
		columnModel1.setColumnSelectionAllowed(false);
		columnModel1.setColumnMargin(0);
		tblDSCD.getTableHeader().setReorderingAllowed(false);

		loadDataCD(DAO_CongDoan.getAlListCongDoan());

		scrollPane_2.setViewportView(tblDSCD);
		JTableHeader tb2 = tblDSCD.getTableHeader();
		tb2.setBackground(new Color(221, 242, 251));
		tb2.setFont(new Font("Tahoma", Font.BOLD, 16));
		tblDSCD.setRowHeight(rowHeight);
		tblDSCD.setIntercellSpacing(new Dimension(0, rowMargin));

		ListSelectionModel listSelectionModel1 = tblDSCD.getSelectionModel();
		listSelectionModel1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblNewLabel_5_1 = new JLabel("Danh sách công đoạn");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(35, 15, 217, 25);
		panel_3.add(lblNewLabel_5_1);

		JLabel lblNewLabel_3_1 = new JLabel("Ngày phân công");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(1055, 443, 170, 25);
		add(lblNewLabel_3_1);

		JDateChooser ngayPhanCong_1 = new JDateChooser();
		ngayPhanCong_1.setEnabled(false);
		ngayPhanCong_1.setDateFormatString("dd-MM-yyyy");
		ngayPhanCong_1.setBounds(1235, 443, 200, 25);
		try {
			Date date = Date.valueOf(LocalDate.now());
			ngayPhanCong_1.setDate(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(ngayPhanCong_1);

		tblDSCD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRowInDSCD = tblDSCD.getSelectedRow();
				if (selectedRowInDSCD >= 0) {
					txtTenCongDoan.setText(modelDSCD.getValueAt(selectedRowInDSCD, 1).toString());
				}
			}
		});

		tblDSTLD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRowInDSTLD = tblDSTLD.getSelectedRow();
				if (selectedRowInDSTLD >= 0) {
					txtMaThoLamDan.setText(modelDSTLD.getValueAt(selectedRowInDSTLD, 0).toString());
					txtTenThoLamDan.setText(modelDSTLD.getValueAt(selectedRowInDSTLD, 1).toString());

				}
			}
		});

		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnXoaRong.getText().equals("Xoá rỗng")) {
					txtMaThoLamDan.setText("");
					txtTenThoLamDan.setText("");
					txtTenThoLamDan.setText("");
					txtSoLuongSanPham.setText("");
					txtTenCongDoan.setText("");
					tblDSCD.clearSelection();
					tblDSTLD.clearSelection();
				} else {
					btnPhanCong.setText("Phân công");
					btnXoaRong.setText("Xoá rỗng");
					txtMaThoLamDan.setText("");
					txtTenCongDoan.setText("");
					txtTenThoLamDan.setText("");
					txtSoLuongSanPham.setText("");
					tblDSCD.clearSelection();
					tblDSTLD.clearSelection();
				}

			}
		});

		btnPhanCong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnPhanCong.getText().equals("Phân công")) {
					btnPhanCong.setText("Lưu");
					btnXoaRong.setText("Huỷ");
					txtSoLuongSanPham.setEnabled(true);
				} else {
					if (selectedRowInDSCD >= 0 && selectedRowInDSTLD >= 0) {

						try {
							String soLuongSanPhamString = txtSoLuongSanPham.getText().trim();
							int soLuongSanPham = Integer.parseInt(soLuongSanPhamString);
							if (soLuongSanPham < 50) {
								JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải lớn hơn 50.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							} else {

								boolean duplicate = false;

								for (int i = 0; i < modelDSPC.getRowCount(); i++) {
									String maThoLamDanInTable = modelDSPC.getValueAt(i, 3).toString();

									for (int a = 0; i < modelDSPC.getRowCount(); a++) {
										String maThoLamDanString = modelDSTLD.getValueAt(tblDSTLD.getSelectedRow(), 1)
												.toString();

										if (maThoLamDanString.equals(maThoLamDanInTable)) {
											duplicate = true;
											break;
										}

									}
								}
								if (duplicate) {
									JOptionPane.showMessageDialog(null, "Thợ làm đàn này đã được phân công", "Lỗi",
											JOptionPane.ERROR_MESSAGE);
								} else {
									Entity.BangPhanCong bangPhanCong = new Entity.BangPhanCong();
									CongDoan congDoan = congDoan_DAO.getCongDoanTheoMaCongDoan(
											modelDSCD.getValueAt(selectedRowInDSCD, 0).toString());
									bangPhanCong.setCongDoan(congDoan);
									ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(
											modelDSTLD.getValueAt(selectedRowInDSTLD, 0).toString());
									bangPhanCong.setThoLamDan(thoLamDan);
									bangPhanCong.setSoLuongSanPham(soLuongSanPham);
									Date date = Date.valueOf(LocalDate.now());
									bangPhanCong.setNgayPhanCong(date);
									bangPhanCong_DAO.insertBangPhanCong(bangPhanCong);
									bangPhanCong_DAO.getBangPhanCongMoiTao();
									Entity.BangPhanCong newBangPhanCong = bangPhanCong_DAO.getBangPhanCongMoiTao();
									Object[] rowData = new Object[] { newBangPhanCong.getCongDoan().getMaCongDoan(),
											newBangPhanCong.getCongDoan().getTenCongDoan(),
											newBangPhanCong.getThoLamDan().getMaThoLamDan(),
											newBangPhanCong.getThoLamDan().getCongNhanVien().getHoTen(),
											newBangPhanCong.getCongDoan().getDan().getMaSanPham(),
											newBangPhanCong.getCongDoan().getDan().getTenSanPham(),
											newBangPhanCong.getNgayPhanCong() };
									modelDSPC.addRow(rowData);
								}

								txtSoLuongSanPham.setText("");
								txtSoLuongSanPham.setEnabled(false);
								txtMaThoLamDan.setText("");
								txtTenThoLamDan.setText("");
								txtTenCongDoan.setText("");
								txtSoLuongSanPham.setText("");
								tblDSCD.clearSelection();
								tblDSTLD.clearSelection();
								btnPhanCong.setText("Phân công");
								btnXoaRong.setText("Xoá rỗng");
							}
						} catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Số lượng sản phẩm nhập vào phải là số.", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn công đoạn và thợ làm đàn từ danh sách.",
								"Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

	}

	private void loadDataCD(ArrayList<Entity.CongDoan> dsCD) {
		modelDSCD.setRowCount(0);
		for (Entity.CongDoan congDoan : dsCD) {
			Object[] objects = { congDoan.getMaCongDoan(), congDoan.getTenCongDoan() };
			modelDSCD.addRow(objects);
		}

	}

	private void loadDataTLD(ArrayList<Entity.ThoLamDan> dsTLD) {
		modelDSTLD.setRowCount(0);
		for (Entity.ThoLamDan thoLamDan : dsTLD) {
			Object[] objects = { thoLamDan.getMaThoLamDan(), thoLamDan.getCongNhanVien().getHoTen() };
			modelDSTLD.addRow(objects);
		}
	}

	private void loadDataPC(ArrayList<Entity.BangPhanCong> dsPC) {
		modelDSPC.setRowCount(0);
		for (Entity.BangPhanCong bangPhanCong : dsPC) {
			Object[] objects = { bangPhanCong.getCongDoan().getMaCongDoan(),
					bangPhanCong.getCongDoan().getTenCongDoan(), bangPhanCong.getThoLamDan().getMaThoLamDan(),
					bangPhanCong.getThoLamDan().getCongNhanVien().getHoTen(),
					bangPhanCong.getCongDoan().getDan().getMaSanPham(),
					bangPhanCong.getCongDoan().getDan().getTenSanPham(), bangPhanCong.getNgayPhanCong() };
			modelDSPC.addRow(objects);
		}
	}
}