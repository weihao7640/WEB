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

import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;

import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.UserModels;

@WebServlet(urlPatterns = {"/admin/order-list","/admin/order"})
public class ListOrderController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		String indexPage=req.getParameter("index");
		
		if (indexPage==null) {
			indexPage="1";
		}
		
		
		
		String tt=req.getParameter("TT");

		int indexp=Integer.parseInt(indexPage);
		
		int countP=0;
		if (tt==null || tt=="5") {
			countP=orderDao.countAll();}
		else {
			countP=orderDao.countTT(Integer.parseInt(tt));
		}
		
		
		
		
		int endPage=countP/10;
		if(countP/10!=0) {endPage++;} 
		if (tt==null || tt=="5") {
			List <DonHangModels> orderList=orderDao.findAllPage(indexp-1);
			req.setAttribute("orders", orderList);
		}
		else {
			List <DonHangModels> orderList=orderDao.findLocTT(indexp-1, Integer.parseInt(tt));
			req.setAttribute("orders", orderList);
		}
		
		req.setAttribute("countOrderAll", countP);
		
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		req.setAttribute("status", tt);
		
		
		
		req.getRequestDispatcher("/view/admin/order/list-order.jsp").forward(req, resp);
	
	
	
	}
	
	
	
}
