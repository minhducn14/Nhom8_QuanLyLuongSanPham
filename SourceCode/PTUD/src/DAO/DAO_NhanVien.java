package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.MyConnection;
import Entity.CongNhanVien;
import Entity.NhanVien;
import Entity.PhongBan;

//private String maNhanVien;
//private String chucVu;
//private String trinhDoVanHoa;
//private double luongCoBan;
//private PhongBan phongBan;
//private CongNhanVien congNhanVien;


public class DAO_NhanVien {
	private static ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
	
	public ArrayList<NhanVien> docTuBang(){
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "SELECT nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, cnv.ngaySinh, cnv.maCanCuocCongDan, cnv.soDienThoai " +
                    "FROM NhanVien nv " +
                    "INNER JOIN CongNhanVien cnv ON nv.congNhanVien = cnv.maCongNhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNhanVien = rs.getString(1);
				String hoTen = rs.getString("hoTen"); 
				boolean gioiTinh = rs.getBoolean("gioiTinh") ? "Nam" != null : "Nữ" != null; 
		        Date ngaySinh = rs.getDate("ngaySinh"); 
		        String maCanCuocCongDan = rs.getString("maCanCuocCongDan");
		        String soDienThoai = rs.getString("soDienThoai");  
		
		        NhanVien nhanVien = new NhanVien();
	            nhanVien.setMaNhanVien(maNhanVien);
	            nhanVien.getCongNhanVien().setHoTen(hoTen);
	            nhanVien.getCongNhanVien().setGioiTinh(gioiTinh);
	            nhanVien.getCongNhanVien().setNgaySinh(ngaySinh);
	            nhanVien.getCongNhanVien().setMaCanCuocCongDan(maCanCuocCongDan);
	            nhanVien.getCongNhanVien().setSoDienThoai(soDienThoai);

	            dsNhanVien.add(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;		
	}
	
	
	// chỗ này chưa xong
	public boolean tao(NhanVien nv) {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			// Xử lý lỗi kết nối
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "insert into NhanVien values(?,?,?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, nv.getMaNhanVien());
			stm.setString(2, nv.getChucVu());
			stm.setString(3, nv.getTrinhDoVanHoa());
			stm.setDouble(4, nv.getLuongCoBan());
			stm.setString(5, nv.getPhongBan().getMaPhongBan());
			stm.setString(6, nv.getCongNhanVien().getMaCongNhanVien());
	
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
