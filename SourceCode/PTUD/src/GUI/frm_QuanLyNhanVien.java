package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.sql.SQLException;

import com.toedter.calendar.JDateChooser;

import Connection.MyConnection;
import DAO.DAO_CongNhanVien;
import DAO.DAO_NhanVien;
import DAO.DAO_PhongBan;
import DAO.DAO_TaiKhoan;
import Entity.CongNhanVien;
import Entity.NhanVien;
import Entity.PhongBan;
import Entity.TaiKhoan;

public class frm_QuanLyNhanVien extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelNhanVien;
	private JTable tbl_bangTen;
	private JTextField txtMaNhanVien;
	private JTextField txtCMND;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtLuongCoBan;
	private JRadioButton rbtNam, rbtNu;
	private JButton btnThem, btnXoaRong, btnSua;
	private JComboBox<String> cbbPhongBan, cbbChucVu, cbbTrinhDo, cbbTrangThai;
	private JDateChooser dateChooserNgayVaoLam, dateChooserNgaySinh;
	private ButtonGroup G;
	private SimpleDateFormat dateFormat;
	private List<NhanVien> listnv;
	private List<CongNhanVien> listcnv;
	private DAO_NhanVien dao_nv;
	private DAO_CongNhanVien dao_cnv;
	private DAO_PhongBan dao_pb;
	private DAO_TaiKhoan dao_TaiKhoan;

	public frm_QuanLyNhanVien() {

		dao_nv = new DAO_NhanVien();
		dao_cnv = new DAO_CongNhanVien();
		dao_pb = new DAO_PhongBan();
		dao_TaiKhoan = new DAO_TaiKhoan();

		setBackground(new Color(221, 242, 251));
		setLayout(null);

		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		JLabel lblTieuDe = new JLabel("Nhân Viên");
		lblTieuDe.setForeground(new Color(0, 27, 72));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(304, -11, 850, 90);
		add(lblTieuDe);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(2, 104, 156));
		separator.setForeground(new Color(2, 104, 156));
		separator.setBounds(15, 518, 1420, 2);
		add(separator);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_1.setBounds(15, 531, 1420, 158);
		add(panel_1_1);

		JLabel lblBngLngNhn = new JLabel("Danh sách nhân viên");
		lblBngLngNhn.setForeground(new Color(0, 27, 72));
		lblBngLngNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBngLngNhn.setBounds(30, 10, 340, 25);
		panel_1_1.add(lblBngLngNhn);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 41, 1376, 106);
		panel_1_1.add(scrollPane_1);

		tbl_bangTen = new JTable();

		TableColumnModel columnModel = tbl_bangTen.getColumnModel();

		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tbl_bangTen.getTableHeader().setReorderingAllowed(false);
		scrollPane_1.setViewportView(tbl_bangTen);

		String[] colHeader = { "Mã Nhân Viên", "Họ tên nhân viên", "Giới Tính", "Ngày Sinh", "CMND", "SDT" };

		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tbl_bangTen.getTableHeader().setReorderingAllowed(false);
		scrollPane_1.setViewportView(tbl_bangTen);

		modelNhanVien = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = { false, false, false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		scrollPane_1.setViewportView(tbl_bangTen);

		tbl_bangTen.setModel(modelNhanVien);
		JTableHeader tbBangLuong = tbl_bangTen.getTableHeader();
		tbBangLuong.setBackground(new Color(151, 201, 219));
		tbBangLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		tbl_bangTen.setRowHeight(rowHeight);
		tbl_bangTen.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(15, 69, 1420, 438);
		add(panel);
		panel.setLayout(null);

		JLabel lblThongTinNhanVien = new JLabel("Thông tin nhân viên");
		lblThongTinNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinNhanVien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTinNhanVien.setBounds(54, 11, 256, 25);
		panel.add(lblThongTinNhanVien);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 47, 684, 336);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaNhanVien.setBounds(20, 11, 133, 25);
		panel_1.add(lblMaNhanVien);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBounds(163, 11, 305, 25);
		txtMaNhanVien.setEditable(false);
		panel_1.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGioiTinh.setBounds(20, 55, 133, 25);
		panel_1.add(lblGioiTinh);

		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCMND.setBounds(20, 99, 133, 25);
		panel_1.add(lblCMND);

		JLabel lblPhongBan = new JLabel("Phòng Ban");
		lblPhongBan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhongBan.setBounds(20, 143, 133, 25);
		panel_1.add(lblPhongBan);

		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChucVu.setBounds(20, 187, 133, 25);
		panel_1.add(lblChucVu);

		JLabel lblNgayVaoLam = new JLabel("Ngày vào làm");
		lblNgayVaoLam.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayVaoLam.setBounds(20, 231, 133, 25);
		panel_1.add(lblNgayVaoLam);

		JLabel lblHeSoLuong = new JLabel("Hệ số lương");
		lblHeSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHeSoLuong.setBounds(20, 275, 133, 25);
		panel_1.add(lblHeSoLuong);

		rbtNam = new JRadioButton("        Nam");
		rbtNam.setBackground(new Color(255, 255, 255));
		rbtNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbtNam.setSelected(true);
		rbtNam.setHorizontalAlignment(SwingConstants.LEFT);
		rbtNam.setBounds(163, 53, 153, 28);
		panel_1.add(rbtNam);

		rbtNu = new JRadioButton("          Nữ");
		rbtNu.setBackground(new Color(255, 255, 255));
		rbtNu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbtNu.setBounds(315, 53, 153, 28);
		panel_1.add(rbtNu);

		G = new ButtonGroup();
		G.add(rbtNam);
		G.add(rbtNu);

		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(163, 100, 305, 27);
		panel_1.add(txtCMND);

		cbbPhongBan = new JComboBox<String>();
		cbbPhongBan.setEditable(true);
		cbbPhongBan.setBounds(163, 143, 305, 28);
		panel_1.add(cbbPhongBan);
		cbbPhongBan.setEditable(false);

		cbbChucVu = new JComboBox<String>();
		cbbChucVu.setEditable(true);
		cbbChucVu.setBounds(163, 187, 305, 28);
		cbbChucVu.addItem("Nhân Viên");
		cbbChucVu.addItem("Phó Phòng");
		cbbChucVu.addItem("Trưởng Phòng");
		panel_1.add(cbbChucVu);
		cbbChucVu.setEditable(false);
		JTextField txtHeSoLuong = new JTextField();
		txtHeSoLuong.setText("2.41");
		txtHeSoLuong.setEditable(false);

		txtHeSoLuong.setBounds(163, 275, 305, 28);
		panel_1.add(txtHeSoLuong);

		dateChooserNgayVaoLam = new JDateChooser();
		dateChooserNgayVaoLam.setBounds(163, 231, 305, 28);
		dateChooserNgayVaoLam.setDateFormatString("dd-MM-yyyy");
		java.util.Date currentDate = new java.util.Date();
		dateChooserNgayVaoLam.setDate(currentDate);
		panel_1.add(dateChooserNgayVaoLam);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(720, 47, 684, 336);
		panel.add(panel_1_2);

		JLabel lblHoTen = new JLabel("Họ tên");
		lblHoTen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHoTen.setBounds(20, 11, 133, 25);
		panel_1_2.add(lblHoTen);

		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(163, 11, 305, 25);
		panel_1_2.add(txtHoTen);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgaySinh.setBounds(20, 55, 133, 25);
		panel_1_2.add(lblNgaySinh);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoDienThoai.setBounds(20, 99, 133, 25);
		panel_1_2.add(lblSoDienThoai);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDiaChi.setBounds(20, 143, 133, 25);
		panel_1_2.add(lblDiaChi);

		JLabel lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrangThai.setBounds(20, 187, 133, 25);
		panel_1_2.add(lblTrangThai);

		JLabel lblTrinhDo = new JLabel("Trình độ");
		lblTrinhDo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrinhDo.setBounds(20, 231, 133, 25);
		panel_1_2.add(lblTrinhDo);

		JLabel lblLuongCoBan = new JLabel("Lương cơ bản");
		lblLuongCoBan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLuongCoBan.setBounds(20, 278, 133, 25);
		panel_1_2.add(lblLuongCoBan);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(163, 100, 305, 27);
		panel_1_2.add(txtSDT);

		cbbTrangThai = new JComboBox<String>();
		cbbTrangThai.setEditable(true);
		cbbTrangThai.setBounds(163, 187, 305, 28);
		cbbTrangThai.addItem("Đang Làm");
		cbbTrangThai.addItem("Nghỉ Làm");
		panel_1_2.add(cbbTrangThai);

		cbbTrinhDo = new JComboBox<String>();
		cbbTrinhDo.setEditable(true);
		cbbTrinhDo.addItem("Đại học");
		cbbTrinhDo.addItem("Cao đẳng");
		cbbTrinhDo.setBounds(163, 231, 305, 28);
		cbbTrinhDo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String TrinhDoDuocChon = (String) cbbTrinhDo.getSelectedItem();
					NhanVien nv = new NhanVien();
					java.sql.Date ngayVaoLam = new java.sql.Date(dateChooserNgayVaoLam.getDate().getTime());
					double heSoLuong = nv.tinhHeSoLuong(ngayVaoLam, TrinhDoDuocChon);
					DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
					txtHeSoLuong.setText(decimalFormat.format(heSoLuong));

				}

			}
		});
		panel_1_2.add(cbbTrinhDo);

		dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setBounds(163, 52, 305, 28);
		dateChooserNgaySinh.setDateFormatString("dd-MM-yyyy");
		panel_1_2.add(dateChooserNgaySinh);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(163, 144, 305, 27);
		panel_1_2.add(txtDiaChi);

		txtLuongCoBan = new JTextField();
		txtLuongCoBan.setColumns(10);
		txtLuongCoBan.setBounds(163, 279, 305, 27);
		panel_1_2.add(txtLuongCoBan);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(473, 394, 120, 30);
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBackground(new Color(0, 128, 255));
		panel.add(btnThem);

		btnSua = new JButton("Sửa thông tin");
		btnSua.setBounds(649, 394, 120, 30);
		btnSua.setBackground(new Color(0, 128, 255));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnSua);

		btnXoaRong = new JButton("Xoá rỗng");
		btnXoaRong.setBounds(827, 394, 120, 30);
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setBackground(new Color(0, 128, 255));
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnXoaRong);

		btnXoaRong.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		tbl_bangTen.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl_bangTen.getSelectedRow();

				if (row >= 0 && row < listnv.size()) {
					NhanVien nv = listnv.get(row);

					txtMaNhanVien.setText(nv.getMaNhanVien());
					txtHoTen.setText(nv.getCongNhanVien().getHoTen());
					txtSDT.setText(nv.getCongNhanVien().getSoDienThoai());
					txtDiaChi.setText(nv.getCongNhanVien().getDiaChi());
					String gioiTinhValue = modelNhanVien.getValueAt(row, 2).toString();
					if ("Nữ".equals(gioiTinhValue)) {
						rbtNu.setSelected(true);
					} else {
						rbtNam.setSelected(true);
					}

					java.sql.Date getNgaySinh = nv.getCongNhanVien().getNgaySinh();
					dateChooserNgaySinh.setDate(getNgaySinh);

					cbbChucVu.setSelectedItem(nv.getChucVu());
					cbbPhongBan.setSelectedItem(nv.getPhongBan().getTenPhongBan());
					cbbTrinhDo.setSelectedItem(nv.getTrinhDoVanHoa());

					java.sql.Date getNgayLam = nv.getCongNhanVien().getNgayVaoLam();
					dateChooserNgayVaoLam.setDate(getNgayLam);

					txtCMND.setText(nv.getCongNhanVien().getMaCanCuocCongDan());
					cbbTrangThai.setSelectedItem(nv.getCongNhanVien().isTrangThai() ? "Đang Làm" : "Nghỉ Làm");
					txtLuongCoBan.setText(nv.getLuongCoBan() + "");
				}
			}
		});
		dateChooserNgayVaoLam.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					String TrinhDoDuocChon = (String) cbbTrinhDo.getSelectedItem();
					NhanVien nv = new NhanVien();
					java.sql.Date ngayVaoLam = new java.sql.Date(dateChooserNgayVaoLam.getDate().getTime());

					double heSoLuong = nv.tinhHeSoLuong(ngayVaoLam, TrinhDoDuocChon);
					DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

					txtHeSoLuong.setText(decimalFormat.format(heSoLuong));
				}
			}
		});

		MyConnection.getInstance().MyConnection();
		layDataVoComboBox();
		autoGenIdNhanVien();
		updateTableDataNhanVien();
	}

	private void updateTableDataNhanVien() {

		listnv = dao_nv.docTuBang();
		listcnv = dao_cnv.docTuBang();
		modelNhanVien.setRowCount(0);

		for (int i = 0; i < listnv.size(); i++) {
			NhanVien nv = listnv.get(i);
			if (i < listcnv.size()) {
				CongNhanVien cnv = listcnv.get(i);
				String gioiTinh = cnv.isGioiTinh() ? "Nam" : "Nữ";
				String ngaySinh = dateFormat.format(cnv.getNgaySinh());
				String[] rowData = { nv.getMaNhanVien(), nv.getCongNhanVien().getHoTen(), gioiTinh, ngaySinh,
						nv.getCongNhanVien().getMaCanCuocCongDan(), nv.getCongNhanVien().getSoDienThoai() };
				modelNhanVien.addRow(rowData);
			} else {

				String[] rowData = { nv.getMaNhanVien(), "", "", "", "", "" };
				modelNhanVien.addRow(rowData);
			}
		}

	}

	public void autoGenIdNhanVien() {
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT MAX(maNhanVien) AS maxNhanVien from NhanVien ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String maNhanVien = rs.getString("maxNhanVien");
				if (maNhanVien == null) {
					txtMaNhanVien.setText("NV001");
				} else {
					Long stt = Long.parseLong(maNhanVien.substring(2));
					stt++;
					txtMaNhanVien.setText("NV" + String.format("%03d", stt));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoaRong() {

		txtCMND.setText("");
		txtHoTen.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtLuongCoBan.setText("");
		dateChooserNgaySinh.setDate(null);
		java.util.Date currentDate = new java.util.Date();
		dateChooserNgayVaoLam.setDate(currentDate);
		rbtNam.setSelected(true);
		txtMaNhanVien.requestFocus();
		cbbChucVu.setSelectedIndex(0);
		cbbPhongBan.setSelectedIndex(0);
		cbbTrangThai.setSelectedIndex(0);
		cbbTrinhDo.setSelectedIndex(0);
		tbl_bangTen.clearSelection();
		autoGenIdNhanVien();
	}

	public void layDataVoComboBox() {
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT * from PhongBan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				cbbPhongBan.addItem(rs.getString("tenPhongBan"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean checkregex() {
		String cmnd = txtCMND.getText().trim();
		String hoTen = txtHoTen.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		java.util.Date today = new java.util.Date();
		Date ngaySinh = new Date(dateChooserNgaySinh.getDate().getTime());
		Date ngayVaoLam = new Date(dateChooserNgayVaoLam.getDate().getTime());
		
		// them try catch
		double luong = Double.parseDouble(txtLuongCoBan.getText().trim());

		if (!(cmnd.length() > 0 && cmnd.matches("^[0-9]{12}$"))) {
			JOptionPane.showMessageDialog(this, "Error : CMND phải có 12 số");
			return false;
		}
		if (!(luong >= 3000000)) {
			JOptionPane.showMessageDialog(this, "Error : Lương phải lớn hơn 3000000 ");
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("^0[0-9]{9}$"))) {
			JOptionPane.showMessageDialog(this, "Error : Số điện thoại bắt đầu từ số 0");
			return false;
		}
		if (!(hoTen.length() > 0 && hoTen.matches("^[\\p{L}\\s]+$"))) {
			JOptionPane.showMessageDialog(this, "Error : Họ tên phải là ký tự");
			return false;
		}
		if (!(diaChi.length() > 0 && diaChi.matches("^[\\p{L}\\d\\s.,]+$"))) {
			JOptionPane.showMessageDialog(this, "Error : Địa chỉ phải là ký tự");
			return false;
		}
		if (ngaySinh.after(today)
				|| (int) ((today.getTime() - ngaySinh.getTime()) / (1000 * 60 * 24 * 60 * 365)) < 18) {
			JOptionPane.showMessageDialog(null, "Ngày Sinh Không Hợp Lệ!!!");
			return false;
		}
		if (ngayVaoLam.after(today)) {
			JOptionPane.showMessageDialog(null, "Ngày Vào Làm Phải Trước Ngày Hiện Tại !!!");
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnXoaRong)) {
			xoaRong();
		} else if (o.equals(btnThem)) {
			if (checkregex()) {
				String chucVu = (String) cbbChucVu.getSelectedItem();
				String trinhDo = (String) cbbTrinhDo.getSelectedItem();
				double luongCoBan = Double.parseDouble(txtLuongCoBan.getText());

				String hoTen = txtHoTen.getText();
				boolean phai = false;
				if (G.getSelection() != null) {
					if (G.getSelection().equals(rbtNam.getModel())) {
						phai = true;
					} else if (G.getSelection().equals(rbtNu.getModel())) {
						phai = false;
					}
				}
				java.sql.Date ngaySinh = new java.sql.Date(dateChooserNgaySinh.getDate().getTime());

				String cmnd = txtCMND.getText();
				String sdt = txtSDT.getText();
				String diaChi = txtDiaChi.getText();
				boolean trangThai = true;
				if (cbbTrangThai.getSelectedItem().equals("Đang Làm")) {
					trangThai = true;
				} else if (cbbTrangThai.getSelectedItem().equals("Nghỉ Làm")) {
					trangThai = false;
				}

				java.sql.Date ngayVaoLam = new java.sql.Date(dateChooserNgayVaoLam.getDate().getTime());
				String tenPhongBan = (String) cbbPhongBan.getSelectedItem();
				PhongBan pb = dao_pb.getPhongBanTheoTen(tenPhongBan);

				CongNhanVien cnv = new CongNhanVien(hoTen, phai, ngaySinh, cmnd, sdt, diaChi, trangThai, ngayVaoLam);
				dao_cnv.taoCNV(cnv);
				CongNhanVien cnvNew = dao_cnv.getCongNhanVienMoiTao();
				NhanVien nv = new NhanVien(chucVu, trinhDo, luongCoBan, pb, cnvNew);
				dao_nv.taoNV(nv);

				String maNVNew = dao_nv.getMaNhanVienMoiTao();
				nv.setMaNhanVien(maNVNew);

				String gioiTinh;
				Boolean gt = nv.getCongNhanVien().isGioiTinh();
				boolean kiemTraGT = true;

				if (gt == kiemTraGT) {
					gioiTinh = "Nam";
				} else {
					gioiTinh = "Nữ";
				}
				String maPB = nv.getPhongBan().getMaPhongBan();
				if (maPB.equals("PB005") || maPB.equals("PB002")) {
					TaiKhoan tk = new TaiKhoan();
					tk.setTaiKhoan(nv.getMaNhanVien());
					tk.setMatKhau("123");
					try {
						dao_TaiKhoan.themTaiKhoan(tk);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				modelNhanVien.addRow(new Object[] { nv.getMaNhanVien(), nv.getCongNhanVien().getHoTen(), gioiTinh,
						nv.getCongNhanVien().getNgaySinh(), nv.getCongNhanVien().getMaCanCuocCongDan(),
						nv.getCongNhanVien().getSoDienThoai() });
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				xoaRong();
			}

		} else if (o.equals(btnSua)) {
			if (checkregex()) {
				int row = tbl_bangTen.getSelectedRow();
				if (row >= 0) {
					String chucVu = (String) cbbChucVu.getSelectedItem();
					String trinhDo = (String) cbbTrinhDo.getSelectedItem();
					double luongCoBan = Double.parseDouble(txtLuongCoBan.getText());
					String maNV = txtMaNhanVien.getText();

					String hoTen = txtHoTen.getText();
					boolean phai = false;
					if (G.getSelection() != null) {
						if (G.getSelection().equals(rbtNam.getModel())) {
							phai = true;
						} else if (G.getSelection().equals(rbtNu.getModel())) {
							phai = false;
						}
					}

					java.sql.Date ngaySinh = new java.sql.Date(dateChooserNgaySinh.getDate().getTime());
					String cmnd = txtCMND.getText();
					String sdt = txtSDT.getText();
					String diaChi = txtDiaChi.getText();
					boolean trangThai = true;
					if (cbbTrangThai.getSelectedItem().equals("Đang Làm")) {
						trangThai = true;
					} else if (cbbTrangThai.getSelectedItem().equals("Nghỉ Làm")) {
						trangThai = false;
					}
					java.sql.Date ngayVaoLam = new java.sql.Date(dateChooserNgayVaoLam.getDate().getTime());

					String maCNV = "";
					int[] selectedRow = tbl_bangTen.getSelectedRows();
					for (int selectedIndex : selectedRow) {
						if (selectedIndex >= 0 && selectedIndex < listnv.size()) {
							NhanVien nhanVienDuocChon = listnv.get(selectedIndex);
							CongNhanVien CNV = nhanVienDuocChon.getCongNhanVien();
							maCNV = CNV.getMaCongNhanVien();
						}
					}
					CongNhanVien cnv = new CongNhanVien(hoTen, phai, ngaySinh, cmnd, sdt, diaChi, trangThai, ngayVaoLam,
							maCNV);

					String tenPhongBan = (String) cbbPhongBan.getSelectedItem();
					PhongBan pb = dao_pb.getPhongBanTheoTen(tenPhongBan);

					NhanVien nv = new NhanVien(maNV, chucVu, trinhDo, luongCoBan, pb, cnv);
					if (dao_nv.update(nv, cnv, pb)) {

						tbl_bangTen.setValueAt(maNV, row, 0);
						tbl_bangTen.setValueAt(hoTen, row, 1);
						tbl_bangTen.setValueAt(phai, row, 2);
						tbl_bangTen.setValueAt(ngaySinh, row, 3);
						tbl_bangTen.setValueAt(cmnd, row, 4);
						tbl_bangTen.setValueAt(sdt, row, 5);
						JOptionPane.showMessageDialog(this, "Sửa thành công");
						updateTableDataNhanVien();
					}

				}

			}
		}

	}
}