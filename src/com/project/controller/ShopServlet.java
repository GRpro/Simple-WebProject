package com.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.ShopDAO;
import com.project.entities.Shop;
import com.project.exceptions.OperationFailedException;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/shops")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private ShopDAO shopDAO;
	
    /**
     * Default constructor. 
     */
    public ShopServlet() {
    	this.shopDAO = ShopDAO.getInstance();
    }

	/**
	 * Retrieves shop list and redirects to shops.jsp page
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Shop> shops = shopDAO.getAll();
			request.setAttribute("shops", shops);
			request.getRequestDispatcher("/shops.jsp").forward(request, response);
		} catch (OperationFailedException e) {
			e.printStackTrace();
			request.setAttribute("title", "Error page");
			request.setAttribute("message", "Cannot load shop list!");
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		}
	}

	/**
	 * Registers new shop
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String shopName = request.getParameter("shopName");
			String shopAddress = request.getParameter("shopAddress");
			if (shopAddress.equals("") || shopName.equals("")) {
				throw new OperationFailedException("Field is empty");
			}
			
			Shop shop = new Shop();
			shop.setAddress(shopAddress);
			shop.setName(shopName);
			
			long shopId;
			shopId = shopDAO.create(shop);
			shop.setId(shopId);
//			System.out.println("New shop was created: " + shop);
			request.setAttribute("title", "Success page");
			request.setAttribute("message", "New shop was successfully created!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("title", "Error page");
			request.setAttribute("message", "Creation of new shop was failed!");
		}
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}	

}
