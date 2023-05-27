package vn.iotstar.controller.admin.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.CateDAO;

@WebServlet(urlPatterns = { "/admin/category-delete" })
public class DeleteCategoryController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
		 * 
		 */
	CateDAO cateDAO = new CateDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.print(id);
		cateDAO.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/category");
	}
}
