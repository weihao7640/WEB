package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.CateDAO;
import vn.iotstar.dao.DAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.ProductsModels;

/**
 * Servlet implementation class dangxuat
 */
@WebServlet("/dangxuat")
public class dangxuat extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 HttpSession session=req.getSession();
		 session.removeAttribute("id");
		 resp.setContentType("/text/html;charset=UTF-8");
		 String id=req.getParameter("id");
		 String cateid=req.getParameter("cateid");
		 DAO dao =new DAO();
		 CateDAO catedao=new CateDAO();
		 
	 		  if(cateid==null)
	 		  {
	 			  if(id==null)
	 			  {
	 			  cateid="1";
	 			  session.setAttribute("cate", cateid);
	 			  id="1";
	 			  }
	 			  else
	 			  {
	 				  cateid=(String) session.getAttribute("cate");
	 			  }
	 		  }
	 		  else {
	 			 session.setAttribute("cate", cateid);
	 			 
	 		  }
	 		  if(id==null)
	 		  {
	 			  if(cateid!=null)
	 			  {
	 				 id="1";
	 				cateid=(String) session.getAttribute("cate");
	 			  }
	 			  
	 		  }
	 		  else
	 		  {
	 			 cateid=(String) session.getAttribute("cate");
	 		  }
	 		 int d = Integer.parseInt (id);
	 		 d=d*10-10;
  		 int c = Integer.parseInt (cateid);
	 		int sotrang=dao.countsp(c);
	 		List<ProductsModels> list1=dao.getpage(d,c); 
	 		List<ProductsModels> list2=dao.top6(); 
	 		List<CategoryModels> listcate=catedao.getAllcate();
	 		req.setAttribute("listP", list1);
	 		req.setAttribute("listC", list2);
	 		req.setAttribute("listcate", listcate);
	 		req.setAttribute("sotrang", sotrang);
	 	    req.getRequestDispatcher("/view/user/Home.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	

}
