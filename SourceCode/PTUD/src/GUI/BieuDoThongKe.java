package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class BieuDoThongKe extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public BieuDoThongKe() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("BIỂU ĐỒ THỐNG KÊ LƯƠNG\r\n");
		lblNewLabel_1.setBounds(450, 5, 600, 70);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(15, 90, 300, 454);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5_1 = new JLabel("Thời gian thống kê\r\n");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(35, 15, 217, 25);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Thống kê trong năm:");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1_1.setBounds(20, 90, 217, 25);
		panel.add(lblNewLabel_5_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 150, 116, 21);
		panel.add(comboBox);
		
		JButton btnTmKim = new JButton("Thống kê\r\n");
		btnTmKim.setForeground(Color.WHITE);
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmKim.setBackground(new Color(2, 104, 156));
		btnTmKim.setBounds(65, 243, 170, 50);
		panel.add(btnTmKim);
		
		JButton btnXut = new JButton("Xuất");
		btnXut.setForeground(Color.WHITE);
		btnXut.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXut.setBackground(new Color(2, 104, 156));
		btnXut.setBounds(65, 350, 170, 50);
		panel.add(btnXut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(340, 90, 1083, 550);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Biểu đồ thống kê");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(35, 15, 217, 25);
		panel_1.add(lblNewLabel_5);

	}
}
