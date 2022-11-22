package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connect.DBConnection;
import Model.ProductsModels;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<ProductsModels> getAllSanpham() {
		List<ProductsModels> list = new ArrayList<>();
		String sql = "select * from Products";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductsModels(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(5), rs.getInt(7),
						rs.getInt(8), rs.getInt(11), rs.getInt(12), rs.getInt(13),rs.getString(16)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public List<ProductsModels> getpage(int id,int cate) {
		List<ProductsModels> list = new ArrayList<>();
		String sql = "SELECT * FROM Products where categoryID=? ORDER BY productid OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";

		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(2, id);
			ps.setInt(1, cate);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductsModels(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(5), rs.getInt(7),
						rs.getInt(8), rs.getInt(11), rs.getInt(12), rs.getInt(13),rs.getString(16)));
			}
		} catch (Exception e) {

		}
		return list;

	}
	public List<ProductsModels> top6() {
		List<ProductsModels> list = new ArrayList<>();
		String sql = "Select top 6 * from Products order by sold DESC ";

		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);;
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductsModels(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(5), rs.getInt(7),
						rs.getInt(8), rs.getInt(11), rs.getInt(12), rs.getInt(13),rs.getString(16)));
			}
		} catch (Exception e) {

		}
		return list;

	}
	public int countsp(int cateid) {
		String sql = "select count(*) from Products where categoryID=?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cateid);
			rs = ps.executeQuery();
			while (rs.next()) {
				int tong = rs.getInt(1);
				int sotrang = 0;
				sotrang = tong / 10;
				if (tong % 10 != 0) {
					sotrang++;
				}
				return sotrang;
			}

		} catch (Exception e) {

		}
		return 0;
	}
	public ProductsModels getIdSanpham(int id) 
	{

		String sql="select * from Products where ProductId=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new  ProductsModels(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(5), rs.getInt(7),
					rs.getInt(8), rs.getInt(11), rs.getInt(12), rs.getInt(13),rs.getString(16));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public ProductsModels updateSanpham(int slDaBan,int slCon,int id) 
	{

		String sql="update  Products set sold=?,quantity=? where productID=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, slDaBan);
		ps.setInt(2, slCon);
		ps.setInt(3, id);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new  ProductsModels(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(5), rs.getInt(7),
					rs.getInt(8), rs.getInt(11), rs.getInt(12), rs.getInt(13),rs.getString(16));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}

	/*
	 * public List<sanpham> timkiemSanpham(String key) { List<sanpham> list=new
	 * ArrayList<>(); String sql="select * from SANPHAM where ten like N'%'+?+'%'";
	 * try { conn=new DBConnection().getConnection(); ps=conn.prepareStatement(sql);
	 * ps.setString(1,key); rs=ps.executeQuery(); while(rs.next()) { list.add(new
	 * sanpham(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getInt(5),rs.getInt(6
	 * ),rs.getInt(8),rs.getInt(11),rs.getString(13))); } } catch(Exception e) {
	 * 
	 * } return list; } public sanpham getIdSanpham(String id) {
	 * 
	 * String sql="select * from SANPHAM where Id_Sp=?";
	 * 
	 * try { conn=new DBConnection().getConnection(); ps=conn.prepareStatement(sql);
	 * ps.setString(1, id); rs=ps.executeQuery(); while(rs.next()) { return new
	 * sanpham(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getInt(5),rs.getInt(6
	 * ),rs.getInt(8),rs.getInt(11),rs.getString(13)); } } catch(Exception e) {
	 * 
	 * } return null; } public User SosachId(String user,String pass) { String
	 * sql="select * from TaiKhoan where email=? and pass_hashed=?";
	 * 
	 * try { conn=new DBConnection().getConnection(); ps=conn.prepareStatement(sql);
	 * ps.setString(1, user); ps.setString(2, pass); rs=ps.executeQuery();
	 * while(rs.next()) { return new
	 * User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(6
	 * ),rs.getString(7),rs.getString(8),rs.getString(11),rs.getString(12),rs.
	 * getString(14)); } } catch(Exception e) {
	 * 
	 * } return null; } public User Sosachuser(String user) { String
	 * sql="select * from TaiKhoan where email=?";
	 * 
	 * try { conn=new DBConnection().getConnection(); ps=conn.prepareStatement(sql);
	 * ps.setString(1, user); rs=ps.executeQuery(); while(rs.next()) { return new
	 * User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(6
	 * ),rs.getString(7),rs.getString(8),rs.getString(11),rs.getString(12),rs.
	 * getString(14)); } } catch(Exception e) {
	 * 
	 * } return null; } public void dangky(String user,String pass) { String
	 * sql="insert into TaiKhoan(email,pass_hashed) values(?,?)"; try { conn=new
	 * DBConnection().getConnection(); ps=conn.prepareStatement(sql);
	 * ps.setString(1, user); ps.setString(2, pass); ps.executeUpdate();
	 * 
	 * } catch(Exception e) {
	 * 
	 * } } public List<sanpham> getNext3Product(int amount) { List<sanpham> list =
	 * new ArrayList<sanpham>(); String query =
	 * "SELECT * FROM SANPHAM ORDER BY Id_Sp OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
	 * try { conn = new DBConnection().getConnection();// mo ket noi voi sql ps =
	 * conn.prepareStatement(query); // set vị trí của product ps.setInt(1, amount);
	 * rs = ps.executeQuery(); while (rs.next()) { list.add(new
	 * sanpham(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getInt(5),rs.getInt(6
	 * ),rs.getInt(8),rs.getInt(11),rs.getString(13))); } } catch (Exception e) { }
	 * return list; } public static void main(String[] args) { DAO dao =new DAO();
	 * List<sanpham> list=dao.getNext3Product(0); for(sanpham o : list) {
	 * System.out.println(o);} } public void insert(CategoryModel category) { String
	 * sql = "INSERT INTO Category(categoryName,images) VALUES (?,?)"; try {
	 * Connection con = new DBConnection().getConnection(); PreparedStatement ps =
	 * con.prepareStatement(sql); ps.setString(1, category.getCatename());
	 * ps.setString(2, category.getIcon()); ps.executeUpdate(); } catch (Exception
	 * e) { e.printStackTrace(); } } public void edit(CategoryModel category) {
	 * String sql =
	 * "UPDATE category SET categoryName = ?, images=?, status=? WHERE categoryId = ?"
	 * ; try { Connection con = new DBConnection().getConnection();
	 * PreparedStatement ps = con.prepareStatement(sql); ps.setString(1,
	 * category.getCatename()); ps.setString(2, category.getIcon()); ps.setInt(4,
	 * category.getCateid()); ps.setInt(3, category.getStatu()); ps.executeUpdate();
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } public void delete(int id) { String sql =
	 * "DELETE FROM Category WHERE categoryId = ?"; try { Connection con = new
	 * DBConnection().getConnection(); PreparedStatement ps =
	 * con.prepareStatement(sql); ps.setInt(1, id); ps.executeUpdate(); } catch
	 * (Exception e) { e.printStackTrace(); } } public CategoryModel get(int id) {
	 * String sql = "SELECT * FROM category WHERE categoryId = ? "; try { Connection
	 * con = new DBConnection().getConnection(); PreparedStatement ps =
	 * con.prepareStatement(sql); ps.setInt(1, id); ResultSet rs =
	 * ps.executeQuery(); while (rs.next()) { CategoryModel category = new
	 * CategoryModel(); category.setCateid(rs.getInt("categoryId"));
	 * category.setCatename(rs.getString("categoryName"));
	 * category.setIcon(rs.getString("images"));
	 * category.setStatu(rs.getInt("status")); return category; }} catch (Exception
	 * e) { e.printStackTrace();} return null; } public List<CategoryModel> getAll()
	 * { List<CategoryModel> categories = new ArrayList<CategoryModel>(); String sql
	 * = "SELECT * FROM Category"; try { Connection conn = new
	 * DBConnection().getConnection(); PreparedStatement ps =
	 * conn.prepareStatement(sql);
	 * 
	 * ResultSet rs = ps.executeQuery(); while (rs.next()) { CategoryModel category
	 * = new CategoryModel();
	 * 
	 * category.setCateid(rs.getInt("categoryId"));
	 * category.setCatename(rs.getString("categoryName"));
	 * category.setIcon(rs.getString("images"));
	 * category.setStatu(rs.getInt("status"));
	 * 
	 * categories.add(category);
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return categories;
	 * 
	 * } public CategoryModel get(String name) { // TODO Auto-generated method stub
	 * return null; }
	 */
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.updateSanpham(5, 120, 14);

	}
}
