package vn.iotstar.controller.user;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import vn.iotstar.dao.CTDHDAO;
import vn.iotstar.dao.DAO;
import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.GioHangDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.CT_GHModels;
import vn.iotstar.model.CategoryModels;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.GioHangModels;
import vn.iotstar.model.ProductsModels;
import vn.iotstar.model.UserModels;

/**
 * Servlet implementation class ThanhToanGH
 */
@WebServlet("/ThanhToanGH")
public class ThanhToanGH extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		UserDAO dao =new UserDAO();
		String sanpham=request.getParameter("idsp");
		int idsp=Integer.parseInt(sanpham);
		 HttpSession session=request.getSession();
		 int id= (int)session.getAttribute("id");
		UserModels user=dao.Sosachuser2(id);
		DAO daosp=new DAO();
		GioHangDAO ghdao=new GioHangDAO();
		 GioHangModels curGH=ghdao.layGH(id);
		 List<CT_GHModels> listgh=ghdao.getAllGH(curGH.getCartID(),idsp);
		 int tong=0;
		 for (CT_GHModels o : listgh) {
				tong+=o.getPrice()*o.getCount();
			}
		Locale localeVN = new Locale("vi", "VN");
		
		NumberFormat vn = NumberFormat.getInstance(localeVN);
			
		// đối với số float được định dạng theo chuẩn của Việt am
		// thì phần thập phân của số được phân cách bằng dấu phẩy
		
		String str2 = vn.format(tong);
		session.setAttribute("idsp", idsp);
		session.setAttribute("tong", tong);
		request.setAttribute("tong", str2);
		request.setAttribute("user", user);
		request.setAttribute("listgh", listgh);
		request.getRequestDispatcher("/view/user/ThanhToan.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		DonHangDAO daoDH=new DonHangDAO();
		 HttpSession session=request.getSession();
		 int id= (int)session.getAttribute("id");
		 String diachi=request.getParameter("diachi");
		 String phone=request.getParameter("phone");
		 int tong=(int) session.getAttribute("tong");
		 int idsp=(int) session.getAttribute("idsp");
		 DAO daosp=new DAO();
			ProductsModels curSP=daosp.getIdSanpham(idsp);
		 daoDH.donhang(id, diachi, phone, tong,curSP.getStoreID());
		 DonHangModels curDH=daoDH.curDH();// lấy đơn hagf hiện tại
		 //lưu chi tiết đơn hàng
		 CTDHDAO ctdao=new CTDHDAO();
		 GioHangDAO ghdao=new GioHangDAO();
		 GioHangModels curGH=ghdao.layGH(id);
		 List<CT_GHModels> listgh=ghdao.getAllGH(curGH.getCartID(),idsp);
		
		 for (CT_GHModels o : listgh) {
			 ctdao.ctdonhang(curDH.getOderid(), o.getProductID(), o.getCount());
			  curSP=daosp.getIdSanpham(o.getProductID());
			 int slDaBan=curSP.getSold()+o.getCount();
			 int slCon=curSP.getQuan()-o.getCount();
			 daosp.updateSanpham(slDaBan, slCon, o.getProductID());
			}
		
		 
		 session.removeAttribute("tong");
		 session.removeAttribute("idsp");
		 session.removeAttribute("sl");
		 response.sendRedirect("home");
	}

}
