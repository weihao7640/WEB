package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.CategoryModels;


public class CateDAO extends DBConnection{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/*
	 * public List<CategoryModels> getAllcate() { List<CategoryModels> list = new
	 * ArrayList<>(); String sql = "select * from Category"; try { conn = new
	 * DBConnection().getConnection(); ps = conn.prepareStatement(sql); rs =
	 * ps.executeQuery(); while (rs.next()) { list.add(new
	 * CategoryModels(rs.getInt(1), rs.getString(2), rs.getString(4))); } } catch
	 * (Exception e) {
	 * 
	 * } return list; }
	 */
	public List<CategoryModels> getAllcate() {
		List<CategoryModels> list = new ArrayList<>();
		String sql = "select * from Category";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CategoryModels(rs.getInt(1), rs.getString(2), rs.getString(4)));
			}
		} catch (Exception e) {

		}
		return list;
	}
	public List<CategoryModels> getAll() {
	List<CategoryModels> categories = new ArrayList<CategoryModels>();
	String sql = "SELECT * FROM Category";
	try {
		Connection conn = super.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			CategoryModels category = new CategoryModels();
		
			category.setCateid(rs.getInt(1));
			category.setNamecate(rs.getString(2));
			category.setImg(rs.getString(4));
			category.setIsDel(rs.getBoolean(5));
			category.setCreateCateDate(rs.getString(6));
			category.setUpdateCateDate(rs.getString(7));
			
			categories.add(category);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
	}
	return categories;
	
	}
	public CategoryModels get(int id) {
		String sql="SELECT * FROM Category WHERE categoryID=?";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModels category= new CategoryModels();
				category.setCateid(rs.getInt(1));
				category.setNamecate(rs.getString(2));
				category.setImg(rs.getString(4));
				category.setIsDel(rs.getBoolean(5));
				category.setCreateCateDate(rs.getString(6));
				category.setUpdateCateDate(rs.getString(7));
				return category;
			}		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return null;
	}
	
	public void insert(CategoryModels category) {
		String sql="INSERT INTO Category(name,slug,image,isDeleted,createdAt,updatedAt) VALUES (?,?,?,?,?,?)";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, category.getNamecate());
			ps.setString(2, category.getNamecate());
			ps.setString(3, category.getImg());
			ps.setBoolean(4, true);
			ps.setString(5, LocalDate.now().toString());
			ps.setString(6, LocalDate.now().toString());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void edit(CategoryModels category)
	{
		String sql="UPDATE Category SET name=?, image=?, isDeleted=?, updatedAt=? WHERE categoryID=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getNamecate());
			if (category.getImg()!=null) {
			ps.setString(2, category.getImg());}
			else 
			{
				ps.setString(2, get(category.getCateid()).getImg());
			}
			ps.setBoolean(3, category.getIsDel());
			ps.setString(4,LocalDate.now().toString() );
			ps.setInt(5, category.getCateid());
			ps.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	public void delete(int id)
	{
		String sql = "UPDATE Category SET isDeleted='true'  WHERE categoryID = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		
	}
	public List<CategoryModels> getCateOfStore(int id) {
		List<CategoryModels> categories = new ArrayList<CategoryModels>();
		String sql = "SELECT distinct(Category.categoryID), Category.name, Category.image, Category.isDeleted,Category.createdAt,Category.updatedAt FROM Category inner join Products on Category.categoryID=Products.categoryID where Products.storeID=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModels category = new CategoryModels();
			
				category.setCateid(rs.getInt(1));
				category.setNamecate(rs.getString(2));
				category.setImg(rs.getString(3));
				category.setIsDel(rs.getBoolean(4));
				category.setCreateCateDate(rs.getString(5));
				category.setUpdateCateDate(rs.getString(6));
				categories.add(category);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
		}
		return categories;
		
		}
	
	
}
