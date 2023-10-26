package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TimKiemNhanVien extends JPanel  {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public TimKiemNhanVien() {
		setLayout(null);
		setBackground(new Color(221, 242, 251));
		
		JLabel lblNewLabel = new JLabel("TÌM KIẾM THÔNG TIN NHÂN VIÊN");
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
	    int rowHeight1 = 32;
	    int rowMargin1= 30;
	    table_1.setRowHeight(rowHeight1);
	    table_1.setIntercellSpacing(new Dimension(0, rowMargin1));
	    
	    table_1.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"Mã Nhân Viên ","Họ tên Nhân Viên","Giới tính","Ngày sinh","CMND","SDT"
	    	}
	    ));
	    
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
	    btnTmKim.setForeground(Color.WHITE);
	    btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnTmKim.setBackground(new Color(2, 104, 156));
	    btnTmKim.setBounds(499, 255, 170, 50);
	    panel.add(btnTmKim);
	    
	    JButton btnXoRng = new JButton("Xoá rỗng");
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
	    
	    JRadioButton rdbtnNewRadioButton = new JRadioButton("");
	    rdbtnNewRadioButton.setBounds(0, 0, 25, 25);
	    rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
	    panel_1.add(rdbtnNewRadioButton);
	    
	    JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1.setBounds(31, 0, 140, 25);
	    panel_1.add(lblNewLabel_1);
	    
	    textField = new JTextField();
	    textField.setEditable(false);
	    textField.setBounds(180, 0, 380, 25);
	    
	    textField = new JTextField();
	    textField.setBounds(201, 0, 318, 25);
	    panel_1.add(textField);
	    textField.setColumns(10);
	    
	    JPanel panel_1_1 = new JPanel();
	    panel_1_1.setLayout(null);
	    panel_1_1.setBackground(Color.WHITE);
	    panel_1_1.setBounds(91, 122, 560, 25);
	    panel_1_1.setBounds(50, 134, 519, 25);
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
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(180, 0, 380, 25);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(201, 0, 318, 25);
	    panel_1_1.add(textField_1);
	    
	    JPanel panel_1_2 = new JPanel();
	    panel_1_2.setLayout(null);
	    panel_1_2.setBackground(Color.WHITE);
	    panel_1_2.setBounds(759, 65, 560, 25);
	    panel_1_2.setBounds(800, 65, 519, 25);
	    panel.add(panel_1_2);
	    
	    JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
	    rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_2.setBackground(Color.WHITE);
	    rdbtnNewRadioButton_2.setBounds(0, 0, 25, 25);
	    panel_1_2.add(rdbtnNewRadioButton_2);
	    
	    JLabel lblNewLabel_1_22 = new JLabel("Họ tên:");
	    lblNewLabel_1_22.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_22.setBounds(31, 0, 140, 25);
	    panel_1_2.add(lblNewLabel_1_22);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(180, 0, 380, 25);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(201, 0, 318, 25);
	    panel_1_2.add(textField_2);
	    
	    JPanel panel_1_3 = new JPanel();
	    panel_1_3.setLayout(null);
	    panel_1_3.setBackground(Color.WHITE);
	    panel_1_3.setBounds(759, 122, 560, 25);
	    panel_1_3.setBounds(800, 134, 519, 25);
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
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    textField_3.setBounds(180, 0, 380, 25);
	    panel_1_3.add(textField_3);
	    
	    JPanel panel_1_4 = new JPanel();
	    panel_1_4.setBackground(Color.WHITE);
	    panel_1_4.setBounds(448, 202, 560, 25);
	    panel.add(panel_1_4);
	    panel_1_4.setLayout(null);
	    
	    JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("");
	    rdbtnNewRadioButton_6.setBounds(1, 0, 25, 25);
	    rdbtnNewRadioButton_6.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_6.setHorizontalAlignment(SwingConstants.CENTER);
	    panel_1_4.add(rdbtnNewRadioButton_6);
	    
	    JLabel lblNewLabel_4 = new JLabel("Giới tính:");
	    lblNewLabel_4.setBounds(32, 0, 85, 25);
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_1_4.add(lblNewLabel_4);
	    
	    JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("");
	    rdbtnNewRadioButton_5.setBounds(225, 0, 25, 25);
	    rdbtnNewRadioButton_5.setSelected(true);
	    rdbtnNewRadioButton_5.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_5.setHorizontalAlignment(SwingConstants.CENTER);
	    panel_1_4.add(rdbtnNewRadioButton_5);
	    
	    JLabel lblNewLabel_3 = new JLabel("Nam");
	    lblNewLabel_3.setBounds(256, 0, 85, 25);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_1_4.add(lblNewLabel_3);
	    textField_3.setBounds(201, 0, 318, 25);
	    panel_1_3.add(textField_3);
	    
	    JRadioButton rdbtnNewRadioButton_66 = new JRadioButton("");
	    rdbtnNewRadioButton_66.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_66.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_66.setBounds(55, 0, 25, 25);
	    
	    JLabel lblNewLabel_44 = new JLabel("Giới tính: ");
	    lblNewLabel_44.setFont(new Font("Tahoma", Font.BOLD, 16));
	    
	    JRadioButton rdbtnNewRadioButton_55 = new JRadioButton("");
	    rdbtnNewRadioButton_55.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_55.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    JLabel lblNewLabel_33 = new JLabel("Nam");
	    lblNewLabel_33.setFont(new Font("Tahoma", Font.BOLD, 16));
	    
	    JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("");
	    rdbtnNewRadioButton_4.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_4.setBounds(373, 0, 25, 25);
	    
	    JLabel lblNewLabel_2 = new JLabel("Nữ");
	    lblNewLabel_2.setBounds(404, 0, 93, 25);
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_1_4.add(lblNewLabel_2);
	    
	    JRadioButton rdbtnNewRadioButton_6_1 = new JRadioButton("");
	    rdbtnNewRadioButton_6_1.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_6_1.setBackground(Color.WHITE);
	    rdbtnNewRadioButton_6_1.setBounds(373, 0, 25, 25);
	    panel_1_4.add(rdbtnNewRadioButton_6_1);
	    rdbtnNewRadioButton_4.setBounds(395, 0, 25, 25);
	}

}
