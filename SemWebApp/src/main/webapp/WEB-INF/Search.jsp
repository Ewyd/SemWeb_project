<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8" />
		<title>Nearest stations</title>
	</head>
	
	<body>
		<h1>Find the nearest stations</h1>
		<%
			String error_message = (String) request.getAttribute("ErrorMessage");
			if (error_message.equals("1")){
				out.println("<p>");
				out.println("Error while processing your request. <br/>");
				out.println("Please make sure that all the fields are correctly fulfilled. <br/>");
				out.println("Latitude and longitude should be floating numbers (with \".\", not \",\") or integers. <br/>");
				out.println("The distance and the number of results should be integers. <br/><br/>");
				out.println("</p>");
				out.println("<br/>");
			}
		
		
		%>
		
		
		<form method="post" action="coordinates">
			<fieldset>
				<legend>Your coordinates</legend>
				<p>Please enter your coordinates</p>
				
				<label for="latitude">Latitude*</label>
				<input type="text" id="latitude" name="latitude" value="45" size="20"/>
				<br/>
				<br/>
				
				<label for="longitude">Longitude*</label>
				<input type="text" id="longitude" name="longitude" value="5" size="20"/>
				<br/>
				<br/>
				
				<label for="max_dist">Maximal distance (km)</label>
				<input type="text" id="max_dist" name="max_dist" value="" size="20"/>
				<br/>
				<br/>
				
				<label for="num_results">Number of results</label>
				<input type="text" id="num_results" name="num_results" value="10" size="20"/>
				<br/>
				<br/>
				
				<input type="submit" value="Search"/>
				<input type="reset" value="Reset"/>
			</fieldset>
		
		</form>
	
	
	</body>
	



</html>