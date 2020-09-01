package com.gamestore.controller.admin.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamestore.service.CategoryServices;


@WebServlet("/admin/list_category")
public class ListCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCategoryServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("list");
		CategoryServices categoryServices= new CategoryServices(request, response);
		categoryServices.listCategory();
	}

}