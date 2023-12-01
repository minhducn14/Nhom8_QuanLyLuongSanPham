package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Connection.MyConnection;
import DAO.DAO_ThoLamDan;
import Entity.ThoLamDan;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frm_TimKiemThongTinThoLamDan extends JPanel implements ItemListener {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtHoTen;
	private JTextField textField_1;
	private JTextField txtDiaChi;
	private JTextField textField_2;
	private JTextField txtSoDienThoai;
	private JComboBox<String> comboBoxTrangThai;
	private DefaultTableModel modell;
	private JRadioButton rdbtnNu, rdbtnHoTen, rdbtnSoDienThoai, rdbtnDiaChi, rdbtnTrangThai, rdbtnGioiTinh, rdbtnNam;
	private ButtonGroup group = new ButtonGroup(), groupGT = new ButtonGroup();
	private DAO_ThoLamDan dao_ThoLamDan = new DAO_ThoLamDan();
	private SimpleDateFormat dateFormat;

	public frm_TimKiemThongTinThoLamDan() {
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

		JTable table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		JTableHeader tb1 = table_1.getTableHeader();
		tb1.setBackground(new Color(221, 242, 251));
		tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight1 = 30;
		int rowMargin1 = 10;
		table_1.setRowHeight(rowHeight1);
		table_1.setIntercellSpacing(new Dimension(0, rowMargin1));
		String[] col = { "Mã thợ làm đàn", "Họ tên thợ làm đàn", "Giới tính", "Ngày sinh", "CMND", "Số điện thoại" };
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

		JLabel lblNewLabel_6_1 = new JLabel("Tìm kiếm thợ làm đàn theo :");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6_1.setBounds(35, 15, 304, 25);
		panel.add(lblNewLabel_6_1);

		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonModel selectedRadioButton = group.getSelection();
				if (selectedRadioButton != null) {
					if (rdbtnHoTen.isSelected()) {
						modell.setRowCount(0);
						String ten = txtHoTen.getText().trim();
						if (ten.equals("")) {
							JOptionPane.showMessageDialog(null, "Tên không được để trống");
						} else {
							ArrayList<ThoLamDan> listTLD = dao_ThoLamDan.getThoLamDanTheoTen(ten);
							for (ThoLamDan thoLamDan : listTLD) {
								String ngaySinh = dateFormat.format(thoLamDan.getCongNhanVien().getNgaySinh());
								String gioiTinh = thoLamDan.getCongNhanVien().isGioiTinh() ? "Nam" : "Nữ";
								Object[] objects = { thoLamDan.getMaThoLamDan(), thoLamDan.getCongNhanVien().getHoTen(),
										gioiTinh, ngaySinh, thoLamDan.getCongNhanVien().getMaCanCuocCongDan(),
										thoLamDan.getCongNhanVien().getSoDienThoai() };
								modell.addRow(objects);
							}
							modell.fireTableDataChanged();
						}
					} else if (rdbtnDiaChi.isSelected()) {
						String diaChi = txtDiaChi.getText();
						modell.setRowCount(0);
						if (diaChi.equals("")) {
							JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống");
						} else {
							ArrayList<ThoLamDan> listTLD = dao_ThoLamDan.getThoLamDanTheoDiaChi(diaChi);
							for (ThoLamDan thoLamDan : listTLD) {
								String ngaySinh = dateFormat.format(thoLamDan.getCongNhanVien().getNgaySinh());
								String gioiTinh = thoLamDan.getCongNhanVien().isGioiTinh() ? "Nam" : "Nữ";
								Object[] objects = { thoLamDan.getMaThoLamDan(), thoLamDan.getCongNhanVien().getHoTen(),
										gioiTinh, ngaySinh, thoLamDan.getCongNhanVien().getMaCanCuocCongDan(),
										thoLamDan.getCongNhanVien().getSoDienThoai() };
								modell.addRow(objects);
							}
							modell.fireTableDataChanged();
						}
					} else if (rdbtnGioiTinh.isSelected()) {
						int gt;
						if (rdbtnNam.isSelected()) {
							gt = 1;
						} else {
							gt = 0;
						}
						modell.setRowCount(0);
						ArrayList<ThoLamDan> listTLD = dao_ThoLamDan.getThoLamDanTheoGioiTinh(gt);
						for (ThoLamDan thoLamDan : listTLD) {
							String ngaySinh = dateFormat.format(thoLamDan.getCongNhanVien().getNgaySinh());
							String gioiTinh = thoLamDan.getCongNhanVien().isGioiTinh() ? "Nam" : "Nữ";
							Object[] objects = { thoLamDan.getMaThoLamDan(), thoLamDan.getCongNhanVien().getHoTen(),
									gioiTinh, ngaySinh, thoLamDan.getCongNhanVien().getMaCanCuocCongDan(),
									thoLamDan.getCongNhanVien().getSoDienThoai() };
							modell.addRow(objects);
						}
						modell.fireTableDataChanged();
					} else if (rdbtnSoDienThoai.isSelected()) {
						String sdt = txtSoDienThoai.getText().trim();

						if (!(sdt.length() > 0 || sdt.matches("^0[0-9]{0,9}$"))) {
							JOptionPane.showMessageDialog(null, "Error : Số điện thoại bắt đầu từ số 0 và là số");
						} else {
							modell.setRowCount(0);
							ArrayList<ThoLamDan> listTLD = dao_ThoLamDan.getAllThoLamDanTheoSoDienThaoi(sdt);
							for (ThoLamDan thoLamDan : listTLD) {
								String ngaySinh = dateFormat.format(thoLamDan.getCongNhanVien().getNgaySinh());
								String gioiTinh = thoLamDan.getCongNhanVien().isGioiTinh() ? "Nam" : "Nữ";
								Object[] objects = { thoLamDan.getMaThoLamDan(), thoLamDan.getCongNhanVien().getHoTen(),
										gioiTinh, ngaySinh, thoLamDan.getCongNhanVien().getMaCanCuocCongDan(),
										thoLamDan.getCongNhanVien().getSoDienThoai() };
								modell.addRow(objects);
							}
							modell.fireTableDataChanged();
						}
					} else if (rdbtnTrangThai.isSelected()) {
						String trangThai = (String) comboBoxTrangThai.getSelectedItem();
						int tt;
						if (trangThai.equals("Đang Làm")) {
							tt = 1;
						} else {
							tt = 0;
						}
						modell.setRowCount(0);
						ArrayList<ThoLamDan> listTLD = dao_ThoLamDan.getThoLamDanTheoTrangThai(tt);
						for (ThoLamDan thoLamDan : listTLD) {
							String ngaySinh = dateFormat.format(thoLamDan.getCongNhanVien().getNgaySinh());
							String gioiTinh = thoLamDan.getCongNhanVien().isGioiTinh() ? "Nam" : "Nữ";
							Object[] objects = { thoLamDan.getMaThoLamDan(), thoLamDan.getCongNhanVien().getHoTen(),
									gioiTinh, ngaySinh, thoLamDan.getCongNhanVien().getMaCanCuocCongDan(),
									thoLamDan.getCongNhanVien().getSoDienThoai() };
							modell.addRow(objects);
						}
						modell.fireTableDataChanged();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Chưa tiêu chí nào được chọn để tìm kiếm");
				}
			}
		});
		btnTmKim.setForeground(Color.WHITE);
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmKim.setBackground(new Color(2, 104, 156));
		btnTmKim.setBounds(499, 255, 170, 50);
		panel.add(btnTmKim);

		JButton btnXoRng = new JButton("Xoá rỗng");
		btnXoRng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				group.clearSelection();
				txtDiaChi.setText("");
				txtHoTen.setText("");
				txtSoDienThoai.setText("");
				comboBoxTrangThai.setSelectedIndex(0);
				rdbtnNam.setSelected(true);
				txtDiaChi.setEnabled(false);
				txtHoTen.setEnabled(false);
				txtSoDienThoai.setEnabled(false);
				comboBoxTrangThai.setEnabled(false);
				rdbtnNam.setEnabled(false);
				rdbtnNu.setEnabled(false);
				group.clearSelection();
			}
		});
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

		rdbtnHoTen = new JRadioButton("");
		rdbtnHoTen.setBounds(0, 0, 25, 25);
		rdbtnHoTen.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnHoTen.setBackground(new Color(255, 255, 255));
		panel_1.add(rdbtnHoTen);

		JLabel lblNewLabel_1 = new JLabel("Họ tên:");
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

		rdbtnDiaChi = new JRadioButton("");
		rdbtnDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnDiaChi.setBackground(Color.WHITE);
		rdbtnDiaChi.setBounds(0, 0, 25, 25);
		panel_1_1.add(rdbtnDiaChi);
		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(31, 0, 140, 25);
		panel_1_1.add(lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 0, 380, 25);

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

		rdbtnTrangThai = new JRadioButton("");
		rdbtnTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTrangThai.setBackground(Color.WHITE);
		rdbtnTrangThai.setBounds(0, 0, 25, 25);
		panel_1_2.add(rdbtnTrangThai);

		JLabel lblNewLabel_1_22 = new JLabel("Trạng thái:");
		lblNewLabel_1_22.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_22.setBounds(31, 0, 140, 25);
		panel_1_2.add(lblNewLabel_1_22);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(180, 0, 380, 25);

		comboBoxTrangThai = new JComboBox<String>();
		comboBoxTrangThai.setBounds(201, 0, 318, 25);
		comboBoxTrangThai.addItem("Đang Làm");
		comboBoxTrangThai.addItem("Nghỉ Làm");
		comboBoxTrangThai.setSelectedIndex(0);
		panel_1_2.add(comboBoxTrangThai);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(759, 122, 560, 25);
		panel_1_3.setBounds(800, 134, 519, 25);
		panel.add(panel_1_3);

		rdbtnSoDienThoai = new JRadioButton("");
		rdbtnSoDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSoDienThoai.setBackground(Color.WHITE);
		rdbtnSoDienThoai.setBounds(0, 0, 25, 25);
		panel_1_3.add(rdbtnSoDienThoai);

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
		panel_1_4.setBounds(448, 202, 560, 25);
		panel.add(panel_1_4);
		panel_1_4.setLayout(null);

		rdbtnGioiTinh = new JRadioButton("");
		rdbtnGioiTinh.setBounds(1, 0, 25, 25);
		rdbtnGioiTinh.setBackground(new Color(255, 255, 255));
		rdbtnGioiTinh.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1_4.add(rdbtnGioiTinh);

		JLabel lblNewLabel_4 = new JLabel("Giới tính:");
		lblNewLabel_4.setBounds(32, 0, 85, 25);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1_4.add(lblNewLabel_4);

		rdbtnNam = new JRadioButton("");
		rdbtnNam.setBounds(225, 0, 25, 25);
		rdbtnNam.setSelected(true);
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
		panel_1_4.add(rdbtnNu);

		groupGT.add(rdbtnNam);
		groupGT.add(rdbtnNu);

		group.add(rdbtnDiaChi);
		group.add(rdbtnGioiTinh);
		group.add(rdbtnHoTen);
		group.add(rdbtnSoDienThoai);
		group.add(rdbtnTrangThai);

		rdbtnDiaChi.addItemListener(this);
		rdbtnGioiTinh.addItemListener(this);
		rdbtnHoTen.addItemListener(this);
		rdbtnSoDienThoai.addItemListener(this);
		rdbtnTrangThai.addItemListener(this);

		txtDiaChi.setEnabled(false);
		txtHoTen.setEnabled(false);
		txtSoDienThoai.setEnabled(false);
		rdbtnNam.setEnabled(false);
		rdbtnNu.setEnabled(false);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(rdbtnHoTen)) {
			txtDiaChi.setText("");
			txtSoDienThoai.setText("");
			comboBoxTrangThai.setSelectedIndex(0);
			rdbtnNam.setSelected(true);
			txtDiaChi.setEnabled(false);
			txtHoTen.setEnabled(true);
			txtSoDienThoai.setEnabled(false);
			comboBoxTrangThai.setEnabled(false);
			rdbtnNam.setEnabled(false);
			rdbtnNu.setEnabled(false);
		} else if (e.getSource().equals(rdbtnDiaChi)) {
			txtHoTen.setText("");
			txtSoDienThoai.setText("");
			comboBoxTrangThai.setSelectedIndex(0);
			rdbtnNam.setSelected(true);
			txtDiaChi.setEnabled(true);
			txtHoTen.setEnabled(false);
			txtSoDienThoai.setEnabled(false);
			comboBoxTrangThai.setEnabled(false);
			rdbtnNam.setEnabled(false);
			rdbtnNu.setEnabled(false);
		} else if (e.getSource().equals(rdbtnGioiTinh)) {
			txtDiaChi.setText("");
			txtHoTen.setText("");
			txtSoDienThoai.setText("");
			comboBoxTrangThai.setSelectedIndex(0);
			rdbtnNam.setSelected(true);
			txtDiaChi.setEnabled(false);
			txtHoTen.setEnabled(false);
			txtSoDienThoai.setEnabled(false);
			comboBoxTrangThai.setEnabled(false);
			rdbtnNam.setEnabled(true);
			rdbtnNu.setEnabled(true);
		} else if (e.getSource().equals(rdbtnSoDienThoai)) {
			txtDiaChi.setText("");
			txtHoTen.setText("");
			comboBoxTrangThai.setSelectedIndex(0);
			rdbtnNam.setSelected(true);
			txtDiaChi.setEnabled(false);
			txtHoTen.setEnabled(false);
			txtSoDienThoai.setEnabled(true);
			comboBoxTrangThai.setEnabled(false);
			rdbtnNam.setEnabled(false);
			rdbtnNu.setEnabled(false);
		} else if (e.getSource().equals(rdbtnTrangThai)) {
			txtDiaChi.setText("");
			txtHoTen.setText("");
			txtSoDienThoai.setText("");
			comboBoxTrangThai.setSelectedIndex(0);
			rdbtnNam.setSelected(true);
			txtDiaChi.setEnabled(false);
			txtHoTen.setEnabled(false);
			txtSoDienThoai.setEnabled(false);
			comboBoxTrangThai.setEnabled(true);
			rdbtnNam.setEnabled(false);
			rdbtnNu.setEnabled(false);
		}
	}
}
