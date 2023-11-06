package Entity;

public class ThoLamDan {
	private String maThoLamDan;
	private String tayNghe;
	private CongNhanVien congNhanVien;

	public String getMaThoLamDan() {
		return maThoLamDan;
	}

	public void setMaThoLamDan(String maThoLamDan) {
		this.maThoLamDan = maThoLamDan;
	}

	public String getTayNghe() {
		return tayNghe;
	}

	public void setTayNghe(String tayNghe) {
		this.tayNghe = tayNghe;
	}

	public CongNhanVien getCongNhanVien() {
		return congNhanVien;
	}

	public void setCongNhanVien(CongNhanVien congNhanVien) {
		this.congNhanVien = congNhanVien;
	}

	public ThoLamDan(String maThoLamDan, String tayNghe, CongNhanVien congNhanVien) {
		super();
		this.maThoLamDan = maThoLamDan;
		this.tayNghe = tayNghe;
		this.congNhanVien = congNhanVien;
	}

	public ThoLamDan(String tayNghe, CongNhanVien congNhanVien) {
		super();
		this.tayNghe = tayNghe;
		this.congNhanVien = congNhanVien;
	}

	public ThoLamDan() {
		super();
	}

	@Override
	public String toString() {
		return "ThoLamDan [maThoLamDan=" + maThoLamDan + ", tayNghe=" + tayNghe + ", congNhanVien=" + congNhanVien
				+ "]";
	}

}
