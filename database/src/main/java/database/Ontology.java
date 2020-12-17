package database;

public class Ontology{
	
	private String stations;
	private String regions;
	private String depts;
	private String cities;
	private String TrainStations;
	private String hasName;
	private String hasLatitude;
	private String hasLongitude;
	private String addressRegion;
	private String address;
	private String addressLocality;
	private String geoWithin;
	private String hasId;
	private String openingHours;
	
	private String TrainStationsDB;
	
	
	
	public Ontology() {
		String exx = "http://example.com/";
		String stations = exx + "stations/";
		this.stations = stations;
		String regions = exx + "regions/";
		this.regions = regions;
		String depts = exx + "departements/";
		this.depts = depts;
		String cities = exx + "cities/";
		this.cities = cities;

		String Schemas = "http://schema.org/";
		String TrainStations = Schemas + "TrainStation";
		this.TrainStations = TrainStations;
		
		String hasName = Schemas + "name";
		this.hasName = hasName;
		String hasLatitude = Schemas + "latitude";
		this.hasLatitude = hasLatitude;
		String hasLongitude = Schemas + "longitude";
		this.hasLongitude = hasLongitude;
		String addressRegion = Schemas + "addressRegion";
		this.addressRegion = addressRegion;
		String addressLocality = Schemas + "addressLocality";
		this.addressLocality = addressLocality;
		String address = Schemas + "postalCode";
		this.address = address;
		String geoWithin = Schemas + "geoWithin";
		this.geoWithin = geoWithin;
		String hasId = Schemas + "identifier";
		this.hasId = hasId;
		String openingHours = Schemas + "openingHours";
		this.openingHours = openingHours;
		
		this.TrainStationsDB = "http://localhost:3030/DB_TrSt";
	}

	public String getStations() {
		return stations;
	}



	public String getRegions() {
		return regions;
	}



	public String getDepts() {
		return depts;
	}



	public String getTrainStations() {
		return TrainStations;
	}



	public String getHasName() {
		return hasName;
	}



	public String getHasLatitude() {
		return hasLatitude;
	}



	public String getHasLongitude() {
		return hasLongitude;
	}



	public String getAddressRegion() {
		return addressRegion;
	}



	public String getAddressLocality() {
		return addressLocality;
	}



	public String getGeoWithin() {
		return geoWithin;
	}



	public String getHasId() {
		return hasId;
	}



	public String getTrainStationsDB() {
		return TrainStationsDB;
	}

	public String getCities() {
		return cities;
	}

	public String getAddress() {
		return address;
	}

	public String getOpeningHours() {
		return openingHours;
	}
	
	
}