<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.jena.rdf.model.Literal, java.util.List, org.apache.jena.rdf.model.Resource"  %>
<!DOCTYPE html>


<html>
    <head>
        <meta charset="utf-8" />
        <title>Sort by region</title>
    </head>

    <body>
        <h1>Sort by region </h1>
        <h2>Choose the region to access the stations</h2>
        <table  style="width:20%">
        	<tr>
                <th>Region_id</th>
                <th>Region_name</th>
            </tr>
        	<% 
        		String url = (String) request.getAttribute("web_app_url");
        
        		List<String> rs = (List<String>) request.getAttribute("liste_regions");
        		List<String> cr = (List<String>) request.getAttribute("code_regions");

        	
        		for( int i = 0; i < rs.size(); i++ ){
        			out.println("<tr>");
                	out.println("<td>" + cr.get(i) + "</td>");
                	out.println("<td><a href=/SemWebApp/sect?secteur=reg&id=" + cr.get(i) + ">" + rs.get(i) + "</a></td>");	
            		out.println("</tr>");
        		}
        	%>
        </table>
    </body>
</html>