package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.LicenseConfiguration;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.StoreModels;

public class StoreDAO extends DBConnection {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public StoreModels getStore(int id)
	{
		String sql="Select storeid, name, avatar, isOpen from Stores where storeID=?";
		try {
			Connection conn= new DBConnection().getConnection();
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				StoreModels store= new StoreModels();
				store.setStoreId(rs.getInt(1));
				store.setStoreName(rs.getString(2));
				store.setAvatar(rs.getString(3));
				store.setOpen(rs.getBoolean(4));
				return store;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}
public void editStore(StoreModels store, int id) {
		
	String sql="UPDATE Stores SET name=?,avatar=?, isOpen=?, updatedAt=? WHERE storeID=?";
	try {
		Connection conn= new DBConnection().getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,store.getStoreName());
		
		if (store.getAvatar()!=null)
		ps.setString(2, store.getAvatar());
		else {
			ps.setString(2, getStore(id).getAvatar());
		}
		ps.setBoolean(3, store.getOpen());
		ps.setString(4, LocalDate.now().toString());
		ps.setInt(5,id);
		ps.executeUpdate();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	
		
		
	}
	public List<StoreModels> getAll(){
		List <StoreModels> stores= new ArrayList<StoreModels>();
		String sql="select Stores.storeID,  Stores.name, Stores.ownerID, Stores.isActive, Stores.isOpen, Stores.avatar, Stores.point, Stores.rating, Stores.createdAt, Stores.updatedAt, Users.name from Stores inner join Users on Stores.ownerID=Users.userID";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				StoreModels store= new StoreModels();
				store.setStoreId(rs.getInt(1));
				store.setStoreName(rs.getString(2));
				store.setOwnerID(rs.getInt(3));
				store.setActive(rs.getBoolean(4));
				store.setOpen(rs.getBoolean(5));
				store.setAvatar(rs.getString(6));
				store.setPoint(rs.getInt(7));
				store.setRating(rs.getInt(8));
				store.setCreateAt(rs.getString(9));
				store.setUpdateAt(rs.getString(10));
				store.setOwnerName(rs.getString(11));
				stores.add(store);
			}
		} catch (Exception e) {

		}
		return stores;
		
		
		
	}
	
	public List<StoreModels> findAllPage(int indexp){
		List <StoreModels> stores= new ArrayList<StoreModels>();
		String sql="select Stores.storeID,  Stores.name, Stores.ownerID, Stores.isActive, Stores.isOpen, Stores.avatar, Stores.point, Stores.rating, Stores.createdAt, Stores.updatedAt, Users.name from Stores inner join Users on Stores.ownerID=Users.userID ORDER BY storeID DESC OFFSET ?*5 rows fetch next 5 rows only";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, indexp);
			rs = ps.executeQuery();
			while (rs.next()) {
				StoreModels store= new StoreModels();
				store.setStoreId(rs.getInt(1));
				store.setStoreName(rs.getString(2));
				store.setOwnerID(rs.getInt(3));
				store.setActive(rs.getBoolean(4));
				store.setOpen(rs.getBoolean(5));
				store.setAvatar(rs.getString(6));
				store.setPoint(rs.getInt(7));
				store.setRating(rs.getInt(8));
				store.setCreateAt(rs.getString(9));
				store.setUpdateAt(rs.getString(10));
				store.setOwnerName(rs.getString(11));
				stores.add(store);
			}
		} catch (Exception e) {

		}
		return stores;
		
		
		
	}
	
	public int countAll() {
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
	
	public StoreModels get(int id) {
		String sql="select Stores.storeID,  Stores.name, Stores.ownerID, Stores.isActive, Stores.isOpen, Stores.avatar, Stores.point, Stores.rating, Stores.createdAt, Stores.updatedAt, Users.name from Stores inner join Users on Stores.ownerID=Users.userID where storeID=?";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreModels store= new StoreModels();
				store.setStoreId(rs.getInt(1));
				store.setStoreName(rs.getString(2));
				store.setOwnerID(rs.getInt(3));
				store.setActive(rs.getBoolean(4));
				store.setOpen(rs.getBoolean(5));
				store.setAvatar(rs.getString(6));
				store.setPoint(rs.getInt(7));
				store.setRating(rs.getDouble(8));
				store.setCreateAt(rs.getString(9));
				store.setUpdateAt(rs.getString(10));
				store.setOwnerName(rs.getString(11));
				
					
	
					
			
				return store;	
					
					
			}		
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}
	
	
	

		
	public void edit(int id) {
		String sql="UPDATE Stores SET isActive=? WHERE StoreID=?";
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			
			if (get(id).getActive()==true)
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
	public void insert(String name,int id) {
		String sql="insert into Stores(name,ownerID,isActive,isOpen,point,rating,createdAt,updatedAt) values (?,?,?,?,?,?,?,?)";
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.setBoolean(3, true);
			ps.setBoolean(4, false);
			ps.setInt(5, 0);
			ps.setInt(6, 0);
			ps.setString(7, LocalDate.now().toString());
			ps.setString(8, LocalDate.now().toString());
			
			
			ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
	public void delete(int id)
	{
		String sql="UPDATE Stores SET isActive='false' where StoreID=?";
		
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	public List<StoreModels> getstore(int userid){
		List <StoreModels> stores= new ArrayList<StoreModels>();
		String sql="select * from Stores where ownerID=?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				StoreModels store= new StoreModels();
				store.setStoreId(rs.getInt(1));
				store.setStoreName(rs.getString(2));
				store.setOwnerID(rs.getInt(5));
				store.setActive(rs.getBoolean(6));
				store.setOpen(rs.getBoolean(7));
				store.setAvatar(rs.getString(8));
				store.setPoint(rs.getInt(9));
				store.setRating(rs.getInt(10));
				store.setCreateAt(rs.getString(12));
				store.setUpdateAt(rs.getString(13));
				stores.add(store);
			}
		} catch (Exception e) {

		}
		return stores;
		
		
		
	}
	public StoreModels getstore_SP(int userid){
		
		String sql="select * from Stores where storeID=?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				StoreModels store= new StoreModels();
				store.setStoreId(rs.getInt(1));
				store.setStoreName(rs.getString(2));
				store.setOwnerID(rs.getInt(5));
				store.setActive(rs.getBoolean(6));
				store.setOpen(rs.getBoolean(7));
				store.setAvatar(rs.getString(8));
				store.setPoint(rs.getInt(9));
				store.setRating(rs.getInt(10));
				store.setCreateAt(rs.getString(12));
				store.setUpdateAt(rs.getString(13));
			
				return store;
			}
			
		} catch (Exception e) {

		}
		return null;
		
		
		
	}
	public static void main(String[] args) {
		StoreDAO dao = new StoreDAO();
		StoreModels list=dao.getstore_SP(2);
		
			System.out.println(list);
		

	}
	
	
}
