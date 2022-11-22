package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DonHangDAO;
import DAO.UserDAO;
import Model.DonHangModels;
import Model.UserModels;

@WebServlet("/Donhang")
public class Donhang extends HttpServlet {
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 HttpSession session=request.getSession();
			 request.setCharacterEncoding("UTF-8");
			 int user=(int)session.getAttribute("id");
			 
			
			 DonHangDAO dao=new DonHangDAO();
			 List<DonHangModels> user_cur=dao.getDH(user);
			 request.setAttribute("donhang",user_cur);
			 System.out.print(user);
			  request.getRequestDispatcher("/view/user/DonHang.jsp").forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}
