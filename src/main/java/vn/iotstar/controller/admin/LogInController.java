package vn.iotstar.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.ProductsModels;
import vn.iotstar.model.UserModels;
import util.MaHoa;

/**
 * Servlet implementation class chitiet
 */
@WebServlet("/admin/login")
public class LogInController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/admin/login.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		pass=MaHoa.toSHA1(pass);
		UserDAO dao=new UserDAO();
		UserModels usercur= dao.admin_login(email, pass);
		 HttpSession session=request.getSession();
		if(usercur==null)
		{
			request.setAttribute("error", "Thông tin đăng nhập không đúng!");
			request.getRequestDispatcher("/view/admin/login.jsp").forward(request, response);
		}
		else
		{
			 session.setAttribute("AdminID", usercur.getUserID());
			response.sendRedirect("thongke");
		}
		
	}

}
