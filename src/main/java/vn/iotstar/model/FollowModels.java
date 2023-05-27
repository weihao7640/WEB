package vn.iotstar.model;

public class FollowModels {
	private int storeid;
	private String storeName;
	private Boolean isDeleted;
	private String avatar;
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public FollowModels(int storeid, String storeName, Boolean isDeleted, String avatar) {
		
		this.storeid = storeid;
		this.storeName = storeName;
		this.isDeleted = isDeleted;
		this.avatar = avatar;
	}
	
	public FollowModels() {}
}
