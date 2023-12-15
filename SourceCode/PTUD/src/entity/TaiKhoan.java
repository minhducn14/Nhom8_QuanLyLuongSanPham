package entity;

public class TaiKhoan {
	private String taiKhoan;
	private String matKhau;
	private NhanVien nhanVien;

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String taiKhoan, String matKhau, NhanVien nhanVien) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.nhanVien = nhanVien;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", nhanVien=" + nhanVien + "]";
	}

}
