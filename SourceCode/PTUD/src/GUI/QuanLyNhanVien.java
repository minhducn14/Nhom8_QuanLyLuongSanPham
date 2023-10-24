package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;


import com.toedter.calendar.JDateChooser;

public class QuanLyNhanVien extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable tbl_BangLuong;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public QuanLyNhanVien() {
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
		
		JLabel lblBngLngNhn = new JLabel("Danh sách nhân viên");
		lblBngLngNhn.setForeground(new Color(0, 27, 72));
		lblBngLngNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBngLngNhn.setBounds(30, 10, 340, 25);
		panel_1_1.add(lblBngLngNhn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 41, 1376, 106);
		panel_1_1.add(scrollPane_1);
		
		tbl_BangLuong = new JTable();
		scrollPane_1.setViewportView(tbl_BangLuong);
		tbl_BangLuong.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD T\u00EAn Nh\u00E2n Vi\u00EAn", "Gi\u1EDBi T\u00EDnh", "Ng\u00E0y Sinh", "CMND", "SDT"
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
	    
	    JLabel lblNewLabel = new JLabel("Thông tin nhân viên");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel.setBounds(54, 11, 256, 25);
	    panel.add(lblNewLabel);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    panel_1.setBackground(new Color(255, 255, 255));
	    panel_1.setBounds(15, 47, 684, 336);
	    panel.add(panel_1);
	    panel_1.setLayout(null);
	    
	    JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1.setBounds(20, 11, 133, 25);
	    panel_1.add(lblNewLabel_1);
	    
	    textField = new JTextField();
	    textField.setBounds(163, 11, 305, 25);
	    panel_1.add(textField);
	    textField.setColumns(10);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Giới tính");
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_1.setBounds(20, 55, 133, 25);
	    panel_1.add(lblNewLabel_1_1);
	    
	    JLabel lblNewLabel_1_2 = new JLabel("CMND");
	    lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_2.setBounds(20, 99, 133, 25);
	    panel_1.add(lblNewLabel_1_2);
	    
	    JLabel lblNewLabel_1_3 = new JLabel("Phòng Ban");
	    lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_3.setBounds(20, 143, 133, 25);
	    panel_1.add(lblNewLabel_1_3);
	    
	    JLabel lblNewLabel_1_4 = new JLabel("Chức vụ");
	    lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_4.setBounds(20, 187, 133, 25);
	    panel_1.add(lblNewLabel_1_4);
	    
	    JLabel lblNewLabel_1_5 = new JLabel("Ngày vào làm");
	    lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_5.setBounds(20, 231, 133, 25);
	    panel_1.add(lblNewLabel_1_5);
	    
	    JLabel lblNewLabel_1_6 = new JLabel("Hệ số lương");
	    lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_6.setBounds(20, 275, 133, 25);
	    panel_1.add(lblNewLabel_1_6);
	    
	    JRadioButton rdbtnNewRadioButton = new JRadioButton("        Nam");
	    rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    rdbtnNewRadioButton.setSelected(true);
	    rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
	    rdbtnNewRadioButton.setBounds(163, 53, 153, 28);
	    panel_1.add(rdbtnNewRadioButton);
	    
	    JRadioButton rdbtnN = new JRadioButton("          Nữ");
	    rdbtnN.setBackground(new Color(255, 255, 255));
	    rdbtnN.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    rdbtnN.setBounds(315, 53, 153, 28);
	    panel_1.add(rdbtnN);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(163, 100, 305, 27);
	    panel_1.add(textField_1);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setEditable(true);
	    comboBox.setBounds(163, 143, 305, 28);
	    panel_1.add(comboBox);
	    
	    JComboBox comboBox_1 = new JComboBox();
	    comboBox_1.setEditable(true);
	    comboBox_1.setBounds(163, 187, 305, 28);
	    panel_1.add(comboBox_1);
	    
	    JComboBox comboBox_2 = new JComboBox();
	    comboBox_2.setEditable(true);
	    comboBox_2.setBounds(163, 275, 305, 28);
	    panel_1.add(comboBox_2);
	    
	    JDateChooser dateChooser = new JDateChooser();
	    dateChooser.setBounds(163, 231, 305, 28);
	    panel_1.add(dateChooser);
	    
	    JPanel panel_1_2 = new JPanel();
	    panel_1_2.setLayout(null);
	    panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    panel_1_2.setBackground(Color.WHITE);
	    panel_1_2.setBounds(720, 47, 684, 336);
	    panel.add(panel_1_2);
	    
	    JLabel lblNewLabel_1_7 = new JLabel("Họ tên");
	    lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_7.setBounds(20, 11, 133, 25);
	    panel_1_2.add(lblNewLabel_1_7);
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    textField_3.setBounds(163, 11, 305, 25);
	    panel_1_2.add(textField_3);
	    
	    JLabel lblNewLabel_1_1_1 = new JLabel("Ngày sinh");
	    lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_1_1.setBounds(20, 55, 133, 25);
	    panel_1_2.add(lblNewLabel_1_1_1);
	    
	    JLabel lblNewLabel_1_2_1 = new JLabel("Số điện thoại");
	    lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_2_1.setBounds(20, 99, 133, 25);
	    panel_1_2.add(lblNewLabel_1_2_1);
	    
	    JLabel lblNewLabel_1_3_1 = new JLabel("Địa chỉ");
	    lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_3_1.setBounds(20, 143, 133, 25);
	    panel_1_2.add(lblNewLabel_1_3_1);
	    
	    JLabel lblNewLabel_1_4_1 = new JLabel("Trạng thái");
	    lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_4_1.setBounds(20, 187, 133, 25);
	    panel_1_2.add(lblNewLabel_1_4_1);
	    
	    JLabel lblNewLabel_1_5_1 = new JLabel("Trình độ");
	    lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_5_1.setBounds(20, 231, 133, 25);
	    panel_1_2.add(lblNewLabel_1_5_1);
	    
	    JLabel lblNewLabel_1_6_1 = new JLabel("Lương cơ bản");
	    lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_6_1.setBounds(20, 278, 133, 25);
	    panel_1_2.add(lblNewLabel_1_6_1);
	    
	    textField_4 = new JTextField();
	    textField_4.setColumns(10);
	    textField_4.setBounds(163, 100, 305, 27);
	    panel_1_2.add(textField_4);
	    
	    JComboBox comboBox_1_1 = new JComboBox();
	    comboBox_1_1.setEditable(true);
	    comboBox_1_1.setBounds(163, 187, 305, 28);
	    panel_1_2.add(comboBox_1_1);
	    
	    JComboBox comboBox_2_1 = new JComboBox();
	    comboBox_2_1.setEditable(true);
	    comboBox_2_1.setBounds(163, 231, 305, 28);
	    panel_1_2.add(comboBox_2_1);
	    
	    JDateChooser dateChooser_1 = new JDateChooser();
	    dateChooser_1.setBounds(163, 52, 305, 28);
	    panel_1_2.add(dateChooser_1);
	    
	    textField_5 = new JTextField();
	    textField_5.setColumns(10);
	    textField_5.setBounds(163, 144, 305, 27);
	    panel_1_2.add(textField_5);
	    
	    textField_6 = new JTextField();
	    textField_6.setColumns(10);
	    textField_6.setBounds(163, 279, 305, 27);
	    panel_1_2.add(textField_6);
	    
	    	    JButton btnNewButton3 = new JButton("New button");
	    	    btnNewButton3.setBounds(473, 394, 120, 30);    	    
	    	    btnNewButton3.setForeground(Color.WHITE);
	    	    btnNewButton3.setFont(new Font("Tahoma", Font.BOLD, 12));
	    	    btnNewButton3.setBackground(new Color(0, 128, 255));
	    	    btnNewButton3.setText("Thêm");
	    	    panel.add(btnNewButton3);
	    	    
	    	    JButton btnNewButton_1 = new JButton("New button");   	   
	    	    btnNewButton_1.setBounds(649, 394, 120, 30);  
	    	    btnNewButton_1.setBackground(new Color(0, 128, 255));
	    	    btnNewButton_1.setForeground(Color.WHITE);
	    	    btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    	    btnNewButton_1.setText("Sửa thông tin");
	    	    panel.add(btnNewButton_1);
	    	    
	    	    
	    	    JButton btnNewButton_2 = new JButton("New button");
	    	    btnNewButton_2.setBounds(827, 394, 120, 30);
	    	    btnNewButton_2.setForeground(Color.WHITE);
	    	    btnNewButton_2.setBackground(new Color(0, 128, 255));
	    	    btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	    	    btnNewButton_2.setText("Xoá rỗng");
	    	    panel.add(btnNewButton_2);
	}
}
