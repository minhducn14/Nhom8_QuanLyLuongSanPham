package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Connection.MyConnection;
import Entity.CongNhanVien;
import Entity.ThoLamDan;

public class DAO_ThoLamDan {

	public ArrayList<ThoLamDan> docTuBang() {
		ArrayList<ThoLamDan> dsThoLamDan = new ArrayList<ThoLamDan>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT *\r\n" + "FROM ThoLamDan\r\n"
					+ "INNER JOIN CongNhanVien ON CongNhanVien.maCongNhanVien = ThoLamDan.maCongNhanVien\r\n";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				ThoLamDan thoLamDan = new ThoLamDan();
				thoLamDan.setMaThoLamDan(rs.getString(1));
				thoLamDan.setTayNghe(rs.getString(2));
				DAO_CongNhanVien dao_CNV = new DAO_CongNhanVien();
				CongNhanVien congNhanVien = dao_CNV.getCongNhanVienTheoMa(rs.getString(3));
				thoLamDan.setCongNhanVien(congNhanVien);
				dsThoLamDan.add(thoLamDan);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsThoLamDan;
	}

	public boolean taoTLD(ThoLamDan tld) {
		Connection conn = MyConnection.getInstance().getConnection();
		if (conn == null) {
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "insert into ThoLamDan(tayNghe, maCongNhanVien) values(?,?)";
			stm = conn.prepareStatement(sql);
			stm.setString(1, tld.getTayNghe());
			stm.setString(2, tld.getCongNhanVien().getMaCongNhanVien());
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

	public String getMaThoLamDanMoiTao() {
		String maThoLamDan = null;
		try {
			Connection conn = MyConnection.getInstance().getConnection();
			String sql = "SELECT TOP 1 maThoLamDan  FROM ThoLamDan  ORDER BY maThoLamDan DESC";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				maThoLamDan = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maThoLamDan;
	}

	public static ArrayList<ThoLamDan> getAlListThoLamDan() {

		ArrayList<ThoLamDan> ds = new ArrayList<ThoLamDan>();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from ThoLamDan");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ThoLamDan thoLamDan = new ThoLamDan();
				thoLamDan.setMaThoLamDan(rs.getString(1));
				thoLamDan.setTayNghe(rs.getString(2));
				DAO_CongNhanVien dao_CNV = new DAO_CongNhanVien();
				CongNhanVien congNhanVien = dao_CNV.getCongNhanVienTheoMa(rs.getString(3));
				thoLamDan.setCongNhanVien(congNhanVien);
				ds.add(thoLamDan);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;
	}

	public static ThoLamDan getTLDTheoMaThoLamDan(String maThoLamDan) {
		ThoLamDan thoLamDan = new ThoLamDan();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from ThoLamDan Where maThoLamDan ='" + maThoLamDan + "'");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				thoLamDan.setMaThoLamDan(rs.getString(1));
				thoLamDan.setTayNghe(rs.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return thoLamDan;
	}
}