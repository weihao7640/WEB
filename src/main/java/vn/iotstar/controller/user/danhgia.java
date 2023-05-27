package vn.iotstar.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DAO;
import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.Theodoi_STDAO;
import vn.iotstar.model.CT_DHVM;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.ProductsModels;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserfollowModels;

/**
 * Servlet implementation class chitiet
 */
@WebServlet("/danhgia")
public class danhgia extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 HttpSession session=request.getSession();
		String sao = request.getParameter("sao");
		int id=(int)session.getAttribute("iddh");
		DonHangDAO dhdao=new DonHangDAO();
		CT_DHVM dh=dhdao.ChitetDH(id);
		int sao1=Integer.parseInt(sao);
		session.setAttribute("sao", sao1);
		DonHangModels curdh=dhdao.CT_DHstore(id);
		request.setAttribute("dh", dh);
		request.setAttribute("dh_HT", curdh);
		request.setAttribute("sao", sao);
		  request.getRequestDispatcher("/view/user/ChitietDH.jsp").forward(request, response);
		


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
