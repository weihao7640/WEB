package controler;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CTDHDAO;
import DAO.DAO;
import DAO.DonHangDAO;
import DAO.UserDAO;
import Model.DonHangModels;
import Model.ProductsModels;
import Model.UserModels;

/**
 * Servlet implementation class Thanhtoan
 */
@WebServlet("/Thanhtoan")
public class Thanhtoan extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		UserDAO dao =new UserDAO();
		
		String soluong=request.getParameter("soluong");
		int sl=Integer.parseInt(soluong);
		 HttpSession session=request.getSession();
		 int id= (int)session.getAttribute("id");
		 int idsp= (int)session.getAttribute("idsp");
		UserModels user=dao.Sosachuser2(id);
		DAO daosp=new DAO();
		ProductsModels curSP=daosp.getIdSanpham(idsp);
		int tong=sl*curSP.getPrice();
		session.setAttribute("tong", tong);
		session.setAttribute("sl", sl);

		Locale localeVN = new Locale("vi", "VN");
		NumberFormat vn = NumberFormat.getInstance(localeVN);
			
		// đối với số float được định dạng theo chuẩn của Việt am
		// thì phần thập phân của số được phân cách bằng dấu phẩy
		
		String str2 = vn.format(tong);
		request.setAttribute("tong", str2);
		request.setAttribute("user", user);
		request.setAttribute("sp", curSP);
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
		 daoDH.donhang(id, diachi, phone, tong);
		 int idsp= (int)session.getAttribute("idsp");
		 int sl= (int)session.getAttribute("sl");
		 DonHangModels curDH=daoDH.curDH();// lấy đơn hagf hiện tại
		 //lưu chi tiết đơn hàng
		 CTDHDAO ctdao=new CTDHDAO();
		 ctdao.ctdonhang(curDH.getOderid(), idsp, sl);
		 DAO daosp=new DAO();
		 ProductsModels curSP=daosp.getIdSanpham(idsp);
		 int slDaBan=curSP.getSold()+sl;
		 int slCon=curSP.getSold()-sl;
		 daosp.updateSanpham(slDaBan, slCon, idsp);
		 session.removeAttribute("tong");
		 session.removeAttribute("idsp");
		 session.removeAttribute("sl");
		 response.sendRedirect("home");
	}

}
