package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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

import com.toedter.calendar.JDateChooser;

import Connection.MyConnection;
import DAO.DAO_CongNhanVien;
import DAO.DAO_ThoLamDan;
import Entity.CongNhanVien;
import Entity.ThoLamDan;
import datechooser.model.multiple.Period;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ItemEvent;

public class QuanLyThoLamDan extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modalThoLamDan;
	private JTextField jmaTLD;
	private JTextField jcmnd;
	private JTextField jhoTen;
	private JTextField jsdt;
	private JTextField textField_5;
	private JTextField jdiaChi;
	private JRadioButton rdbtnNewRadioButton_5,rdbtnNewRadioButton_4;
	private JDateChooser jngayVaoLam, jngaySinh;
	private ButtonGroup buttonGroup;
	private JButton btnThem, btnXoaRong, btnSua;
	private JComboBox<String> jtayNghe, jtrangThai;
	private DAO_CongNhanVien dao_cnv;
	private DAO_ThoLamDan dao_tld;
	public QuanLyThoLamDan() {
		
		dao_cnv = new DAO_CongNhanVien();
		dao_tld = new DAO_ThoLamDan();
		setLayout(null);
		setBackground(new Color(221, 242, 251));
	    
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setBounds(325, 5, 800, 70);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
	    add(lblNewLabel);
	    lblNewLabel.setText("THỢ LÀM ĐÀN");
	    
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
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(20, 10, 1380, 180);
	    panel_2.add(scrollPane_1);
	    
	    JTable table_1 = new JTable();
	    scrollPane_1.setViewportView(table_1);
	    JTableHeader tb1 = table_1.getTableHeader();
	    tb1.setBackground(new Color(221, 242, 251));
	    tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    table_1.setRowHeight(30);
	    table_1.setIntercellSpacing(new Dimension(0, 5));
	    
//	    table_1.setModel(new DefaultTableModel(
//	    	new Object[][] {
//	    		{null, null, null, null, null, null},
//	    		{null, null, null, null, null, null},
//	    		{null, null, null, null, null, null},
//	    		{null, null, null, null, null, null},
//	    		{null, null, null, null, null, null},
//	    	},
//	    	new String[] {
//	    		"M\u00E3 th\u1EE3 l\u00E0m \u0111\u00E0n", "H\u1ECD t\u00EAn th\u1EE3 l\u00E0m \u0111\u00E0n", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "CMND", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
//	    	}
//	    ));

		String[] colHeader = {"Mã Thợ Làm Đàn", "Họ Tên Thợ Làm Đàn", "Giới Tính", "Ngày Sinh", "CMND", "SDT"};
		modalThoLamDan = new DefaultTableModel(colHeader,0);
		table_1.setModel(modalThoLamDan);
	    
	    JLabel lblNewLabel_6 = new JLabel("New label");
	    lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_6.setBounds(50, 450, 283, 25);
	    add(lblNewLabel_6);
	    lblNewLabel_6.setText("Danh sách thợ làm đàn");
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.WHITE);
	    panel.setBounds(15, 90, 1420, 315);
	    add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblNewLabel_6_1 = new JLabel("Thông tin thợ làm đàn");
	    lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_6_1.setBounds(35, 15, 304, 25);
	    panel.add(lblNewLabel_6_1);
	    
	  
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(new Color(255, 255, 255));
	    panel_1.setBounds(91, 50, 560, 25);
	    panel.add(panel_1);
	    panel_1.setLayout(null);
	    
	    JLabel lblNewLabel_1 = new JLabel("Mã thợ làm đàn:");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1.setBounds(31, 0, 140, 25);
	    panel_1.add(lblNewLabel_1);
	    
	    jmaTLD = new JTextField();
	    jmaTLD.setEditable(false);
	    jmaTLD.setBounds(180, 0, 380, 25);
	    panel_1.add(jmaTLD);
	    jmaTLD.setColumns(10);
	    
	    JPanel panel_1_1 = new JPanel();
	    panel_1_1.setLayout(null);
	    panel_1_1.setBackground(Color.WHITE);
	    panel_1_1.setBounds(91, 130, 560, 25);
	    panel.add(panel_1_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("CMND:");
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_1.setBounds(31, 0, 140, 25);
	    panel_1_1.add(lblNewLabel_1_1);
	    
	    jcmnd = new JTextField();
	    jcmnd.setColumns(10);
	    jcmnd.setBounds(180, 0, 380, 25);
	    panel_1_1.add(jcmnd);
	    
	    JPanel panel_1_2 = new JPanel();
	    panel_1_2.setLayout(null);
	    panel_1_2.setBackground(Color.WHITE);
	    panel_1_2.setBounds(759, 50, 560, 25);
	    panel.add(panel_1_2);
	    
	    JLabel lblNewLabel_1_2 = new JLabel("Họ tên:");
	    lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_2.setBounds(31, 0, 140, 25);
	    panel_1_2.add(lblNewLabel_1_2);
	    
	    jhoTen = new JTextField();
	    jhoTen.setColumns(10);
	    jhoTen.setBounds(180, 0, 380, 25);
	    panel_1_2.add(jhoTen);
	    
	    JPanel panel_1_3 = new JPanel();
	    panel_1_3.setLayout(null);
	    panel_1_3.setBackground(Color.WHITE);
	    panel_1_3.setBounds(759, 130, 560, 25);
	    panel.add(panel_1_3);
	    
	    JLabel lblNewLabel_1_3 = new JLabel("Số điện thoại:");
	    lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_3.setBounds(31, 0, 140, 25);
	    panel_1_3.add(lblNewLabel_1_3);
	    
	    jsdt = new JTextField();
	    jsdt.setColumns(10);
	    jsdt.setBounds(180, 0, 380, 25);
	    panel_1_3.add(jsdt);
	    
	    JPanel panel_1_4 = new JPanel();
	    panel_1_4.setBackground(Color.WHITE);
	    panel_1_4.setBounds(91, 90, 560, 25);
	    panel.add(panel_1_4);
	    panel_1_4.setLayout(null);
	    

	    
	    JLabel lblNewLabel_4 = new JLabel("Giới tính:");
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_4.setBounds(32, 0, 93, 25);
	    panel_1_4.add(lblNewLabel_4);
	    
	    rdbtnNewRadioButton_5 = new JRadioButton("");
	    rdbtnNewRadioButton_5.setSelected(true);
	    rdbtnNewRadioButton_5.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_5.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_5.setBounds(187, 0, 25, 25);
	    panel_1_4.add(rdbtnNewRadioButton_5);
	    
	    JLabel lblNewLabel_3 = new JLabel("Nam");
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_3.setBounds(218, 0, 93, 25);
	    panel_1_4.add(lblNewLabel_3);
	    
	    rdbtnNewRadioButton_4 = new JRadioButton("");
//	    rdbtnNewRadioButton_4.addItemListener(new ItemListener() {
//	    	public void itemStateChanged(ItemEvent e) {
//	    		if(e.getStateChange()==ItemEvent.SELECTED) {
//	    			rdbtnNewRadioButton_5.setSelected(false);
//	    		}
//	    	}
//	    });
	    rdbtnNewRadioButton_4.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_4.setBounds(373, 0, 25, 25);
	    panel_1_4.add(rdbtnNewRadioButton_4);
	    
	    JLabel lblNewLabel_2 = new JLabel("Nữ");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_2.setBounds(404, 0, 93, 25);
	    panel_1_4.add(lblNewLabel_2);
	    
	    buttonGroup = new ButtonGroup();
	    buttonGroup.add(rdbtnNewRadioButton_4);
	    buttonGroup.add(rdbtnNewRadioButton_5);
	    
	    
	    
	    JPanel panel_1_5 = new JPanel();
	    panel_1_5.setLayout(null);
	    panel_1_5.setBackground(Color.WHITE);
	    panel_1_5.setBounds(91, 170, 560, 25);
	    panel.add(panel_1_5);
	    
	    JLabel lblNewLabel_1_4 = new JLabel("Tay nghề:");
	    lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_4.setBounds(31, 0, 140, 25);
	    panel_1_5.add(lblNewLabel_1_4);
	    
	    String[] trinhDo = {"Bậc 1","Bậc 2","Bậc 3","Bậc 4","Bậc 5"};
        jtayNghe = new JComboBox<>(trinhDo);
	    jtayNghe.setBounds(180, 0, 380, 25);
	    panel_1_5.add(jtayNghe);
	    
//	    JComboBox jtayNghe = new JComboBox();
//	    jtayNghe.addItem("Bac 1");
//	    jtayNghe.addItem("Bac 2");
//	    jtayNghe.setBounds(180,0,380,25);
//	    panel_1_5.add(jtayNghe);
	    
	    JPanel panel_1_6 = new JPanel();
	    panel_1_6.setLayout(null);
	    panel_1_6.setBackground(Color.WHITE);
	    panel_1_6.setBounds(91, 210, 560, 25);
	    panel.add(panel_1_6);
	    
	    JLabel lblNewLabel_1_5 = new JLabel("Ngày vào làm:");
	    lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_5.setBounds(31, 0, 140, 25);
	    panel_1_6.add(lblNewLabel_1_5);
	    
	    jngayVaoLam = new JDateChooser();
	    jngayVaoLam.setLocation(180, 0);
	    jngayVaoLam.setSize(380, 25);
	    panel_1_6.add(jngayVaoLam);
	    
	    JPanel panel_1_7 = new JPanel();
	    panel_1_7.setLayout(null);
	    panel_1_7.setBackground(Color.WHITE);
	    panel_1_7.setBounds(759, 170, 560, 25);
	    panel.add(panel_1_7);
	    
	    JLabel lblNewLabel_1_6 = new JLabel("Địa chỉ:");
	    lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_6.setBounds(31, 0, 140, 25);
	    panel_1_7.add(lblNewLabel_1_6);
	    
	    jdiaChi = new JTextField();
	    jdiaChi.setColumns(10);
	    jdiaChi.setBounds(180, 0, 380, 25);
	    panel_1_7.add(jdiaChi);
	    
	    JPanel panel_1_8 = new JPanel();
	    panel_1_8.setLayout(null);
	    panel_1_8.setBackground(Color.WHITE);
	    panel_1_8.setBounds(759, 90, 560, 25);
	    panel.add(panel_1_8);
	    
	    JLabel lblNewLabel_1_7 = new JLabel("Ngày sinh:");
	    lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_7.setBounds(31, 0, 140, 25);
	    panel_1_8.add(lblNewLabel_1_7);
	    
	    jngaySinh = new JDateChooser();
	    jngaySinh.setBounds(180, 0, 380, 25);
	    panel_1_8.add(jngaySinh);
	    
	    JPanel panel_1_9 = new JPanel();
	    panel_1_9.setLayout(null);
	    panel_1_9.setBackground(Color.WHITE);
	    panel_1_9.setBounds(759, 210, 560, 25);
	    panel.add(panel_1_9);
	    
	    JLabel lblNewLabel_1_8 = new JLabel("Trạng thái:");
	    lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_8.setBounds(31, 0, 140, 25);
	    panel_1_9.add(lblNewLabel_1_8);
	    
//	    String[] trangThai = {"Đang làm","Nghỉ việc"};
        jtrangThai = new JComboBox<>();
        jtrangThai.addItem("Đang làm");
        jtrangThai.addItem("Nghỉ việc");
	    jtrangThai.setBounds(180, 0, 380, 25);
	    panel_1_9.add(jtrangThai);
	    
	    //Xóa
	    btnSua = new JButton("Sửa thông tin");
	    btnXoaRong = new JButton("Xoá rỗng");
	    btnXoaRong.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int row = table_1.getSelectedRow();
	    		if(row==-1) {
	    			JOptionPane.showMessageDialog(null, "Vui lòng chọn thợ làm đàn để xóa");
	    		} else if(row!=-1){
	    			int option = JOptionPane.showConfirmDialog(null,  "Bạn có muốn xóa thợ làm đàn này không?","Xóa hàng trống",JOptionPane.YES_NO_OPTION);
	    			if(option == JOptionPane.YES_OPTION) {
	    				((DefaultTableModel) table_1.getModel()).removeRow(row);
	    			}
	    	}
	    	}
	    });
	    btnXoaRong.setForeground(Color.WHITE);
	    btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnXoaRong.setBackground(new Color(2, 104, 156));
	    btnXoaRong.setBounds(900, 260, 170, 40);
	    panel.add(btnXoaRong);
	    
	    //Sửa thông tin
//	    JButton btnTmKim = new JButton("Sửa thông tin");
	    btnSua.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnSua.setForeground(Color.WHITE);
	    btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnSua.setBackground(new Color(2, 104, 156));
	    btnSua.setBounds(625, 260, 170, 40);
	    panel.add(btnSua);
	    
	    
	    
	    //Thêm
	    
	    btnThem= new JButton("Thêm");
	    btnThem.setForeground(Color.WHITE);
	    btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnThem.setBackground(new Color(2, 104, 156));
	    btnThem.setBounds(350, 260, 170, 40);
	    panel.add(btnThem);
	    
	    btnThem.addActionListener(this);
	    btnXoaRong.addActionListener(this);
	    
	    MyConnection.getInstance().MyConnection();
	    autoGenIdThoLamDan();
	    updateTableDataNhanVien();
	}
	
	private void updateTableDataNhanVien() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		DAO_ThoLamDan dsThoLamDan = new DAO_ThoLamDan();
		DAO_CongNhanVien dsCongNhanVien = new DAO_CongNhanVien();

		List<ThoLamDan> listtld = dsThoLamDan.docTuBang();
		List<CongNhanVien> listcnv = dsCongNhanVien.docTuBang();
		for (ThoLamDan tld : listtld) {
			for (CongNhanVien cnv : listcnv) {
				String gioiTinh;
				if (String.valueOf(cnv.isGioiTinh()) == "True") {
					gioiTinh = "Nữ";
				} else {
					gioiTinh = "Nam";
				}
				String ngaySinh = dateFormat.format(cnv.getNgaySinh());
				String[] rowData = { tld.getMaThoLamDan(), cnv.getHoTen(), gioiTinh,ngaySinh,
						cnv.getMaCanCuocCongDan(), cnv.getSoDienThoai() };
				modalThoLamDan.addRow(rowData);
			}
		}
	}

	public void autoGenIdThoLamDan() {
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT MAX(maThoLamDan) AS maxThoLamDan from ThoLamDan ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String maThoLamDan = rs.getString("maxThoLamDan");
				if (maThoLamDan == null) {
					jmaTLD.setText("TLD001");
				} else {
					Long stt = Long.parseLong(maThoLamDan.substring(4));
					stt++;
					jmaTLD.setText("TLD" + String.format("%03d", stt));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public void xoaRong() {
//		txtMaNhanVien.setText("");
//		txtCMND.setText("");
//		txtHoTen.setText("");
//		txtSDT.setText("");
//		txtDiaChi.setText("");
//		txtLuongCoBan.setText("");
//		rbtNam.isSelected();
//		txtMaNhanVien.requestFocus();
//	}

//	public void layDataVoComboBox() {
//		try {
//			Connection con = MyConnection.getInstance().getConnection();
//			String sql = "SELECT * from PhongBan";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				cbbPhongBan.addItem(rs.getString("tenPhongBan"));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

	    Pattern patternsdt = Pattern.compile("^(0[0-9]{9})$");
	    Pattern patternsmnd = Pattern.compile("^[0-9]{12}$");
	    java.util.Date today = new java.util.Date();
		if (o.equals(btnThem)) {

//			String trangThai = (String) jtrangThai.getSelectedItem();
			String tayNghe = (String) jtayNghe.getSelectedItem();
			String hoTen = jhoTen.getText();
			boolean phai = false;
			if (buttonGroup.getSelection() != null) {
				if (buttonGroup.getSelection().equals(rdbtnNewRadioButton_5.getModel())) {
					phai = true;
				} else if (buttonGroup.getSelection().equals(rdbtnNewRadioButton_4.getModel())) {
					phai = false;
				}
			}
			Date ngaySinh = new Date(jngaySinh.getDate().getTime());
			Date ngayVaoLam = new Date(jngayVaoLam.getDate().getTime());

			String cmnd = jcmnd.getText();
			Matcher matchercmnd = patternsmnd.matcher(cmnd);
			String sdt = jsdt.getText();
			Matcher matchersdt = patternsdt.matcher(sdt);
			String diaChi = jdiaChi.getText();
			boolean trangThai = true;
			if (jtrangThai.equals("Đang Làm")) {
				trangThai = true;
			} else if (jtrangThai.equals("Nghỉ Làm")) {
				trangThai = false;
			}
			CongNhanVien cnv = new CongNhanVien(hoTen, phai, ngaySinh, cmnd, sdt, diaChi, trangThai, ngayVaoLam);
			dao_cnv.taoCNV(cnv);
			CongNhanVien cnvNew = dao_cnv.getCongNhanVienMoiTao();
			ThoLamDan tld = new ThoLamDan(tayNghe, cnvNew);
			dao_tld.taoTLD(tld);
			System.out.println(tld);
			String maThoLamDanMoi = dao_tld.getMaThoLamDanMoiTao();
			tld.setMaThoLamDan(maThoLamDanMoi);
			System.out.println(maThoLamDanMoi);
			System.out.println(tld);
			String gioiTinh;
			Boolean gt = tld.getCongNhanVien().isGioiTinh();
			boolean kiemTraGT = true;

			if (gt == kiemTraGT) {
				gioiTinh = "Nam";
			} else {
				gioiTinh = "Nữ";
			}
			
			if(hoTen.equals("")||cmnd.equals("")||sdt.equals("")||diaChi.equals("")||ngaySinh.equals("")||ngayVaoLam.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền thông tin đầy đủ");
			} else if(!matchersdt.matches()) {
				JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
			} else if(!matchercmnd.matches()) {
				JOptionPane.showMessageDialog(null, "Mã căn cước công dân không hợp lệ");
			} else if(ngaySinh.after(today) || (int)((today.getTime() - ngaySinh.getTime())/(1000*60*24*60*365))<18) {
				JOptionPane.showMessageDialog(null, "Ngày Sinh Không Hợp Lệ!!!");
			} else if(ngayVaoLam.after(today)) {
				JOptionPane.showMessageDialog(null, "Ngày Vào Làm Phải Trước Ngày Hiện Tại !!!");	    			
			} else {
					modalThoLamDan.addRow(new Object[] { tld.getMaThoLamDan(), tld.getCongNhanVien().getHoTen(),
							gioiTinh, tld.getCongNhanVien().getNgaySinh(),
							tld.getCongNhanVien().getMaCanCuocCongDan(), tld.getCongNhanVien().getSoDienThoai() });
	    			jhoTen.setText("");
	    			jsdt.setText("");
	    			jdiaChi.setText("");
	    			jngaySinh.setDate(null);
	    			jngayVaoLam.setDate(null);
	    			jtayNghe.setSelectedIndex(0);
	    			jtrangThai.setSelectedIndex(0);
	    			jcmnd.setText("");
			}
//			modalThoLamDan.addRow(new Object[] { tld.getMaThoLamDan(), tld.getCongNhanVien().getHoTen(),
//					gioiTinh, tld.getCongNhanVien().getNgaySinh(),
//					tld.getCongNhanVien().getMaCanCuocCongDan(), tld.getCongNhanVien().getSoDienThoai() });
		}

	}

}
