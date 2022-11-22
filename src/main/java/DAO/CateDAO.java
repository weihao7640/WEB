package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connect.DBConnection;
import Model.CategoryModels;
import Model.ProductsModels;

public class CateDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<CategoryModels> getAllcate() {
		List<CategoryModels> list = new ArrayList<>();
		String sql = "select * from Category";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CategoryModels(rs.getInt(1), rs.getString(2), rs.getString(4)));
			}
		} catch (Exception e) {

		}
		return list;
	}
	public static void main(String[] args) {
		CateDAO dao = new CateDAO();
		List<CategoryModels> list = dao.getAllcate();
		for (CategoryModels o : list) {
			System.out.println(o);
		}

	}
}
