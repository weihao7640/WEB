package vn.iotstar.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.DonHangDAO;
import vn.iotstar.model.CT_DHVM;
import vn.iotstar.model.DonHangModels;
import vn.iotstar.model.DonHangVM;

/**
 * Servlet implementation class update_TTDH
 */
@WebServlet("/update_TTDH")
public class update_TTDH extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iddh=request.getParameter("iddh");
		DonHangDAO dhdao=new DonHangDAO();
		int id=Integer.parseInt(iddh);
		CT_DHVM dh=dhdao.ChitetDH(id);
		DonHangModels curdh=dhdao.CT_DHstore(id);
		System.out.println(curdh.getTrangthai());
		if(curdh.getTrangthai().equals("Chưa xác nhận"))
		{
			System.out.println("1");
			dhdao.xacnhan_DH(id);
		}
		
		request.setAttribute("dh", dh);
		request.setAttribute("mess", "Xác nhận thành công");
		request.setAttribute("dh_HT", curdh);
		  request.getRequestDispatcher("/view/user/ChitietDH.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
