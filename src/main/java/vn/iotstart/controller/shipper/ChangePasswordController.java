package vn.iotstart.controller.shipper;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.UserModels;
import util.MaHoa;

/**
 * Servlet implementation class DoiMK
 */
@WebServlet("/shipper-changePassword")
public class ChangePasswordController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		HttpSession session=req.getSession();
		
		int idShipper=0;
		try {
			idShipper= (int)session.getAttribute("idshipper");
			if (idShipper==0)
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/user/dangnhap.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/user/dangnhap.jsp");
			dispatcher.forward(req, resp);
			
		}
		UserDAO userDao= new UserDAO();
		UserModels shipper= userDao.get(idShipper);
		req.setAttribute("shipper", shipper);
			req.getRequestDispatcher("/view/shipper/changePassword-shipper.jsp").forward(req, resp);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 UserDAO dao=new UserDAO();
			String user=request.getParameter("password1");
			String pass=request.getParameter("password2");
			String repass=request.getParameter("password3");
			 HttpSession session=request.getSession();
			 int id= (int)session.getAttribute("idshipper");
		
			if(pass.equals(repass)==true)
			{
				user=MaHoa.toSHA1(user);
				if(dao.SosachMK(user)!=null)
				{
					request.setAttribute("sus", "Đã đổi thành công!");
					repass=MaHoa.toSHA1(repass);
					dao.DoiMk(repass,id);
					response.sendRedirect("shipper-profile");
				}
				else
				{
					request.setAttribute("error", "Mật khẩu cũ không chính xác!");
					 request.getRequestDispatcher("/view/shipper/changePassword-shipper.jsp").forward(request, response);
				}
			}
			else
			{
			request.setAttribute("error", "Mật khẩu không trùng nhau!");
			 request.getRequestDispatcher("/view/shipper/changePassword-shipper.jsp").forward(request, response);
			}
	}

}
