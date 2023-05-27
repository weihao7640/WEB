package vn.iotstart.controller.shipper;
import vn.iotstar.dao.CateDAO;
import vn.iotstar.dao.DAO;
import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.ProductDAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.DonHangVM;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.ProductsModels;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "Homeshipper", urlPatterns = {"/homeshipper"})
public class Homesellercontroller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 resp.setContentType("/text/html;charset=UTF-8");
			String trang = req.getParameter("id");
			req.setCharacterEncoding("UTF-8");

			HttpSession session = req.getSession();
			int id = (int) session.getAttribute("idshipper");
			if (trang == null) {
				trang = "1";
			}
			int d = Integer.parseInt(trang);
			d = d * 10 - 10;
			DonHangDAO dao = new DonHangDAO();
			System.out.println(d);
			int sotrang = dao.countpage_shipper(id);
			List<DonHangVM> user_cur = dao.getDH_shipper(id, d);
			
			req.setAttribute("donhang", user_cur);
			req.setAttribute("sotrang", sotrang);

	 	 req.getRequestDispatcher("/view/shipper/shipperhome.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	

}
