package vn.iotstar.model;

public class CT_DHVM {
	private int oderID;
	private int productID;
	private int count;
	private String namepro;
	public int getOderID() {
		return oderID;
	}
	public void setOderID(int oderID) {
		this.oderID = oderID;
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
	public String getNamepro() {
		return namepro;
	}
	public void setNamepro(String namepro) {
		this.namepro = namepro;
	}
	public CT_DHVM(int oderID, int productID, int count, String namepro) {
		super();
		this.oderID = oderID;
		this.productID = productID;
		this.count = count;
		this.namepro = namepro;
	}
	
}
