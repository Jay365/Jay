package com.gyf.bookstore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gyf.bookstore.domain.Product;
import com.gyf.bookstore.service.ProductService;

@WebServlet("/findbook")
public class FindBookByNameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String bookname= request.getParameter("bookname");
		
		ProductService ps = new ProductService();
		List<Product> list = ps.findBookByname(bookname);
		
		if(list != null){
			request.setAttribute("list", list);
		}else {
			request.setAttribute("error", "Not found");
		}
		
		request.getRequestDispatcher("/findbook.jsp").forward(request, response);
	}
}
