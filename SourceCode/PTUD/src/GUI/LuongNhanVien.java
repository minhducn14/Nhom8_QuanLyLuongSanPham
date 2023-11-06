package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JYearChooser;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class LuongNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tbl_BangLuong;
	private JTextField textField_2;
	private DefaultTableModel modelNhanVien, modelDanhSachLuong;

	/**
	 * Create the panel.
	 */
	public LuongNhanVien() {
		setBackground(new Color(221, 242, 251));
		setLayout(null);

		JLabel lblTieuDe = new JLabel("Lương Nhân Viên");
		lblTieuDe.setForeground(new Color(0, 27, 72));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(301, 0, 850, 90);
		add(lblTieuDe);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(2, 104, 156));
		separator.setForeground(new Color(2, 104, 156));
		separator.setBounds(15, 170, 1420, 2);
		add(separator);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_1.setBounds(15, 191, 1420, 499);
		add(panel_1_1);

		JLabel lblBngLngNhn = new JLabel("Danh sách tiền lương nhân viên");
		lblBngLngNhn.setForeground(new Color(0, 27, 72));
		lblBngLngNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBngLngNhn.setBounds(30, 10, 340, 25);
		panel_1_1.add(lblBngLngNhn);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 50, 1360, 214);
		panel_1_1.add(scrollPane_1);

		tbl_BangLuong = new JTable();
		scrollPane_1.setViewportView(tbl_BangLuong);
		String[] colHeader = { "M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD T\u00EAn",
				"Ph\u1EE5 c\u1EA5p th\u00E2m ni\u00EAn", "Ti\u1EC1n L\u01B0\u01A1ng",
				"T\u1ED5ng Ti\u1EC1n L\u01B0\u01A1ng" };

		modelDanhSachLuong = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbl_BangLuong.setModel(modelDanhSachLuong);
		TableColumnModel columnModel = tbl_BangLuong.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tbl_BangLuong.getTableHeader().setReorderingAllowed(false);

		tbl_BangLuong.getColumnModel().getColumn(0).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(1).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(2).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(3).setResizable(false);
		tbl_BangLuong.getColumnModel().getColumn(4).setResizable(false);

		JTableHeader tbBangLuong = tbl_BangLuong.getTableHeader();
		tbBangLuong.setBackground(new Color(151, 201, 219));
		tbBangLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		tbl_BangLuong.setRowHeight(rowHeight);
		tbl_BangLuong.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(399, 10, 210, 25);
		panel_1_1.add(textField_2);

		JButton btnTnhTonB_1_1 = new JButton("");
		btnTnhTonB_1_1.setIcon(new ImageIcon(LuongNhanVien.class.getResource("/icons/search_icon.png")));
		btnTnhTonB_1_1.setForeground(Color.WHITE);
		btnTnhTonB_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTnhTonB_1_1.setBackground(new Color(2, 104, 156));
		btnTnhTonB_1_1.setBounds(634, 10, 61, 25);
		panel_1_1.add(btnTnhTonB_1_1);

		JButton btnTnhTonB_1_1_1 = new JButton("Xuất toàn bộ");
		btnTnhTonB_1_1_1.setForeground(Color.WHITE);
		btnTnhTonB_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTnhTonB_1_1_1.setBackground(new Color(2, 104, 156));
		btnTnhTonB_1_1_1.setBounds(726, 10, 170, 25);
		panel_1_1.add(btnTnhTonB_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(15, 90, 1420, 67);
		add(panel_1);

		JLabel lblThang = new JLabel("Tháng");
		lblThang.setBounds(10, 20, 80, 30);
		panel_1.add(lblThang);
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 16));

		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setLocation(235, 20);
		yearChooser.setSize(60, 30);
		panel_1.add(yearChooser);

		String[] thang = { "1", "2", "3", "4", "5", "7", "8", "9", "10", "11", "12" };
		JComboBox<Object> cmbThang = new JComboBox<Object>(thang);
		cmbThang.setBounds(90, 20, 56, 30);
		panel_1.add(cmbThang);

		JLabel lblNam = new JLabel("Năm");
		lblNam.setBounds(169, 20, 80, 30);
		panel_1.add(lblNam);
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnTnhTonB_1_2 = new JButton("");
		btnTnhTonB_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nam = yearChooser.getYear()+"";
				String thang = cmbThang.getSelectedItem().toString();
				ChiTietBangLuong bangLuong = new ChiTietBangLuong();
				bangLuong.setVisible(true);
			}
		});
		btnTnhTonB_1_2.setIcon(new ImageIcon(LuongNhanVien.class.getResource("/icons/search_icon.png")));
		btnTnhTonB_1_2.setForeground(Color.WHITE);
		btnTnhTonB_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTnhTonB_1_2.setBackground(new Color(2, 104, 156));
		btnTnhTonB_1_2.setBounds(324, 20, 61, 30);
		panel_1.add(btnTnhTonB_1_2);

	}
}