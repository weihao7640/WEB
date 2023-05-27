package vn.iotstar.model;

public class StoreModels {
	private int storeId;
	private String storeName;
	private int ownerID;
	private Boolean active;
	private Boolean open;
	private String avatar;
	private int point;
	private double rating;
	private String createAt;
	private String updateAt;
	private String ownerName;
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public int getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public StoreModels() {
		super();
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
	public double getRating() {
		return rating;
	}
	public void setRating(double d) {
		this.rating = d;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public String getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	
	public StoreModels(int storeId, String storeName, int ownerID, Boolean active, Boolean open, String avatar, int point,
			 double rating, String createAt, String updateAt, String ownerName) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.ownerID = ownerID;
		this.active = active;
		this.open = open;
		this.avatar = avatar;
		this.point = point;
		this.rating = rating;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.ownerName=ownerName;
	}
	@Override
	public String toString() {
		return "StoreModels [storeId=" + storeId + ", storeName=" + storeName + ", ownerID=" + ownerID + ", active="
				+ active + ", open=" + open + ", avatar=" + avatar + ", point=" + point + ", rating=" + rating
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	private int sumCost;
	public int getSumCost() {
		return sumCost;
	}
	public void setSumCost(int sumCost) {
		this.sumCost = sumCost;
	}
	public StoreModels(int storeId, String storeName, int ownerID, String ownerName, int sumCost) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.ownerID = ownerID;
		this.ownerName = ownerName;
		this.sumCost = sumCost;
	}
	
	public StoreModels(int storeId, String storeName, Boolean open, String avatar, String updateAt) {
		
		this.storeId = storeId;
		this.storeName = storeName;
		this.open = open;
		this.avatar = avatar;
	}
	
	
}