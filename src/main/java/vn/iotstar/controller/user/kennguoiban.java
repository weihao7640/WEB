package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.iotstar.model.*;
import vn.iotstar.dao.StoreDAO;

/**
 * Servlet implementation class kennguoiban
 */
@WebServlet("/kennguoiban")
public class kennguoiban extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoreDAO stdao=new StoreDAO();
		 HttpSession session=request.getSession();
		 
		 int user= (int)session.getAttribute("id");
		List<StoreModels> list=stdao.getstore(user);
		request.setAttribute("store", list);
		System.out.println(user);
		for(StoreModels o:list)
		{
		System.out.println(o);
		}
		request.getRequestDispatcher("view/user/Kenhnguoiban.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("dknguoiban");
	}

}
