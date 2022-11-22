package Model;

public class CategoryModels {
private int cateid;
private String namecate;
private String img;
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
public CategoryModels(int cateid, String namecate, String img) {
	this.cateid = cateid;
	this.namecate = namecate;
	this.img = img;
}
@Override
public String toString() {
	return "CategoryModels [cateid=" + cateid + ", namecate=" + namecate + ", img=" + img + "]";
}

}
