package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.MyConnection;
import Entity.BangLuongNhanVien;
import Entity.BangLuongThoLamDan;
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
			String sql = "INSERT INTO BangLuongThoLamDan " + "([maBangLuong], [maThoLamDan], [thang], [nam]) "
					+ "VALUES (?, ?, ?, ?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1, bangLuong.getMaBangLuong());
			stm.setString(2, bangLuong.getThoLamDan().getMaThoLamDan());
			stm.setInt(3, bangLuong.getThang());
			stm.setInt(4, bangLuong.getNam());
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

}
