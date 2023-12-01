package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class frm_BangThongKeLuong extends JPanel {

	/**
	 * Create the panel.
	 */
	public frm_BangThongKeLuong() {
		setBackground(new Color(221, 242, 251));
		setLayout(null);
		
		JLabel lblBngThngK = new JLabel("BẢNG THỐNG KÊ LƯƠNG");
		lblBngThngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblBngThngK.setForeground(new Color(0, 27, 72));
		lblBngThngK.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblBngThngK.setBounds(10, 5, 1430, 70);
		add(lblBngThngK);
		
	}
}
