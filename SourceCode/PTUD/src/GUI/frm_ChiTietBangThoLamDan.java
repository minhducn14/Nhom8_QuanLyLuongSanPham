package GUI;

import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import Entity.BangChamCongThoLamDan;
import Entity.BangLuongNhanVien;
import Entity.BangLuongThoLamDan;
import Entity.CongDoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.storage.BATBlock;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import DAO.DAO_ChamCongThoLamDan;
import DAO.DAO_CongDoan;
import DAO.DAO_LuongThoLamDan;
import DAO.DAO_ThoLamDan;

import javax.swing.JScrollPane;

public class frm_ChiTietBangThoLamDan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMaNhanVien;
	private JLabel lblTenNhanVien;
	private JTable table;
	private DAO_ChamCongThoLamDan dao_ChamCongThoLamDan = new DAO_ChamCongThoLamDan();
	private DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();
	private DAO_CongDoan dao_CongDoan = new DAO_CongDoan();
	private DefaultTableModel model_ChiTietBangLuong;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UIManager.setLookAndFeel(new FlatMacLightLaf());
//				} catch (Exception ex) {
//					System.err.println("Failed to initialize LaF");
//				}
//				try {
//					ChiTietBangLuong frame = new ChiTietBangLuong();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public frm_ChiTietBangThoLamDan(BangLuongThoLamDan bangLuongThoLamDan) {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 670);
		setTitle("Phiếu Lương");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 242, 251));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã Thợ Làm Đàn:");
		lblNewLabel_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(25, 69, 300, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên Thợ Làm Đàn:");
		lblNewLabel_1_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(25, 114, 300, 25);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel = new JLabel("Phiếu Lương");
		lblNewLabel.setBounds(0, 10, 877, 49);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground((new Color(0, 27, 72)));
		contentPane.add(lblNewLabel);

		lblMaNhanVien = new JLabel();
		lblMaNhanVien.setText(bangLuongThoLamDan.getThoLamDan().getMaThoLamDan());
		lblMaNhanVien.setForeground(new Color(0, 27, 72));
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaNhanVien.setBounds(242, 69, 300, 25);
		contentPane.add(lblMaNhanVien);

		lblTenNhanVien = new JLabel();
		lblTenNhanVien.setText(bangLuongThoLamDan.getThoLamDan().getCongNhanVien().getHoTen());
		lblTenNhanVien.setForeground(new Color(0, 27, 72));
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenNhanVien.setBounds(242, 114, 300, 25);
		contentPane.add(lblTenNhanVien);

		JLabel lblNewLabel_1_1_1_2_2_1_1_1_1 = new JLabel("Tổng lương được nhận");
		lblNewLabel_1_1_1_2_2_1_1_1_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_2_1_1_1_1.setBounds(30, 554, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_2_1_1_1_1);
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

		JLabel lblluongThucLinh = new JLabel();
		double luong = dao_LuongThoLamDan.layTongThuNhapTungThang(bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(),
				bangLuongThoLamDan.getThang(), bangLuongThoLamDan.getNam());
		double luongThucLinh = bangLuongThoLamDan.tinhLuongThucLinh(luong);
		lblluongThucLinh.setText(decimalFormat.format(luongThucLinh));
		lblluongThucLinh.setForeground(new Color(255, 0, 0));
		lblluongThucLinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblluongThucLinh.setBounds(304, 554, 300, 20);
		contentPane.add(lblluongThucLinh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 169, 934, 353);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		String[] colHeader = { "S\u1EA3n Ph\u1EA9m", "C\u00F4ng \u0110o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng",
				"Gi\u00E1 C\u00F4ng \u0111o\u1EA1n" };
		model_ChiTietBangLuong = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		table.setModel(model_ChiTietBangLuong);
		model_ChiTietBangLuong.setRowCount(0);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);

		JTableHeader tbBangLuong = table.getTableHeader();
		tbBangLuong.setBackground(new Color(151, 201, 219));
		tbBangLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		table.setRowHeight(rowHeight);
		table.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));

		JButton btnXuat = new JButton("Xuất Excel");
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel(bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(), table, luongThucLinh);
			}
		});
		btnXuat.setBounds(731, 566, 85, 21);
		contentPane.add(btnXuat);

		ArrayList<BangChamCongThoLamDan> list = dao_ChamCongThoLamDan.laySoLuongLamDuocCuaThang(
				bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(), bangLuongThoLamDan.getThang(),
				bangLuongThoLamDan.getNam());

		ArrayList<CongDoan> listCongDoans = dao_CongDoan.getCongDoanTheoTLDNgayThang(
				bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(), bangLuongThoLamDan.getThang(),
				bangLuongThoLamDan.getNam());

		for (int i = 0; i < listCongDoans.size(); i++) {
			Object[] objects = { listCongDoans.get(i).getDan().getTenSanPham(), listCongDoans.get(i).getTenCongDoan(),
					list.get(i).getSoLuongSanPham(), listCongDoans.get(i).getGiaCongDoan() };
			model_ChiTietBangLuong.addRow(objects);
		}
	}

	public static void exportExcel(String ma, JTable table, double luongThucLinh) {
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
				String tenSheet = "ChiTietBangLuongThoLamDan" + ma;
				Sheet sheet = workbook.createSheet(tenSheet);

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

				int newRowNum = table.getRowCount();

				Row newDataRow = sheet.createRow(newRowNum + 1);
				DecimalFormat decimalFormat = new DecimalFormat("#,##0.000");
				Object[] newData = { "Lương Được Nhận", "", "", decimalFormat.format(luongThucLinh) + "VND" };

				for (int col = 0; col < newData.length; col++) {
					Object cellValue = newData[col];

					if (cellValue != null) {
						if (cellValue instanceof String) {
							newDataRow.createCell(col).setCellValue((String) cellValue);
						} else if (cellValue instanceof Number) {
							newDataRow.createCell(col).setCellValue(((Number) cellValue).doubleValue());
						} else {
							newDataRow.createCell(col).setCellValue(cellValue.toString());
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
