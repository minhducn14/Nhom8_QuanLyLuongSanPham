package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;

import Connection.MyConnection;
import Entity.BangChamCongNhanVien;
import Entity.BangPhanCong;
import Entity.CongDoan;
import Entity.NhanVien;
import Entity.ThoLamDan;

public class DAO_ChamCongThoLamDan {

	public ArrayList<BangPhanCong> listAllBangPhanCongTheoNgayHienTai() throws SQLException {
		LocalDate currentDate = LocalDate.now();

		java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
		ArrayList<BangPhanCong> listBangPhanCong = new ArrayList();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT BPC.* FROM BangPhanCong BPC \r\n" + "LEFT JOIN BangChamCongThoLamDan BCC \r\n"
					+ "ON BPC.maThoLamDan = BCC.maThoLamDan AND BPC.maCongDoan = BCC.maCongDoan \r\n"
					+ "WHERE BCC.maThoLamDan IS NULL AND BCC.maCongDoan IS NULL and ngayPhanCong ='" + sqlDate + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BangPhanCong bangPhanCong = new BangPhanCong();
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
				listBangPhanCong.add(bangPhanCong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBangPhanCong;
	}
}
