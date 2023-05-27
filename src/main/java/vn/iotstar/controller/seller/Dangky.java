package vn.iotstar.controller.seller;


	import java.io.IOException;
import java.util.Properties;
import java.util.Random;


import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;



import vn.iotstar.dao.DAO;
import vn.iotstar.dao.StoreDAO;
import vn.iotstar.dao.UserDAO;
import vn.iotstar.model.StoreModels;
import vn.iotstar.model.UserModels;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import util.MaHoa;

	@WebServlet("/dangkyshipper")
public class Dangky extends HttpServlet {

		protected void doGet(HttpServletRequest req, HttpServletResponse response)
				throws ServletException, IOException {
			
			HttpSession session = req.getSession();
			int idst = (int) session.getAttribute("storeid");
			StoreDAO userDao= new StoreDAO();
			StoreModels admin= userDao.get(idst);
			req.setAttribute("store", admin);

			req.setAttribute("stid", idst);
			req.getRequestDispatcher("view/shipper/add.jsp").forward(req, response);
			

		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("/text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			String user = request.getParameter("email");
			String pass = request.getParameter("pass");
			String ten = request.getParameter("ten");
			pass=MaHoa.toSHA1(pass);
			String salt="asjrlkmcoewj@tjle;oxqskjhdjksjf1jurVn";
			String sdt = request.getParameter("sdt");
			
				
				UserDAO dao = new UserDAO();
				UserModels tk = dao.Sosachuser(user);
				UserModels tk2=dao.Sosachsdt(sdt);
				if (tk == null) {
					if(tk2==null)
					{
					dao.themshipper(user, pass, ten, sdt, salt);
					
					System.out.print(user);
					
					response.sendRedirect("nhanvien");
					}
					else
					{
						request.setAttribute("error", "Số điện thoại đã tồn tại!");
						request.getRequestDispatcher("view/shipper/add.jsp").forward(request, response);
					
					}
				}
				else
				{
					request.setAttribute("error", "Email đã tồn tại!");
					request.getRequestDispatcher("view/shipper/add.jsp").forward(request, response);
				}
		}

	}


