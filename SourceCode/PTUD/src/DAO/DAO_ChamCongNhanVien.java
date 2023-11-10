package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.MyConnection;
import Entity.BangChamCongNhanVien;
import Entity.NhanVien;

public class DAO_ChamCongNhanVien {
	public boolean themBangChamCong(BangChamCongNhanVien bangChamCong) throws SQLException {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			return false;
		}
		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "INSERT INTO [dbo].[BangChamCongNhanVien] "
					+ "([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) "
					+ "VALUES ([dbo].[generate_IDBCCNV](?, ?),?, ?, ?, ?, ?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, bangChamCong.getNhanVien().getMaNhanVien());
			stm.setDate(2, bangChamCong.getNgayChamCong());
			stm.setString(3, bangChamCong.getNhanVien().getMaNhanVien());
			stm.setDate(4, bangChamCong.getNgayChamCong());
			stm.setString(5, bangChamCong.getTrangThaiDiLam());
			stm.setInt(6, bangChamCong.getSoGioTangCa());
			stm.setString(7, bangChamCong.getBangLuong().getMaBangLuong());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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

//	public boolean KiemTraTrung(BangChamCongNhanVien bangChamCong) throws SQLException {
//		int n = 0;
//		try {
//			Connection con = MyConnection.getInstance().getConnection();
//			String sql = "SELECT COUNT(*) AS so_luong_trung\r\n" + "FROM BangChamCongNhanVien\r\n"
//					+ "GROUP BY maNhanVien, ngayChamCong\r\n" + "having maNhanVien= '"
//					+ bangChamCong.getNhanVien().getMaNhanVien() + "' and ngayChamCong = '"
//					+ bangChamCong.getNgayChamCong() + "'";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				n = rs.getInt(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (n == 1) {
//			return false;
//		} else {
//			return true;
//		}
//	}

	public int kiemTraSoLuongDaChamCong(Date date) throws SQLException {
		int n = 0;
		int day = date.toLocalDate().getDayOfMonth();
		int month = date.toLocalDate().getMonthValue();
		int year = date.toLocalDate().getYear();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "Select count(maBCCNhanVien)\r\n" + "FROM BangChamCongNhanVien \r\n"
					+ "where DAY(ngayChamCong) =" + day + " \r\n" + "and month(ngayChamCong) =" + month + " \r\n"
					+ "and YEAR(ngayChamCong) =" + year + " \r\n" + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	public int kiemTraTimKiemTheoTen(String ten) throws SQLException {
		int n = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(NhanVien.maCongNhanVien)\r\n" + "FROM NhanVien\r\n"
					+ "INNER JOIN CongNhanVien ON NhanVien.maCongNhanVien = CongNhanVien.maCongNhanVien\r\n"
					+ "where CongNhanVien.hoTen LIKE '%" + ten + "%';" + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	public ArrayList<BangChamCongNhanVien> layDanhSachChamCong(Date date) throws SQLException {
		ArrayList<BangChamCongNhanVien> list = new ArrayList<>();
		int day = date.toLocalDate().getDayOfMonth();
		int month = date.toLocalDate().getMonthValue();
		int year = date.toLocalDate().getYear();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT NhanVien.maNhanVien, CongNhanVien.hoTen, BangChamCongNhanVien.trangThaiDiLam, BangChamCongNhanVien.soGioTangCa\r\n"
					+ "FROM NhanVien\r\n"
					+ "JOIN BangChamCongNhanVien ON NhanVien.maNhanVien = BangChamCongNhanVien.maNhanVien\r\n"
					+ "JOIN CongNhanVien ON NhanVien.maCongNhanVien = CongNhanVien.maCongNhanVien "
					+ "where DAY(BangChamCongNhanVien.ngayChamCong) =" + day + " \r\n" + "and month(ngayChamCong) ="
					+ month + " \r\n" + "and YEAR(ngayChamCong) =" + year + " \r\n" + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangChamCongNhanVien bccNhanVien = new BangChamCongNhanVien();
				DAO_NhanVien dao_nv = new DAO_NhanVien();
				NhanVien nv = dao_nv.getNhanVienTheoMa(rs.getString(1));
				bccNhanVien.setNhanVien(nv);
				bccNhanVien.setTrangThaiDiLam(rs.getString(3));
				bccNhanVien.setSoGioTangCa(rs.getInt(4));
				list.add(bccNhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BangChamCongNhanVien> layDanhSachChamCongTheoTen(Date date, String ten) throws SQLException {
		ArrayList<BangChamCongNhanVien> list = new ArrayList<>();
		int day = date.toLocalDate().getDayOfMonth();
		int month = date.toLocalDate().getMonthValue();
		int year = date.toLocalDate().getYear();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT NhanVien.maNhanVien, CongNhanVien.hoTen, BangChamCongNhanVien.trangThaiDiLam, BangChamCongNhanVien.soGioTangCa\r\n"
					+ "FROM NhanVien\r\n"
					+ "JOIN BangChamCongNhanVien ON NhanVien.maNhanVien = BangChamCongNhanVien.maNhanVien\r\n"
					+ "JOIN CongNhanVien ON NhanVien.maCongNhanVien = CongNhanVien.maCongNhanVien "
					+ "where DAY(BangChamCongNhanVien.ngayChamCong) =" + day + " \r\n" + "and month(ngayChamCong) ="
					+ month + " \r\n" + "and YEAR(ngayChamCong) =" + year + " \r\n" + "and CongNhanVien.hoTen LIKE N'%"
					+ ten + "%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangChamCongNhanVien bccNhanVien = new BangChamCongNhanVien();
				DAO_NhanVien dao_nv = new DAO_NhanVien();
				NhanVien nv = dao_nv.getNhanVienTheoMa(rs.getString(1));
				bccNhanVien.setNhanVien(nv);
				bccNhanVien.setTrangThaiDiLam(rs.getString(3));
				bccNhanVien.setSoGioTangCa(rs.getInt(4));
				list.add(bccNhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BangChamCongNhanVien> layDanhSachChamCongTheoPhongBan(Date date, String maPhongBan)
			throws SQLException {
		ArrayList<BangChamCongNhanVien> list = new ArrayList<>();
		int day = date.toLocalDate().getDayOfMonth();
		int month = date.toLocalDate().getMonthValue();
		int year = date.toLocalDate().getYear();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT NhanVien.maNhanVien, CongNhanVien.hoTen, BangChamCongNhanVien.trangThaiDiLam, BangChamCongNhanVien.soGioTangCa\r\n"
					+ "FROM NhanVien\r\n"
					+ "JOIN BangChamCongNhanVien ON NhanVien.maNhanVien = BangChamCongNhanVien.maNhanVien\r\n"
					+ "JOIN CongNhanVien ON NhanVien.maCongNhanVien = CongNhanVien.maCongNhanVien "
					+ "where DAY(BangChamCongNhanVien.ngayChamCong) =" + day + " \r\n" + "and month(ngayChamCong) ="
					+ month + " \r\n" + "and YEAR(ngayChamCong) =" + year + " \r\n" + "and maPhongBan = '" + maPhongBan
					+ "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangChamCongNhanVien bccNhanVien = new BangChamCongNhanVien();
				DAO_NhanVien dao_nv = new DAO_NhanVien();
				NhanVien nv = dao_nv.getNhanVienTheoMa(rs.getString(1));
				bccNhanVien.setNhanVien(nv);
				bccNhanVien.setTrangThaiDiLam(rs.getString(3));
				bccNhanVien.setSoGioTangCa(rs.getInt(4));
				list.add(bccNhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
