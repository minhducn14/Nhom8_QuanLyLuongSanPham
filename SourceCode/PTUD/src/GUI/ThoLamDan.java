package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
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

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ThoLamDan extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
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
	    		"Mã thợ làm đàn","Họ tên thợ làm đàn","Giới tính","Ngày sinh","CMND","Số điện thoại"
	    	}
	    ));
	    
	    JLabel lblNewLabel_6 = new JLabel("New label");
	    lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_6.setBounds(50, 450, 217, 25);
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
	    
	    JButton btnTmKim = new JButton("Sửa thông tin");
	    btnTmKim.setForeground(Color.WHITE);
	    btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnTmKim.setBackground(new Color(2, 104, 156));
	    btnTmKim.setBounds(625, 260, 170, 40);
	    panel.add(btnTmKim);
	    
	    JButton btnXoRng = new JButton("Xoá rỗng");
	    btnXoRng.setForeground(Color.WHITE);
	    btnXoRng.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnXoRng.setBackground(new Color(2, 104, 156));
	    btnXoRng.setBounds(900, 260, 170, 40);
	    panel.add(btnXoRng);
	    
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
	    
	    textField = new JTextField();
	    textField.setBounds(180, 0, 380, 25);
	    panel_1.add(textField);
	    textField.setColumns(10);
	    
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
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(180, 0, 380, 25);
	    panel_1_1.add(textField_1);
	    
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
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(180, 0, 380, 25);
	    panel_1_2.add(textField_2);
	    
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
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    textField_3.setBounds(180, 0, 380, 25);
	    panel_1_3.add(textField_3);
	    
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
	    rdbtnNewRadioButton_4.setBackground(new Color(255, 255, 255));
	    rdbtnNewRadioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnNewRadioButton_4.setBounds(373, 0, 25, 25);
	    panel_1_4.add(rdbtnNewRadioButton_4);
	    
	    JLabel lblNewLabel_2 = new JLabel("Nữ");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_2.setBounds(404, 0, 93, 25);
	    panel_1_4.add(lblNewLabel_2);
	    
	    JButton btnThm = new JButton("Thêm");
	    btnThm.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnThm.setForeground(Color.WHITE);
	    btnThm.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnThm.setBackground(new Color(2, 104, 156));
	    btnThm.setBounds(350, 260, 170, 40);
	    panel.add(btnThm);
	    
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
        JComboBox<String> jComboBox = new JComboBox<>(trinhDo);
	    jComboBox.setBounds(180, 0, 380, 25);
	    panel_1_5.add(jComboBox);
	    
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
	    
	    JDateChooser ngayVaoLam = new JDateChooser();
	    ngayVaoLam.setLocation(180, 0);
	    ngayVaoLam.setSize(380, 25);
	    panel_1_6.add(ngayVaoLam);
	    
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
	    
	    textField_6 = new JTextField();
	    textField_6.setColumns(10);
	    textField_6.setBounds(180, 0, 380, 25);
	    panel_1_7.add(textField_6);
	    
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
	    
	    JDateChooser ngayVaoLam_1 = new JDateChooser();
	    ngayVaoLam_1.setBounds(180, 0, 380, 25);
	    panel_1_8.add(ngayVaoLam_1);
	    
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
        JComboBox<String> jComboBox_1 = new JComboBox<>(trangThai);
	    jComboBox_1.setBounds(180, 0, 380, 25);
	    panel_1_9.add(jComboBox_1);
	}
}
