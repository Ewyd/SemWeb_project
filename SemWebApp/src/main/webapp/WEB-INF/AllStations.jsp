<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.jena.rdf.model.Literal, java.util.List, org.apache.jena.rdf.model.Resource"  %>
<!DOCTYPE html>


<html>
    <head>
        <meta charset="utf-8" />
        <title>Toutes les gares</title>
    </head>

    <body>
        <h1> 
        <%	
        	String id = (String) request.getParameter("id");
        	String secteur = (String) request.getParameter("secteur");
        	if (id == null){
        		out.println("Toutes les gares :");
        	}
        	else{
        		if (secteur.equals("reg")) {
        			out.println("Gares situées dans la région : " + id);
        		}
        		else{
        			out.println("Gares situées dans le département : " + id);
        		}
        	}
        
        
        %> 
        </h1>
        <ul>
        <%     		
    		
    		List<String> stations_uri = (List<String>) request.getAttribute("stations_uri");
    		List<String> stations = (List<String>) request.getAttribute("stations");
    		List<String> stations_id = (List<String>) request.getAttribute("stations_id");
    		List<String> latitudes = (List<String>) request.getAttribute("lat");
    		List<String> longitudes = (List<String>) request.getAttribute("lon");
    		List<String> depts = (List<String>) request.getAttribute("depts");
    		List<String> regions = (List<String>) request.getAttribute("regions");
        	
    		if ((secteur == null)||(secteur.equals("reg"))){
        		for( int i = 0; i < stations.size(); i++ ){
                	out.println("<li> Station n°"+ stations_id.get(i) + " - " + stations.get(i) + " - " + depts.get(i) + "</li>");
                	out.println("	| Latitude : " + latitudes.get(i) + ", Longitude : " + longitudes.get(i));
            	}
    		}
    		else if (secteur.equals("dept")){
    			for( int i = 0; i < stations.size(); i++ ){
    				out.println("<li> Station n°"+ stations_id.get(i) + " - " + stations.get(i) + "</li>");	
    				out.println("	| Latitude : " + latitudes.get(i) + ", Longitude : " + longitudes.get(i));
    			}
    		}
        %>
        </ul>
    </body>