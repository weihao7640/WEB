package vn.iotstar.model;

public class DonHangVM {
	private int oderid;
	private String name;
	private String namestore;
	private String diachi;
	private String phone;
	private String statusTT;
	private String status;
	private int tong;
	private String ngaytao;
	private String nameshipper;
	public int getOderid() {
		return oderid;
	}
	public void setOderid(int oderid) {
		this.oderid = oderid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNamestore() {
		return namestore;
	}
	public void setNamestore(String namestore) {
		this.namestore = namestore;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatusTT() {
		return statusTT;
	}
	public void setStatusTT(String statusTT) {
		this.statusTT = statusTT;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTong() {
		return tong;
	}
	public void setTong(int tong) {
		this.tong = tong;
	}
	public String getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(String ngaytao) {
		this.ngaytao = ngaytao;
	}
	public String getNameshipper() {
		return nameshipper;
	}
	public void setNameshipper(String nameshipper) {
		this.nameshipper = nameshipper;
	}
	public DonHangVM(int oderid, String name, String namestore, String diachi, String phone, String statusTT,
			String status, int tong, String ngaytao, String nameshipper) {
		super();
		this.oderid = oderid;
		this.name = name;
		this.namestore = namestore;
		this.diachi = diachi;
		this.phone = phone;
		this.statusTT = statusTT;
		this.status = status;
		this.tong = tong;
		this.ngaytao = ngaytao;
		this.nameshipper = nameshipper;
	}
	@Override
	public String toString() {
		return "DonHangVM [oderid=" + oderid + ", name=" + name + ", namestore=" + namestore + ", diachi=" + diachi
				+ ", phone=" + phone + ", statusTT=" + statusTT + ", status=" + status + ", tong=" + tong + ", ngaytao="
				+ ngaytao + ", nameshipper=" + nameshipper + "]";
	}

	

}
