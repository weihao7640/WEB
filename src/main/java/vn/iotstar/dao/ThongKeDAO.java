package vn.iotstar.dao;

import java.security.spec.PSSParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.exceptions.RSAException;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.StoreModels;

public class ThongKeDAO extends DBConnection {
	public int[] getThongKeTheoThang(int year, int id) {
		int[] months = new int[12];

		String sql = "select sum(costSum), MONTH(createdAt) from [Order] where storeid=? and YEAR(createdAt)=? group by MONTH(createdAt) order by MONTH(createdAt)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2,year);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				int mm = 0;
				int getmonth = rs.getInt(2);
				Boolean setBoolean = false;
				while (setBoolean == false) {
					if (getmonth == i+1) {
						mm = rs.getInt(1);
						months[i] = mm;
						i++;
						setBoolean=true;
					} else {
						mm = 0;
						months[i] = mm;
						i++;
						setBoolean=false;
					}
				}
			}

		} catch (Exception e) {

		}

		return months;
	}
	public int[] getThongKeTheoThang(int year) {
		int[] months = new int[12];

		String sql = "select sum(costSum), MONTH(updatedAt) from [Order] where YEAR(updatedAt)=? group by MONTH(updatedAt) order by MONTH(updatedAt)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, year);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				int mm = 0;
				int getmonth = rs.getInt(2);
				Boolean setBoolean = false;
				while (setBoolean == false) {
					if (getmonth == i+1) {
						mm = rs.getInt(1);
						months[i] = mm;
						i++;
						setBoolean=true;
					} else {
						mm = 0;
						months[i] = mm;
						i++;
						setBoolean=false;
					}
				}
			}

		} catch (Exception e) {

		}

		return months;
	}

	public List<ProductModels> getTop10Products(int year){
		List<ProductModels> products=new ArrayList<>();
		String sqlString="select Products.productID, Products.name, Products.price, Products.sold, Products.categoryID, Products.storeID, Products.img, Category.name, Stores.name from Products,Stores,Category where Products.storeID=Stores.storeID and Products.categoryID=Category.categoryID and YEAR(Products.updatedAt)=YEAR(GETDATE()) order by sold DESC OFFSET 0 rows fetch next 10 rows only";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps=conn.prepareStatement(sqlString);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductModels product= new ProductModels();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setSold(rs.getInt(4));
				product.setCategoryId(rs.getInt(5));
				product.setStoreId(rs.getInt(6));
				product.setImg(rs.getString(7));
				product.setNameStore(rs.getString(9));
				product.setNameCategory(rs.getString(8));
				products.add(product);				
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return products;
	}
	
	public List<StoreModels> getTop8Store(int year){
		List<StoreModels> stores= new ArrayList<>();
		String sqlString="with b1\r\n"
				+ "as\r\n"
				+ "(\r\n"
				+ "	select sum(costsum) as sumcost, storeid\r\n"
				+ "	from [order]\r\n"
				+ "	where Year(updatedAt)=year(getdate())\r\n"
				+ "	group by storeid\r\n"
				+ "\r\n"
				+ ")\r\n"
				+ "select stores.storeID, Stores.name, Stores.ownerID, Users.name, b1.sumcost\r\n"
				+ "from b1, stores,users\r\n"
				+ "where b1.storeID=Stores.storeID and  stores.ownerID=Users.userID\r\n"
				+ "";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps=conn.prepareStatement(sqlString);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				StoreModels store=new StoreModels();
				store.setStoreId(rs.getInt(1));
				store.setStoreName(rs.getString(2));
				store.setOwnerID(rs.getInt(3));
				store.setOwnerName(rs.getString(4));
				store.setSumCost(rs.getInt(5));
				stores.add(store);
				
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		return stores;
	}
	
	
	public int countstore() {
		String sql="select count(*) from Stores";
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
	public int countusers() {
		String sql="select count(*) from users";
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
	public int countOrderOfMonth() {
		String sql="select count(*) from [order] where month(updatedAt)=month(getdate()) and YEAR(updatedAt)=YEAR(getDAte())";
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
	public int sumOfMonth() {
		String sql="select sum(costsum) from [order] where Month(updatedAt)=month(getdate()) and YEAR(updatedAt)=YEAR(getDAte())";
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
	
}
