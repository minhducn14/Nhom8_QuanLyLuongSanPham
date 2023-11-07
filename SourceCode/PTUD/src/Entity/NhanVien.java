package Entity;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class NhanVien {
	private String maNhanVien;
	private String chucVu;
	private String trinhDoVanHoa;
	private double luongCoBan;
	private PhongBan phongBan;
	private CongNhanVien congNhanVien;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNhanVien, String chucVu, String trinhDoVanHoa, double luongCoBan, PhongBan phongBan,
			CongNhanVien congNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
		this.chucVu = chucVu;
		this.trinhDoVanHoa = trinhDoVanHoa;
		this.luongCoBan = luongCoBan;
		this.phongBan = phongBan;
		this.congNhanVien = congNhanVien;
	}

	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	public NhanVien(String chucVu, String trinhDoVanHoa, double luongCoBan, PhongBan phongBan,
			CongNhanVien congNhanVien) {
		// TODO Auto-generated constructor stub
		super();

		this.chucVu = chucVu;
		this.trinhDoVanHoa = trinhDoVanHoa;
		this.luongCoBan = luongCoBan;
		this.phongBan = phongBan;
		this.congNhanVien = congNhanVien;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", chucVu=" + chucVu + ", trinhDoVanHoa=" + trinhDoVanHoa
				+ ", luongCoBan=" + luongCoBan + ", phongBan=" + phongBan + ", congNhanVien=" + congNhanVien + "]";
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getTrinhDoVanHoa() {
		return trinhDoVanHoa;
	}

	public void setTrinhDoVanHoa(String trinhDoVanHoa) {
		this.trinhDoVanHoa = trinhDoVanHoa;
	}

	public double getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public CongNhanVien getCongNhanVien() {
		return congNhanVien;
	}

	public void setCongNhanVien(CongNhanVien congNhanVien) {
		this.congNhanVien = congNhanVien;
	}

	public double tinhHeSoLuong(Date ngayVaoLam, String trinhDo) {
		Instant ngayVaoLamInstant = new java.util.Date(ngayVaoLam.getTime()).toInstant();
		LocalDate ngayVaoLamLocal = ngayVaoLamInstant.atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate ngayHienTai = LocalDate.now();
		Period khoangThoiGian = Period.between(ngayVaoLamLocal, ngayHienTai);
		int soNamLamViec = khoangThoiGian.getYears();
		int soBacTangLuong = soNamLamViec / 3;

		double heSoTienTrienCaoDang = 0.31;
		double heSoTienTrienDaiHoc = 0.20;

		double heSoLuong = 0.0;

		if ("Cao Đẳng".equalsIgnoreCase(trinhDo)) {
			heSoLuong = 2.1;
		} else if ("Đại Học".equalsIgnoreCase(trinhDo)) {
			heSoLuong = 2.41;
		}

		if ("Cao Đẳng".equalsIgnoreCase(trinhDo)) {
			heSoLuong += soBacTangLuong * heSoTienTrienCaoDang;
		} else if ("Đại Học".equalsIgnoreCase(trinhDo)) {
			heSoLuong += soBacTangLuong * heSoTienTrienDaiHoc;
		}

		return heSoLuong;
	}

	public double tinhHeSoLuong() {
		Instant ngayVaoLamInstant = new java.util.Date(congNhanVien.getNgayVaoLam().getTime()).toInstant();
		LocalDate ngayVaoLamLocal = ngayVaoLamInstant.atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate ngayHienTai = LocalDate.now();
		Period khoangThoiGian = Period.between(ngayVaoLamLocal, ngayHienTai);
		int soNamLamViec = khoangThoiGian.getYears();
		int soBacTangLuong = soNamLamViec / 3;

		double heSoTienTrienCaoDang = 0.31;
		double heSoTienTrienDaiHoc = 0.20;

		double heSoLuong = 0.0;

		if ("Cao Đẳng".equalsIgnoreCase(trinhDoVanHoa)) {
			heSoLuong = 2.1;
		} else if ("Đại Học".equalsIgnoreCase(trinhDoVanHoa)) {
			heSoLuong = 2.41;
		}

		if ("Cao Đẳng".equalsIgnoreCase(trinhDoVanHoa)) {
			heSoLuong += soBacTangLuong * heSoTienTrienCaoDang;
		} else if ("Đại Học".equalsIgnoreCase(trinhDoVanHoa)) {
			heSoLuong += soBacTangLuong * heSoTienTrienDaiHoc;
		}

		return heSoLuong;
	}
}
