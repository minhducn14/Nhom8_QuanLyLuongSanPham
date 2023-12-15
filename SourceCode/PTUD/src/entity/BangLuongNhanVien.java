package entity;

public class BangLuongNhanVien {
	private String maBangLuong;
	private int thang;
	private int nam;
	private float soNgayThuongDiLam;
	private int soNgayNghiKhongPhep;
	private int soNgayNghiCoPhep;
	private int soGioTangCaChuNhat;
	private int soGioTangCaNgayThuong;
	private float soNgayLamChuNhat;
	private NhanVien nhanVien;

	public int getSoGioTangCaChuNhat() {
		return soGioTangCaChuNhat;
	}

	public void setSoGioTangCaChuNhat(int soGioTangCaChuNhat) {
		this.soGioTangCaChuNhat = soGioTangCaChuNhat;
	}

	public int getSoGioTangCaNgayThuong() {
		return soGioTangCaNgayThuong;
	}

	public void setSoGioTangCaNgayThuong(int soGioTangCaNgayThuong) {
		this.soGioTangCaNgayThuong = soGioTangCaNgayThuong;
	}

	public String getMaBangLuong() {
		return maBangLuong;
	}

	public void setMaBangLuong(String maBangLuong) {
		this.maBangLuong = maBangLuong;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public int getSoNgayNghiKhongPhep() {
		return soNgayNghiKhongPhep;
	}

	public void setSoNgayNghiKhongPhep(int soNgayNghiKhongPhep) {
		this.soNgayNghiKhongPhep = soNgayNghiKhongPhep;
	}

	public int getSoNgayNghiCoPhep() {
		return soNgayNghiCoPhep;
	}

	public void setSoNgayNghiCoPhep(int soNgayNghiCoPhep) {
		this.soNgayNghiCoPhep = soNgayNghiCoPhep;
	}

	public float getSoNgayThuongDiLam() {
		return soNgayThuongDiLam;
	}

	public void setSoNgayThuongDiLam(float soNgayThuongDiLam) {
		this.soNgayThuongDiLam = soNgayThuongDiLam;
	}

	public float getSoNgayLamChuNhat() {
		return soNgayLamChuNhat;
	}

	public void setSoNgayLamChuNhat(float soNgayLamChuNhat) {
		this.soNgayLamChuNhat = soNgayLamChuNhat;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public BangLuongNhanVien() {
		super();
	}

	public BangLuongNhanVien(String maBangLuong, int thang, int nam, int soNgayThuongDiLam, int soNgayNghiKhongPhep,
			int soNgayNghiCoPhep, int soGioTangCaChuNhat, int soGioTangCaNgayThuong, int soNgayLamChuNhat,
			NhanVien nhanVien) {
		super();
		this.maBangLuong = maBangLuong;
		this.thang = thang;
		this.nam = nam;
		this.soNgayThuongDiLam = soNgayThuongDiLam;
		this.soNgayNghiKhongPhep = soNgayNghiKhongPhep;
		this.soNgayNghiCoPhep = soNgayNghiCoPhep;
		this.soGioTangCaChuNhat = soGioTangCaChuNhat;
		this.soGioTangCaNgayThuong = soGioTangCaNgayThuong;
		this.soNgayLamChuNhat = soNgayLamChuNhat;
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "BangLuongNhanVien [maBangLuong=" + maBangLuong + ", thang=" + thang + ", nam=" + nam
				+ ", soNgayThuongDiLam=" + soNgayThuongDiLam + ", soNgayNghiKhongPhep=" + soNgayNghiKhongPhep
				+ ", soNgayNghiCoPhep=" + soNgayNghiCoPhep + ", soGioTangCaChuNhat=" + soGioTangCaChuNhat
				+ ", soGioTangCaNgayThuong=" + soGioTangCaNgayThuong + ", soNgayLamChuNhat=" + soNgayLamChuNhat
				+ ", nhanVien=" + nhanVien + "]";
	}

	public double tinhLuongThucTe(double luongCoBan, double heSoLuong, double phuCapThamNien) {
		double luongThucTe = (soNgayThuongDiLam * luongCoBan * heSoLuong) / 26 + soGioTangCaNgayThuong * 25000
				+ soNgayLamChuNhat * 1.5 * (luongCoBan * heSoLuong) / 26 + soGioTangCaChuNhat * 25000 * 1.5;
		return luongThucTe;
	}

	public double tinhLuongThucLinh(double luongThucTe, double luongCoBan, double heSoLuong) {
		double luongThucLinh = luongThucTe - (luongThucTe * 0.08 + luongThucTe * 0.015 + luongThucTe * 0.01)
				+ nhanVien.getCongNhanVien().tinhPhuCapThamNienNhanVien(luongCoBan, nhanVien.tinhHeSoLuong())
				+ (soNgayLamChuNhat + soNgayThuongDiLam) * 30000;
		return luongThucLinh;
	}

}
