<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="com.emse.semweb.beans.WebAppUrl" %>
<!DOCTYPE html>


<html>
    <head>
        <meta charset="utf-8" />
        <title>Semantic Web project Brennan-Cottard</title>
    </head>

    <body>
        <h1> <dd> Train stations localisation web app </h1>
        <h2>Choose the way you want to research your train station</h2>

		<ul>
		
			<% 
			
			String url = "/SemWebApp";
			
			//String url_reg = url + "/regions";
			String url_dept = url + "/departements";
			String url_all = url + "/all-stations";
			String url_search = url + "/search";
			
			//out.println("<li><a href=" + url_reg + ">Sort by regions</a></li>");
			out.println("<li><a href=" + url_dept + ">Sort by department</a></li>");
			out.println("<li><a href=" + url_all + ">All stations</a></li>");
			out.println("<li><a href=" + url_search + ">Search the nearest stations</a></li>");
			%>
		</ul>
    </body>
</html>