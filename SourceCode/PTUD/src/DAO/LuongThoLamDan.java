package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Connection.MyConnection;

public class LuongThoLamDan {
	public String getMaBangLuong(int thang, int nam, String maNhanVien) {
		String maBangLuongResult = null;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "{? = call dbo.[GenerateMaBangLuongTLD](?, ?, ?)}";
			CallableStatement statement = con.prepareCall(sql);

			statement.registerOutParameter(1, java.sql.Types.VARCHAR);
			statement.setInt(2, thang);
			statement.setInt(3, nam);
			statement.setString(4, maNhanVien);

			statement.execute();

			maBangLuongResult = statement.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maBangLuongResult;
	}
}
