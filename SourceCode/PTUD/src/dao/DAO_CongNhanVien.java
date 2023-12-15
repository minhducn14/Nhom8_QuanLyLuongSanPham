package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.MyConnection;
import entity.CongNhanVien;

public class DAO_CongNhanVien {
	private static ArrayList<CongNhanVien> dsCongNhanVien = new ArrayList<CongNhanVien>();

	public ArrayList<CongNhanVien> docTuBang() {
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "select * from CongNhanVien";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maCongNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String maCanCuocCongDan = rs.getString(5);
				String soDienThoai = rs.getString(6);
				String diaChi = rs.getString(7);
				boolean trangThai = rs.getBoolean(8);
				Date ngayVaoLam = rs.getDate(9);
				CongNhanVien temp = new CongNhanVien(maCongNhanVien, hoTen, gioiTinh, ngaySinh, maCanCuocCongDan,
						soDienThoai, diaChi, trangThai, ngayVaoLam);
				dsCongNhanVien.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCongNhanVien;
	}

	public boolean isDuplicate(String hoTen, String maCanCuocCongDan, String soDienThoai) {
		Connection con = MyConnection.getInstance().getConnection();
		String sql = "SELECT COUNT(*) FROM CongNhanVien WHERE hoTen = ? OR maCanCuocCongDan = ? OR soDienThoai = ?";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, hoTen);
			pst.setString(2, maCanCuocCongDan);
			pst.setString(3, soDienThoai);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean taoCNV(CongNhanVien cnv) {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			// Xử lý lỗi kết nối
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "insert into CongNhanVien(hoTen,gioiTinh,ngaySinh,maCanCuocCongDan,soDienThoai,diaChi,trangThai,ngayVaoLam) values(?,?,?,?,?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, cnv.getHoTen());
			stm.setBoolean(2, cnv.isGioiTinh());
			stm.setDate(3, cnv.getNgaySinh());
			stm.setString(4, cnv.getMaCanCuocCongDan());
			stm.setString(5, cnv.getSoDienThoai());
			stm.setString(6, cnv.getDiaChi());
			stm.setBoolean(7, cnv.isTrangThai());
			stm.setDate(8, cnv.getNgayVaoLam());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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

	public CongNhanVien getCongNhanVienMoiTao() {
		CongNhanVien cnv = new CongNhanVien();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT TOP 1 *\r\n" + "FROM CongNhanVien\r\n" + "ORDER BY maCongNhanVien DESC;";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				cnv.setMaCongNhanVien(rs.getString(1));
				cnv.setHoTen(rs.getString(2));
				cnv.setGioiTinh(rs.getBoolean(3));
				cnv.setNgaySinh(rs.getDate(4));
				cnv.setMaCanCuocCongDan(rs.getString(5));
				cnv.setSoDienThoai(rs.getString(6));
				cnv.setDiaChi(rs.getString(7));
				cnv.setTrangThai(rs.getBoolean(8));
				cnv.setNgayVaoLam(rs.getDate(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnv;
	}

	public CongNhanVien getCongNhanVienTheoMa(String maCongNhanVien) {
		CongNhanVien cnv = new CongNhanVien();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT *\r\n" + "FROM CongNhanVien\r\n" + "Where maCongNhanVien = '" + maCongNhanVien + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				cnv.setMaCongNhanVien(rs.getString(1));
				cnv.setHoTen(rs.getString(2));
				cnv.setGioiTinh(rs.getBoolean(3));
				cnv.setNgaySinh(rs.getDate(4));
				cnv.setMaCanCuocCongDan(rs.getString(5));
				cnv.setSoDienThoai(rs.getString(6));
				cnv.setDiaChi(rs.getString(7));
				cnv.setTrangThai(rs.getBoolean(8));
				cnv.setNgayVaoLam(rs.getDate(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnv;
	}

}
