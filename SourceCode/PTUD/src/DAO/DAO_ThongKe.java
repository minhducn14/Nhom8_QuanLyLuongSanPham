package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import Connection.MyConnection;

public class DAO_ThongKe {
	public static ResultSet getTopLuongNhanVien(int thang, int nam) {
		String query = "SELECT Top 5\r\n" + "    cnv.hoTen,\r\n"
				+ "    dbo.tinhPhuCapThamNienTLD(cnv.ngayVaoLam, dbo.tinhHeSoLuongTLD(tho.tayNghe)) AS phuCapThamNien,\r\n"
				+ "    SUM(cd.giaCongDoan * bcc.soLuongSanPham) AS luongThucTe,\r\n"
				+ "    SUM(cd.giaCongDoan * bcc.soLuongSanPham) + dbo.tinhPhuCapThamNienTLD(cnv.ngayVaoLam, dbo.tinhHeSoLuongTLD(tho.tayNghe)) + 900000- (3000000 * 0.08 + 3000000 * 0.015 + 3000000 * 0.01) AS Tong\r\n"
				+ "FROM \r\n" + "    BangChamCongThoLamDan bcc \r\n" + "JOIN \r\n"
				+ "    CongDoan cd ON bcc.maCongDoan = cd.maCongDoan\r\n" + "JOIN \r\n"
				+ "    ThoLamDan tho ON bcc.maThoLamDan = tho.maThoLamDan\r\n" + "JOIN \r\n"
				+ "    CongNhanVien cnv ON cnv.maCongNhanVien = tho.maCongNhanVien\r\n"
				+ "where MONTH(bcc.ngayChamCong) = '" + thang + "'\r\n" + "and  YEAR(bcc.ngayChamCong)= '" + nam
				+ "'\r\n" + "GROUP BY \r\n" + "    cnv.hoTen, cnv.ngayVaoLam, tho.tayNghe\r\n" + "ORDER BY \r\n"
				+ "    luongThucTe DESC;";
		Connection con = MyConnection.getInstance().getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public DefaultTableModel getSPTheoTopLuongNhanVien(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Họ tên");
		model.addColumn("Tổng SP");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "SELECT Top 5\r\n" + "    cnv.hoTen,\r\n"
					+ "    dbo.tinhPhuCapThamNienTLD(cnv.ngayVaoLam, dbo.tinhHeSoLuongTLD(tho.tayNghe)) AS phuCapThamNien,\r\n"
					+ "    SUM(cd.giaCongDoan * bcc.soLuongSanPham) AS luongThucTe,\r\n"
					+ "    SUM(bcc.soLuongSanPham) AS tongSoSP,\r\n"
					+ "    SUM(cd.giaCongDoan * bcc.soLuongSanPham) + dbo.tinhPhuCapThamNienTLD(cnv.ngayVaoLam, dbo.tinhHeSoLuongTLD(tho.tayNghe)) + 900000- (3000000 * 0.08 + 3000000 * 0.015 + 3000000 * 0.01) AS Tong\r\n"
					+ "FROM \r\n" + "    BangChamCongThoLamDan bcc \r\n" + "JOIN \r\n"
					+ "    CongDoan cd ON bcc.maCongDoan = cd.maCongDoan\r\n" + "JOIN \r\n"
					+ "    ThoLamDan tho ON bcc.maThoLamDan = tho.maThoLamDan\r\n" + "JOIN \r\n"
					+ "    CongNhanVien cnv ON cnv.maCongNhanVien = tho.maCongNhanVien\r\n"
					+ "where MONTH(bcc.ngayChamCong) = '" + thang + "'\r\n" + "and  YEAR(bcc.ngayChamCong)= '" + nam
					+ "'\r\n" + "GROUP BY \r\n" + "    cnv.hoTen, cnv.ngayVaoLam, tho.tayNghe\r\n" + "ORDER BY \r\n"
					+ "    luongThucTe DESC;";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String employeeName = resultSet.getString("hoTen");
						int totalProducts = resultSet.getInt("tongSoSP");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(employeeName);
						row.add(totalProducts);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	// ==============================
	public DefaultTableModel allMax(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, (nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\nfrom NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		on pb.maPhongBan=nv.maPhongBan\r\nwhere thang="
					+ thang + " and nam=" + nam + "\r\n order by tongLuong desc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel allMin(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, (nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\nfrom NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		on pb.maPhongBan=nv.maPhongBan\r\nwhere thang="
					+ thang + " and nam=" + nam + "\r\n order by tongLuong asc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel phongKinhDoanhMax(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, (nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\nfrom NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		on pb.maPhongBan=nv.maPhongBan\r\nwhere thang="
					+ thang + " and nam=" + nam + " and pb.tenPhongBan='Kinh Doanh'\r\n order by tongLuong desc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel phongKinhDoanhMin(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, (nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\nfrom NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		on pb.maPhongBan=nv.maPhongBan\r\nwhere thang="
					+ thang + " and nam=" + nam + " and pb.tenPhongBan='Kinh Doanh'\r\n order by tongLuong asc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel phongMarketingMax(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, (nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\nfrom NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		on pb.maPhongBan=nv.maPhongBan\r\nwhere thang="
					+ thang + " and nam=" + nam + " and pb.tenPhongBan='Marketing'\r\n order by tongLuong desc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel phongMarketingMin(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, (nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\nfrom NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		on pb.maPhongBan=nv.maPhongBan\r\nwhere thang="
					+ thang + " and nam=" + nam + " and pb.tenPhongBan='Marketing'\r\n order by tongLuong asc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel phongNhanSuMax(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, "
					+ "(nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\n"
					+ "from NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		"
					+ "join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		"
					+ "on pb.maPhongBan=nv.maPhongBan\r\nwhere thang=" + thang + " and nam=" + nam
					+ " and pb.tenPhongBan=N'Nhân Sự'\r\n " + "order by tongLuong desc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel phongNhanSuMin(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, "
					+ "(nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\n"
					+ "from NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		"
					+ "join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		"
					+ "on pb.maPhongBan=nv.maPhongBan\r\nwhere thang=" + thang + " and nam=" + nam
					+ " and pb.tenPhongBan=N'Nhân Sự'\r\n " + "order by tongLuong asc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel phongPhatTrienSanPhamMax(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, "
					+ "(nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\n"
					+ "from NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		"
					+ "join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		"
					+ "on pb.maPhongBan=nv.maPhongBan\r\nwhere thang=" + thang + " and nam=" + nam
					+ " and pb.tenPhongBan=N'Phát Triển Sản Phẩm'\r\n " + "order by tongLuong desc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel phongPhatTrienSanPhamMin(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, "
					+ "(nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\n"
					+ "from NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		"
					+ "join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		"
					+ "on pb.maPhongBan=nv.maPhongBan\r\nwhere thang=" + thang + " and nam=" + nam
					+ " and pb.tenPhongBan=N'Phát Triển Sản Phẩm'\r\n " + "order by tongLuong asc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel phongDieuPhoiMax(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, "
					+ "(nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\n"
					+ "from NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		"
					+ "join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		"
					+ "on pb.maPhongBan=nv.maPhongBan\r\nwhere thang=" + thang + " and nam=" + nam
					+ " and pb.tenPhongBan=N'Điều Phối'\r\n " + "order by tongLuong desc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}

	public DefaultTableModel phongDieuPhoiMin(int thang, int nam) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã số");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Phòng Ban");
		model.addColumn("Mã CCCD");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Tổng lương");
		Connection connection = MyConnection.getInstance().getConnection();
		try {
			String sql = "select top 5 nv.maNhanVien, cnv.hoTen, cnv.gioiTinh, pb.tenPhongBan,cnv.maCanCuocCongDan, cnv.soDienThoai, "
					+ "(nv.luongCoBan+(blnv.soNgayLamChuNhat + blnv.soNgayThuongDiLam)*30000+blnv.soGioTangCaChuNhat*1.5*25000+blnv.soGioTangCaNgayThuong*25000) as tongLuong\r\n"
					+ "from NhanVien nv join CongNhanVien cnv \r\n		on cnv.maCongNhanVien=nv.maCongNhanVien\r\n		"
					+ "join BangLuongNhanVien blnv\r\n		on blnv.maNhanVien=nv.maNhanVien\r\n		join PhongBan pb\r\n		"
					+ "on pb.maPhongBan=nv.maPhongBan\r\nwhere thang=" + thang + " and nam=" + nam
					+ " and pb.tenPhongBan=N'Điều Phối'\r\n " + "order by tongLuong asc";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String manv = resultSet.getString("maNhanVien");
						String name = resultSet.getString("hoTen");
						boolean gender = resultSet.getBoolean("gioiTinh");
						String gioiTinh = gender ? "Nam" : "Nữ";

						String phongBan = resultSet.getString("tenPhongBan");
						String cccd = resultSet.getString("maCanCuocCongDan");
						String sdt = resultSet.getString("soDienThoai");
						double tongLuong = resultSet.getDouble("tongLuong");
						java.util.Vector<Object> row = new Vector<Object>();
						row.add(manv);
						row.add(name);
						row.add(gioiTinh);
						row.add(phongBan);
						row.add(cccd);
						row.add(sdt);
						row.add(tongLuong);
						model.addRow(row);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception according to your needs
		}
		return model;
	}
}