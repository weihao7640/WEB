package vn.iotstar.dao;

import java.security.spec.PSSParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.CT_DHVM;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.DonHangVM;
import vn.iotstar.model.ProductsModels;


public class DonHangDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
public int countTT(int tt) {
		
		String sqlString="select count(*) from [Order] where status=?";
		try {
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sqlString);
			ps.setInt(1, tt);
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()) {
				return rSet.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
		
	}
	
	public List<DonHangModels> findLocTT(int indexp, int tt)
	{
		List <DonHangModels> orderList= new ArrayList<DonHangModels>();
		String sql="Select * from [Order],Users where [Order].userid=Users.userid and [Order].status=? ORDER BY orderID DESC OFFSET ?*10 rows fetch next 10 rows only";
		
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, tt);
			ps.setInt(2, indexp);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				DonHangModels order= new DonHangModels();
				order.setOderid(rs.getInt(1));
				order.setUserid(rs.getInt(2));
				order.setStoreid(rs.getInt(3));
				order.setDiachi(rs.getString(4));
				order.setTrangthai(rs.getString(7));
				order.setStatusTT(rs.getString(6));
				order.setPhone(rs.getString(5));
				order.setNgaynhap(rs.getString(10));
				order.setNgayup(rs.getString(11));
				order.setTong(rs.getInt(9));
				order.setShipperid(rs.getInt(8));
				order.setUsersName(rs.getString(13));
				orderList.add(order);		
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return orderList;
	}
	
	
	public List<DonHangModels> getDH(int user ,int trang)
	{	
		List<DonHangModels> list = new ArrayList<>();
		String sql="select * from [dbo].[Order] where userID=?  ORDER BY orderID DESC OFFSET ? rows fetch next 6 rows only";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, user);
		ps.setInt(2, trang);
		rs=ps.executeQuery();
		while(rs.next())
		{
			list.add( new DonHangModels(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(6),rs.getInt(8),rs.getString(5),rs.getString(7),rs.getInt(9),rs.getString(10),rs.getString(11)));
		}
		}
		catch(Exception e)
		{
			
		}
		return list;
	}
	public int countpage_user(int id)
	{
	String sqlString="select count(*) from [Order] where userID=?";
		try {
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sqlString);
			ps.setInt(1, id);
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()) {
				int tong= rSet.getInt(1);
				
				int sotrang = 0;
				sotrang = tong / 6;
				if (tong % 6 != 0) {
					sotrang++;
				}
				return sotrang;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
	}
	
	public int countpage_shipper(int id)
	{
	String sqlString="select count(*) from [Order] where shipperID=?";
		try {
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sqlString);
			ps.setInt(1, id);
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()) {
				int tong= rSet.getInt(1);
				
				int sotrang = 0;
				sotrang = tong / 6;
				if (tong % 6 != 0) {
					sotrang++;
				}
				return sotrang;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
	}
	
	public DonHangModels layDH(int user)
	{	
		
		String sql="select * from [dbo].[Order] where userID=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, user);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new DonHangModels(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(6),rs.getInt(8),rs.getString(5),rs.getString(7),rs.getInt(9),rs.getString(10),rs.getString(11));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
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
			return new DonHangModels(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(6),rs.getInt(8),rs.getString(5),rs.getString(7),rs.getInt(9),rs.getString(10),rs.getString(11));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	
	public void donhang(int userid,String address,String phone,int sum,int storeID)
	{
		String sql="insert into [dbo].[Order](userID,address,phone,status,statusTT,costSum,StoreID,createdAt,updatedAt) values(?,?,?,N'Chưa xác nhận',N'Chưa thanh toán',?,?,?,?)";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setInt(4, sum);
			ps.setInt(5, storeID);
			ps.setString(6, LocalDate.now().toString());
			ps.setString(7 ,LocalDate.now().toString());
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public void xacnhan_DH(int userID)
	{
		String sql="update [order] set status=N'Đã xác nhận' where orderID=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userID);
			
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public void huy(int userID)
	{
		String sql="update [order] set status=N'Đã hủy' where orderID=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userID);
			
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public void giao_DH(int userID,int idshipper)
	{
		String sql="update [order] set status=N'Đang giao',shipperID=? where orderID=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(2, userID);
			ps.setInt(1, idshipper);
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public void dagiao_DH(int userID)
	{
		String sql="update [order] set status=N'Đã giao' where orderID=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userID);
			
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public void donggoi_DH(int userID)
	{
		String sql="update [order] set status=N'Đã đóng gói' where orderID=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userID);
			
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
	public static void main(String[] args) {
		 DonHangDAO dao=new DonHangDAO();
		
	}
	
	
	
	public int countAll()
	{
		String sqlString="select count(*) from [Order]";
		try {
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sqlString);
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()) {
				return rSet.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
	}
	
	public int countOrderOfUser(int id)
	{
		String sqlString="select count(*) from [Order] where userID=?";
		try {
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sqlString);
			ps.setInt(1, id);
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()) {
				return rSet.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
		
		
	}
	public int countpage_DH(int id) {
		String sql = "select count(*) from [Order] where StoreID=?";
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
	public int countpage_DH(int id,String TT) {
		String sql = "select count(*) from [Order] where StoreID=? and status=?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, TT);
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
	public List<DonHangVM> getGH_ST(int id,int cate) {
		List<DonHangVM> list = new ArrayList<>();
		String sql = "with b1\r\n"
				+ "as\r\n"
				+ "(select [Order].orderID, Users.name,Stores.name as nameStore, [Order].address,[Order].storeID, [Order].phone, [Order].statusTT, [Order].status, [Order].costSum, [Order].createdAt, [Order].updatedAt, [Order].shipperID \r\n"
				+ "from (Users left join [Order]\r\n"
				+ "on Users.userID=[Order].userID ) inner join Stores on [Order].storeID=Stores.storeID\r\n"
				+ ")\r\n"
				+ "select b1.orderID, b1.name, b1.nameStore, b1.address, b1.phone, b1.statusTT, b1.status, b1.costSum,\r\n"
				+ "b1.createdAt, b1.updatedAt, Users.name as nameShipper\r\n"
				+ "from b1 left join Users\r\n"
				+ "on b1.shipperID=Users.userID\r\n"
				+ "where storeID=? \r\n"
				+ "ORDER BY orderID OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";

		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, cate);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHangVM(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(11)));
			}
		} catch (Exception e) {

		}
		return list;

	}
	public List<DonHangVM> getGH_ST(int id,int cate,String TT) {
		List<DonHangVM> list = new ArrayList<>();
		String sql = "with b1\r\n"
				+ "as\r\n"
				+ "(select [Order].orderID, Users.name,Stores.name as nameStore, [Order].address,[Order].storeID, [Order].phone, [Order].statusTT, [Order].status, [Order].costSum, [Order].createdAt, [Order].updatedAt, [Order].shipperID \r\n"
				+ "from (Users left join [Order]\r\n"
				+ "on Users.userID=[Order].userID ) inner join Stores on [Order].storeID=Stores.storeID\r\n"
				+ ")\r\n"
				+ "select b1.orderID, b1.name, b1.nameStore, b1.address, b1.phone, b1.statusTT, b1.status, b1.costSum,\r\n"
				+ "b1.createdAt, b1.updatedAt, Users.name as nameShipper\r\n"
				+ "from b1 left join Users\r\n"
				+ "on b1.shipperID=Users.userID\r\n"
				+ "where storeID=? and status=?\r\n"
				+ "ORDER BY orderID OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";

		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, TT);
			ps.setInt(3, cate);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHangVM(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(11)));
			}
		} catch (Exception e) {

		}
		return list;

	}
	public List<DonHangVM> getDH_shipper(int id,int cate) {
		List<DonHangVM> list = new ArrayList<>();
		String sql = "with b1\r\n"
				+ "as\r\n"
				+ "(select [Order].orderID, Users.name,Stores.name as nameStore, [Order].address,[Order].storeID, [Order].phone, [Order].statusTT, [Order].status, [Order].costSum, [Order].createdAt, [Order].updatedAt, [Order].shipperID \r\n"
				+ "from (Users inner join [Order]\r\n"
				+ "on Users.userID=[Order].userID ) inner join Stores on [Order].storeID=Stores.storeID\r\n"
				+ ")\r\n"
				+ "select b1.orderID, b1.name, b1.nameStore, b1.address, b1.phone, b1.statusTT, b1.status, b1.costSum,\r\n"
				+ "b1.createdAt, b1.updatedAt, Users.name as nameShipper\r\n"
				+ "from b1 inner join Users\r\n"
				+ "on b1.shipperID=Users.userID\r\n"
				+ "where shipperID=? \r\n"
				+ "ORDER BY orderID OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";

		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, cate);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHangVM(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(11)));
			}
		} catch (Exception e) {

		}
		return list;

	}
	public List<DonHangModels> findAllOrderOfUser(int userId,int indexp)
	{
		List <DonHangModels> orderList= new ArrayList<DonHangModels>();
		String sql="Select * from [Order] where userID=? ORDER BY orderID DESC OFFSET ?*10 rows fetch next 10 rows only";
		
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, indexp);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				DonHangModels order= new DonHangModels();
				order.setOderid(rs.getInt(1));
				order.setUserid(rs.getInt(2));
				order.setStoreid(rs.getInt(3));
				order.setDiachi(rs.getString(4));
				order.setTrangthai(rs.getString(7));
				order.setStatusTT(rs.getString(6));
				order.setPhone(rs.getString(5));
				order.setNgaynhap(rs.getString(10));
				order.setNgayup(rs.getString(11));
				order.setTong(rs.getInt(9));
				order.setShipperid(rs.getInt(8));
				orderList.add(order);		
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return orderList;
	}
	public int countDH(int id)
	{
		String sqlString="select count(*) from [Order] where storeID=?";
		try {
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sqlString);
			ps.setInt(1, id);
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()) {
				return rSet.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
		
		
	}
	public int doanhthu_T(int storeID,int thang)
	{
		String sqlString="select sum(costSum) from [order] where MONTH(createdAt)=? and storeID=?";
		try {
			Connection conn= new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sqlString);
			ps.setInt(1, thang);
			ps.setInt(2, storeID);
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()) {
				return rSet.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
		
		
	}
	public DonHangModels CT_DHstore(int id)
	{	
	
		String sql="select * from [dbo].[Order] where orderID=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new DonHangModels(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(6),rs.getInt(8),rs.getString(5),rs.getString(7),rs.getInt(9),rs.getString(10),rs.getString(11));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public DonHangVM DHstore(int id)
	{	
	
		String sql="with b1\r\n"
				+ "as\r\n"
				+ "(select [Order].orderID, Users.name,Stores.name as nameStore, [Order].address, [Order].phone, [Order].statusTT, [Order].status, [Order].costSum, [Order].createdAt, [Order].updatedAt, [Order].shipperID \r\n"
				+ "from (Users left join [Order]\r\n"
				+ "on Users.userID=[Order].userID ) inner join Stores on [Order].storeID=Stores.storeID\r\n"
				+ ")\r\n"
				+ "select b1.orderID, b1.name, b1.nameStore, b1.address, b1.phone, b1.statusTT, b1.status, b1.costSum,\r\n"
				+ "b1.createdAt, b1.updatedAt, Users.name as nameShipper\r\n"
				+ "from b1 left join Users\r\n"
				+ "on b1.shipperID=Users.userID\r\n"
				+ "where orderID=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new DonHangVM(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(11));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public CT_DHVM ChitetDH(int id)
	{	
	
		String sql="select * from [dbo].[Orderitem] inner join Products on [Orderitem].productID=Products.productID where orderID=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs=ps.executeQuery();
		while(rs.next())
		{
			return new CT_DHVM(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(7));
		}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	
	public List<DonHangModels> findAllPage(int indexp)
	{
		List <DonHangModels> orderList= new ArrayList<DonHangModels>();
		String sql="Select * from [Order],Users where [Order].userid=Users.userid ORDER BY orderID DESC OFFSET ?*10 rows fetch next 10 rows only";
		
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, indexp);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				DonHangModels order= new DonHangModels();
				order.setOderid(rs.getInt(1));
				order.setUserid(rs.getInt(2));
				order.setStoreid(rs.getInt(3));
				order.setDiachi(rs.getString(4));
				order.setTrangthai(rs.getString(7));
				order.setStatusTT(rs.getString(6));
				order.setPhone(rs.getString(5));
				order.setNgaynhap(rs.getString(10));
				order.setNgayup(rs.getString(11));
				order.setTong(rs.getInt(9));
				order.setShipperid(rs.getInt(8));
				order.setUsersName(rs.getString(13));
				orderList.add(order);		
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return orderList;
	}
	
	
	
	//thêm mới
	//lấy thông tin đơn hàng
	public DonHangModels getOrder(int orderid) {
		DonHangModels order=new DonHangModels();
		String sql="with b1\r\n"
				+ "as\r\n"
				+ "(select [Order].orderID,[Order].userID,[Order].storeID, Users.name,Stores.name as nameStore, [Order].address, [Order].phone, [Order].statusTT, [Order].status, [Order].costSum, [Order].createdAt, [Order].updatedAt, [Order].shipperID \r\n"
				+ "from (Users inner join [Order]\r\n"
				+ "on Users.userID=[Order].userID ) inner join Stores on [Order].storeID=Stores.storeID\r\n"
				+ ")\r\n"
				+ "select b1.orderID,b1.userid, b1.name,b1.storeid, b1.nameStore, b1.address, b1.phone, b1.statusTT, b1.status, b1.costSum,\r\n"
				+ "b1.createdAt, b1.updatedAt,b1.shipperID, Users.name as nameShipper\r\n"
				+ "from b1 inner join Users\r\n"
				+ "on b1.shipperID=Users.userID\r\n"
				+ "where b1.orderID=?";
		try {
			Connection conn=new DBConnection().getConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, orderid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				order.setOderid(rs.getInt(1));
				order.setUserid(rs.getInt(2));
				order.setUsersName(rs.getString(3));
				order.setStoreid(rs.getInt(4));
				order.setStoreName(rs.getString(5));
				order.setDiachi(rs.getString(6));
				order.setPhone(rs.getString(7));
				order.setStatusTT(rs.getString(8));
				order.setTrangthai(rs.getString(9));
				order.setTong(rs.getInt(10));
				order.setNgaynhap(rs.getString(11));
				order.setNgayup(rs.getString(12));
				order.setShipperid(rs.getInt(13));
				order.setShipperName(rs.getString(14));
				return order;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	
	
}
