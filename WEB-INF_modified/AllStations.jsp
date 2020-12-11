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
        		out.println("All stations sort by alphabetic ordre"); //Ca pourrait être bien ;)
        	}
        	else{
        		if (secteur.equals("reg")) {
        			out.println("Stations located in region : " + id);
        		}
        		else{
        			out.println("Stations located in department : " + id);
        		}
                out.println("<h2> Every station comes with its geographic coordinates </h2>");
        	}
        
        %> 
        </h1>
        <table style="width:60%">
        <%     		
    		
    		List<String> stations_uri = (List<String>) request.getAttribute("stations_uri");
    		List<String> stations = (List<String>) request.getAttribute("stations");
    		List<String> stations_id = (List<String>) request.getAttribute("stations_id");
    		List<String> latitudes = (List<String>) request.getAttribute("lat");
    		List<String> longitudes = (List<String>) request.getAttribute("lon");
    		List<String> depts = (List<String>) request.getAttribute("depts");
    		List<String> regions = (List<String>) request.getAttribute("regions");
        	
    		if ((secteur == null)||(secteur.equals("reg"))){
                out.println("<tr> <th> Station number </th> <th> Station name </th> <th> Department name </th> <th> Latitude </th> <th> Longitude </th> </tr> <tr>")
        		for( int i = 0; i < stations.size(); i++ ){
                	out.println("<td> "+ stations_id.get(i) + "</td> <td> " + stations.get(i) + "</td> <td> " + depts.get(i) + "</td>");
                	out.println("<td> " + latitudes.get(i) + "</td> <td> " + longitudes.get(i) + "</td>");
            	}
                out.println("</tr>");
    		}
    		else if (secteur.equals("dept")){
                out.println("<tr> <th> Station number </th> <th> Station name </th> <th> Latitude </th> <th> Longitude </th> </tr> <tr>")
    			for( int i = 0; i < stations.size(); i++ ){
    				out.println("<td> "+ stations_id.get(i) + "</td> <td> " + stations.get(i) + "</td>");	
    				out.println("<td> " + latitudes.get(i) + "</td> <td> " + longitudes.get(i) + "</td>");
    			}
                out.println("</tr>");
    		}
        %>
        </table>
    </body>
</html>