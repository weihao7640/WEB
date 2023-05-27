package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import  vn.iotstar.model.CT_GHModels;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.GioHangModels;
import vn.iotstar.model.ProductsModels;

public class GioHangDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void themGH(int cartid,int productid,int sl)
	{
		String sql="insert into [dbo].[cartitem](cartID,productID,count,storeID) values(?,?,?,'1')";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cartid);
			ps.setInt(2, productid);
			ps.setInt(3, sl);
			
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public void updateGH(int cartid,int productid,int sl)
	{
		String sql="update [dbo].[cartitem] set count=?  where cartid=? and productid=?" ;
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(2, cartid);
			ps.setInt(3, productid);
			ps.setInt(1, sl);
			
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public void deleteGH(int cartid,int productid,int sl)
	{
		String sql="delete from [dbo].[cartitem]  where cartid=? and productid=?" ;
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cartid);
			ps.setInt(2, productid);
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public GioHangModels layGH(int user)
	{	
		
		String sql="select * from [dbo].[Cart] where userID=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, user);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new GioHangModels(rs.getInt(1),rs.getInt(2));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public CT_GHModels kiemtraGH(int idsp,int cartID)
	{	
		
		String sql="select * from Cartitem inner join Products on Cartitem.productid=Products.productid  where Cartitem.productID=? and cartId=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, idsp);
		ps.setInt(2, cartID);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new CT_GHModels(rs.getInt(1),rs.getInt(2),rs.getInt(4),rs.getString(8),rs.getInt(11),rs.getString(22));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public List<CT_GHModels> getAllGH(int user,int productID) {
		List<CT_GHModels> list = new ArrayList<>();
		String sql = "select * from Cartitem inner join Products on Cartitem.productid=Products.productid  where cartID=? and CartItem.ProductId=?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user);
			ps.setInt(2, productID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CT_GHModels(rs.getInt(1),rs.getInt(2),rs.getInt(4),rs.getString(8),rs.getInt(11),rs.getString(22)));
			}
		} catch (Exception e) {

		}
		return list;
	}
	public List<CT_GHModels> getAllGH(int user) {
		List<CT_GHModels> list = new ArrayList<>();
		String sql = "select * from Cartitem inner join Products on Cartitem.productid=Products.productid  where cartID=? ";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CT_GHModels(rs.getInt(1),rs.getInt(2),rs.getInt(4),rs.getString(8),rs.getInt(11),rs.getString(22)));
			}
		} catch (Exception e) {

		}
		return list;
	}
	
	public static void main(String[] args) {
		GioHangDAO dao = new GioHangDAO();
		List<CT_GHModels> list=new ArrayList<>();
		list=dao.getAllGH(16,13);
		for(CT_GHModels o:list)
		{
		System.out.print(o);
		}

	}
}
