package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.toedter.calendar.JYearChooser;

import Connection.MyConnection;
import DAO.DAO_LuongNhanVien;
import DAO.DAO_NhanVien;
import DAO.DAO_PhongBan;
import Entity.BangLuongNhanVien;
import Entity.NhanVien;
import Entity.PhongBan;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class frm_LuongNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tbl_BangLuong;
	private JTextField txtTen;
	private DefaultTableModel modelDanhSachLuong;
	private DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	private DAO_LuongNhanVien dao_LuongNhanVien = new DAO_LuongNhanVien();
	private static JYearChooser yearChooser;
	private static JComboBox<Object> cmbThang;
	private DAO_PhongBan dao_PhongBan = new DAO_PhongBan();

	/**
	 * Create the panel.
	 */
	public frm_LuongNhanVien() {
		MyConnection.getInstance().MyConnection();
		setBackground(new Color(221, 242, 251));
		setLayout(null);
		JLabel lblTieuDe = new JLabel("Lương Nhân Viên");
		lblTieuDe.setForeground(new Color(0, 27, 72));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(301, 0, 850, 90);
		add(lblTieuDe);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(2, 104, 156));
		separator.setForeground(new Color(2, 104, 156));
		separator.setBounds(15, 170, 1420, 2);
		add(separator);

		JPanel panel_ThongTinLuong = new JPanel();
		panel_ThongTinLuong.setBackground(Color.WHITE);
		panel_ThongTinLuong.setLayout(null);
		panel_ThongTinLuong.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_ThongTinLuong.setBounds(15, 191, 1420, 499);
		add(panel_ThongTinLuong);

		JLabel lblBngLngNhn = new JLabel("Danh sách tiền lương nhân viên");
		lblBngLngNhn.setForeground(new Color(0, 27, 72));
		lblBngLngNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBngLngNhn.setBounds(30, 10, 340, 30);
		panel_ThongTinLuong.add(lblBngLngNhn);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 50, 1360, 426);
		panel_ThongTinLuong.add(scrollPane_1);

		tbl_BangLuong = new JTable();

		scrollPane_1.setViewportView(tbl_BangLuong);
		String[] colHeader = { "Mã Nhân Viên", "H\u1ECD T\u00EAn", "Ph\u1EE5 c\u1EA5p th\u00E2m ni\u00EAn",
				"Ti\u1EC1n L\u01B0\u01A1ng", "T\u1ED5ng Ti\u1EC1n L\u01B0\u01A1ng" };

		modelDanhSachLuong = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbl_BangLuong.setModel(modelDanhSachLuong);
		TableColumnModel columnModel = tbl_BangLuong.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tbl_BangLuong.getTableHeader().setReorderingAllowed(false);

		JTableHeader tbBangLuong = tbl_BangLuong.getTableHeader();
		tbBangLuong.setBackground(new Color(151, 201, 219));
		tbBangLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		tbl_BangLuong.setRowHeight(rowHeight);
		tbl_BangLuong.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBackground(Color.WHITE);
		txtTen.setBounds(558, 10, 210, 30);
		txtTen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ten = txtTen.getText().trim();
				if (ten.equals("")) {
					loadDataLuong();
					modelDanhSachLuong.fireTableDataChanged();
				} else {
					loadDataLuongTheoTen(ten);
					modelDanhSachLuong.fireTableDataChanged();
				}
			}
		});
		panel_ThongTinLuong.add(txtTen);

		JButton btnTimTheoTen = new JButton("");
		btnTimTheoTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = txtTen.getText().trim();
				if (ten.equals("")) {
					loadDataLuong();
					modelDanhSachLuong.fireTableDataChanged();
				} else {
					loadDataLuongTheoTen(ten);
					modelDanhSachLuong.fireTableDataChanged();
				}

			}
		});
		btnTimTheoTen.setIcon(new ImageIcon(frm_LuongNhanVien.class.getResource("/icons/search_icon.png")));
		btnTimTheoTen.setForeground(Color.WHITE);
		btnTimTheoTen.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTimTheoTen.setBackground(new Color(2, 104, 156));
		btnTimTheoTen.setBounds(793, 10, 61, 30);
		panel_ThongTinLuong.add(btnTimTheoTen);

		JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo tên");
		lblTmKimTheo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTmKimTheo.setBounds(390, 10, 176, 30);
		panel_ThongTinLuong.add(lblTmKimTheo);

		JLabel lblTmKimTheo_2 = new JLabel("Tìm kiếm theo phòng ban");
		lblTmKimTheo_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTmKimTheo_2.setBounds(880, 10, 219, 30);
		panel_ThongTinLuong.add(lblTmKimTheo_2);

		JButton btnXuat = new JButton("Xuất Excel");
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel(tbl_BangLuong);
			}
		});
		btnXuat.setForeground(Color.WHITE);
		btnXuat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXuat.setBackground(new Color(2, 104, 156));
		btnXuat.setBounds(1254, 10, 136, 30);
		panel_ThongTinLuong.add(btnXuat);

		JComboBox<String> comboBoxPhongBan = new JComboBox<String>();
		comboBoxPhongBan.setBounds(1100, 10, 100, 30);
		panel_ThongTinLuong.add(comboBoxPhongBan);
		comboBoxPhongBan.addItem("Tất Cả");
		ArrayList<PhongBan> listPhongBan = dao_PhongBan.getTatCaPhongBan();
		for (PhongBan phongBan : listPhongBan) {
			comboBoxPhongBan.addItem(phongBan.getTenPhongBan());
		}
		comboBoxPhongBan.setSelectedIndex(0);
		comboBoxPhongBan.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selectedValue = (String) comboBoxPhongBan.getSelectedItem();
					if (selectedValue.equals("Tất Cả")) {
						loadDataLuong();
						modelDanhSachLuong.fireTableDataChanged();
					} else {
						modelDanhSachLuong.setRowCount(0);
						DAO_PhongBan dao_PhongBan = new DAO_PhongBan();
						PhongBan pb = dao_PhongBan.getPhongBanTheoTen(selectedValue);
						loadDataLuongTheoPhongBan(pb.getMaPhongBan());
						modelDanhSachLuong.fireTableDataChanged();
					}
				}
			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(2, 104, 156));
		separator_1.setBackground(new Color(2, 104, 156));
		separator_1.setBounds(369, 10, 21, 30);
		panel_ThongTinLuong.add(separator_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(15, 90, 1420, 67);
		add(panel_1);

		JLabel lblThang = new JLabel("Tháng");
		lblThang.setBounds(30, 20, 80, 30);
		panel_1.add(lblThang);
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 16));

		yearChooser = new JYearChooser();
		yearChooser.setLocation(250, 20);
		yearChooser.setSize(60, 30);
		panel_1.add(yearChooser);

		String[] thang = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cmbThang = new JComboBox<Object>(thang);
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		int monthValue = currentMonth.getValue();
		cmbThang.setSelectedIndex(monthValue - 1);
		cmbThang.setBounds(110, 20, 56, 30);
		panel_1.add(cmbThang);

		JLabel lblNam = new JLabel("Năm");
		lblNam.setBounds(190, 20, 80, 30);
		panel_1.add(lblNam);
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnXemLuong = new JButton("Tính lương");
		btnXemLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedYear = yearChooser.getYear();
		        int selectedMonth = Integer.parseInt(cmbThang.getSelectedItem().toString());

		        LocalDate currentDate = LocalDate.now();
		        int currentYear = currentDate.getYear();
		        int currentMonth = currentDate.getMonthValue();

		        if (selectedYear > currentYear || (selectedYear == currentYear && selectedMonth > currentMonth)) {
		            JOptionPane.showMessageDialog(null, "Tháng và năm không hợp lệ! Vui lòng chọn một tháng và năm trong phù hợp.");
		            return;
		        }
				panel_ThongTinLuong.setEnabled(true);
				for (Component component : panel_ThongTinLuong.getComponents()) {
					component.setEnabled(true);
				}
				comboBoxPhongBan.setSelectedIndex(0);
				txtTen.setText("");
				modelDanhSachLuong.setRowCount(0);
				int nam = yearChooser.getYear();
				int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
				float soNgayThuongDiLam;
				int soGioTangCaNgayThuong;
				float soNgayLamChuNhat;
				int soGioTangCaChuNhat;
				int soNgayNghiKhongPhep;
				int soNgayNghiCoPhep;

				for (NhanVien nhanVien : dao_NhanVien.getAllListNhanVien()) {
					soNgayThuongDiLam = (float) (dao_LuongNhanVien
							.laySoNgayDiLamNguyenCaNgayThuong(nhanVien.getMaNhanVien(), thang, nam) * 1.0
							+ 0.5 * dao_LuongNhanVien.laySoNgayDiLamNuaCaNgayThuong(nhanVien.getMaNhanVien(), thang,
									nam));
					soGioTangCaNgayThuong = dao_LuongNhanVien.laySoGioTangCaNgayThuong(nhanVien.getMaNhanVien(), thang,
							nam);
					soNgayLamChuNhat = (float) (dao_LuongNhanVien.laySoNgayDiLamNguyenCaCN(nhanVien.getMaNhanVien(),
							thang, nam) * 1.0
							+ 0.5 * dao_LuongNhanVien.laySoNgayDiLamNuaCaCN(nhanVien.getMaNhanVien(), thang, nam));
					soGioTangCaChuNhat = dao_LuongNhanVien.laySoGioTangCaCN(nhanVien.getMaNhanVien(), thang, nam);
					soNgayNghiKhongPhep = dao_LuongNhanVien.laySoNgayNghiKhongPhep(nhanVien.getMaNhanVien(), thang,
							nam);
					soNgayNghiCoPhep = dao_LuongNhanVien.laySoNgayNghiCoPhep(nhanVien.getMaNhanVien(), thang, nam);
					BangLuongNhanVien bl = new BangLuongNhanVien();
					bl.setNam(nam);
					bl.setThang(thang);
					bl.setNhanVien(nhanVien);
					bl.setSoGioTangCaChuNhat(soGioTangCaChuNhat);
					bl.setSoGioTangCaNgayThuong(soGioTangCaNgayThuong);
					bl.setSoNgayLamChuNhat(soNgayLamChuNhat);
					bl.setSoNgayThuongDiLam(soNgayThuongDiLam);
					bl.setSoNgayNghiCoPhep(soNgayNghiCoPhep);
					bl.setSoNgayNghiKhongPhep(soNgayNghiKhongPhep);
					String maBangLuong = dao_LuongNhanVien.getMaBangLuong(thang, nam, nhanVien.getMaNhanVien());
					bl.setMaBangLuong(maBangLuong);
					dao_LuongNhanVien.updateBangLuongNhanVien(bl);
					DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
					double luongThucTe = bl.tinhLuongThucTe(nhanVien.getLuongCoBan(), nhanVien.tinhHeSoLuong(),
							bl.getNhanVien().getCongNhanVien().tinhPhuCapThamNienNhanVien(nhanVien.getLuongCoBan(),
									nhanVien.tinhHeSoLuong()));
					Object[] objects = { bl.getNhanVien().getMaNhanVien(),
							bl.getNhanVien().getCongNhanVien().getHoTen(),
							decimalFormat.format(bl.getNhanVien().getCongNhanVien()
									.tinhPhuCapThamNienNhanVien(nhanVien.getLuongCoBan(), nhanVien.tinhHeSoLuong())),
							decimalFormat.format(luongThucTe), decimalFormat.format(bl.tinhLuongThucLinh(luongThucTe,
									nhanVien.getLuongCoBan(), nhanVien.tinhHeSoLuong())) };
					modelDanhSachLuong.addRow(objects);
				}

			}
		});
		btnXemLuong.setIcon(null);
		btnXemLuong.setForeground(Color.WHITE);
		btnXemLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXemLuong.setBackground(new Color(2, 104, 156));
		btnXemLuong.setBounds(340, 20, 130, 30);

		panel_1.add(btnXemLuong);
		panel_ThongTinLuong.setEnabled(false);
		for (Component component : panel_ThongTinLuong.getComponents()) {
			component.setEnabled(false);
		}

		tbl_BangLuong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl_BangLuong.getSelectedRow();
				int nam = yearChooser.getYear();
				int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
				String maBangLuong = dao_LuongNhanVien.getMaBangLuong(thang, nam,
						(String) modelDanhSachLuong.getValueAt(row, 0));
				BangLuongNhanVien bangLuongNhanVien = dao_LuongNhanVien.getBangLuongTheoMa(maBangLuong);
				frm_ChiTietBangLuongNhanVien bangLuong = new frm_ChiTietBangLuongNhanVien(bangLuongNhanVien);
				bangLuong.setVisible(true);
			}
		});
	}

	private void loadDataLuong() {
		modelDanhSachLuong.setRowCount(0);
		int nam = yearChooser.getYear();
		int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
		float soNgayThuongDiLam;
		int soGioTangCaNgayThuong;
		float soNgayLamChuNhat;
		int soGioTangCaChuNhat;
		int soNgayNghiKhongPhep;
		int soNgayNghiCoPhep;

		for (NhanVien nhanVien : dao_NhanVien.getAllListNhanVien()) {
			soNgayThuongDiLam = (float) (dao_LuongNhanVien.laySoNgayDiLamNguyenCaNgayThuong(nhanVien.getMaNhanVien(),
					thang, nam) * 1.0
					+ 0.5 * dao_LuongNhanVien.laySoNgayDiLamNuaCaNgayThuong(nhanVien.getMaNhanVien(), thang, nam));
			soGioTangCaNgayThuong = dao_LuongNhanVien.laySoGioTangCaNgayThuong(nhanVien.getMaNhanVien(), thang, nam);
			soNgayLamChuNhat = (float) (dao_LuongNhanVien.laySoNgayDiLamNguyenCaCN(nhanVien.getMaNhanVien(), thang, nam)
					* 1.0 + 0.5 * dao_LuongNhanVien.laySoNgayDiLamNuaCaCN(nhanVien.getMaNhanVien(), thang, nam));
			soGioTangCaChuNhat = dao_LuongNhanVien.laySoGioTangCaCN(nhanVien.getMaNhanVien(), thang, nam);
			soNgayNghiKhongPhep = dao_LuongNhanVien.laySoNgayNghiKhongPhep(nhanVien.getMaNhanVien(), thang, nam);
			soNgayNghiCoPhep = dao_LuongNhanVien.laySoNgayNghiCoPhep(nhanVien.getMaNhanVien(), thang, nam);
			BangLuongNhanVien bl = new BangLuongNhanVien();
			bl.setNam(nam);
			bl.setThang(thang);
			bl.setNhanVien(nhanVien);
			bl.setSoGioTangCaChuNhat(soGioTangCaChuNhat);
			bl.setSoGioTangCaNgayThuong(soGioTangCaNgayThuong);
			bl.setSoNgayLamChuNhat(soNgayLamChuNhat);
			bl.setSoNgayThuongDiLam(soNgayThuongDiLam);
			bl.setSoNgayNghiCoPhep(soNgayNghiCoPhep);
			bl.setSoNgayNghiKhongPhep(soNgayNghiKhongPhep);
			String maBangLuong = dao_LuongNhanVien.getMaBangLuong(thang, nam, nhanVien.getMaNhanVien());
			bl.setMaBangLuong(maBangLuong);
			dao_LuongNhanVien.updateBangLuongNhanVien(bl);
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
			double luongThucTe = bl.tinhLuongThucTe(nhanVien.getLuongCoBan(), nhanVien.tinhHeSoLuong(), bl.getNhanVien()
					.getCongNhanVien().tinhPhuCapThamNienNhanVien(nhanVien.getLuongCoBan(), nhanVien.tinhHeSoLuong()));

			Object[] objects = { bl.getNhanVien().getMaNhanVien(), bl.getNhanVien().getCongNhanVien().getHoTen(),
					decimalFormat.format(bl.getNhanVien().getCongNhanVien().tinhPhuCapThamNienNhanVien(nhanVien.getLuongCoBan(),
							nhanVien.tinhHeSoLuong())),
					decimalFormat.format(luongThucTe), decimalFormat.format(
							bl.tinhLuongThucLinh(luongThucTe, nhanVien.getLuongCoBan(), nhanVien.tinhHeSoLuong())) };
			modelDanhSachLuong.addRow(objects);
		}
	}

	private void loadDataLuongTheoTen(String tenNhanVien) {

		try {
			int sl = dao_LuongNhanVien.kiemTraTimKiemTheoTen(tenNhanVien);
			if (sl == 0) {
				modelDanhSachLuong.setRowCount(0);
				JOptionPane.showMessageDialog(null, "Không có tên nhân viên tìm kiếm");
			} else {
				modelDanhSachLuong.setRowCount(0);
				int nam = yearChooser.getYear();
				int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
				ArrayList<BangLuongNhanVien> listBL = dao_LuongNhanVien.getBangLuongTheoTen(tenNhanVien, thang, nam);
				for (BangLuongNhanVien bangLuongNhanVien : listBL) {
					DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
					double luongThucTe = bangLuongNhanVien.tinhLuongThucTe(
							bangLuongNhanVien.getNhanVien().getLuongCoBan(),
							bangLuongNhanVien.getNhanVien().tinhHeSoLuong(),
							bangLuongNhanVien.getNhanVien().getCongNhanVien().tinhPhuCapThamNienNhanVien(
									bangLuongNhanVien.getNhanVien().getLuongCoBan(),
									bangLuongNhanVien.getNhanVien().tinhHeSoLuong()));
					Object[] objects = { bangLuongNhanVien.getNhanVien().getMaNhanVien(),
							bangLuongNhanVien.getNhanVien().getCongNhanVien().getHoTen(),
							decimalFormat.format(bangLuongNhanVien.getNhanVien().getCongNhanVien().tinhPhuCapThamNienNhanVien(
									bangLuongNhanVien.getNhanVien().getLuongCoBan(),
									bangLuongNhanVien.getNhanVien().tinhHeSoLuong())),
							decimalFormat.format(luongThucTe),
							decimalFormat.format(bangLuongNhanVien.tinhLuongThucLinh(luongThucTe,
									bangLuongNhanVien.getNhanVien().getLuongCoBan(),
									bangLuongNhanVien.getNhanVien().tinhHeSoLuong())) };
					modelDanhSachLuong.addRow(objects);
				}
			}
			modelDanhSachLuong.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadDataLuongTheoPhongBan(String maPhongBan) {

		modelDanhSachLuong.setRowCount(0);
		int nam = yearChooser.getYear();
		int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
		ArrayList<BangLuongNhanVien> listBCC = dao_LuongNhanVien.getBangLuongTheoPhongBan(maPhongBan, thang, nam);
		for (BangLuongNhanVien bangLuongNhanVien : listBCC) {
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
			double luongThucTe = bangLuongNhanVien.tinhLuongThucTe(bangLuongNhanVien.getNhanVien().getLuongCoBan(),
					bangLuongNhanVien.getNhanVien().tinhHeSoLuong(),
					bangLuongNhanVien.getNhanVien().getCongNhanVien().tinhPhuCapThamNienNhanVien(
							bangLuongNhanVien.getNhanVien().getLuongCoBan(),
							bangLuongNhanVien.getNhanVien().tinhHeSoLuong()));
			Object[] objects = { bangLuongNhanVien.getNhanVien().getMaNhanVien(),
					bangLuongNhanVien.getNhanVien().getCongNhanVien().getHoTen(),
					decimalFormat.format(bangLuongNhanVien.getNhanVien().getCongNhanVien()
							.tinhPhuCapThamNienNhanVien(bangLuongNhanVien.getNhanVien().getLuongCoBan(),
									bangLuongNhanVien.getNhanVien().tinhHeSoLuong())),
					decimalFormat.format(luongThucTe),
					decimalFormat.format(bangLuongNhanVien.tinhLuongThucLinh(luongThucTe,
							bangLuongNhanVien.getNhanVien().getLuongCoBan(),
							bangLuongNhanVien.getNhanVien().tinhHeSoLuong())) };
			modelDanhSachLuong.addRow(objects);
		}
		modelDanhSachLuong.fireTableDataChanged();
	}
//
//	private void themBangLuong(NhanVien nhanVien) {
//		LocalDate currentDate = LocalDate.now();
//		Month currentMonth = currentDate.getMonth();
//		int thang = currentMonth.getValue();
//		int nam = currentDate.getYear();
//		BangLuongNhanVien bl = new BangLuongNhanVien();
//		bl.setNam(nam);
//		bl.setThang(thang);
//		bl.setNhanVien(nhanVien);
//		String maBangLuong = dao_LuongNhanVien.getMaBangLuong(thang, nam, nhanVien.getMaNhanVien());
//		bl.setMaBangLuong(maBangLuong);
//		bl.setSoGioTangCaChuNhat(0);
//		bl.setSoGioTangCaNgayThuong(0);
//		bl.setSoNgayLamChuNhat(0);
//		bl.setSoNgayNghiCoPhep(0);
//		bl.setSoNgayNghiKhongPhep(0);
//		bl.setSoNgayThuongDiLam(0);
//		dao_LuongNhanVien.themBangLuongNhanVien(bl);
//	}

	public static void exportExcel(JTable table) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn nơi lưu tệp Excel");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Tệp Excel (.xls)", "xls");
		fileChooser.setFileFilter(filter);

		int userSelection = fileChooser.showSaveDialog(null);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			try {
				File fileToSave = fileChooser.getSelectedFile();
				String filePath = fileToSave.getAbsolutePath();
				if (fileToSave.exists()) {
					int response = JOptionPane.showConfirmDialog(null, "Tệp đã tồn tại. Bạn có muốn ghi đè không?",
							"Xác nhận ghi đè", JOptionPane.YES_NO_OPTION);

					if (response != JOptionPane.YES_OPTION) {
						return;
					}
				}
				if (!filePath.endsWith(".xls")) {
					filePath += ".xls";
				}

				Workbook workbook = new HSSFWorkbook();
				Sheet sheet = workbook.createSheet("DanhSachNhanVien");

				org.apache.poi.ss.usermodel.Font titleFont = sheet.getWorkbook().createFont();
				titleFont.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
				titleFont.setFontHeightInPoints((short) 16);

				CellStyle titleCellStyle = sheet.getWorkbook().createCellStyle();
				titleCellStyle.setFont(titleFont);
				titleCellStyle.setAlignment(CellStyle.ALIGN_CENTER);

				Row titleRow = sheet.createRow(0);

				Cell titleCell = titleRow.createCell(0);
				int nam = yearChooser.getYear();
				int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
				String txt = "Danh sách lương nhân viên Tháng " + thang + " Năm " + nam;

				titleCell.setCellValue(txt);
				titleCell.setCellStyle(titleCellStyle);
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, table.getColumnCount() - 1));

				Row headerRow = sheet.createRow(1);
				for (int col = 0; col < table.getColumnCount(); col++) {
					Cell cell = headerRow.createCell(col);
					cell.setCellValue(table.getColumnName(col));
					sheet.autoSizeColumn(col);
				}

				for (int row = 0; row < table.getRowCount(); row++) {
					Row dataRow = sheet.createRow(row + 2);
					for (int col = 0; col < table.getColumnCount(); col++) {
						Cell cell = dataRow.createCell(col);
						Object cellValue = table.getValueAt(row, col);
						if (cellValue != null) {
							if (cellValue instanceof String) {
								cell.setCellValue((String) cellValue);
							} else if (cellValue instanceof Number) {
								cell.setCellValue(((Number) cellValue).doubleValue());
							} else {
								cell.setCellValue(cellValue.toString());
							}
						}
					}
				}

				for (int col = 0; col < table.getColumnCount(); col++) {
					sheet.autoSizeColumn(col);
				}

				try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
					workbook.write(fileOut);
					JOptionPane.showMessageDialog(null, "Tạo và lưu tệp Excel thành công!");
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi khi tạo và lưu tệp Excel!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}