package vn.iotstar.controller.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.CateDAO;
import vn.iotstar.dao.ProductDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.StoreModels;
@WebServlet(name = "Sanpham", urlPatterns = {"/sanpham"})
public class ListProductController extends HttpServlet{

	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 resp.setContentType("/text/html;charset=UTF-8");
			 ProductDAO prodao=new ProductDAO();
			 String trang=req.getParameter("id");
			 String cateid=req.getParameter("cateid");
			 HttpSession session=req.getSession();
			 int id = (int) session.getAttribute("storeid");
			  if(cateid==null)
	 		  {
	 			  if(trang==null)
	 			  {
	 			  cateid="1";
	 			  session.setAttribute("TT", cateid);
	 			  trang="1";
	 			
	 			  }
	 			  else
	 			  {
	 				  cateid=(String) session.getAttribute("TT");
	 			  }
	 		  }
	 		  else {
	 			 session.setAttribute("TT", cateid);
	 			 
	 		  }
	 		  if(trang==null)
	 		  {
	 			  if(cateid!=null)
	 			  {
	 				 trang="1";
	 				cateid=(String) session.getAttribute("TT");
	 				
	 			  }
	 			  
	 		  }
	 		  else
	 		  {
	 			 cateid=(String) session.getAttribute("TT");
	 		  }
			
			
			 System.out.println(id);
			 int vitri=Integer.parseInt(trang);
			 int cate=Integer.parseInt(cateid);
			 vitri=vitri*6-6;
			 int sotrang;
			 List<ProductModels> pro;
			 if(cate==0)
			 {
				  pro=prodao.getpageST(id,vitri);
				   sotrang=prodao.countsp_ST(id);
			 }
			 else
			 {
				 sotrang=prodao.countsp_ST(id,cate);
				 pro=prodao.getpageST(id,vitri,cate);
			 }
			 req.setAttribute("pro", pro);
			 CateDAO catedao = new CateDAO();
			
			 List<CategoryModels> listcate = catedao.getAllcate();
				req.setAttribute("listcate", listcate);
				req.setAttribute("stid", id);
			
				StoreDAO userDao= new StoreDAO();
				StoreModels admin= userDao.get(id);
				req.setAttribute("store", admin);
				req.setAttribute("sotrang", sotrang);
		 	    req.getRequestDispatcher("/view/seller/list.jsp").forward(req, resp);
			
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request,response);
		}

		

	}



