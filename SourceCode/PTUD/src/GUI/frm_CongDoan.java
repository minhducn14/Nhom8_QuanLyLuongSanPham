package GUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import Connection.MyConnection;
import DAO.DAO_CongDoan;
import DAO.DAO_Dan;
import Entity.Dan;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class frm_CongDoan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaCongDoan;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtTenCongDoan;
	private JLabel lblNewLabel_3;
	private JTextField txtGiaCongDoan;
	private JLabel lblNewLabel_4;
	private JLabel lblDSSanPham;
	private JPanel panel_1;
	private JSeparator separator_1;
	private JTable tblDSCongDoan;
	private JScrollPane scrollPane_1;
	private JTable tblDSSanPham;
	private JScrollPane scrollPane;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoaRong;
	private DefaultTableModel modelDSSanPham;
	private DAO_Dan dan_DAO = new DAO_Dan();
	private DefaultTableModel modelDSCongDoan;
	private DAO_CongDoan congDoan_DAO = new DAO_CongDoan();
	private int editedRow = -1;

	/**
	 * Create the panel.
	 */
	public frm_CongDoan() {
		MyConnection.getInstance().MyConnection();
		setBackground(new Color(221, 242, 251));
		setLayout(null);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(550, 5, 375, 70);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblNewLabel_1);
		lblNewLabel_1.setText("CÔNG ĐOẠN");

		JPanel panel = new JPanel();
		panel.setBounds(975, 90, 460, 315);
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);

		JButton btnThem = new JButton("New button");
		btnThem.setBounds(20, 260, 120, 30);
		panel.add(btnThem);
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBackground(new Color(2, 104, 156));
		btnThem.setText("Thêm");

		JButton btnSua = new JButton("New button");
		btnSua.setBounds(160, 260, 120, 30);
		panel.add(btnSua);
		btnSua.setBackground(new Color(2, 104, 156));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setText("Sửa thông tin");

		JButton btnXoaRong = new JButton("New button");
		btnXoaRong.setBounds(295, 260, 120, 30);
		panel.add(btnXoaRong);
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setBackground(new Color(2, 104, 156));
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaRong.setText("Xoá rỗng");

		txtGiaCongDoan = new JTextField();
		txtGiaCongDoan.setBounds(160, 207, 250, 25);
		panel.add(txtGiaCongDoan);
		txtGiaCongDoan.setColumns(10);
		txtGiaCongDoan.setEnabled(false);

		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(20, 205, 170, 25);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setText("Giá công đoạn");

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(20, 135, 170, 25);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setText("Tên công đoạn");

		txtTenCongDoan = new JTextField();
		txtTenCongDoan.setBounds(160, 135, 250, 25);
		panel.add(txtTenCongDoan);
		txtTenCongDoan.setColumns(10);
		lblNewLabel_2.setLabelFor(txtTenCongDoan);
		txtTenCongDoan.setEnabled(false);

		txtMaCongDoan = new JTextField();
		txtMaCongDoan.setBounds(160, 65, 250, 25);
		panel.add(txtMaCongDoan);
		txtMaCongDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaCongDoan.setColumns(10);
		txtMaCongDoan.setEnabled(false);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(20, 65, 170, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setText("Mã công đoạn");
		lblNewLabel.setLabelFor(txtMaCongDoan);

		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(35, 15, 220, 25);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setText("Thông tin công đoạn");

		panel_1 = new JPanel();
		panel_1.setBounds(15, 90, 900, 315);
		panel_1.setBackground(Color.WHITE);
		add(panel_1);
		panel_1.setLayout(null);

		lblDSSanPham = new JLabel("New label");
		lblDSSanPham.setBounds(35, 15, 217, 25);
		panel_1.add(lblDSSanPham);
		lblDSSanPham.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDSSanPham.setText("Danh sách sản phẩm");


		String[] cols = { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Lo\u1EA1i s\u1EA3n ph\u1EA9m",
				"Gi\u00E1 b\u00E1n" };
		modelDSSanPham = new DefaultTableModel(cols, 0) {
			boolean[] columnEditables = {false, false, false, false, false, false};
			
			public boolean isCellEditable(int row, int cols) {
				return columnEditables[cols];
			}
		};

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 75, 860, 230);
		panel_1.add(scrollPane);
		int rowHeight = 30;
		int rowMargin = 10;
		tblDSSanPham = new JTable(modelDSSanPham);
		
		TableColumnModel columnModel = tblDSSanPham.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tblDSSanPham.getTableHeader().setReorderingAllowed(false);

		
		loadDataSP(dan_DAO.getAlListDan());

		ListSelectionModel listSelectionModel = tblDSSanPham.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(tblDSSanPham);
		JTableHeader tb = tblDSSanPham.getTableHeader();
		tb.setBackground(new Color(221, 242, 251));
		tb.setFont(new Font("Tahoma", Font.BOLD, 16));
		tblDSSanPham.setRowHeight(rowHeight);
		tblDSSanPham.setIntercellSpacing(new Dimension(0, rowMargin));

		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(15, 430, 1420, 3);
		add(separator_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(15, 490, 1420, 200);
		add(panel_2);
		panel_2.setLayout(null);

		scrollPane_1 = new JScrollPane();

		scrollPane_1.setBounds(20, 10, 1380, 180);
		panel_2.add(scrollPane_1);

		String[] col = { "M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n",
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i S\u1EA3n Ph\u1EA9m",
				"Gi\u00E1 C\u00F4ng \u0110o\u1EA1n" };
		modelDSCongDoan = new DefaultTableModel(col, 0);
		


		tblDSCongDoan = new JTable(modelDSCongDoan) {
			boolean[] columnEditables = {false, false, false, false, false, false};
			
			public boolean isCellEditable(int row, int col) {
				return columnEditables[col];
			}
		};
		tblDSCongDoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int row = tblDSCongDoan.getSelectedRow();
					if (row >= 0) {
						txtMaCongDoan.setText(modelDSCongDoan.getValueAt(row, 0).toString());
						txtTenCongDoan.setText(modelDSCongDoan.getValueAt(row, 1).toString());
						txtGiaCongDoan.setText(modelDSCongDoan.getValueAt(row, 5).toString());
					}
				}
			}
		});

		loadDataCD(DAO_CongDoan.getAlListCongDoan());

		ListSelectionModel listSelectionModel1 = tblDSCongDoan.getSelectionModel();
		listSelectionModel1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TableColumnModel columnModel1 = tblDSCongDoan.getColumnModel();
		columnModel1.setColumnSelectionAllowed(false);
		columnModel1.setColumnMargin(0);
		tblDSCongDoan.getTableHeader().setReorderingAllowed(false);

		scrollPane_1.setViewportView(tblDSCongDoan);
		JTableHeader tb1 = tblDSCongDoan.getTableHeader();
		tb1.setBackground(new Color(221, 242, 251));
		tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		tblDSCongDoan.setRowHeight(rowHeight);
		tblDSCongDoan.setIntercellSpacing(new Dimension(0, rowMargin));

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(49, 450, 217, 25);
		add(lblNewLabel_6);
		lblNewLabel_6.setText("Danh sách công đoạn");

		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaCongDoan.setText("");
				txtGiaCongDoan.setText("");
				txtTenCongDoan.setText("");
			}
		});

		tblDSSanPham.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}
		});

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnThem.getText().equals("Thêm")) {
					btnThem.setText("Lưu");
					btnSua.setText("Huỷ");
					txtGiaCongDoan.setEnabled(true);
					txtTenCongDoan.setEnabled(true);
				} else {
					editedRow = tblDSCongDoan.getSelectedRow();
					if (editedRow >= 0) {
						modelDSCongDoan.setValueAt(txtTenCongDoan.getText(), editedRow, 1);
						editedRow = -1;
						txtMaCongDoan.setText("");
						txtGiaCongDoan.setText("");
						txtTenCongDoan.setText("");
						txtGiaCongDoan.setEnabled(false);
						txtTenCongDoan.setEnabled(false);
						btnThem.setText("Thêm");
						btnSua.setText("Sửa thông tin");
					} else {
						editedRow = -1;
						try {
							String tenCongDoan = txtTenCongDoan.getText();
							String giaCongDoanStr = txtGiaCongDoan.getText();

							if (tenCongDoan.equals("") || giaCongDoanStr.equals("")) {
								JOptionPane.showMessageDialog(null,
										"Tên công đoạn và giá công đoạn không được để trống.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							} else if (tenCongDoan.length() < 2) {
								JOptionPane.showMessageDialog(null, "Tên công đoạn phải có ít nhất 2 kí tự.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							} else {
								float giaCongDoan = Float.parseFloat(giaCongDoanStr);
								if (giaCongDoan < 0) {
									JOptionPane.showMessageDialog(null, "Giá công đoạn phải là số không âm.", "Lỗi",
											JOptionPane.ERROR_MESSAGE);
								} else {
									boolean duplicate = false;

									for (int i = 0; i < modelDSCongDoan.getRowCount(); i++) {
										String tenCongDoanInTable = modelDSCongDoan.getValueAt(i, 1).toString();

										if (tenCongDoan.equals(tenCongDoanInTable)) {
											duplicate = true;
											break;
										}
									}

									if (duplicate) {
										JOptionPane.showMessageDialog(null, " Công đoạn đã tồn tại.", "Lỗi",
												JOptionPane.ERROR_MESSAGE);
									} else {
										int row = tblDSSanPham.getSelectedRow();
										if (row >= 0) {
											String maSanPham = modelDSSanPham.getValueAt(row, 0).toString();
											Entity.CongDoan congDoan = new Entity.CongDoan();

											Dan dan = dan_DAO.getDanTheoMaSanPham(maSanPham);
											congDoan.setDan(dan);
											congDoan.setTenCongDoan(txtTenCongDoan.getText());
											congDoan.setGiaCongDoan(Float.parseFloat(txtGiaCongDoan.getText()));
											System.out.println(congDoan_DAO.insertCongDoan(congDoan));

											Entity.CongDoan newCongDoan = congDoan_DAO.getCongDoanMoiTao();
											System.out.println(newCongDoan);
											Object[] rowData = new Object[] { newCongDoan.getMaCongDoan(),
													newCongDoan.getTenCongDoan(), newCongDoan.getDan().getMaSanPham(),
													newCongDoan.getDan().getTenSanPham(),
													newCongDoan.getDan().getLoaiSanPham(),
													newCongDoan.getGiaCongDoan() };
											modelDSCongDoan.addRow(rowData);
											txtMaCongDoan.setText("");
											txtGiaCongDoan.setText("");
											txtTenCongDoan.setText("");
											txtGiaCongDoan.setEnabled(false);
											txtTenCongDoan.setEnabled(false);
											tblDSSanPham.clearSelection();
											btnThem.setText("Thêm");
											btnSua.setText("Sửa thông tin");
										} else {
											JOptionPane.showMessageDialog(null,
													"Vui lòng chọn sản phẩm từ danh sách sản phẩm.", "Lỗi",
													JOptionPane.ERROR_MESSAGE);
										}
									}
								}
							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Giá công đoạn phải là số.", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					}

				}
			}
		});
		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnSua.getText().equals("Sửa thông tin")) {
					int selectedRow = tblDSCongDoan.getSelectedRow();
					if (selectedRow >= 0) {
						btnThem.setText("Lưu");
						btnSua.setText("Huỷ");
						txtGiaCongDoan.setEnabled(true);
						txtTenCongDoan.setEnabled(true);
						editedRow = selectedRow;
					} else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn công đoạn cần sửa từ bảng.", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (btnSua.getText().equals("Huỷ")) {
					btnSua.setText("Sửa thông tin");
					btnThem.setText("Thêm");
					txtGiaCongDoan.setEnabled(false);
					txtTenCongDoan.setEnabled(false);
					txtGiaCongDoan.setText("");
					txtTenCongDoan.setText("");
					txtMaCongDoan.setText("");
					tblDSCongDoan.clearSelection();
					tblDSSanPham.clearSelection();
				}
			}
		});

		// TODO Auto-generated method stub

	};

	protected static Object getTenCongDoan() {
		// TODO Auto-generated method stub
		return null;
	}

	protected static Object getMaCongDoan() {
		// TODO Auto-generated method stub
		return null;
	}

	private void loadDataCD(ArrayList<Entity.CongDoan> dsCD) {
		modelDSCongDoan.setRowCount(0);
		for (Entity.CongDoan congDoan : dsCD) {
			Object[] objects = { congDoan.getMaCongDoan(), congDoan.getTenCongDoan(), congDoan.getDan().getMaSanPham(),
					congDoan.getDan().getTenSanPham(), congDoan.getDan().getLoaiSanPham(), congDoan.getGiaCongDoan() };
			modelDSCongDoan.addRow(objects);
		}

	}

	private void loadDataSP(ArrayList<Dan> dsSanPham) {
		modelDSSanPham.setRowCount(0);
		for (Dan dan : dsSanPham) {
			Object[] objects = { dan.getMaSanPham(), dan.getTenSanPham(), dan.getLoaiSanPham(), dan.getGiaBan() };
			modelDSSanPham.addRow(objects);
		}
	}

}
