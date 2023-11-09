package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.MyConnection;
import Entity.BangPhanCong;
import Entity.CongDoan;
import Entity.Dan;
import Entity.ThoLamDan;

public class DAO_BangPhanCong {
	public static ArrayList<BangPhanCong> getAlListBangPhanCong() {

		ArrayList<BangPhanCong> ds = new ArrayList<BangPhanCong>();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from BangPhanCong");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BangPhanCong bangPhanCong = new BangPhanCong();
				DAO_CongDoan congDoan_DAO = new DAO_CongDoan();
				DAO_ThoLamDan thoLamDan_DAO = new DAO_ThoLamDan();
				String maThoLamDan = rs.getString(1);
				String maCongDoan = rs.getString(2);
				CongDoan congDoan = DAO_CongDoan.getCongDoanTheoMaCongDoan(maCongDoan);
				ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(maThoLamDan);
				bangPhanCong.setNgayPhanCong(rs.getDate(3));
				bangPhanCong.setCongDoan(congDoan);
				bangPhanCong.setThoLamDan(thoLamDan);
				ds.add(bangPhanCong);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;
	}

	public boolean insertBangPhanCong(BangPhanCong bangPhanCong) {
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			String query = "INSERT INTO BangPhanCong (maThoLamDan, MaCongDoan, ngayPhanCong, soLuongSanPham)"
					+ "VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bangPhanCong.getThoLamDan().getMaThoLamDan());
			preparedStatement.setString(2, bangPhanCong.getCongDoan().getMaCongDoan());
			preparedStatement.setDate(3, bangPhanCong.getNgayPhanCong());
			preparedStatement.setInt(4, bangPhanCong.getSoLuongSanPham());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public BangPhanCong getBangPhanCongMoiTao() {
		BangPhanCong bangPhanCong = new BangPhanCong();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select TOP 1 * from BangPhanCong order by maCongDoan DESC");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DAO_CongDoan congDoan_DAO = new DAO_CongDoan();
				DAO_ThoLamDan thoLamDan_DAO = new DAO_ThoLamDan();
				String maThoLamDan = rs.getString(1);
				String maCongDoan = rs.getString(2);
				CongDoan congDoan = DAO_CongDoan.getCongDoanTheoMaCongDoan(maCongDoan);
				ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(maThoLamDan);
				bangPhanCong.setCongDoan(congDoan);
				bangPhanCong.setThoLamDan(thoLamDan);
				bangPhanCong.setNgayPhanCong(rs.getDate(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return bangPhanCong;
	}
}