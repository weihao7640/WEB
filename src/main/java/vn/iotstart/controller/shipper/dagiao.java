package vn.iotstart.controller.shipper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.model.DonHangVM;

/**
 * Servlet implementation class dagiao
 */
@WebServlet("/dagiao")
public class dagiao extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("/text/html;charset=UTF-8");
		String id = req.getParameter("iddh");
		req.setCharacterEncoding("UTF-8");
		int iddh=Integer.parseInt(id);
		DonHangDAO dhdao=new DonHangDAO();
		DonHangVM curdh=dhdao.DHstore(iddh);
		if(curdh.getStatus().equals("Đang giao"))
		{
			dhdao.dagiao_DH(iddh);
		}
		resp.sendRedirect("homeshipper");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
