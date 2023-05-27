package vn.iotstar.model;

public class ProductModels {

	private int productId;
	private String productName;
	private String description;
	private int price;
	private int quantity;
	private int sold;
	private Boolean isActive;
	private Boolean isSelling;
	private int categoryId;
	private int storeId;
	private float rating;
	private String createProDate;
	private String updateProDate;
	private String img;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsSelling() {
		return isSelling;
	}
	public void setIsSelling(Boolean isSelling) {
		this.isSelling = isSelling;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getCreateProDate() {
		return createProDate;
	}
	public void setCreateProDate(String createProDate) {
		this.createProDate = createProDate;
	}
	public String getUpdateProDate() {
		return updateProDate;
	}
	public void setUpdateProDate(String updateProDate) {
		this.updateProDate = updateProDate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public ProductModels() {super();}
	
	
	public ProductModels(int productId, String productName, String description, int price, int quantity, int sold,
			Boolean isActive, Boolean isSelling, int categoryId, int storeId, float rating, String createProDate,
			String updateProDate, String img) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.sold = sold;
		this.isActive = isActive;
		this.isSelling = isSelling;
		this.categoryId = categoryId;
		this.storeId = storeId;
		this.rating = rating;
		this.createProDate = createProDate;
		this.updateProDate = updateProDate;
		this.img = img;
	}
	@Override
	public String toString() {
		return "ProductModels [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + ", sold=" + sold + ", isActive=" + isActive
				+ ", isSelling=" + isSelling + ", categoryId=" + categoryId + ", storeId=" + storeId + ", rating="
				+ rating + ", createProDate=" + createProDate + ", updateProDate=" + updateProDate + ", img=" + img
				+ "]";
	}
	private String nameStore;
	private String nameCategory;
	public String getNameStore() {
		return nameStore;
	}
	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public ProductModels(int productId, String productName, int price, int sold, int categoryId, int storeId,
			String img, String nameStore, String nameCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.sold = sold;
		this.categoryId = categoryId;
		this.storeId = storeId;
		this.img = img;
		this.nameStore = nameStore;
		this.nameCategory = nameCategory;
	}
	
	
	
}
