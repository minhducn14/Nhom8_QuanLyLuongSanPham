package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Connection.MyConnection;
import Entity.CongNhanVien;
import Entity.NhanVien;
import Entity.PhongBan;

public class DAO_NhanVien {

	public ArrayList<NhanVien> docTuBang() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT *\r\n" + "FROM NhanVien\r\n"
					+ "INNER JOIN CongNhanVien ON CongNhanVien.maCongNhanVien = NhanVien.maCongNhanVien\r\n";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(rs.getString(1));
				nhanVien.setChucVu(rs.getString(2));
				nhanVien.setTrinhDoVanHoa(rs.getString(3));
				nhanVien.setLuongCoBan(rs.getFloat(4));
				DAO_PhongBan dao_PB = new DAO_PhongBan();
				PhongBan phongBan = dao_PB.getPhongBanTheoMa(rs.getString(5));
				nhanVien.setPhongBan(phongBan);
				DAO_CongNhanVien dao_CNV = new DAO_CongNhanVien();
				CongNhanVien congNhanVien = dao_CNV.getCongNhanVienTheoMa(rs.getString(6));
				nhanVien.setCongNhanVien(congNhanVien);
				dsNhanVien.add(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	public boolean taoNV(NhanVien nv) {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "insert into NhanVien(chucVu,trinhDoVanHoa,luongCoBan,maPhongBan,maCongNhanVien) values(?,?,?,?,?)";
			stm = con.prepareStatement(sql);

			stm.setString(1, nv.getChucVu());
			stm.setString(2, nv.getTrinhDoVanHoa());
			stm.setDouble(3, nv.getLuongCoBan());
			stm.setString(4, nv.getPhongBan().getMaPhongBan());
			stm.setString(5, nv.getCongNhanVien().getMaCongNhanVien());

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

	public String getMaNhanVienMoiTao() {
		String maNhanVien = null;
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT TOP 1 maNhanVien\r\n" + "FROM NhanVien\r\n" + "ORDER BY maNhanVien DESC;";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				maNhanVien = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maNhanVien;
	}

	public ArrayList<NhanVien> getAllListNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT *\r\n" + "FROM NhanVien\r\n"
					+ "INNER JOIN CongNhanVien ON CongNhanVien.maCongNhanVien = NhanVien.maCongNhanVien\r\n"
					+ "WHERE CongNhanVien.trangThai = 1;";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(resultSet.getString(1));
				nhanVien.setChucVu(resultSet.getString(2));
				nhanVien.setTrinhDoVanHoa(resultSet.getString(3));
				nhanVien.setLuongCoBan(resultSet.getFloat(4));
				DAO_PhongBan dao_PB = new DAO_PhongBan();
				PhongBan phongBan = dao_PB.getPhongBanTheoMa(resultSet.getString(5));
				nhanVien.setPhongBan(phongBan);
				DAO_CongNhanVien dao_CNV = new DAO_CongNhanVien();
				CongNhanVien congNhanVien = dao_CNV.getCongNhanVienTheoMa(resultSet.getString(6));
				nhanVien.setCongNhanVien(congNhanVien);
				dsNhanVien.add(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	public NhanVien getNhanVienTheoMa(String maNhanVien) {
		NhanVien nhanVien = new NhanVien();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT *\r\n" + "FROM NhanVien\r\n"
					+ "INNER JOIN CongNhanVien ON CongNhanVien.maCongNhanVien = NhanVien.maCongNhanVien\r\n"
					+ "WHERE maNhanVien = '" + maNhanVien + "'";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				nhanVien.setMaNhanVien(resultSet.getString(1));
				nhanVien.setChucVu(resultSet.getString(2));
				nhanVien.setTrinhDoVanHoa(resultSet.getString(3));
				nhanVien.setLuongCoBan(resultSet.getFloat(4));

				DAO_PhongBan dao_PB = new DAO_PhongBan();
				PhongBan phongBan = dao_PB.getPhongBanTheoMa(resultSet.getString(5));
				nhanVien.setPhongBan(phongBan);
				DAO_CongNhanVien dao_CNV = new DAO_CongNhanVien();
				CongNhanVien congNhanVien = dao_CNV.getCongNhanVienTheoMa(resultSet.getString(6));
				nhanVien.setCongNhanVien(congNhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	public ArrayList<NhanVien> getAllNhanVienTheoTen(String ten) {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT *\r\n" + "FROM NhanVien\r\n"
					+ "INNER JOIN CongNhanVien ON CongNhanVien.maCongNhanVien = NhanVien.maCongNhanVien\r\n"
					+ "WHERE CongNhanVien.trangThai = 1 and CongNhanVien.hoTen LIKE N'%" + ten + "%'";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(resultSet.getString(1));
				nhanVien.setChucVu(resultSet.getString(2));
				nhanVien.setTrinhDoVanHoa(resultSet.getString(3));
				nhanVien.setLuongCoBan(resultSet.getFloat(4));
				DAO_PhongBan dao_PB = new DAO_PhongBan();
				PhongBan phongBan = dao_PB.getPhongBanTheoMa(resultSet.getString(5));
				nhanVien.setPhongBan(phongBan);
				DAO_CongNhanVien dao_CNV = new DAO_CongNhanVien();
				CongNhanVien congNhanVien = dao_CNV.getCongNhanVienTheoMa(resultSet.getString(6));
				nhanVien.setCongNhanVien(congNhanVien);
				dsNhanVien.add(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	public ArrayList<NhanVien> getAllNhanVienTheoPhongBan(String maPhongBan) {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT *\r\n" + "FROM NhanVien\r\n"
					+ "INNER JOIN CongNhanVien ON CongNhanVien.maCongNhanVien = NhanVien.maCongNhanVien\r\n"
					+ "WHERE CongNhanVien.trangThai = 1 and maPhongBan = '" + maPhongBan + "'";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(resultSet.getString(1));
				nhanVien.setChucVu(resultSet.getString(2));
				nhanVien.setTrinhDoVanHoa(resultSet.getString(3));
				nhanVien.setLuongCoBan(resultSet.getFloat(4));
				DAO_PhongBan dao_PB = new DAO_PhongBan();
				PhongBan phongBan = dao_PB.getPhongBanTheoMa(resultSet.getString(5));
				nhanVien.setPhongBan(phongBan);
				DAO_CongNhanVien dao_CNV = new DAO_CongNhanVien();
				CongNhanVien congNhanVien = dao_CNV.getCongNhanVienTheoMa(resultSet.getString(6));
				nhanVien.setCongNhanVien(congNhanVien);
				dsNhanVien.add(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}
}
