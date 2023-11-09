package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JDateChooser;

import Connection.MyConnection;
import DAO.DAO_ChamCongThoLamDan;
import Entity.BangChamCongNhanVien;
import Entity.BangPhanCong;
import Entity.NhanVien;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;

public class frm_ChamCongThoLamDan extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable tbl_BangChamCong;
	private JTextField txtTen;
	private JDateChooser ngayPhanCong;

	private DefaultTableModel model_BagPhanCong;
	private DAO_ChamCongThoLamDan dao_ChamCongThoLamDan = new DAO_ChamCongThoLamDan();

	/**
	 * Create the panel.
	 */
	public frm_ChamCongThoLamDan() {
		MyConnection.getInstance().MyConnection();

		setBackground(new Color(221, 242, 251));
		setLayout(null);

		JLabel lblTieuDe = new JLabel("Chấm Công Thợ Làm Đàn");
		lblTieuDe.setForeground(new Color(0, 27, 72));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setBounds(301, 0, 850, 90);
		add(lblTieuDe);

		int rowHeight = 30;
		int rowMargin = 10;

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_2.setBounds(15, 90, 1413, 579);
		add(panel_1_2);

		JLabel lblThongTin_1 = new JLabel("Danh Sách Chấm Công");
		lblThongTin_1.setForeground(new Color(0, 27, 72));
		lblThongTin_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblThongTin_1.setBounds(568, 70, 318, 25);
		panel_1_2.add(lblThongTin_1);
		ngayPhanCong = new JDateChooser();
		ngayPhanCong.setSize(new Dimension(30, 20));
		ngayPhanCong.setDateFormatString("dd-MM-yyyy");
		try {
			Date date = Date.valueOf(LocalDate.now());
			ngayPhanCong.setDate(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ngayPhanCong.setBounds(206, 20, 130, 25);
		ngayPhanCong.setEnabled(false);
		panel_1_2.add(ngayPhanCong);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 128, 1365, 376);
		panel_1_2.add(scrollPane);
		model_BagPhanCong = new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "Mã TLD", "Họ Tên", "Sản Phẩm", "Công đoạn", "Số lượng được phân công",
						"Số lượng làm được" }) {
			/**
			 * s
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbl_BangChamCong = new JTable(model_BagPhanCong);
		tbl_BangChamCong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbl_BangChamCong);
		TableColumnModel columnModel = tbl_BangChamCong.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		tbl_BangChamCong.getTableHeader().setReorderingAllowed(false);
		tbl_BangChamCong.getColumnModel().getColumn(0).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(1).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(2).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(3).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(4).setResizable(false);
		tbl_BangChamCong.getColumnModel().getColumn(5).setResizable(false);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBackground(new Color(255, 255, 255));
		txtTen.setBounds(591, 20, 210, 25);
		panel_1_2.add(txtTen);

		JButton btnTimKiemTen = new JButton("");
		btnTimKiemTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JTableHeader tbNhanVien = tbl_BangChamCong.getTableHeader();
		tbNhanVien.setBackground(new Color(151, 201, 219));
		tbNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		tbl_BangChamCong.setRowHeight(rowHeight);
		tbl_BangChamCong.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));

		btnTimKiemTen.setIcon(new ImageIcon(frm_ChamCongThoLamDan.class.getResource("/icons/search_icon.png")));
		btnTimKiemTen.setForeground(Color.WHITE);
		btnTimKiemTen.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTimKiemTen.setBackground(new Color(2, 104, 156));
		btnTimKiemTen.setBounds(812, 20, 61, 25);
		panel_1_2.add(btnTimKiemTen);

		JButton btnChamCong = new JButton("Chấm Công");
		btnChamCong.setForeground(Color.WHITE);
		btnChamCong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChamCong.setBackground(new Color(2, 104, 156));
		btnChamCong.setBounds(1259, 528, 129, 30);
		panel_1_2.add(btnChamCong);

		JLabel lblThongTin_1_1 = new JLabel("Tìm kiếm theo tên");
		lblThongTin_1_1.setForeground(new Color(0, 27, 72));
		lblThongTin_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTin_1_1.setBounds(394, 20, 187, 25);
		panel_1_2.add(lblThongTin_1_1);

		JLabel lblThongTin_1_1_1 = new JLabel("Sản Phẩm");
		lblThongTin_1_1_1.setForeground(new Color(0, 27, 72));
		lblThongTin_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTin_1_1_1.setBounds(899, 20, 116, 25);
		panel_1_2.add(lblThongTin_1_1_1);

		JComboBox comboBoxSP = new JComboBox();
		comboBoxSP.setBounds(1017, 20, 100, 25);
		panel_1_2.add(comboBoxSP);

		JComboBox comboBoxCongDoan = new JComboBox();
		comboBoxCongDoan.setBounds(1287, 20, 100, 25);
		panel_1_2.add(comboBoxCongDoan);

		JLabel lblThongTin_1_1_1_1 = new JLabel("Công Đoạn");
		lblThongTin_1_1_1_1.setForeground(new Color(0, 27, 72));
		lblThongTin_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTin_1_1_1_1.setBounds(1144, 20, 116, 25);
		panel_1_2.add(lblThongTin_1_1_1_1);

		JLabel lblThongTin_1_1_2 = new JLabel("Ngày Chấm Công");
		lblThongTin_1_1_2.setForeground(new Color(0, 27, 72));
		lblThongTin_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThongTin_1_1_2.setBounds(20, 20, 270, 25);
		panel_1_2.add(lblThongTin_1_1_2);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 128));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(366, 20, 5, 25);
		panel_1_2.add(separator);
		loadDataIntoTableChamCong();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private void loadDataIntoTableChamCong() {
		model_BagPhanCong.setRowCount(0);
		try {
			ArrayList<BangPhanCong> listBangPhanCong = dao_ChamCongThoLamDan.listAllBangPhanCong();

			for (BangPhanCong bangPhanCong : listBangPhanCong) {
				Object[] objects = { bangPhanCong.getThoLamDan().getMaThoLamDan(),
						bangPhanCong.getThoLamDan().getCongNhanVien().getHoTen(),
						bangPhanCong.getCongDoan().getDan().getMaSanPham(), bangPhanCong.getCongDoan().getTenCongDoan(),
						bangPhanCong.getSoLuongSanPham(), bangPhanCong.getSoLuongSanPham() };
				model_BagPhanCong.addRow(objects);
			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

	}
}
