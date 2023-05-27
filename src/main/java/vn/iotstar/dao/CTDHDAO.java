package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.CT_DonHangModels;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.ProductModels;

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
	
	
	
	//Thêm mới
	public List<CT_DonHangModels> listProOfOrder(int orderid){
		List <CT_DonHangModels> list=new ArrayList<>();
		String sql="select [order].orderID, orderItem.productID, Products.name, orderItem.count, products.price*orderItem.count as gia \r\n"
				+ "from [order],orderItem, Products \r\n"
				+ "where [Order].orderID=orderItem.orderID and orderItem.productID=Products.productID\r\n"
				+ "and orderItem.orderID=?";
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, orderid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				CT_DonHangModels orderitem=new CT_DonHangModels();
				orderitem.setOrderid(rs.getInt(1));
				orderitem.setProductid(rs.getInt(2));
				orderitem.setProductName(rs.getString(3));
				orderitem.setCount(rs.getInt(4));
				orderitem.setGia(rs.getInt(5));
				list.add(orderitem);
				
				
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		
		
		return list;
	}
	
	
	
}

