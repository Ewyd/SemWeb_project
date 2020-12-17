<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.emse.semweb.beans.Ontology"  %>
<!DOCTYPE html>


<html prefix="xsd: https://www.w3.org/2001/XMLSchema#">
    <head>
        <meta charset="utf-8" />
        <title>Station</title>
    </head>
    
    <%
			List<String> stations = (List<String>) request.getAttribute("stations");
			List<String> stations_uri = (List<String>) request.getAttribute("stations_uri");
			List<String> latitudes = (List<String>) request.getAttribute("lat");
    		List<String> longitudes = (List<String>) request.getAttribute("lon");
    		List<String> depts = (List<String>) request.getAttribute("depts");
        	List<String> cities = (List<String>) request.getAttribute("cities");
        	List<String> ohs = (List<String>) request.getAttribute("ohs");
        	Ontology o = new Ontology();

        	out.println("<body about=\"" + stations_uri.get(0) + "\">");
        	
        	
				out.println("<h1 property=\"" + o.getHasName() + "\">");
				out.println(stations.get(0));
				out.println("</h1>");	
			
				out.println("<h2>");
				out.println("<span property=\"" + o.getAddress() + "\">");
				out.println(cities.get(0));
				out.println("</span> - ");
				out.println("<span property=\"" + o.getAddressLocality() + "\">");
				out.println(depts.get(0));
				out.println("</span>");
				out.println("</h2>");
				
				
				out.println("<p>");
				out.println("Coordinates : <br/>");
				out.println("<ul>");
				out.println("<li>Latitude : <span property=\"" + o.getHasLatitude() + "\" datatype=\"xsd:float\">" + latitudes.get(0) + "</span></li>");
				out.println("<li>Longitude : <span property=\"" + o.getHasLongitude() + "\" datatype=\"xsd:float\">" + longitudes.get(0) + "</span></li>");
				out.println("</ul>");
				out.println("</p>");
			
				out.println("<p>");
				
				if (ohs.size() != 0){
					out.println("Opening Hours : ");
					out.println("<ul>");
					for ( int i = 0; i < ohs.size(); i++ ){
						out.println("<li property=\"" + o.getOpeningHours() + "\">");
						out.println(ohs.get(i));
						out.println("</li>");	
					}
					out.println("</ul>");	
				}
				else{
					out.println("We don't have any information about this station's opening hours.");
				}
				out.println("</p>");
			
			
			
			out.println("</body>");
		%>
		
</html>	
		
		
		
		