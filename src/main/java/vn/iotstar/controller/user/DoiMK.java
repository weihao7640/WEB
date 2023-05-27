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
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.DonHangModels;
import util.MaHoa;

/**
 * Servlet implementation class DoiMK
 */
@WebServlet("/DoiMK")
public class DoiMK extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/view/user/DoiMK.jsp").forward(request, response);
		 request.setCharacterEncoding("UTF-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 UserDAO dao=new UserDAO();
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			String repass=request.getParameter("repass");
			 HttpSession session=request.getSession();
			 int id= (int)session.getAttribute("id");
		
			if(pass.equals(repass)==true)
			{
				user=MaHoa.toSHA1(user);
				if(dao.SosachMK(user)!=null)
				{
					request.setAttribute("sus", "Đã đổi thành công!");
					repass=MaHoa.toSHA1(repass);
					dao.DoiMk(repass,id);
					 request.getRequestDispatcher("/view/user/DoiMK.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("error", "Mật khẩu cũ không chính xác!");
					 request.getRequestDispatcher("/view/user/DoiMK.jsp").forward(request, response);
				}
			}
			else
			{
			request.setAttribute("error", "Mật khẩu không trùng nhau!");
			 request.getRequestDispatcher("/view/user/DoiMK.jsp").forward(request, response);
			}
	}

}
