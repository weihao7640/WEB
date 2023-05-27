package vn.iotstart.controller.shipper;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.DonHangVM;
import vn.iotstar.model.UserModels;

@WebServlet("/ChitietDHshipper")
public class Chitietdonhang extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("/text/html;charset=UTF-8");

		req.setCharacterEncoding("UTF-8");
		 HttpSession session=req.getSession();
		String id = req.getParameter("iddh");
		
		DonHangDAO dhdao = new DonHangDAO();
		int c = Integer.parseInt(id);
		session.setAttribute("iddh", c);
		DonHangVM dh_cur = dhdao.DHstore(c);
		UserDAO dao = new UserDAO();

		List<UserModels> user_cur = dao.DS_shipper();

		req.setAttribute("nhanvien", user_cur);
		req.setAttribute("dh", dh_cur);
		req.getRequestDispatcher("/view/shipper/ChiTietDH.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
