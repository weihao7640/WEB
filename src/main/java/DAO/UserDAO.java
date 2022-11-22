package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Connect.DBConnection;
import Model.ProductsModels;
import Model.UserModels;

public class UserDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
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
			return new UserModels(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(11));
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
			return new UserModels(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(11));
		}
		}
		catch(Exception e)
		{
			
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
			return new UserModels(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(11));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
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
			return new UserModels(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(11));
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
			return new UserModels(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(10),rs.getInt(11));
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
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		
		System.out.print(dao.Sosachuser2(40));
	}

}
