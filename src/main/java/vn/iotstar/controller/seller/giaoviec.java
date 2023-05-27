package vn.iotstar.controller.seller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.model.DonHangVM;
import vn.iotstar.model.StoreModels;

/**
 * Servlet implementation class giaoviec
 */
@WebServlet("/giaoviec")
public class giaoviec extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("/text/html;charset=UTF-8");
		 
		String idshipper = req.getParameter("chon");
		HttpSession session = req.getSession();
		int idst = (int) session.getAttribute("storeid");
		StoreDAO userDao= new StoreDAO();
		StoreModels admin= userDao.get(idst);
		req.setAttribute("store", admin);
		req.setAttribute("stid", idst);
		int idsh=Integer.parseInt(idshipper);
		req.setCharacterEncoding("UTF-8");
		int iddh=(int)session.getAttribute("iddh");
		DonHangDAO dhdao=new DonHangDAO();
		DonHangVM curdh=dhdao.DHstore(iddh);
		if(curdh.getStatus().equals("Đã đóng gói"))
		{
			dhdao.giao_DH(iddh, idsh);
		}
		session.removeAttribute("iddh");
		resp.sendRedirect("donhangseller");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
