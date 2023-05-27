package vn.iotstar.controller.admin.store;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserModels;

@WebServlet(urlPatterns = { "/admin/stores-list", "/admin/stores" })
public class ListStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreDAO storeDao = new StoreDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int idAdmin = 0;
		try {
			idAdmin = (int) session.getAttribute("AdminID");
			if (idAdmin == 0) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/login.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/login.jsp");
			dispatcher.forward(req, resp);

		}
		UserDAO userDao = new UserDAO();
		UserModels admin = userDao.get(idAdmin);
		req.setAttribute("admin", admin);

		String indexPage = req.getParameter("index");

		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		int countP = storeDao.countAll();
		int endPage = countP / 5;
		if (countP / 5 != 0) {
			endPage++;
		}

		List <StoreModels> productListNew=storeDao.findAllPage(indexp-1);
		req.setAttribute("stores", productListNew);
		req.setAttribute("countStoreAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/stores/list-store.jsp");
		dispatcher.forward(req, resp);

	}
}
