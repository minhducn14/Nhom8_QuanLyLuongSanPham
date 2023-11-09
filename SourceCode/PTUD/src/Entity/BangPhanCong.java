package Entity;

import java.sql.Date;

public class BangPhanCong {
	private CongDoan congDoan;
	private ThoLamDan thoLamDan;
	private Date ngayPhanCong;
	private int soLuongSanPham;

	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}

	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}

	public CongDoan getCongDoan() {
		return congDoan;
	}

	public void setCongDoan(CongDoan congDoan) {
		this.congDoan = congDoan;
	}

	public ThoLamDan getThoLamDan() {
		return thoLamDan;
	}

	public void setThoLamDan(ThoLamDan thoLamDan) {
		this.thoLamDan = thoLamDan;
	}

	public Date getNgayPhanCong() {
		return ngayPhanCong;
	}

	public void setNgayPhanCong(Date ngayPhanCong) {
		this.ngayPhanCong = ngayPhanCong;
	}

	public BangPhanCong(CongDoan congDoan, ThoLamDan thoLamDan, Date ngayPhanCong) {
		super();
		this.congDoan = congDoan;
		this.thoLamDan = thoLamDan;
		this.ngayPhanCong = ngayPhanCong;
	}

	public BangPhanCong() {
		super();
	}

	@Override
	public String toString() {
		return "BangPhanCong [congDoan=" + congDoan + ", thoLamDan=" + thoLamDan + ", ngayPhanCong=" + ngayPhanCong
				+ "]";
	}

}
