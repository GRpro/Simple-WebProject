package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Just a redirection servlet
 */
@WebServlet("/add_item")
public class RedirectToItemRegistrtionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Redirects to {@code add_shop.jsp} and sets parameter {@code shopId}
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long shopId = Long.valueOf(request.getParameter("shopId"));
		request.setAttribute("shopId", shopId);
		request.getRequestDispatcher("/add_item.jsp").forward(request, response);
	}

}
