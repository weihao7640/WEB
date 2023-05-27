package vn.iotstar.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.UserModels;
@WebServlet("/admin/profile")
public class ProfileController extends HttpServlet {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	int idAdmin=0;
	try {
		idAdmin= (int)session.getAttribute("AdminID");
		if (idAdmin==0)
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/login.jsp");
			dispatcher.forward(req, resp);
		}
	} catch (Exception e) {
		// TODO: handle exception
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/login.jsp");
		dispatcher.forward(req, resp);
		
	}
	UserDAO userDao= new UserDAO();
	UserModels admin= userDao.get(idAdmin);
	req.setAttribute("admin", admin);
		req.getRequestDispatcher("/view/admin/profile/myProfile.jsp").forward(req, resp);
		
		
	}
	
	
}
