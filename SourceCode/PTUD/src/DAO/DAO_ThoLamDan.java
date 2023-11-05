package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import GUI.QuanLyThoLamDan;
import Connection.MyConnection;
import Entity.CongNhanVien;
import Entity.ThoLamDan;

public class DAO_ThoLamDan {
	private static ArrayList<ThoLamDan> dsThoLamDan = new ArrayList<>();
	public ArrayList<ThoLamDan> docTuBang(){
		try {
			Connection conn = MyConnection.getInstance().getConnection();
			String sql = "SELECT maThoLamDan, tayNghe, maCongNhanVien" + "FROM CongNhanVien";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maThoLamDan = rs.getString(1);
				String tayNghe = rs.getString(2);
				String maCongNhanVien = rs.getString(3);
				CongNhanVien cnv = new CongNhanVien(maCongNhanVien);
				ThoLamDan temp = new ThoLamDan(maThoLamDan, tayNghe, cnv);
				
				dsThoLamDan.add(temp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsThoLamDan;
	}
	
	public boolean taoTLD(ThoLamDan tld) {
		Connection conn = MyConnection.getInstance().getConnection();
		if (conn == null) {
			// Xử lý lỗi kết nối
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql ="insert into ThoLamDan(tayNghe, maCongNhanVien) values(?,?)";
			stm = conn.prepareStatement(sql);
			
			stm.setString(2, tld.getTayNghe());
			stm.setString(3, tld.getCongNhanVien().getMaCongNhanVien());
	
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
