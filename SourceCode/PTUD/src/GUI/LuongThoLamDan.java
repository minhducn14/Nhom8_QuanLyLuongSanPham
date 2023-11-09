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
import java.time.LocalDate;
import java.time.Month;
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

public class LuongThoLamDan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tbl_BangLuong;
	private JTextField textField_2;
	private JYearChooser yearChooser;
	private JComboBox<Object> cmbThang;

	/**
	 * Create the panel.
	 */
	public LuongThoLamDan() {
		setBackground(new Color(221, 242, 251));
		setLayout(null);

		JLabel lblTieuDe = new JLabel("Lương Thợ Làm Đàn");
		lblTieuDe.setForeground(new Color(0, 27, 72));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(301, 0, 850, 90);
		add(lblTieuDe);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(2, 104, 156));
		separator.setForeground(new Color(2, 104, 156));
		separator.setBounds(15, 183, 1420, 2);
		add(separator);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_1.setBounds(15, 210, 1420, 480);
		add(panel_1_1);

		JLabel lblBngLngNhn = new JLabel("Danh sách tiền lương thợ làm đàn");
		lblBngLngNhn.setForeground(new Color(0, 27, 72));
		lblBngLngNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBngLngNhn.setBounds(30, 10, 340, 30);
		panel_1_1.add(lblBngLngNhn);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 50, 1360, 401);
		panel_1_1.add(scrollPane_1);

		tbl_BangLuong = new JTable();
		scrollPane_1.setViewportView(tbl_BangLuong);
		tbl_BangLuong.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "M\u00E3 Th\u1EE3 L\u00E0m \u0110\u00E0n", "H\u1ECD T\u00EAn",
						"Ph\u1EE5 c\u1EA5p th\u00E2m ni\u00EAn", "Ti\u1EC1n L\u01B0\u01A1ng",
						"T\u1ED5ng Ti\u1EC1n L\u01B0\u01A1ng" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
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
		textField_2.setBounds(569, 10, 210, 25);
		panel_1_1.add(textField_2);

		JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo tên");
		lblTmKimTheo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTmKimTheo.setBounds(393, 10, 176, 30);
		panel_1_1.add(lblTmKimTheo);

		JButton btnTnhTonB_1_1 = new JButton("");
		btnTnhTonB_1_1.setIcon(new ImageIcon(LuongThoLamDan.class.getResource("/icons/search_icon.png")));
		btnTnhTonB_1_1.setForeground(Color.WHITE);
		btnTnhTonB_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTnhTonB_1_1.setBackground(new Color(2, 104, 156));
		btnTnhTonB_1_1.setBounds(804, 10, 61, 25);
		panel_1_1.add(btnTnhTonB_1_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(2, 104, 156));
		separator_1.setBackground(new Color(2, 104, 156));
		separator_1.setBounds(385, 10, 21, 30);
		panel_1_1.add(separator_1);

		JButton btnTnhTonB_1_1_1 = new JButton("Xuất Excel");
		btnTnhTonB_1_1_1.setForeground(Color.WHITE);
		btnTnhTonB_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTnhTonB_1_1_1.setBackground(new Color(2, 104, 156));
		btnTnhTonB_1_1_1.setBounds(1220, 12, 170, 25);
		panel_1_1.add(btnTnhTonB_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(15, 90, 1420, 67);
		add(panel_1);

		JLabel lblThang = new JLabel("Tháng");
		lblThang.setBounds(30, 20, 80, 30);
		panel_1.add(lblThang);
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 16));

		yearChooser = new JYearChooser();
		yearChooser.setLocation(250, 20);
		yearChooser.setSize(60, 30);
		panel_1.add(yearChooser);

		String[] thang = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cmbThang = new JComboBox<Object>(thang);
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		int monthValue = currentMonth.getValue();
		cmbThang.setSelectedIndex(monthValue - 1);
		cmbThang.setBounds(110, 20, 56, 30);
		panel_1.add(cmbThang);

		JLabel lblNam = new JLabel("Năm");
		lblNam.setBounds(190, 20, 80, 30);
		panel_1.add(lblNam);
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnXemLuong = new JButton("");
		btnXemLuong.setIcon(new ImageIcon(LuongNhanVien.class.getResource("/icons/search_icon.png")));
		btnXemLuong.setForeground(Color.WHITE);
		btnXemLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXemLuong.setBackground(new Color(2, 104, 156));
		btnXemLuong.setBounds(340, 20, 61, 30);
		panel_1.add(btnXemLuong);
	}
}
