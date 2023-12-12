package GUI;

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

public class frm_GiaoDienChinhQLSanXuat extends JFrame implements MouseListener, ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnCneter;
	JMenu mnTrangChu;
	JMenuItem mnCongDoan;
	JMenuItem mnPhanCong, mnChamCongTLD;
	JMenuItem mnTimSanPham, mnCapNhatSP;
	private JMenu mnTroGiup;
//	private JMenu mnThngK;
//	private JMenuItem mntmNewMenuItem;
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
					frm_GiaoDienChinhQLSanXuat frame = new frm_GiaoDienChinhQLSanXuat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frm_GiaoDienChinhQLSanXuat() {
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
				Toolkit.getDefaultToolkit().getImage(frm_GiaoDienChinhQLSanXuat.class.getResource("/icons/Icon.png")));
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		Font ftmn = new Font("arial", Font.BOLD, 20);
		JMenuBar menuBar = new JMenuBar();

		mnTrangChu = new JMenu("Trang Chủ");
		mnTrangChu.setIcon(new ImageIcon(getClass().getResource("/icons/home_icon.png")));
		mnTrangChu.setFont(ftmn);
		mnTrangChu.isSelected();

		JMenu mnThoLamDan = new JMenu("Thợ làm đàn");
		mnThoLamDan.setIcon(new ImageIcon(getClass().getResource("/icons/worker_icon.png")));
		mnThoLamDan.setFont(ftmn);
		mnThoLamDan.add(mnPhanCong = new JMenuItem("Phân Công"));
		mnThoLamDan.add(mnChamCongTLD = new JMenuItem("Chấm Công"));
		mnPhanCong.setPreferredSize(new Dimension(150, 30));
		mnChamCongTLD.setPreferredSize(new Dimension(150, 30));

		JMenu mnSanPham = new JMenu("Đàn");
		mnSanPham.setIcon(new ImageIcon(getClass().getResource("/icons/product_icon.png")));
		mnSanPham.setFont(ftmn);
		mnSanPham.add(mnCongDoan = new JMenuItem("Công Đoạn"));
		mnCongDoan.setPreferredSize(new Dimension(150, 30));

		JMenu mnQuanLy = new JMenu("Quản Lý");
		mnQuanLy.setIcon(new ImageIcon(frm_GiaoDienChinhQLSanXuat.class.getResource("/icons/management.png")));
		mnQuanLy.setFont(ftmn);
		mnQuanLy.add(mnCapNhatSP = new JMenuItem("Sản Phẩm"));
		mnCapNhatSP.setPreferredSize(new Dimension(150, 30));

		JMenu mnTimKiem = new JMenu("Tìm Kiếm");
		mnTimKiem.setIcon(new ImageIcon(getClass().getResource("/icons/search_icon.png")));
		mnTimKiem.setFont(ftmn);
		mnTimKiem.add(mnTimSanPham = new JMenuItem("Sản Phẩm"));

		mnTimSanPham.setPreferredSize(new Dimension(150, 30));

		menuBar.add(mnTrangChu);
		menuBar.add(mnThoLamDan);
		menuBar.add(mnSanPham);
		menuBar.add(mnQuanLy);
		menuBar.add(mnTimKiem);

		mnTroGiup = new JMenu("Trợ giúp");
		mnTroGiup.setIcon(new ImageIcon(frm_GiaoDienChinhQLSanXuat.class.getResource("/icons/HoTro.png")));
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
		lblNewLabel.setIcon(new ImageIcon(frm_GiaoDienChinhQLSanXuat.class.getResource("/icons/BG.jpg")));
		lblNewLabel.setBounds(0, 0, 1450, 733);
		pnCenterC.add(lblNewLabel);

		cp.add(menuBar, BorderLayout.NORTH);
		cp.add(pnCneter, BorderLayout.CENTER);
		menuBar.setBackground(Color.decode("#B2EBF2"));

		pnCneter.setForeground(Color.decode("#CCCCCC"));

		// Event
		mnTrangChu.addMouseListener(this);
		mnChamCongTLD.addActionListener(this);
		mnPhanCong.addActionListener(this);
		mnCapNhatSP.addActionListener(this);
		mnTimSanPham.addActionListener(this);
		mnCongDoan.addActionListener(this);
		mnTroGiup.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		String helpFilePath = "/help/helpQLSX.chm";
		URL helpFileURL = getClass().getResource(helpFilePath);
		if (helpFileURL == null) {
			String basePath = System.getProperty("user.dir");
			String basePathNew = basePath.substring(0, basePath.length() - 11);
			String helpFolderPath = basePathNew + "SourceCode" + File.separator + "PTUD" + File.separator + "src"
					+ File.separator + "help" + File.separator + "helpQLSX.chm";
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
		if (e.getSource().equals(mnCapNhatSP)) {
			frm_QuanLySanPham form_SanPham = new frm_QuanLySanPham();
			pnCneter.removeAll();
			pnCneter.add(form_SanPham);
			validate();
		} else if (e.getSource().equals(mnCongDoan)) {
			frm_CongDoan form_CongDoan = new frm_CongDoan();
			pnCneter.removeAll();
			pnCneter.add(form_CongDoan);
			validate();

		} else if (e.getSource().equals(mnPhanCong)) {
			frm_PhanCong form_bangPhanCong = new frm_PhanCong();
			pnCneter.removeAll();
			pnCneter.add(form_bangPhanCong);
			validate();

		} else if (e.getSource().equals(mnChamCongTLD)) {
			frm_ChamCongThoLamDan form_chamCongThoLamDan = new frm_ChamCongThoLamDan();
			pnCneter.removeAll();
			pnCneter.add(form_chamCongThoLamDan);
			validate();
		} else if (e.getSource().equals(mnTimSanPham)) {
			frm_TimKiemThongTinSanPham form_TimKiemSanPham = new frm_TimKiemThongTinSanPham();
			pnCneter.removeAll();
			pnCneter.add(form_TimKiemSanPham);
			validate();

		}
	}
}
