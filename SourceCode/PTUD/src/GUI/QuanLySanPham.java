package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import Connection.MyConnection;
import DAO.DAO_NhanVien;
import DAO.DAO_SanPham;
import Entity.CongNhanVien;
import Entity.Dan;
import Entity.NhanVien;

public class QuanLySanPham extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelSanPham;
	private JTable tbl_BangSanPham;
	private JTextField txtMaSanPham;
	private JTextField txtGiaBan;
	private JTextField txtTenSanPham;
	private JTextField txtMoTa;
	private JButton btnThem,btnSua,btnXoaRong;
	private JComboBox cbbLoaiSanPham,cbbEoLung,cbbMatPhim,cbbKhoa,cbbNgua,cbbDay,cbbTrangThai,cbbMatDan,cbbCau;
	private List<Dan> listsp;
	private DAO_SanPham dao_sp;
	public QuanLySanPham() {
		
		dao_sp = new DAO_SanPham();
		setBackground(new Color(221, 242, 251));
		setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Sản Phẩm");
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
		
		tbl_BangSanPham = new JTable();
		TableColumnModel columnModel = tbl_BangSanPham.getColumnModel();
        columnModel.setColumnSelectionAllowed(false);
        columnModel.setColumnMargin(0);
        tbl_BangSanPham.getTableHeader().setReorderingAllowed(false);
		scrollPane_1.setViewportView(tbl_BangSanPham);

		
		String[] colHeader = { "Mã Sản Phẩm","Tên Sản Phảm","Loại Sản Phẩm","trạng Thái","Giá bán | VND |" };
		
		modelSanPham = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = { false, false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};


		tbl_BangSanPham.setModel(modelSanPham);
		
		tbl_BangSanPham.getTableHeader();
		tbl_BangSanPham.setBackground(new Color(151, 201, 219));
		tbl_BangSanPham.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
	    int rowMargin = 10;
	    tbl_BangSanPham.setRowHeight(rowHeight);
	    tbl_BangSanPham.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));
	    
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
	    lblMaSanPham.setBounds(20, 11, 133, 25);
	    panel_1.add(lblMaSanPham);
	    
	    txtMaSanPham = new JTextField();
	    txtMaSanPham.setBounds(163, 13, 305, 25);
	    txtMaSanPham.setEditable(false);
	    panel_1.add(txtMaSanPham);
	    txtMaSanPham.setColumns(10);
	    
	    JLabel lblGioiTinh = new JLabel("Loại Sản Phẩm ");
	    lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblGioiTinh.setBounds(20, 54, 133, 25);
	    panel_1.add(lblGioiTinh);
	    
	    JLabel lblCMND = new JLabel("Giá Bán | VND |");
	    lblCMND.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblCMND.setBounds(20, 99, 133, 25);
	    panel_1.add(lblCMND);
	    
	    JLabel lblPhongBan = new JLabel("Eo + Lưng");
	    lblPhongBan.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblPhongBan.setBounds(20, 148, 133, 25);
	    panel_1.add(lblPhongBan);
	    
	    JLabel lblChucVu = new JLabel("Mặt Phím");
	    lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblChucVu.setBounds(20, 196, 133, 25);
	    panel_1.add(lblChucVu);
	    
	    JLabel lblNgayVaoLam = new JLabel("Ngựa");
	    lblNgayVaoLam.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNgayVaoLam.setBounds(20, 246, 133, 25);
	    panel_1.add(lblNgayVaoLam);
	    
	    txtGiaBan = new JTextField();
	    txtGiaBan.setColumns(10);
	    txtGiaBan.setBounds(163, 100, 305, 27);
	    panel_1.add(txtGiaBan);
	    
	    JLabel lblDay = new JLabel("Dây");
	    lblDay.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblDay.setBounds(20, 285, 133, 25);
	    panel_1.add(lblDay);
	    
	     cbbLoaiSanPham = new JComboBox();
	     cbbLoaiSanPham.addItem("ACOUSTIC");
	     cbbLoaiSanPham.addItem("CLASSIC");
	    cbbLoaiSanPham.setEditable(true);
	    cbbLoaiSanPham.setBounds(163, 57, 305, 28);
	    panel_1.add(cbbLoaiSanPham);
	    
	     cbbEoLung = new JComboBox();
	    cbbEoLung.setEditable(true);
	    cbbEoLung.addItem("Gỗ cẩm Ấn");
	    cbbEoLung.addItem("Gỗ điệp Solid");
	    cbbEoLung.addItem("Gỗ hồng đào");
	    cbbEoLung.setBounds(163, 151, 305, 28);
	    panel_1.add(cbbEoLung);
	    
	     cbbMatPhim = new JComboBox();
	    cbbMatPhim.setEditable(true);
	    cbbMatPhim.addItem("Gỗ mật");
	    cbbMatPhim.addItem("Gỗ mun");
	    cbbMatPhim.addItem("Gỗ đen");
	    cbbMatPhim.setBounds(163, 199, 305, 28);
	    panel_1.add(cbbMatPhim);
	    
	     cbbDay = new JComboBox();
	    cbbDay.setEditable(true);
	    cbbDay.addItem("Alice A107");
	    cbbDay.addItem("Elixir");
	    cbbDay.addItem("Alice A206");
	    cbbDay.addItem("Alice AW432");
	    cbbDay.setBounds(163, 288, 305, 28);
	    panel_1.add(cbbDay);
	    
	     cbbNgua = new JComboBox();
	    cbbNgua.setEditable(true);
	    cbbNgua.addItem("Gỗ mật");
	    cbbNgua.addItem("Gỗ mun");
	    cbbNgua.addItem("Gỗ đen");
	    cbbNgua.setBounds(163, 249, 305, 28);
	    panel_1.add(cbbNgua);
	    
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
	    
	    txtTenSanPham = new JTextField();
	    txtTenSanPham.setColumns(10);
	    txtTenSanPham.setBounds(163, 28, 305, 25);
	    panel_1_2.add(txtTenSanPham);
	    
	    JLabel lblMoTa = new JLabel("Mô Tả");
	    lblMoTa.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblMoTa.setBounds(20, 76, 133, 25);
	    panel_1_2.add(lblMoTa);
	    
	    JLabel lblMatDan = new JLabel("Mặt Đàn");
	    lblMatDan.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblMatDan.setBounds(20, 128, 133, 25);
	    panel_1_2.add(lblMatDan);
	    
	    JLabel lblCan = new JLabel("Cầu");
	    lblCan.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblCan.setBounds(20, 175, 133, 25);
	    panel_1_2.add(lblCan);
	    
	    JLabel lblTrangThai = new JLabel("Trạng thái");
	    lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblTrangThai.setBounds(20, 220, 133, 25);
	    panel_1_2.add(lblTrangThai);
	    
	    JLabel lblKhoa = new JLabel("Khóa");
	    lblKhoa.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblKhoa.setBounds(20, 272, 133, 25);
	    panel_1_2.add(lblKhoa);
	    
	     cbbTrangThai = new JComboBox();
	    cbbTrangThai.setEditable(true);
	    cbbTrangThai.addItem("Đang Làm");
	    cbbTrangThai.addItem("Chưa Làm");
	    cbbTrangThai.setBounds(163, 220, 305, 28);
	    panel_1_2.add(cbbTrangThai);
	    
	    txtMoTa = new JTextField();
	    txtMoTa.setColumns(10);
	    txtMoTa.setBounds(163, 78, 305, 25);
	    panel_1_2.add(txtMoTa);
	    
	     cbbMatDan = new JComboBox();
	    cbbMatDan.setEditable(true);
	    cbbMatDan.addItem("Gỗ thông sitka");
	    cbbMatDan.addItem("Thông Cedar");
	    cbbMatDan.addItem("Gỗ thông sitka");
	    cbbMatDan.setBounds(163, 131, 305, 28);
	    panel_1_2.add(cbbMatDan);
	    
	     cbbCau = new JComboBox();
	    cbbCau.setEditable(true);
	    cbbCau.addItem("Gỗ thao lao");
	    cbbCau.addItem("Gỗ giá ty");
	    cbbCau.setBounds(163, 178, 305, 28);
	    panel_1_2.add(cbbCau);
	    
	     cbbKhoa = new JComboBox();
	    cbbKhoa.setEditable(true);
	    cbbKhoa.addItem("Đài Loan");
	    cbbKhoa.addItem("Nhật Bản");
	    cbbKhoa.setBounds(163, 275, 305, 28);
	    panel_1_2.add(cbbKhoa);
	    
	    	     btnThem = new JButton("New button");
	    	    btnThem.setBounds(473, 394, 120, 30);    	    
	    	    btnThem.setForeground(Color.WHITE);
	    	    btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
	    	    btnThem.setBackground(new Color(0, 128, 255));
	    	    btnThem.setText("Thêm");
	    	    panel.add(btnThem);
	    	    
	    	     btnSua = new JButton("New button");   	   
	    	    btnSua.setBounds(649, 394, 120, 30);  
	    	    btnSua.setBackground(new Color(0, 128, 255));
	    	    btnSua.setForeground(Color.WHITE);
	    	    btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
	    	    btnSua.setText("Sửa thông tin");
	    	    panel.add(btnSua);
	    	    
	    	    
	    	     btnXoaRong = new JButton("New button");
	    	    btnXoaRong.setBounds(827, 394, 120, 30);
	    	    btnXoaRong.setForeground(Color.WHITE);
	    	    btnXoaRong.setBackground(new Color(0, 128, 255));
	    	    btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
	    	    btnXoaRong.setText("Xoá rỗng");
	    	    panel.add(btnXoaRong);
	    	    
	    	    
	    	    btnSua.addActionListener(this);
	    	    btnThem.addActionListener(this);
	    	    btnXoaRong.addActionListener(this);
	    	    
	    	    MyConnection.getInstance().MyConnection();
	    	    autoGenIdSanPham();
	    		updateTableDataSanPham();
	}
	
	private void updateTableDataSanPham() {
		listsp = dao_sp.docTuBang();
		
		modelSanPham.setRowCount(0);
		DAO_SanPham dsSanPham = new DAO_SanPham();
		listsp = dsSanPham.docTuBang();
		for (Dan dan : listsp) {
			Boolean tt = dan.isTrangThai();
			boolean ktraTT = true;
			String trangThai;
			if (tt == ktraTT) {
				trangThai = "Đang làm";
			}
			else {
				trangThai = "Chưa làm";
			}
			
			
			String[] rowData = { dan.getMaSanPham(), dan.getTenSanPham(),dan.getLoaiSanPham(),trangThai, String.valueOf(dan.getGiaBan())};
			modelSanPham.addRow(rowData);
		}


	}
	public void xoaRong() {
		txtMaSanPham.setText("");
		txtTenSanPham.setText("");
		txtGiaBan.setText("");
		txtMoTa.setText("");
		cbbEoLung.setSelectedItem(null);
		cbbCau.setSelectedItem(null);
		cbbDay.setSelectedItem(null);
		cbbKhoa.setSelectedItem(null);
		cbbLoaiSanPham.setSelectedItem(null);
		cbbMatDan.setSelectedItem(null);
		cbbMatPhim.setSelectedItem(null);
		cbbNgua.setSelectedItem(null);
		cbbTrangThai.setSelectedItem(null);
		txtMaSanPham.requestFocus();
		autoGenIdSanPham();
	}
	public void autoGenIdSanPham() {
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT MAX(maSanPham) AS maxSanPham from Dan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String maSanPham = rs.getString("maxSanPham");
				if (maSanPham == null) {
					txtMaSanPham.setText("SP001");
				} else {
					Long stt = Long.parseLong(maSanPham.substring(2));
					stt++;
					txtMaSanPham.setText("SP" + String.format("%03d", stt));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnXoaRong)) {
			xoaRong();
		} else if (o.equals(btnThem)) {
			String tenSP = txtTenSanPham.getText();
			String mota = txtMoTa.getText();
			double giaBan = Double.parseDouble(txtGiaBan.getText());
			String loaiSP = (String) cbbLoaiSanPham.getSelectedItem();
			String matDan = (String) cbbMatDan.getSelectedItem();
			String eoLung = (String) cbbEoLung.getSelectedItem();
			String can = (String) cbbCau.getSelectedItem();
			String matPhim = (String) cbbMatPhim.getSelectedItem();		
			String day = (String) cbbDay.getSelectedItem();
			String khoa = (String) cbbKhoa.getSelectedItem();
			String ngua = (String) cbbNgua.getSelectedItem();
			boolean trangThai = true;
			if (cbbTrangThai.toString().equals("Đang Làm")) {
				trangThai = true;
			} else if (cbbTrangThai.toString().equals("Chưa Làm")) {
				trangThai = false;
			}
			Dan dan = new Dan(tenSP,loaiSP,mota,giaBan,matDan,eoLung,can,matPhim,day,khoa,ngua,trangThai);
			dao_sp.taoSP(dan);
			modelSanPham.addRow(new Object[] {dan.getMaSanPham(),dan.getTenSanPham(),
					dan.getLoaiSanPham(),dan.isTrangThai(),dan.getGiaBan()});
			xoaRong();
			
		}
		
	}

}
