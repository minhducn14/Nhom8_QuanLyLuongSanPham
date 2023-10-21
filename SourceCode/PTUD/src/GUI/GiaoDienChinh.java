package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import java.awt.*;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GiaoDienChinh extends JFrame implements MouseListener, ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnCneter;
	JMenu mnTrangChu;
	JMenuItem mnChamCong, mnTinhLuong;
	JMenuItem mnCongDoan;
	JMenuItem mnPhanCong, mnChamCongCN, mnTinhLuongCN;
	JMenuItem mnCapNhatNV, mnCapNhatCN, mnCapNhatSP;
	JMenuItem mnTimSanPham, mnTimNhanVien, mnTimCongNhan;
	JMenuItem mnDangXuat, mnDoiMatKhau;
	private JMenu mnThoat;
	private JPanel panel;

	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatMacLightLaf());
				} catch (Exception ex) {
					System.err.println("Failed to initialize LaF");
				}
				try {
					GiaoDienChinh frame = new GiaoDienChinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GiaoDienChinh() {
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
		mnThoLamDan.add(mnChamCongCN = new JMenuItem("Chấm Công"));
		mnThoLamDan.add(mnTinhLuongCN = new JMenuItem("Tính Lương"));
		mnPhanCong.setPreferredSize(new Dimension(150, 30));
		mnChamCongCN.setPreferredSize(new Dimension(150, 30));
		mnTinhLuongCN.setPreferredSize(new Dimension(150, 30));

		JMenu mnSanPham = new JMenu("Sản Phẩm");
		mnSanPham.setIcon(new ImageIcon(getClass().getResource("/icons/product_icon.png")));
		mnSanPham.setFont(ftmn);
		mnSanPham.add(mnCongDoan = new JMenuItem("Công Đoạn"));
		mnCongDoan.setPreferredSize(new Dimension(150, 30));

		JMenu mnCapNhat = new JMenu("Cập Nhật");
		mnCapNhat.setIcon(new ImageIcon(getClass().getResource("/icons/update_icon_menu.png")));
		mnCapNhat.setFont(ftmn);
		mnCapNhat.add(mnCapNhatNV = new JMenuItem("Nhân Viên"));
		mnCapNhat.add(mnCapNhatCN = new JMenuItem("Thợ làm đàn"));
		mnCapNhat.add(mnCapNhatSP = new JMenuItem("Sản Phẩm"));
		mnCapNhatNV.setPreferredSize(new Dimension(150, 30));
		mnCapNhatCN.setPreferredSize(new Dimension(150, 30));
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
		menuBar.add(mnCapNhat);
		menuBar.add(mnTimKiem);
		
		mnThoat = new JMenu("Thoát");
		mnThoat.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/icons/exit_icon.png")));
		mnThoat.setFont(new Font("Arial", Font.BOLD, 20));
		menuBar.add(mnThoat);

		// PnCneter
		pnCneter = new JPanel();
		JPanel pnCenterN = new JPanel();
		pnCenterN.setBackground(new Color(221, 242, 251));
		JPanel pnCenterC = new JPanel();
		pnCenterC.setBackground(new Color(221, 242, 251));
		pnCneter.setLayout(new BorderLayout());

		pnCenterN.setPreferredSize(new Dimension(1000, 80));
		pnCneter.add(pnCenterN, BorderLayout.NORTH);
		pnCneter.add(pnCenterC, BorderLayout.CENTER);

		// pnSouth
		JPanel pnSouth = new JPanel();

		cp.add(menuBar, BorderLayout.NORTH);
		cp.add(pnCneter, BorderLayout.CENTER);
		cp.add(pnSouth, BorderLayout.SOUTH);
		menuBar.setBackground(Color.decode("#B2EBF2"));
		
				JMenu mnTaiKhoan = new JMenu("Tài Khoản");
				mnTaiKhoan.setIcon(new ImageIcon(getClass().getResource("/icons/user_icon.png")));
				mnTaiKhoan.setFont(ftmn);
				mnTaiKhoan.add(mnDoiMatKhau = new JMenuItem("Đổi Mật Khẩu"));
				mnTaiKhoan.add(mnDangXuat = new JMenuItem("Đăng Xuất"));
				mnDoiMatKhau.setPreferredSize(new Dimension(150, 30));
				mnDangXuat.setPreferredSize(new Dimension(150, 30));
				
				panel = new JPanel();
				panel.setBackground(new Color(221, 242, 251));
				menuBar.add(panel);
				menuBar.add(mnTaiKhoan);
				mnDoiMatKhau.addActionListener(this);
				mnDangXuat.addActionListener(this);
		pnCneter.setForeground(Color.decode("#CCCCCC"));

		// Event
		mnTrangChu.addMouseListener(this);

		mnChamCong.addActionListener(this);
		mnTinhLuong.addActionListener(this);
		mnChamCongCN.addActionListener(this);
		mnTinhLuongCN.addActionListener(this);
		mnPhanCong.addActionListener(this);
		mnCapNhatCN.addActionListener(this);
		mnCapNhatNV.addActionListener(this);
		mnCapNhatSP.addActionListener(this);
		mnTimNhanVien.addActionListener(this);
		mnTimCongNhan.addActionListener(this);
		mnTimSanPham.addActionListener(this);
		mnCongDoan.addActionListener(this);

	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(mnTrangChu)) {
			TrangChu form_trangChu = new TrangChu();
			pnCneter.removeAll();
			pnCneter.add(form_trangChu);
			validate();
		} else if (e.getSource().equals(mnThoat)) {
			setVisible(false);
			dispose();
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
			ChamCongNhanVien form_chamCongNhanVien = new ChamCongNhanVien();
			pnCneter.removeAll();
			pnCneter.add(form_chamCongNhanVien);
			validate();
		} else if (e.getSource().equals(mnTinhLuong)) {
			LuongNhanVien form_luongNhanVien = new LuongNhanVien();
			pnCneter.removeAll();
			pnCneter.add(form_luongNhanVien);
			validate();

		} else if (e.getSource().equals(mnDangXuat)) {

		} else if (e.getSource().equals(mnCapNhatNV)) {

		} else if (e.getSource().equals(mnCapNhatCN)) {

		} else if (e.getSource().equals(mnCapNhatSP)) {

		} else if (e.getSource().equals(mnCongDoan)) {

		} else if (e.getSource().equals(mnPhanCong)) {

		} else if (e.getSource().equals(mnChamCongCN)) {
			ChamCongThoLamDan form_chamCongThoLamDan = new ChamCongThoLamDan();
			pnCneter.removeAll();
			pnCneter.add(form_chamCongThoLamDan);
			validate();
		} else if (e.getSource().equals(mnTinhLuongCN)) {
			LuongThoLamDan form_luongThoLamDan = new LuongThoLamDan();
			pnCneter.removeAll();
			pnCneter.add(form_luongThoLamDan);
			validate();
		} else if (e.getSource().equals(mnTimNhanVien)) {

		} else if (e.getSource().equals(mnTimCongNhan)) {

		} else if (e.getSource().equals(mnTimSanPham)) {

		}
	}
}
