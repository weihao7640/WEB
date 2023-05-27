package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.DiaCHi;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.UserModels;

public class DiachiDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<DiaCHi> getDiaChi(int  userid)
	{	
		List<DiaCHi> list = new ArrayList<>();
		String sql="select * from UserDiaChi where userid=?";

		try {
		conn=new DBConnection().getConnection();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, userid);
		rs=ps.executeQuery();
		while(rs.next())
		{
			list.add(new DiaCHi(rs.getInt(1),rs.getString(2)));
		}
		}
		catch(Exception e)
		{
			
		}
		return list;
	}
	public void ThemDiaChi(String pass,int id)
	{
		String sql="insert into  Userdiachi(Userid,DiaChi)  values(?,?)";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			
			ps.setString(2, pass);
			ps.setInt(1, id);
		
			ps.executeUpdate();
			
			}
			catch(Exception e)
			{
				
			}
	}
}
