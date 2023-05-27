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

import vn.iotstar.dao.CateDAO;
import vn.iotstar.dao.ProductDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.StoreModels;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = { "/addsanpham" })
public class AddProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductDAO productDao = new ProductDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 CateDAO catedao=new CateDAO();
		List<CategoryModels> listcate=catedao.getAllcate();
		req.setAttribute("listcate", listcate);
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("storeid");
		StoreDAO userDao= new StoreDAO();
		StoreModels admin= userDao.get(id);
		req.setAttribute("store", admin);
		req.setAttribute("stid", id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/seller/product/add.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductModels product = new ProductModels();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		 HttpSession session=req.getSession();
		 int id=(int)session.getAttribute("storeid");
		 System.out.println(id);
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				
				if (item.getFieldName().equals("productName")) {
					product.setProductName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("images")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/product/" + fileName);
					item.write(file);
					product.setImg("product/" + fileName);
				}
				else if(item.getFieldName().equals("description")) {
					product.setDescription(item.getString("UTF-8"));
				}else if(item.getFieldName().equals("categoryId")) {
					product.setCategoryId(Integer.parseInt(item.getString()));
				}else if(item.getFieldName().equals("storeId")) {
					product.setStoreId(id);
				}else if(item.getFieldName().equals("price")) {
					product.setPrice(Integer.parseInt(item.getString()));
				}else if(item.getFieldName().equals("isSelling")) {
					product.setIsSelling(Boolean.parseBoolean(item.getString("UTF-8")));
				}else if(item.getFieldName().equals("quantity")) {
					product.setQuantity(Integer.parseInt(item.getString()));
				}
				
			}
			productDao.insert(product,id);
			resp.sendRedirect(req.getContextPath() + "/sanpham");

		} catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
