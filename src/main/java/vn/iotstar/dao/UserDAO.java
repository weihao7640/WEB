package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.FollowModels;
import vn.iotstar.model.KhachHang;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.UserModels;

public class UserDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void DoiMk(String pass,int id)
	{
		String sql="update  Users set hash_password=? where UserID=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, pass);
			ps.setInt(2, id);
		
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public void ratingnd(int storeID ,Double rating)
	{
		String sql="update  Stores set rating=? where StoreID=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			
			ps.setInt(2,storeID);
			ps.setDouble(1, rating);
		
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public UserModels SosachId(String user,String pass)
	{	
		String sql="select * from Users where email=? and hash_password=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setString(1, user);
		ps.setString(2, pass);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new UserModels(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(11),rs.getInt(9));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public UserModels getAdmin(int id) {
		String sqlString="Select * from Users where userid=?";
		try {
			
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sqlString);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				UserModels user=new UserModels();
				user.setUserID(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setSalt(rs.getString(7));
				user.setHash_password(rs.getString(8));
				user.setPoint(rs.getInt(11));
				user.setAvatar(rs.getString(10));
				return user;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}

public void editAdmin(UserModels user, int id) {
		
		String sql="UPDATE Users SET name=?, phone=?, email=?, avatar=? WHERE userID=?";
		try {
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,user.getName());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getEmail());
			if (user.getAvatar()==null) ps.setString(4, getAdmin(id).getAvatar());
			else ps.setString(4, user.getAvatar());
			ps.setInt(5,id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

public void editStore(UserModels user, int id) {
	
	String sql="UPDATE Users SET name=?,avatar=? WHERE storeID=?";
	try {
		Connection conn= new DBConnection().getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,user.getName());
		ps.setString(2, user.getAvatar());
		ps.setInt(3,id);
		ps.executeUpdate();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	
}

public UserModels admin_login(String email, String pass) {
	String sqlString="Select * from Users where email=? and hash_password=? and role=3";
	try {
		
		Connection conn=new DBConnection().getConnection();
		PreparedStatement ps= conn.prepareStatement(sqlString);
		ps.setString(1,email);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			UserModels user=new UserModels();
			user.setUserID(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setPhone(rs.getString(4));
			user.setSalt(rs.getString(7));
			user.setHash_password(rs.getString(8));
			user.setPoint(rs.getInt(11));
			user.setAvatar(rs.getString(10));
			return user;
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	return null;
}

	public UserModels SosachMK(String user)
	{	
		String sql="select * from Users where hash_password=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setString(1, user);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new UserModels(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(11),rs.getInt(9));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public UserModels Sosachuser(String user)
	{	
		String sql="select * from Users where email=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setString(1, user);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new UserModels(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(11),rs.getInt(9));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public UserModels Sosachsdt(String sdt)
	{	
		String sql="select * from Users where phone=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setString(1, sdt);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new UserModels(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(11),rs.getInt(9));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public void dangky(String email,String pass,String name,String sdt,String salt)
	{
		String sql="insert into Users(email,hash_password,name,phone,salt,point,role) values(?,?,?,?,?,'0','1')";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setString(4, sdt);
			ps.setString(5, salt);
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public void themshipper(String email,String pass,String name,String sdt,String salt)
	{
		String sql="insert into Users(email,hash_password,name,phone,salt,point,role) values(?,?,?,?,?,'0','2')";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setString(4, sdt);
			ps.setString(5, salt);
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public void taoGH(int i)
	{
		String sql="insert into Cart(userID) values(?)";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, i);
			
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public UserModels Sosachuser2(int user)
	{	
		String sql="select * from Users where userID=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, user);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new UserModels(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(11),rs.getInt(9));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	
	public int countAll()
	{
		String sqlString="select count(*) from Users";
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sqlString);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}
	public List<UserModels> findAllPage (int indexp){
		List<UserModels> userList = new ArrayList<UserModels>();
		String sql = "SELECT * FROM Users ORDER BY userID DESC OFFSET ?*5 rows fetch next 5 rows only";
		try {
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, indexp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModels user=new UserModels();
				user.setUserID(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setSalt(rs.getString(7));
				user.setRole(rs.getInt(9));
				user.setHash_password(rs.getString(8));
				user.setPoint(rs.getInt(11));
				user.setAvatar(rs.getString(10));
				userList.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return userList;
		
		
		
		
	}
	
	public UserModels get(int id)
	{
		String sql="Select * from Users where userID=?";
		try {
			
			Connection conn=new DBConnection().getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				UserModels user=new UserModels();
				user.setUserID(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setSalt(rs.getString(7));
				user.setHash_password(rs.getString(8));
				user.setPoint(rs.getInt(11));
				user.setAvatar(rs.getString(10));
				return user;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	public List<UserModels> DS_shipper()
	{
		List<UserModels> users=new ArrayList<>();
		String sql="Select * from Users where role='2'";
		try {
			
			Connection conn=new DBConnection().getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				UserModels user=new UserModels();
				user.setUserID(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setSalt(rs.getString(7));
				user.setHash_password(rs.getString(8));
				user.setPoint(rs.getInt(11));
				user.setAvatar(rs.getString(10));
				users.add(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return users;
	}
	
	public List<KhachHang> DS_khachhang(int storeID,int trang)
	{
		List<KhachHang> users=new ArrayList<>();
		String sql="select * from Users inner join UserFollowStore on Users.userID=UserFollowStore.userID where storeID=? ORDER BY storeID DESC OFFSET ? rows fetch next 10 rows only";
		try {
			
			Connection conn=new DBConnection().getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeID);
			ps.setInt(2, trang);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				KhachHang user=new KhachHang(rs.getString(2), rs.getString(3), rs.getString(4));
				users.add(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return users;
	}
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		List<KhachHang> kh=new ArrayList<>();
		//kh=dao.DS_khachhang(2);
		for(KhachHang o:kh)
		{
			System.out.print(o);
		}

	}
	public int countpage_KH(int id) {
		String sql = "select count(*) from [UserFollowStore] where StoreID=?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
	public int getStoreID(int userid) {
		String sql="select storeID from Stores where ownerID=?";
		
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,userid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}
/////Thêm mới nè
	public List<FollowModels> getListFollow(int id, int indexp)
	{
		List<FollowModels> list=new ArrayList<>();
		String sql="select Stores.avatar,Stores.storeID, Stores.name, UserFollowStore.isDeleted from Users, UserFollowStore,Stores  where Users.userID=UserFollowStore.userID and Stores.storeID=UserFollowStore.storeID and Users.userID=? and UserFollowStore.isDeleted='false' ORDER BY UserFollowStore.updatedAt DESC OFFSET ?*10 rows fetch next 10 rows only";
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, indexp);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				FollowModels fl=new FollowModels();
				fl.setStoreid(rs.getInt(2));
				fl.setStoreName(rs.getString(3));
				fl.setAvatar(rs.getString(1));
				fl.setIsDeleted(rs.getBoolean(4));
				
				list.add(fl);			
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return list;
	}
	
	public int countListFollow(int id) {
		String sql="select  count(*) from Users, UserFollowStore,Stores  where Users.userID=UserFollowStore.userID and Stores.storeID=UserFollowStore.storeID and Users.userID=? and UserFollowStore.isDeleted='false'";
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
		
	}
	public void unfollow(int userid, int storeid) {
		String sql=" UPDATE UserFollowStore SET isDeleted='true' where userid=? and storeid=?";
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, storeid);
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
}
