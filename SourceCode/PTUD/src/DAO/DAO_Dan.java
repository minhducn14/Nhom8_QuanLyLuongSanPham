package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.MyConnection;
import Entity.Dan;

public class DAO_Dan {

	public ArrayList<Dan> getAlListDan() {
		ArrayList<Dan> ds = new ArrayList<Dan>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "select * from Dan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Dan dan = new Dan();
				dan.setMaSanPham(rs.getString(1));
				dan.setTenSanPham(rs.getString(2));
				dan.setLoaiSanPham(rs.getString(3));
				dan.setMoTa(rs.getString(4));
				dan.setGiaBan(rs.getFloat(5));
				dan.setMatDan(rs.getString(6));
				dan.setEoLung(rs.getString(7));
				dan.setCan(rs.getString(8));
				dan.setMatPhim(rs.getString(9));
				dan.setDay(rs.getString(10));
				dan.setKhoa(rs.getString(11));
				dan.setCauNgua(rs.getString(12));
				dan.setTrangThai(rs.getBoolean(13));
				ds.add(dan);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;
	}

	public Dan getDanTheoMaSanPham(String maSanPham) {

		Dan dan = new Dan();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Dan Where maSanPham ='" + maSanPham + "'");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				dan.setMaSanPham(rs.getString(1));
				dan.setTenSanPham(rs.getString(2));
				dan.setLoaiSanPham(rs.getString(3));
				dan.setMoTa(rs.getString(4));
				dan.setGiaBan(rs.getFloat(5));
				dan.setMatDan(rs.getString(6));
				dan.setEoLung(rs.getString(7));
				dan.setCan(rs.getString(8));
				dan.setMatPhim(rs.getString(9));
				dan.setDay(rs.getString(10));
				dan.setKhoa(rs.getString(11));
				dan.setCauNgua(rs.getString(12));
				dan.setTrangThai(rs.getBoolean(13));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return dan;
	}

	public Dan getDanTheoTenSanPham(String tenSanPham) {

		Dan dan = new Dan();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Dan Where tenSanPham ='" + tenSanPham + "'");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				dan.setMaSanPham(rs.getString(1));
				dan.setTenSanPham(rs.getString(2));
				dan.setLoaiSanPham(rs.getString(3));
				dan.setMoTa(rs.getString(4));
				dan.setGiaBan(rs.getFloat(5));
				dan.setMatDan(rs.getString(6));
				dan.setEoLung(rs.getString(7));
				dan.setCan(rs.getString(8));
				dan.setMatPhim(rs.getString(9));
				dan.setDay(rs.getString(10));
				dan.setKhoa(rs.getString(11));
				dan.setCauNgua(rs.getString(12));
				dan.setTrangThai(rs.getBoolean(13));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return dan;
	}
}