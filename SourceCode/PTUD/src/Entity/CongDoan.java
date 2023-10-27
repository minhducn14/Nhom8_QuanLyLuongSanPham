package Entity;

public class CongDoan {
	private String maCongDoan;
	private String tenCongDoan;
	private Dan dan;
	private float giaCongDoan;

	public String getMaCongDoan() {
		return maCongDoan;
	}

	public void setMaCongDoan(String maCongDoan) {
		this.maCongDoan = maCongDoan;
	}

	public String getTenCongDoan() {
		return tenCongDoan;
	}

	public void setTenCongDoan(String tenCongDoan) {
		this.tenCongDoan = tenCongDoan;
	}

	public Dan getDan() {
		return dan;
	}

	public void setDan(Dan dan) {
		this.dan = dan;
	}

	public float getGiaCongDoan() {
		return giaCongDoan;
	}

	public void setGiaCongDoan(float giaCongDoan) {
		this.giaCongDoan = giaCongDoan;
	}

	public CongDoan(String maCongDoan, String tenCongDoan, Dan dan, float giaCongDoan) {
		super();
		this.maCongDoan = maCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.dan = dan;
		this.giaCongDoan = giaCongDoan;
	}

	public CongDoan() {
		super();
	}

	@Override
	public String toString() {
		return "CongDoan [maCongDoan=" + maCongDoan + ", tenCongDoan=" + tenCongDoan + ", dan=" + dan + ", giaCongDoan="
				+ giaCongDoan + "]";
	}

}
