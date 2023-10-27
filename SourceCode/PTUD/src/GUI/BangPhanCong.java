package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class BangPhanCong extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable table_2;
	private JTable table;
	private JDateChooser ngayPhanCong;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoaRongs;
	private JTextField txtMaPhanCong;
	private JTextField txtSoLuongSanPham;
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
		
		JPanel pnlThongTinCongDoan = new JPanel();
	    pnlThongTinCongDoan.setBounds(990, 90, 450, 315);
	    pnlThongTinCongDoan.setBackground(Color.WHITE);
	    add(pnlThongTinCongDoan);
	    pnlThongTinCongDoan.setLayout(null);
	    
	    JButton btnThem = new JButton("New button");
	    btnThem.setBounds(20, 260, 120, 30);
	    pnlThongTinCongDoan.add(btnThem);
	    btnThem.setForeground(Color.WHITE);
	    btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnThem.setBackground(new Color(2, 104, 156));
	    btnThem.setText("Thêm");
	    
	    JButton btnSua = new JButton("New button");
	    btnSua.setBounds(160, 260, 120, 30);
	    pnlThongTinCongDoan.add(btnSua);
	    btnSua.setBackground(new Color(2, 104, 156));
	    btnSua.setForeground(Color.WHITE);
	    btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnSua.setText("Sửa thông tin");
	    
	    JButton btnXoaRong = new JButton("New button");
	    btnXoaRong.setBounds(295, 260, 120, 30);
	    pnlThongTinCongDoan.add(btnXoaRong);
	    btnXoaRong.setForeground(Color.WHITE);
	    btnXoaRong.setBackground(new Color(2, 104, 156));
	    btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnXoaRong.setText("Xoá rỗng");
	   
	    
	    ngayPhanCong = new JDateChooser();
	    ngayPhanCong.setSize(new Dimension(30,20));
	    ngayPhanCong.setDateFormatString("dd-MM-yyyy");
        try {
            Date date = Date.valueOf(LocalDate.now());
            ngayPhanCong.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ngayPhanCong.setBounds(200, 207, 200, 25);
        ngayPhanCong.setEnabled(false);
        pnlThongTinCongDoan.add(ngayPhanCong);
	    
	    
	    JLabel lblNewLabel_3 = new JLabel("New label");
	    lblNewLabel_3.setBounds(20, 205, 170, 25);
	    pnlThongTinCongDoan.add(lblNewLabel_3);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_3.setText("Ngày chấm công");
	    
	    JLabel lblNewLabel_2 = new JLabel("New label");
	    lblNewLabel_2.setBounds(20, 135, 170, 25);
	    pnlThongTinCongDoan.add(lblNewLabel_2);
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_2.setText("Số lượng sản phẩm\r\n");
	    
	    JTextField txtSoLuongSanPham = new JTextField();
	    txtSoLuongSanPham.setBounds(200, 137, 200, 25);
	    pnlThongTinCongDoan.add(txtSoLuongSanPham);
	    txtSoLuongSanPham.setColumns(10);
	    lblNewLabel_2.setLabelFor(txtSoLuongSanPham);
	    txtSoLuongSanPham.setEnabled(false);
	    
	    JTextField txtMaPhanCong = new JTextField();
	    txtMaPhanCong.setBounds(200, 65, 200, 25);
	    pnlThongTinCongDoan.add(txtMaPhanCong);
	    txtMaPhanCong.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtMaPhanCong.setColumns(10);
	    txtMaPhanCong.setEnabled(false);
	    
	    
	    JLabel lblNewLabel1 = new JLabel("New label");
	    lblNewLabel1.setBounds(20, 65, 170, 25);
	    pnlThongTinCongDoan.add(lblNewLabel1);
	    lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel1.setText("Mã phân công");
	    lblNewLabel1.setLabelFor(txtMaPhanCong);
	    
	    JLabel lblNewLabel_4 = new JLabel("New label");
	    lblNewLabel_4.setBounds(35, 15, 220, 25);
	    pnlThongTinCongDoan.add(lblNewLabel_4);
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
	    ) {
	    	boolean[] columnEditables = new boolean[] {
	    		false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
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
	    ) {
	    	boolean[] columnEditables = new boolean[] {
	    		false, false, false, false, false, false, false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    
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
	    ) {
	    	boolean[] columnEditables = new boolean[] {
	    		false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    JTableHeader tb2 = table_2.getTableHeader();
	    tb2.setBackground(new Color(221, 242, 251));
	    tb2.setFont(new Font("Tahoma", Font.BOLD, 16));
	    table_2.setRowHeight(rowHeight);
	    table_2.setIntercellSpacing(new Dimension(0, rowMargin));

	    JLabel lblNewLabel_5_1 = new JLabel("Danh sách công đoạn");
	    lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNewLabel_5_1.setBounds(35, 15, 217, 25);
	    panel_3.add(lblNewLabel_5_1);
	    
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
				txtSoLuongSanPham.setEnabled(true);
			}
			else {
				btnThem.setText("Thêm");
				txtSoLuongSanPham.setEnabled(false);
			}
		}
		else if(e.getSource().equals(btnSua)) {
			if(btnSua.getText().equals("Sửa thông tin")) {
				btnSua.setText("Huỷ");
				txtSoLuongSanPham.setEnabled(true);
			}
			else {
				btnThem.setText("Sửa thông tin");
				txtSoLuongSanPham.setEnabled(false);	
			}
		}
	}
	}
	
