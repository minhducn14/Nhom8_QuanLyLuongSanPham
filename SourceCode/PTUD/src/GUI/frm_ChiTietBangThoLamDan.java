package GUI;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import Entity.BangChamCongThoLamDan;
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
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import DAO.DAO_ChamCongThoLamDan;
import DAO.DAO_CongDoan;
import DAO.DAO_LuongThoLamDan;

import javax.swing.JScrollPane;

public class frm_ChiTietBangThoLamDan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMaThoLamDan;
	private JLabel lblTenThoLamDan;
	private JTable table;
	private DAO_ChamCongThoLamDan dao_ChamCongThoLamDan = new DAO_ChamCongThoLamDan();
	private static DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();
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
		setBounds(100, 100, 1000, 744);
		setTitle("Phiếu Lương");
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMTLD = new JLabel("Mã Thợ Làm Đàn:");
		lblMTLD.setForeground(new Color(0, 0, 0));
		lblMTLD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMTLD.setBounds(25, 69, 300, 25);
		contentPane.add(lblMTLD);

		JLabel lblTenTLD = new JLabel("Tên Thợ Làm Đàn:");
		lblTenTLD.setForeground(new Color(0, 0, 0));
		lblTenTLD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenTLD.setBounds(25, 114, 300, 25);
		contentPane.add(lblTenTLD);

		JLabel lblThongTin = new JLabel();
		String txt = "Phiếu Lương Tháng " + bangLuongThoLamDan.getThang() + " Năm " + bangLuongThoLamDan.getNam();
		lblThongTin.setText(txt);
		lblThongTin.setBounds(0, 10, 986, 49);
		lblThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblThongTin.setForeground(new Color(255, 0, 0));
		contentPane.add(lblThongTin);

		lblMaThoLamDan = new JLabel();
		lblMaThoLamDan.setText(bangLuongThoLamDan.getThoLamDan().getMaThoLamDan());
		lblMaThoLamDan.setForeground(new Color(0, 0, 0));
		lblMaThoLamDan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaThoLamDan.setBounds(242, 69, 300, 25);
		contentPane.add(lblMaThoLamDan);

		lblTenThoLamDan = new JLabel();
		lblTenThoLamDan.setText(bangLuongThoLamDan.getThoLamDan().getCongNhanVien().getHoTen());
		lblTenThoLamDan.setForeground(new Color(0, 0, 0));
		lblTenThoLamDan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenThoLamDan.setBounds(242, 114, 300, 25);
		contentPane.add(lblTenThoLamDan);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 169, 934, 302);
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
				exportExcel(table, bangLuongThoLamDan);
			}
		});
		btnXuat.setBounds(835, 640, 124, 40);
		contentPane.add(btnXuat);

		JLabel lblLuongSP = new JLabel("Lương sản phẩm : ");
		lblLuongSP.setForeground(Color.BLACK);
		lblLuongSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLuongSP.setBounds(30, 499, 300, 20);
		contentPane.add(lblLuongSP);

		JLabel lblluongSP = new JLabel();
		lblluongSP.setForeground(Color.RED);
		lblluongSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblluongSP.setBounds(304, 499, 300, 20);
		contentPane.add(lblluongSP);
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		double luong = dao_LuongThoLamDan.layTongThuNhapTungThang(bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(),
				bangLuongThoLamDan.getThang(), bangLuongThoLamDan.getNam());
		lblluongSP.setText(decimalFormat.format(luong));

		JLabel lblPCThamNien = new JLabel("Phụ cấp thâm niên : ");
		lblPCThamNien.setForeground(Color.BLACK);
		lblPCThamNien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPCThamNien.setBounds(30, 539, 300, 20);
		contentPane.add(lblPCThamNien);

		JLabel lblPCTN = new JLabel();
		lblPCTN.setForeground(Color.RED);
		lblPCTN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPCTN.setBounds(304, 539, 300, 20);
		contentPane.add(lblPCTN);
		lblPCTN.setText(decimalFormat.format(bangLuongThoLamDan.getThoLamDan().getCongNhanVien()
				.tinhPhuCapThamNienThoLamDan(bangLuongThoLamDan.getThoLamDan().tinhHeSoLuong())));

		JLabel lblPCAnTrua = new JLabel("Phụ cấp ăn trưa : ");
		lblPCAnTrua.setForeground(Color.BLACK);
		lblPCAnTrua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPCAnTrua.setBounds(30, 579, 300, 20);
		contentPane.add(lblPCAnTrua);

		JLabel lblPCAT = new JLabel();
		lblPCAT.setForeground(Color.RED);
		lblPCAT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPCAT.setBounds(304, 579, 300, 20);
		contentPane.add(lblPCAT);
		lblPCAT.setText(decimalFormat.format(900000));

		JLabel lblTienBH = new JLabel();
		lblTienBH.setForeground(Color.RED);
		lblTienBH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTienBH.setBounds(304, 619, 300, 20);
		contentPane.add(lblTienBH);
		lblTienBH.setText(decimalFormat.format((3000000 * 0.08 + 3000000 * 0.015 + 3000000 * 0.01)));

		JLabel lblTienBaoHiem = new JLabel("Tiền đóng bảo hiểm : ");
		lblTienBaoHiem.setForeground(Color.BLACK);
		lblTienBaoHiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTienBaoHiem.setBounds(30, 619, 300, 20);
		contentPane.add(lblTienBaoHiem);

		JLabel lblLuongThucLinh = new JLabel("Lương thực lĩnh : ");
		lblLuongThucLinh.setForeground(Color.BLACK);
		lblLuongThucLinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLuongThucLinh.setBounds(30, 659, 300, 20);
		contentPane.add(lblLuongThucLinh);

		JLabel lblLuongTL = new JLabel();
		lblLuongTL.setForeground(Color.RED);
		lblLuongTL.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLuongTL.setBounds(304, 659, 300, 20);
		contentPane.add(lblLuongTL);
		double luongThucLinh = bangLuongThoLamDan.tinhLuongThucLinh(luong);
		lblLuongTL.setText(decimalFormat.format(luongThucLinh));

		ArrayList<BangChamCongThoLamDan> list = dao_ChamCongThoLamDan.laySoLuongLamDuocCuaThang(
				bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(), bangLuongThoLamDan.getThang(),
				bangLuongThoLamDan.getNam());

		ArrayList<CongDoan> listCongDoans = dao_CongDoan.getCongDoanTheoTLDNgayThang(
				bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(), bangLuongThoLamDan.getThang(),
				bangLuongThoLamDan.getNam());
		for (int i = 0; i < listCongDoans.size(); i++) {
			Object[] objects = { listCongDoans.get(i).getDan().getTenSanPham(), listCongDoans.get(i).getTenCongDoan(),
					decimalFormat.format(list.get(i).getSoLuongSanPham()),
					decimalFormat.format(listCongDoans.get(i).getGiaCongDoan()) };
			model_ChiTietBangLuong.addRow(objects);
		}
	}

	public static void addSalaryTableTitle(Sheet sheet, String title, int tableWidth) {
		org.apache.poi.ss.usermodel.Font titleFont = sheet.getWorkbook().createFont();
		titleFont.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
		titleFont.setFontHeightInPoints((short) 16);

		CellStyle titleCellStyle = sheet.getWorkbook().createCellStyle();
		titleCellStyle.setFont(titleFont);
		titleCellStyle.setAlignment(CellStyle.ALIGN_CENTER);

		Row titleRow = sheet.createRow(0); 

		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(title);
		titleCell.setCellStyle(titleCellStyle);

		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, tableWidth - 1));
	}

	public static boolean isFileOpen(File file) {
		if (!file.exists() || file.isDirectory()) {
			return false;
		}

		try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
				FileChannel channel = raf.getChannel();
				FileLock lock = channel.tryLock()) {
			if (lock == null) {
				return true;
			}
		} catch (IOException e) {
			return true;
		}
		return false;
	}

	public static void exportExcel(JTable table, BangLuongThoLamDan bangLuongThoLamDan) {
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
				File file = new File(filePath);

				if (isFileOpen(file)) {
					JOptionPane.showMessageDialog(null, "File is already open. Please close it and try again.");
				} else {

					Workbook workbook = new HSSFWorkbook();
					String tenSheet = "ChiTietBangLuongThoLamDan" + bangLuongThoLamDan.getThoLamDan().getMaThoLamDan();
					Sheet sheet = workbook.createSheet(tenSheet);
					org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
					headerFont.setBoldweight((short) 12);
					headerFont.setFontHeightInPoints((short) 12);
					String title = "Phiếu Lương Tháng " + bangLuongThoLamDan.getThang() + " Năm "
							+ bangLuongThoLamDan.getNam();

					int tableWidth = 4;
					addSalaryTableTitle(sheet, title, tableWidth);

					CellStyle headerCellStyle = workbook.createCellStyle();
					headerCellStyle.setFont(headerFont);
					Row rowThongTin = sheet.createRow(2);
					Object[] rowTT = { "Mã TLD", bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(), "Tên TLD",
							bangLuongThoLamDan.getThoLamDan().getCongNhanVien().getHoTen() };
					for (int col = 0; col < rowTT.length; col++) {
						Object cellValue = rowTT[col];
						if (cellValue != null) {
							if (cellValue instanceof String) {
								rowThongTin.createCell(col).setCellValue((String) cellValue);
							} else if (cellValue instanceof Number) {
								rowThongTin.createCell(col).setCellValue(((Number) cellValue).doubleValue());
							} else {
								rowThongTin.createCell(col).setCellValue(cellValue.toString());
							}
						}
					}

					Row headerRow = sheet.createRow(4);
					for (int i = 0; i < table.getColumnCount(); i++) {
						Cell cell = headerRow.createCell(i);
						cell.setCellValue(table.getColumnName(i));
						cell.setCellStyle(headerCellStyle);
					}

					CellStyle dateCellStyle = workbook.createCellStyle();
					CreationHelper createHelper = workbook.getCreationHelper();
					dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

					for (int col = 0; col < table.getColumnCount(); col++) {
						headerRow.createCell(col).setCellValue(table.getColumnName(col));
					}

					for (int row = 0; row < table.getRowCount(); row++) {
						Row dataRow = sheet.createRow(row + 5);
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

					int row = table.getRowCount();
					DecimalFormat decimalFormat = new DecimalFormat("#,##0.000");
					double luong = dao_LuongThoLamDan.layTongThuNhapTungThang(
							bangLuongThoLamDan.getThoLamDan().getMaThoLamDan(), bangLuongThoLamDan.getThang(),
							bangLuongThoLamDan.getNam());
					Row Luong_Data_Row = sheet.createRow(row + 6);
					Object[] luongData = { "Lương được nhận", "", "", decimalFormat.format(luong) + " VND" };
					for (int col = 0; col < luongData.length; col++) {
						Object cellValue = luongData[col];
						if (cellValue != null) {
							if (cellValue instanceof String) {
								Luong_Data_Row.createCell(col).setCellValue((String) cellValue);
							} else if (cellValue instanceof Number) {
								Luong_Data_Row.createCell(col).setCellValue(((Number) cellValue).doubleValue());
							} else {
								Luong_Data_Row.createCell(col).setCellValue(cellValue.toString());
							}
						}
					}

					Row PCTN_Data_Row = sheet.createRow(row + 7);
					Object[] PCTNData = { "Phụ cấp thâm niên", "", "",
							decimalFormat
									.format(bangLuongThoLamDan.getThoLamDan().getCongNhanVien()
											.tinhPhuCapThamNienThoLamDan(bangLuongThoLamDan.getThoLamDan().tinhHeSoLuong()))
									+ " VND" };
					for (int col = 0; col < PCTNData.length; col++) {
						Object cellValue = PCTNData[col];
						if (cellValue != null) {
							if (cellValue instanceof String) {
								PCTN_Data_Row.createCell(col).setCellValue((String) cellValue);
							} else if (cellValue instanceof Number) {
								PCTN_Data_Row.createCell(col).setCellValue(((Number) cellValue).doubleValue());
							} else {
								PCTN_Data_Row.createCell(col).setCellValue(cellValue.toString());
							}
						}
					}

					Row PCAT_Data_Row = sheet.createRow(row + 8);
					Object[] PCATData = { "Phụ cấp ăn trưa", "", "", decimalFormat.format(900000) + " VND" };
					for (int col = 0; col < PCATData.length; col++) {
						Object cellValue = PCATData[col];
						if (cellValue != null) {
							if (cellValue instanceof String) {
								PCAT_Data_Row.createCell(col).setCellValue((String) cellValue);
							} else if (cellValue instanceof Number) {
								PCAT_Data_Row.createCell(col).setCellValue(((Number) cellValue).doubleValue());
							} else {
								PCAT_Data_Row.createCell(col).setCellValue(cellValue.toString());
							}
						}
					}

					Row TienDongBaoHiem_Data_Row = sheet.createRow(row + 9);
					Object[] TienDongBaoHiem_Data = { "Tiền đóng bảo hiểm", "", "",
							decimalFormat.format((3000000 * 0.08 + 3000000 * 0.015 + 3000000 * 0.01)) + " VND" };
					for (int col = 0; col < TienDongBaoHiem_Data.length; col++) {
						Object cellValue = TienDongBaoHiem_Data[col];
						if (cellValue != null) {
							if (cellValue instanceof String) {
								TienDongBaoHiem_Data_Row.createCell(col).setCellValue((String) cellValue);
							} else if (cellValue instanceof Number) {
								TienDongBaoHiem_Data_Row.createCell(col)
										.setCellValue(((Number) cellValue).doubleValue());
							} else {
								TienDongBaoHiem_Data_Row.createCell(col).setCellValue(cellValue.toString());
							}
						}
					}

					double luongThucLinh = bangLuongThoLamDan.tinhLuongThucLinh(luong);

					Row tongLuongDataRow = sheet.createRow(row + 10);
					Object[] luongTNData = { "Lương Được Nhận", "", "", decimalFormat.format(luongThucLinh) + " VND" };
					for (int col = 0; col < luongTNData.length; col++) {
						Object cellValue = luongTNData[col];
						if (cellValue != null) {
							if (cellValue instanceof String) {
								tongLuongDataRow.createCell(col).setCellValue((String) cellValue);
							} else if (cellValue instanceof Number) {
								tongLuongDataRow.createCell(col).setCellValue(((Number) cellValue).doubleValue());
							} else {
								tongLuongDataRow.createCell(col).setCellValue(cellValue.toString());
							}
						}
					}

					for (int i = 0; i < table.getColumnCount(); i++) {
						sheet.autoSizeColumn(i);
					}

					try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
						workbook.write(fileOut);
						JOptionPane.showMessageDialog(null, "Tạo và lưu tệp Excel thành công!");
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Lỗi khi tạo và lưu tệp Excel!");
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
