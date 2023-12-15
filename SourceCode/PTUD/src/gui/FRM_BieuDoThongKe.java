package gui;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JYearChooser;

import connection.MyConnection;
import dao.DAO_ThongKe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Currency;
import java.util.Locale;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FRM_BieuDoThongKe extends JPanel {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
//	private JFreeChart chartThongKeLuong;
	private JYearChooser yearChooser;
	private JComboBox<Object> cmbThang;
	private ChartPanel panelChart;
	private JPanel panel_1 = new JPanel();
	private JTable table = new JTable();
	private DefaultTableModel model;
	private static DAO_ThongKe dao_ThongKe = new DAO_ThongKe();

	/**
	 * Create the panel.
	 */
	public FRM_BieuDoThongKe() {
		MyConnection.getInstance().MyConnection();

		setLayout(null);

		setBackground(new Color(221, 242, 251));
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.setColumnSelectionAllowed(false);
		columnModel.setColumnMargin(0);
		table.getTableHeader().setReorderingAllowed(false);

		JTableHeader tb = table.getTableHeader();
		tb.setBackground(new Color(151, 201, 219));
		tb.setFont(new Font("Tahoma", Font.BOLD, 16));
		int rowHeight = 30;
		int rowMargin = 10;
		table.setRowHeight(rowHeight);
		table.setIntercellSpacing(new java.awt.Dimension(0, rowMargin));
		JLabel lblNewLabel_1 = new JLabel("BIỂU ĐỒ THỐNG KÊ LƯƠNG\r\n");
		lblNewLabel_1.setBounds(450, 5, 600, 70);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(15, 90, 300, 454);
		panel.setBounds(25, 90, 280, 550);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_5_1 = new JLabel("Thời gian thống kê\r\n");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(35, 15, 217, 25);
		lblNewLabel_5_1.setBounds(35, 15, 210, 25);
		panel.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Thống kê trong năm:");

		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1_1.setBounds(20, 90, 217, 25);
		lblNewLabel_5_1_1.setBounds(0, 50, 280, 25);
		panel.add(lblNewLabel_5_1_1);

		String[] thang = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cmbThang = new JComboBox<Object>(thang);
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		int monthValue = currentMonth.getValue();
		cmbThang.setSelectedIndex(monthValue - 1);
		cmbThang.setBounds(57, 85, 56, 30);
		panel.add(cmbThang);

		yearChooser = new JYearChooser();
		yearChooser.setLocation(160, 85);
		yearChooser.setSize(60, 30);
		panel.add(yearChooser);

		JButton btnTmKim = new JButton("Thống kê");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedYear = yearChooser.getYear();
		        int selectedMonth = Integer.parseInt(cmbThang.getSelectedItem().toString());

		        LocalDate currentDate = LocalDate.now();
		        int currentYear = currentDate.getYear();
		        int currentMonth = currentDate.getMonthValue();

		        if (selectedYear > currentYear || (selectedYear == currentYear && selectedMonth > currentMonth)) {
		            JOptionPane.showMessageDialog(null, "Tháng và năm không hợp lệ! Vui lòng chọn một tháng và năm trong phù hợp.");
		            return;
		        }
				panel_1.removeAll();
				JLabel lblNewLabel_5 = new JLabel("Biểu đồ thống kê");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_5.setBounds(35, 15, 217, 25);
				panel_1.add(lblNewLabel_5);
				int nam = yearChooser.getYear();
				int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
				JFreeChart chart = createBarChart(thang, nam);
				panelChart = new ChartPanel(chart);
				panelChart.setSize(1000, 470);
				panelChart.setLocation(40, 55);
				panelChart.setPopupMenu(null);
				panelChart.setDomainZoomable(false);
				panelChart.setRangeZoomable(false);
				panel_1.add(panelChart);
				panel_1.revalidate();
				panel_1.repaint();
				model = dao_ThongKe.getSPTheoTopLuongNhanVien(thang, nam);
				table.setModel(model);
			}
		});
		btnTmKim.setForeground(Color.WHITE);
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTmKim.setBackground(new Color(2, 104, 156));
		btnTmKim.setBounds(65, 243, 170, 50);
		btnTmKim.setBounds(57, 138, 170, 50);
		panel.add(btnTmKim);

		panel_1 = new JPanel();

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(0, 216, 280, 5);
		panel.add(separator);

		JLabel lblNewLabel_5_1_2 = new JLabel("Tổng số sản phẩm");
		lblNewLabel_5_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5_1_2.setBounds(0, 242, 280, 25);
		panel.add(lblNewLabel_5_1_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 283, 260, 257);
		panel.add(scrollPane);

		scrollPane.setViewportView(table);

		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(340, 90, 1083, 550);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Biểu đồ thống kê");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(35, 15, 217, 25);
		panel_1.add(lblNewLabel_5);

	}

	public static JFreeChart createBarChart(int thang, int nam) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ResultSet rs = DAO_ThongKe.getTopLuongNhanVien(thang, nam);
		try {
			while (rs != null && rs.next()) {
				dataset.addValue(rs.getDouble("luongThucTe"), "Thu nhập", rs.getString("hoTen"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JFreeChart chart = ChartFactory.createBarChart("Top thợ làm đàn có thu nhập cao", "Họ tên", "Thu nhập (VNĐ)",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		customizeChart(chart);
		return chart;

	}

	private static void customizeChart(JFreeChart chart) {
		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setSeriesPaint(0, Color.RED);

		NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();

		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		currencyFormat.setCurrency(Currency.getInstance("VND"));
		yAxis.setNumberFormatOverride(currencyFormat);

		yAxis.setLabel("Thu nhập (VNĐ)");

		TextTitle title = chart.getTitle();
		title.setFont(new Font("SansSerif", Font.BOLD, 16));
	}
}