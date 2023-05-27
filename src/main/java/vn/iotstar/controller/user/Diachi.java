package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.DiachiDAO;
import vn.iotstar.dao.UserDAO;
import  vn.iotstar.model.DiaCHi;
import vn.iotstar.model.UserModels;


@WebServlet("/Diachi")
public class Diachi extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 int user= (int)session.getAttribute("id");
		 DiachiDAO dao=new DiachiDAO();
		 List<DiaCHi> user_cur=dao.getDiaChi(user);
		 request.setAttribute("diachi",user_cur);
		  request.getRequestDispatcher("/view/user/DiaChi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		String DiaChi=request.getParameter("diachi");
		 int user= (int)session.getAttribute("id");
		 DiachiDAO dao=new DiachiDAO();
		 dao.ThemDiaChi(DiaChi, user);
		

		 List<DiaCHi> user_cur=dao.getDiaChi(user);
		 request.setAttribute("listDC",user_cur);
		 request.getRequestDispatcher("/view/user/DiaChi.jsp").forward(request, response);
		 
	}
}
