package vn.iotstar.controller.user.follow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.ProductDAO;
import vn.iotstar.dao.UserDAO;
@WebServlet(urlPatterns = { "/unfollow" })
public class UnFollowController extends HttpServlet {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDAO userDao= new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("storeid");
		HttpSession session=req.getSession();
		int iduser=(int)session.getAttribute("id");
		userDao.unfollow(iduser,Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/listFollow");
	}
}
