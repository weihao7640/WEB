package vn.iotstar.controller.seller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserModels;
@WebServlet("/profile")
public class ProfileController extends HttpServlet {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	int idAdmin=0;
	 int idstore= (int)session.getAttribute("storeid");
	try {
		idAdmin= (int)session.getAttribute("id");
		if (idAdmin==0)
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("");
			dispatcher.forward(req, resp);
		}
	} catch (Exception e) {
		// TODO: handle exception
		RequestDispatcher dispatcher = req.getRequestDispatcher("");
		dispatcher.forward(req, resp);
		
	}
	StoreDAO userDao= new StoreDAO();
	StoreModels admin= userDao.get(idstore);
	req.setAttribute("store", admin);
	req.setAttribute("stid", idstore);
		req.getRequestDispatcher("/view/seller/profile/myProfile.jsp").forward(req, resp);
		
		
	}
	
	
}
