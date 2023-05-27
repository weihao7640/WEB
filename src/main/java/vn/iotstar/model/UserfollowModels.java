package vn.iotstar.model;

public class UserfollowModels {
private int Userid;
private int Storeid;
private Boolean isdeleted;
private String ngaytg;
private String ngayup;
public int getUserid() {
	return Userid;
}
public void setUserid(int userid) {
	Userid = userid;
}
public int getStoreid() {
	return Storeid;
}
public void setStoreid(int storeid) {
	Storeid = storeid;
}
public Boolean getIsdeleted() {
	return isdeleted;
}
public void setIsdeleted(Boolean isdeleted) {
	this.isdeleted = isdeleted;
}
public String getNgaytg() {
	return ngaytg;
}
public void setNgaytg(String ngaytg) {
	this.ngaytg = ngaytg;
}
public String getNgayup() {
	return ngayup;
}
public void setNgayup(String ngayup) {
	this.ngayup = ngayup;
}
public UserfollowModels(int userid, int storeid, Boolean isdeleted, String ngaytg, String ngayup) {
	super();
	Userid = userid;
	Storeid = storeid;
	this.isdeleted = isdeleted;
	this.ngaytg = ngaytg;
	this.ngayup = ngayup;
}
public UserfollowModels() {
	super();
}
@Override
public String toString() {
	return "UserfollowModels [Userid=" + Userid + ", Storeid=" + Storeid + ", isdeleted=" + isdeleted + ", ngaytg="
			+ ngaytg + ", ngayup=" + ngayup + "]";
}

}
