package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import GUI.QuanLyNhanVien;
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
			String sql = "SELECT maNhanVien, chucVu, trinhDoVanHoa, luongCoban, maPhongBan, maCongNhanVien " +
                    "FROM NhanVien" ;
                   
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNhanVien = rs.getString(1);
				String chucVu = rs.getString(2); 
				String trinhDoVanHoa =  rs.getString(3); 
		        double luongCoban = rs.getDouble(4);    
		        String maPhongBan = rs.getString(5); 
		        PhongBan pb = new PhongBan(maPhongBan);
		        String maCongNhanVien = rs.getString(6); 
		        CongNhanVien cnv = new CongNhanVien(maCongNhanVien);
		        NhanVien temp = new NhanVien(maNhanVien, chucVu, trinhDoVanHoa, luongCoban, pb, cnv);
				
	            
	            dsNhanVien.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;		
	}
	
	public boolean taoNV(NhanVien nv) {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			// Xử lý lỗi kết nối
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql ="insert into NhanVien values(chucVu,trinhDoVanHoa,luongCoBan,maPhongBan,maCongNhanVien)";
			stm = con.prepareStatement(sql);
			
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
