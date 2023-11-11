package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.MyConnection;
import Entity.BangChamCongThoLamDan;
import Entity.BangLuongNhanVien;
import Entity.BangLuongThoLamDan;
import Entity.CongDoan;
import Entity.NhanVien;
import Entity.ThoLamDan;

public class DAO_LuongThoLamDan {
	public boolean themBangLuongThoLamDan(BangLuongThoLamDan bangLuong) {
		Connection conn = MyConnection.getInstance().getConnection();
		if (conn == null) {
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "INSERT INTO BangLuongThoLamDan " + "([maBangLuong], [maThoLamDan], [thang], [nam],[soLuong]) "
					+ "VALUES (?, ?, ?, ?,?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1, bangLuong.getMaBangLuong());
			stm.setString(2, bangLuong.getThoLamDan().getMaThoLamDan());
			stm.setInt(3, bangLuong.getThang());
			stm.setInt(4, bangLuong.getNam());
			stm.setInt(5, bangLuong.getSoLuongSanPham());
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

	public boolean updateBangLuongThoLamDan(BangLuongThoLamDan bangLuong) {

		try {
			Connection connection = MyConnection.getInstance().getConnection();
			String sql = "UPDATE [dbo].[BangLuongThoLamDan] " + "SET [maThoLamDan] = ?, " + "[thang] = ?, "
					+ "[nam] = ?, " + "[soLuong] = ? " + "WHERE [maBangLuong] = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, bangLuong.getThoLamDan().getMaThoLamDan());
			statement.setInt(2, bangLuong.getThang());
			statement.setInt(3, bangLuong.getNam());
			statement.setInt(4, bangLuong.getSoLuongSanPham());
			statement.setString(5, bangLuong.getMaBangLuong());

			int rowsAffected = statement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getMaBangLuong(int thang, int nam, String maThoLamDan) {
		String maBangLuongResult = null;
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			String sql = "{? = call dbo.GenerateMaBangLuongTLD(?, ?, ?)}";
			CallableStatement statement = connection.prepareCall(sql);

			statement.registerOutParameter(1, java.sql.Types.VARCHAR);
			statement.setString(2, maThoLamDan);
			statement.setInt(3, thang);
			statement.setInt(4, nam);

			statement.execute();

			maBangLuongResult = statement.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maBangLuongResult;
	}

	public boolean kiemTraTrungMa(int thang, int nam, String maThoLamDan) {
		boolean ketQua = true;
		DAO_LuongThoLamDan dao_LuongThoLamDan = new DAO_LuongThoLamDan();
		String maBangLuong = dao_LuongThoLamDan.getMaBangLuong(thang, nam, maThoLamDan);
		int tong = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(*) AS TotalCount\r\n" + "FROM BangLuongThoLamDan\r\n" + "WHERE maBangLuong = '"
					+ maBangLuong + "';";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				tong = rs.getInt("TotalCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (tong == 0) {
			ketQua = false;
		}
		return ketQua;
	}

	public BangLuongThoLamDan getBangLuongTheoMa(String maBangLuong) {
		BangLuongThoLamDan bangLuong = new BangLuongThoLamDan();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT [maBangLuong], [maThoLamDan], [thang], [nam] FROM [dbo].[BangLuongThoLamDan] where maBangLuong = '"
					+ maBangLuong + "'";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				bangLuong.setMaBangLuong(resultSet.getString("maBangLuong"));
				DAO_ThoLamDan dao_ThoLamDan = new DAO_ThoLamDan();
				ThoLamDan thoLamDan = dao_ThoLamDan.getTLDTheoMaThoLamDan(resultSet.getString("maThoLamDan"));
				bangLuong.setThoLamDan(thoLamDan);
				bangLuong.setThang(resultSet.getInt("thang"));
				bangLuong.setNam(resultSet.getInt("nam"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bangLuong;
	}

	public int laySoSanPham(String maThoLamDan, int thang, int nam) {
		int soSP = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT maThoLamDan, SUM(soLuongSanPham) AS SoSanPhamLam " + "FROM BangChamCongThoLamDan "
					+ "WHERE maThoLamDan = '" + maThoLamDan + "' " + "  AND MONTH(ngayChamCong) = '" + thang + "' "
					+ "  AND YEAR(ngayChamCong) = '" + nam + "'" + "GROUP BY \r\n" + "    maThoLamDan;";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soSP = rs.getInt(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soSP;
	}

	public double layTongThuNhapTungThang(String maThoLamDan, int thang, int nam) {
		double tongThuNhap = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT\r\n" + "    BCCTLD.maThoLamDan,\r\n" + "    MONTH(BCCTLD.ngayChamCong) AS Thang,\r\n"
					+ "    YEAR(BCCTLD.ngayChamCong) AS Nam,\r\n"
					+ "    SUM(CD.giaCongDoan * BCCTLD.soLuongSanPham) AS TongThuNhap\r\n" + "FROM\r\n"
					+ "    BangChamCongThoLamDan BCCTLD\r\n" + "JOIN\r\n"
					+ "    BangPhanCong BPC ON BCCTLD.maThoLamDan = BPC.maThoLamDan\r\n"
					+ "    AND BCCTLD.maCongDoan = BPC.maCongDoan\r\n" + "JOIN\r\n"
					+ "    CongDoan CD ON BPC.maCongDoan = CD.maCongDoan\r\n" + "GROUP BY\r\n"
					+ "    BCCTLD.maThoLamDan, MONTH(BCCTLD.ngayChamCong), YEAR(BCCTLD.ngayChamCong)"
					+ "Having BCCTLD.maThoLamDan = '" + maThoLamDan + "'\r\n" + "  AND MONTH(BCCTLD.ngayChamCong) = '"
					+ thang + "'\r\n" + "and  YEAR(BCCTLD.ngayChamCong)= '" + nam + "'\r\n";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				tongThuNhap = rs.getInt(4) * 1.0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tongThuNhap;
	}

	public int kiemTraTimKiemTheoTen(String ten) throws SQLException {
		int n = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(ThoLamDan.maCongNhanVien)\r\n" + "FROM ThoLamDan\r\n"
					+ "INNER JOIN CongNhanVien ON ThoLamDan.maCongNhanVien = CongNhanVien.maCongNhanVien\r\n"
					+ "where CongNhanVien.hoTen LIKE N'%" + ten + "%';" + "";
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

	public ArrayList<BangLuongThoLamDan> getBangLuongTheoTen(String tenThoLamDan) {
		ArrayList<BangLuongThoLamDan> list = new ArrayList<>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT BangLuongThoLamDan.*, CongNhanVien.hoTen  FROM BangLuongThoLamDan \r\n"
					+ "join ThoLamDan on BangLuongThoLamDan.maThoLamDan= ThoLamDan.maThoLamDan\r\n"
					+ "join CongNhanVien on CongNhanVien.maCongNhanVien= ThoLamDan.maCongNhanVien where CongNhanVien.hoTen LIKE N'%"
					+ tenThoLamDan + "%'";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				BangLuongThoLamDan bangLuong = new BangLuongThoLamDan();
				bangLuong.setMaBangLuong(resultSet.getString(1));
				bangLuong.setThang(resultSet.getInt(3));
				bangLuong.setNam(resultSet.getInt(4));
				DAO_ThoLamDan dao_ThoLamDan = new DAO_ThoLamDan();
				ThoLamDan thoLamDan = dao_ThoLamDan.getTLDTheoMaThoLamDan(resultSet.getString(2));
				bangLuong.setThoLamDan(thoLamDan);
				bangLuong.setSoLuongSanPham(resultSet.getInt(5));
				list.add(bangLuong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
