package vn.iotstar.model;

public class CommentVM {
	private int userID;
	private int productID;
	private int storeID;
	private int orderID;
	private int rating;
	private String content;
	private String createdAt;
	private String updatedAt;
	private String name;
	private String avatar;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public CommentVM(int userID, int productID, int storeID, int orderID, int rating, String content, String createdAt,
			String updatedAt, String name, String avatar) {
		super();
		this.userID = userID;
		this.productID = productID;
		this.storeID = storeID;
		this.orderID = orderID;
		this.rating = rating;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.name = name;
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "CommentVM [userID=" + userID + ", productID=" + productID + ", storeID=" + storeID + ", orderID="
				+ orderID + ", rating=" + rating + ", content=" + content + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", name=" + name + ", avatar=" + avatar + "]";
	}
	
	
}
