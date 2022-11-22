package Model;
import java.sql.Date;
public class DonHangModels {


	private int oderid;
	private int userid;
	private int storeid;
	private String diachi;
	private String trangthai;
	private int tong;
	private Date ngaynhap;
	private Date ngayup;
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
	public Date getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public Date getNgayup() {
		return ngayup;
	}
	public void setNgayup(Date ngayup) {
		this.ngayup = ngayup;
	}
	@Override
	public String toString() {
		return "DonHangModels [oderid=" + oderid + ", userid=" + userid + ", storeid=" + storeid + ", diachi=" + diachi
				+ ", trangthai=" + trangthai + ", tong=" + tong + ", ngaynhap=" + ngaynhap + ", ngayup=" + ngayup + "]";
	}
	public DonHangModels(int oderid, int userid, int storeid, String diachi, String trangthai, int tong) {
		super();
		this.oderid = oderid;
		this.userid = userid;
		this.storeid = storeid;
		this.diachi = diachi;
		this.trangthai = trangthai;
		this.tong = tong;
	}
	
}