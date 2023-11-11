package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.toedter.calendar.JDateChooser;

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
				CongDoan congDoan = congDoan_DAO.getCongDoanTheoMaCongDoan(maCongDoan);
				ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(maThoLamDan);
				bangPhanCong.setNgayPhanCong(rs.getDate(3));
				bangPhanCong.setCongDoan(congDoan);
				bangPhanCong.setThoLamDan(thoLamDan);
				bangPhanCong.setSoLuongSanPham(rs.getInt(4));
				ds.add(bangPhanCong);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;
	}

	public void insertBangPhanCong(BangPhanCong bangPhanCong) {
		String sql = "INSERT INTO [dbo].[BangPhanCong] ([maThoLamDan], [maCongDoan], [ngayPhanCong], [soLuongSanPham])"
				+ "VALUES (?, ?, ?, ?)";
		Connection connection = MyConnection.getInstance().getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, bangPhanCong.getThoLamDan().getMaThoLamDan());
			preparedStatement.setString(2, bangPhanCong.getCongDoan().getMaCongDoan());
			preparedStatement.setDate(3, bangPhanCong.getNgayPhanCong());
			preparedStatement.setInt(4, bangPhanCong.getSoLuongSanPham());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
				CongDoan congDoan = congDoan_DAO.getCongDoanTheoMaCongDoan(maCongDoan);
				ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(maThoLamDan);
				bangPhanCong.setCongDoan(congDoan);
				bangPhanCong.setThoLamDan(thoLamDan);
				bangPhanCong.setNgayPhanCong(rs.getDate(3));
				bangPhanCong.setSoLuongSanPham(rs.getInt(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return bangPhanCong;
	}

	public ArrayList<BangPhanCong> getBangPhanCongTheoNgayPhanCong(JDateChooser ngayPhanCong) {
		java.util.Date selectedDateUtil = ngayPhanCong.getDate();
		java.sql.Date selectedDateSql = new java.sql.Date(selectedDateUtil.getTime());

		ArrayList<BangPhanCong> ds = new ArrayList<BangPhanCong>();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from BangPhanCong Where ngayPhanCong ='" + selectedDateSql + "'");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BangPhanCong bangPhanCong = new BangPhanCong();
				DAO_CongDoan congDoan_DAO = new DAO_CongDoan();
				DAO_ThoLamDan thoLamDan_DAO = new DAO_ThoLamDan();
				String maThoLamDan = rs.getString(1);
				String maCongDoan = rs.getString(2);
				CongDoan congDoan = congDoan_DAO.getCongDoanTheoMaCongDoan(maCongDoan);
				ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(maThoLamDan);
				bangPhanCong.setNgayPhanCong(rs.getDate(3));
				bangPhanCong.setCongDoan(congDoan);
				bangPhanCong.setThoLamDan(thoLamDan);
				bangPhanCong.setSoLuongSanPham(rs.getInt(4));
				ds.add(bangPhanCong);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return ds;
	}

	public BangPhanCong getBangPhanCongTheoNgayTLDSP(Date ngay, String maTLD, String maCongDoan) {
		BangPhanCong bangPhanCong = new BangPhanCong();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from BangPhanCong Where ngayPhanCong ='" + ngay + "'"
							+ "and maThoLamDan ='" + maTLD + "'" + "and maCongDoan='" + maCongDoan + "'");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DAO_CongDoan congDoan_DAO = new DAO_CongDoan();
				DAO_ThoLamDan thoLamDan_DAO = new DAO_ThoLamDan();
				String maThoLamDan = rs.getString(1);
				String maCD = rs.getString(2);
				CongDoan congDoan = congDoan_DAO.getCongDoanTheoMaCongDoan(maCD);
				ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(maThoLamDan);
				bangPhanCong.setNgayPhanCong(rs.getDate(3));
				bangPhanCong.setCongDoan(congDoan);
				bangPhanCong.setThoLamDan(thoLamDan);
				bangPhanCong.setSoLuongSanPham(rs.getInt(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return bangPhanCong;
	}

	public BangPhanCong getBangPhanCongTheoNgayTLD(Date ngay, String maTLD) {
		BangPhanCong bpc = new BangPhanCong();
		try {
			Connection connection = MyConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from BangPhanCong Where ngayPhanCong ='" + ngay + "'"
							+ "and maThoLamDan ='" + maTLD + "'");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DAO_CongDoan congDoan_DAO = new DAO_CongDoan();
				DAO_ThoLamDan thoLamDan_DAO = new DAO_ThoLamDan();
				String maThoLamDan = rs.getString(1);
				String maCD = rs.getString(2);
				CongDoan congDoan = congDoan_DAO.getCongDoanTheoMaCongDoan(maCD);
				ThoLamDan thoLamDan = thoLamDan_DAO.getTLDTheoMaThoLamDan(maThoLamDan);
				bpc.setNgayPhanCong(rs.getDate(3));
				bpc.setCongDoan(congDoan);
				bpc.setThoLamDan(thoLamDan);
				bpc.setSoLuongSanPham(rs.getInt(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return bpc;
	}

}