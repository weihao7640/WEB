package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO;
import DAO.UserDAO;
import Model.ProductsModels;
import Model.UserModels;
import util.MaHoa;

/**
 * Servlet implementation class chitiet
 */
@WebServlet("/login")
public class Dangnhap extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/user/dangnhap.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		pass=MaHoa.toSHA1(pass);
		UserDAO dao=new UserDAO();
		UserModels usercur= dao.SosachId(user, pass);
		 HttpSession session=request.getSession();
		if(usercur==null)
		{
			request.setAttribute("error", "Thông tin đăng nhập không đúng!");
			request.getRequestDispatcher("/view/user/dangnhap.jsp").forward(request, response);
		}
		else
		{
			 session.setAttribute("id", usercur.getUserID());
			response.sendRedirect("home");
		}
		
	}

}
