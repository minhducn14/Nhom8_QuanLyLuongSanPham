package gui;

import javax.swing.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class FRM_GiaoDienChinhQLNhanSu extends JFrame implements MouseListener, ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnCneter;
	JMenu mnTrangChu;
	JMenuItem mnChamCong, mnTinhLuong;
	JMenuItem mnTinhLuongTLD;
	JMenuItem mnCapNhatNV, mnCapNhatTLD;
	JMenuItem mnTimNhanVien, mnTimCongNhan;
	private JMenu mnTroGiup;
	private JMenu mnThngK;
	private JMenuItem mnTKBieuDo, mnBangTK;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatMacLightLaf());
				} catch (Exception ex) {
					System.err.println("Failed to initialize LaF");
				}
				try {
					FRM_GiaoDienChinhQLNhanSu frame = new FRM_GiaoDienChinhQLNhanSu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FRM_GiaoDienChinhQLNhanSu() {
		getContentPane().setBackground(new Color(221, 242, 251));
		doShow();
	}

	public void doShow() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1464, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Quản Lý Lương Sản Phẩm");
		setBackground(new Color(221, 242, 251));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(FRM_GiaoDienChinhQLNhanSu.class.getResource("/icons/Icon.png")));
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		Font ftmn = new Font("arial", Font.BOLD, 20);
		JMenuBar menuBar = new JMenuBar();

		mnTrangChu = new JMenu("Trang Chủ");
		mnTrangChu.setIcon(new ImageIcon(getClass().getResource("/icons/home_icon.png")));
		mnTrangChu.setFont(ftmn);
		mnTrangChu.isSelected();

		JMenu mnNhanVien = new JMenu("Nhân Viên");
		mnNhanVien.setIcon(new ImageIcon(getClass().getResource("/icons/employee_icon.png")));
		mnNhanVien.setFont(ftmn);
		mnChamCong = new JMenuItem("Chấm Công");
		mnNhanVien.add(mnChamCong);
		mnTinhLuong = new JMenuItem("Tính Lương");
		mnNhanVien.add(mnTinhLuong);

		mnChamCong.setPreferredSize(new Dimension(150, 30));
		mnTinhLuong.setPreferredSize(new Dimension(150, 30));

		JMenu mnThoLamDan = new JMenu("Thợ làm đàn");
		mnThoLamDan.setIcon(new ImageIcon(getClass().getResource("/icons/worker_icon.png")));
		mnThoLamDan.setFont(ftmn);
		mnThoLamDan.add(mnTinhLuongTLD = new JMenuItem("Tính Lương"));
		mnTinhLuongTLD.setPreferredSize(new Dimension(150, 30));

		JMenu mnQuanLy = new JMenu("Quản Lý");
		mnQuanLy.setIcon(new ImageIcon(FRM_GiaoDienChinhQLNhanSu.class.getResource("/icons/management.png")));
		mnQuanLy.setFont(ftmn);
		mnQuanLy.add(mnCapNhatNV = new JMenuItem("Nhân Viên"));
		mnQuanLy.add(mnCapNhatTLD = new JMenuItem("Thợ làm đàn"));
		mnCapNhatNV.setPreferredSize(new Dimension(150, 30));
		mnCapNhatTLD.setPreferredSize(new Dimension(150, 30));

		JMenu mnTimKiem = new JMenu("Tìm Kiếm");
		mnTimKiem.setIcon(new ImageIcon(getClass().getResource("/icons/search_icon.png")));
		mnTimKiem.setFont(ftmn);
		mnTimKiem.add(mnTimNhanVien = new JMenuItem("Nhân Viên"));
		mnTimKiem.add(mnTimCongNhan = new JMenuItem("Thợ làm đàn"));

		mnTimNhanVien.setPreferredSize(new Dimension(150, 30));
		mnTimCongNhan.setPreferredSize(new Dimension(150, 30));

		menuBar.add(mnTrangChu);
		menuBar.add(mnNhanVien);
		menuBar.add(mnThoLamDan);
		menuBar.add(mnQuanLy);
		menuBar.add(mnTimKiem);

		mnTroGiup = new JMenu("Trợ giúp");
		mnTroGiup.setIcon(new ImageIcon(FRM_GiaoDienChinhQLNhanSu.class.getResource("/icons/HoTro.png")));
		mnTroGiup.setFont(new Font("Arial", Font.BOLD, 20));
		menuBar.add(mnTroGiup);

		// PnCneter
		pnCneter = new JPanel();
		JPanel pnCenterC = new JPanel();
		pnCenterC.setBackground(new Color(221, 242, 251));
		pnCneter.setLayout(new BorderLayout());
		pnCneter.add(pnCenterC, BorderLayout.CENTER);
		pnCenterC.setLayout(null);

		lblNewLabel_1 = new JLabel("LƯƠNG SẢN PHẨM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel_1.setBounds(424, 122, 555, 73);
		pnCenterC.add(lblNewLabel_1);

		lblNewLabel_3 = new JLabel("Harmonious Guitars");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 70));
		lblNewLabel_3.setBounds(329, 219, 766, 73);
		pnCenterC.add(lblNewLabel_3);

		lblNewLabel_2 = new JLabel("PHẦN MỀM QUẢN LÝ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel_2.setBounds(384, 38, 630, 73);
		pnCenterC.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FRM_GiaoDienChinhQLNhanSu.class.getResource("/icons/BG.jpg")));
		lblNewLabel.setBounds(0, 0, 1450, 733);
		pnCenterC.add(lblNewLabel);

		cp.add(menuBar, BorderLayout.NORTH);
		cp.add(pnCneter, BorderLayout.CENTER);
		menuBar.setBackground(Color.decode("#B2EBF2"));

		mnThngK = new JMenu("Thống kê");
		mnThngK.setIcon(new ImageIcon(FRM_GiaoDienChinhQLNhanSu.class.getResource("/icons/analytis_icon.png")));
		mnThngK.setFont(new Font("Arial", Font.BOLD, 20));
		menuBar.add(mnThngK);

		mnTKBieuDo = new JMenuItem("Biểu đồ");
		mnThngK.add(mnTKBieuDo);
		mnBangTK = new JMenuItem("Danh Sách");
		mnThngK.add(mnBangTK);

		pnCneter.setForeground(Color.decode("#CCCCCC"));

		// Event
		mnTrangChu.addMouseListener(this);
		mnChamCong.addActionListener(this);
		mnTinhLuong.addActionListener(this);
		mnTinhLuongTLD.addActionListener(this);
		mnCapNhatTLD.addActionListener(this);
		mnCapNhatNV.addActionListener(this);
		mnTimNhanVien.addActionListener(this);
		mnTimCongNhan.addActionListener(this);
		mnTroGiup.addMouseListener(this);
		mnTKBieuDo.addActionListener(this);
		mnBangTK.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(mnTrangChu)) {
			FRM_TrangChu form_trangChu = new FRM_TrangChu();
			pnCneter.removeAll();
			pnCneter.add(form_trangChu);
			validate();
		} else if (e.getSource().equals(mnTroGiup)) {

			String helpFilePath = "/help/helpQLNS.chm";
			URL helpFileURL = getClass().getResource(helpFilePath);
			if (helpFileURL == null) {
				String basePath = System.getProperty("user.dir");
				String basePathNew = basePath.substring(0, basePath.length() - 11);
				String helpFolderPath = basePathNew + "SourceCode" + File.separator + "PTUD" + File.separator + "src"
						+ File.separator + "help" + File.separator + "helpQLNS.chm";
				File newFile = new File(helpFolderPath);
				try {
					helpFileURL = newFile.toURI().toURL();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			File helpFile;
			try {
				helpFile = new File(helpFileURL.toURI());
				String[] commands = { "cmd", "/c", "start", helpFile.getAbsolutePath() };
				Runtime.getRuntime().exec(commands);

			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Không thể mở file .chm: " + e1.getMessage());

			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mnChamCong)) {
			FRM_ChamCongNhanVien form_chamCongNhanVien = new FRM_ChamCongNhanVien();
			pnCneter.removeAll();
			pnCneter.add(form_chamCongNhanVien);
			validate();
		} else if (e.getSource().equals(mnTinhLuong)) {
			FRM_LuongNhanVien form_luongNhanVien = new FRM_LuongNhanVien();
			pnCneter.removeAll();
			pnCneter.add(form_luongNhanVien);
			validate();

		} else if (e.getSource().equals(mnCapNhatNV)) {
			FRM_QuanLyNhanVien form_NhanVien = new FRM_QuanLyNhanVien();
			pnCneter.removeAll();
			pnCneter.add(form_NhanVien);
			validate();
		} else if (e.getSource().equals(mnCapNhatTLD)) {
			FRM_QuanLyThoLamDan thoLamDan = new FRM_QuanLyThoLamDan();
			pnCneter.removeAll();
			pnCneter.add(thoLamDan);
			validate();
		} else if (e.getSource().equals(mnTinhLuongTLD)) {
			FRM_LuongThoLamDan form_luongThoLamDan = new FRM_LuongThoLamDan();
			pnCneter.removeAll();
			pnCneter.add(form_luongThoLamDan);
			validate();
		} else if (e.getSource().equals(mnTimNhanVien)) {
			FRM_TimKiemThongTinNhanVien form_TimKiemNhanVien = new FRM_TimKiemThongTinNhanVien();
			pnCneter.removeAll();
			pnCneter.add(form_TimKiemNhanVien);
			validate();
		} else if (e.getSource().equals(mnTimCongNhan)) {
			FRM_TimKiemThongTinThoLamDan form_TimKiemThoLamDan = new FRM_TimKiemThongTinThoLamDan();
			pnCneter.removeAll();
			pnCneter.add(form_TimKiemThoLamDan);
			validate();
		} else if (e.getSource().equals(mnTKBieuDo)) {
			FRM_BieuDoThongKe bieuDoThongKe = new FRM_BieuDoThongKe();
			pnCneter.removeAll();
			pnCneter.add(bieuDoThongKe);
			validate();
		} else if (e.getSource().equals(mnBangTK)) {
			FRM_BangThongKeLuong bangThongKeLuong = new FRM_BangThongKeLuong();
			pnCneter.removeAll();
			pnCneter.add(bangThongKeLuong);
			validate();
		}
	}
}
