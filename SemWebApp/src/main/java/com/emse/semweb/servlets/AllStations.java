package com.emse.semweb.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emse.semweb.beans.AllTheStations;

public class AllStations extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AllStations(){
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		AllTheStations ats = new AllTheStations();
		Map<String, List<String>> rs = ats.getStations();
		
		Set<String> keys = rs.keySet();
		Iterator<String> i = keys.iterator();
		while (i.hasNext()) {
			String k = (String) i.next();
			request.setAttribute(k, rs.get(k));
		}
			
		this.getServletContext().getRequestDispatcher( "/WEB-INF/AllStations.jsp" ).forward( request, response );
	}

}