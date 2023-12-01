package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public ArrayList<CongDoan> getAlListCongDoan() {
		ArrayList<CongDoan> ds = new ArrayList<CongDoan>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT * FROM CongDoan";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
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

	public CongDoan getCongDoanTheoMaCongDoan(String maCongDoan) {

		CongDoan congDoan = new CongDoan();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			String sql = "select * from CongDoan Where maCongDoan ='" + maCongDoan + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

	public String getMaCongDoan(String maSanPham) {
		String maxMaCongDoan = null;

		try {
			Connection connection = MyConnection.getInstance().getConnection();
			String sql = "SELECT MAX(maCongDoan) AS MaxMaCongDoan FROM CongDoan WHERE maSanPham = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, maSanPham);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					if (resultSet.next()) {
						maxMaCongDoan = resultSet.getString("MaxMaCongDoan");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maxMaCongDoan;
	}

	public CongDoan getCongDoanTheoCDSP(String tenCongDoan, String maSanPham) {

		CongDoan congDoan = new CongDoan();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			String sql = "SELECT [maCongDoan]\r\n" + "      ,[tenCongDoan]\r\n" + "      ,[maSanPham]\r\n"
					+ "      ,[giaCongDoan]\r\n" + "FROM CongDoan\r\n" + "WHERE [maSanPham] = '" + maSanPham + "'\r\n"
					+ "  AND [tenCongDoan] = N'" + tenCongDoan + "'" + "";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

	public ArrayList<CongDoan> getCongDoanTheoTLDNgayThang(String maThoLamDan, int thang, int nam) {
		ArrayList<CongDoan> ds = new ArrayList<CongDoan>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT\r\n" + "    TLD.maThoLamDan,\r\n" + "    CD.maSanPham,\r\n" + "	CD.maCongDoan,\r\n"
					+ "    SUM(BCCTLD.soLuongSanPham) AS SoLuongLamDuoc\r\n" + "FROM\r\n"
					+ "    BangChamCongThoLamDan BCCTLD\r\n" + "JOIN\r\n"
					+ "    ThoLamDan TLD ON BCCTLD.maThoLamDan = TLD.maThoLamDan\r\n" + "JOIN\r\n"
					+ "    BangPhanCong BPC ON BCCTLD.maThoLamDan = BPC.maThoLamDan AND BCCTLD.maCongDoan = BPC.maCongDoan\r\n"
					+ "JOIN\r\n" + "    CongDoan CD ON BPC.maCongDoan = CD.maCongDoan\r\n" + "WHERE\r\n"
					+ "    TLD.maThoLamDan ='" + maThoLamDan + "'\r\n" + "    AND MONTH(BCCTLD.ngayChamCong) = '"
					+ thang + "'\r\n" + "    AND YEAR(BCCTLD.ngayChamCong) = '" + nam + "'\r\n" + "GROUP BY\r\n"
					+ "TLD.maThoLamDan,\r\n" + "    CD.maSanPham,\r\n" + "	CD.maCongDoan\r\n" + "";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				CongDoan congDoan = new CongDoan();
				DAO_CongDoan dao_congDoan = new DAO_CongDoan();
				congDoan = dao_congDoan.getCongDoanTheoMaCongDoan(rs.getString(3));
				ds.add(congDoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public boolean checkIfExists(String tenCongDoan, String maSanPham) {
		boolean ketQua = true;
		int tong = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(*) FROM CongDoan WHERE TenCongDoan = N'" + tenCongDoan + "' AND MaSanPham = '"
					+ maSanPham + "'";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				tong = rs.getInt(1);
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