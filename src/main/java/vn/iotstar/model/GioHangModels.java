package vn.iotstar.model;

public class GioHangModels {
private int cartID;
private int userID;

@Override
public String toString() {
	return "GioHangModels [cartID=" + cartID + ", userID=" + userID + "]";
}
public int getCartID() {
	return cartID;
}
public void setCartID(int cartID) {
	this.cartID = cartID;
}
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public GioHangModels(int cartID, int userID) {
	super();
	this.cartID = cartID;
	this.userID = userID;
}

}
