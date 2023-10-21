package GUI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;

public class Test extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				    UIManager.setLookAndFeel(new FlatMacLightLaf());
//				} catch( Exception ex ) {
//				    System.err.println( "Failed to initialize LaF" );
//				}
//				try {
//					Test frame = new Test();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1464, 737);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 1450, 700);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		panel.add(new LuongThoLamDan());

	}
}
