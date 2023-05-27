package vn.iotstar.model;

public class UserModels {
private int userID;
private String name;
private String email;
private String phone;
private String salt;
private String hash_password;
private String avatar;
private int point;
private int role;
public UserModels(int userID, String name, String email, String phone, String salt, String hash_password, String avatar,
		int point, int role) {
	super();
	this.userID = userID;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.salt = salt;
	this.hash_password = hash_password;
	this.avatar = avatar;
	this.point = point;
	this.role = role;
}
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
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
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getSalt() {
	return salt;
}
public void setSalt(String salt) {
	this.salt = salt;
}
public String getHash_password() {
	return hash_password;
}
public void setHash_password(String hash_password) {
	this.hash_password = hash_password;
}
public String getAvatar() {
	return avatar;
}
public void setAvatar(String avatar) {
	this.avatar = avatar;
}
public int getPoint() {
	return point;
}
public void setPoint(int point) {
	this.point = point;
}
@Override
public String toString() {
	return "UserModels [userID=" + userID + ", name=" + name +  ", email=" + email + ", phone="
			+ phone + ", salt=" + salt + ", hash_password=" + hash_password + ", avatar=" + avatar + ", point=" + point
			+ "]";
}
public UserModels() {}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}


}
