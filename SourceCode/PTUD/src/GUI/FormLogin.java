package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Canvas;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.BorderUIResource;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtpwd;
	private boolean isHidden = true;

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
					FormLogin frame = new FormLogin();
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
	public FormLogin() {
		setTitle("Form login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1450, 700);
		setIconImage(Toolkit.getDefaultToolkit().getImage(frm_GiaoDienChinh.class.getResource("/icons/Icon.png")));
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

		JPanel panel = new JPanel();

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(131, 171, 185, -83);
		contentPane.add(desktopPane);

		JLabel jbicon = new JLabel();
		jbicon.setIcon(new ImageIcon(FormLogin.class.getResource("/icons/form_login.jpg")));
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

		JCheckBox checkbox_show = new JCheckBox("Hiển thị mật khẩu");
		checkbox_show.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkbox_show.setBackground(new Color(221, 242, 251));
		checkbox_show.setBounds(70, 268, 139, 22);
		login.add(checkbox_show);

		txtpwd = new JPasswordField();
		txtpwd.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtpwd.setBounds(70, 214, 400, 36);
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
		JButton btn_login = new JButton("Đăng nhập");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredPassword = new String(txtpwd.getPassword());

				if (txtTaiKhoan.getText().trim().equals("QLSX") && enteredPassword.equals("QLSX")) {
					frm_GiaoDienChinhQLSanXuat qlsx = new frm_GiaoDienChinhQLSanXuat();
					setVisible(false);
					qlsx.setVisible(true);
				} else if (txtTaiKhoan.getText().trim().equals("QLNS") && enteredPassword.equals("QLNS")) {
					frm_GiaoDienChinhQLNhanSu qlns = new frm_GiaoDienChinhQLNhanSu();
					setVisible(false);
					qlns.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc tài khoản");
				}
			}
		});
		btn_login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_login.setBackground(new Color(255, 255, 255));
		btn_login.setBounds(73, 319, 120, 40);
		login.add(btn_login);

		JButton btn_exit = new JButton("Thoát");
		btn_exit.setBackground(new Color(255, 255, 255));
		btn_exit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_exit.setBounds(350, 321, 120, 40);
		login.add(btn_exit);

	}
}
