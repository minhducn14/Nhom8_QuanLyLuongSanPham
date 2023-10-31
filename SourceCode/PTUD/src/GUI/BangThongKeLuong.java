package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class BangThongKeLuong extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public BangThongKeLuong() {
		setBackground(new Color(221, 242, 251));
		setLayout(null);
		
		JLabel lblBngThngK = new JLabel("BẢNG THỐNG KÊ LƯƠNG");
		lblBngThngK.setBounds(10, 5, 1430, 70);
		lblBngThngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblBngThngK.setForeground(new Color(0, 27, 72));
		lblBngThngK.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblBngThngK);
		String[] thang = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		String[] nam = {"2023","2022","2021","2020","1999","1998"};
	    
	    JLabel lblNewLabel = new JLabel("Tháng");
	    lblNewLabel.setBounds(59, 85, 50, 25);
	    add(lblNewLabel);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel.setBackground(new Color(255, 255, 255));
	    JComboBox<String> jComboBox = new JComboBox<>(thang);
	    jComboBox.setBounds(119, 85, 80, 25);
	    add(jComboBox);
	    jComboBox.setBackground(new Color(255, 255, 255));
	    
	    JLabel lblNewLabel_1 = new JLabel("Năm");
	    lblNewLabel_1.setBounds(229, 85, 40, 25);
	    add(lblNewLabel_1);
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_1.setBackground(new Color(255, 255, 255));
	    JComboBox<String> jComboBox1 = new JComboBox<>(nam);
	    jComboBox1.setBounds(279, 85, 80, 25);
	    add(jComboBox1);
	    jComboBox1.setBackground(new Color(255, 255, 255));
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(255, 255, 255));
	    panel.setBounds(10, 120, 380, 217);
	    add(panel);
	    panel.setLayout(null);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(new Color(255, 255, 255));
	    panel_1.setBounds(10, 25, 360, 24);
	    panel.add(panel_1);
	    panel_1.setLayout(null);
	    
	    JLabel lblNewLabel_2 = new JLabel("Tổng lương lớn nhất:");
	    lblNewLabel_2.setBounds(0, 0, 180, 24);
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	    panel_1.add(lblNewLabel_2);
	    
	    JLabel lblNewLabel_3 = new JLabel("");
	    lblNewLabel_3.setBounds(180, 0, 180, 24);
	    panel_1.add(lblNewLabel_3);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	    JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Phòng ban:");
	    rdbtnmntmNewRadioItem.setFont(new Font("Tahoma", Font.BOLD, 14));
	    rdbtnmntmNewRadioItem.setSelected(true);
	    rdbtnmntmNewRadioItem.setBounds(10, 1, 140, 24);
	    panel.add(rdbtnmntmNewRadioItem);
	    
	    JPanel panel_1_1 = new JPanel();
	    panel_1_1.setLayout(null);
	    panel_1_1.setBackground(Color.WHITE);
	    panel_1_1.setBounds(10, 50, 360, 24);
	    panel.add(panel_1_1);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Tổng lương nhỏ nhất:");
	    lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_2_1.setBounds(0, 0, 180, 24);
	    panel_1_1.add(lblNewLabel_2_1);
	    
	    JLabel lblNewLabel_3_1 = new JLabel("");
	    lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_3_1.setBounds(180, 0, 180, 24);
	    panel_1_1.add(lblNewLabel_3_1);
	    
	    JPanel panel_1_2 = new JPanel();
	    panel_1_2.setLayout(null);
	    panel_1_2.setBackground(Color.WHITE);
	    panel_1_2.setBounds(10, 100, 360, 24);
	    panel.add(panel_1_2);
	    
	    JLabel lblNewLabel_2_2 = new JLabel("Tăng ca các phòng ban:");
	    lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_2_2.setBounds(0, 0, 180, 24);
	    panel_1_2.add(lblNewLabel_2_2);
	    
	    JLabel lblNewLabel_3_2 = new JLabel("");
	    lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_3_2.setBounds(180, 0, 180, 24);
	    panel_1_2.add(lblNewLabel_3_2);
	    
	    JPanel panel_1_3 = new JPanel();
	    panel_1_3.setLayout(null);
	    panel_1_3.setBackground(Color.WHITE);
	    panel_1_3.setBounds(10, 125, 360, 24);
	    panel.add(panel_1_3);
	    
	    JLabel lblNewLabel_2_3 = new JLabel("Lương các phòng ban:");
	    lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_2_3.setBounds(0, 0, 180, 24);
	    panel_1_3.add(lblNewLabel_2_3);
	    
	    JLabel lblNewLabel_3_3 = new JLabel("");
	    lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_3_3.setBounds(180, 0, 180, 24);
	    panel_1_3.add(lblNewLabel_3_3);
	    
	    JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("Tổng tiền:");
	    rdbtnmntmNewRadioItem_1.setSelected(true);
	    rdbtnmntmNewRadioItem_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	    rdbtnmntmNewRadioItem_1.setBounds(10, 75, 140, 24);
	    panel.add(rdbtnmntmNewRadioItem_1);
	    
	    JButton btnNewButton = new JButton(" In Báo Cáo");
	    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnNewButton.setIcon(new ImageIcon(BangThongKeLuong.class.getResource("/icons/print_icon.png")));
	    btnNewButton.setBounds(180, 167, 160, 40);
	    panel.add(btnNewButton);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBackground(new Color(255, 255, 255));
	    panel_2.setBounds(10, 371, 380, 319);
	    add(panel_2);
	    panel_2.setLayout(null);
	    
	    JPanel panel_1_4 = new JPanel();
	    panel_1_4.setLayout(null);
	    panel_1_4.setBackground(Color.WHITE);
	    panel_1_4.setBounds(10, 25, 360, 24);
	    panel_2.add(panel_1_4);
	    
	    JLabel lblNewLabel_2_4 = new JLabel("Tổng lương lớn nhất:");
	    lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_2_4.setBounds(0, 0, 180, 24);
	    panel_1_4.add(lblNewLabel_2_4);
	    
	    JLabel lblNewLabel_3_4 = new JLabel("");
	    lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_3_4.setBounds(180, 0, 180, 24);
	    panel_1_4.add(lblNewLabel_3_4);
	    
	    JPanel panel_1_5 = new JPanel();
	    panel_1_5.setLayout(null);
	    panel_1_5.setBackground(Color.WHITE);
	    panel_1_5.setBounds(10, 50, 360, 24);
	    panel_2.add(panel_1_5);
	    
	    JLabel lblNewLabel_2_5 = new JLabel("Tổng lương nhỏ nhất:");
	    lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_2_5.setBounds(0, 0, 180, 24);
	    panel_1_5.add(lblNewLabel_2_5);
	    
	    JLabel lblNewLabel_3_5 = new JLabel("");
	    lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_3_5.setBounds(180, 0, 180, 24);
	    panel_1_5.add(lblNewLabel_3_5);
	    
	    JPanel panel_1_6 = new JPanel();
	    panel_1_6.setLayout(null);
	    panel_1_6.setBackground(Color.WHITE);
	    panel_1_6.setBounds(10, 100, 360, 24);
	    panel_2.add(panel_1_6);
	    
	    JLabel lblNewLabel_2_6 = new JLabel("Thực hiện nhiều nhất:");
	    lblNewLabel_2_6.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_2_6.setBounds(0, 0, 180, 24);
	    panel_1_6.add(lblNewLabel_2_6);
	    
	    JLabel lblNewLabel_3_6 = new JLabel("");
	    lblNewLabel_3_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_3_6.setBounds(180, 0, 180, 24);
	    panel_1_6.add(lblNewLabel_3_6);
	    
	    JPanel panel_1_7 = new JPanel();
	    panel_1_7.setLayout(null);
	    panel_1_7.setBackground(Color.WHITE);
	    panel_1_7.setBounds(10, 125, 360, 24);
	    panel_2.add(panel_1_7);
	    
	    JLabel lblNewLabel_2_7 = new JLabel("Thực hiện ít nhất:");
	    lblNewLabel_2_7.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_2_7.setBounds(0, 0, 180, 24);
	    panel_1_7.add(lblNewLabel_2_7);
	    
	    JLabel lblNewLabel_3_7 = new JLabel("");
	    lblNewLabel_3_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_3_7.setBounds(180, 0, 180, 24);
	    panel_1_7.add(lblNewLabel_3_7);
	    
	    JPanel panel_1_8 = new JPanel();
	    panel_1_8.setLayout(null);
	    panel_1_8.setBackground(Color.WHITE);
	    panel_1_8.setBounds(10, 175, 360, 24);
	    panel_2.add(panel_1_8);
	    
	    JLabel lblNewLabel_2_8 = new JLabel("Từ sản phẩm:");
	    lblNewLabel_2_8.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_2_8.setBounds(0, 0, 180, 24);
	    panel_1_8.add(lblNewLabel_2_8);
	    
	    JLabel lblNewLabel_3_8 = new JLabel("");
	    lblNewLabel_3_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_3_8.setBounds(180, 0, 180, 24);
	    panel_1_8.add(lblNewLabel_3_8);
	    
	    JPanel panel_1_9 = new JPanel();
	    panel_1_9.setLayout(null);
	    panel_1_9.setBackground(Color.WHITE);
	    panel_1_9.setBounds(10, 200, 360, 24);
	    panel_2.add(panel_1_9);
	    
	    JLabel lblNewLabel_2_9 = new JLabel("Từ sản phẩm tăng ca:");
	    lblNewLabel_2_9.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_2_9.setBounds(0, 0, 180, 24);
	    panel_1_9.add(lblNewLabel_2_9);
	    
	    JLabel lblNewLabel_3_9 = new JLabel("");
	    lblNewLabel_3_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_3_9.setBounds(180, 0, 180, 24);
	    panel_1_9.add(lblNewLabel_3_9);
	    
	    JPanel panel_1_10 = new JPanel();
	    panel_1_10.setLayout(null);
	    panel_1_10.setBackground(Color.WHITE);
	    panel_1_10.setBounds(10, 225, 360, 24);
	    panel_2.add(panel_1_10);
	    
	    JLabel lblNewLabel_2_10 = new JLabel("Thợ làm đàn:");
	    lblNewLabel_2_10.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_2_10.setBounds(0, 0, 180, 24);
	    panel_1_10.add(lblNewLabel_2_10);
	    
	    JLabel lblNewLabel_3_10 = new JLabel("");
	    lblNewLabel_3_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_3_10.setBounds(180, 0, 180, 24);
	    panel_1_10.add(lblNewLabel_3_10);
	    
	    JRadioButtonMenuItem rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem("Thợ làm đàn:");
	    rdbtnmntmNewRadioItem_2.setSelected(true);
	    rdbtnmntmNewRadioItem_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	    rdbtnmntmNewRadioItem_2.setBounds(10, 1, 140, 24);
	    panel_2.add(rdbtnmntmNewRadioItem_2);
	    
	    JRadioButtonMenuItem rdbtnmntmNewRadioItem_3 = new JRadioButtonMenuItem("Công đoạn:");
	    rdbtnmntmNewRadioItem_3.setSelected(true);
	    rdbtnmntmNewRadioItem_3.setFont(new Font("Tahoma", Font.BOLD, 14));
	    rdbtnmntmNewRadioItem_3.setBounds(10, 75, 140, 24);
	    panel_2.add(rdbtnmntmNewRadioItem_3);
	    
	    JRadioButtonMenuItem rdbtnmntmNewRadioItem_4 = new JRadioButtonMenuItem("Tổng tiền:");
	    rdbtnmntmNewRadioItem_4.setSelected(true);
	    rdbtnmntmNewRadioItem_4.setFont(new Font("Tahoma", Font.BOLD, 14));
	    rdbtnmntmNewRadioItem_4.setBounds(10, 150, 140, 24);
	    panel_2.add(rdbtnmntmNewRadioItem_4);
	    
	    JButton btnInBoCo = new JButton(" In Báo Cáo");
	    btnInBoCo.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnInBoCo.setIcon(new ImageIcon(BangThongKeLuong.class.getResource("/icons/print_icon.png")));
	    btnInBoCo.setBounds(181, 269, 160, 40);
	    panel_2.add(btnInBoCo);
	    
	    JSeparator separator = new JSeparator();
	    separator.setForeground(new Color(0, 0, 0));
	    separator.setBackground(new Color(0, 0, 0));
	    separator.setBounds(25, 351, 1400, 2);
	    add(separator);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBackground(new Color(255, 255, 255));
	    panel_3.setBounds(437, 120, 980, 217);
	    add(panel_3);
	    panel_3.setLayout(null);
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(10, 15, 960, 185);
	    panel_3.add(scrollPane_1);
	    

		JTable table_1 = new JTable();
	    scrollPane_1.setViewportView(table_1);
	    JTableHeader tb1 = table_1.getTableHeader();
	    tb1.setBackground(new Color(221, 242, 251));
	    tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    int rowMargin1= 30;
	    table_1.setRowHeight(32);
	    table_1.setIntercellSpacing(new Dimension(0, rowMargin1));
	    
	    table_1.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    	},
	    	new String[] {
	    		"M\u00E3 Ph\u00F2ng Ban", "T\u00EAn Ph\u00F2ng Ban", "Ti\u1EC1n T\u0103ng Ca (VND)", "T\u1ED5ng Ti\u1EC1n L\u01B0\u01A1ng (VND)"
	    	}
	    ));
	    
	    JPanel panel_4 = new JPanel();
	    panel_4.setBackground(new Color(255, 255, 255));
	    panel_4.setBounds(437, 387, 980, 303);
	    add(panel_4);
	    panel_4.setLayout(null);
	    
	    JScrollPane scrollPane_2 = new JScrollPane();
	    scrollPane_2.setBounds(10, 11, 960, 280);
	    panel_4.add(scrollPane_2);
	    

		JTable table_2 = new JTable();
	    scrollPane_2.setViewportView(table_2);
	    JTableHeader tb2 = table_2.getTableHeader();
	    tb2.setBackground(new Color(221, 242, 251));
	    tb2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    int rowMargin2= 30;
	    table_2.setRowHeight(32);
	    table_2.setIntercellSpacing(new Dimension(0, rowMargin2));
	    
	    table_2.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"M\u00E3 Th\u1EE3 L\u00E0m \u0110\u00E0n", "T\u00EAn Th\u1EE3 L\u00E0m \u0110\u00E0n", "C\u00F4ng \u0110o\u1EA1n Th\u1EF1c Hi\u1EC7n", "L\u01B0\u01A1ng T\u1EEB S\u1EA3n Ph\u1EA9m (VND)", "L\u01B0\u01A1ng T\u1EEB S\u1EA3n Ph\u1EA9m T\u0103ng Ca", "T\u1ED5ng Ti\u1EC1n L\u01B0\u01A1ng (VND)"
	    	}
	    ));
	    
	    JLabel lblNewLabel_4 = new JLabel("Phòng ban");
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_4.setBackground(new Color(255, 255, 255));
	    lblNewLabel_4.setBounds(569, 90, 104, 25);
	    add(lblNewLabel_4);
	    
	    JLabel lblNewLabel_4_1 = new JLabel("Thợ làm đàn");
	    lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblNewLabel_4_1.setBackground(Color.WHITE);
	    lblNewLabel_4_1.setBounds(569, 360, 104, 25);
	    add(lblNewLabel_4_1);
		
	}
}
