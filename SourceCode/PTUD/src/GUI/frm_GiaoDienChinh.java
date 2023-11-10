package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import java.awt.*;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class frm_GiaoDienChinh extends JFrame implements MouseListener, ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnCneter;
	JMenu mnTrangChu;
	JMenuItem mnChamCong, mnTinhLuong;
	JMenuItem mnCongDoan;
	JMenuItem mnPhanCong, mnChamCongTLD, mnTinhLuongTLD;
	JMenuItem mnCapNhatNV, mnCapNhatTLD, mnCapNhatSP;
	JMenuItem mnTimSanPham, mnTimNhanVien, mnTimCongNhan;
	private JMenu mnTroGiup;
	private JMenu mnThngK;
	private JMenuItem mntmNewMenuItem;
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
					frm_GiaoDienChinh frame = new frm_GiaoDienChinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frm_GiaoDienChinh() {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(frm_GiaoDienChinh.class.getResource("/icons/Icon.png")));
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
		mnThoLamDan.add(mnPhanCong = new JMenuItem("Phân Công"));
		mnThoLamDan.add(mnChamCongTLD = new JMenuItem("Chấm Công"));
		mnThoLamDan.add(mnTinhLuongTLD = new JMenuItem("Tính Lương"));
		mnPhanCong.setPreferredSize(new Dimension(150, 30));
		mnChamCongTLD.setPreferredSize(new Dimension(150, 30));
		mnTinhLuongTLD.setPreferredSize(new Dimension(150, 30));

		JMenu mnSanPham = new JMenu("Đàn");
		mnSanPham.setIcon(new ImageIcon(getClass().getResource("/icons/product_icon.png")));
		mnSanPham.setFont(ftmn);
		mnSanPham.add(mnCongDoan = new JMenuItem("Công Đoạn"));
		mnCongDoan.setPreferredSize(new Dimension(150, 30));

		JMenu mnQuanLy = new JMenu("Quản Lý");
		mnQuanLy.setIcon(new ImageIcon(frm_GiaoDienChinh.class.getResource("/icons/management.png")));
		mnQuanLy.setFont(ftmn);
		mnQuanLy.add(mnCapNhatNV = new JMenuItem("Nhân Viên"));
		mnQuanLy.add(mnCapNhatTLD = new JMenuItem("Thợ làm đàn"));
		mnQuanLy.add(mnCapNhatSP = new JMenuItem("Sản Phẩm"));
		mnCapNhatNV.setPreferredSize(new Dimension(150, 30));
		mnCapNhatTLD.setPreferredSize(new Dimension(150, 30));
		mnCapNhatSP.setPreferredSize(new Dimension(150, 30));

		JMenu mnTimKiem = new JMenu("Tìm Kiếm");
		mnTimKiem.setIcon(new ImageIcon(getClass().getResource("/icons/search_icon.png")));
		mnTimKiem.setFont(ftmn);
		mnTimKiem.add(mnTimNhanVien = new JMenuItem("Nhân Viên"));
		mnTimKiem.add(mnTimCongNhan = new JMenuItem("Thợ làm đàn"));
		mnTimKiem.add(mnTimSanPham = new JMenuItem("Sản Phẩm"));

		mnTimSanPham.setPreferredSize(new Dimension(150, 30));
		mnTimNhanVien.setPreferredSize(new Dimension(150, 30));
		mnTimCongNhan.setPreferredSize(new Dimension(150, 30));

		menuBar.add(mnTrangChu);
		menuBar.add(mnNhanVien);
		menuBar.add(mnThoLamDan);
		menuBar.add(mnSanPham);
		menuBar.add(mnQuanLy);
		menuBar.add(mnTimKiem);

		mnTroGiup = new JMenu("Trợ giúp");
		mnTroGiup.setIcon(new ImageIcon(frm_GiaoDienChinh.class.getResource("/icons/HoTro.png")));
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
		lblNewLabel.setIcon(new ImageIcon(frm_GiaoDienChinh.class.getResource("/icons/BG.jpg")));
		lblNewLabel.setBounds(0, 0, 1450, 733);
		pnCenterC.add(lblNewLabel);

		cp.add(menuBar, BorderLayout.NORTH);
		cp.add(pnCneter, BorderLayout.CENTER);
		menuBar.setBackground(Color.decode("#B2EBF2"));

		mnThngK = new JMenu("Thống kê");
		mnThngK.setIcon(new ImageIcon(frm_GiaoDienChinh.class.getResource("/icons/analytis_icon.png")));
		mnThngK.setFont(new Font("Arial", Font.BOLD, 20));
		menuBar.add(mnThngK);

		mntmNewMenuItem = new JMenuItem("Biểu đồ");
		mnThngK.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Danh sách");
		mnThngK.add(mntmNewMenuItem_1);

		pnCneter.setForeground(Color.decode("#CCCCCC"));

		// Event
		mnTrangChu.addMouseListener(this);
		mnChamCong.addActionListener(this);
		mnTinhLuong.addActionListener(this);
		mnChamCongTLD.addActionListener(this);
		mnTinhLuongTLD.addActionListener(this);
		mnPhanCong.addActionListener(this);
		mnCapNhatTLD.addActionListener(this);
		mnCapNhatNV.addActionListener(this);
		mnCapNhatSP.addActionListener(this);
		mnTimNhanVien.addActionListener(this);
		mnTimCongNhan.addActionListener(this);
		mnTimSanPham.addActionListener(this);
		mnCongDoan.addActionListener(this);
		mnTroGiup.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(mnTrangChu)) {
			frm_TrangChu form_trangChu = new frm_TrangChu();
			pnCneter.removeAll();
			pnCneter.add(form_trangChu);
			validate();
		} else if (e.getSource().equals(mnTroGiup)) {
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
			frm_ChamCongNhanVien form_chamCongNhanVien = new frm_ChamCongNhanVien();
			pnCneter.removeAll();
			pnCneter.add(form_chamCongNhanVien);
			validate();
		} else if (e.getSource().equals(mnTinhLuong)) {
			frm_LuongNhanVien form_luongNhanVien = new frm_LuongNhanVien();
			pnCneter.removeAll();
			pnCneter.add(form_luongNhanVien);
			validate();

		} else if (e.getSource().equals(mnCapNhatNV)) {
			frm_QuanLyNhanVien form_NhanVien = new frm_QuanLyNhanVien();
			pnCneter.removeAll();
			pnCneter.add(form_NhanVien);
			validate();
		} else if (e.getSource().equals(mnCapNhatTLD)) {
			frm_QuanLyThoLamDan thoLamDan = new frm_QuanLyThoLamDan();
			pnCneter.removeAll();
			pnCneter.add(thoLamDan);
			validate();
		} else if (e.getSource().equals(mnCapNhatSP)) {
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
		} else if (e.getSource().equals(mnTinhLuongTLD)) {
			frm_LuongThoLamDan form_luongThoLamDan = new frm_LuongThoLamDan();
			pnCneter.removeAll();
			pnCneter.add(form_luongThoLamDan);
			validate();
		} else if (e.getSource().equals(mnTimNhanVien)) {
			frm_TimKiemNhanVien form_TimKiemNhanVien = new frm_TimKiemNhanVien();
			pnCneter.removeAll();
			pnCneter.add(form_TimKiemNhanVien);
			validate();
		} else if (e.getSource().equals(mnTimCongNhan)) {
			frm_TimKiemThongTinThoLamDan form_TimKiemThoLamDan = new frm_TimKiemThongTinThoLamDan();
			pnCneter.removeAll();
			pnCneter.add(form_TimKiemThoLamDan);
			validate();
		} else if (e.getSource().equals(mnTimSanPham)) {
			frm_TimKiemThongTinSanPham form_TimKiemSanPham = new frm_TimKiemThongTinSanPham();
			pnCneter.removeAll();
			pnCneter.add(form_TimKiemSanPham);
			validate();

		}
	}
}
