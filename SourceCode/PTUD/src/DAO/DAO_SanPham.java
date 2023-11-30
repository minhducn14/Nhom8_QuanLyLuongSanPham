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
	public String getMaSanPhamMoiTao() {
		String maSanPham = null;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT TOP 1 maSanPham\r\n" + "FROM Dan\r\n" + "ORDER BY maSanPham DESC;";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				maSanPham = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maSanPham;
	}
	public boolean update(Dan dan) {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "update Dan set tenSanPham=?, loaiSanPham=?, moTa=?, giaBan=?, matDan=?, eoLung=?, can=?, matPhim=?, day=?, khoa=?, cauNgua=?, trangThai=? where maSanPham=? ";
				
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
			stm.setString(13, dan.getMaSanPham());
			

			
			
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
