package Model;

public class ChiTietDonHang {
private int orderID;
private int productID;
private int count;
public int getOrderID() {
	return orderID;
}
public void setOrderID(int orderID) {
	this.orderID = orderID;
}
public int getProductID() {
	return productID;
}
public void setProductID(int productID) {
	this.productID = productID;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public ChiTietDonHang(int orderID, int productID, int count) {
	super();
	this.orderID = orderID;
	this.productID = productID;
	this.count = count;
}
@Override
public String toString() {
	return "ChiTietDonHang [orderID=" + orderID + ", productID=" + productID + ", count=" + count + "]";
}
}
