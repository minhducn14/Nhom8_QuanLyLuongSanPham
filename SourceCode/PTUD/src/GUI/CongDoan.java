package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class CongDoan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel_1;
	private JSeparator separator_1;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public CongDoan() {
		setBackground(new Color(221, 242, 251));
	    setLayout(null);
	    
	    lblNewLabel_1 = new JLabel("New label");
	    lblNewLabel_1.setBounds(550, 5, 375, 70);
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
	    add(lblNewLabel_1);
	    lblNewLabel_1.setText("CÔNG ĐOẠN");
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(975, 90, 460, 315);
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
	    
	    textField_3 = new JTextField();
	    textField_3.setBounds(160, 207, 250, 25);
	    panel.add(textField_3);
	    textField_3.setColumns(10);
	    
	    lblNewLabel_3 = new JLabel("New label");
	    lblNewLabel_3.setBounds(20, 205, 170, 25);
	    panel.add(lblNewLabel_3);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_3.setText("Giá công đoạn");
	    
	    lblNewLabel_2 = new JLabel("New label");
	    lblNewLabel_2.setBounds(20, 135, 170, 25);
	    panel.add(lblNewLabel_2);
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_2.setText("Tên công đoạn");
	    
	    textField_2 = new JTextField();
	    textField_2.setBounds(160, 135, 250, 25);
	    panel.add(textField_2);
	    textField_2.setColumns(10);
	    lblNewLabel_2.setLabelFor(textField_2);
	    
	    textField_1 = new JTextField();
	    textField_1.setBounds(160, 65, 250, 25);
	    panel.add(textField_1);
	    textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    textField_1.setColumns(10);
	    
	    
	    JLabel lblNewLabel = new JLabel("New label");
	    lblNewLabel.setBounds(20, 65, 170, 25);
	    panel.add(lblNewLabel);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel.setText("Mã công đoạn");
	    lblNewLabel.setLabelFor(textField_1);
	    
	    lblNewLabel_4 = new JLabel("New label");
	    lblNewLabel_4.setBounds(35, 15, 220, 25);
	    panel.add(lblNewLabel_4);
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_4.setText("Thông tin công đoạn");
	    
	    panel_1 = new JPanel();
	    panel_1.setBounds(15, 90, 900, 315);
	    panel_1.setBackground(Color.WHITE);
	    add(panel_1);
	    panel_1.setLayout(null);
	    
	    lblNewLabel_5 = new JLabel("New label");
	    lblNewLabel_5.setBounds(35, 15, 217, 25);
	    panel_1.add(lblNewLabel_5);
	    lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_5.setText("Danh sách sản phẩm");
	    
	    scrollPane = new JScrollPane();
	    scrollPane.setBounds(20, 65, 860, 230);
	    panel_1.add(scrollPane);
	    int rowHeight = 30;
	    int rowMargin = 10;
	    table = new JTable();
	    scrollPane.setViewportView(table);
	    table.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    	},
	    	new String[] {
	    		"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Lo\u1EA1i s\u1EA3n ph\u1EA9m", "Gi\u00E1 b\u00E1n"
	    	}
	    ) {
	    	boolean[] columnEditables = new boolean[] {
	    		false, false, false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    JTableHeader tb = table.getTableHeader();
	    tb.setBackground(new Color(221, 242, 251));
	    tb.setFont(new Font("Tahoma", Font.BOLD, 16));
	    table.setRowHeight(rowHeight);
	    table.setIntercellSpacing(new Dimension(0, rowMargin));
	    
	    separator_1 = new JSeparator();
	    separator_1.setBackground(Color.BLACK);
	    separator_1.setForeground(Color.BLACK);
	    separator_1.setBounds(15, 430, 1420, 3);
	    add(separator_1);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBackground(Color.WHITE);
	    panel_2.setBounds(15, 490, 1420, 200);
	    add(panel_2);
	    panel_2.setLayout(null);
	    
	    scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(20, 10, 1380, 180);
	    panel_2.add(scrollPane_1);
	    
	    table_1 = new JTable();
	    scrollPane_1.setViewportView(table_1);
	    JTableHeader tb1 = table_1.getTableHeader();
	    tb1.setBackground(new Color(221, 242, 251));
	    tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    table_1.setRowHeight(rowHeight);
	    table_1.setIntercellSpacing(new Dimension(0, rowMargin));
	    
	    table_1.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n", "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i S\u1EA3n Ph\u1EA9m", "Gi\u00E1 C\u00F4ng \u0110o\u1EA1n"
	    	}
	    ) {
	    	boolean[] columnEditables = new boolean[] {
	    		false, false, false, false, false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    
	    JLabel lblNewLabel_6 = new JLabel("New label");
	    lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_6.setBounds(49, 450, 217, 25);
	    add(lblNewLabel_6);
	    lblNewLabel_6.setText("Danh sách công đoạn");
	    
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
