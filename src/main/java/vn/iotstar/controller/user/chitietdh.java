package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.ReviewDAO;
import vn.iotstar.model.CT_DHVM;
import vn.iotstar.model.CommentVM;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.DonHangVM;

/**
 * Servlet implementation class chitietdh
 */
@WebServlet("/chitietdh")
public class chitietdh extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iddh = request.getParameter("iddh");
		HttpSession session = request.getSession();
		DonHangDAO dhdao = new DonHangDAO();
		int userid = (int) session.getAttribute("id");
		int id = Integer.parseInt(iddh);
		session.setAttribute("iddh", id);
		CT_DHVM dh = dhdao.ChitetDH(id);
		DonHangModels curdh = dhdao.CT_DHstore(id);
		ReviewDAO rvdao = new ReviewDAO();
		CommentVM check = rvdao.reviewed(id, userid);

		request.setAttribute("check", check);

		request.setAttribute("dh", dh);
		request.setAttribute("dh_HT", curdh);

		request.getRequestDispatcher("/view/user/ChitietDH.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
