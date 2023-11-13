package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import Connection.MyConnection;
import DAO.DAO_CongNhanVien;
import DAO.DAO_NhanVien;
import Entity.CongNhanVien;
import Entity.NhanVien;



public class frm_TimKiemNhanVien extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtMaNV;
	private JTextField textField_1;
	private JTextField txtCMND;
	private JTextField textField_2;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private DefaultTableModel modelNhanVien;
	private JTable tbl_bangTen;
	private DAO_NhanVien dao_nv;
	private DAO_CongNhanVien dao_cnv;
	private List<NhanVien> listnv;
	private List<CongNhanVien> listcnv;
	private JRadioButton rbtNam, rbtNu;
	private ButtonGroup G;
	private SimpleDateFormat dateFormat;
	private JButton btnXoaRong,btnTimKiem;
	public frm_TimKiemNhanVien() {
		
		dao_nv = new DAO_NhanVien();
		dao_cnv = new DAO_CongNhanVien();
		setLayout(null);
		setBackground(new Color(221, 242, 251));
		
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
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
	    

	    tbl_bangTen = new JTable();

		TableColumnModel columnModel = tbl_bangTen.getColumnModel();

		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tbl_bangTen.getTableHeader().setReorderingAllowed(false);
		scrollPane_1.setViewportView(tbl_bangTen);

		String[] colHeader = { "Mã Nhân Viên", "Họ tên nhân viên", "Giới Tính", "Ngày Sinh", "CMND", "SDT" };

		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tbl_bangTen.getTableHeader().setReorderingAllowed(false);
		scrollPane_1.setViewportView(tbl_bangTen);

		modelNhanVien = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = { false, false, false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		scrollPane_1.setViewportView(tbl_bangTen);

		tbl_bangTen.setModel(modelNhanVien);
		JTableHeader tbBangLuong = tbl_bangTen.getTableHeader();
		tbBangLuong.setBackground(new Color(151, 201, 219));
		tbBangLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		tbl_bangTen.setRowHeight(rowHeight);
		tbl_bangTen.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));
	    
		
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
	    
	     btnTimKiem = new JButton("Tìm kiếm");
	    btnTimKiem.setForeground(Color.WHITE);
	    btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnTimKiem.setBackground(new Color(2, 104, 156));
	    btnTimKiem.setBounds(499, 255, 170, 50);
	    panel.add(btnTimKiem);
	    
	     btnXoaRong = new JButton("Xoá rỗng");
	    btnXoaRong.setForeground(Color.WHITE);
	    btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnXoaRong.setBackground(new Color(2, 104, 156));
	    btnXoaRong.setBounds(803, 255, 170, 50);
	    panel.add(btnXoaRong);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(new Color(255, 255, 255));
	    panel_1.setBounds(50, 65, 519, 25);
	    panel.add(panel_1);
	    panel_1.setLayout(null);
	    
	    JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1.setBounds(31, 0, 140, 25);
	    panel_1.add(lblNewLabel_1);
	    
	    textField = new JTextField();
	    textField.setEditable(false);
	    textField.setBounds(180, 0, 380, 25);
	    
	    txtMaNV = new JTextField();
	    txtMaNV.setBounds(201, 0, 318, 25);
	    panel_1.add(txtMaNV);
	    txtMaNV.setColumns(10);
	    
	    JPanel panel_1_1 = new JPanel();
	    panel_1_1.setLayout(null);
	    panel_1_1.setBackground(Color.WHITE);
	    panel_1_1.setBounds(91, 122, 560, 25);
	    panel_1_1.setBounds(50, 134, 519, 25);
	    panel.add(panel_1_1);
	    JLabel lblNewLabel_1_1 = new JLabel("CMND:");
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_1.setBounds(31, 0, 140, 25);
	    panel_1_1.add(lblNewLabel_1_1);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(180, 0, 380, 25);
	    
	    txtCMND = new JTextField();
	    txtCMND.setColumns(10);
	    txtCMND.setBounds(201, 0, 318, 25);
	    panel_1_1.add(txtCMND);
	    
	    JPanel panel_1_2 = new JPanel();
	    panel_1_2.setLayout(null);
	    panel_1_2.setBackground(Color.WHITE);
	    panel_1_2.setBounds(759, 65, 560, 25);
	    panel_1_2.setBounds(800, 65, 519, 25);
	    panel.add(panel_1_2);
	    
	    JLabel lblNewLabel_1_22 = new JLabel("Họ tên:");
	    lblNewLabel_1_22.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_22.setBounds(31, 0, 140, 25);
	    panel_1_2.add(lblNewLabel_1_22);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(180, 0, 380, 25);
	    
	    txtHoTen = new JTextField();
	    txtHoTen.setColumns(10);
	    txtHoTen.setBounds(201, 0, 318, 25);
	    panel_1_2.add(txtHoTen);
	    
	    JPanel panel_1_3 = new JPanel();
	    panel_1_3.setLayout(null);
	    panel_1_3.setBackground(Color.WHITE);
	    panel_1_3.setBounds(759, 122, 560, 25);
	    panel_1_3.setBounds(800, 134, 519, 25);
	    panel.add(panel_1_3);
	    
	    JLabel lblNewLabel_1_3 = new JLabel("Số điện thoại:");
	    lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel_1_3.setBounds(31, 0, 140, 25);
	    panel_1_3.add(lblNewLabel_1_3);
	    
	    txtSDT = new JTextField();
	    txtSDT.setColumns(10);
	    txtSDT.setBounds(180, 0, 380, 25);
	    panel_1_3.add(txtSDT);
	    
	    JPanel panel_1_4 = new JPanel();
	    panel_1_4.setBackground(Color.WHITE);
	    panel_1_4.setBounds(448, 202, 560, 25);
	    panel.add(panel_1_4);
	    panel_1_4.setLayout(null);
	    
	    JLabel lblNewLabel_4 = new JLabel("Giới tính:");
	    lblNewLabel_4.setBounds(32, 0, 85, 25);
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_1_4.add(lblNewLabel_4);
	    
	    
	    JLabel lblNewLabel_3 = new JLabel("Nam");
	    lblNewLabel_3.setBounds(256, 0, 85, 25);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_1_4.add(lblNewLabel_3);
	    txtSDT.setBounds(201, 0, 318, 25);
	    panel_1_3.add(txtSDT);
	    
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
	    
	    JRadioButton rbtNam = new JRadioButton("");
	    rbtNam.setBounds(225, 0, 25, 25);
	    rbtNam.setSelected(true);
	    rbtNam.setBackground(new Color(255, 255, 255));
	    rbtNam.setHorizontalAlignment(SwingConstants.CENTER);
	    panel_1_4.add(rbtNam);
	    
	    JRadioButton rbtNu = new JRadioButton("");
	    rbtNu.setHorizontalAlignment(SwingConstants.CENTER);
	    rbtNu.setBackground(Color.WHITE);
	    rbtNu.setBounds(373, 0, 25, 25);
	    panel_1_4.add(rbtNu);
	    rdbtnNewRadioButton_4.setBounds(395, 0, 25, 25);
	    
	    G = new ButtonGroup();
		G.add(rbtNam);
		G.add(rbtNu);
		
		btnTimKiem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		MyConnection.getInstance().MyConnection();
		updateTableDataNhanVien();
	}
	private void updateTableDataNhanVien() {

		listnv = dao_nv.docTuBang();
		listcnv = dao_cnv.docTuBang();
		modelNhanVien.setRowCount(0);

		for (int i = 0; i < listnv.size(); i++) {
			NhanVien nv = listnv.get(i);
			if (i < listcnv.size()) {
				CongNhanVien cnv = listcnv.get(i);
				String gioiTinh = cnv.isGioiTinh() ? "Nam" : "Nữ";
				String ngaySinh = dateFormat.format(cnv.getNgaySinh());
				String[] rowData = { nv.getMaNhanVien(), cnv.getHoTen(), gioiTinh, ngaySinh, cnv.getMaCanCuocCongDan(),
						cnv.getSoDienThoai() };
				modelNhanVien.addRow(rowData);
			} else {

				String[] rowData = { nv.getMaNhanVien(), "", "", "", "", "" };
				modelNhanVien.addRow(rowData);
			}
		}

	}
	public void xoaRong() {
		txtMaNV.setText("");
		txtCMND.setText("");
		txtHoTen.setText("");
		txtSDT.setText("");
		rbtNam.setSelected(true);
		txtMaNV.requestFocus();
		tbl_bangTen.clearSelection();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnXoaRong)) {
			xoaRong();
		}else if (o.equals(btnTimKiem)) {
		    String ma = txtMaNV.getText();
		    String sdt = txtSDT.getText();
		    String cmnd = txtCMND.getText();
		    String hoTen = txtHoTen.getText();

		    DefaultTableModel model = (DefaultTableModel) tbl_bangTen.getModel();
		    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
		    tbl_bangTen.setRowSorter(sorter);
		    List<RowFilter<Object, Object>> filters = new ArrayList<>();
		    filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(ma), 0));
		    filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(hoTen), 1));

		    
//		    boolean phai = true;
//			if (G.getSelection() != null) {
//				if (G.getSelection().equals(rbtNam.getModel())) {
//					phai = "Nam";
//				} else if (G.getSelection().equals(rbtNu.getModel())) {
//					phai = "Nữ";
//				}
//			}
//		    filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(String.valueOf(phai)), 2));

		    filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(sdt), 5));
		    filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(cmnd), 4));

		    RowFilter<Object, Object> af = RowFilter.andFilter(filters);
		    sorter.setRowFilter(af);

		   
		}

		
	}
}
