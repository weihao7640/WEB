package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.CommentVM;
import vn.iotstar.model.Review;

public class ReviewDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void danhgia(int userid,int productID,int storeID, int orderID,String contents,int rating)
	{
		String sql="insert into Review(userID,ProductID,storeID,orderID,contents,rating,createdAt,updateAt) values(?,?,?,?,?,?,?,?)";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, productID);
			ps.setInt(3, storeID);
			ps.setInt(4, orderID);
			ps.setString(5, contents);
			ps.setInt(6, rating);
			ps.setString(7, LocalDate.now().toString());
			ps.setString(8, LocalDate.now().toString());
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public double ratingsp(int productID) {
		String sql = "select avg(rating) from Review where productID=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Double tong = rs.getDouble(1);
				return tong;
				}
				
			

		} catch (Exception e) {

		}
		return 0;
	}
	public int count_rv(int productID) {
		String sql = "select count(*) from Review where productID=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int tong = rs.getInt(1);
				return tong;
				}
				
			

		} catch (Exception e) {

		}
		return 0;
	}
	
public List<CommentVM>  ds_comment(int productID)
{
	List<CommentVM> list=new ArrayList<>();
	String sql = "select * from Review inner join Users on Review.userID=Users.userID where productID=?";
	try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		
		ps.setInt(1, productID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		list.add(new CommentVM(rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(2), rs.getInt(7), rs.getString(6),rs.getString(8),rs.getString(9), rs.getString(11), rs.getString(19)));
			}
			
		

	} catch (Exception e) {

	}
	return list;
}
public List<CommentVM>  ds_comment(int productID,int sao)
{
	List<CommentVM> list=new ArrayList<>();
	String sql = "select * from Review inner join Users on Review.userID=Users.userID where productID=? and rating=?";
	try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		
		ps.setInt(1, productID);
		ps.setInt(2, sao);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		list.add(new CommentVM(rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(2), rs.getInt(7), rs.getString(6),rs.getString(8),rs.getString(9), rs.getString(11), rs.getString(19)));
			}
			
		

	} catch (Exception e) {

	}
	return list;
}
public CommentVM  reviewed(int productID, int userID)
{
	String sql = "select * from Review inner join Users on Review.userID=Users.userID where orderID=?";
	try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		
		ps.setInt(1, productID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		return new CommentVM(rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(2), rs.getInt(7), rs.getString(6),rs.getString(8),rs.getString(9), rs.getString(11), rs.getString(19));
			}
			
		

	} catch (Exception e) {

	}
	return null;
}
public double ratingst(int storeID) {
	String sql = "select avg(rating) from Products where storeID=?";
	try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		
		ps.setInt(1, storeID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Double tong = rs.getDouble(1);
			return tong;
			}
			
		

	} catch (Exception e) {

	}
	return 0;
}

}
