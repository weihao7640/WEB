package vn.iotstar.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.UserModels;

/**
 * Servlet implementation class ChiTietND
 */
@WebServlet("/ChiTietND")
public class ChiTietND extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 int user= (int)session.getAttribute("id");
		 UserDAO dao=new UserDAO();
		 UserModels user_cur=dao.Sosachuser2(user);
		 request.setAttribute("user",user_cur);
		  request.getRequestDispatcher("/view/user/Thongtin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
