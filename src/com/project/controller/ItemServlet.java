package com.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.ItemDAO;
import com.project.entities.Item;
import com.project.entities.Shop;
import com.project.exceptions.OperationFailedException;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/shop/items")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ItemDAO itemDAO;
	
    public ItemServlet() {
        this.itemDAO = ItemDAO.getInstance();
    }

	/**
	 * Returns list of items related to particular shop
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long shopId = Long.parseLong(request.getParameter("shopId"));
			List<Item> items = itemDAO.getByShopId(shopId);
			request.setAttribute("items", items);
			request.getRequestDispatcher("/items.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("title", "Error page");
			request.setAttribute("message", "Cannot load item list!");
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		}
	}

	/**
	 * Registers new item
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long shopId = Long.parseLong(request.getParameter("shopId"));
			float price = Float.parseFloat(request.getParameter("itemPrice"));
			String name = request.getParameter("itemName");
			if (name.equals("")) {
				throw new OperationFailedException("Field 'name' is empty");
			}
			
			Item item = new Item();
			item.setName(name);
			item.setPrice(price);
			item.setShopId(shopId);
			
			shopId = itemDAO.create(item);
			item.setId(shopId);
			System.out.println("New item was created: " + item);
			request.setAttribute("title", "Success page");
			request.setAttribute("message", "New item was successfully created!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("title", "Error page");
			request.setAttribute("message", "Creation of new item was failed!");
		}
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}


}
