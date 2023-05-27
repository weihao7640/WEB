package vn.iotstar.controller.admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.ProductDAO;
@WebServlet(urlPatterns = { "/admin/product-delete" })
public class DeleteProductController extends HttpServlet {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductDAO productDao= new ProductDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		productDao.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/product-list");
	}
}
