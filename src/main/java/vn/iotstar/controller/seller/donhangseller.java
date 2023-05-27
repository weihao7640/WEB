package vn.iotstar.controller.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.CateDAO;
import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.DonHangVM;
import vn.iotstar.model.StoreModels;

@WebServlet("/donhangseller")
public class donhangseller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("/text/html;charset=UTF-8");
		String trang = req.getParameter("id");
		String TT = req.getParameter("TT");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("storeid");
		  if(TT==null)
 		  {
 			  if(trang==null)
 			  {
 			  TT="1";
 			  session.setAttribute("TT", TT);
 			  trang="1";
 			
 			  }
 			  else
 			  {
 				  TT=(String) session.getAttribute("TT");
 			  }
 		  }
 		  else {
 			 session.setAttribute("TT", TT);
 			 
 		  }
 		  if(trang==null)
 		  {
 			  if(TT!=null)
 			  {
 				 trang="1";
 				TT=(String) session.getAttribute("TT");
 				
 			  }
 			  
 		  }
 		  else
 		  {
 			 TT=(String) session.getAttribute("TT");
 		  }
		int d = Integer.parseInt(trang);
		d = d * 10 - 10;
		DonHangDAO dao = new DonHangDAO();
		
		 int sotrang;
		List<DonHangVM> user_cur;
		if(TT=="1")
		{
			 user_cur = dao.getGH_ST(id, d);
			 sotrang = dao.countpage_DH(id);
			 System.out.println(trang);
		}		
		else
		{
			 sotrang = dao.countpage_DH(id,TT);
		user_cur = dao.getGH_ST(id, d,TT);
		}
		 CateDAO catedao=new CateDAO();
		 
		List<CategoryModels> listcate=catedao.getAllcate();
		req.setAttribute("listcate", listcate);
		req.setAttribute("stid", id);
		req.setAttribute("donhang", user_cur);
		req.setAttribute("sotrang", sotrang);
		StoreDAO userDao= new StoreDAO();
		StoreModels admin= userDao.get(id);
		req.setAttribute("store", admin);
		req.getRequestDispatcher("/view/seller/donhangseller.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
