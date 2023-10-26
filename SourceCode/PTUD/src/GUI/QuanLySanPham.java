package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;


import com.toedter.calendar.JDateChooser;

public class QuanLySanPham extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable tbl_BangLuong;
	private JTextField txtMaNhanVien;
	private JTextField txtCMND;
	private JTextField txtHoTen;
	private JTextField textField;
	public QuanLySanPham() {
		setBackground(new Color(221, 242, 251));
		setLayout(null);
		
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
		
		JLabel lbldanhSachSanPham = new JLabel("Danh sách Sản Phẩm");
		lbldanhSachSanPham.setForeground(new Color(0, 27, 72));
		lbldanhSachSanPham.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbldanhSachSanPham.setBounds(30, 10, 340, 25);
		panel_1_1.add(lbldanhSachSanPham);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 41, 1376, 106);
		panel_1_1.add(scrollPane_1);
		
		tbl_BangLuong = new JTable();
		scrollPane_1.setViewportView(tbl_BangLuong);
		tbl_BangLuong.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
		    		"Mã Sản Phẩm","Tên Sản Phảm","Loại Sản Phẩm","trạng Thái","Giá bán | VND |"
		    	}
		));
		
		JTableHeader tbBangLuong= tbl_BangLuong.getTableHeader();
		tbBangLuong.setBackground(new Color(151, 201, 219));
		tbBangLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
	    int rowMargin = 10;
	    tbl_BangLuong.setRowHeight(rowHeight);
	    tbl_BangLuong.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));
	    
	    JPanel panel = new JPanel();
	    panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    panel.setBackground(new Color(255, 255, 255));
	    panel.setBounds(15, 69, 1420, 438);
	    add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblThongTinSanPham = new JLabel("Thông tin sản phẩm");
	    lblThongTinSanPham.setHorizontalAlignment(SwingConstants.CENTER);
	    lblThongTinSanPham.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblThongTinSanPham.setBounds(54, 11, 256, 25);
	    panel.add(lblThongTinSanPham);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    panel_1.setBackground(new Color(255, 255, 255));
	    panel_1.setBounds(10, 47, 684, 336);
	    panel.add(panel_1);
	    panel_1.setLayout(null);
	    
	    JLabel lblMaSanPham = new JLabel("Mã Sản Phẩm");
	    lblMaSanPham.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblMaSanPham.setBounds(20, 24, 133, 25);
	    panel_1.add(lblMaSanPham);
	    
	    txtMaNhanVien = new JTextField();
	    txtMaNhanVien.setBounds(163, 26, 305, 25);
	    panel_1.add(txtMaNhanVien);
	    txtMaNhanVien.setColumns(10);
	    
	    JLabel lblGioiTinh = new JLabel("Loại Sản Phẩm ");
	    lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblGioiTinh.setBounds(20, 75, 133, 25);
	    panel_1.add(lblGioiTinh);
	    
	    JLabel lblCMND = new JLabel("Giá Bán | VND |");
	    lblCMND.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblCMND.setBounds(20, 124, 133, 25);
	    panel_1.add(lblCMND);
	    
	    JLabel lblPhongBan = new JLabel("Eo + Lưng");
	    lblPhongBan.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblPhongBan.setBounds(20, 174, 133, 25);
	    panel_1.add(lblPhongBan);
	    
	    JLabel lblChucVu = new JLabel("Mặt Phím");
	    lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblChucVu.setBounds(20, 225, 133, 25);
	    panel_1.add(lblChucVu);
	    
	    JLabel lblNgayVaoLam = new JLabel("Ngựa");
	    lblNgayVaoLam.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNgayVaoLam.setBounds(20, 276, 133, 25);
	    panel_1.add(lblNgayVaoLam);
	    
	    txtCMND = new JTextField();
	    txtCMND.setColumns(10);
	    txtCMND.setBounds(163, 125, 305, 27);
	    panel_1.add(txtCMND);
	    
	    JComboBox cbbPhongBan = new JComboBox();
	    cbbPhongBan.setEditable(true);
	    cbbPhongBan.setBounds(163, 174, 305, 28);
	    panel_1.add(cbbPhongBan);
	    
	    JComboBox cbbChucVu = new JComboBox();
	    cbbChucVu.setEditable(true);
	    cbbChucVu.setBounds(163, 225, 305, 28);
	    panel_1.add(cbbChucVu);
	    
	    JComboBox txtHeSoLuong = new JComboBox();
	    txtHeSoLuong.setEditable(true);
	    txtHeSoLuong.setBounds(163, 276, 305, 28);
	    panel_1.add(txtHeSoLuong);
	    
	    JComboBox cbbPhongBan_1 = new JComboBox();
	    cbbPhongBan_1.setEditable(true);
	    cbbPhongBan_1.setBounds(163, 75, 305, 28);
	    panel_1.add(cbbPhongBan_1);
	    
	    JPanel panel_1_2 = new JPanel();
	    panel_1_2.setLayout(null);
	    panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    panel_1_2.setBackground(Color.WHITE);
	    panel_1_2.setBounds(720, 47, 684, 336);
	    panel.add(panel_1_2);
	    
	    JLabel lblTenSamPham = new JLabel("Tên Sản Phẩm");
	    lblTenSamPham.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblTenSamPham.setBounds(20, 26, 133, 25);
	    panel_1_2.add(lblTenSamPham);
	    
	    txtHoTen = new JTextField();
	    txtHoTen.setColumns(10);
	    txtHoTen.setBounds(163, 28, 305, 25);
	    panel_1_2.add(txtHoTen);
	    
	    JLabel lblMoTa = new JLabel("Mô Tả");
	    lblMoTa.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblMoTa.setBounds(20, 76, 133, 25);
	    panel_1_2.add(lblMoTa);
	    
	    JLabel lblMatDan = new JLabel("Mặt Đàn");
	    lblMatDan.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblMatDan.setBounds(20, 128, 133, 25);
	    panel_1_2.add(lblMatDan);
	    
	    JLabel lblCau = new JLabel("Cầu");
	    lblCau.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblCau.setBounds(20, 175, 133, 25);
	    panel_1_2.add(lblCau);
	    
	    JLabel lblTrangThai = new JLabel("Trạng thái");
	    lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblTrangThai.setBounds(20, 220, 133, 25);
	    panel_1_2.add(lblTrangThai);
	    
	    JLabel lblKhoa = new JLabel("Khóa");
	    lblKhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblKhoa.setBounds(20, 272, 133, 25);
	    panel_1_2.add(lblKhoa);
	    
	    JComboBox cbbTrangThai = new JComboBox();
	    cbbTrangThai.setEditable(true);
	    cbbTrangThai.setBounds(163, 220, 305, 28);
	    panel_1_2.add(cbbTrangThai);
	    
	    JComboBox cbbTrinhDo = new JComboBox();
	    cbbTrinhDo.setEditable(true);
	    cbbTrinhDo.setBounds(163, 272, 305, 28);
	    panel_1_2.add(cbbTrinhDo);
	    
	    textField = new JTextField();
	    textField.setColumns(10);
	    textField.setBounds(163, 78, 305, 25);
	    panel_1_2.add(textField);
	    
	    JComboBox cbbTrangThai_1 = new JComboBox();
	    cbbTrangThai_1.setEditable(true);
	    cbbTrangThai_1.setBounds(163, 175, 305, 28);
	    panel_1_2.add(cbbTrangThai_1);
	    
	    JComboBox cbbTrangThai_2 = new JComboBox();
	    cbbTrangThai_2.setEditable(true);
	    cbbTrangThai_2.setBounds(163, 128, 305, 28);
	    panel_1_2.add(cbbTrangThai_2);
	    
	    	    JButton btnThem = new JButton("New button");
	    	    btnThem.setBounds(473, 394, 120, 30);    	    
	    	    btnThem.setForeground(Color.WHITE);
	    	    btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
	    	    btnThem.setBackground(new Color(0, 128, 255));
	    	    btnThem.setText("Thêm");
	    	    panel.add(btnThem);
	    	    
	    	    JButton btnSua = new JButton("New button");   	   
	    	    btnSua.setBounds(649, 394, 120, 30);  
	    	    btnSua.setBackground(new Color(0, 128, 255));
	    	    btnSua.setForeground(Color.WHITE);
	    	    btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
	    	    btnSua.setText("Sửa thông tin");
	    	    panel.add(btnSua);
	    	    
	    	    
	    	    JButton btnXoaRong = new JButton("New button");
	    	    btnXoaRong.setBounds(827, 394, 120, 30);
	    	    btnXoaRong.setForeground(Color.WHITE);
	    	    btnXoaRong.setBackground(new Color(0, 128, 255));
	    	    btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
	    	    btnXoaRong.setText("Xoá rỗng");
	    	    panel.add(btnXoaRong);
	}
}
