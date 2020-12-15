package semweb;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.vocabulary.RDF;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class Main {
	
	private static final String FILE_STATIONS = "../donnees/gares-tgv-modified.csv";
	
	public static void main(String[] args) throws IOException{
		
		Model model = ModelFactory.createDefaultModel();
		
		Ontology o = new Ontology();
				
		//Resource exx = model.createResource("http://example.com/");
		Resource stations = model.createResource(o.getStations());
		Resource regions = model.createResource(o.getRegions());
		Resource depts = model.createResource(o.getDepts());

		//Resource Schemas = model.createResource("http://schema.org/");
		Resource TrainStations = model.createResource(o.getTrainStations());
		
		Property hasName = model.createProperty(o.getHasName());
		Property hasLatitude = model.createProperty(o.getHasLatitude());
		Property hasLongitude = model.createProperty(o.getHasLongitude());
		Property addressRegion = model.createProperty(o.getAddressRegion());
		Property addressLocality = model.createProperty(o.getAddressLocality());
		Property geoWithin = model.createProperty(o.getGeoWithin());
		Property hasId = model.createProperty(o.getHasId());
		
		//CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
		//Reader stations_reader = Files.newBufferedReader(Paths.get(FILE_STATIONS));
		//CSVReader stations_csvreader = new CSVReaderBuilder(stations_reader).withCSVParser(parser).build();
		
		Reader stations_reader = new FileReader(FILE_STATIONS, StandardCharsets.UTF_8);
		CSVReader stations_csvreader = new CSVReader(stations_reader);
	    
		String[] next_line;
		next_line = stations_csvreader.readNext();

		
		while ((next_line = stations_csvreader.readNext()) != null) {
			
			Resource station = model.createResource(stations + next_line[0]);
			Resource region = model.createResource(regions + next_line[2]);
			Resource dept = model.createResource(depts + next_line[4]);
			
			Literal name_station = model.createLiteral(next_line[1], "fr");
			Literal name_region = model.createLiteral(next_line[3]);
			Literal name_dept = model.createLiteral(next_line[5]);
			
			Literal id = model.createLiteral(next_line[0]);
			//Literal lat = model.createLiteral(next_line[6]);
			Literal lat = model.createTypedLiteral(next_line[6], XSDDatatype.XSDdouble);
			//Literal lon = model.createTypedLiteral(next_line[7]);
			Literal lon = model.createTypedLiteral(next_line[7], XSDDatatype.XSDdouble);
			
			model.add(station, RDF.type, TrainStations);
			model.add(station, hasName, name_station);
			model.add(station, hasLatitude, lat);
			model.add(station, hasLongitude, lon);
			model.add(region, hasName, name_region);
			model.add(dept, hasName, name_dept);			
			model.add(station, addressRegion, region);
			model.add(station, addressLocality, dept);
			model.add(dept, geoWithin, region);
			model.add(station, hasId, id);
				
			
		}
		model.write(System.out, "Turtle");
		
		String datasetURL = o.getTrainStationsDB();
		String sparqlEndpoint = datasetURL + "/sparql";
		String sparqlUpdate = datasetURL + "/update";
		String graphStore = datasetURL + "/data";
		RDFConnection conneg = RDFConnectionFactory.connect(sparqlEndpoint,sparqlUpdate,graphStore);
		conneg.load(model);
		
		System.out.print("Done !");
		stations_csvreader.close(); 
		
		conneg.close(); 
		
		/*
		String datasetURL = "http://localhost:3030/test";
		String sparqlEndpoint = datasetURL + "/sparql";
		String sparqlUpdate = datasetURL + "/update";
		String graphStore = datasetURL + "/data";
		RDFConnection conneg = RDFConnectionFactory.connect(sparqlEndpoint,sparqlUpdate,graphStore);

		Query query = QueryFactory.create("SELECT ?subject ?predicate ?object\r\n"
				+ "WHERE {\r\n"
				+ "  ?subject <http://schema.org/addressLocality> ?object.\r\n"
				+ "}\r\n"
				+ "LIMIT 50");
		System.out.print("Here");
		QueryExecution qExec = conneg.query(query) ;

		ResultSet rs = qExec.execSelect() ; 
		
		System.out.print("There\n");
		
		QuerySolution qs = rs.next() ;
		qs = rs.next() ;
    	Resource subject = qs.getResource("subject") ;
    	System.out.println("Subject: "+subject) ; 
		
		qExec.close() ;

		conneg.close() ;
		
		
		
		/*Consumer<ResultSet> rs = null;
		conneg.queryResultSet(query, rs);
		System.out.print("Aqui");*/
		
		//return rs;
		
	}
}	