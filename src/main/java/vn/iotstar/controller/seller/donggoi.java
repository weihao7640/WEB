package vn.iotstar.controller.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.DonHangVM;
import vn.iotstar.model.StoreModels;

@WebServlet("/donggoi")
public class donggoi extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("/text/html;charset=UTF-8");
		String id = req.getParameter("iddh");
		req.setCharacterEncoding("UTF-8");
		int iddh=Integer.parseInt(id);
		DonHangDAO dhdao=new DonHangDAO();
		DonHangVM curdh=dhdao.DHstore(iddh);
		HttpSession session = req.getSession();
		int idst = (int) session.getAttribute("storeid");
		StoreDAO userDao= new StoreDAO();
		StoreModels admin= userDao.get(idst);
		req.setAttribute("store", admin);
		req.setAttribute("stid", idst);
		if(curdh.getStatus().equals("Đã xác nhận"))
		{
			dhdao.donggoi_DH(iddh);
		}
		resp.sendRedirect("donhangseller");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
