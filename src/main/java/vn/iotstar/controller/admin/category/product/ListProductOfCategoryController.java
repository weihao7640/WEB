package vn.iotstar.controller.admin.category.product;

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
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.UserModels;

@WebServlet(urlPatterns= {"/admin/categorylist"})
public class ListProductOfCategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ProductDAO productDao= new ProductDAO();
	CateDAO categoryDao=new CateDAO();
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
		String categoryID=req.getParameter("categoryID");
		if (indexPage==null)
		{indexPage="1";}
		int indexp = Integer.parseInt(indexPage);
		int countP = productDao.countCategory(Integer.parseInt(categoryID));
		int endPage=countP/5;
		if (countP/5!=0) {
			endPage++;
		}
		
		List <CategoryModels> categorys=categoryDao.getAll();
		req.setAttribute("categorys", categorys);
		
		List <ProductModels> productListNew=productDao.findAllProCate(Integer.parseInt(categoryID),indexp-1);
		req.setAttribute("products", productListNew);
		req.setAttribute("countProductAll", countP);
		
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		req.setAttribute("cateid", Integer.parseInt(categoryID));
		req.getRequestDispatcher("/view/admin/category/listproductofcategory.jsp").forward(req, resp);
		
	}
	
	
	
}
