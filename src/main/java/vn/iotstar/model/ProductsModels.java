package vn.iotstar.model;

public class ProductsModels {
	private int proid;
	private String namePro;
	private String des;
	private int price;
	private int quan;
	private int sold;
	public ProductsModels(int proid, String namePro, String des, int price, int quan, int sold, int cateId, int storeID,
			float rating, String img) {
	
		this.proid = proid;
		this.namePro = namePro;
		this.des = des;
		this.price = price;
		this.quan = quan;
		this.sold = sold;
		this.cateId = cateId;
		this.storeID = storeID;
		this.rating = rating;
		this.img = img;
	}
	@Override
	public String toString() {
		return "ProductsModels [proid=" + proid + ", namePro=" + namePro + ", des=" + des + ", price=" + price
				+ ", quan=" + quan + ", sold=" + sold + ", cateId=" + cateId + ", storeID=" + storeID + ", rating="
				+ rating + ", img=" + img + "]";
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getNamePro() {
		return namePro;
	}
	public void setNamePro(String namePro) {
		this.namePro = namePro;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public ProductsModels() {
		
	}
	private int cateId;
	private int storeID;
	private float rating;
	private String img;
	
}