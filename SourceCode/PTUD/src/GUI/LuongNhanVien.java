package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class LuongNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JTextField txtSoNgayDiLam;
	private JTextField txtNghiCoPhep;
	private JTextField txtSGioTangCa;
	private JTextField txtSNgayLamChuNhat;
	private JTextField txtSNgayNghiKoPhep;
	private JTextField txtSNgayLamNuaCa;
	private JTextField txtThang;
	private JTextField textField;
	private JTextField txtPhCpThm;
	private JTable tbl_BangLuong;
	private JTable tbl_NhanVien;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public LuongNhanVien() {
		setBackground(new Color(221, 242, 251));
		setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Lương Nhân Viên");
		lblTieuDe.setForeground(new Color(0, 27, 72));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(301, 0, 850, 90);
		add(lblTieuDe);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(820, 90, 615, 270);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblThongTin = new JLabel("Thông tin lương nhân viên");
		lblThongTin.setForeground(new Color(0, 27, 72));
		lblThongTin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTin.setBounds(30, 10, 271, 25);
		panel.add(lblThongTin);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMaNhanVien.setBounds(20, 55, 76, 15);
		panel.add(lblMaNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTenNhanVien.setBounds(300, 55, 76, 15);
		panel.add(lblTenNhanVien);
		
		JLabel lblSoNgayDiLam = new JLabel("Số ngày đi làm");
		lblSoNgayDiLam.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSoNgayDiLam.setBounds(20, 115, 76, 15);
		panel.add(lblSoNgayDiLam);
		
		JLabel lblNghiCoPhep = new JLabel("Số ngày nghỉ có phép");
		lblNghiCoPhep.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNghiCoPhep.setBounds(20, 145, 110, 15);
		panel.add(lblNghiCoPhep);
		
		JLabel lblSNgayNghiKoPhep = new JLabel("Số ngày nghỉ không phép");
		lblSNgayNghiKoPhep.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSNgayNghiKoPhep.setBounds(300, 145, 131, 15);
		panel.add(lblSNgayNghiKoPhep);
		
		JLabel lblSNgayLamChuNhat = new JLabel("Số ngày làm chủ nhật");
		lblSNgayLamChuNhat.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSNgayLamChuNhat.setBounds(300, 175, 131, 15);
		panel.add(lblSNgayLamChuNhat);
		
		JLabel lblSGioTangCa = new JLabel("Số giờ tăng ca");
		lblSGioTangCa.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSGioTangCa.setBounds(20, 175, 110, 15);
		panel.add(lblSGioTangCa);
		
		JLabel lblSNgayLamNuaCa = new JLabel("Số ngày đi làm nửa ca");
		lblSNgayLamNuaCa.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSNgayLamNuaCa.setBounds(300, 115, 116, 15);
		panel.add(lblSNgayLamNuaCa);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setBackground(new Color(151, 202, 219));
		txtMaNhanVien.setBounds(160, 55, 100, 15);
		panel.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setBackground(new Color(151, 202, 219));
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(450, 55, 130, 15);
		panel.add(txtTenNhanVien);
		
		txtSoNgayDiLam = new JTextField();
		txtSoNgayDiLam.setEditable(false);
		txtSoNgayDiLam.setBackground(new Color(151, 202, 219));
		txtSoNgayDiLam.setColumns(10);
		txtSoNgayDiLam.setBounds(160, 115, 100, 15);
		panel.add(txtSoNgayDiLam);
		
		txtNghiCoPhep = new JTextField();
		txtNghiCoPhep.setEditable(false);
		txtNghiCoPhep.setBackground(new Color(151, 202, 219));
		txtNghiCoPhep.setColumns(10);
		txtNghiCoPhep.setBounds(160, 145, 100, 15);
		panel.add(txtNghiCoPhep);
		
		txtSGioTangCa = new JTextField();
		txtSGioTangCa.setHorizontalAlignment(SwingConstants.TRAILING);
		txtSGioTangCa.setEditable(false);
		txtSGioTangCa.setBackground(new Color(151, 202, 219));
		txtSGioTangCa.setColumns(10);
		txtSGioTangCa.setBounds(160, 175, 100, 15);
		panel.add(txtSGioTangCa);
		
		txtSNgayLamChuNhat = new JTextField();
		txtSNgayLamChuNhat.setEditable(false);
		txtSNgayLamChuNhat.setBackground(new Color(151, 202, 219));
		txtSNgayLamChuNhat.setColumns(10);
		txtSNgayLamChuNhat.setBounds(450, 175, 130, 15);
		panel.add(txtSNgayLamChuNhat);
		
		txtSNgayNghiKoPhep = new JTextField();
		txtSNgayNghiKoPhep.setEditable(false);
		txtSNgayNghiKoPhep.setBackground(new Color(151, 202, 219));
		txtSNgayNghiKoPhep.setColumns(10);
		txtSNgayNghiKoPhep.setBounds(450, 145, 130, 15);
		panel.add(txtSNgayNghiKoPhep);
		
		txtSNgayLamNuaCa = new JTextField();
		txtSNgayLamNuaCa.setEditable(false);
		txtSNgayLamNuaCa.setBackground(new Color(151, 202, 219));
		txtSNgayLamNuaCa.setColumns(10);
		txtSNgayLamNuaCa.setBounds(450, 115, 130, 15);
		panel.add(txtSNgayLamNuaCa);
		
		JLabel lblThng = new JLabel("Tháng");
		lblThng.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblThng.setBounds(20, 85, 76, 15);
		panel.add(lblThng);
		
		txtThang = new JTextField();
		txtThang.setEditable(false);
		txtThang.setColumns(10);
		txtThang.setBackground(new Color(151, 202, 219));
		txtThang.setBounds(79, 85, 44, 15);
		panel.add(txtThang);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(151, 202, 219));
		textField.setBounds(204, 85, 44, 15);
		panel.add(textField);
		
		JLabel lblNm = new JLabel("Năm");
		lblNm.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNm.setBounds(145, 85, 76, 15);
		panel.add(lblNm);
		
		JLabel lblPhCpThm = new JLabel("Phụ cấp thâm niên");
		lblPhCpThm.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPhCpThm.setBounds(300, 85, 116, 15);
		panel.add(lblPhCpThm);
		
		txtPhCpThm = new JTextField();
		txtPhCpThm.setEditable(false);
		txtPhCpThm.setColumns(10);
		txtPhCpThm.setBackground(new Color(151, 202, 219));
		txtPhCpThm.setBounds(450, 85, 130, 15);
		panel.add(txtPhCpThm);
		
		JButton btnTnhTonB_1_1_1_1 = new JButton("Xuất file excel");
		btnTnhTonB_1_1_1_1.setBounds(230, 220, 170, 25);
		panel.add(btnTnhTonB_1_1_1_1);
		btnTnhTonB_1_1_1_1.setForeground(Color.WHITE);
		btnTnhTonB_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTnhTonB_1_1_1_1.setBackground(new Color(2, 104, 156));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(2, 104, 156));
		separator.setForeground(new Color(2, 104, 156));
		separator.setBounds(15, 380, 1420, 2);
		add(separator);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_1.setBounds(15, 400, 1420, 290);
		add(panel_1_1);
		
		JLabel lblBngLngNhn = new JLabel("Danh sách tiền lương nhân viên");
		lblBngLngNhn.setForeground(new Color(0, 27, 72));
		lblBngLngNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBngLngNhn.setBounds(30, 10, 340, 25);
		panel_1_1.add(lblBngLngNhn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 50, 1360, 214);
		panel_1_1.add(scrollPane_1);
		
		tbl_BangLuong = new JTable();
		scrollPane_1.setViewportView(tbl_BangLuong);
		tbl_BangLuong.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD T\u00EAn", "Ph\u1EE5 c\u1EA5p th\u00E2m ni\u00EAn", "Ti\u1EC1n L\u01B0\u01A1ng", "T\u1ED5ng Ti\u1EC1n L\u01B0\u01A1ng"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbl_BangLuong.getColumnModel().getColumn(0).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(1).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(2).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(3).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(4).setResizable(false);
		
		JTableHeader tbBangLuong= tbl_BangLuong.getTableHeader();
		tbBangLuong.setBackground(new Color(151, 201, 219));
		tbBangLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
	    int rowMargin = 10;
	    tbl_BangLuong.setRowHeight(rowHeight);
	    tbl_BangLuong.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBackground(Color.WHITE);
	    textField_2.setBounds(399, 10, 210, 25);
	    panel_1_1.add(textField_2);
	    
	    JButton btnTnhTonB_1_1 = new JButton("");
	    btnTnhTonB_1_1.setIcon(new ImageIcon(LuongNhanVien.class.getResource("/icons/search_icon.png")));
	    btnTnhTonB_1_1.setForeground(Color.WHITE);
	    btnTnhTonB_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnTnhTonB_1_1.setBackground(new Color(2, 104, 156));
	    btnTnhTonB_1_1.setBounds(634, 10, 61, 25);
	    panel_1_1.add(btnTnhTonB_1_1);
	    
	    JButton btnTnhTonB_1_1_1 = new JButton("Xuất toàn bộ");
	    btnTnhTonB_1_1_1.setForeground(Color.WHITE);
	    btnTnhTonB_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnTnhTonB_1_1_1.setBackground(new Color(2, 104, 156));
	    btnTnhTonB_1_1_1.setBounds(726, 10, 170, 25);
	    panel_1_1.add(btnTnhTonB_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(15, 90, 775, 67);
		add(panel_1);
		
		JButton btnTinhLuong = new JButton("Tính lương");
		btnTinhLuong.setForeground(Color.WHITE);
		btnTinhLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTinhLuong.setBackground(new Color(2, 104, 156));
		btnTinhLuong.setBounds(577, 20, 140, 30);
		panel_1.add(btnTinhLuong);
		
		JButton btnTnhTonB = new JButton("Tính toàn bộ");
		btnTnhTonB.setForeground(Color.WHITE);
		btnTnhTonB.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTnhTonB.setBackground(new Color(2, 104, 156));
		btnTnhTonB.setBounds(375, 20, 140, 30);
		panel_1.add(btnTnhTonB);
		
		JLabel lblThang = new JLabel("Tháng");
		lblThang.setBounds(10, 20, 80, 30);
		panel_1.add(lblThang);
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JComboBox cmbThang = new JComboBox();
		cmbThang.setBounds(90, 20, 56, 30);
		panel_1.add(cmbThang);
		
		JLabel lblNam = new JLabel("Năm");
		lblNam.setBounds(169, 20, 80, 30);
		panel_1.add(lblNam);
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JComboBox cmbNam = new JComboBox();
		cmbNam.setBounds(235, 20, 63, 30);
		panel_1.add(cmbNam);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_2.setBounds(15, 181, 775, 179);
		add(panel_1_2);
		
		JLabel lblThongTin_1 = new JLabel("Nhân viên");
		lblThongTin_1.setForeground(new Color(0, 27, 72));
		lblThongTin_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTin_1.setBounds(20, 10, 271, 25);
		panel_1_2.add(lblThongTin_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 58, 730, 100);
		panel_1_2.add(scrollPane);
		
		tbl_NhanVien = new JTable();
		tbl_NhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbl_NhanVien);
		tbl_NhanVien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD t\u00EAn", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "CMND", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbl_NhanVien.getColumnModel().getColumn(0).setResizable(false);
		tbl_NhanVien.getColumnModel().getColumn(1).setResizable(false);
		tbl_NhanVien.getColumnModel().getColumn(2).setResizable(false);
		tbl_NhanVien.getColumnModel().getColumn(3).setResizable(false);
		tbl_NhanVien.getColumnModel().getColumn(4).setResizable(false);
		tbl_NhanVien.getColumnModel().getColumn(5).setResizable(false);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(150, 10, 210, 25);
		panel_1_2.add(textField_1);
		
		JButton btnTnhTonB_1 = new JButton("");
		btnTnhTonB_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JTableHeader tbNhanVien= tbl_NhanVien.getTableHeader();
		tbNhanVien.setBackground(new Color(151, 201, 219));
		tbNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
        tbl_NhanVien.setRowHeight(rowHeight);
        tbl_NhanVien.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));
	        
		btnTnhTonB_1.setIcon(new ImageIcon(LuongNhanVien.class.getResource("/icons/search_icon.png")));
		btnTnhTonB_1.setForeground(Color.WHITE);
		btnTnhTonB_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTnhTonB_1.setBackground(new Color(2, 104, 156));
		btnTnhTonB_1.setBounds(385, 10, 61, 25);
		panel_1_2.add(btnTnhTonB_1);
	}
}
