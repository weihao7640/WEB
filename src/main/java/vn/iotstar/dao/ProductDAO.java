package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.ProductModels;

public class ProductDAO extends DBConnection{

	
	
	public List<ProductModels> getAll(){
		List<ProductModels> products=new ArrayList<ProductModels>();
		String sql="SELECT * FROM Products";
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));
				products.add(product);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
		}
		return products;
	}
	public List<ProductModels> getAllStore(int storeid){
		List<ProductModels> products=new ArrayList<ProductModels>();
		String sql="SELECT * FROM Products where storeID=?";
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));
				products.add(product);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
		}
		return products;
	}
	
	public ProductModels get(int id) {
		String sql="Select * from Products where productID=?";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));			
				
				return product;
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}
	
	
	public void insert(ProductModels product) {
		String sql="insert into Products(name,description,price,promotionalPrice,quantity,sold,isActive,isSelling,categoryID,storeID,rating,createdAt,updatedAt,img) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getPrice());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, 0);
			ps.setBoolean(7, true);
			ps.setBoolean(8, product.getIsSelling());
			ps.setInt(9, product.getCategoryId());
			ps.setInt(10, product.getStoreId());
			ps.setFloat(11, 0);
			ps.setString(12, LocalDate.now().toString());
			ps.setString(13, LocalDate.now().toString());
			ps.setString(14, product.getImg());
			
			ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	public void insert(ProductModels product,int id) {
		String sql="insert into Products(name,description,price,promotionalPrice,quantity,sold,isActive,isSelling,categoryID,storeID,rating,createdAt,updatedAt,img) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getPrice());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, 0);
			ps.setBoolean(7, true);
			ps.setBoolean(8, product.getIsSelling());
			ps.setInt(9, product.getCategoryId());
			ps.setInt(10,id);
			ps.setFloat(11, 0);
			ps.setString(12, LocalDate.now().toString());
			ps.setString(13, LocalDate.now().toString());
			ps.setString(14, product.getImg());
			
			ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
	public void edit(ProductModels product) {
		String sql="UPDATE Products SET "
				+ "name=?,img=?, description=?, price=?, promotionalPrice=?,"
				+ "isActive=?, isSelling=?, categoryId=?,storeId=?,"
				+ "updatedAt=? WHERE productID=?";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			if (product.getImg()!=null) {
			ps.setString(2, product.getImg());}
			else 
			{
				ps.setString(2, get(product.getProductId()).getImg());
			}
			ps.setString(3, product.getDescription());
			ps.setInt(4, product.getPrice());
			ps.setInt(5, product.getPrice());
			ps.setBoolean(6, product.getIsActive());
			ps.setBoolean(7, product.getIsSelling());
			ps.setInt(8, product.getCategoryId());
			ps.setInt(9, product.getStoreId());			
			ps.setString(10,LocalDate.now().toString());
			ps.setInt(11, product.getProductId());
			ps.executeUpdate();		
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}
	public void rating(int product,Double rating) {
		String sql="UPDATE Products SET rating=? WHERE productID=?";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(2, product);
			ps.setDouble(1, rating);
			ps.executeUpdate();		
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}
	public void delete(int id)
	{
		String sql = "UPDATE Products SET isActive='false'  WHERE productID = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		
	}
	public void delete_sp(int id)
	{
		String sql = "UPDATE Products SET isSelling='false'  WHERE productID = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		
	}
	public List<ProductModels> getpage(int id,int cate) {
		List<ProductModels> list = new ArrayList<>();
		String sql = "SELECT * FROM Products where categoryID=? ORDER BY productid OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(2, id);
			ps.setInt(1, cate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));
				list.add(product);
			}
		} catch (Exception e) {

		}
		return list;

	}
	public List<ProductModels> getpageST(int id,int cate) {
		List<ProductModels> list = new ArrayList<>();
		String sql = "SELECT * FROM Products where storeID=? ORDER BY productid OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, cate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));
				list.add(product);
			}
		} catch (Exception e) {

		}
		return list;

	}
	public List<ProductModels> getpageST(int id,int cate, int cateid) {
		List<ProductModels> list = new ArrayList<>();
		String sql = "SELECT * FROM Products where storeID=? and categoryID=? ORDER BY productid OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, cateid);
			ps.setInt(3, cate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));
				list.add(product);
			}
		} catch (Exception e) {

		}
		return list;

	}
	public List<ProductModels> top6() {
		List<ProductModels> list = new ArrayList<>();
		String sql = "Select top 6 * from Products order by sold DESC ";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));
				list.add(product);
			}
		} catch (Exception e) {

		}
		return list;

	}
	public int countsp_ST(int cateid) {
		String sql = "select count(*) from Products where storeID=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cateid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int tong = rs.getInt(1);
				int sotrang = 0;
				sotrang = tong / 6;
				if (tong % 6 != 0) {
					sotrang++;
				}
				return sotrang;
			}

		} catch (Exception e) {

		}
		return 0;
	}
	public int countsp_ST(int cateid,int cate) {
		String sql = "select count(*) from Products where storeID=? and categoryID=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cateid);
			ps.setInt(2, cate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int tong = rs.getInt(1);
				int sotrang = 0;
				sotrang = tong / 6;
				if (tong % 6 != 0) {
					sotrang++;
				}
				return sotrang;
			}

		} catch (Exception e) {

		}
		return 0;
	}
	
	
	public int countsp(int cateid) {
		String sql = "select count(*) from Products where categoryID=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cateid);
			ResultSet rs = ps.executeQuery();
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
	
	public int countAll() {
		String sql="select count(*) from Products";
		try
		{
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);				
			}
			
			
		}catch(Exception e){
			
		}
		
		
		return 0;
	}
	public List<ProductModels> findAllPage(int indexp){
		List<ProductModels> productList = new ArrayList<ProductModels>();
		String sql = "SELECT * FROM Products, Stores, Category where Products.storeid=stores.storeid and products.categoryid=category.categoryid ORDER BY productID DESC OFFSET ?*5 rows fetch next 5 rows only";
		
		
		
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, indexp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));
				product.setNameStore(rs.getString(18));
				product.setNameCategory(rs.getString(31));
				productList.add(product);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
		}
		
		return productList;
	}
	public int countCategory(int categoryID) {
		String sql="select count(*) from Products where categoryID=?";
		try
		{
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, categoryID);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);				
			}
			
			
		}catch(Exception e){
			
		}
		
		
		return 0;
	}
	public List<ProductModels> findAllProCate(int categoryID,int indexp){
		List<ProductModels> productList = new ArrayList<ProductModels>();
		String sql = "SELECT * FROM Products WHERE categoryID=? ORDER BY productID DESC OFFSET ?*5 rows fetch next 5 rows only";
		
		
		
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryID);
			ps.setInt(2, indexp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));
				productList.add(product);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
		}
		
		return productList;
	}
	
	public int countProOfStore(int id) {
		String sql="SELECT count(*) FROM Category inner join Products on Category.categoryID=Products.categoryID where Products.storeID=?";
		
		
		try
		{
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);				
			}
			
			
		}catch(Exception e){
			
		}
		
		
		return 0;
	}
	
	public int countProOfCateOfStore(int storeid, int cateid) {
		
String sql="SELECT count(*) FROM Category inner join Products on Category.categoryID=Products.categoryID where Products.storeID=? and Products.categoryID=?";
		
		
		try
		{
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, storeid);
			ps.setInt(2, cateid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);				
			}
			
			
		}catch(Exception e){
			
		}
		
		
		return 0;
	}
	
	public List<ProductModels> findAllProOfStore(int storeID,int indexp){
		List<ProductModels> productList = new ArrayList<ProductModels>();
		String sql = "SELECT * FROM Products WHERE storeID=? ORDER BY productID DESC OFFSET ?*8 rows fetch next 8 rows only";
		
		
		
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeID);
			ps.setInt(2, indexp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));
				productList.add(product);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
		}
		
		return productList;
	}
	
	public List<ProductModels> findAllProOfCateOfStore(int storeID, int categoryID,int indexp){
		List<ProductModels> productList = new ArrayList<ProductModels>();
		String sql = "SELECT * FROM Products WHERE storeID=? and categoryID=? ORDER BY productID DESC OFFSET ?*8 rows fetch next 8 rows only";
		
		
		
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeID);
			ps.setInt(2, categoryID);
			ps.setInt(3, indexp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setQuantity(rs.getInt(7));
				product.setSold(rs.getInt(8));
				product.setIsActive(rs.getBoolean(9));
				product.setIsSelling(rs.getBoolean(10));
				product.setCategoryId(rs.getInt(11));
				product.setStoreId(rs.getInt(12));
				product.setRating(rs.getFloat(13));
				product.setCreateProDate(rs.getString(14));
				product.setUpdateProDate(rs.getString(15));
				product.setImg(rs.getString(16));
				productList.add(product);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
		}
		
		return productList;
	}
	public void edit(int id) {
		String sql="UPDATE Products SET isActive=? WHERE productID=?";
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			
			if (get(id).getIsActive()==true)
				ps.setBoolean(1, false);
			else {
				ps.setBoolean(1, true);
			}
			
			
			ps.setInt(2,id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
}
