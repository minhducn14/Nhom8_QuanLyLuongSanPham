package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import connection.MyConnection;
import dao.DAO_TaiKhoan;
import entity.TaiKhoan;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class FRM_Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtpwd;
	private int countSaiMatKhau = 0;
	private JButton btn_login, btn_exit;
	private DAO_TaiKhoan dao_taiKhoan = new DAO_TaiKhoan();

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
					FRM_Login frame = new FRM_Login();
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
	public FRM_Login() {
		MyConnection.getInstance().MyConnection();
		setTitle("Form login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1450, 700);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FRM_GiaoDienChinh.class.getResource("/icons/Icon.png")));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 102, 204));
		contentPane.setBackground(new Color(218, 205, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setAlignmentX(BOTTOM_ALIGNMENT);

		JLabel lblNewLabel = new JLabel("PHẦN MỀM QUẢN LÝ LƯƠNG");
		lblNewLabel.setForeground(new Color(0, 27, 72));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel.setBackground(new Color(218, 205, 212));
		lblNewLabel.setBounds(324, 20, 788, 97);
		contentPane.add(lblNewLabel);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(131, 171, 185, -83);
		contentPane.add(desktopPane);

		JLabel jbicon = new JLabel();
		jbicon.setIcon(new ImageIcon(FRM_Login.class.getResource("/icons/form_login.jpg")));
		jbicon.setBounds(165, 156, 563, 431);
		contentPane.add(jbicon);

		JPanel login = new JPanel();
		login.setBackground(new Color(221, 242, 251));
		login.setForeground(new Color(221, 242, 251));
		login.setBorder(new LineBorder(new Color(221, 242, 251), 10, true));
		login.setBounds(785, 171, 540, 400);
		contentPane.add(login);
		login.setLayout(null);

		JLabel login_title = new JLabel("ĐĂNG NHẬP");
		login_title.setFont(new Font("Tahoma", Font.PLAIN, 34));
		login_title.setBounds(176, 35, 188, 37);
		login.add(login_title);

		JLabel tk_login = new JLabel("Tài khoản");
		tk_login.setForeground(new Color(0, 27, 72));
		tk_login.setFont(new Font("Tahoma", Font.PLAIN, 22));
		tk_login.setBounds(70, 81, 100, 32);
		login.add(tk_login);

		JLabel mk_login = new JLabel("Mật khẩu");
		mk_login.setForeground(new Color(0, 27, 72));
		mk_login.setFont(new Font("Tahoma", Font.PLAIN, 22));
		mk_login.setBounds(70, 181, 100, 32);
		login.add(mk_login);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTaiKhoan.setBounds(70, 114, 400, 36);
		login.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setText("NV002");
		txtTaiKhoan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_login.doClick();
				}
			}
		});

		JCheckBox checkbox_show = new JCheckBox("Hiển thị mật khẩu");
		checkbox_show.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkbox_show.setBackground(new Color(221, 242, 251));
		checkbox_show.setBounds(70, 268, 139, 22);
		login.add(checkbox_show);

		txtpwd = new JPasswordField();
		txtpwd.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtpwd.setBounds(70, 214, 400, 36);
		txtpwd.setText("123");
		txtpwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_login.doClick();
				}
			}
		});
		login.add(txtpwd);
		Font defaultFont = txtpwd.getFont();

		checkbox_show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkbox_show.isSelected()) {
					txtpwd.setEchoChar((char) 0);
				} else {
					txtpwd.setEchoChar('●');
				}
				txtpwd.setFont(new Font("Tahoma", Font.PLAIN, defaultFont.getSize()));

			}
		});
		btn_login = new JButton("Đăng nhập");
		btn_login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_login.setBackground(new Color(255, 255, 255));
		btn_login.setBounds(73, 319, 120, 40);
		login.add(btn_login);

		btn_exit = new JButton("Thoát");
		btn_exit.setBackground(new Color(255, 255, 255));
		btn_exit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_exit.setBounds(350, 321, 120, 40);
		login.add(btn_exit);
		btn_login.addActionListener(this);

	}

	public void login() throws SQLException {
		if (countSaiMatKhau > 2) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai tài khoản quá 3 lần. Chương trình sẽ thoát!");
			System.exit(0);
		} else {
			String maTaiKhoan = txtTaiKhoan.getText().trim();
			@SuppressWarnings("deprecation")
			String matKhau = txtpwd.getText().toString().trim();
			TaiKhoan taiKhoan = dao_taiKhoan.getTaiKhoanTheoMaTaiKhoan(maTaiKhoan);
			if (taiKhoan.getTaiKhoan() == null) {
				JOptionPane.showMessageDialog(null, "Tài khoản không đúng!");
				countSaiMatKhau++;
			} else if (!taiKhoan.getMatKhau().equals(matKhau)) {
				JOptionPane.showMessageDialog(null, "Mật khẩu không đúng!");
				countSaiMatKhau++;
			} else {
				String maPB = taiKhoan.getNhanVien().getPhongBan().getMaPhongBan();
				if (maPB.equals("PB005")) {
					FRM_GiaoDienChinhQLSanXuat qlsx = new FRM_GiaoDienChinhQLSanXuat();
					setVisible(false);
					qlsx.setVisible(true);
				} else {
					FRM_GiaoDienChinhQLNhanSu qlns = new FRM_GiaoDienChinhQLNhanSu();
					setVisible(false);
					qlns.setVisible(true);
				}
				this.setVisible(false);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btn_login)) {
			try {
				login();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(btn_exit)) {
			int option = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn thoát?", "Thoát?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
}
