package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.MyConnection;

public class DAO_LuongThoLamDan {
	public String getMaBangLuong(int thang, int nam, String maThoLamDan) {
		String maBangLuongResult = null;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "{? = call dbo.[GenerateMaBangLuongTLD](?, ?, ?)}";
			CallableStatement statement = con.prepareCall(sql);

			statement.registerOutParameter(1, java.sql.Types.VARCHAR);
			statement.setInt(2, thang);
			statement.setInt(3, nam);
			statement.setString(4, maThoLamDan);

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
			String sql = "SELECT COUNT(*) AS TotalCount\r\n" + "FROM BangLuongNhanVien\r\n" + "WHERE maBangLuong = '"
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
}
