package GUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
import Entity.CongDoan;
import Entity.Dan;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class frm_CongDoan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaCongDoan;
	private JLabel lblCongDoan;
	private JLabel lblTenCD;
	private JLabel lblGiaCD;
	private JTextField txtGiaCongDoan;
	private JLabel lblTTCongDoan;
	private JLabel lblDSSanPham;
	private JPanel pnlDSSP;
	private JSeparator separator_1;
	private JTable tblDSCongDoan;
	private JScrollPane scrollPane_1;
	private JTable tblDSSanPham;
	private JScrollPane scrollPane;
	private DefaultTableModel modelDSSanPham;
	private DAO_Dan dan_DAO = new DAO_Dan();
	private DefaultTableModel modelDSCongDoan;
	private DAO_CongDoan congDoan_DAO = new DAO_CongDoan();

	/**
	 * Create the panel.
	 */
	public frm_CongDoan() {
		MyConnection.getInstance().MyConnection();
		setBackground(new Color(221, 242, 251));
		setLayout(null);

		lblCongDoan = new JLabel("New label");
		lblCongDoan.setBounds(550, 5, 375, 70);
		lblCongDoan.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblCongDoan);
		lblCongDoan.setText("CÔNG ĐOẠN");

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

		lblGiaCD = new JLabel("New label");
		lblGiaCD.setBounds(20, 205, 170, 25);
		panel.add(lblGiaCD);
		lblGiaCD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGiaCD.setText("Giá công đoạn");

		lblTenCD = new JLabel("New label");
		lblTenCD.setBounds(20, 135, 170, 25);
		panel.add(lblTenCD);
		lblTenCD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenCD.setText("Tên công đoạn");

		txtMaCongDoan = new JTextField();
		txtMaCongDoan.setBounds(160, 65, 250, 25);
		panel.add(txtMaCongDoan);
//		txtMaCongDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaCongDoan.setColumns(10);
		txtMaCongDoan.setEnabled(false);

		JLabel lblMaCD = new JLabel("New label");
		lblMaCD.setBounds(20, 65, 170, 25);
		panel.add(lblMaCD);
		lblMaCD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaCD.setText("Mã công đoạn");
		lblMaCD.setLabelFor(txtMaCongDoan);

		lblTTCongDoan = new JLabel("New label");
		lblTTCongDoan.setBounds(35, 15, 220, 25);
		panel.add(lblTTCongDoan);
		lblTTCongDoan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTTCongDoan.setText("Thông tin công đoạn");

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(160, 135, 250, 25);
		panel.add(comboBox);

		String[] tenCongDoan = { "Lựa chọn chất liệu gỗ", "Xử lý độ ẩm", "Chế tác mặt đàn", "Chế tác eo lưng",
				"Chế tác cần đàn", "Chế tác mặt phím", "Chế tác dây đàn", "Chế tác khóa đàn", "Chế tác cầu ngựa",
				"Cảm âm", "Thiết kế lỗ thoát âm", "Kiểm tra và điều chỉnh", "Tinh chỉnh âm thanh",
				"Hoàn thiện và làm đẹp" };
		for (String congDoan : tenCongDoan) {
			comboBox.addItem(congDoan);
		}
		comboBox.setSelectedIndex(0);
		comboBox.setEnabled(false);
		pnlDSSP = new JPanel();
		pnlDSSP.setBounds(15, 90, 900, 315);
		pnlDSSP.setBackground(Color.WHITE);
		add(pnlDSSP);
		pnlDSSP.setLayout(null);

		lblDSSanPham = new JLabel("New label");
		lblDSSanPham.setBounds(35, 15, 217, 25);
		pnlDSSP.add(lblDSSanPham);
		lblDSSanPham.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDSSanPham.setText("Danh sách sản phẩm");

		String[] cols = { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Lo\u1EA1i s\u1EA3n ph\u1EA9m",
				"Gi\u00E1 b\u00E1n" };
		modelDSSanPham = new DefaultTableModel(cols, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int cols) {
				return columnEditables[cols];
			}
		};

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 75, 860, 230);
		pnlDSSP.add(scrollPane);
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

		JPanel pnlDSCongDoan = new JPanel();
		pnlDSCongDoan.setBackground(Color.WHITE);
		pnlDSCongDoan.setBounds(15, 490, 1420, 200);
		add(pnlDSCongDoan);
		pnlDSCongDoan.setLayout(null);

		scrollPane_1 = new JScrollPane();

		scrollPane_1.setBounds(20, 10, 1380, 180);
		pnlDSCongDoan.add(scrollPane_1);

		String[] col = { "M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n",
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i S\u1EA3n Ph\u1EA9m",
				"Gi\u00E1 C\u00F4ng \u0110o\u1EA1n" };
		modelDSCongDoan = new DefaultTableModel(col, 0);

		tblDSCongDoan = new JTable(modelDSCongDoan) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = { false, false, false, false, false, false };

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
						comboBox.setSelectedItem(modelDSCongDoan.getValueAt(row, 1).toString());
						txtGiaCongDoan.setText(modelDSCongDoan.getValueAt(row, 5).toString());
					}
				}
			}
		});

		loadDataCD(congDoan_DAO.getAlListCongDoan());

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

		JLabel lblDSCD = new JLabel("New label");
		lblDSCD.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDSCD.setBounds(49, 450, 217, 25);
		add(lblDSCD);
		lblDSCD.setText("Danh sách công đoạn");

		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaCongDoan.setText("");
				txtGiaCongDoan.setText("");
				comboBox.setSelectedIndex(0);
			}
		});

		tblDSSanPham.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tblDSCongDoan.clearSelection();
				txtMaCongDoan.setText("");
				txtGiaCongDoan.setText("");
				comboBox.setSelectedIndex(0);

			}
		});

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnThem.getText().equals("Thêm")) {
					int row = tblDSSanPham.getSelectedRow();
					if (row >= 0) {
						btnThem.setText("Lưu");
						btnSua.setText("Huỷ");
						txtMaCongDoan.setText("");
						txtGiaCongDoan.setText("");
						comboBox.setSelectedIndex(0);
						tblDSCongDoan.clearSelection();
						txtGiaCongDoan.setEnabled(true);
						comboBox.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm từ danh sách sản phẩm.", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (btnThem.getText().equals("Lưu")) {
					int row = tblDSSanPham.getSelectedRow();
					if (row >= 0) {
						boolean kt = true;
						try {
							String maSanPham = modelDSSanPham.getValueAt(row, 0).toString();
							String tenCongDoan = (String) comboBox.getSelectedItem();
							String giaCongDoanStr = txtGiaCongDoan.getText();
							if (tenCongDoan.equals("") || giaCongDoanStr.equals("")) {
								kt = false;
								JOptionPane.showMessageDialog(null,
										"Tên công đoạn và giá công đoạn không được để trống.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							}
							if (congDoan_DAO.checkIfExists(tenCongDoan, maSanPham)) {
								kt = false;
								JOptionPane.showMessageDialog(null, "Công đoạn này đã tồn tại cho sản phẩm.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							}

							if (tenCongDoan.length() < 2) {
								kt = false;
								JOptionPane.showMessageDialog(null, "Tên công đoạn phải có ít nhất 2 kí tự.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							}

							float giaCongDoan = Float.parseFloat(giaCongDoanStr);
							if (giaCongDoan < 0) {
								kt = false;
								JOptionPane.showMessageDialog(null, "Giá công đoạn phải là số không âm.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Giá công đoạn phải là số.", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
						if (kt) {
							String maSanPham = modelDSSanPham.getValueAt(row, 0).toString();
							Entity.CongDoan congDoan = new Entity.CongDoan();

							Dan dan = dan_DAO.getDanTheoMaSanPham(maSanPham);
							congDoan.setDan(dan);
							congDoan.setTenCongDoan((String) comboBox.getSelectedItem());
							congDoan.setGiaCongDoan(Float.parseFloat(txtGiaCongDoan.getText()));
							congDoan_DAO.insertCongDoan(congDoan);
							JOptionPane.showMessageDialog(null, "Thêm công đoạn thành công ");
							
							modelDSCongDoan.setRowCount(0);
							loadDataCD(congDoan_DAO.getAlListCongDoan());
							modelDSCongDoan.fireTableDataChanged();
							String maCongDoan = congDoan_DAO.getMaCongDoan(maSanPham);
							CongDoan newCongDoan = congDoan_DAO.getCongDoanTheoMaCongDoan(maCongDoan);
							Object[] rowData = new Object[] { maCongDoan, newCongDoan.getTenCongDoan(),
									newCongDoan.getDan().getMaSanPham(), newCongDoan.getDan().getTenSanPham(),
									newCongDoan.getDan().getLoaiSanPham(), newCongDoan.getGiaCongDoan() };
							modelDSCongDoan.addRow(rowData);
							txtMaCongDoan.setText("");
							txtGiaCongDoan.setText("");
							comboBox.setSelectedIndex(0);
							txtGiaCongDoan.setEnabled(false);
							comboBox.setEnabled(false);
							btnThem.setText("Thêm");
							btnSua.setText("Sửa thông tin");
							tblDSSanPham.clearSelection();
							tblDSCongDoan.clearSelection();
						}

					} else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm từ danh sách sản phẩm.", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (btnThem.getText().equals("Lưu ")) {
					int rowCD = tblDSCongDoan.getSelectedRow();
					if (rowCD >= 0) {
						boolean kt = true;
						try {
							String maSanPham = modelDSCongDoan.getValueAt(rowCD, 2).toString();
							String tenCongDoan = (String) comboBox.getSelectedItem();
							String giaCongDoanStr = txtGiaCongDoan.getText();

							if (tenCongDoan.equals("") || giaCongDoanStr.equals("")) {
								kt = false;
								JOptionPane.showMessageDialog(null,
										"Tên công đoạn và giá công đoạn không được để trống.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							}
							if (congDoan_DAO.checkIfExists(tenCongDoan, maSanPham)) {
								
								kt = false;
								JOptionPane.showMessageDialog(null, "Công đoạn này đã tồn tại cho sản phẩm.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							}

							if (tenCongDoan.length() < 2) {
								kt = false;
								JOptionPane.showMessageDialog(null, "Tên công đoạn phải có ít nhất 2 kí tự.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							}
							float giaCongDoan = Float.parseFloat(giaCongDoanStr);
							if (giaCongDoan < 0) {
								kt = false;
								JOptionPane.showMessageDialog(null, "Giá công đoạn phải là số không âm.", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Giá công đoạn phải là số.", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
						if (kt) {
							String maSanPham = modelDSCongDoan.getValueAt(rowCD, 3).toString();
							Entity.CongDoan congDoan = new Entity.CongDoan();
							String maCongDoan = modelDSCongDoan.getValueAt(rowCD, 0).toString();
							Dan dan = dan_DAO.getDanTheoMaSanPham(maSanPham);
							congDoan.setDan(dan);
							congDoan.setTenCongDoan((String) comboBox.getSelectedItem());
							congDoan.setGiaCongDoan(Float.parseFloat(txtGiaCongDoan.getText()));
							congDoan.setMaCongDoan(maCongDoan);
							congDoan_DAO.updateCongDoan(congDoan);
							modelDSCongDoan.setRowCount(0);
							loadDataCD(congDoan_DAO.getAlListCongDoan());
							modelDSCongDoan.fireTableDataChanged();
							for (Entity.CongDoan congDoan1 : congDoan_DAO.getAlListCongDoan()) {
								Object[] objects = { congDoan1.getMaCongDoan(), congDoan1.getTenCongDoan(),
										congDoan1.getDan().getMaSanPham(), congDoan1.getDan().getTenSanPham(),
										congDoan1.getDan().getLoaiSanPham(), congDoan1.getGiaCongDoan() };
								modelDSCongDoan.addRow(objects);
							}
							JOptionPane.showMessageDialog(null, "Sửa công đoạn thành công ");
							modelDSCongDoan.fireTableDataChanged();
							txtMaCongDoan.setText("");
							txtGiaCongDoan.setText("");
							comboBox.setSelectedIndex(0);
							txtGiaCongDoan.setEnabled(false);
							comboBox.setEnabled(false);
							btnThem.setText("Thêm");
							btnSua.setText("Sửa thông tin");
							tblDSSanPham.clearSelection();
							tblDSCongDoan.clearSelection();
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
						btnThem.setText("Lưu ");
						btnSua.setText("Huỷ");
						txtGiaCongDoan.setEnabled(true);
						comboBox.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn công đoạn cần sửa từ bảng.", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (btnSua.getText().equals("Huỷ")) {
					btnSua.setText("Sửa thông tin");
					btnThem.setText("Thêm");
					txtGiaCongDoan.setEnabled(false);
					comboBox.setEnabled(false);
					txtGiaCongDoan.setText("");
					comboBox.setSelectedIndex(0);
					txtMaCongDoan.setText("");
					tblDSCongDoan.clearSelection();
					tblDSSanPham.clearSelection();
				}
			}

		});

	};

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
