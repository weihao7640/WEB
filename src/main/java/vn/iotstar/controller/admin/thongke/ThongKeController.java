package vn.iotstar.controller.admin.thongke;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.ThongKeDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserModels;

@WebServlet(urlPatterns = { "/admin/thongke", "/admin/home" })
public class ThongKeController extends HttpServlet {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ThongKeDAO thongkeDao=new ThongKeDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//////Phần thêm
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
	////////////////////////////////////
	
		int[] month=new int[12];
		
		String yyyy=req.getParameter("yyyy");
		int year=0;
		if (yyyy==null)
		 {year=LocalDateTime.now().getYear();}
		else {
			year=Integer.parseInt(yyyy);
		}
		month=thongkeDao.getThongKeTheoThang(year);
		req.setAttribute("month", month);
		req.setAttribute("namhientai",LocalDateTime.now().getYear() );
		req.setAttribute("thang1", month[0]);
		req.setAttribute("thang2", month[1]);
		req.setAttribute("thang3", month[2]);
		req.setAttribute("thang4", month[3]);
		req.setAttribute("thang5", month[4]);
		req.setAttribute("thang6", month[5]);
		req.setAttribute("thang7", month[6]);
		req.setAttribute("thang8", month[7]);
		req.setAttribute("thang9", month[8]);
		req.setAttribute("thang10", month[9]);
		req.setAttribute("thang11", month[10]);
		req.setAttribute("thang12", month[11]);
		
		req.setAttribute("nam", year);
		
		List<ProductModels> products=thongkeDao.getTop10Products(year);
		req.setAttribute("top10products", products);
		
		List<StoreModels> stores=thongkeDao.getTop8Store(year);
		req.setAttribute("top8stores", stores);
		
		req.setAttribute("countUsers", thongkeDao.countusers());
		req.setAttribute("countStores", thongkeDao.countstore());
		req.setAttribute("countOrderOfMonth", thongkeDao.countOrderOfMonth());
		req.setAttribute("sumOfMonth", thongkeDao.sumOfMonth());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/thongke/thongke.jsp");
		dispatcher.forward(req, resp);
	}
}
