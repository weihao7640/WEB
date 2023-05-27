package vn.iotstar.controller.seller;
import vn.iotstar.dao.CateDAO;
import vn.iotstar.dao.DAO;
import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.ProductDAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.Theodoi_STDAO;
import vn.iotstar.dao.ThongKeDAO;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.ProductModels;
import vn.iotstar.model.ProductsModels;
import vn.iotstar.model.StoreModels;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.HashPrintJobAttributeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.core.compiler.CharOperation;
@WebServlet(name = "Homeseller", urlPatterns = {"/homeseller"})
public class Homesellercontroller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("/text/html;charset=UTF-8");
		 //HttpSession session=req.getSession();
		 String storeID=req.getParameter("storeid");
		 int stID=Integer.parseInt(storeID);
		HttpSession session = req.getSession();
		session.setAttribute("storeid", stID);
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
		
		
		 
		 System.out.println(stID);
		 DonHangDAO dhdao=new DonHangDAO();
		 int sl_dh=dhdao.countDH(stID);
		 int doanhthu=0;
		 StoreDAO stdao=new StoreDAO();
		 StoreModels shop=stdao.get(stID);
		 ProductDAO prodao=new ProductDAO();
		 List<ProductModels> pro=prodao.getAllStore(stID);
		 int namhientai=LocalDate.now().getYear();
		 for(ProductModels o:pro)
		 {
			doanhthu+=o.getSold()*o.getPrice(); 
		 }
		 int doanhthunam=0;
		 DAO dao=new DAO();
		 List<ProductsModels> listtop6=dao.top6store(stID);
		 //tính doanh thu hàng tháng
			/*
			 * int[] doanhthu_T = new int[12]; int i=1; while(i<=12) {
			 * 
			 * doanhthu_T[i-1]=dhdao.doanhthu_T(stID, i); i++; } i=1; while(i<=12) {
			 * doanhthunam+=doanhthu_T[i-1]; i++; }
			 */
		Theodoi_STDAO tddao=new Theodoi_STDAO();
		
		
		
		
		
		String select=req.getParameter("YearSelected");
		int selected=0;
		if (select==null)
			selected=namhientai;
		else {
			selected=Integer.parseInt(select);
		}
		ThongKeDAO thongKeDao= new ThongKeDAO();
		int[] doanhthu_T = new int[12];
		doanhthu_T=thongKeDao.getThongKeTheoThang(selected, idAdmin);
		LocalDate createDate= LocalDate.parse(shop.getCreateAt());
		int yearCreate=createDate.getYear();
		req.setAttribute("yearCreate", yearCreate);
		int[] dsnam= new int[namhientai-yearCreate+1];
		int dem=0;
		for (int o=namhientai;o>=yearCreate;o--) {
			dsnam[dem]=o;
			dem++;
			}
		
		req.setAttribute("dsnam", dsnam);
		int slfollow=tddao.count_NTD(stID);
		 req.setAttribute("doanhthu", doanhthu);
		 req.setAttribute("doanhthunam", doanhthunam);
		 req.setAttribute("follow", slfollow);
		 req.setAttribute("sl_dh", sl_dh);
		 req.setAttribute("shop", shop);
		 req.setAttribute("doanhthu_T", doanhthu_T);
		 req.setAttribute("listtop6", listtop6);
		 req.setAttribute("namhientai", namhientai);
		 int user= (int)session.getAttribute("id");
	 	    req.getRequestDispatcher("/view/seller/sellerhome.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	

}
