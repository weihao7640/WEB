package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.GioHangDAO;
import vn.iotstar.model.CT_GHModels;
import vn.iotstar.model. GioHangModels;

/**
 * Servlet implementation class XoaItemCart
 */
@WebServlet("/Xoaitemcart")
public class XoaItemCart extends HttpServlet {

       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		GioHangDAO ghdao=new GioHangDAO();
		String idsp=request.getParameter("idsp");
		int id_SP=Integer.parseInt(idsp);
		HttpSession session=request.getSession();
		 int user= (int)session.getAttribute("id");
		 GioHangModels curGH=ghdao.layGH(user);
		 List<CT_GHModels> listgh;
		 ghdao.deleteGH(curGH.getCartID(), id_SP, user);
		 listgh=ghdao.getAllGH(curGH.getCartID());
		 
		
		
		request.setAttribute("listgh", listgh);
		request.getRequestDispatcher("/view/user/GioHang.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
