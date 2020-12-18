package database;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.vocabulary.RDF;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	
	private static final String FILE_STATIONS = "../donnees/referentiel-gares-voyageurs.csv";
	private static final String FILE_TIMESHEET = "../donnees/horaires-des-gares1.csv";
	
	public static void main(String[] args) throws IOException{
		
		Model model = ModelFactory.createDefaultModel();
		
		Ontology o = new Ontology();
				
		Resource stations = model.createResource(o.getStations());
		Resource depts = model.createResource(o.getDepts());
		Resource cities = model.createResource(o.getCities());

		Resource TrainStations = model.createResource(o.getTrainStations());
		
		Property hasName = model.createProperty(o.getHasName());
		Property hasLatitude = model.createProperty(o.getHasLatitude());
		Property hasLongitude = model.createProperty(o.getHasLongitude());
		Property address = model.createProperty(o.getAddress());
		Property addressLocality = model.createProperty(o.getAddressLocality());
		Property geoWithin = model.createProperty(o.getGeoWithin());
		Property hasId = model.createProperty(o.getHasId());
		
		CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
		Reader stations_reader = Files.newBufferedReader(Paths.get(FILE_STATIONS));
		CSVReader stations_csvreader = new CSVReaderBuilder(stations_reader).withCSVParser(parser).build();
	    
		String[] next_line;
		next_line = stations_csvreader.readNext();

		
		while ((next_line = stations_csvreader.readNext()) != null) {
			
			
			Resource station = model.createResource(stations + next_line[1]);
			Resource city = model.createResource(cities + next_line[4] + "_" + next_line[5]);
			Resource dept = model.createResource(depts + next_line[7]);
			
			Literal name_station = model.createLiteral(next_line[17], "fr");
			Literal name_city = model.createLiteral(next_line[6], "fr");
			Literal name_dept = model.createLiteral(next_line[8]);
			
			Literal id = model.createLiteral(next_line[1]);
			Literal lat = model.createTypedLiteral(next_line[10], XSDDatatype.XSDdouble);
			Literal lon = model.createTypedLiteral(next_line[9], XSDDatatype.XSDdouble);
			
			model.add(station, RDF.type, TrainStations);
			model.add(station, hasName, name_station);
			model.add(station, hasLatitude, lat);
			model.add(station, hasLongitude, lon);
			model.add(city, hasName, name_city);
			model.add(dept, hasName, name_dept);			
			model.add(station, address, city);
			model.add(station, addressLocality, dept);
			model.add(city, geoWithin, dept);
			model.add(station, hasId, id);
				
			
		}
		
		CSVParser parser2 = new CSVParserBuilder().withSeparator(';').build();
		Reader timesheet_reader = Files.newBufferedReader(Paths.get(FILE_TIMESHEET));
		CSVReader timesheet_csvreader = new CSVReaderBuilder(timesheet_reader).withCSVParser(parser2).build();
		
		Property openingHours = model.createProperty(o.getOpeningHours());
		
		String[] next_line2;
		next_line2 = timesheet_csvreader.readNext();
				
		while ((next_line2 = timesheet_csvreader.readNext()) != null) {		
			Resource station = model.createResource(stations + next_line2[0]);
			
			String fr_day = next_line2[2];
			String day = "";
			if (fr_day.equals("Lundi")) {
				day = "1 - Monday";
			}
			else if (fr_day.equals("Mardi")) {
				day = "2 - Tuesday";
			}
			else if (fr_day.equals("Mercredi")) {
				day = "3 - Wednesday";
			}
			else if (fr_day.equals("Jeudi")) {
				day = "4 - Thursday";
			}
			else if (fr_day.equals("Vendredi")) {
				day = "5 - Friday";
			}
			else if (fr_day.equals("Samedi")) {
				day = "6 - Saturday";
			}
			else if (fr_day.equals("Dimanche")) {
				day = "7 - Sunday";
			}
			

			Literal hours;
			if (next_line2[4].equals("")){
				hours = model.createLiteral(day + " - Normal day : " + next_line2[3]);
			}
			else {
				hours = model.createLiteral(day + " - Normal day : " + next_line2[3] + ", Holiday : " + next_line2[4]);
			}
			
			model.add(station, openingHours, hours);
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
		
		
		
		
		
		
		
		

		
	}
}	