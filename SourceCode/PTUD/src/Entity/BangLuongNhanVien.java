package Entity;

public class BangLuongNhanVien {
	private String maBangLuong;
	private int thang;
	private int nam;
	private int soNgayDiLam;
	private int soNgayNghiKhongPhep;
	private int soNgayNghiCoPhep;
	private int soGioTangCa;
	private int soNgayLamChuNhat;
	private NhanVien nhanVien;

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

	public int getSoNgayDiLam() {
		return soNgayDiLam;
	}

	public void setSoNgayDiLam(int soNgayDiLam) {
		this.soNgayDiLam = soNgayDiLam;
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

	public int getSoGioTangCa() {
		return soGioTangCa;
	}

	public void setSoGioTangCa(int soGioTangCa) {
		this.soGioTangCa = soGioTangCa;
	}

	public int getSoNgayLamChuNhat() {
		return soNgayLamChuNhat;
	}

	public void setSoNgayLamChuNhat(int soNgayLamChuNhat) {
		this.soNgayLamChuNhat = soNgayLamChuNhat;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public BangLuongNhanVien(String maBangLuong, int thang, int nam, int soNgayDiLam, int soNgayNghiKhongPhep,
			int soNgayNghiCoPhep, int soGioTangCa, int soNgayLamChuNhat, NhanVien nhanVien) {
		super();
		this.maBangLuong = maBangLuong;
		this.thang = thang;
		this.nam = nam;
		this.soNgayDiLam = soNgayDiLam;
		this.soNgayNghiKhongPhep = soNgayNghiKhongPhep;
		this.soNgayNghiCoPhep = soNgayNghiCoPhep;
		this.soGioTangCa = soGioTangCa;
		this.soNgayLamChuNhat = soNgayLamChuNhat;
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "LuongNhanVien [maBangLuong=" + maBangLuong + ", thang=" + thang + ", nam=" + nam + ", soNgayDiLam="
				+ soNgayDiLam + ", soNgayNghiKhongPhep=" + soNgayNghiKhongPhep + ", soNgayNghiCoPhep="
				+ soNgayNghiCoPhep + ", soGioTangCa=" + soGioTangCa + ", soNgayLamChuNhat=" + soNgayLamChuNhat
				+ ", nhanVien=" + nhanVien + "]";
	}

	public double tinhLuongThucTe(int soNgayDiLam, double luongCoBan, double heSoLuong, int soGioTangCa,
			int soNgayLamChuNhat, double phuCapThamNien) {
		double luongThucTe = (soNgayDiLam * luongCoBan * heSoLuong) / 26 + (soGioTangCa * 25000)
				+ (soNgayLamChuNhat * (1.5 * luongCoBan * heSoLuong) / 26) + phuCapThamNien;
		return luongThucTe;
	}

	public double tinhLuongThucLinh(double luongThucTe, double luongCoBan, double heSoLuong) {
		double luongThucLinh = luongThucTe
				- (luongCoBan * heSoLuong * 0.08 + luongCoBan * heSoLuong * 0.015 + luongCoBan * heSoLuong * 0.01);
		return luongThucLinh;
	}

}
