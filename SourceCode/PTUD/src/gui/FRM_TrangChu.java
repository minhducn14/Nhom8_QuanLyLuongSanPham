package gui;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

public class FRM_TrangChu extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public FRM_TrangChu() {
		setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Harmonious Guitars");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 70));
		lblNewLabel_3.setBounds(329, 219, 766, 73);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("PHẦN MỀM QUẢN LÝ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel_2.setBounds(384, 38, 630, 73);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("LƯƠNG SẢN PHẨM");		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel_1.setBounds(424, 122, 555, 73);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FRM_TrangChu.class.getResource("/icons/BG.jpg")));
		lblNewLabel.setBounds(0, 0, 1450, 733);
		add(lblNewLabel);

	}
}
