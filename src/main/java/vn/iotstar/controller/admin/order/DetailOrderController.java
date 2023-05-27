package vn.iotstar.controller.admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.CTDHDAO;
import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.CT_DonHangModels;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.UserModels;
@WebServlet (urlPatterns = {"/admin/order-detail"})
public class DetailOrderController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDAO userDao= new UserDAO();
	DonHangDAO orderDao=new DonHangDAO();
	CTDHDAO orderitemDao= new CTDHDAO();
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
		
		String orID=req.getParameter("oID");
		int orderid=Integer.parseInt(orID);
		DonHangModels order=orderDao.getOrder(orderid);
		req.setAttribute("ord", order);
		
		
		List<CT_DonHangModels> orderitems=orderitemDao.listProOfOrder(orderid);
		req.setAttribute("orditems", orderitems);
		
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin/order/detail-order.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	
	
	
}
