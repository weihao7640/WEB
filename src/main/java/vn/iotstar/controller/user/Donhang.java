package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.ReviewDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.CommentVM;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.UserModels;

@WebServlet("/Donhang")
public class Donhang extends HttpServlet {
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 HttpSession session=request.getSession();
			 request.setCharacterEncoding("UTF-8");
			 int user=(int)session.getAttribute("id");
			 String trang = request.getParameter("id");
			 if (trang == null) {
					trang = "1";
				}
				int d = Integer.parseInt(trang);
				d = d * 6 - 6;
			
			 DonHangDAO dao=new DonHangDAO();
			 int sotrang=dao.countpage_user(user);
			 List<DonHangModels> user_cur=dao.getDH(user,d);
			 request.setAttribute("donhang",user_cur);
			 request.setAttribute("sotrang",sotrang);
			  request.getRequestDispatcher("/view/user/DonHang.jsp").forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}
