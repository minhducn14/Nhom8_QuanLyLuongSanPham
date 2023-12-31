package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.MyConnection;
import entity.PhongBan;

public class DAO_PhongBan {

	public ArrayList<PhongBan> docTuBang() {
		ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT maPhongBan,tenPhongBan FROM PhongBan";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhongBan = rs.getString(1);
				String tenPhongBan = rs.getString(2);

				PhongBan temp = new PhongBan(maPhongBan, tenPhongBan);

				dsPhongBan.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhongBan;
	}

	public PhongBan getPhongBanTheoTen(String tenPhongBan) {
		PhongBan phongBan = new PhongBan();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from PhongBan where tenPhongBan = N'" + tenPhongBan + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				phongBan.setMaPhongBan(resultSet.getString(1));
				phongBan.setTenPhongBan(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phongBan;
	}

	public PhongBan getPhongBanTheoMa(String maPhongBan) {
		PhongBan phongBan = new PhongBan();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from PhongBan where maPhongBan = '" + maPhongBan + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				phongBan.setMaPhongBan(resultSet.getString(1));
				phongBan.setTenPhongBan(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phongBan;
	}

	public ArrayList<PhongBan> getTatCaPhongBan() {
		ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT * FROM PhongBan";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhongBan = rs.getString(1);
				String tenPhongBan = rs.getString(2);

				PhongBan temp = new PhongBan(maPhongBan, tenPhongBan);

				dsPhongBan.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhongBan;
	}
}
