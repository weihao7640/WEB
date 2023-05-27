package vn.iotstart.controller.shipper;

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
@WebServlet("/shipper-profile")
public class ProfileShipperController extends HttpServlet {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();
	
	int idShipper=0;
	try {
		idShipper= (int)session.getAttribute("idshipper");
		if (idShipper==0)
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/user/dangnhap.jsp");
			dispatcher.forward(req, resp);
		}
	} catch (Exception e) {
		// TODO: handle exception
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/user/dangnhap.jsp");
		dispatcher.forward(req, resp);
		
	}
	UserDAO userDao= new UserDAO();
	UserModels shipper= userDao.get(idShipper);
	req.setAttribute("shipper", shipper);
		req.getRequestDispatcher("/view/shipper/myProfile-shipper.jsp").forward(req, resp);
		
		
	}
	
	
}
