<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.jena.rdf.model.Literal, java.util.List, org.apache.jena.rdf.model.Resource"  %>
<!DOCTYPE html>


<html prefix = "rdfs: <https://www.w3.org/2000/01/rdf-schema#>.
				ex <http://example.org/> .">
    <head>
        <meta charset="utf-8" />
        <title rdfs:label>Semantic Web project Brennan-Cottard</title>
    </head>

    <body>
        <h1> <dd>TGV stations localisation web app </h1>
        <h2>Choose the way you want to research your train station</h2>

		<ul>
		
			<% String url = (String) request.getAttribute("web_app_url");
			
			String url_reg = url + "/regions";
			String url_dept = url + "/departements";
			String url_all = url + "/all-stations";
			
			out.println("<li><a href="+ url_reg + ">Tri par régions</a></li>");
			out.println("<li><a href=" + url_dept + ">Tri par départements</a></li>");
			out.println("<li><a href=" + url_all + ">Toutes les gares</a></li>");
			%>
		</ul>
    </body>
</html>