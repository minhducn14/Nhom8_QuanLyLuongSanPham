package Entity;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;

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

	public double tinhHeSoLuong() {
		String[] trinhDo = { "Bậc 1", "Bậc 2", "Bậc 3", "Bậc 4", "Bậc 5" };
		double[] heSo = { 1.0, 1.2, 1.4, 1.6, 1.8 };

		int position = Arrays.asList(trinhDo).indexOf(tayNghe);
		double heSoLuong = heSo[position];
		return heSoLuong;
	}
}
