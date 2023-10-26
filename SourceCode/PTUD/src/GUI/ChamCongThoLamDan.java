package GUI;

import java.awt.Color;
import java.awt.Event;

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

public class ChamCongThoLamDan extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtTenThoLamDan;
	private JTextField txtMaNhanVien;
	private JTextField txtSoNgayDiLam;
	private JTextField txtNghiCoPhep;
	private JTextField txtSNgayLamNuaCa;
	private JTextField txtThang;
	private JTextField txtPhCpThm;
	private JTable tbl_BangChamCong;
	private JTable tbl_BangPhanCong;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ChamCongThoLamDan() {
		setBackground(new Color(221, 242, 251));
		setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Chấm Công Thợ Làm Đàn");
		lblTieuDe.setForeground(new Color(0, 27, 72));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(301, 0, 850, 90);
		add(lblTieuDe);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(820, 90, 620, 270);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblThongTin = new JLabel("Thông tin lương thợ làm đàn\r\n");
		lblThongTin.setForeground(new Color(0, 27, 72));
		lblThongTin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTin.setBounds(30, 10, 324, 25);
		panel.add(lblThongTin);
		
		JLabel lblTenThoLamDan = new JLabel("Tên thợ làm đàn");
		lblTenThoLamDan.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTenThoLamDan.setBounds(300, 55, 100, 15);
		panel.add(lblTenThoLamDan);
		
		JLabel lblMaNhanVien = new JLabel("Mã thợ làm đàn");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMaNhanVien.setBounds(20, 55, 103, 15);
		panel.add(lblMaNhanVien);
		
		JLabel lblSoNgayDiLam = new JLabel("Công việc");
		lblSoNgayDiLam.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSoNgayDiLam.setBounds(20, 115, 76, 15);
		panel.add(lblSoNgayDiLam);
		
		JLabel lblNghiCoPhep = new JLabel("Số lượng");
		lblNghiCoPhep.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNghiCoPhep.setBounds(20, 145, 110, 15);
		panel.add(lblNghiCoPhep);
		
		JLabel lblSNgayLamNuaCa = new JLabel("Giá tiền");
		lblSNgayLamNuaCa.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSNgayLamNuaCa.setBounds(300, 115, 116, 15);
		panel.add(lblSNgayLamNuaCa);
		
		txtTenThoLamDan = new JTextField();
		txtTenThoLamDan.setEditable(false);
		txtTenThoLamDan.setBackground(new Color(151, 202, 219));
		txtTenThoLamDan.setColumns(10);
		txtTenThoLamDan.setBounds(450, 55, 130, 15);
		panel.add(txtTenThoLamDan);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setBackground(new Color(151, 202, 219));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(160, 55, 100, 15);
		panel.add(txtMaNhanVien);
		
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
		
		txtSNgayLamNuaCa = new JTextField();
		txtSNgayLamNuaCa.setEditable(false);
		txtSNgayLamNuaCa.setBackground(new Color(151, 202, 219));
		txtSNgayLamNuaCa.setColumns(10);
		txtSNgayLamNuaCa.setBounds(450, 115, 130, 15);
		panel.add(txtSNgayLamNuaCa);
		
		JLabel lblThng = new JLabel("Ngày chấm công");
		lblThng.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblThng.setBounds(20, 85, 103, 15);
		panel.add(lblThng);
		
		txtThang = new JTextField();
		txtThang.setEditable(false);
		txtThang.setColumns(10);
		txtThang.setBackground(new Color(151, 202, 219));
		txtThang.setBounds(160, 85, 100, 15);
		panel.add(txtThang);
		
		JLabel lblPhCpThm = new JLabel("Sản phẩm");
		lblPhCpThm.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPhCpThm.setBounds(300, 85, 116, 15);
		panel.add(lblPhCpThm);
		
		txtPhCpThm = new JTextField();
		txtPhCpThm.setEditable(false);
		txtPhCpThm.setColumns(10);
		txtPhCpThm.setBackground(new Color(151, 202, 219));
		txtPhCpThm.setBounds(450, 85, 130, 15);
		panel.add(txtPhCpThm);
		
		JButton btnChamCong = new JButton("Chấm công");
		btnChamCong.setBounds(60, 210, 140, 40);
		panel.add(btnChamCong);
		btnChamCong.setForeground(Color.WHITE);
		btnChamCong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChamCong.setBackground(new Color(2, 104, 156));
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHuy.setBackground(new Color(120, 186, 219));
		btnHuy.setBounds(240, 210, 140, 40);
		panel.add(btnHuy);
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoaRong.setBackground(new Color(2, 104, 156));
		btnXoaRong.setBounds(420, 210, 140, 40);
		panel.add(btnXoaRong);
		
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
		
		JLabel lblBDanhSachChamCong = new JLabel("Danh sách chấm công thợ làm đàn");
		lblBDanhSachChamCong.setForeground(new Color(0, 27, 72));
		lblBDanhSachChamCong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBDanhSachChamCong.setBounds(30, 10, 420, 25);
		panel_1_1.add(lblBDanhSachChamCong);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 50, 1360, 214);
		panel_1_1.add(scrollPane_1);
		
		
		
		DefaultTableModel model_BangChamCong= new DefaultTableModel(
				new String[] {
					"M\u00E3 Th\u1EE3 L\u00E0m \u0110\u00E0n", "H\u1ECD T\u00EAn", "C\u00F4ng vi\u1EC7c", "S\u1ED1 l\u01B0\u1EE3ng", "Ng\u00E0y ch\u1EA5m c\u00F4ng"
				},6) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		tbl_BangChamCong = new JTable(model_BangChamCong);
		scrollPane_1.setViewportView(tbl_BangChamCong);
		tbl_BangChamCong.getColumnModel().getColumn(0).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(1).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(2).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(3).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(4).setResizable(false);
		
		JTableHeader tbBangLuong= tbl_BangChamCong.getTableHeader();
		tbBangLuong.setBackground(new Color(151, 201, 219));
		tbBangLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
	    int rowMargin = 10;
	    tbl_BangChamCong.setRowHeight(rowHeight);
	    tbl_BangChamCong.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_2.setBounds(15, 90, 775, 270);
		add(panel_1_2);
		
		JLabel lblThongTin_1 = new JLabel("Bảng phân công");
		lblThongTin_1.setForeground(new Color(0, 27, 72));
		lblThongTin_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTin_1.setBounds(20, 10, 271, 25);
		panel_1_2.add(lblThongTin_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 58, 730, 185);
		panel_1_2.add(scrollPane);
		DefaultTableModel model_BagPhanCong=new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"M\u00E3 TLD", "H\u1ECD t\u00EAn", "S\u1EA3n ph\u1EA9m", "C\u00F4ng \u0111o\u1EA1n", "Gi\u00E1 ti\u1EC1n", "S\u1ED1 l\u01B0\u1EE3ng"
				}
			) {
				/**s
				 * 
				 */
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		tbl_BangPhanCong = new JTable(model_BagPhanCong);
		tbl_BangPhanCong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbl_BangPhanCong);
		tbl_BangPhanCong.getColumnModel().getColumn(0).setResizable(false);
		tbl_BangPhanCong.getColumnModel().getColumn(1).setResizable(false);
		tbl_BangPhanCong.getColumnModel().getColumn(2).setResizable(false);
		tbl_BangPhanCong.getColumnModel().getColumn(3).setResizable(false);
		tbl_BangPhanCong.getColumnModel().getColumn(4).setResizable(false);
		tbl_BangPhanCong.getColumnModel().getColumn(5).setResizable(false);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(229, 10, 210, 25);
		panel_1_2.add(textField_1);
		
		JButton btnTnhTonB_1 = new JButton("");
		btnTnhTonB_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JTableHeader tbNhanVien= tbl_BangPhanCong.getTableHeader();
		tbNhanVien.setBackground(new Color(151, 201, 219));
		tbNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
        tbl_BangPhanCong.setRowHeight(rowHeight);
        tbl_BangPhanCong.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));
	        
		btnTnhTonB_1.setIcon(new ImageIcon(ChamCongThoLamDan.class.getResource("/icons/search_icon.png")));
		btnTnhTonB_1.setForeground(Color.WHITE);
		btnTnhTonB_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTnhTonB_1.setBackground(new Color(2, 104, 156));
		btnTnhTonB_1.setBounds(500, 10, 61, 25);
		panel_1_2.add(btnTnhTonB_1);
		
		
		
		btnChamCong.addActionListener(this);
		btnHuy.addActionListener(this);
		btnHuy.setEnabled(false);
		btnXoaRong.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
