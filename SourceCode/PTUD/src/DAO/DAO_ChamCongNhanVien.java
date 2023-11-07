package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.MyConnection;
import Entity.BangChamCongNhanVien;

public class DAO_ChamCongNhanVien {
	public boolean themBangChamCong(BangChamCongNhanVien bangChamCong) throws SQLException {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			return false;
		}
		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "INSERT INTO [dbo].[BangChamCongNhanVien] "
					+ "([maBCCNhanVien], [maNhanVien], [ngayChamCong], [trangThaiDiLam], [soGioTangCa], [maBangLuong]) "
					+ "VALUES ([dbo].[generate_IDBCCNV](?, ?),?, ?, ?, ?, ?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, bangChamCong.getNhanVien().getMaNhanVien());
			stm.setDate(2, bangChamCong.getNgayChamCong());
			stm.setString(3, bangChamCong.getNhanVien().getMaNhanVien());
			stm.setDate(4, bangChamCong.getNgayChamCong());
			stm.setString(5, bangChamCong.getTrangThaiDiLam());
			stm.setInt(6, bangChamCong.getSoGioTangCa());
			stm.setString(7, bangChamCong.getBangLuong().getMaBangLuong());
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

	public boolean KiemTraTrung(BangChamCongNhanVien bangChamCong) throws SQLException {
		int n = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(*) AS so_luong_trung\r\n" + "FROM BangChamCongNhanVien\r\n"
					+ "GROUP BY maNhanVien, ngayChamCong\r\n" + "having maNhanVien= '"
					+ bangChamCong.getNhanVien().getMaNhanVien() + "' and ngayChamCong = '"
					+ bangChamCong.getNgayChamCong() + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (n == 1) {
			return false;
		} else {
			return true;
		}
	}
	
	
}
