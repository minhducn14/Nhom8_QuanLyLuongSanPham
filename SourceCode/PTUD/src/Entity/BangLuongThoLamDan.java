package Entity;

public class BangLuongThoLamDan {
	private String maBangLuong;
	private ThoLamDan thoLamDan;
	private int thang;
	private int nam;

	public String getMaBangLuong() {
		return maBangLuong;
	}

	public void setMaBangLuong(String maBangLuong) {
		this.maBangLuong = maBangLuong;
	}

	public ThoLamDan getThoLamDan() {
		return thoLamDan;
	}

	public void setThoLamDan(ThoLamDan thoLamDan) {
		this.thoLamDan = thoLamDan;
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

	public BangLuongThoLamDan(String maBangLuong, ThoLamDan thoLamDan, int thang, int nam) {
		super();
		this.maBangLuong = maBangLuong;
		this.thoLamDan = thoLamDan;
		this.thang = thang;
		this.nam = nam;
	}

	@Override
	public String toString() {
		return "LuongThoLamDan [maBangLuong=" + maBangLuong + ", thoLamDan=" + thoLamDan + ", thang=" + thang + ", nam="
				+ nam + "]";
	}

	public double tinhLuongThucLinh(double luongThucTe) {
		double luongThucLinh = luongThucTe - (3000000 * 0.08 + 3000000 * 0.015 + 3000000 * 0.01);
		return luongThucLinh;
	}

	public BangLuongThoLamDan() {
		super();
	}

}
