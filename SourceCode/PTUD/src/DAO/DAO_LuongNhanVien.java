package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.MyConnection;

public class DAO_LuongNhanVien {
	public boolean insertBangLuongNhanVien(String maNhanVien, int thang, int nam) {
		Connection conn = MyConnection.getInstance().getConnection();
		if (conn == null) {
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "insert into ThoLamDan(tayNghe, maCongNhanVien) values(?,?)";
			stm = conn.prepareStatement(sql);

			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return n > 0;
	}

	private int laySoNgayDiLamNguyenCaNgayThuong(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNguyenCa\r\n"
					+ "FROM BangChamCongNhanVien\r\n" + "WHERE maNhanVien = '" + maNhanVien + "\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) <> 1 \r\n" + "  AND trangThaiDiLam = N'Làm nguyên ca';\r\n"
					+ "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	private int laySoNgayDiLamNuaCaNgayThuong(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7; go  SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNuaCa\r\n"
					+ "FROM BangChamCongNhanVien\r\n" + "WHERE maNhanVien = '" + maNhanVien + "\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) <> 1 \r\n" + "  AND trangThaiDiLam = N'Làm nửa ca';\r\n"
					+ "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	private int laySoGioTangCaNgayThuong(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7; go SELECT SUM(soGioTangCa) AS TongSoGioTangCa\r\n"
					+ "FROM BangChamCongNhanVien" + "WHERE maNhanVien = '" + maNhanVien + "\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) <> 1 \r\n"
					+ "  AND trangThaiDiLam = N'Nghỉ không phép';\r\n" + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	private int laySoNgayDiLamNguyenCaCN(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7; go SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNguyenCa\r\n"
					+ "FROM BangChamCongNhanVien\r\n" + "WHERE maNhanVien = '" + maNhanVien + "\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) = 1 \r\n" + "  AND trangThaiDiLam = N'Làm nguyên ca';\r\n"
					+ "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	private int laySoNgayDiLamNuaCaCN(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7; go SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNuaCa\r\n"
					+ "FROM BangChamCongNhanVien\r\n" + "WHERE maNhanVien = '" + maNhanVien + "\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) = 1 \r\n" + "  AND trangThaiDiLam = N'Làm nửa ca';\r\n"
					+ "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	private int laySoGioTangCaCN(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7; go SELECT SUM(soGioTangCa) AS TongSoGioTangCa\r\n"
					+ "FROM BangChamCongNhanVien" + "WHERE maNhanVien = '" + maNhanVien + "\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) = 1 \r\n"
					+ "  AND trangThaiDiLam = N'Nghỉ không phép';\r\n" + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	private int laySoNgayNghiCoPhep(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNuaCa\r\n" + "FROM BangChamCongNhanVien\r\n"
					+ "WHERE maNhanVien = '" + maNhanVien + "\r\n" + "  AND MONTH(ngayChamCong) = " + thang + "\r\n"
					+ "  AND YEAR(ngayChamCong) = " + nam + "\r\n" + "  AND trangThaiDiLam = N'Nghỉ phép';\r\n" + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	private int laySoNgayNghiKhongPhep(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNuaCa\r\n" + "FROM BangChamCongNhanVien\r\n"
					+ "WHERE maNhanVien = '" + maNhanVien + "\r\n" + "  AND MONTH(ngayChamCong) = " + thang + "\r\n"
					+ "  AND YEAR(ngayChamCong) = " + nam + "\r\n" + "  AND trangThaiDiLam = N'Nghỉ không phép';\r\n"
					+ "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

}
