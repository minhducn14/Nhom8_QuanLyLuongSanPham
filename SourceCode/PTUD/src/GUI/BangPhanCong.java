package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import DAO.DAO_BangPhanCong;
import DAO.DAO_CongDoan;
import DAO.DAO_ThoLamDan;
import Entity.ThoLamDan;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NonWritableChannelException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class BangPhanCong extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable tblDSCD;
	private JTable tblDSTLD;
	private JDateChooser ngayPhanCong;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoaRongs;
	private JTextField txtMaPhanCong;
	private JTextField txtSoLuongSanPham;
	private DefaultTableModel modelDSCD;
	private DAO_CongDoan congDoan_DAO;
	private DefaultTableModel modelDSTLD;
	private DAO_ThoLamDan thoLamDan_DAO;
	private DefaultTableModel modelDSPC;
	private DAO_BangPhanCong bangPhanCong_DAO;
	private JTable tblDSPC;

	/**
	 * Create the panel.
	 */
	public BangPhanCong() {
		congDoan_DAO = new DAO_CongDoan();
		thoLamDan_DAO = new DAO_ThoLamDan();
		bangPhanCong_DAO = new DAO_BangPhanCong();

		setBackground(new Color(221, 242, 251));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(550, 5, 375, 70);
		add(lblNewLabel);
		lblNewLabel.setText("BẢNG PHÂN CÔNG");

		JPanel pnlThongTinCongDoan = new JPanel();
		pnlThongTinCongDoan.setBounds(990, 90, 450, 315);
		pnlThongTinCongDoan.setBackground(Color.WHITE);
		add(pnlThongTinCongDoan);
		pnlThongTinCongDoan.setLayout(null);

		JButton btnPhanCong = new JButton("New button");
		btnPhanCong.setBounds(30, 260, 170, 40);
		pnlThongTinCongDoan.add(btnPhanCong);
		btnPhanCong.setForeground(Color.WHITE);
		btnPhanCong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPhanCong.setBackground(new Color(2, 104, 156));
		btnPhanCong.setText("Phân công\r\n");

		JButton btnXoaRong = new JButton("New button");
		btnXoaRong.setBounds(250, 260, 170, 40);
		pnlThongTinCongDoan.add(btnXoaRong);
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setBackground(new Color(2, 104, 156));
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaRong.setText("Xoá rỗng");

		ngayPhanCong = new JDateChooser();
		ngayPhanCong.setSize(new Dimension(30, 20));
		ngayPhanCong.setDateFormatString("dd-MM-yyyy");
		try {
			Date date = Date.valueOf(LocalDate.now());
			ngayPhanCong.setDate(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ngayPhanCong.setBounds(200, 150, 200, 25);
		ngayPhanCong.setEnabled(false);
		pnlThongTinCongDoan.add(ngayPhanCong);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(20, 150, 170, 25);
		pnlThongTinCongDoan.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setText("Ngày chấm công");

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(20, 65, 170, 25);
		pnlThongTinCongDoan.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setText("Số lượng sản phẩm\r\n");

		JTextField txtSoLuongSanPham = new JTextField();
		txtSoLuongSanPham.setBounds(200, 65, 200, 25);
		pnlThongTinCongDoan.add(txtSoLuongSanPham);
		txtSoLuongSanPham.setColumns(10);
		lblNewLabel_2.setLabelFor(txtSoLuongSanPham);
		txtSoLuongSanPham.setEnabled(false);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(35, 15, 220, 25);
		pnlThongTinCongDoan.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setText("Thông tin phân công");

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, 90, 450, 315);
		panel_1.setBackground(Color.WHITE);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(35, 15, 249, 25);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setText("Danh sách thợ làm đàn\r\n");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 65, 410, 230);
		panel_1.add(scrollPane);

		String[] cols = { "M\u00E3 Th\u1EE3 L\u00E0m \u0110\u00E0n", "T\u00EAn Th\u1EE3 L\u00E0m \u0110\u00E0n" };
		modelDSTLD = new DefaultTableModel(cols, 0);
		tblDSTLD = new JTable(modelDSTLD);
		loadDataTLD(DAO_ThoLamDan.getAlListThoLamDan());

		scrollPane.setViewportView(tblDSTLD);
		JTableHeader tb = tblDSTLD.getTableHeader();
		tb.setBackground(new Color(221, 242, 251));
		tb.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		tblDSTLD.setRowHeight(rowHeight);
		tblDSTLD.setIntercellSpacing(new Dimension(0, rowMargin));

		ListSelectionModel listSelectionModel = tblDSTLD.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(15, 430, 1420, 3);
		add(separator_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(15, 490, 1420, 200);
		add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 10, 1380, 180);
		panel_2.add(scrollPane_1);

		String[] col = { "M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n",
				"M\u00E3 Th\u1EE3 L\u00E0m \u0110\u00E0n", "T\u00EAn Th\u1EE3 L\u00E0m \u0110\u00E0n",
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Ng\u00E0y Ph\u00E2n C\u00F4ng" };
		modelDSPC = new DefaultTableModel(col, 0);
		tblDSPC = new JTable(modelDSPC);
		loadDataPC(DAO_BangPhanCong.getAlListBangPhanCong());

		scrollPane_1.setViewportView(tblDSPC);
		JTableHeader tb1 = tblDSPC.getTableHeader();
		tb1.setBackground(new Color(221, 242, 251));
		tb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		tblDSPC.setRowHeight(rowHeight);
		tblDSPC.setIntercellSpacing(new Dimension(0, rowMargin));

		ListSelectionModel listSelectionModel2 = tblDSPC.getSelectionModel();
		listSelectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(49, 450, 217, 25);
		add(lblNewLabel_6);
		lblNewLabel_6.setText("Danh sách phân công\r\n");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(502, 90, 450, 315);
		add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 60, 410, 230);
		panel_3.add(scrollPane_2);

		String[] column = { "M\u00E3 C\u00F4ng \u0110o\u1EA1n", "T\u00EAn C\u00F4ng \u0110o\u1EA1n" };
		modelDSCD = new DefaultTableModel(column, 0);
		tblDSCD = new JTable(modelDSCD);
		loadDataCD(DAO_CongDoan.getAlListCongDoan());

		scrollPane_2.setViewportView(tblDSCD);
		JTableHeader tb2 = tblDSCD.getTableHeader();
		tb2.setBackground(new Color(221, 242, 251));
		tb2.setFont(new Font("Tahoma", Font.BOLD, 16));
		tblDSCD.setRowHeight(rowHeight);
		tblDSCD.setIntercellSpacing(new Dimension(0, rowMargin));

		ListSelectionModel listSelectionModel1 = tblDSCD.getSelectionModel();
		listSelectionModel1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblNewLabel_5_1 = new JLabel("Danh sách công đoạn");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(35, 15, 217, 25);
		panel_3.add(lblNewLabel_5_1);

		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaPhanCong.setText("");
				txtSoLuongSanPham.setText("");
			}
		});

		btnPhanCong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnPhanCong.getText().equals("Phân công")) {
					btnPhanCong.setText("Lưu");
					btnXoaRong.setText("Huỷ");
					txtSoLuongSanPham.setEnabled(true);
				} else {
					btnPhanCong.setText("Phân công");
					btnXoaRong.setText("Xoá rỗng");
					txtSoLuongSanPham.setEnabled(false);
					txtSoLuongSanPham.setText("");
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	private void loadDataCD(ArrayList<Entity.CongDoan> dsCD) {
		modelDSCD.setRowCount(0);
		for (Entity.CongDoan congDoan : dsCD) {
			Object[] objects = { congDoan.getMaCongDoan(), congDoan.getTenCongDoan() };
			modelDSCD.addRow(objects);
		}

	}

	private void loadDataTLD(ArrayList<Entity.ThoLamDan> dsTLD) {
		modelDSTLD.setRowCount(0);
		for (Entity.ThoLamDan thoLamDan : dsTLD) {
			Object[] objects = { thoLamDan.getMaThoLamDan(), thoLamDan.getCongNhanVien().getHoTen() };
			modelDSTLD.addRow(objects);
		}
	}

	private void loadDataPC(ArrayList<Entity.BangPhanCong> dsPC) {
		modelDSPC.setRowCount(0);
		for (Entity.BangPhanCong bangPhanCong : dsPC) {
			Object[] objects = { bangPhanCong.getCongDoan().getMaCongDoan(),
					bangPhanCong.getCongDoan().getTenCongDoan(), bangPhanCong.getThoLamDan().getMaThoLamDan(),
					bangPhanCong.getThoLamDan().getCongNhanVien().getHoTen(),
					bangPhanCong.getCongDoan().getDan().getMaSanPham(),
					bangPhanCong.getCongDoan().getDan().getTenSanPham(), bangPhanCong.getNgayPhanCong() };
			modelDSPC.addRow(objects);
		}
	}
}
