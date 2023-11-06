package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.MyConnection;
import Entity.CongDoan;
import Entity.Dan;

public class DAO_CongDoan {
	public boolean insertCongDoan(CongDoan congDoan) {
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			String query = "INSERT INTO CongDoan (maCongDoan, tenCongDoan, maSanPham, giaCongDoan)\r\n" + "VALUES\r\n"
					+ "    (dbo.generate_IDCD(?), ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, congDoan.getDan().getMaSanPham());
			preparedStatement.setString(2, congDoan.getTenCongDoan());
			preparedStatement.setString(3, congDoan.getDan().getMaSanPham());
			preparedStatement.setFloat(4, congDoan.getGiaCongDoan());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<CongDoan> getAlListCongDoan() {
		ArrayList<CongDoan> ds = new ArrayList<CongDoan>();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CongDoan");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CongDoan congDoan = new CongDoan();
				congDoan.setMaCongDoan(rs.getString(1));
				congDoan.setTenCongDoan(rs.getString(2));
				DAO_Dan dan_DAO = new DAO_Dan();
				String maSanPham = rs.getString(3);
				Dan dan = dan_DAO.getDanTheoMaSanPham(maSanPham);
				congDoan.setGiaCongDoan(rs.getFloat(4));
				congDoan.setDan(dan);
				ds.add(congDoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public boolean updateCongDoan(CongDoan congDoan) {
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			String query = "UPDATE CongDoan SET tenCongDoan = ?, giaCongDoan = ? WHERE maCongDoan = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, congDoan.getTenCongDoan());
			preparedStatement.setFloat(2, congDoan.getGiaCongDoan());
			preparedStatement.setString(3, congDoan.getMaCongDoan());
			int rowsUpdated = preparedStatement.executeUpdate();

			if (rowsUpdated > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static CongDoan getCongDoanTheoMaCongDoan(String maCongDoan) {
		CongDoan congDoan = new CongDoan();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from CongDoan Where maCongDoan ='" + maCongDoan + "'");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				congDoan.setMaCongDoan(rs.getString(1));
				congDoan.setTenCongDoan(rs.getString(2));
				DAO_Dan dan_DAO = new DAO_Dan();
				Dan dan = dan_DAO.getDanTheoMaSanPham(rs.getString(3));
				congDoan.setDan(dan);
				congDoan.setGiaCongDoan(rs.getFloat(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return congDoan;
	}

	public static CongDoan getCongDoanMoiTao() {
		CongDoan congDoan = new CongDoan();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select TOP 1 * from CongDoan order by maCongDoan DESC");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				congDoan.setMaCongDoan(rs.getString(1));
				congDoan.setTenCongDoan(rs.getString(2));
				DAO_Dan dan_DAO = new DAO_Dan();
				Dan dan = dan_DAO.getDanTheoMaSanPham(rs.getString(3));
				congDoan.setDan(dan);
				congDoan.setGiaCongDoan(rs.getFloat(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return congDoan;
	}
}
