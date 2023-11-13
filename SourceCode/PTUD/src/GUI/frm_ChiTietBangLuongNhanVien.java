package GUI;

import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import Connection.MyConnection;
import DAO.DAO_LuongNhanVien;
import Entity.BangLuongNhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JSeparator;

public class frm_ChiTietBangLuongNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JLabel lblMaNhanVien;
	private JLabel lblTenNhanVien;
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
	public frm_ChiTietBangLuongNhanVien(BangLuongNhanVien bangLuongNhanVien) {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 948, 670);
		setTitle("Phiếu Lương");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(25, 69, 300, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên Nhân Viên:");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(25, 114, 300, 25);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Chức vụ:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(25, 159, 300, 20);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel = new JLabel("Phiếu Lương");
		lblNewLabel.setBounds(0, 10, 877, 49);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		contentPane.add(lblNewLabel);

		lblMaNhanVien = new JLabel();
		lblMaNhanVien.setText(bangLuongNhanVien.getNhanVien().getMaNhanVien());
		lblMaNhanVien.setForeground(new Color(0, 0, 0));
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaNhanVien.setBounds(242, 69, 300, 25);
		contentPane.add(lblMaNhanVien);

		lblTenNhanVien = new JLabel();
		lblTenNhanVien.setText(bangLuongNhanVien.getNhanVien().getCongNhanVien().getHoTen());
		lblTenNhanVien.setForeground(new Color(0, 0, 0));
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenNhanVien.setBounds(242, 114, 300, 25);
		contentPane.add(lblTenNhanVien);

		JLabel lblChucVu = new JLabel();
		lblChucVu.setText(bangLuongNhanVien.getNhanVien().getChucVu());
		lblChucVu.setForeground(new Color(0, 0, 0));
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChucVu.setBounds(242, 159, 300, 20);
		contentPane.add(lblChucVu);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Lương Chính");
		lblNewLabel_1_1_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2.setBounds(36, 272, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Tổng Phụ Cấp");
		lblNewLabel_1_1_1_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1.setBounds(36, 321, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1);

		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("Phụ Cấp Thâm Niên");
		lblNewLabel_1_1_1_2_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_1.setBounds(36, 371, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1_1);

		JLabel lblNewLabel_1_1_1_2_1_1_1 = new JLabel("Ăn Trưa");
		lblNewLabel_1_1_1_2_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_1_1.setBounds(36, 425, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1_1_1);

		JLabel lblNewLabel_1_1_1_2_2_1_1_1_1 = new JLabel("Tổng lương được nhận");
		lblNewLabel_1_1_1_2_2_1_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_2_2_1_1_1_1.setBounds(131, 527, 300, 25);
		contentPane.add(lblNewLabel_1_1_1_2_2_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2_3 = new JLabel("Các khoản thu nhập");
		lblNewLabel_1_1_1_2_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_3.setBounds(36, 230, 220, 20);
		contentPane.add(lblNewLabel_1_1_1_2_3);

		JLabel lblNewLabel_1_3 = new JLabel("Lương đóng bảo hiểm:");
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(447, 69, 300, 25);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1_3 = new JLabel("Ngày Công Đi Làm Thực Tế:");
		lblNewLabel_1_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_3.setBounds(447, 114, 300, 25);
		contentPane.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("Ngày Công Tính Lương:");
		lblNewLabel_1_1_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_3.setBounds(447, 159, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_3);

		JLabel lblNgayCongTinhLuong = new JLabel("26");
		lblNgayCongTinhLuong.setForeground(new Color(0, 0, 0));
		lblNgayCongTinhLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgayCongTinhLuong.setBounds(762, 159, 300, 20);
		contentPane.add(lblNgayCongTinhLuong);

		JLabel lblNgayCongTT = new JLabel();
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

		String soNgayTinhCong = decimalFormat
				.format(bangLuongNhanVien.getSoNgayLamChuNhat() * 1.5 + bangLuongNhanVien.getSoNgayThuongDiLam());
		lblNgayCongTT.setText(soNgayTinhCong);
		lblNgayCongTT.setForeground(new Color(0, 0, 0));
		lblNgayCongTT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgayCongTT.setBounds(762, 114, 300, 25);
		contentPane.add(lblNgayCongTT);

		JLabel lbLuong = new JLabel();
		double luongTT = bangLuongNhanVien.tinhLuongThucTe(bangLuongNhanVien.getNhanVien().getLuongCoBan(),
				bangLuongNhanVien.getNhanVien().tinhHeSoLuong(),
				bangLuongNhanVien.getNhanVien().getCongNhanVien().tinhPhuCapThamNien(
						bangLuongNhanVien.getNhanVien().getLuongCoBan(),
						bangLuongNhanVien.getNhanVien().tinhHeSoLuong()));
		String luongThucTe = decimalFormat.format(luongTT);
		lbLuong.setText(luongThucTe);
		lbLuong.setForeground(new Color(0, 0, 0));
		lbLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbLuong.setBounds(762, 69, 203, 25);
		contentPane.add(lbLuong);

		JLabel lblNewLabel_1_1_1_2_3_2 = new JLabel("Số tiền");
		lblNewLabel_1_1_1_2_3_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_3_2.setBounds(262, 230, 104, 20);
		contentPane.add(lblNewLabel_1_1_1_2_3_2);

		JLabel lblNewLabel_1_1_1_2_3_3 = new JLabel("Các khoản trừ vào lương");
		lblNewLabel_1_1_1_2_3_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_3_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_3_3.setBounds(483, 230, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_3_3);

		JLabel lblNewLabel_1_1_1_2_3_2_1 = new JLabel("Số tiền");
		lblNewLabel_1_1_1_2_3_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_3_2_1.setBounds(762, 230, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_3_2_1);

		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Bảo Hiểm Bắt Buộc");
		lblNewLabel_1_1_1_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_2.setBounds(483, 272, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_2);

		JLabel lblNewLabel_1_1_1_2_1_2 = new JLabel("Bảo Hiểm Xã Hội (8%)");
		lblNewLabel_1_1_1_2_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_2.setBounds(483, 321, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1_2);

		JLabel lblNewLabel_1_1_1_2_1_1_2 = new JLabel("Bảo Hiểm Y Tế (1.5%)");
		lblNewLabel_1_1_1_2_1_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_1_2.setBounds(483, 371, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1_1_2);

		JLabel lblNewLabel_1_1_1_2_1_1_1_1 = new JLabel("Bảo Hiểm Thất Nghiệp (1%)");
		lblNewLabel_1_1_1_2_1_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_1_1_1.setBounds(483, 425, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1_1_1_1);

		JLabel lblLuong = new JLabel("");
		lblLuong.setText(luongThucTe);
		lblLuong.setForeground(new Color(0, 0, 0));
		lblLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLuong.setBounds(262, 272, 169, 20);
		contentPane.add(lblLuong);

		JLabel lblPCTN = new JLabel("");
		double phuCapThamNien = bangLuongNhanVien.getNhanVien().getCongNhanVien().tinhPhuCapThamNien(
				bangLuongNhanVien.getNhanVien().getLuongCoBan(), bangLuongNhanVien.getNhanVien().tinhHeSoLuong());
		lblPCTN.setText(decimalFormat.format(phuCapThamNien));
		lblPCTN.setForeground(new Color(0, 0, 0));
		lblPCTN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPCTN.setBounds(262, 371, 169, 20);
		contentPane.add(lblPCTN);

		JLabel lblAnTrua = new JLabel("");
		double soNgayDiLam = bangLuongNhanVien.getSoNgayLamChuNhat() + bangLuongNhanVien.getSoNgayThuongDiLam();
		lblAnTrua.setText(decimalFormat.format(soNgayDiLam * 30000));
		lblAnTrua.setForeground(new Color(0, 0, 0));
		lblAnTrua.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAnTrua.setBounds(262, 425, 169, 20);
		contentPane.add(lblAnTrua);

		JLabel lblBHXH = new JLabel("");
		String bhxh = decimalFormat.format(luongTT * 0.08);
		lblBHXH.setText(bhxh);
		lblBHXH.setForeground(new Color(0, 0, 0));
		lblBHXH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBHXH.setBounds(762, 321, 300, 20);
		contentPane.add(lblBHXH);

		JLabel lblBHYT = new JLabel("");
		String bhyt = decimalFormat.format(luongTT * 0.015);
		lblBHYT.setText(bhyt);
		lblBHYT.setForeground(new Color(0, 0, 0));
		lblBHYT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBHYT.setBounds(762, 371, 300, 20);
		contentPane.add(lblBHYT);

		JLabel lblBHTN = new JLabel("");
		String bhtn = decimalFormat.format(luongTT * 0.01);
		lblBHTN.setText(bhtn);
		lblBHTN.setForeground(new Color(0, 0, 0));
		lblBHTN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBHTN.setBounds(762, 425, 300, 20);
		contentPane.add(lblBHTN);

		JLabel lblluongThucLinh = new JLabel();
		double luongThucLinh = bangLuongNhanVien.tinhLuongThucLinh(luongTT,
				bangLuongNhanVien.getNhanVien().getLuongCoBan(), bangLuongNhanVien.getNhanVien().tinhHeSoLuong());
		lblluongThucLinh.setText(decimalFormat.format(luongThucLinh));
		lblluongThucLinh.setForeground(new Color(255, 0, 0));
		lblluongThucLinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblluongThucLinh.setBounds(405, 527, 300, 25);
		contentPane.add(lblluongThucLinh);

		JLabel lblTongBH = new JLabel("0.00");
		String tongBh = decimalFormat.format(luongTT * 0.08 + luongTT * 0.01 + luongTT * 0.01);
		lblTongBH.setText(tongBh);
		lblTongBH.setForeground(new Color(255, 128, 64));
		lblTongBH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongBH.setBounds(762, 272, 300, 20);
		contentPane.add(lblTongBH);

		JLabel lblTongPC = new JLabel("");
		double tongPhuCap = soNgayDiLam * 30000 + phuCapThamNien;
		lblTongPC.setText(decimalFormat.format(tongPhuCap));
		lblTongPC.setForeground(new Color(255, 128, 64));
		lblTongPC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongPC.setBounds(262, 321, 169, 20);
		contentPane.add(lblTongPC);

		JButton btnNewButton = new JButton("Export pdf");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportPDF();
			}
		});
		btnNewButton.setBounds(772, 583, 124, 40);
		contentPane.add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 224, 900, 5);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 257, 900, 5);
		contentPane.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(10, 306, 900, 5);
		contentPane.add(separator_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1.setBounds(10, 356, 900, 5);
		contentPane.add(separator_1_1_1);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1_1.setBounds(10, 410, 900, 5);
		contentPane.add(separator_1_1_1_1);

		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1_1_1.setBounds(10, 455, 900, 5);
		contentPane.add(separator_1_1_1_1_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(909, 224, 30, 230);
		contentPane.add(separator_2);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setForeground(Color.BLACK);
		separator_2_1.setBounds(730, 224, 30, 230);
		contentPane.add(separator_2_1);

		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1.setForeground(Color.BLACK);
		separator_2_1_1.setBounds(470, 224, 30, 230);
		contentPane.add(separator_2_1_1);

		JSeparator separator_2_1_1_1 = new JSeparator();
		separator_2_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1_1.setForeground(Color.BLACK);
		separator_2_1_1_1.setBounds(250, 224, 30, 230);
		contentPane.add(separator_2_1_1_1);

		JSeparator separator_2_1_1_1_1 = new JSeparator();
		separator_2_1_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1_1_1.setForeground(Color.BLACK);
		separator_2_1_1_1_1.setBounds(10, 224, 30, 230);
		contentPane.add(separator_2_1_1_1_1);

	}

	private static void savePanelAsJpg() {
		BufferedImage image = new BufferedImage(contentPane.getWidth(), contentPane.getHeight() - 50,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		contentPane.printAll(g2d);
		g2d.dispose();
		try {
			ImageIO.write(image, "jpg", new File("src//contentPane.jpg"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void exportPDF() {
		savePanelAsJpg();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn nơi lưu tệp pdf");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
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
				if (!filePath.endsWith(".pdf")) {
					filePath += ".pdf";
				}
				String jpgFilePath = "src//contentPane.jpg";
				Document document = new Document(PageSize.A5.rotate(), 0, 0, 0, 0);

				try {
					FileOutputStream fos = new FileOutputStream(new File(filePath));
					PdfWriter.getInstance(document, fos);
					document.open();

					Image image = Image.getInstance(jpgFilePath);
					image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
					document.add(image);

					document.close();
					fos.close();

					String duongDan = "src//contentPane.jpg";

					File tepCanXoa = new File(duongDan);

					if (tepCanXoa.exists()) {
						tepCanXoa.delete();

					}
					JOptionPane.showMessageDialog(null, "Tạo và lưu tệp thành công!");
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
