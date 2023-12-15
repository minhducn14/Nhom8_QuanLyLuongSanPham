package entity;

public class Dan {
	private String maSanPham;
	private String tenSanPham;
	private String loaiSanPham;
	private String moTa;
	private double giaBan;
	private String matDan;
	private String eoLung;
	private String can;
	private String matPhim;
	private String day;
	private String khoa;
	private String cauNgua;
	private boolean trangThai;

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public String getMatDan() {
		return matDan;
	}

	public void setMatDan(String matDan) {
		this.matDan = matDan;
	}

	public String getEoLung() {
		return eoLung;
	}

	public void setEoLung(String eoLung) {
		this.eoLung = eoLung;
	}

	public String getCan() {
		return can;
	}

	public void setCan(String can) {
		this.can = can;
	}

	public String getMatPhim() {
		return matPhim;
	}

	public void setMatPhim(String matPhim) {
		this.matPhim = matPhim;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getCauNgua() {
		return cauNgua;
	}

	public void setCauNgua(String cauNgua) {
		this.cauNgua = cauNgua;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Dan(String maSanPham, String tenSanPham, String loaiSanPham, String moTa, double giaBan, String matDan,
			String eoLung, String can, String matPhim, String day, String khoa, String cauNgua, boolean trangThai) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.loaiSanPham = loaiSanPham;
		this.moTa = moTa;
		this.giaBan = giaBan;
		this.matDan = matDan;
		this.eoLung = eoLung;
		this.can = can;
		this.matPhim = matPhim;
		this.day = day;
		this.khoa = khoa;
		this.cauNgua = cauNgua;
		this.trangThai = trangThai;
	}

	public Dan() {
		super();
	}


	public Dan(String tenSanPham, String loaiSanPham, String moTa, double giaBan, String matDan, String eoLung,
			String can, String matPhim, String day, String khoa, String cauNgua, boolean trangThai) {

		super();
		this.tenSanPham = tenSanPham;
		this.loaiSanPham = loaiSanPham;
		this.moTa = moTa;
		this.giaBan = giaBan;
		this.matDan = matDan;
		this.eoLung = eoLung;
		this.can = can;
		this.matPhim = matPhim;
		this.day = day;
		this.khoa = khoa;
		this.cauNgua = cauNgua;
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "Dan [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", loaiSanPham=" + loaiSanPham + ", moTa="
				+ moTa + ", giaBan=" + giaBan + ", matDan=" + matDan + ", eoLung=" + eoLung + ", can=" + can
				+ ", matPhim=" + matPhim + ", day=" + day + ", khoa=" + khoa + ", cauNgua=" + cauNgua + ", trangThai="
				+ trangThai + "]";
	}

}
