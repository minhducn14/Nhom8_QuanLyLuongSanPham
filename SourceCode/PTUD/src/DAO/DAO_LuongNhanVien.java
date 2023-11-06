package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.MyConnection;
import Entity.BangLuongNhanVien;
import Entity.CongNhanVien;
import Entity.NhanVien;
import Entity.PhongBan;

public class DAO_LuongNhanVien {
	public boolean themBangLuongNhanVien(BangLuongNhanVien bangLuong) {
		Connection conn = MyConnection.getInstance().getConnection();
		if (conn == null) {
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "INSERT INTO [dbo].[BangLuongNhanVien]\r\n" + "([maBangLuong]\r\n" + ",[thang]\r\n"
					+ ",[nam]\r\n" + ",[maNhanVien]\r\n" + ",[soNgayThuongDiLam]\r\n" + ",[soGioTangCaNgayThuong]\r\n"
					+ ",[soNgayLamChuNhat]\r\n" + ",[soGioTangCaChuNhat]\r\n" + ",[soNgayNghiKhongPhep]\r\n"
					+ ",[soNgayNghiCoPhep])\r\n" + "VALUES(dbo.GenerateMaBangLuongNV(?, ?, ?),?,?,?,?,?,?,?,?,?)";
			stm = conn.prepareStatement(sql);
			stm.setInt(1, bangLuong.getThang());
			stm.setInt(2, bangLuong.getNam());
			stm.setString(3, bangLuong.getNhanVien().getMaNhanVien());
			stm.setInt(4, bangLuong.getThang());
			stm.setInt(5, bangLuong.getNam());
			stm.setString(6, bangLuong.getNhanVien().getMaNhanVien());
			stm.setFloat(7, bangLuong.getSoNgayThuongDiLam());
			stm.setInt(8, bangLuong.getSoGioTangCaNgayThuong());
			stm.setFloat(9, bangLuong.getSoNgayLamChuNhat());
			stm.setInt(10, bangLuong.getSoGioTangCaChuNhat());
			stm.setInt(11, bangLuong.getSoNgayNghiKhongPhep());
			stm.setInt(12, bangLuong.getSoNgayNghiCoPhep());
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

	public int laySoNgayDiLamNguyenCaNgayThuong(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7;\r\n" + "SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNguyenCa\r\n"
					+ "FROM BangChamCongNhanVien\r\n" + "WHERE maNhanVien = '" + maNhanVien + "'\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) <> 1 \r\n"
					+ "  AND trangThaiDiLam = N'Làm nguyên ca';\r\n";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = Integer.parseInt(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	public int laySoNgayDiLamNuaCaNgayThuong(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7;\r\n" + "SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNuaCa\r\n"
					+ "FROM BangChamCongNhanVien\r\n" + "WHERE maNhanVien = '" + maNhanVien + "'\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) <> 1 \r\n" + "  AND trangThaiDiLam = N'Làm nửa ca';\r\n";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	public int laySoGioTangCaNgayThuong(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7;\r\n" + "SELECT SUM(soGioTangCa) AS TongSoGioTangCa\r\n"
					+ "FROM BangChamCongNhanVien\r\n" + "WHERE maNhanVien = '" + maNhanVien + "'\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) <> 1 \r\n";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	public int laySoNgayDiLamNguyenCaCN(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7;\r\n" + "SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNguyenCa\r\n"
					+ "FROM BangChamCongNhanVien\r\n" + "WHERE maNhanVien = '" + maNhanVien + "'\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) = 1 \r\n" + "  AND trangThaiDiLam = N'Làm nguyên ca';\r\n";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	public int laySoNgayDiLamNuaCaCN(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7;\r\n" + "SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNuaCa\r\n"
					+ "FROM BangChamCongNhanVien\r\n" + "WHERE maNhanVien = '" + maNhanVien + "'\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) = 1 \r\n" + "  AND trangThaiDiLam = N'Làm nửa ca';\r\n";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	public int laySoGioTangCaCN(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SET DATEFIRST 7;\r\n" + "SELECT SUM(soGioTangCa) AS TongSoGioTangCa\r\n"
					+ "FROM BangChamCongNhanVien\r\n" + "WHERE maNhanVien = '" + maNhanVien + "'\r\n"
					+ "  AND MONTH(ngayChamCong) = " + thang + "\r\n" + "  AND YEAR(ngayChamCong) = " + nam + "\r\n"
					+ "  AND DATEPART(weekday, ngayChamCong) = 1 \r\n";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	public int laySoNgayNghiCoPhep(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNuaCa\r\n" + "FROM BangChamCongNhanVien\r\n"
					+ "WHERE maNhanVien = '" + maNhanVien + "'\r\n" + "  AND MONTH(ngayChamCong) = " + thang + "\r\n"
					+ "  AND YEAR(ngayChamCong) = " + nam + "\r\n" + "  AND trangThaiDiLam = N'Nghỉ phép';\r\n";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	public int laySoNgayNghiKhongPhep(String maNhanVien, int thang, int nam) {
		int soNgay = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(DISTINCT ngayChamCong) AS SoNgayLamNuaCa\r\n" + "FROM BangChamCongNhanVien\r\n"
					+ "WHERE maNhanVien = '" + maNhanVien + "'\r\n" + "  AND MONTH(ngayChamCong) = " + thang + "\r\n"
					+ "  AND YEAR(ngayChamCong) = " + nam + "\r\n" + "  AND trangThaiDiLam = N'Nghỉ không phép';\r\n";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				soNgay = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soNgay;
	}

	public String getMaBangLuong(int thang, int nam, String maNhanVien) {
		String maBangLuongResult = null;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "{? = call dbo.GenerateMaBangLuongNV(?, ?, ?)}";
			CallableStatement statement = con.prepareCall(sql);

			statement.registerOutParameter(1, java.sql.Types.VARCHAR);
			statement.setInt(2, thang);
			statement.setInt(3, nam);
			statement.setString(4, maNhanVien);

			statement.execute();

			maBangLuongResult = statement.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maBangLuongResult;
	}

	public boolean kiemTraTrungMa(int thang, int nam, String maNhanVien) {
		boolean ketQua = true;
		DAO_LuongNhanVien dao_LuongNhanVien = new DAO_LuongNhanVien();
		String maBangLuong = dao_LuongNhanVien.getMaBangLuong(thang, nam, maNhanVien);
		int tong = 0;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT COUNT(*) AS TotalCount\r\n" + "FROM BangLuongNhanVien\r\n" + "WHERE maBangLuong = '"
					+ maBangLuong + "';";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				tong = rs.getInt("TotalCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (tong == 0) {
			ketQua = false;
		}
		return ketQua;
	}
	
//	public BangLuongNhanVien getMaBangLuongTheoMa(String maBangLuong) {
//		BangLuongNhanVien bangLuongNhanVien = new BangLuongNhanVien();
//		try {
//			Connection con = MyConnection.getInstance().getConnection();
//			String sql = "SELECT *  FROM BangLuongNhanVien where maBangLuong = '" + maBangLuong + "'";
//			Statement statement = con.createStatement();
//			ResultSet resultSet = statement.executeQuery(sql);
//			while (resultSet.next()) {
//				nhanVien.setMaNhanVien(resultSet.getString(1));
//				nhanVien.setChucVu(resultSet.getString(2));
//				nhanVien.setTrinhDoVanHoa(resultSet.getString(3));
//				nhanVien.setLuongCoBan(resultSet.getFloat(4));
//
//				DAO_PhongBan dao_PB = new DAO_PhongBan();
//				PhongBan phongBan = dao_PB.getPhongBanTheoMa(resultSet.getString(5));
//				nhanVien.setPhongBan(phongBan);
//				DAO_CongNhanVien dao_CNV = new DAO_CongNhanVien();
//				CongNhanVien congNhanVien = dao_CNV.getCongNhanVienTheoMa(resultSet.getString(6));
//				nhanVien.setCongNhanVien(congNhanVien);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return nhanVien;
//	}

}
