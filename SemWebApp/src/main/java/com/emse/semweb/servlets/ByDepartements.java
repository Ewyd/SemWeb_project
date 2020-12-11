package com.emse.semweb.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emse.semweb.beans.Departements;
import com.emse.semweb.beans.WebAppUrl;

public class ByDepartements extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ByDepartements(){
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Departements departements = new Departements();
		Map<String, List<String>> rs = departements.getDepartements();
		
		request.setAttribute("liste_departements", rs.get("departements"));
		request.setAttribute("code_depts", rs.get("code_dept"));
		
		WebAppUrl wa = new WebAppUrl(request);
		String url = wa.getURL();
		request.setAttribute("web_app_url", url);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/ByDepartements.jsp" ).forward( request, response );
	}

}