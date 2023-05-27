package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DAO;
import vn.iotstar.dao.GioHangDAO;
import vn.iotstar.model.CT_GHModels;
import vn.iotstar.model.GioHangModels;
import vn.iotstar.model.ProductsModels;

/**
 * Servlet implementation class GioHang
 */
@WebServlet("/GioHang")
public class GioHang extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		GioHangDAO ghdao=new GioHangDAO();
		String idsp=request.getParameter("idsp");
		int id_SP=Integer.parseInt(idsp);
		HttpSession session=request.getSession();
		int user=0;
		try {
			 user= (int)session.getAttribute("id");
			 GioHangModels curGH=ghdao.layGH(user);
			 List<CT_GHModels> listgh;
			 System.out.print(ghdao.kiemtraGH(id_SP,curGH.getCartID()));
			 if(ghdao.kiemtraGH(id_SP,curGH.getCartID())==null)
			 {
				 ghdao.themGH(curGH.getCartID(),id_SP, 1);
				 listgh=ghdao.getAllGH(curGH.getCartID());
			 }
			 else
			 {
				 int sl=ghdao.kiemtraGH(id_SP,curGH.getCartID()).getCount();
				 ghdao.updateGH(curGH.getCartID(),id_SP, sl+1);
				  listgh=ghdao.getAllGH(curGH.getCartID());
			 }
			
			
			request.setAttribute("listgh", listgh);
			request.getRequestDispatcher("/view/user/GioHang.jsp").forward(request, response);
			
		}
		catch (Exception e) {
			if(user==0)
			{
				response.sendRedirect("login");
			}
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
