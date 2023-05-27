package vn.iotstar.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.UserModels;
@WebServlet (urlPatterns = {"/admin/user-detail"})
public class DetailUserController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDAO userDao= new UserDAO();
	DonHangDAO orderDao=new DonHangDAO();
	@Override
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
		
		String id = req.getParameter("userId");
		UserModels user= userDao.get(Integer.parseInt(id));
		req.setAttribute("user", user);
		int storeid=userDao.getStoreID(Integer.parseInt(id));
		req.setAttribute("storeID", storeid);
		
		
		String indexPage=req.getParameter("index");
		
		if (indexPage==null) {
			indexPage="1";
		}
		int indexp=Integer.parseInt(indexPage);
		int countP=orderDao.countOrderOfUser(Integer.parseInt(id));
		int endPage=countP/10;
		if(countP/10!=0) {endPage++;} 
		
		List <DonHangModels> orderList=orderDao.findAllOrderOfUser(Integer.parseInt(id),indexp-1);
		req.setAttribute("orders", orderList);
		req.setAttribute("countOrderAll", countP);
		
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin/user/detail-user.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	
	
	
}
