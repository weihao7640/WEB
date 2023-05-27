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
import vn.iotstar.dao.ProductDAO;
import vn.iotstar.dao.ReviewDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.Theodoi_STDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.CT_DHVM;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.ProductsModels;
import vn.iotstar.model.Review;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserfollowModels;

/**
 * Servlet implementation class chitiet
 */
@WebServlet("/review")
public class review extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		 HttpSession session=request.getSession();
		 String content=request.getParameter("content");
		int id=(int)session.getAttribute("id");
		int iddh=(int)session.getAttribute("iddh");
		int sao=(int)session.getAttribute("sao");
		ReviewDAO rvdao=new ReviewDAO();
		DonHangDAO dhdao=new DonHangDAO();
		CT_DHVM dh=dhdao.ChitetDH(iddh);
		DonHangModels curdh=dhdao.CT_DHstore(iddh);
		rvdao.danhgia(id,dh.getProductID() , curdh.getStoreid(),iddh , content,sao);	
		Double ratingsptb=rvdao.ratingsp(dh.getProductID());
		Double ratingstoretb=rvdao.ratingst(curdh.getStoreid());
		System.out.println(ratingstoretb);
		ProductDAO prodao=new ProductDAO();
		System.out.println(curdh.getStoreid());
		prodao.rating(dh.getProductID(), (double) Math.round(ratingsptb * 10) / 10);
		UserDAO usdao=new UserDAO();
		usdao.ratingnd(curdh.getStoreid(), (double) Math.round(ratingstoretb * 10) / 10);
		
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
