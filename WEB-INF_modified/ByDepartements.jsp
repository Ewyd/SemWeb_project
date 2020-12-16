<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.jena.rdf.model.Literal, java.util.List, org.apache.jena.rdf.model.Resource"  %>
<!DOCTYPE html>


<html prefix = "ex: <http://example.org/>.">
    <head>
        <meta charset="utf-8" />
        <title>Sort by regions</title>
    </head>

    <body>
        <h1>Sort by region </h1>
        <h2 ex:departments>Choose the region to access the stations</h2>
        <table>
            <tr>
                <th>Department_id</th>
                <th>Department_name</th>
            </tr>
            <tr>
                <% 
                List<Literal> rs = (List<Literal>) request.getAttribute("liste_departements");
                List<String> cd = (List<String>) request.getAttribute("code_depts");
                //QuerySolution qs = rs.get(0) ;
                //Resource subject = qs.getResource("s") ;
                //Resource subject = rs.get(0);
                //out.println("Subject: "+subject) ;
            
                for( int i = 0; i < rs.size(); i++ ){
                    out.println("<td> " + cd.get(i) "</td>");
                    out.println("<td> " + rs.get(i) + "</td>");  
                }
                %>
            </tr>


        </table>
    </body>
</html>