<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.jena.rdf.model.Literal, java.util.List, org.apache.jena.rdf.model.Resource"  %>
<!DOCTYPE html>


<html>
    <head>
        <meta charset="utf-8" />
        <title>Tri par département</title>
    </head>

    <body>
        <h1> Tri par département : </h1>
        <ul>
        <% 
        	List<Literal> rs = (List<Literal>) request.getAttribute("liste_departements");
    		List<String> cd = (List<String>) request.getAttribute("code_depts");
        	//QuerySolution qs = rs.get(0) ;
        	//Resource subject = qs.getResource("s") ;
        	//Resource subject = rs.get(0);
        	//out.println("Subject: "+subject) ;
        	
        	for( int i = 0; i < rs.size(); i++ ){
                out.println("<li> " + cd.get(i) + " - " + rs.get(i) + "</li>");	
            }
        %>
        </ul>
    </body>