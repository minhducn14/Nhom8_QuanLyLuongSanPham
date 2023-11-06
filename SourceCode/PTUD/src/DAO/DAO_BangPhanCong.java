package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				ThoLamDan thoLamDan = DAO_ThoLamDan.getTLDTheoMaThoLamDan(maThoLamDan);
				bangPhanCong.setNgayPhanCong(rs.getDate(3));
				bangPhanCong.setCongDoan(congDoan);
				bangPhanCong.setThoLamDan(thoLamDan);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;
	}
}
