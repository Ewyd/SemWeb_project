<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta charset="utf-8" />
        <title>Test</title>
    </head>

    <body>
        <h1>Trouvez la gare la plus proche !</h1>

		<ul>
		
			<% String url = (String) request.getAttribute("web_app_url");
			String url_reg = url + "/regions";
			String url_dept = url + "/departements";
			String url_all = url + "/all";
			
			//out.println("<li><a href="+ url_reg + ">Tri par régions</a></li>");
			out.println("<li><a href=/regions> Tri par régions</a></li>");
			out.println("<li><a href=" + url_dept + ">Tri par départements</a></li>");
			out.println("<li><a href=" + url_all + ">Toutes les gares</a></li>");
			%>
		</ul>
    </body>
</html>