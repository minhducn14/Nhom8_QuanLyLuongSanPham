package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;

import connection.MyConnection;
import dao.DAO_CongNhanVien;
import dao.DAO_ThoLamDan;
import entity.CongNhanVien;
import entity.ThoLamDan;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FRM_TimKiemThongTinThoLamDan extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JComboBox<String> comboBoxTrangThai, comboBoxTayNghe;
	private ButtonGroup group = new ButtonGroup(), groupSex = new ButtonGroup();
	private JRadioButton rdbtnNu, rdbtnNam;
	private DAO_CongNhanVien dao_cnv = new DAO_CongNhanVien();
	private DAO_ThoLamDan dao_tld = new DAO_ThoLamDan();
	private JButton btnTmKim, btnXoRng;
	private DefaultTableModel modell;
	private SimpleDateFormat dateFormat;
	private JTable table_1;
	private List<CongNhanVien> listcnv;
	private List<ThoLamDan> listtld;

	public FRM_TimKiemThongTinThoLamDan() {
		MyConnection.getInstance().MyConnection();

		setLayout(null);
		setBackground(new Color(221, 242, 251));
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		JLabel lblNewLabel = new JLabel("TÌM KIẾM THÔNG TIN THỢ LÀM ĐÀN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(0, 27, 72));
		lblNewLabel.setBounds(10, 5, 1430, 70);
		add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(15, 490, 1420, 200);
		add(panel_2);
		panel_2.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(15, 430, 1420, 3);
		add(separator_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 10, 1380, 180);
		panel_2.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		JTableHeader tb1 = table_1.getTableHeader();
		tb1.setBackground(new Color(221, 242, 251));
		tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight1 = 30;
		int rowMargin1 = 10;
		table_1.setRowHeight(rowHeight1);
		table_1.setIntercellSpacing(new Dimension(0, rowMargin1));
		String[] col = { "Mã Thợ Làm Đàn ", "Họ Tên Thợ Làm Đàn", "Giới Tính", "Ngày Sinh", "CMND", "SDT", "Địa Chỉ",
				"Tay Nghề", "Trạng Thái" };
		modell = new DefaultTableModel(col, 0);
		table_1.setModel(modell);

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

		JLabel lblNewLabel_6_1 = new JLabel("Tìm Kiếm Thợ Làm Đàn Theo :");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6_1.setBounds(35, 15, 304, 25);
		panel.add(lblNewLabel_6_1);

		btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setForeground(Color.WHITE);
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmKim.setBackground(new Color(2, 104, 156));
		btnTmKim.setBounds(499, 255, 170, 50);
		panel.add(btnTmKim);

		btnXoRng = new JButton("Xoá rỗng");
		btnXoRng.setForeground(Color.WHITE);
		btnXoRng.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoRng.setBackground(new Color(2, 104, 156));
		btnXoRng.setBounds(803, 255, 170, 50);
		panel.add(btnXoRng);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(50, 65, 519, 25);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(31, 0, 140, 25);
		panel_1.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(180, 0, 380, 25);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(201, 0, 318, 25);
		panel_1.add(txtHoTen);
		txtHoTen.setColumns(10);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(91, 122, 560, 25);
		panel_1_1.setBounds(50, 134, 519, 25);
		panel.add(panel_1_1);
		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(31, 0, 140, 25);
		panel_1_1.add(lblNewLabel_1_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(201, 0, 318, 25);
		panel_1_1.add(txtDiaChi);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(759, 65, 560, 25);
		panel_1_2.setBounds(800, 65, 519, 25);
		panel.add(panel_1_2);

		JLabel lblNewLabel_1_3_2 = new JLabel("Tay Nghề :");
		lblNewLabel_1_3_2.setBounds(30, 0, 140, 25);
		panel_1_2.add(lblNewLabel_1_3_2);
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));

		comboBoxTayNghe = new JComboBox<String>();
		comboBoxTayNghe.setBounds(201, 0, 318, 25);
		comboBoxTayNghe.addItem("Tất cả");
		comboBoxTayNghe.addItem("Bậc 1");
		comboBoxTayNghe.addItem("Bậc 2");
		comboBoxTayNghe.addItem("Bậc 3");
		comboBoxTayNghe.addItem("Bậc 4");
		comboBoxTayNghe.addItem("Bậc 5");
		panel_1_2.add(comboBoxTayNghe);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(759, 122, 560, 25);
		panel_1_3.setBounds(800, 134, 519, 25);
		panel.add(panel_1_3);

		JLabel lblNewLabel_1_3 = new JLabel("Số điện thoại:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(31, 0, 140, 25);
		panel_1_3.add(lblNewLabel_1_3);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(180, 0, 380, 25);
		panel_1_3.add(txtSoDienThoai);

		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(Color.WHITE);
		panel_1_4.setBounds(50, 202, 519, 25);
		panel.add(panel_1_4);
		panel_1_4.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Giới tính:");
		lblNewLabel_4.setBounds(32, 0, 85, 25);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1_4.add(lblNewLabel_4);

		rdbtnNam = new JRadioButton("");
		rdbtnNam.setBounds(225, 0, 25, 25);
		rdbtnNam.setSelected(false);
		rdbtnNam.setBackground(new Color(255, 255, 255));
		rdbtnNam.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1_4.add(rdbtnNam);

		JLabel lblNewLabel_3 = new JLabel("Nam");
		lblNewLabel_3.setBounds(256, 0, 85, 25);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1_4.add(lblNewLabel_3);
		txtSoDienThoai.setBounds(201, 0, 318, 25);
		panel_1_3.add(txtSoDienThoai);

		JLabel lblNewLabel_44 = new JLabel("Giới tính: ");
		lblNewLabel_44.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNewLabel_33 = new JLabel("Nam");
		lblNewLabel_33.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNewLabel_2 = new JLabel("Nữ");
		lblNewLabel_2.setBounds(404, 0, 93, 25);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1_4.add(lblNewLabel_2);

		rdbtnNu = new JRadioButton("");
		rdbtnNu.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNu.setBackground(Color.WHITE);
		rdbtnNu.setBounds(373, 0, 25, 25);
		rdbtnNu.setSelected(false);
		panel_1_4.add(rdbtnNu);

		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setLayout(null);
		panel_1_3_1.setBackground(Color.WHITE);
		panel_1_3_1.setBounds(800, 202, 519, 25);
		panel.add(panel_1_3_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("Trạng thái:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBounds(31, 0, 140, 25);
		panel_1_3_1.add(lblNewLabel_1_3_1);

		comboBoxTrangThai = new JComboBox<String>();
		comboBoxTrangThai.setBounds(201, 0, 318, 25);
		comboBoxTrangThai.addItem("Tất cả");
		comboBoxTrangThai.addItem("Đang Làm");
		comboBoxTrangThai.addItem("Nghỉ Làm");

		comboBoxTrangThai.setSelectedIndex(0);
		panel_1_3_1.add(comboBoxTrangThai);

		groupSex.add(rdbtnNu);
		groupSex.add(rdbtnNam);

		btnTmKim.addActionListener(this);
		btnXoRng.addActionListener(this);

		MyConnection.getInstance().MyConnection();
		updateTableDataThoLamDan();
	}

	public void updateTableDataThoLamDan() {

		listcnv = dao_cnv.docTuBang();
		listtld = dao_tld.docTuBang();
		modell.setRowCount(0);

		for (int i = 0; i < listtld.size(); i++) {
			ThoLamDan tld = listtld.get(i);
			CongNhanVien cnv = listcnv.get(i);
			String gioiTinh = cnv.isGioiTinh() ? "Nam" : "Nữ";
			String trangThai = cnv.isTrangThai() ? "Đang làm" : "Nghỉ làm";
			String ngaySinh = dateFormat.format(cnv.getNgaySinh());
			String taynghe = tld.getTayNghe();
			String[] rowData = { tld.getMaThoLamDan(), cnv.getHoTen(), gioiTinh, ngaySinh, cnv.getMaCanCuocCongDan(),
					cnv.getSoDienThoai(), cnv.getDiaChi(), taynghe, trangThai };
			modell.addRow(rowData);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTmKim)) {

			String tayNghe = comboBoxTayNghe.getSelectedItem().toString();
			String hoten = txtHoTen.getText();
			String tinhTrang = comboBoxTrangThai.getSelectedItem().toString();
			String diaChi = txtDiaChi.getText();
			String sdt = txtSoDienThoai.getText();

			String gioiTinhFilter = "";
			if (rdbtnNam.isSelected()) {
				gioiTinhFilter = "Nam";
			} else if (rdbtnNu.isSelected()) {
				gioiTinhFilter = "Nữ";
			}

			TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modell);
			table_1.setRowSorter(sorter);
			List<RowFilter<Object, Object>> filters = new ArrayList<>();
			if (!hoten.isEmpty()) {
				filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(hoten), 1));
			}
			if (!diaChi.isEmpty()) {
				filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(diaChi), 6));
			}
			if (!sdt.isEmpty()) {
				filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(sdt), 5));
			}
			if (!tinhTrang.equalsIgnoreCase("Tất cả")) {
				filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(tinhTrang), 8));
			}
			if (!tayNghe.equalsIgnoreCase("Tất cả")) {
				filters.add(RowFilter.regexFilter(tayNghe, 7));
			}
			if (!gioiTinhFilter.isEmpty()) {
				filters.add(RowFilter.regexFilter(gioiTinhFilter, 2));
			}

			RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
			sorter.setRowFilter(combinedFilter);

			if (table_1.getRowCount() > 0) {
				JOptionPane.showMessageDialog(null, "Tìm kiếm thành công");
			} else {

				JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả tìm kiếm");
			}
		} else if (o.equals(btnXoRng)) {
			groupSex.clearSelection();
			txtDiaChi.setText("");
			txtHoTen.setText("");
			txtSoDienThoai.setText("");
			comboBoxTayNghe.setSelectedIndex(0);
			comboBoxTrangThai.setSelectedIndex(0);
			group.clearSelection();
		}
	}
}