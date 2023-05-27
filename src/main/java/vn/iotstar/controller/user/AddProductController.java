package vn.iotstar.controller.user;

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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.iotstar.dao.ProductDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.StoreModels;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = { "/dknguoiban" })
public class AddProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StoreDAO productDao = new StoreDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/user/Dangkynguoiban.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StoreModels product = new StoreModels();
		resp.setContentType("/text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String name=req.getParameter("name");
		 HttpSession session=req.getSession();
		 int id= (int)session.getAttribute("id");
		
			productDao.insert(name,id);
			resp.sendRedirect("kennguoiban");

	}
}
