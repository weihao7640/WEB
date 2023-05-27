package vn.iotstar.model;

public class CT_DonHangModels {
	
	private int orderid;
	private int productid;
	private int count;
	private String createdAt;
	private String updatedAt;
	
	private String productName;
	private int gia;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public CT_DonHangModels(int orderid, int productid, int count, String productName, int gia) {
		
		this.orderid = orderid;
		this.productid = productid;
		this.count = count;
		this.productName = productName;
		this.gia = gia;
	}
	
	public CT_DonHangModels() {}
	
}
