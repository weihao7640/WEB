package vn.iotstar.model;

public class DiaCHi {
private int userid;
private String DiaChi;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getDiaChi() {
	return DiaChi;
}
public void setDiaChi(String diaChi) {
	DiaChi = diaChi;
}
@Override
public String toString() {
	return "DiaCHi [userid=" + userid + ", DiaChi=" + DiaChi + "]";
}
public DiaCHi(int userid, String diaChi) {
	super();
	this.userid = userid;
	DiaChi = diaChi;
}

}
