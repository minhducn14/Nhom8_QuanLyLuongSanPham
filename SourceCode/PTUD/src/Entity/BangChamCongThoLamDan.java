package Entity;

import java.sql.Date;

public class BangChamCongThoLamDan {
	private String maBCCThoLamDan;
	private int soLuongSanPham;
	private Date ngayChamCong;
	private BangLuongThoLamDan bangLuong;
	private ThoLamDan thoLamDan;
	private CongDoan congDoan;

	public String getMaBCCThoLamDan() {
		return maBCCThoLamDan;
	}

	public void setMaBCCThoLamDan(String maBCCThoLamDan) {
		this.maBCCThoLamDan = maBCCThoLamDan;
	}

	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}

	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}

	public Date getNgayChamCong() {
		return ngayChamCong;
	}

	public void setNgayChamCong(Date ngayChamCong) {
		this.ngayChamCong = ngayChamCong;
	}

	public BangLuongThoLamDan getBangLuong() {
		return bangLuong;
	}

	public void setBangLuong(BangLuongThoLamDan bangLuong) {
		this.bangLuong = bangLuong;
	}

	public ThoLamDan getThoLamDan() {
		return thoLamDan;
	}

	public void setThoLamDan(ThoLamDan thoLamDan) {
		this.thoLamDan = thoLamDan;
	}

	public CongDoan getCongDoan() {
		return congDoan;
	}

	public void setCongDoan(CongDoan congDoan) {
		this.congDoan = congDoan;
	}

	@Override
	public String toString() {
		return "ChamCongThoLamDan [maBCCThoLamDan=" + maBCCThoLamDan + ", soLuongSanPham=" + soLuongSanPham
				+ ", ngayChamCong=" + ngayChamCong + ", bangLuong=" + bangLuong + ", thoLamDan=" + thoLamDan
				+ ", congDoan=" + congDoan + "]";
	}

	public BangChamCongThoLamDan(String maBCCThoLamDan, int soLuongSanPham, Date ngayChamCong, BangLuongThoLamDan bangLuong,
			ThoLamDan thoLamDan, CongDoan congDoan) {
		super();
		this.maBCCThoLamDan = maBCCThoLamDan;
		this.soLuongSanPham = soLuongSanPham;
		this.ngayChamCong = ngayChamCong;
		this.bangLuong = bangLuong;
		this.thoLamDan = thoLamDan;
		this.congDoan = congDoan;
	}

}
