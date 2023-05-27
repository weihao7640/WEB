package vn.iotstar.model;
import java.sql.Date;
public class DonHangModels {


	private int oderid;
	private int userid;
	private int storeid;
	private String diachi;
	private String statusTT;
	private int shipperid;
	private String phone;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String trangthai;
	private int tong;
	private String ngaynhap;
	private String ngayup;
	public int getOderid() {
		return oderid;
	}
	public void setOderid(int oderid) {
		this.oderid = oderid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public int getTong() {
		return tong;
	}
	public void setTong(int tong) {
		this.tong = tong;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public String getNgayup() {
		return ngayup;
	}
	public void setNgayup(String ngayup) {
		this.ngayup = ngayup;
	}
	@Override
	public String toString() {
		return "DonHangModels [oderid=" + oderid + ", userid=" + userid + ", storeid=" + storeid + ", diachi=" + diachi
				+ ", phone=" + phone + ", trangthai=" + trangthai + ", tong=" + tong + ", ngaynhap=" + ngaynhap
				+ ", ngayup=" + ngayup + "]";
	}
	
	public DonHangModels(int oderid, int userid, int storeid, String diachi, String statusTT, int shipperid,
			String phone, String trangthai, int tong, String ngaynhap, String ngayup) {
		super();
		this.oderid = oderid;
		this.userid = userid;
		this.storeid = storeid;
		this.diachi = diachi;
		this.statusTT = statusTT;
		this.shipperid = shipperid;
		this.phone = phone;
		this.trangthai = trangthai;
		this.tong = tong;
		this.ngaynhap = ngaynhap;
		this.ngayup = ngayup;
	}
	public String getStatusTT() {
		return statusTT;
	}
	public void setStatusTT(String statusTT) {
		this.statusTT = statusTT;
	}
	public int getShipperid() {
		return shipperid;
	}
	public void setShipperid(int shipperid) {
		this.shipperid = shipperid;
	}
	private String usersName;



	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public DonHangModels(int oderid, int userid, int storeid, String diachi, String statusTT, int shipperid,
			String phone, String trangthai, int tong, String ngaynhap, String ngayup, String userName) {
		super();
		this.oderid = oderid;
		this.userid = userid;
		this.storeid = storeid;
		this.diachi = diachi;
		this.statusTT = statusTT;
		this.shipperid = shipperid;
		this.phone = phone;
		this.trangthai = trangthai;
		this.tong = tong;
		this.ngaynhap = ngaynhap;
		this.ngayup = ngayup;
		this.usersName=userName;
	}
	
	public DonHangModels() {}
	private String shipperName;
	private String storeName;
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public DonHangModels(int oderid, int userid, int storeid, String diachi, String statusTT, int shipperid,
			String phone, String trangthai, int tong, String ngaynhap, String ngayup, String usersName,
			String shipperName, String storeName) {
		super();
		this.oderid = oderid;
		this.userid = userid;
		this.storeid = storeid;
		this.diachi = diachi;
		this.statusTT = statusTT;
		this.shipperid = shipperid;
		this.phone = phone;
		this.trangthai = trangthai;
		this.tong = tong;
		this.ngaynhap = ngaynhap;
		this.ngayup = ngayup;
		this.usersName = usersName;
		this.shipperName = shipperName;
		this.storeName = storeName;
	}
	
	
	
	
	
	
}