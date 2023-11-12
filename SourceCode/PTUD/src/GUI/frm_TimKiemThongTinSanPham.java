package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
//import javax.naming.directory.SearchResult;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import Connection.MyConnection;
import DAO.DAO_Dan;
import Entity.Dan;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class frm_TimKiemThongTinSanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTenSP;
	private JComboBox<String> cmbLoaiSP;
	private JComboBox<String> cmbTrangThai;
	private JComboBox<String> cmbGiaBan;
	private DAO_Dan dan_DAO = new DAO_Dan();
	private DefaultTableModel modelKQTK;
	private JTable tblKQTK;
	private ButtonGroup group = new ButtonGroup();
	private JRadioButton rdbtnTenSanPham;
	private JRadioButton rdbtnTrangThai;
	private JRadioButton rdbtnLoaiSanPham;
	private JRadioButton rdbtnGiaBan;
	private List<Dan> danList = new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public frm_TimKiemThongTinSanPham() {

		MyConnection.getInstance().MyConnection();
		setLayout(null);
		setBackground(new Color(221, 242, 251));

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(400, 5, 680, 70);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblNewLabel);
		lblNewLabel.setText("TÌM KIẾM THÔNG TIN SẢN PHẨM");

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

		String[] col = { "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i S\u1EA3n Ph\u1EA9m",
				"T\u00ECnh tr\u1EA1ng", "Gi\u00E1 B\u00E1n" };
		modelKQTK = new DefaultTableModel(col, 0) {
			boolean[] columnEditables = { false, false, false, false, false };

			public boolean isCellEditable(int row, int col) {
				return columnEditables[col];
			}
		};

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 10, 1380, 180);
		panel_2.add(scrollPane_1);
		int rowHeight1 = 30;
		int rowMargin1 = 10;
		tblKQTK = new JTable(modelKQTK);

		TableColumnModel columnModel = tblKQTK.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tblKQTK.getTableHeader().setReorderingAllowed(false);

		ListSelectionModel listSelectionModel = tblKQTK.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane_1.setViewportView(tblKQTK);
		JTableHeader tb1 = tblKQTK.getTableHeader();
		tb1.setBackground(new Color(221, 242, 251));
		tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		tblKQTK.setRowHeight(rowHeight1);
		tblKQTK.setIntercellSpacing(new Dimension(0, rowMargin1));

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(50, 450, 217, 25);
		add(lblNewLabel_6);
		lblNewLabel_6.setText("Kết quả tìm kiếm\r\n");

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(15, 90, 1420, 315);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_6_1 = new JLabel("Tìm kiếm sản phẩm theo :");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6_1.setBounds(35, 15, 304, 25);
		panel.add(lblNewLabel_6_1);

		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(100, 65, 170, 25);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Loại sản phẩm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(100, 165, 130, 25);
		panel.add(lblNewLabel_1_1);

		txtTenSP = new JTextField();
		txtTenSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTenSP.setEnabled(true);
			}
		});
		txtTenSP.setEnabled(false);
		lblNewLabel_1.setLabelFor(txtTenSP);
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(240, 65, 250, 25);
		panel.add(txtTenSP);

		JLabel lblNewLabel_1_1_1 = new JLabel("Giá bán");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(900, 165, 170, 25);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Trạng thái\r\n");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(900, 65, 170, 25);
		panel.add(lblNewLabel_1_1_1_1);

		JButton btnTimKiem = new JButton("Tìm kiếm");

		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKiem.setBackground(new Color(2, 104, 156));
		btnTimKiem.setBounds(500, 225, 170, 50);
		panel.add(btnTimKiem);

		JButton btnXoaRong = new JButton("Xoá rỗng");
		btnXoaRong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnXoaRong.getText().equals("Xoá rỗng")) {
					txtTenSP.setText("");
				} else {
					txtTenSP.setText("");
					btnXoaRong.setText("Xoá rỗng");
				}
			}
		});
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaRong.setBackground(new Color(2, 104, 156));
		btnXoaRong.setBounds(800, 225, 170, 50);
		panel.add(btnXoaRong);

		rdbtnTenSanPham = new JRadioButton("");
		rdbtnTenSanPham.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					txtTenSP.setEnabled(true);
					btnXoaRong.setText("Xoá rỗng");
				} else {
					txtTenSP.setEnabled(false);
				}

			}
		});
		rdbtnTenSanPham.setBackground(Color.WHITE);
		rdbtnTenSanPham.setBounds(60, 65, 27, 21);
		panel.add(rdbtnTenSanPham);

		String[] loaiSP = { "Classic", "Acoustic", "Phím lõm", "Cao cấp" };
		cmbLoaiSP = new JComboBox<>(loaiSP);
		cmbLoaiSP.setSelectedIndex(0);
		cmbLoaiSP.setEnabled(false);
		cmbLoaiSP.setBackground(Color.WHITE);
		cmbLoaiSP.setBounds(240, 165, 250, 25);
		panel.add(cmbLoaiSP);

		rdbtnLoaiSanPham = new JRadioButton("");
		rdbtnLoaiSanPham.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cmbLoaiSP.setEnabled(true);
					btnXoaRong.setText("Xoá rỗng");
				} else {
					cmbLoaiSP.setEnabled(false);
				}

			}
		});
		rdbtnLoaiSanPham.setBackground(Color.WHITE);
		rdbtnLoaiSanPham.setBounds(60, 165, 27, 21);
		panel.add(rdbtnLoaiSanPham);

		String[] giaBan = { "500.000 - 1.000.000", "1.000.000 - 2.000.000", "2.000.000 - 3.000.000",
				"3.000.000 - 4.000.000", "4.000.000 - 5.000.000", "5.000.000 - 6.000.000" };
		cmbGiaBan = new JComboBox<>(giaBan);
		cmbGiaBan.setSelectedIndex(0);
		cmbGiaBan.setEnabled(false);
		cmbGiaBan.setBackground(Color.WHITE);
		cmbGiaBan.setBounds(1060, 169, 250, 25);
		panel.add(cmbGiaBan);

		rdbtnGiaBan = new JRadioButton("");
		rdbtnGiaBan.setBackground(Color.WHITE);
		rdbtnGiaBan.setBounds(868, 165, 27, 21);
		panel.add(rdbtnGiaBan);

		rdbtnGiaBan.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cmbGiaBan.setEnabled(true);
					btnXoaRong.setText("Xoá rỗng");
				} else {
					cmbGiaBan.setEnabled(false);
				}

			}
		});

		rdbtnTrangThai = new JRadioButton("");

		rdbtnTrangThai.setBackground(Color.WHITE);
		rdbtnTrangThai.setBounds(867, 65, 27, 21);
		panel.add(rdbtnTrangThai);

		String[] tinhTrang = { "Đang bán", "Ngưng phục vụ" };
		cmbTrangThai = new JComboBox<>(tinhTrang);
		cmbTrangThai.setSelectedIndex(0);
		cmbTrangThai.setEnabled(false);
		cmbTrangThai.setBackground(Color.WHITE);
		cmbTrangThai.setBounds(1060, 65, 250, 25);
		panel.add(cmbTrangThai);

		rdbtnTrangThai.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					cmbTrangThai.setEnabled(true);
					btnXoaRong.setText("Xoá rỗng");

				} else {
					cmbTrangThai.setEnabled(false);
				}

			}
		});

		btnTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println();
				searchDan();

			}
		});

		group.add(rdbtnTrangThai);
		group.add(rdbtnGiaBan);
		group.add(rdbtnLoaiSanPham);
		group.add(rdbtnTenSanPham);
	}

//

//	private void search() {
//
//		String tenSP = txtTenSP.getText();
//		String loaiSP = (String) cmbLoaiSP.getSelectedItem();
//		String giaBan = (String)cmbGiaBan.getSelectedItem();
//		String trangThai = (String)cmbTrangThai.getSelectedItem();
//		List<Dan> searchResults = searchDan();
//		displaySearchResult(searchResults);
//	}

	private void searchDan() {

		if (rdbtnTenSanPham.isSelected()) {
			String tenSP = txtTenSP.getText();
		} else if (rdbtnLoaiSanPham.isSelected()) {
			String loaiSP = (String) cmbLoaiSP.getSelectedItem();
			danList = dan_DAO.searchDanTheoLoaiSP(loaiSP);
			modelKQTK.setRowCount(0);

			for (Dan dan : danList) {
				Object[] rowData = { dan.getMaSanPham(), dan.getTenSanPham(), dan.getLoaiSanPham(), dan.isTrangThai() };
				modelKQTK.addRow(rowData);
			}
			modelKQTK.fireTableDataChanged();
		} else if (rdbtnGiaBan.isSelected()) {
			String giaBan = cmbGiaBan.getSelectedItem().toString();
		} else if (rdbtnTrangThai.isSelected()) {
			String trangThai = cmbTrangThai.getSelectedItem().toString();
		}
	}

	private void displaySearchResult(List<Dan> searchResults) {
		modelKQTK.setRowCount(0);

		for (Dan dan : searchResults) {
			Object[] rowData = { dan.getMaSanPham(), dan.getTenSanPham(), dan.getLoaiSanPham(), dan.isTrangThai() };
			modelKQTK.addRow(rowData);
		}
	}

}
