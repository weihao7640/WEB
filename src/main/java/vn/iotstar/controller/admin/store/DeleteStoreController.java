package vn.iotstar.controller.admin.store;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.StoreDAO;


@WebServlet (urlPatterns = { "/admin/stores-delete" })
public class DeleteStoreController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StoreDAO storeDao= new StoreDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		storeDao.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/stores-list");
	}
}
