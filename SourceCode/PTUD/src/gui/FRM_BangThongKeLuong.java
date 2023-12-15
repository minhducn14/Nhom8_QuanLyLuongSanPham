package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import com.toedter.calendar.JYearChooser;

import connection.MyConnection;
import dao.DAO_ThongKe;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class FRM_BangThongKeLuong extends JPanel {

	private static final long serialVersionUID = 1L;
	private JYearChooser yearChooser;
	private JComboBox<Object> cmbThang;
	private JComboBox<Object> cmbDonVi;
	private JComboBox<Object> cmbTieuChi;
//	private DefaultTableModel modelDanhSachLuong;
	private JTable table = new JTable();
	private DefaultTableModel model;
	private static DAO_ThongKe dao_ThongKe = new DAO_ThongKe();

	/**
	 * Create the panel.
	 */
	public FRM_BangThongKeLuong() {
		setBackground(new Color(221, 242, 251));
		setBounds(0, 0, 1450, 700);
		setLayout(null);

		JLabel lblBng = new JLabel("BẢNG THỐNG KÊ LƯƠNG");
		lblBng.setBounds(300, 0, 850, 60);
		lblBng.setHorizontalAlignment(SwingConstants.CENTER);
		lblBng.setForeground(new Color(0, 27, 72));
		lblBng.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblBng);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 60, 1430, 60);
		add(panel);
		panel.setLayout(null);

		JLabel lblThang = new JLabel("Tháng");
		lblThang.setBounds(45, 17, 50, 25);
		panel.add(lblThang);
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 16));

		String[] thang = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cmbThang = new JComboBox<Object>(thang);
		cmbThang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		int monthValue = currentMonth.getValue();
		cmbThang.setSelectedIndex(monthValue - 1);
		cmbThang.setBounds(105, 17, 56, 25);
		panel.add(cmbThang);

		yearChooser = new JYearChooser();
		yearChooser.setLocation(246, 17);
		yearChooser.setSize(65, 25);
		panel.add(yearChooser);

		JLabel lblNam = new JLabel("Năm");
		lblNam.setBounds(199, 17, 37, 25);
		panel.add(lblNam);
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblDonvi = new JLabel("Đơn vị");
		lblDonvi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDonvi.setBounds(349, 17, 65, 25);
		panel.add(lblDonvi);

		String[] donVi = { "Tất Cả Phòng Ban", "Phòng Kinh Doanh", "Marketing", "Phòng Nhân Sự",
				"Phòng Phát Triển Sản Phẩm", "Phòng Điều Phối" };
		cmbDonVi = new JComboBox<Object>(donVi);
		cmbDonVi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbDonVi.setBounds(417, 17, 145, 25);
		panel.add(cmbDonVi);

		JLabel lblTieuChi = new JLabel("Tiêu Chí");
		lblTieuChi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTieuChi.setBounds(592, 17, 75, 25);
		panel.add(lblTieuChi);

		String[] tieuChi = { "Lương Cao Nhất", "Lương Thấp Nhất" };
		cmbTieuChi = new JComboBox<Object>(tieuChi);
		cmbTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTieuChi.setBounds(671, 17, 135, 25);
		panel.add(cmbTieuChi);

		JButton btnTmKim = new JButton("Thống kê");
		btnTmKim.addActionListener(new ActionListener() {

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
		        
				int nam = yearChooser.getYear();
				int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
				int maxMin = cmbTieuChi.getSelectedIndex();
				int dv = cmbDonVi.getSelectedIndex();
				if (dv == 0 && maxMin == 0) {
					model = dao_ThongKe.allMax(thang, nam);
					table.setModel(model);
				} else if (dv == 0 && maxMin == 1) {
					model = dao_ThongKe.allMin(thang, nam);
					table.setModel(model);
				} else if (dv == 1 && maxMin == 0) {
					model = dao_ThongKe.phongKinhDoanhMax(thang, nam);
					table.setModel(model);
				} else if (dv == 1 && maxMin == 1) {
					model = dao_ThongKe.phongKinhDoanhMin(thang, nam);
					table.setModel(model);
				} else if (dv == 2 && maxMin == 0) {
					model = dao_ThongKe.phongMarketingMax(thang, nam);
					table.setModel(model);
				} else if (dv == 2 && maxMin == 1) {
					model = dao_ThongKe.phongMarketingMin(thang, nam);
					table.setModel(model);
				} else if (dv == 3 && maxMin == 0) {
					model = dao_ThongKe.phongNhanSuMax(thang, nam);
					table.setModel(model);
				} else if (dv == 3 && maxMin == 1) {
					model = dao_ThongKe.phongNhanSuMin(thang, nam);
					table.setModel(model);
				} else if (dv == 4 && maxMin == 0) {
					model = dao_ThongKe.phongPhatTrienSanPhamMax(thang, nam);
					table.setModel(model);
				} else if (dv == 4 && maxMin == 1) {
					model = dao_ThongKe.phongPhatTrienSanPhamMin(thang, nam);
					table.setModel(model);
				} else if (dv == 5 && maxMin == 0) {
					model = dao_ThongKe.phongDieuPhoiMax(thang, nam);
					table.setModel(model);
				} else if (dv == 5 && maxMin == 1) {
					model = dao_ThongKe.phongDieuPhoiMin(thang, nam);
					table.setModel(model);
				}
			}

		});
		MyConnection.getInstance().MyConnection();

		setLayout(null);

		setBackground(new Color(221, 242, 251));
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		table.getTableHeader().setReorderingAllowed(false);

		JTableHeader tb = table.getTableHeader();
		tb.setBackground(new Color(151, 201, 219));
		tb.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		table.setRowHeight(rowHeight);
		table.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));
		btnTmKim.setBounds(845, 7, 170, 45);
		panel.add(btnTmKim);
		btnTmKim.setForeground(Color.WHITE);
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmKim.setBackground(new Color(2, 104, 156));

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 130, 1430, 2);
		add(separator);

		JPanel panel_BangtkLuong = new JPanel();
		panel_BangtkLuong.setBackground(new Color(255, 255, 255));
		panel_BangtkLuong.setBounds(10, 142, 1430, 548);
		add(panel_BangtkLuong);
		panel_BangtkLuong.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 10, 1380, 470);
		panel_BangtkLuong.add(scrollPane_1);
		scrollPane_1.setViewportView(table);

		JButton btnTmKim_1 = new JButton("Xuất Excel");
		btnTmKim_1.setForeground(Color.WHITE);
		btnTmKim_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmKim_1.setBackground(new Color(2, 104, 156));
		btnTmKim_1.setBounds(1240, 493, 170, 45);
		panel_BangtkLuong.add(btnTmKim_1);
		btnTmKim_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exportExcel(table);
			}
		});
	}

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
				if (!filePath.endsWith(".xls")) {
					filePath += ".xls";
				}

				Workbook workbook = new HSSFWorkbook();
				Sheet sheet = workbook.createSheet("DanhSachThongKeThoLamDan");
				Row headerRow = sheet.createRow(0);
				for (int col = 0; col < table.getColumnCount(); col++) {
					headerRow.createCell(col).setCellValue(table.getColumnName(col));
				}

				for (int row = 0; row < table.getRowCount(); row++) {
					Row dataRow = sheet.createRow(row + 1);
					for (int col = 0; col < table.getColumnCount(); col++) {
						Object cellValue = table.getValueAt(row, col);
						if (cellValue != null) {
							if (cellValue instanceof String) {
								dataRow.createCell(col).setCellValue((String) cellValue);
							} else if (cellValue instanceof Number) {
								dataRow.createCell(col).setCellValue(((Number) cellValue).doubleValue());
							} else {
								dataRow.createCell(col).setCellValue(cellValue.toString());
							}
						}
					}
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
