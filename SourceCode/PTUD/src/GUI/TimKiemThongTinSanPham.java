package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class TimKiemThongTinSanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public TimKiemThongTinSanPham() {
		setLayout(null);
		setBackground(new Color(221, 242, 251));
	    
		JLabel lblNewLabel = new JLabel("New label");
	    lblNewLabel.setBounds(400, 5, 680, 70);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
	    add(lblNewLabel);
	    lblNewLabel.setText("TÌM KIẾM THÔNG TIN SẢN PHẨM");
	    
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
	    		"M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n", "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i S\u1EA3n Ph\u1EA9m", "Gi\u00E1 C\u00F4ng \u0110o\u1EA1n"
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
	    
	    JLabel lblNewLabel_6_1 = new JLabel("Tìm kiếm sản phẩm theo :");
	    lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_6_1.setBounds(35, 15, 304, 25);
	    panel.add(lblNewLabel_6_1);
	    
	    JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1.setBounds(100, 65, 170, 25);
	    panel.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Loại sản phẩm");
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_1.setBounds(100, 165, 170, 25);
	    panel.add(lblNewLabel_1_1);
	    
	    textField = new JTextField();
	    lblNewLabel_1.setLabelFor(textField);
	    textField.setColumns(10);
	    textField.setBounds(240, 65, 250, 25);
	    panel.add(textField);
	    
	    JLabel lblNewLabel_1_1_1 = new JLabel("Giá bán");
	    lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_1_1.setBounds(900, 165, 170, 25);
	    panel.add(lblNewLabel_1_1_1);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(1060, 165, 250, 25);
	    panel.add(textField_2);
	    
	    JLabel lblNewLabel_1_1_1_1 = new JLabel("Tình trạng");
	    lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_1_1_1.setBounds(900, 65, 170, 25);
	    panel.add(lblNewLabel_1_1_1_1);
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    textField_3.setBounds(1060, 65, 250, 25);
	    panel.add(textField_3);
	    
	    JButton btnTmKim = new JButton("Tìm kiếm");
	    btnTmKim.setForeground(Color.WHITE);
	    btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnTmKim.setBackground(new Color(2, 104, 156));
	    btnTmKim.setBounds(500, 225, 170, 50);
	    panel.add(btnTmKim);
	    
	    JButton btnXoRng = new JButton("Xoá rỗng");
	    btnXoRng.setForeground(Color.WHITE);
	    btnXoRng.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnXoRng.setBackground(new Color(2, 104, 156));
	    btnXoRng.setBounds(800, 225, 170, 50);
	    panel.add(btnXoRng);
	    
	    JRadioButton rdbtnMaSanPham = new JRadioButton("");
	    rdbtnMaSanPham.setBackground(Color.WHITE);
	    rdbtnMaSanPham.setBounds(60, 65, 27, 21);
	    panel.add(rdbtnMaSanPham);
	    
	    JComboBox comboBoxLoaiSanPham = new JComboBox();
	    comboBoxLoaiSanPham.setBackground(Color.WHITE);
	    comboBoxLoaiSanPham.setBounds(240, 165, 250, 25);
	    panel.add(comboBoxLoaiSanPham);
	    
	    JRadioButton rdbtnLoaiSanPham = new JRadioButton("");
	    rdbtnLoaiSanPham.setBackground(Color.WHITE);
	    rdbtnLoaiSanPham.setBounds(60, 165, 27, 21);
	    panel.add(rdbtnLoaiSanPham);
	    
	    JRadioButton rdbtnLoaiSanPham_1 = new JRadioButton("");
	    rdbtnLoaiSanPham_1.setBackground(Color.WHITE);
	    rdbtnLoaiSanPham_1.setBounds(868, 165, 27, 21);
	    panel.add(rdbtnLoaiSanPham_1);
	    
	    JRadioButton rdbtnLoaiSanPham_1_1 = new JRadioButton("");
	    rdbtnLoaiSanPham_1_1.setBackground(Color.WHITE);
	    rdbtnLoaiSanPham_1_1.setBounds(867, 65, 27, 21);
	    panel.add(rdbtnLoaiSanPham_1_1);
	    
	    
	    	  
	}
}
