package vn.iotstar.model;

public class KhachHang {
public String name;
public String email;
public String sdt;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}
public KhachHang(String name, String email, String sdt) {
	super();
	this.name = name;
	this.email = email;
	this.sdt = sdt;
}
@Override
public String toString() {
	return "KhachHang [name=" + name + ", email=" + email + ", sdt=" + sdt + "]";
}

}
