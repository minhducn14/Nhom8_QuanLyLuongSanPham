package Entity;

import java.sql.Date;

public class BangChamCongNhanVien {
	private String maBCCNhanVien;
	private NhanVien nhanVien;
	private Date ngayChamCong;
	private String trangThaiDiLam;
	private int soGioTangCa;
	private BangLuongNhanVien bangLuong;

	public String getMaBCCNhanVien() {
		return maBCCNhanVien;
	}

	public void setMaBCCNhanVien(String maBCCNhanVien) {
		this.maBCCNhanVien = maBCCNhanVien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Date getNgayChamCong() {
		return ngayChamCong;
	}

	public void setNgayChamCong(Date ngayChamCong) {
		this.ngayChamCong = ngayChamCong;
	}

	public String getTrangThaiDiLam() {
		return trangThaiDiLam;
	}

	public void setTrangThaiDiLam(String trangThaiDiLam) {
		this.trangThaiDiLam = trangThaiDiLam;
	}

	public int getSoGioTangCa() {
		return soGioTangCa;
	}

	public void setSoGioTangCa(int soGioTangCa) {
		this.soGioTangCa = soGioTangCa;
	}

	public BangLuongNhanVien getBangLuong() {
		return bangLuong;
	}

	public void setBangLuong(BangLuongNhanVien bangLuong) {
		this.bangLuong = bangLuong;
	}

	public BangChamCongNhanVien(String maBCCNhanVien, NhanVien nhanVien, Date ngayChamCong, String trangThaiDiLam,
			int soGioTangCa, BangLuongNhanVien bangLuong) {
		super();
		this.maBCCNhanVien = maBCCNhanVien;
		this.nhanVien = nhanVien;
		this.ngayChamCong = ngayChamCong;
		this.trangThaiDiLam = trangThaiDiLam;
		this.soGioTangCa = soGioTangCa;
		this.bangLuong = bangLuong;
	}

	public BangChamCongNhanVien() {
		super();
	}

	@Override
	public String toString() {
		return "ChamCongNhanVien [maBCCNhanVien=" + maBCCNhanVien + ", nhanVien=" + nhanVien + ", ngayChamCong="
				+ ngayChamCong + ", trangThaiDiLam=" + trangThaiDiLam + ", soGioTangCa=" + soGioTangCa + ", bangLuong="
				+ bangLuong + "]";
	}

}
