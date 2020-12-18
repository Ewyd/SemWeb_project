package com.emse.semweb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emse.semweb.beans.WebAppUrl;



public class Home extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Home(){
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WebAppUrl wa = new WebAppUrl(request);
		String url = wa.getURL();
		request.setAttribute("web_app_url", url);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/HomeView.jsp" ).forward( request, response );
	}

}