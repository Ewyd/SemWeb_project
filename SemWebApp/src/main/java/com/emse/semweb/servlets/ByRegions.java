package com.emse.semweb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;

import com.emse.semweb.beans.Regions;



public class ByRegions extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ByRegions(){
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Regions regions = new Regions();
		Map<String, List<String>> rs = regions.getRegions();
		
		request.setAttribute("liste_regions", rs.get("regions"));
		request.setAttribute("code_regions", rs.get("code_regions"));
		this.getServletContext().getRequestDispatcher( "/WEB-INF/ByRegions.jsp" ).forward( request, response );
	}

}