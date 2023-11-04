package Entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class CongNhanVien {
	private String maCongNhanVien;
	private String hoTen;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String maCanCuocCongDan;
	private String soDienThoai;
	private String diaChi;
	private boolean trangThai;
	private Date ngayVaoLam;

	public String getMaCongNhanVien() {
		return maCongNhanVien;
	}

	public void setMaCongNhanVien(String maCongNhanVien) {
		this.maCongNhanVien = maCongNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getMaCanCuocCongDan() {
		return maCanCuocCongDan;
	}

	public void setMaCanCuocCongDan(String maCanCuocCongDan) {
		this.maCanCuocCongDan = maCanCuocCongDan;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public CongNhanVien(String maCongNhanVien, String hoTen, boolean gioiTinh, Date ngaySinh, String maCanCuocCongDan,
			String soDienThoai, String diaChi, boolean trangThai, Date ngayVaoLam) {
		super();
		this.maCongNhanVien = maCongNhanVien;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.maCanCuocCongDan = maCanCuocCongDan;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.ngayVaoLam = ngayVaoLam;
	}

	public CongNhanVien(String hoTen, boolean gioiTinh, Date ngaySinh, String maCanCuocCongDan, String soDienThoai) {
		super();
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.maCanCuocCongDan = maCanCuocCongDan;
		this.soDienThoai = soDienThoai;
	}

	public CongNhanVien(String maCongNhanVien) {
		super();
		this.maCongNhanVien = maCongNhanVien;
	}
	
	public CongNhanVien( String hoTen, boolean gioiTinh, Date ngaySinh, String maCanCuocCongDan,
			String soDienThoai, String diaChi, boolean trangThai, Date ngayVaoLam) {
		// TODO Auto-generated constructor stub
		super();
		
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.maCanCuocCongDan = maCanCuocCongDan;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.ngayVaoLam = ngayVaoLam;
	}

	@Override
	public String toString() {
		return "CongNhanVien [maCongNhanVien=" + maCongNhanVien + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + ", maCanCuocCongDan=" + maCanCuocCongDan + ", soDienThoai=" + soDienThoai
				+ ", diaChi=" + diaChi + ", trangThai=" + trangThai + ", ngayVaoLam=" + ngayVaoLam + "]";
	}

	public double tinhPhuCapThamNien(Date ngayVaoLam, double luongCoBan, double heSoLuong) {
        int soNamLamViec = tinhSoNamLamViec(ngayVaoLam);
        double tyLePhuCap = xacDinhTyLePhuCap(soNamLamViec);
        double phuCapThamNien = luongCoBan * heSoLuong * (tyLePhuCap / 100);
        return phuCapThamNien;
    }

    private int tinhSoNamLamViec(Date ngayVaoLam) {
        LocalDate ngayVaoLamLocal = ngayVaoLam.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ngayHienTai = LocalDate.now();
        Period khoangThoiGian = Period.between(ngayVaoLamLocal, ngayHienTai);
        int soNamLamViec = khoangThoiGian.getYears();
        return soNamLamViec;
    }

    private double xacDinhTyLePhuCap(int soNamLamViec) {
        if (soNamLamViec >= 5 && soNamLamViec < 10) {
            return 5.0;
        } else if (soNamLamViec >= 10 && soNamLamViec < 15) {
            return 10.0;
        } else if (soNamLamViec >= 15 && soNamLamViec < 20) {
            return 15.0;
        } else if (soNamLamViec >= 20) {
            return 20.0;
        } else {
            return 0.0;
        }
    }

}
