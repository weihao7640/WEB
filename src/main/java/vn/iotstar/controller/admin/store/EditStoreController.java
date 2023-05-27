package vn.iotstar.controller.admin.store;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserModels;
import vn.iotstar.util.Constant;
@WebServlet(urlPatterns = { "/admin/stores-edit" })
public class EditStoreController extends HttpServlet {

	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StoreDAO storeDao=  new StoreDAO();
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
		String id = req.getParameter("storeid");
	
	
	  storeDao.edit(Integer.parseInt(id));
	  
	
	resp.sendRedirect(req.getContextPath() + "/admin/stores-list");
	}
	
	
	
	
	
	
}
