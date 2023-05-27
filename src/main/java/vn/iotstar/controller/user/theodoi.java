package vn.iotstar.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.Theodoi_STDAO;
import vn.iotstar.model.ProductsModels;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserfollowModels;

/**
 * Servlet implementation class theodoi
 */
@WebServlet("/theodoi")
public class theodoi extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id=request.getParameter("id");
		 HttpSession session=request.getSession();
		 int userid=0;
		 try {
		 userid=(int)session.getAttribute("id");
			DAO dao =new DAO();
			StoreDAO stdao=new StoreDAO();
			int idsp=Integer.parseInt (id);
			ProductsModels sp=dao.getIdSanpham(idsp);
			StoreModels st=stdao.get(sp.getStoreID());
			request.setAttribute("sp", sp);
			request.setAttribute("st", st);
			 session.setAttribute("idsp",idsp);
			Theodoi_STDAO tddao=new Theodoi_STDAO();
			tddao.theodoi(userid, sp.getStoreID());
			request.setAttribute("shop", st);
			int slfollow=tddao.count_NTD(sp.getStoreID());
			request.setAttribute("slflow", slfollow);
			int slsp=tddao.count_SP(sp.getStoreID());
			request.setAttribute("slsp", slsp);
			UserfollowModels flowed=tddao.check_theodoi(userid,sp.getStoreID());
			System.out.println(flowed.getNgaytg());
			request.setAttribute("flowed", flowed);
			
			request.getRequestDispatcher("/view/user/ChiTiet.jsp").forward(request, response);
		 }
		 catch (Exception e) {
			if(userid==0)
			{
				response.sendRedirect("login");
			}
			
			
				
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
