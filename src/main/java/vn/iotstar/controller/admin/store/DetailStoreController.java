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

import vn.iotstar.dao.CateDAO;
import vn.iotstar.dao.ProductDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserModels;
@WebServlet(urlPatterns = { "/admin/stores-detail" })
public class DetailStoreController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	StoreDAO storeDao = new StoreDAO();
	ProductDAO productDao= new ProductDAO();
	CateDAO categoryDao=new CateDAO();
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
		String storeid=req.getParameter("storeID");
		
		StoreModels store=storeDao.get(Integer.parseInt(storeid));
		
	req.setAttribute("store", store);
	
	
	
	
	  String indexPage=req.getParameter("index"); 
	  String categoryID=req.getParameter("categoryID");
	  
	  if (indexPage==null)
	  {indexPage="1";} 
	  int indexp = Integer.parseInt(indexPage); 
	  int countP = 0;
	  if (categoryID==null)
	  {
		  countP=productDao.countProOfStore(Integer.parseInt(storeid));
	  }
	  if (categoryID!=null) {
	 countP= productDao.countProOfCateOfStore(Integer.parseInt(storeid),Integer.parseInt(categoryID)); }
	  int endPage=countP/8;
	  if (countP/8!=0) { endPage++; }
	 
	 
	
	  List <CategoryModels> categorys=categoryDao.getCateOfStore(Integer.parseInt(storeid));
	  req.setAttribute("categorys", categorys);
	 
	
		
		  if (categoryID==null) { List <ProductModels>
		  productListNew=productDao.findAllProOfStore(Integer.parseInt(storeid),indexp-
		  1); req.setAttribute("products", productListNew);} else { List
		  <ProductModels>
		  productListNew=productDao.findAllProOfCateOfStore(Integer.parseInt(storeid),Integer.parseInt(categoryID),indexp-
		  1); req.setAttribute("products", productListNew); }
		 
	  req.setAttribute("countProductAll", countP);
	 
	
	
	  req.setAttribute("endP", endPage); 
	  req.setAttribute("tag", indexp);
	  if (categoryID!=null) {
	  req.setAttribute("cateid", Integer.parseInt(categoryID));}
	 
	req.getRequestDispatcher("/view/admin/stores/detail-store.jsp").forward(req, resp);
		
		
	
	
	
		
		

	}
	
	
	
}



