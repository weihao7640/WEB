package vn.iotstar.model;

public class CT_GHModels {
	private int cartID;
	private int productID;
	private int count;
	private String namepro;
	private int price;
	private String img;
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "CT_GHModels [cartID=" + cartID + ", productID=" + productID + ", count=" + count + ", namepro="
				+ namepro + ", price=" + price + ", img=" + img + "]";
	}
	public CT_GHModels(int cartID, int productID, int count, String namepro, int price, String img) {
		super();
		this.cartID = cartID;
		this.productID = productID;
		this.count = count;
		this.namepro = namepro;
		this.price = price;
		this.img = img;
	}
	
}
