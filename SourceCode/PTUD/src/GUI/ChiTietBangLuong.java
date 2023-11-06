package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.JLabel;
import java.awt.Color;

public class ChiTietBangLuong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatMacLightLaf());
				} catch (Exception ex) {
					System.err.println("Failed to initialize LaF");
				}
				try {
					ChiTietBangLuong frame = new ChiTietBangLuong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChiTietBangLuong() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(25, 69, 300, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Nhân Viên:");
		lblNewLabel_1_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(25, 114, 300, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Chức vụ:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(25, 159, 300, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Phiếu Lương");
		lblNewLabel.setBounds(0, 10, 877, 49);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground((new Color(0, 27, 72)));
		contentPane.add(lblNewLabel);
		
		JLabel lblMaNhanVien = new JLabel("NV001");
		lblMaNhanVien.setForeground(new Color(0, 27, 72));
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaNhanVien.setBounds(242, 69, 300, 25);
		contentPane.add(lblMaNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("Chung Gi");
		lblTenNhanVien.setForeground(new Color(0, 27, 72));
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenNhanVien.setBounds(242, 114, 300, 25);
		contentPane.add(lblTenNhanVien);
		
		JLabel lblChucVu = new JLabel("Nhân Viên");
		lblChucVu.setForeground(new Color(0, 27, 72));
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChucVu.setBounds(242, 159, 300, 20);
		contentPane.add(lblChucVu);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Lương Chính");
		lblNewLabel_1_1_1_2.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2.setBounds(36, 272, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Tổng Phụ Cấp");
		lblNewLabel_1_1_1_2_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1.setBounds(36, 321, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("Phụ Cấp Thâm Niên");
		lblNewLabel_1_1_1_2_1_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_1.setBounds(36, 371, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_2_1_1_1 = new JLabel("Ăn Trưa");
		lblNewLabel_1_1_1_2_1_1_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_1_1.setBounds(36, 425, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2_2_1_1_1_1 = new JLabel("Chức vụ :");
		lblNewLabel_1_1_1_2_2_1_1_1_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_2_1_1_1_1.setBounds(131, 527, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_2_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2_3 = new JLabel("Các khoản thu nhập");
		lblNewLabel_1_1_1_2_3.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_3.setBounds(36, 230, 220, 20);
		contentPane.add(lblNewLabel_1_1_1_2_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Lương đóng bảo hiểm:");
		lblNewLabel_1_3.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(447, 69, 300, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Ngày Công Đi Làm Thực Tế:");
		lblNewLabel_1_1_3.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_3.setBounds(447, 114, 300, 25);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Ngày Công Tính Lương:");
		lblNewLabel_1_1_1_3.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_3.setBounds(447, 159, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		JLabel lblNgayCongTinhLuong = new JLabel("26");
		lblNgayCongTinhLuong.setForeground(new Color(0, 27, 72));
		lblNgayCongTinhLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgayCongTinhLuong.setBounds(762, 159, 300, 20);
		contentPane.add(lblNgayCongTinhLuong);
		
		JLabel lblNgayCongTT = new JLabel("23");
		lblNgayCongTT.setForeground(new Color(0, 27, 72));
		lblNgayCongTT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgayCongTT.setBounds(762, 114, 300, 25);
		contentPane.add(lblNgayCongTT);
		
		JLabel lbLuong = new JLabel("23000000");
		lbLuong.setForeground(new Color(0, 27, 72));
		lbLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbLuong.setBounds(762, 69, 203, 25);
		contentPane.add(lbLuong);
		
		JLabel lblNewLabel_1_1_1_2_3_2 = new JLabel("Số tiền");
		lblNewLabel_1_1_1_2_3_2.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_3_2.setBounds(262, 230, 104, 20);
		contentPane.add(lblNewLabel_1_1_1_2_3_2);
		
		JLabel lblNewLabel_1_1_1_2_3_3 = new JLabel("Các trừ vào lương");
		lblNewLabel_1_1_1_2_3_3.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_3_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_3_3.setBounds(486, 230, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_3_3);
		
		JLabel lblNewLabel_1_1_1_2_3_2_1 = new JLabel("Số tiền");
		lblNewLabel_1_1_1_2_3_2_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_3_2_1.setBounds(712, 230, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_3_2_1);
		
		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Bảo Hiểm Bắt Buộc");
		lblNewLabel_1_1_1_2_2.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_2.setBounds(483, 272, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_2);
		
		JLabel lblNewLabel_1_1_1_2_1_2 = new JLabel("Bảo Hiểm Xã Hội ()");
		lblNewLabel_1_1_1_2_1_2.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_2.setBounds(483, 321, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1_1_2 = new JLabel("Bảo Hiểm Y Tế ()");
		lblNewLabel_1_1_1_2_1_1_2.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_1_2.setBounds(483, 371, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1_1_1_1 = new JLabel("Bảo Hiểm Thất Nghiệp ()");
		lblNewLabel_1_1_1_2_1_1_1_1.setForeground(new Color(0, 27, 72));
		lblNewLabel_1_1_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2_1_1_1_1.setBounds(483, 425, 300, 20);
		contentPane.add(lblNewLabel_1_1_1_2_1_1_1_1);
	}
}
