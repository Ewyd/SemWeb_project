<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.emse.semweb.beans.Ontology"  %>
<!DOCTYPE html>


<html prefix="xsd: https://www.w3.org/2001/XMLSchema#">
    <head>
        <meta charset="utf-8" />
        <title>Results</title>
    </head>

    <body>
        <h1>Stations close to your position</h1>
        <%
	    	String lat = request.getParameter("latitude");
	    	String lon = request.getParameter("longitude");
	    	String max_dist = request.getParameter("max_dist");
	    	String num_results = request.getParameter("num_results");
	    	out.println("<p>");
	    	out.println("Your position : <br/>");
	    	out.println("Latitude : " + lat);
	    	out.println("Longitude : " + lon);
	    	out.print("<br/>");
	    	if (!(max_dist.equals(""))){
	    		out.println("You asked to see the stations in a radius of " + max_dist + "kms.");
	    	}
	    	
	    	out.println("</p>");
        %>

        <table style="width:60%">
        <%     		
    		
    		List<String> stations_uri = (List<String>) request.getAttribute("stations_uri");
    		List<String> stations = (List<String>) request.getAttribute("stations");
    		List<String> stations_id = (List<String>) request.getAttribute("stations_id");
    		List<String> latitudes = (List<String>) request.getAttribute("lat");
    		List<String> longitudes = (List<String>) request.getAttribute("lon");
    		List<String> depts = (List<String>) request.getAttribute("depts");
    		List<String> regions = (List<String>) request.getAttribute("regions");
    		List<String> distances = (List<String>) request.getAttribute("distances");
        	
    		Ontology o = new Ontology();    		
    		
    		if (stations.size() == 0){
    			out.println("<p>");
        		out.println("We found no stations corresponding to your criterias");
        		out.println("</p>");
        	}
    		else{
    			out.println("<tr> <th>Station number </th> <th>Station name </th> <th>Department name </th> <th>Latitude </th> <th>Longitude </th> <th>Approximate distance </th></tr> ");
    		}
    		for( int i = 0; i < stations.size(); i++ ){
        		out.println("<tr about=\"" + stations_uri.get(i) +  "\">");
        		
               	out.println("<td rel=\"" + o.getHasId() + "\" datatype=\"xsd:integer\">"+ stations_id.get(i) + "</td>");
               	out.println("<td property=\"" + o.getHasName() +  "\">" + stations.get(i) + "</td>");
               	out.println("<td property=\"" + o.getAddressRegion() +  "\">" +  depts.get(i) + "</td>");
               	out.println("<td property=\"" + o.getHasLatitude() + "\" datatype=\"xsd:float\">" + latitudes.get(i) + "</td>");
               	out.println("<td property=\"" + o.getHasLongitude() + "\" datatype=\"xsd:float\">" + longitudes.get(i) + "</td>");
               	out.println("<td property=\"" + o.getDistance() + "\" datatype=\"xsd:float\">" + distances.get(i).substring(0, 6) + "kms</td>");
                	
               	out.println("</tr>");
        	}
        	
        	
        %>
        </table>
    </body>
</html>    
    