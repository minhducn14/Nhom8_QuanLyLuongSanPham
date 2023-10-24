package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BangPhanCong extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table_2;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BangPhanCong() {
		setBackground(new Color(221, 242, 251));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(550, 5, 375, 70);
		add(lblNewLabel);
		lblNewLabel.setText("BẢNG PHÂN CÔNG");
		
		JPanel panel = new JPanel();
	    panel.setBounds(990, 90, 450, 315);
	    panel.setBackground(Color.WHITE);
	    add(panel);
	    panel.setLayout(null);
	    
	    JButton btnNewButton = new JButton("New button");
	    btnNewButton.setBounds(20, 260, 120, 30);
	    panel.add(btnNewButton);
	    btnNewButton.setForeground(Color.WHITE);
	    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnNewButton.setBackground(new Color(2, 104, 156));
	    btnNewButton.setText("Thêm");
	    
	    JButton btnNewButton_1 = new JButton("New button");
	    btnNewButton_1.setBounds(160, 260, 120, 30);
	    panel.add(btnNewButton_1);
	    btnNewButton_1.setBackground(new Color(2, 104, 156));
	    btnNewButton_1.setForeground(Color.WHITE);
	    btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnNewButton_1.setText("Sửa thông tin");
	    
	    JButton btnNewButton_2 = new JButton("New button");
	    btnNewButton_2.setBounds(295, 260, 120, 30);
	    panel.add(btnNewButton_2);
	    btnNewButton_2.setForeground(Color.WHITE);
	    btnNewButton_2.setBackground(new Color(2, 104, 156));
	    btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnNewButton_2.setText("Xoá rỗng");
	    
	    JTextField textField_3 = new JTextField();
	    textField_3.setBounds(200, 207, 200, 25);
	    panel.add(textField_3);
	    textField_3.setColumns(10);
	    
	    JLabel lblNewLabel_3 = new JLabel("New label");
	    lblNewLabel_3.setBounds(20, 205, 170, 25);
	    panel.add(lblNewLabel_3);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_3.setText("Ngày chấm công");
	    
	    JLabel lblNewLabel_2 = new JLabel("New label");
	    lblNewLabel_2.setBounds(20, 135, 170, 25);
	    panel.add(lblNewLabel_2);
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_2.setText("Số lượng sản phẩm\r\n");
	    
	    JTextField textField_2 = new JTextField();
	    textField_2.setBounds(200, 137, 200, 25);
	    panel.add(textField_2);
	    textField_2.setColumns(10);
	    lblNewLabel_2.setLabelFor(textField_2);
	    
	    JTextField textField_1 = new JTextField();
	    textField_1.setBounds(200, 65, 200, 25);
	    panel.add(textField_1);
	    textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    textField_1.setColumns(10);
	    
	    
	    JLabel lblNewLabel1 = new JLabel("New label");
	    lblNewLabel1.setBounds(20, 65, 170, 25);
	    panel.add(lblNewLabel1);
	    lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel1.setText("Mã phân công");
	    lblNewLabel1.setLabelFor(textField_1);
	    
	    JLabel lblNewLabel_4 = new JLabel("New label");
	    lblNewLabel_4.setBounds(35, 15, 220, 25);
	    panel.add(lblNewLabel_4);
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_4.setText("Thông tin công đoạn");
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBounds(15, 90, 450, 315);
	    panel_1.setBackground(Color.WHITE);
	    add(panel_1);
	    panel_1.setLayout(null);
	    
	    JLabel lblNewLabel_5 = new JLabel("New label");
	    lblNewLabel_5.setBounds(35, 15, 249, 25);
	    panel_1.add(lblNewLabel_5);
	    lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_5.setText("Danh sách thợ làm đàn\r\n");
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(20, 65, 410, 230);
	    panel_1.add(scrollPane);
	    table = new JTable();
	    scrollPane.setViewportView(table);
	    table.setModel(new DefaultTableModel(
	    		new Object[][] {
		    		{null, null},
		    		{null, null},
		    		{null, null},
		    		{null, null},
		    	},
		    	new String[] {
		    		"M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n"
		    	}
	    ));
	    JTableHeader tb = table.getTableHeader();
	    tb.setBackground(new Color(221, 242, 251));
	    tb.setFont(new Font("Tahoma", Font.BOLD, 16));
	    int rowHeight = 30;
	    int rowMargin = 10;
	    table.setRowHeight(rowHeight);
	    table.setIntercellSpacing(new Dimension(0, rowMargin));

	    

	    
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
	    table_1.setRowMargin(rowMargin);
	    scrollPane_1.setViewportView(table_1);
	    JTableHeader tb1 = table_1.getTableHeader();
	    tb1.setBackground(new Color(221, 242, 251));
	    tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    table_1.setRowHeight(rowHeight);
	    table_1.setIntercellSpacing(new Dimension(0, rowMargin));
	    
	    table_1.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, "", null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"M\u00E3 Ph\u00E2n C\u00F4ng", "M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n", "M\u00E3 Th\u1EE3 L\u00E0m \u0110\u00E0n", "T\u00EAn Th\u1EE3 L\u00E0m \u0110\u00E0n", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m"
	    	}
	    ));
	    
	    JLabel lblNewLabel_6 = new JLabel("New label");
	    lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_6.setBounds(49, 450, 217, 25);
	    add(lblNewLabel_6);
	    lblNewLabel_6.setText("Danh sách phân công\r\n");
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBackground(Color.WHITE);
	    panel_3.setBounds(502, 90, 450, 315);
	    add(panel_3);
	    panel_3.setLayout(null);
	    
	    JScrollPane scrollPane_2 = new JScrollPane();
	    scrollPane_2.setBounds(20, 60, 410, 230);
	    panel_3.add(scrollPane_2);
	    
	    table_2 = new JTable();
	    scrollPane_2.setViewportView(table_2);
	    table_2.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null},
	    		{null, null},
	    		{null, null},
	    		{null, null},
	    	},
	    	new String[] {
	    		"M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n"
	    	}
	    ));
	    JTableHeader tb2 = table_2.getTableHeader();
	    tb2.setBackground(new Color(221, 242, 251));
	    tb2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    
	    JLabel lblNewLabel_5_1 = new JLabel("Danh sách công đoạn");
	    lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_5_1.setBounds(35, 15, 217, 25);
	    panel_3.add(lblNewLabel_5_1);
	    
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	}
	}
