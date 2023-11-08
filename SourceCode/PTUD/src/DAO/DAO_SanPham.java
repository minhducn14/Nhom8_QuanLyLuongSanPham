package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.MyConnection;
import Entity.Dan;

public class DAO_SanPham {
	public ArrayList<Dan> docTuBang() {
		ArrayList<Dan> dsDan = new ArrayList<Dan>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT * FROM Dan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Dan dan = new Dan();
				dan.setMaSanPham(rs.getString(0));
				dan.setTenSanPham(rs.getString(1));
				dan.setLoaiSanPham(rs.getString(2));
				dan.setMoTa(rs.getString(3));
				dan.setGiaBan(rs.getDouble(4));
				dan.setMatDan(rs.getString(5));
				dan.setEoLung(rs.getString(6));
				dan.setCan(rs.getString(7));
				dan.setMatPhim(rs.getString(8));
				dan.setDay(rs.getString(9));
				dan.setKhoa(rs.getString(10));
				dan.setCauNgua(rs.getString(11));
				dan.setTrangThai(rs.getBoolean(12));
				dsDan.add(dan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDan;
	}

	public boolean taoSP(Dan dan) {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "insert into Dan(tenSanPham,loaiSanPham,moTa,giaBan,matDan,eoLung,can,matPhim,day,khoa,cauNgua,trangThai) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			stm = con.prepareStatement(sql);

			stm.setString(1, dan.getTenSanPham());
			stm.setString(2, dan.getLoaiSanPham());
			stm.setString(3, dan.getMoTa());
			stm.setDouble(4, dan.getGiaBan());
			stm.setString(5, dan.getMatDan());
			stm.setString(6, dan.getEoLung());
			stm.setString(7, dan.getCan());
			stm.setString(8, dan.getMatPhim());
			stm.setString(9, dan.getDay());
			stm.setString(10, dan.getKhoa());
			stm.setString(11, dan.getCauNgua());
			stm.setBoolean(12, dan.isTrangThai());

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

}
