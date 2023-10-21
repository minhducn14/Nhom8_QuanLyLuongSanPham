package GUI;

import javax.swing.*;
import java.awt.*;

public class TrangChu extends JPanel {
    public TrangChu() {
        doShow();
    }
    public void doShow() {
        JPanel pnCenterN = new JPanel();
        JPanel pnCenterC = new JPanel();
        pnCenterN.setPreferredSize(new Dimension(1000,80));



        this.setLayout(new BorderLayout());
        this.add(pnCenterN, BorderLayout.NORTH);
        this.add(pnCenterC, BorderLayout.CENTER);
    }
}
