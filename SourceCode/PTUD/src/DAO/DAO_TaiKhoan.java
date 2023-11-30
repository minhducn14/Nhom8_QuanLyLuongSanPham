package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.MyConnection;
import Entity.NhanVien;
import Entity.TaiKhoan;

public class DAO_TaiKhoan {
	public boolean themTaiKhoan(TaiKhoan taiKhoan) throws SQLException {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			return false;
		}
		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "INSERT INTO [dbo].[TaiKhoan] ([taiKhoan], [matKhau], [maNhanVien]) VALUES (?, ?, ?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, taiKhoan.getTaiKhoan());
			stm.setString(2, taiKhoan.getMatKhau());
			stm.setString(3, taiKhoan.getNhanVien().getMaNhanVien());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return n > 0;

	}

	public ArrayList<TaiKhoan> getDanhSachTaiKhoan() {
		ArrayList<TaiKhoan> lstTK = new ArrayList<TaiKhoan>();
		Connection con = MyConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from TaiKhoan");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan();
				tk.setTaiKhoan(rs.getString(1));
				tk.setMatKhau(rs.getString(2));
				DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
				NhanVien nv = dao_NhanVien.getNhanVienTheoMa(rs.getString(3));
				tk.setNhanVien(nv);
				lstTK.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstTK;
	}

	public TaiKhoan getTaiKhoanTheoMaTaiKhoan(String maTK) {
		TaiKhoan tk = new TaiKhoan();
		Connection con = MyConnection.getInstance().getConnection();

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from TaiKhoan where taiKhoan = '" + maTK + "'");
			while (rs.next()) {
				tk.setTaiKhoan(rs.getString(1));
				tk.setMatKhau(rs.getString(2));
				DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
				NhanVien nv = dao_NhanVien.getNhanVienTheoMa(rs.getString(3));
				tk.setNhanVien(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tk;

	}

	public TaiKhoan getMatKhauTheoMaNhanVien(String ma) {
		TaiKhoan tk = new TaiKhoan();
		Connection con = MyConnection.getInstance().getConnection();
		String sql = "select * from TaiKhoan where maTK = '" + ma + "'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk.setTaiKhoan(rs.getString(1));
				tk.setMatKhau(rs.getString(2));
				DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
				NhanVien nv = dao_NhanVien.getNhanVienTheoMa(rs.getString(3));
				tk.setNhanVien(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
}
