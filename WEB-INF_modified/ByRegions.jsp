<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.jena.rdf.model.Literal, java.util.List, org.apache.jena.rdf.model.Resource"  %>
<!DOCTYPE html>


<html>
    <head>
        <meta charset="utf-8" />
        <title>Sort by regions</title>
    </head>

    <body>
        <h1>Sort by region </h1>
        <h2>Choose the region to access the stations</h2>

        <table style="width:20%">
            <tr>
                <th>Region_id</th>
                <th>Region_name</th>
            </tr>

            <tr>
            <% 
        	   List<String> rs = (List<String>) request.getAttribute("liste_regions");
        	   List<String> cr = (List<String>) request.getAttribute("code_regions");
        	   //QuerySolution qs = rs.get(0) ;
        	   //Resource subject = qs.getResource("s") ;
        	   //Resource subject = rs.get(0);
        	   //out.println("Subject: "+subject) ;
        	
        	   for( int i = 0; i < rs.size(); i++ ){
                    out.println("<td> " + cr.get(i) "</td>");
                    out.println("<td> " + rs.get(i) + "</td>");	
                }
            %>
            </tr>
        </table>
    </body>
</html>