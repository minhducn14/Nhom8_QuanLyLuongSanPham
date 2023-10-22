package ptud;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TimKiemThongTinSanPham_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemThongTinSanPham_GUI frame = new TimKiemThongTinSanPham_GUI();
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
	public TimKiemThongTinSanPham_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1463, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1450, 700);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		TimKiemThongTinSanPham timKiemThongTinSanPham = new TimKiemThongTinSanPham();
		timKiemThongTinSanPham.setBackground(new Color(221, 242, 251));
		panel.add(timKiemThongTinSanPham);
		setLocationRelativeTo(null);
		
	}

}
