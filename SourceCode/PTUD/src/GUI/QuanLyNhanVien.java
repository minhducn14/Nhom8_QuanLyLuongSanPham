package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.toedter.calendar.JDateChooser;

import Connection.MyConnection;
import DAO.DAO_CongNhanVien;
import DAO.DAO_NhanVien;
import DAO.DAO_PhongBan;
import Entity.CongNhanVien;
import Entity.NhanVien;
import Entity.PhongBan;

public class QuanLyNhanVien extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelNhanVien;
	private JTable tbl_bangTen;
	private JTextField txtMaNhanVien;
	private JTextField txtCMND;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtLuongCoBan;
	private JRadioButton rbtNam,rbtNu;
	private JButton btnThem,btnXoaRong,btnSua;
	private JComboBox cbbPhongBan,cbbChucVu,cbbTrinhDo,cbbTrangThai;
	private JDateChooser dateChooserNgayVaoLam,dateChooserNgaySinh;
	private ButtonGroup G;
	
	private DAO_NhanVien dao_nv;
	private DAO_CongNhanVien dao_cnv;
	private DAO_PhongBan dao_pb;
	public QuanLyNhanVien() {
		setBackground(new Color(221, 242, 251));
		setLayout(null);

		dao_nv = new DAO_NhanVien();
		dao_cnv = new DAO_CongNhanVien();
		dao_pb = new DAO_PhongBan();
		
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
		scrollPane_1.setViewportView(tbl_bangTen);
		

		String[] colHeader = {"Mã Nhân Viên", "Họ tên nhân viên", "Giới Tính", "Ngày Sinh", "CMND", "SDT"};
		modelNhanVien = new DefaultTableModel(colHeader,0);
		tbl_bangTen.setModel(modelNhanVien);
		
		JTableHeader tbBangLuong= tbl_bangTen.getTableHeader();
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

		JLabel lblNewLabel = new JLabel("Thông tin nhân viên");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(54, 11, 256, 25);
		panel.add(lblNewLabel);

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

		G =new ButtonGroup();
		G.add(rbtNam);
		G.add(rbtNu);

		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(163, 100, 305, 27);
		panel_1.add(txtCMND);

		cbbPhongBan = new JComboBox();
		cbbPhongBan.setEditable(true);
		cbbPhongBan.setBounds(163, 143, 305, 28);
		panel_1.add(cbbPhongBan);

		cbbChucVu = new JComboBox();
		cbbChucVu.setEditable(true);
		cbbChucVu.setBounds(163, 187, 305, 28);
		cbbChucVu.addItem("Nhân Viên");
		cbbChucVu.addItem("Phó Phòng");
		cbbChucVu.addItem("Trưởng Phòng");
		panel_1.add(cbbChucVu);

		JTextField txtHeSoLuong = new JTextField();
		txtHeSoLuong.setText("2.41");
		txtHeSoLuong.setEditable(false);
		//double a = xacDinhHeSoLuongBanDau();
		
		txtHeSoLuong.setBounds(163, 275, 305, 28);
		panel_1.add(txtHeSoLuong);

		 dateChooserNgayVaoLam = new JDateChooser();
		dateChooserNgayVaoLam.setBounds(163, 231, 305, 28);
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

		 cbbTrangThai = new JComboBox();
		cbbTrangThai.setEditable(true);
		cbbTrangThai.setBounds(163, 187, 305, 28);
		cbbTrangThai.addItem("True");
		cbbTrangThai.addItem("False");
		panel_1_2.add(cbbTrangThai);

		 cbbTrinhDo = new JComboBox();
		cbbTrinhDo.setEditable(true);
		cbbTrinhDo.addItem("Đại học");
		cbbTrinhDo.addItem("Cao đẳng");
		cbbTrinhDo.setBounds(163, 231, 305, 28);
		cbbTrinhDo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				 if (e.getStateChange() == ItemEvent.SELECTED) {
					 String TrinhDoDuocChon = (String)cbbTrinhDo.getSelectedItem();
					 if ("Đại Học".equalsIgnoreCase(TrinhDoDuocChon)) {
			                
			                double heSoLuong = 2.41;

			               
			                txtHeSoLuong.setText(String.valueOf(heSoLuong));
			            } else {
			            	double heSoLuong = 2.1;
			                txtHeSoLuong.setText(String.valueOf(heSoLuong));
			            }
			        
				 }
				
			}
		});
		panel_1_2.add(cbbTrinhDo);

		 dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setBounds(163, 52, 305, 28);
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
		
		MyConnection.getInstance().MyConnection();
		layDataVoComboBox();
		autoGenIdNhanVien();
		updateTableDataNhanVien();
		
	}
	private void updateTableDataNhanVien() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

		DAO_NhanVien dsNhanVien = new DAO_NhanVien();
		DAO_CongNhanVien dsCongNhanVien = new DAO_CongNhanVien();
		DAO_PhongBan dsPhongBan = new DAO_PhongBan();
		List<NhanVien> listnv = dsNhanVien.docTuBang();
		List<CongNhanVien> listcnv = dsCongNhanVien.docTuBang();
		List<PhongBan> listpb = dsPhongBan.docTuBang();
		for (NhanVien nv : listnv) {
			for (CongNhanVien cnv : listcnv) {
				for(PhongBan pb : listpb) {
				String [] rowData = {nv.getMaNhanVien(),
						cnv.getHoTen(),
						String.valueOf(cnv.isGioiTinh()),
						String.valueOf(cnv.getNgaySinh()),
						cnv.getMaCanCuocCongDan(),
						cnv.getSoDienThoai()					
						};
			modelNhanVien.addRow(rowData);

			}
			
			}
		}	 
	}
	public void autoGenIdNhanVien() {
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT MAX(maNhanVien) AS maxNhanVien from NhanVien ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				String maNhanVien = rs.getString("maxNhanVien");
				if(maNhanVien == null) {
					txtMaNhanVien.setText("NV001");
				}
				else {
					 Long stt = Long.parseLong(maNhanVien.substring(2));
				        stt++;
				        txtMaNhanVien.setText("NV" + String.format("%03d", stt));
				}
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void xoaRong() {
		txtMaNhanVien.setText("");
		txtCMND.setText("");
		txtHoTen.setText(""); 
		txtSDT.setText(""); 
		txtDiaChi.setText("");
		txtLuongCoBan.setText("");
		rbtNam.isSelected();
		txtMaNhanVien.requestFocus();
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
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if(o.equals(btnXoaRong)) {
			xoaRong();
		}
		else if (o.equals(btnThem)) {	

			
				String chucVu = (String) cbbChucVu.getSelectedItem();
				String trinhDo = (String) cbbTrinhDo.getSelectedItem();
				double luongCoBan = Double.parseDouble(txtLuongCoBan.getText());
				
				String tenPhongBan = (String) cbbPhongBan.getSelectedItem();
				
				
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
				boolean trangThai=true; 	
			    if (cbbTrangThai.equals("True")) {
			        trangThai = true; 
			    } else if (cbbTrangThai.equals("False")) {
			        trangThai = false; 
			    }
			    java.sql.Date ngayVaoLam = new java.sql.Date(dateChooserNgayVaoLam.getDate().getTime());
				
			   
				CongNhanVien cnv  = new CongNhanVien(hoTen,phai,ngaySinh,cmnd,sdt,diaChi,trangThai,ngayVaoLam);
				PhongBan pb = new PhongBan(tenPhongBan);
				NhanVien nv = new NhanVien(chucVu,trinhDo,luongCoBan,pb,cnv);
				
				
				dao_pb.taoPB(pb);
				dao_cnv.taoCNV(cnv);
				dao_nv.taoNV(nv);

				((DefaultTableModel) tbl_bangTen.getModel()).addRow(new Object[] { nv.getMaNhanVien(), 
						nv.getCongNhanVien().getHoTen(), nv.getCongNhanVien().isGioiTinh(), nv.getCongNhanVien().getNgaySinh(), nv.getCongNhanVien().getMaCanCuocCongDan(), nv.getCongNhanVien().getSoDienThoai() });
			
			
		}

	}
}
