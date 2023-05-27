package vn.iotstar.controller.seller;

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

import util.MaHoa;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserModels;
import vn.iotstar.util.Constant;

@WebServlet("/profile-edit")
public class EditProfileController extends HttpServlet {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int idAdmin = 0;
		try {
			idAdmin = (int) session.getAttribute("storeid");
			if (idAdmin == 0) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			RequestDispatcher dispatcher = req.getRequestDispatcher("");
			dispatcher.forward(req, resp);

		}
		StoreDAO storeDAO = new StoreDAO();
		StoreModels store = storeDAO.getStore(idAdmin);
		req.setAttribute("store", store);
		req.getRequestDispatcher("/view/seller/profile/editProfile.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		StoreDAO storeDao= new StoreDAO();
		StoreModels store=new StoreModels();
		
		
		HttpSession session = req.getSession();
		int id=(int) session.getAttribute("storeid");
	
		StoreDAO userDao= new StoreDAO();
		StoreModels admin= userDao.get(id);
		req.setAttribute("store", admin);
		req.setAttribute("stid", id);
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("")) {
					store.setStoreId(id);
				} else if (item.getFieldName().equals("name")) {
					store.setStoreName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("images")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/store/" + fileName);
						item.write(file);
						store.setAvatar("store/" + fileName);
					} else {
						store.setAvatar(null);
					}
				}else if (item.getFieldName().equals("isDel")) {
					store.setOpen(Boolean.parseBoolean(item.getString("UTF-8")));
				}
				
				
				
				
			}
			storeDao.editStore(store,id);
			resp.sendRedirect(req.getContextPath() + "/profile");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
