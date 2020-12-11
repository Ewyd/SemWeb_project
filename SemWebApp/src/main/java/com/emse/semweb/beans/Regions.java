package com.emse.semweb.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;


public class Regions {

	
	public Regions() {
	}
	
	public Map<String, List<String>> getRegions() {
		
		Ontology o = new Ontology();
		
		
		String datasetURL = o.getTrainStationsDB();
		String sparqlEndpoint = datasetURL + "/sparql";
		String sparqlUpdate = datasetURL + "/update";
		String graphStore = datasetURL + "/data";
		RDFConnection conneg = RDFConnectionFactory.connect(sparqlEndpoint,sparqlUpdate,graphStore);
		
		Query query = QueryFactory.create("SELECT DISTINCT ?code_region ?region\r\n"
				+ "WHERE {\r\n"
				+ "  ?code_region <" + o.getHasName() + "> ?region.\r\n"
				+ "  ?station <" + o.getAddressRegion() + "> ?code_region.\r\n"
				+ "}\r\n"
				+ "ORDER BY ASC(?code_region)\r\n"
				+ "LIMIT 50");
		
		QueryExecution qExec = conneg.query(query) ;
		ResultSet rs = qExec.execSelect() ; 
		
		List<String> regions = new ArrayList<String>();
		List<String> code_regions = new ArrayList<String>();
		Map<String, List<String>> r= new HashMap<String, List<String>>();
		

		Integer i = 0;
    	while(rs.hasNext()) {
    		i = i + 1;
    		
		    QuerySolution qs = rs.next() ;
		    
		    Literal region = (Literal) qs.getLiteral("region") ;
		    
		    Resource code_region = (Resource) qs.getResource("code_region");
		    String uri_code_region = code_region.getURI();
		    String num_region = uri_code_region.substring(o.getRegions().length());
		    
		    regions.add(region.getString());
		    code_regions.add(num_region);
		    
		}
		qExec.close();
		conneg.close();
		r.put("regions", regions);
		r.put("code_regions", code_regions);
		
		return r;
	}
	
}