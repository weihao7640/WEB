package vn.iotstar.controller.admin.category;

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

import vn.iotstar.dao.CateDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.UserModels;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = { "/admin/category-add" })
public class AddCategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CateDAO cateDAO= new CateDAO();
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
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/category/add-category.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	CategoryModels category= new CategoryModels();
	DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
	servletFileUpload.setHeaderEncoding("UTF-8");
	try {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		List<FileItem> items = servletFileUpload.parseRequest(req);
		for (FileItem item : items) {
			
			if (item.getFieldName().equals("namecate")) {
				category.setNamecate(item.getString("UTF-8"));
			} else if (item.getFieldName().equals("images")) {
				String originalFileName = item.getName();
				int index = originalFileName.lastIndexOf(".");
				String ext = originalFileName.substring(index + 1);
				String fileName = System.currentTimeMillis() + "." + ext;
				File file = new File(Constant.DIR + "/category/" + fileName);
				item.write(file);
				category.setImg("category/"+fileName);
			}
		}
		cateDAO.insert(category);
		resp.sendRedirect(req.getContextPath() + "/admin/category-list");
		
		
		
		
	} catch (FileUploadException e) {
		// TODO: handle exception
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
	
	
	
	
	
	}
	
}
