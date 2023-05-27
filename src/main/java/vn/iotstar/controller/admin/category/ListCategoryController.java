package vn.iotstar.controller.admin.category;

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
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.UserModels;


@WebServlet(urlPatterns = {"/admin/category", "/admin/category-list"})
public class ListCategoryController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CateDAO cate= new CateDAO();
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
		List<CategoryModels> cateList = cate.getAll();
		req.setAttribute("categorys", cateList); 
		/*
		 * CategoryModels a= new CategoryModels(); a=cateList.get(1); int d=0; if
		 * (a.isDel()==true) {d=1;} req.setAttribute("aa", d);
		 */
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/category/list-category.jsp");
		dispatcher.forward(req, resp);
	
	}
}
