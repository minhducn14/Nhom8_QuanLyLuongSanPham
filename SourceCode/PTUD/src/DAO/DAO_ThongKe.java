package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import Connection.MyConnection;

public class DAO_ThongKe {
	public static ResultSet getTopLuongNhanVien(int thang, int nam) {
		String query = "SELECT Top 5\r\n" + "    cnv.hoTen,\r\n"
				+ "    dbo.tinhPhuCapThamNienTLD(cnv.ngayVaoLam, dbo.tinhHeSoLuongTLD(tho.tayNghe)) AS phuCapThamNien,\r\n"
				+ "    SUM(cd.giaCongDoan * bcc.soLuongSanPham) AS luongThucTe,\r\n"
				+ "    SUM(cd.giaCongDoan * bcc.soLuongSanPham) + dbo.tinhPhuCapThamNienTLD(cnv.ngayVaoLam, dbo.tinhHeSoLuongTLD(tho.tayNghe)) + 900000- (3000000 * 0.08 + 3000000 * 0.015 + 3000000 * 0.01) AS Tong\r\n"
				+ "FROM \r\n" + "    BangChamCongThoLamDan bcc \r\n" + "JOIN \r\n"
				+ "    CongDoan cd ON bcc.maCongDoan = cd.maCongDoan\r\n" + "JOIN \r\n"
				+ "    ThoLamDan tho ON bcc.maThoLamDan = tho.maThoLamDan\r\n" + "JOIN \r\n"
				+ "    CongNhanVien cnv ON cnv.maCongNhanVien = tho.maCongNhanVien\r\n"
				+ "where MONTH(bcc.ngayChamCong) = '" + thang + "'\r\n" + "and  YEAR(bcc.ngayChamCong)= '" + nam
				+ "'\r\n" + "GROUP BY \r\n" + "    cnv.hoTen, cnv.ngayVaoLam, tho.tayNghe\r\n" + "ORDER BY \r\n"
				+ "    luongThucTe DESC;";
		Connection con = MyConnection.getInstance().getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public DefaultTableModel getSPTheoTopLuongNhanVien(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Họ tên");
		model.addColumn("Tổng SP");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "SELECT Top 5\r\n" + "    cnv.hoTen,\r\n"
					+ "    dbo.tinhPhuCapThamNienTLD(cnv.ngayVaoLam, dbo.tinhHeSoLuongTLD(tho.tayNghe)) AS phuCapThamNien,\r\n"
					+ "    SUM(cd.giaCongDoan * bcc.soLuongSanPham) AS luongThucTe,\r\n"
					+ "    SUM(bcc.soLuongSanPham) AS tongSoSP,\r\n"
					+ "    SUM(cd.giaCongDoan * bcc.soLuongSanPham) + dbo.tinhPhuCapThamNienTLD(cnv.ngayVaoLam, dbo.tinhHeSoLuongTLD(tho.tayNghe)) + 900000- (3000000 * 0.08 + 3000000 * 0.015 + 3000000 * 0.01) AS Tong\r\n"
					+ "FROM \r\n" + "    BangChamCongThoLamDan bcc \r\n" + "JOIN \r\n"
					+ "    CongDoan cd ON bcc.maCongDoan = cd.maCongDoan\r\n" + "JOIN \r\n"
					+ "    ThoLamDan tho ON bcc.maThoLamDan = tho.maThoLamDan\r\n" + "JOIN \r\n"
					+ "    CongNhanVien cnv ON cnv.maCongNhanVien = tho.maCongNhanVien\r\n"
					+ "where MONTH(bcc.ngayChamCong) = '" + thang + "'\r\n" + "and  YEAR(bcc.ngayChamCong)= '" + nam
					+ "'\r\n" + "GROUP BY \r\n" + "    cnv.hoTen, cnv.ngayVaoLam, tho.tayNghe\r\n" + "ORDER BY \r\n"
					+ "    luongThucTe DESC;";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String employeeName = resultSet.getString("hoTen");
						int totalProducts = resultSet.getInt("tongSoSP");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(employeeName);
						row.add(totalProducts);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}
}