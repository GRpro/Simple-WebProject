package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.ItemDAO;
import com.project.dao.ShopDAO;
import com.project.exceptions.OperationFailedException;

/**
 * Servlet implementation class DeleteShopServlete
 */
@WebServlet("/delete/shop")
public class DeleteShopServlete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ShopDAO shopDAO;
	private ItemDAO itemDAO;
    
    public DeleteShopServlete() {
        this.shopDAO = ShopDAO.getInstance();
        this.itemDAO = ItemDAO.getInstance();
    }

	/**
	 * Deletes shop and all related items
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long shopId = Long.parseLong(request.getParameter("shopId"));
			itemDAO.deleteByShopId(shopId);
			shopDAO.delete(shopId);
			request.setAttribute("title", "Success page");
			request.setAttribute("message", "Shop was successfully deleted!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("title", "Error page");
			request.setAttribute("message", "Deletion of shop failed!");
		} 
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	
	}

}
