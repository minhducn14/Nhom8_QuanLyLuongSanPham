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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ItemEvent;

public class ThoLamDan extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jmaTLD;
	private JTextField jcmnd;
	private JTextField jhoTen;
	private JTextField jsdt;
	private JTextField textField_5;
	private JTextField jdiaChi;
	public ThoLamDan() {
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
	    
	    table_1.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"M\u00E3 th\u1EE3 l\u00E0m \u0111\u00E0n", "H\u1ECD t\u00EAn th\u1EE3 l\u00E0m \u0111\u00E0n", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "CMND", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
	    	}
	    ));
	    
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
	    
	    JRadioButton rdbtnNewRadioButton = new JRadioButton("");
	    rdbtnNewRadioButton.setBounds(0, 0, 25, 25);
	    rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
	    panel_1.add(rdbtnNewRadioButton);
	    
	    JLabel lblNewLabel_1 = new JLabel("Mã thợ làm đàn:");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1.setBounds(31, 0, 140, 25);
	    panel_1.add(lblNewLabel_1);
	    
	    jmaTLD = new JTextField();
	    jmaTLD.setBounds(180, 0, 380, 25);
	    panel_1.add(jmaTLD);
	    jmaTLD.setColumns(10);
	    
	    JPanel panel_1_1 = new JPanel();
	    panel_1_1.setLayout(null);
	    panel_1_1.setBackground(Color.WHITE);
	    panel_1_1.setBounds(91, 130, 560, 25);
	    panel.add(panel_1_1);
	    
	    JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
	    rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_1.setBackground(Color.WHITE);
	    rdbtnNewRadioButton_1.setBounds(0, 0, 25, 25);
	    panel_1_1.add(rdbtnNewRadioButton_1);
	    
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
	    
	    JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
	    rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_2.setBackground(Color.WHITE);
	    rdbtnNewRadioButton_2.setBounds(0, 0, 25, 25);
	    panel_1_2.add(rdbtnNewRadioButton_2);
	    
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
	    
	    JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("");
	    rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_3.setBackground(Color.WHITE);
	    rdbtnNewRadioButton_3.setBounds(0, 0, 25, 25);
	    panel_1_3.add(rdbtnNewRadioButton_3);
	    
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
	    
	    JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("");
	    rdbtnNewRadioButton_6.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_6.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_6.setBounds(1, 0, 25, 25);
	    panel_1_4.add(rdbtnNewRadioButton_6);
	    

	    
	    JLabel lblNewLabel_4 = new JLabel("Giới tính:");
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_4.setBounds(32, 0, 93, 25);
	    panel_1_4.add(lblNewLabel_4);
	    
	    JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("");
	    rdbtnNewRadioButton_5.setSelected(true);
	    rdbtnNewRadioButton_5.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_5.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_5.setBounds(187, 0, 25, 25);
	    panel_1_4.add(rdbtnNewRadioButton_5);
	    
	    JLabel lblNewLabel_3 = new JLabel("Nam");
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_3.setBounds(218, 0, 93, 25);
	    panel_1_4.add(lblNewLabel_3);
	    
	    JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("");
	    rdbtnNewRadioButton_4.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent e) {
	    		if(e.getStateChange()==ItemEvent.SELECTED) {
	    			rdbtnNewRadioButton_5.setSelected(false);
	    		}
	    	}
	    });
	    rdbtnNewRadioButton_4.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_4.setBounds(373, 0, 25, 25);
	    panel_1_4.add(rdbtnNewRadioButton_4);
	    
	    JLabel lblNewLabel_2 = new JLabel("Nữ");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_2.setBounds(404, 0, 93, 25);
	    panel_1_4.add(lblNewLabel_2);
	    
	    ButtonGroup buttonGroup = new ButtonGroup();
	    buttonGroup.add(rdbtnNewRadioButton_4);
	    buttonGroup.add(rdbtnNewRadioButton_5);
	    
	    
	    
	    JPanel panel_1_5 = new JPanel();
	    panel_1_5.setLayout(null);
	    panel_1_5.setBackground(Color.WHITE);
	    panel_1_5.setBounds(91, 170, 560, 25);
	    panel.add(panel_1_5);
	    
	    JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("");
	    rdbtnNewRadioButton_7.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_7.setBackground(Color.WHITE);
	    rdbtnNewRadioButton_7.setBounds(0, 0, 25, 25);
	    panel_1_5.add(rdbtnNewRadioButton_7);
	    
	    JLabel lblNewLabel_1_4 = new JLabel("Tay nghề:");
	    lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_4.setBounds(31, 0, 140, 25);
	    panel_1_5.add(lblNewLabel_1_4);
	    
	    String[] trinhDo = {"Bậc 1","Bậc 2","Bậc 3","Bậc 4","Bậc 5"};
        JComboBox<String> jtayNghe = new JComboBox<>(trinhDo);
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
	    
	    JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("");
	    rdbtnNewRadioButton_8.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_8.setBackground(Color.WHITE);
	    rdbtnNewRadioButton_8.setBounds(0, 0, 25, 25);
	    panel_1_6.add(rdbtnNewRadioButton_8);
	    
	    JLabel lblNewLabel_1_5 = new JLabel("Ngày vào làm:");
	    lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_5.setBounds(31, 0, 140, 25);
	    panel_1_6.add(lblNewLabel_1_5);
	    
	    JDateChooser jngayVaoLam = new JDateChooser();
	    jngayVaoLam.setLocation(180, 0);
	    jngayVaoLam.setSize(380, 25);
	    panel_1_6.add(jngayVaoLam);
	    
	    JPanel panel_1_7 = new JPanel();
	    panel_1_7.setLayout(null);
	    panel_1_7.setBackground(Color.WHITE);
	    panel_1_7.setBounds(759, 170, 560, 25);
	    panel.add(panel_1_7);
	    
	    JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("");
	    rdbtnNewRadioButton_9.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_9.setBackground(Color.WHITE);
	    rdbtnNewRadioButton_9.setBounds(0, 0, 25, 25);
	    panel_1_7.add(rdbtnNewRadioButton_9);
	    
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
	    
	    JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("");
	    rdbtnNewRadioButton_10.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_10.setBackground(Color.WHITE);
	    rdbtnNewRadioButton_10.setBounds(0, 0, 25, 25);
	    panel_1_8.add(rdbtnNewRadioButton_10);
	    
	    JLabel lblNewLabel_1_7 = new JLabel("Ngày sinh:");
	    lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_7.setBounds(31, 0, 140, 25);
	    panel_1_8.add(lblNewLabel_1_7);
	    
	    JDateChooser jngaySinh = new JDateChooser();
	    jngaySinh.setBounds(180, 0, 380, 25);
	    panel_1_8.add(jngaySinh);
	    
	    JPanel panel_1_9 = new JPanel();
	    panel_1_9.setLayout(null);
	    panel_1_9.setBackground(Color.WHITE);
	    panel_1_9.setBounds(759, 210, 560, 25);
	    panel.add(panel_1_9);
	    
	    JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("");
	    rdbtnNewRadioButton_11.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_11.setBackground(Color.WHITE);
	    rdbtnNewRadioButton_11.setBounds(0, 0, 25, 25);
	    panel_1_9.add(rdbtnNewRadioButton_11);
	    
	    JLabel lblNewLabel_1_8 = new JLabel("Trạng thái:");
	    lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_8.setBounds(31, 0, 140, 25);
	    panel_1_9.add(lblNewLabel_1_8);
	    
	    String[] trangThai = {"Đang làm","Nghỉ việc"};
        JComboBox<String> jtrangThai = new JComboBox<>(trangThai);
	    jtrangThai.setBounds(180, 0, 380, 25);
	    panel_1_9.add(jtrangThai);
	    
	    //Xóa
	    JButton btnXoRng = new JButton("Xoá rỗng");
	    btnXoRng.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int row = table_1.getSelectedRow();
	    		if(row==-1) {
	    			JOptionPane.showMessageDialog(null, "Vui long chon dong de xoa");
	    		} else {
	    			((DefaultTableModel) table_1.getModel()).removeRow(row);
	    		}
	    	}
	    });
	    btnXoRng.setForeground(Color.WHITE);
	    btnXoRng.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnXoRng.setBackground(new Color(2, 104, 156));
	    btnXoRng.setBounds(900, 260, 170, 40);
	    panel.add(btnXoRng);
	    
	    //Sửa thông tin
	    JButton btnTmKim = new JButton("Sửa thông tin");
	    btnTmKim.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnTmKim.setForeground(Color.WHITE);
	    btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnTmKim.setBackground(new Color(2, 104, 156));
	    btnTmKim.setBounds(625, 260, 170, 40);
	    panel.add(btnTmKim);
	    
	    
	    
	    //Thêm
	    Pattern patternsdt = Pattern.compile("^(0[0-9]{9})$");
	    Pattern patternsmnd = Pattern.compile("^[0-9]{12}$");
	    
	    JButton btnThm = new JButton("Thêm");
	    btnThm.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//Mã TLD
	    		String maTLD = jmaTLD.getText();
	    		//Giới Tính
	    		boolean isSelected = rdbtnNewRadioButton_5.isSelected();
	    		String gioiTinh = isSelected ? "Nam":"Nữ";
	    		//CMND
	    		String cmnd = jcmnd.getText();
	    		Matcher matchercmnd = patternsmnd.matcher(cmnd);
	    		//Tay Nghề
	    		String tayNghe = (String) jtayNghe.getSelectedItem();
	    		//Ngày Vào Làm
	    		java.util.Date ngayVaoLam = jngayVaoLam.getDate();
	    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//	    		String NgayVaoLam = sdf.format(ngayVaoLam);
	    		//Họ Tên
	    		String hoTen = jhoTen.getText();
	    		//Ngày Sinh
	    		java.util.Date ngaySinh = jngaySinh.getDate();
	    		String NgaySinh = sdf.format(ngaySinh);
	    		java.util.Date today = new java.util.Date();
	    		if(ngaySinh.after(today)&& (int)(today.getTime()-ngaySinh.getTime())/(1000*60*24*60*365)<18) {
	    			JOptionPane.showMessageDialog(null, "Ngày Sinh Không Hợp Lệ!!!");
	    		}
	    		//SDT
	    		String sdt = jsdt.getText();
	    		Matcher matchersdt = patternsdt.matcher(sdt);
	    		//Địa Chỉ
	    		String diaChi = jdiaChi.getText();
	    		//Trạng Thái
	    		String trangThai = (String) jtrangThai.getSelectedItem();
	    		//Check điều kiện 
	    		if(!matchersdt.matches()) {
	    			JOptionPane.showMessageDialog(null, "Số Điện Thoại Không Hợp Lệ");
	    		}else if(!matchercmnd.matches()){
	    			JOptionPane.showMessageDialog(null, "Căn Cước Công Dân Không Hợp Lệ");	    			
	    		}else{
	    		
	    		Object[] rowData = {maTLD, hoTen, gioiTinh,NgaySinh,cmnd,sdt};
//	    		((DefaultTableModel) table_1.getModel()).addRow(rowData);
	    		if(maTLD.equals("")&&hoTen.equals("")&&cmnd.equals("")&&sdt.equals("")&&diaChi.equals("")&&ngaySinh.equals("")&&ngayVaoLam==null) {
	    			JOptionPane.showMessageDialog(null, "Error");
	    		} else {	    			
	    			((DefaultTableModel) table_1.getModel()).insertRow(0, rowData);
	    			jmaTLD.setText("");
	    			jhoTen.setText("");
	    			jsdt.setText("");
	    			jdiaChi.setText("");
	    			jngaySinh.setDate(null);
	    			jngayVaoLam.setDate(null);
	    			jtayNghe.setSelectedIndex(0);
	    			jtrangThai.setSelectedIndex(0);
	    			jcmnd.setText("");
	    		}
	    		try {
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyLuongSP", "sa", "sapassword");
	    			String sql = "INSERT INTO CongNhanVien(maCongNhanVien, hoTen, gioiTinh,ngaySinh,maCanCuocCongDan,soDienThoai, diaChi, trangThai,ngayVaoLam) VALUES (?,?,?,?,?,?,?,?,?)";
	    			PreparedStatement statement = conn.prepareStatement(sql);
	    			statement.setString(1, maTLD);
	    			statement.setString(2, hoTen);
	    			statement.setString(3,gioiTinh);
	    			statement.setDate(4, new Date(jngaySinh.getDate().getTime()));
	    			statement.setString(5, cmnd);
	    			statement.setString(6,sdt);
	    			statement.setString(7, diaChi);
	    			statement.setString(8, (String)jtrangThai.getSelectedItem());
	    			statement.setDate(9, new Date(jngayVaoLam.getDate().getTime()));
	    			
	    			
	    			statement.executeUpdate(sql);
	    			conn.close();
	    			
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
	    	}
	    	}
	    });
	    btnThm.setForeground(Color.WHITE);
	    btnThm.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnThm.setBackground(new Color(2, 104, 156));
	    btnThm.setBounds(350, 260, 170, 40);
	    panel.add(btnThm);
	    
	}
}
