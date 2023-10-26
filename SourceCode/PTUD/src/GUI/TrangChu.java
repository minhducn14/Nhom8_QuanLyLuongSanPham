package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TrangChu extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TrangChu() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TrangChu.class.getResource("/icons/BG.jpg")));
		lblNewLabel.setBounds(0, 0, 1451, 700);
		add(lblNewLabel);

	}
}
