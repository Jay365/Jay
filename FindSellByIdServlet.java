package com.gyf.bookstore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gyf.bookstore.domain.Sell;
import com.gyf.bookstore.domain.User;
import com.gyf.bookstore.service.SellService;

/**
 * Servlet implementation class FindSellByIdServlet
 */
@WebServlet("/findSellByIdServlet")
public class FindSellByIdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			response.getWriter().write("非法访问...");
			return;
		}
		
		//获取定单
		SellService ss = new SellService();
		List<Sell> list = ss.findsellByUserId(user.getId()+"");
		request.setAttribute("sells",list);
		request.setAttribute("count",list.size());
		//转发
		request.getRequestDispatcher("/selllist.jsp").forward(request, response);
		
	}

	

}
