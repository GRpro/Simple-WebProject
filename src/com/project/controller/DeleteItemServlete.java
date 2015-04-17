package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.ItemDAO;
import com.project.exceptions.OperationFailedException;

/**
 * Servlet implementation class DeleteItemServlete
 */
@WebServlet("/delete/item")
public class DeleteItemServlete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ItemDAO itemDAO;
    
    public DeleteItemServlete() {
       this.itemDAO = ItemDAO.getInstance();
    }

	/**
	 * Deletes item
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long itemId = Long.parseLong(request.getParameter("itemId"));
			itemDAO.delete(itemId);
			request.setAttribute("title", "Success page");
			request.setAttribute("message", "Item was successfully deleted!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("title", "Error page");
			request.setAttribute("message", "Deletion of item failed!");
		}
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}


}
