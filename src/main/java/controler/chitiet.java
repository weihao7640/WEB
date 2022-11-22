package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import Model.ProductsModels;

/**
 * Servlet implementation class chitiet
 */
@WebServlet("/chitiet")
public class chitiet extends HttpServlet {
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			String id=request.getParameter("id");
			DAO dao =new DAO();
			int idsp=Integer.parseInt (id);
			ProductsModels sp=dao.getIdSanpham(idsp);
			request.setAttribute("sp", sp);
			 HttpSession session=request.getSession();
			 session.setAttribute("idsp",idsp);
			request.getRequestDispatcher("/view/user/ChiTiet.jsp").forward(request, response);
			
			
		}
	
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
		}

}
