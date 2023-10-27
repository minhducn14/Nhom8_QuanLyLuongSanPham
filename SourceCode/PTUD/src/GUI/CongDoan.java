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

public class CongDoan extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaCongDoan;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtTenCongDoan;
	private JLabel lblNewLabel_3;
	private JTextField txtGiaCongDoan;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel_1;
	private JSeparator separator_1;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoaRong;

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
	    
	    JButton btnThem = new JButton("New button");
	    btnThem.setBounds(20, 260, 120, 30);
	    panel.add(btnThem);
	    btnThem.setForeground(Color.WHITE);
	    btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnThem.setBackground(new Color(2, 104, 156));
	    btnThem.setText("Thêm");
	    
	    JButton btnSua = new JButton("New button");
	    btnSua.setBounds(160, 260, 120, 30);
	    panel.add(btnSua);
	    btnSua.setBackground(new Color(2, 104, 156));
	    btnSua.setForeground(Color.WHITE);
	    btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnSua.setText("Sửa thông tin");
	    
	    JButton btnXoaRong = new JButton("New button");
	    btnXoaRong.setBounds(295, 260, 120, 30);
	    panel.add(btnXoaRong);
	    btnXoaRong.setForeground(Color.WHITE);
	    btnXoaRong.setBackground(new Color(2, 104, 156));
	    btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnXoaRong.setText("Xoá rỗng");
	    
	    txtGiaCongDoan = new JTextField();
	    txtGiaCongDoan.setBounds(160, 207, 250, 25);
	    panel.add(txtGiaCongDoan);
	    txtGiaCongDoan.setColumns(10);
	    txtGiaCongDoan.setEnabled(false);
	    
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
	    
	    txtTenCongDoan = new JTextField();
	    txtTenCongDoan.setBounds(160, 135, 250, 25);
	    panel.add(txtTenCongDoan);
	    txtTenCongDoan.setColumns(10);
	    lblNewLabel_2.setLabelFor(txtTenCongDoan);
	    txtTenCongDoan.setEnabled(false);
	    
	    txtMaCongDoan = new JTextField();
	    txtMaCongDoan.setBounds(160, 65, 250, 25);
	    panel.add(txtMaCongDoan);
	    txtMaCongDoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtMaCongDoan.setColumns(10);
	    txtMaCongDoan.setEnabled(false);
	    
	    
	    JLabel lblNewLabel = new JLabel("New label");
	    lblNewLabel.setBounds(20, 65, 170, 25);
	    panel.add(lblNewLabel);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel.setText("Mã công đoạn");
	    lblNewLabel.setLabelFor(txtMaCongDoan);
	    
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
	    
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaRong.addActionListener(this);
	    
	}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(btnThem)) {
				if(btnThem.getText().equals("Thêm")) {
					btnThem.setText("Lưu");
					txtGiaCongDoan.setEnabled(true);
					txtTenCongDoan.setEnabled(true);
				}
				else {
					btnThem.setText("Thêm");
					txtGiaCongDoan.setEnabled(false);
					txtTenCongDoan.setEnabled(false);
				}
			}
			else if(e.getSource().equals(btnSua)) {
				if(btnSua.getText().equals("Sửa thông tin")) {
					btnSua.setText("Huỷ");
					txtGiaCongDoan.setEnabled(true);
					txtTenCongDoan.setEnabled(true);
				}
				else {
					btnThem.setText("Sửa thông tin");
					txtGiaCongDoan.setEnabled(false);
					txtTenCongDoan.setEnabled(false);
				}
			}
		}
}
