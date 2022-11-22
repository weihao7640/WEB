package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connect.DBConnection;
import Model.CategoryModels;
import Model.DonHangModels;


public class DonHangDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<DonHangModels> getDH(int user)
	{	
		List<DonHangModels> list = new ArrayList<>();
		String sql="select * from [dbo].[Order] where userID=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, user);
		rs=ps.executeQuery();
		while(rs.next())
		{
			list.add(new DonHangModels(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(6),rs.getInt(7)));
		}
		}
		catch(Exception e)
		{
			
		}
		return list;
	}
	public DonHangModels curDH()
	{	
	
		String sql="select top 1 * from [dbo].[Order] Order by orderID DESC";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new DonHangModels(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(6),rs.getInt(7));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public void donhang(int userid,String address,String phone,int sum)
	{
		String sql="insert into [dbo].[Order](userID,address,phone,status,costSum) values(?,?,?,'Chưa Thanh toán',?)";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setInt(4, sum);
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public static void main(String[] args) {
		DonHangDAO dao = new DonHangDAO();
	dao.donhang(40, "Long an", "0911950859", 300);
	}
	}
