package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import connection.MyConnection;
import dao.DAO_Dan;
import entity.Dan;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FRM_TimKiemThongTinSanPham extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtTenSP;
	private JComboBox<String> cmbLoaiSP;
	private JComboBox<String> cmbTrangThai;
	private JComboBox<String> cmbGiaBan;
	private JButton btnTimKiem, btnXoaRong;
	private DAO_Dan dan_DAO = new DAO_Dan();
	private DefaultTableModel modelKQTK;
	private JTable tblKQTK;
	private List<Dan> danList = new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public FRM_TimKiemThongTinSanPham() {

		MyConnection.getInstance().MyConnection();
		setLayout(null);
		setBackground(new Color(221, 242, 251));

		JLabel lblTimKiemSP = new JLabel("New label");
		lblTimKiemSP.setBounds(400, 5, 680, 70);
		lblTimKiemSP.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblTimKiemSP);
		lblTimKiemSP.setText("TÌM KIẾM THÔNG TIN SẢN PHẨM");

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(15, 430, 1420, 3);
		add(separator_1);

		JPanel pnlKQTK = new JPanel();
		pnlKQTK.setBackground(Color.WHITE);
		pnlKQTK.setBounds(15, 490, 1420, 200);
		add(pnlKQTK);
		pnlKQTK.setLayout(null);

		String[] col = { "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i S\u1EA3n Ph\u1EA9m",
				"T\u00ECnh tr\u1EA1ng", "Gi\u00E1 B\u00E1n" };
		modelKQTK = new DefaultTableModel(col, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = { false, false, false, false, false };

			public boolean isCellEditable(int row, int col) {
				return columnEditables[col];
			}
		};

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 10, 1380, 180);
		pnlKQTK.add(scrollPane_1);
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

		JLabel lblThongTInTImKiem = new JLabel("Tìm kiếm sản phẩm theo :");
		lblThongTInTImKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTInTImKiem.setBounds(35, 15, 304, 25);
		panel.add(lblThongTInTImKiem);

		JLabel lblTenSP = new JLabel("Tên sản phẩm");
		lblTenSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenSP.setBounds(100, 65, 170, 25);
		panel.add(lblTenSP);

		JLabel lblLoaiSP = new JLabel("Loại sản phẩm");
		lblLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoaiSP.setBounds(100, 165, 130, 25);
		panel.add(lblLoaiSP);

		txtTenSP = new JTextField();
		lblTenSP.setLabelFor(txtTenSP);
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(240, 65, 250, 25);
		panel.add(txtTenSP);

		JLabel lblGiaBan = new JLabel("Giá bán");
		lblGiaBan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGiaBan.setBounds(900, 165, 170, 25);
		panel.add(lblGiaBan);

		JLabel lblTrangThai = new JLabel("Trạng thái\r\n");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrangThai.setBounds(900, 65, 170, 25);
		panel.add(lblTrangThai);

		btnTimKiem = new JButton("Tìm kiếm");

		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKiem.setBackground(new Color(2, 104, 156));
		btnTimKiem.setBounds(500, 225, 170, 50);
		panel.add(btnTimKiem);

		btnXoaRong = new JButton("Xoá rỗng");
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

		String[] loaiSP = { "Tất cả", "CLASSIC", "ACOUSTIC" };
		cmbLoaiSP = new JComboBox<>(loaiSP);
		cmbLoaiSP.setSelectedIndex(0);
		cmbLoaiSP.setBackground(Color.WHITE);
		cmbLoaiSP.setBounds(240, 165, 250, 25);
		panel.add(cmbLoaiSP);

		String[] giaBan = { "Tất cả", "500.000 - 1.000.000", "1.000.000 - 2.000.000", "2.000.000 - 3.000.000",
				"3.000.000 - 4.000.000", "4.000.000 - 5.000.000", "5.000.000 - 6.000.000" };
		cmbGiaBan = new JComboBox<>(giaBan);
		cmbGiaBan.setSelectedIndex(0);
		cmbGiaBan.setBackground(Color.WHITE);
		cmbGiaBan.setBounds(1060, 169, 250, 25);
		panel.add(cmbGiaBan);

		String[] tinhTrang = { "Tất cả", "Đang bán", "Ngưng phục vụ" };
		cmbTrangThai = new JComboBox<>(tinhTrang);
		cmbTrangThai.setSelectedIndex(0);
		cmbTrangThai.setBackground(Color.WHITE);
		cmbTrangThai.setBounds(1060, 65, 250, 25);
		panel.add(cmbTrangThai);
		btnTimKiem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		updateTableKQ();

	}

	public void updateTableKQ() {
		danList = dan_DAO.getAlListDan();
		modelKQTK.setRowCount(0);
		for (int i = 0; i < danList.size(); i++) {
			Dan dan = danList.get(i);
			String trangThai = dan.isTrangThai() ? "Đang bán" : "Ngưng phục vụ";
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

			String[] rowData = { dan.getMaSanPham(), dan.getTenSanPham(), dan.getLoaiSanPham(), trangThai,
					decimalFormat.format(dan.getGiaBan()) };
			modelKQTK.addRow(rowData);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTimKiem)) {

			String tenSP = txtTenSP.getText().toLowerCase();
			String loaiSP = cmbLoaiSP.getSelectedItem().toString().equalsIgnoreCase("Tất cả") ? ""
					: cmbLoaiSP.getSelectedItem().toString();
			String trangThai = cmbTrangThai.getSelectedItem().toString().equalsIgnoreCase("Tất cả") ? ""
					: cmbTrangThai.getSelectedItem().toString();

			TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(modelKQTK);
			tblKQTK.setRowSorter(sorter);
			List<RowFilter<Object, Object>> filters = new ArrayList<>();

			if (!cmbGiaBan.getSelectedItem().toString().equalsIgnoreCase("Tất cả")) {
				String[] parts = cmbGiaBan.getSelectedItem().toString().split(" - ");
				double lowerBound = Double.parseDouble(parts[0].replace(".", "").replace(",", "").trim());
				double upperBound = Double.parseDouble(parts[1].replace(".", "").replace(",", "").trim());

				filters.add(new RowFilter<Object, Object>() {
					@Override
					public boolean include(Entry<? extends Object, ? extends Object> entry) {
						String priceStr = entry.getStringValue(4).replace(",", "");
						double price;
						try {
							price = Double.parseDouble(priceStr);
						} catch (NumberFormatException ex) {
							return false;
						}
						return price >= lowerBound && price <= upperBound;
					}
				});
			}
			filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(tenSP), 1));
			filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(loaiSP), 2));
			filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(trangThai), 3));
			RowFilter<Object, Object> af = RowFilter.andFilter(filters);
			sorter.setRowFilter(af);

			if (tblKQTK.getRowCount() > 0) {
				JOptionPane.showMessageDialog(null, "Tìm kiếm thành công");
			} else {

				JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả tìm kiếm");
			}

		} else if (o.equals(btnXoaRong)) {
			txtTenSP.setText("");
			cmbGiaBan.setSelectedIndex(0);
			cmbLoaiSP.setSelectedIndex(0);
			cmbTrangThai.setSelectedIndex(0);
		}
	}

}
