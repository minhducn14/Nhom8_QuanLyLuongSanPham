package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

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
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private boolean isHidden = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
//		setBounds(100, 100, 1450, 700);
		setSize(1450,700);
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
		
//		URL ulrIconNotepad = FormLogin.class.getResource("form_login.jpg");
//		Image img = Toolkit.getDefaultToolkit().createImage(ulrIconNotepad);
//		this.setIconImage(img);
		
		
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField.setBounds(70, 114, 400, 36);
		login.add(textField);
		textField.setColumns(10);
		
		JCheckBox checkbox_show = new JCheckBox("Hiển thị mật khẩu");
		checkbox_show.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkbox_show.setBackground(new Color(221, 242, 251));
		checkbox_show.setBounds(70, 268, 139, 22);
		login.add(checkbox_show);
		
		checkbox_show.addActionListener((new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isChecked = checkbox_show.isSelected();
				passwordField.setEchoChar(isChecked ? '\0':'●');
			}
			}));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		passwordField.setBounds(70, 214, 400, 36);
		login.add(passwordField);
		
		JButton btn_login = new JButton("Đăng nhập");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				if(username.equals("login")&&password.equals("123")) {
					GiaoDienChinh giaoDienChinh = new GiaoDienChinh();
					giaoDienChinh.setVisible(true);
					FormLogin.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "username hoặc password không đúng","Lỗi",JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					passwordField.setText("");
				}
			}
		});
		btn_login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_login.setBackground(new Color(255, 255, 255));
		btn_login.setBounds(73, 319, 120, 40);
		login.add(btn_login);
		
		JButton btn_exit = new JButton("Thoát");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormLogin.this.dispose();
			}
		});
		btn_exit.setBackground(new Color(255, 255, 255));
		btn_exit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_exit.setBounds(350, 321, 120, 40);
		login.add(btn_exit);

	}
}
