package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.MyConnection;

import Entity.PhongBan;

public class DAO_PhongBan {

		private static ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();
		
		public ArrayList<PhongBan> docTuBang(){
			try {
				Connection con = MyConnection.getInstance().getConnection();
				String sql = "SELECT maPhongBan,tenPhongBan FROM PhongBan" ;
	                   
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					String maPhongBan = rs.getString(1);
					String tenPhongBan = rs.getString(2); 
					
			        PhongBan temp = new PhongBan(maPhongBan, tenPhongBan);
					
		            
			        dsPhongBan.add(temp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dsPhongBan;		
		}
		
		
		// chỗ này chưa xong
		public boolean taoPB(PhongBan pb) {
			Connection con = MyConnection.getInstance().getConnection();
			if (con == null) {
				// Xử lý lỗi kết nối
				return false;
			}

			PreparedStatement stm = null;
			int n = 0;
			try {
				String sql ="insert into PhongBan values(?)";
				stm = con.prepareStatement(sql);
				
				stm.setString(2, pb.getTenPhongBan());
				
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
