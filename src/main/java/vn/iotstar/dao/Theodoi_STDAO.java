package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.UserfollowModels;


public class Theodoi_STDAO extends DBConnection{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;


	
	public void theodoi(int userid,int storeid) {
		String sql="INSERT INTO UserFollowStore(userid,storeid,isDeleted,createdAt,updatedAt) VALUES (?,?,?,?,?)";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, storeid);
			ps.setBoolean(3, true);
			ps.setString(4, LocalDate.now().toString());
			ps.setString(5, LocalDate.now().toString());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void huytheodoi(int userid,int storeid) {
		String sql="Delete from UserFollowStore  where userID=? and storeID=? ";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, storeid);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public UserfollowModels check_theodoi(int userid,int storeid) {
		String sql="select * from UserFollowStore where userID=? and storeID=?";
		try {
			Connection conn=super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, storeid);
			ResultSet rs = ps.executeQuery();
			
			UserfollowModels usmodels=new UserfollowModels();
			while (rs.next()) {
			usmodels.setUserid(rs.getInt(2));
			usmodels.setStoreid(rs.getInt(3));
			usmodels.setIsdeleted(rs.getBoolean(4));
			usmodels.setNgaytg(rs.getString(5));
			usmodels.setNgayup(rs.getString(6));
			
			}
			return usmodels;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public int count_NTD(int storeid) {
		String sql = "select count(userID) from UserFollowStore where storeID=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, storeid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int tong = rs.getInt(1);
				
				
				return tong;
			}

		} catch (Exception e) {

		}
		return 0;
	}
	public int count_SP(int storeid) {
		String sql = "select count(ProductID) from Products where storeID=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, storeid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int tong = rs.getInt(1);
				
				
				return tong;
			}

		} catch (Exception e) {

		}
		return 0;
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
	
	
	
	
	
}
