package vn.iotstar.controller.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.CateDAO;
import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.KhachHang;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserModels;

@WebServlet("/khachhang")
public class khachhang extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("/text/html;charset=UTF-8");
		String trang = req.getParameter("id");
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("storeid");
		if (trang == null) {
			trang = "1";
		}
		int d = Integer.parseInt(trang);
		d = d * 10 - 10;
		UserDAO dao = new UserDAO();
		
		
		List<KhachHang> user_cur = dao.DS_khachhang(id,d);
	
			System.out.print(id);
		int sotrang=dao.countpage_KH(id);
		req.setAttribute("nhanvien", user_cur);
		req.setAttribute("sotrang", sotrang);
		req.setAttribute("stid", id);
		StoreDAO userDao= new StoreDAO();
		StoreModels admin= userDao.get(id);
		req.setAttribute("store", admin);
		req.getRequestDispatcher("/view/seller/danhsachNV.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
