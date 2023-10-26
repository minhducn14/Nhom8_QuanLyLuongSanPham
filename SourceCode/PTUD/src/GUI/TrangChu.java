package GUI;

import javax.swing.*;
import java.awt.*;

public class TrangChu extends JPanel {
    public TrangChu() {
        doShow();
    }
    public void doShow() {
    	JPanel pnCenterC = new JPanel();
		pnCenterC.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LƯƠNG SẢN PHẨM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel_1.setBounds(424, 122, 555, 73);
		pnCenterC.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Harmonious Guitars ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 70));
		lblNewLabel_3.setBounds(329, 219, 766, 73);
		pnCenterC.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("PHẦN MỀM QUẢN LÝ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel_2.setBounds(384, 38, 630, 73);
		pnCenterC.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/icons/BG.jpg")));
		lblNewLabel.setBounds(0, 0, 1450, 733);
		pnCenterC.add(lblNewLabel);
        this.setLayout(new BorderLayout());
    }
}
