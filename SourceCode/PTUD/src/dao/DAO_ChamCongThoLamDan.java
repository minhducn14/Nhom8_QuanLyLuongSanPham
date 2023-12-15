package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;

import connection.MyConnection;
import entity.BangChamCongThoLamDan;
import entity.BangLuongThoLamDan;
import entity.BangPhanCong;
import entity.CongDoan;
import entity.ThoLamDan;

public class DAO_ChamCongThoLamDan {

	public ArrayList<BangPhanCong> listAllBangPhanCongTheoNgayHienTai() throws SQLException {
		LocalDate currentDate = LocalDate.now();
		java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
		ArrayList<BangPhanCong> listBangPhanCong = new ArrayList<BangPhanCong>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT BPC.* FROM BangPhanCong BPC \r\n" + "WHERE ngayPhanCong ='" + sqlDate + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangPhanCong bangPhanCong = new BangPhanCong();
				DAO_CongDoan congDoan_DAO = new DAO_CongDoan();
				DAO_ThoLamDan thoLamDan_DAO = new DAO_ThoLamDan();
				String maThoLamDan = rs.getString(1);
				String maCongDoan = rs.getString(2);
				CongDoan congDoan = congDoan_DAO.getCongDoanTheoMaCongDoan(maCongDoan);
				ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(maThoLamDan);
				bangPhanCong.setCongDoan(congDoan);
				bangPhanCong.setThoLamDan(thoLamDan);
				bangPhanCong.setNgayPhanCong(rs.getDate(3));
				bangPhanCong.setSoLuongSanPham(rs.getInt(4));
				listBangPhanCong.add(bangPhanCong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBangPhanCong;
	}

	public ArrayList<BangPhanCong> listAllBangPhanCongTheoNgayHienTaiVaSP(String maSP) throws SQLException {
		LocalDate currentDate = LocalDate.now();
		java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
		ArrayList<BangPhanCong> listBangPhanCong = new ArrayList<BangPhanCong>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT * FROM BangPhanCong \r\n "
					+ "join CongDoan on BangPhanCong.maCongDoan= CongDoan.maCongDoan\r\n" + "" + "WHERE ngayPhanCong ='"
					+ sqlDate + "'" + "and maSanPham ='" + maSP + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangPhanCong bangPhanCong = new BangPhanCong();
				DAO_CongDoan congDoan_DAO = new DAO_CongDoan();
				DAO_ThoLamDan thoLamDan_DAO = new DAO_ThoLamDan();
				String maThoLamDan = rs.getString(1);
				String maCongDoan = rs.getString(2);
				CongDoan congDoan = congDoan_DAO.getCongDoanTheoMaCongDoan(maCongDoan);
				ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(maThoLamDan);
				bangPhanCong.setCongDoan(congDoan);
				bangPhanCong.setThoLamDan(thoLamDan);
				bangPhanCong.setNgayPhanCong(rs.getDate(3));
				bangPhanCong.setSoLuongSanPham(rs.getInt(4));
				listBangPhanCong.add(bangPhanCong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBangPhanCong;
	}

	public ArrayList<BangPhanCong> listAllBangPhanCongTheoNgayHienTaiVaTenCongDoan(String tenCongDoan)
			throws SQLException {
		LocalDate currentDate = LocalDate.now();
		java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
		ArrayList<BangPhanCong> listBangPhanCong = new ArrayList<BangPhanCong>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT * FROM BangPhanCong \r\n "
					+ "join CongDoan on BangPhanCong.maCongDoan= CongDoan.maCongDoan\r\n" + "" + "WHERE ngayPhanCong ='"
					+ sqlDate + "'" + "and tenCongDoan =N'" + tenCongDoan + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangPhanCong bangPhanCong = new BangPhanCong();
				DAO_CongDoan congDoan_DAO = new DAO_CongDoan();
				DAO_ThoLamDan thoLamDan_DAO = new DAO_ThoLamDan();
				String maThoLamDan = rs.getString(1);
				String maCongDoan = rs.getString(2);
				CongDoan congDoan = congDoan_DAO.getCongDoanTheoMaCongDoan(maCongDoan);
				ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(maThoLamDan);
				bangPhanCong.setCongDoan(congDoan);
				bangPhanCong.setThoLamDan(thoLamDan);
				bangPhanCong.setNgayPhanCong(rs.getDate(3));
				bangPhanCong.setSoLuongSanPham(rs.getInt(4));
				listBangPhanCong.add(bangPhanCong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBangPhanCong;
	}

	public boolean themBangChamCong(BangChamCongThoLamDan bangChamCong) throws SQLException {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			return false;
		}
		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "INSERT INTO BangChamCongThoLamDan (maBCCThoLamDan, soLuongSanPham, ngayChamCong, maBangLuong, maThoLamDan, maCongDoan) "
					+ "VALUES ([dbo].[generate_IDBCCTLD](?, ?),?, ?, ?, ?, ?)";

			stm = con.prepareStatement(sql);
			stm.setString(1, bangChamCong.getThoLamDan().getMaThoLamDan());
			stm.setDate(2, bangChamCong.getNgayChamCong());
			stm.setInt(3, bangChamCong.getSoLuongSanPham());
			stm.setDate(4, bangChamCong.getNgayChamCong());
			stm.setString(5, bangChamCong.getBangLuong().getMaBangLuong());
			stm.setString(6, bangChamCong.getThoLamDan().getMaThoLamDan());
			stm.setString(7, bangChamCong.getCongDoan().getMaCongDoan());

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

	public ArrayList<BangChamCongThoLamDan> layDanhSachChamCong(Date date) throws SQLException {
		ArrayList<BangChamCongThoLamDan> list = new ArrayList<>();
		int day = date.toLocalDate().getDayOfMonth();
		int month = date.toLocalDate().getMonthValue();
		int year = date.toLocalDate().getYear();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT * FROM BangChamCongThoLamDan WHERE DAY(ngayChamCong) = " + day
					+ " AND MONTH(ngayChamCong) = " + month + " AND YEAR(ngayChamCong) = " + year + "";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangChamCongThoLamDan bccThoLamDan = new BangChamCongThoLamDan();
				bccThoLamDan.setMaBCCThoLamDan(rs.getString(1));
				bccThoLamDan.setSoLuongSanPham(rs.getInt(2));
				bccThoLamDan.setNgayChamCong(rs.getDate(3));
				DAO_ThoLamDan dao_tld = new DAO_ThoLamDan();
				ThoLamDan tld = dao_tld.getTLDTheoMaThoLamDan(rs.getString(5));
				bccThoLamDan.setThoLamDan(tld);
				DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();
				BangLuongThoLamDan luong = dao_LuongThoLamDan.getBangLuongTheoMa(rs.getString(4));
				bccThoLamDan.setBangLuong(luong);
				DAO_CongDoan dao_CongDoan = new DAO_CongDoan();
				CongDoan congdoan = dao_CongDoan.getCongDoanTheoMaCongDoan(rs.getString(6));
				bccThoLamDan.setCongDoan(congdoan);
				list.add(bccThoLamDan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BangChamCongThoLamDan> layDanhSachChamCongTheoTen(Date date, String ten) throws SQLException {
		ArrayList<BangChamCongThoLamDan> list = new ArrayList<>();
		int day = date.toLocalDate().getDayOfMonth();
		int month = date.toLocalDate().getMonthValue();
		int year = date.toLocalDate().getYear();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT BangChamCongThoLamDan.* FROM BangChamCongThoLamDan join ThoLamDan on BangChamCongThoLamDan.maThoLamDan=ThoLamDan.maThoLamDan\r\n"
					+ "join CongNhanVien on CongNhanVien.maCongNhanVien=ThoLamDan.maCongNhanVien  WHERE DAY(ngayChamCong) = "
					+ day + " AND MONTH(ngayChamCong) = " + month + " AND YEAR(ngayChamCong) = " + year + ""
					+ "and CongNhanVien.hoTen LIKE N'%" + ten + "%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangChamCongThoLamDan bccThoLamDan = new BangChamCongThoLamDan();
				bccThoLamDan.setMaBCCThoLamDan(rs.getString(1));
				bccThoLamDan.setSoLuongSanPham(rs.getInt(2));
				bccThoLamDan.setNgayChamCong(rs.getDate(3));
				DAO_ThoLamDan dao_tld = new DAO_ThoLamDan();
				ThoLamDan tld = dao_tld.getTLDTheoMaThoLamDan(rs.getString(5));
				bccThoLamDan.setThoLamDan(tld);
				DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();
				BangLuongThoLamDan luong = dao_LuongThoLamDan.getBangLuongTheoMa(rs.getString(4));
				bccThoLamDan.setBangLuong(luong);
				DAO_CongDoan dao_CongDoan = new DAO_CongDoan();
				CongDoan congdoan = dao_CongDoan.getCongDoanTheoMaCongDoan(rs.getString(6));
				bccThoLamDan.setCongDoan(congdoan);
				list.add(bccThoLamDan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BangChamCongThoLamDan> layDanhSachChamCongTheoSP(Date date, String maSP) throws SQLException {
		ArrayList<BangChamCongThoLamDan> list = new ArrayList<>();
		int day = date.toLocalDate().getDayOfMonth();
		int month = date.toLocalDate().getMonthValue();
		int year = date.toLocalDate().getYear();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT BangChamCongThoLamDan.* FROM BangChamCongThoLamDan join CongDoan on BangChamCongThoLamDan.maCongDoan=CongDoan.maCongDoan\r\n"
					+ "WHERE DAY(ngayChamCong) = " + day + " AND MONTH(ngayChamCong) = " + month
					+ " AND YEAR(ngayChamCong) = " + year + "" + "and  maSanPham ='" + maSP + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangChamCongThoLamDan bccThoLamDan = new BangChamCongThoLamDan();
				bccThoLamDan.setMaBCCThoLamDan(rs.getString(1));
				bccThoLamDan.setSoLuongSanPham(rs.getInt(2));
				bccThoLamDan.setNgayChamCong(rs.getDate(3));
				DAO_ThoLamDan dao_tld = new DAO_ThoLamDan();
				ThoLamDan tld = dao_tld.getTLDTheoMaThoLamDan(rs.getString(5));
				bccThoLamDan.setThoLamDan(tld);
				DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();
				BangLuongThoLamDan luong = dao_LuongThoLamDan.getBangLuongTheoMa(rs.getString(4));
				bccThoLamDan.setBangLuong(luong);
				DAO_CongDoan dao_CongDoan = new DAO_CongDoan();
				CongDoan congdoan = dao_CongDoan.getCongDoanTheoMaCongDoan(rs.getString(6));
				bccThoLamDan.setCongDoan(congdoan);
				list.add(bccThoLamDan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BangChamCongThoLamDan> layDanhSachChamCongTheoTenCongDoan(Date date, String tenCongDoan)
			throws SQLException {
		ArrayList<BangChamCongThoLamDan> list = new ArrayList<>();
		int day = date.toLocalDate().getDayOfMonth();
		int month = date.toLocalDate().getMonthValue();
		int year = date.toLocalDate().getYear();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT BangChamCongThoLamDan.*, tenCongDoan FROM BangChamCongThoLamDan join CongDoan on BangChamCongThoLamDan.maCongDoan=CongDoan.maCongDoan\r\n"
					+ "WHERE DAY(ngayChamCong) = " + day + " AND MONTH(ngayChamCong) = " + month
					+ " AND YEAR(ngayChamCong) = " + year + "" + "and  tenCongDoan =N'" + tenCongDoan + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangChamCongThoLamDan bccThoLamDan = new BangChamCongThoLamDan();
				bccThoLamDan.setMaBCCThoLamDan(rs.getString(1));
				bccThoLamDan.setSoLuongSanPham(rs.getInt(2));
				bccThoLamDan.setNgayChamCong(rs.getDate(3));
				DAO_ThoLamDan dao_tld = new DAO_ThoLamDan();
				ThoLamDan tld = dao_tld.getTLDTheoMaThoLamDan(rs.getString(5));
				bccThoLamDan.setThoLamDan(tld);
				DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();
				BangLuongThoLamDan luong = dao_LuongThoLamDan.getBangLuongTheoMa(rs.getString(4));
				bccThoLamDan.setBangLuong(luong);
				DAO_CongDoan dao_CongDoan = new DAO_CongDoan();
				CongDoan congdoan = dao_CongDoan.getCongDoanTheoMaCongDoan(rs.getString(6));
				bccThoLamDan.setCongDoan(congdoan);
				list.add(bccThoLamDan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int kiemTraTimKiemTheoTen(String ten) throws SQLException {
		int n = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(ThoLamDan.maCongNhanVien)\r\n" + "FROM ThoLamDan\r\n"
					+ "INNER JOIN CongNhanVien ON ThoLamDan.maCongNhanVien = CongNhanVien.maCongNhanVien\r\n"
					+ "where CongNhanVien.hoTen LIKE N'%" + ten + "%';";
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

	public ArrayList<BangChamCongThoLamDan> laySoLuongLamDuocCuaThang(String maThoLamDan, int thang, int nam) {
		ArrayList<BangChamCongThoLamDan> ds = new ArrayList<BangChamCongThoLamDan>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT TLD.maThoLamDan, CD.maSanPham, CD.maCongDoan, SUM(BCCTLD.soLuongSanPham) AS SoLuongLamDuoc\r\n"
					+ "FROM BangChamCongThoLamDan BCCTLD \r\n"
					+ "JOIN ThoLamDan TLD ON BCCTLD.maThoLamDan = TLD.maThoLamDan\r\n"
					+ "JOIN CongDoan CD ON BCCTLD.maCongDoan = CD.maCongDoan " + "WHERE\r\n"
					+ "    TLD.maThoLamDan ='" + maThoLamDan + "'\r\n" + "    AND MONTH(BCCTLD.ngayChamCong) = '"
					+ thang + "'\r\n" + "    AND YEAR(BCCTLD.ngayChamCong) = '" + nam + "'\r\n" + "GROUP BY\r\n"
					+ "TLD.maThoLamDan,\r\n" + "    CD.maSanPham,\r\n" + "	CD.maCongDoan\r\n" + "";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangChamCongThoLamDan bcc = new BangChamCongThoLamDan();
				int soLuong = rs.getInt(4);
				bcc.setSoLuongSanPham(soLuong);
				ds.add(bcc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
