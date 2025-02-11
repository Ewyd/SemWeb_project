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

import com.emse.semweb.beans.Coordinates;

public class ByCoordinates  extends HttpServlet {

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	    String lat = request.getParameter("latitude");
	    String lon = request.getParameter("longitude");
	    String max_dist = request.getParameter("max_dist");
	    String num_results = request.getParameter("num_results");
	    
	    boolean conditions_ok = true;
	    
	    try{
	        Float.parseFloat(lat);
	        Float.parseFloat(lon);
	        if (!(max_dist.equals(""))){
	        	Integer.parseInt(max_dist);
	        }
	        if (!(num_results.equals(""))){
	        	Integer.parseInt(num_results);
	        }
	    }catch(Exception e){
	    	conditions_ok = false;
	        request.setAttribute("ErrorMessage", "1");
	        this.getServletContext().getRequestDispatcher( "/WEB-INF/Search.jsp" ).forward( request, response );
	    }
	        
	    if (conditions_ok){
	    	Coordinates coo = new Coordinates(lat, lon, max_dist, num_results);  
	    	Map<String, List<String>> rs = coo.getStations();
		
	    	Set<String> keys = rs.keySet();
	    	Iterator<String> i = keys.iterator();
	    	while (i.hasNext()) {
	    		String k = (String) i.next();
	    		request.setAttribute(k, rs.get(k));
	    	}
			
	    	this.getServletContext().getRequestDispatcher( "/WEB-INF/Results.jsp" ).forward( request, response );
	        
	    }    
	        
	        
	}     
	        
	        
	        
}
