package vn.iotstar.model;

public class CategoryModels {
private int cateid;
private String namecate;
private String img;
private String createCateDate;
private String updateCateDate;
private Boolean isDel;
public String getCreateCateDate() {
	return createCateDate;
}
public void setCreateCateDate(String createCateDate) {
	this.createCateDate = createCateDate;
}
public String getUpdateCateDate() {
	return updateCateDate;
}
public void setUpdateCateDate(String updateCateDate) {
	this.updateCateDate = updateCateDate;
}

public CategoryModels(int cateid, String namecate, String img) {
	this.cateid = cateid;
	this.namecate = namecate;
	this.img = img;
}

public Boolean getIsDel() {
	return isDel;
}
public void setIsDel(Boolean isDel) {
	this.isDel = isDel;
}
public int getCateid() {
	return cateid;
}
public void setCateid(int cateid) {
	this.cateid = cateid;
}
public String getNamecate() {
	return namecate;
}
public void setNamecate(String namecate) {
	this.namecate = namecate;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public CategoryModels(int cateid, String namecate, String img, String createCateDate, String updateCateDate,
		boolean isDel) {
	super();
	this.cateid = cateid;
	this.namecate = namecate;
	this.img = img;
	this.createCateDate = createCateDate;
	this.updateCateDate = updateCateDate;
	this.isDel = isDel;
}
public CategoryModels() {super();}
@Override
public String toString() {
	return "CategoryModels [cateid=" + cateid + ", namecate=" + namecate + ", img=" + img + ", createCateDate="
			+ createCateDate + ", updateCateDate=" + updateCateDate + ", isDel=" + isDel + "]";
}

}
