package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connect.DBConnection;
import Model.DonHangModels;

public class CTDHDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void ctdonhang(int orderid,int productid,int sl)
	{
		String sql="insert into [dbo].[Orderitem](orderID,productID,count) values(?,?,?)";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, orderid);
			ps.setInt(2, productid);
			ps.setInt(3, sl);
			
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public static void main(String[] args) {
		CTDHDAO dao=new CTDHDAO();
		dao.ctdonhang(6, 12, 5);
	}
	
}

