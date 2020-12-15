package com.emse.semweb.beans;

public class Ontology{
	
	private String stations;
	private String regions;
	private String depts;
	private String TrainStations;
	private String hasName;
	private String hasLatitude;
	private String hasLongitude;
	private String addressRegion;
	private String addressLocality;
	private String geoWithin;
	private String hasId;
	private String TrainStationsDB;
	
	
	
	public Ontology() {
		String exx = "http://example.com/";
		String stations = exx + "stations/";
		this.stations = stations;
		String regions = exx + "regions/";
		this.regions = regions;
		String depts = exx + "departements/";
		this.depts = depts;

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
		String geoWithin = Schemas + "geoWithin";
		this.geoWithin = geoWithin;
		String hasId = Schemas + "identifier";
		this.hasId = hasId;
		
		this.TrainStationsDB = "http://localhost:3030/n_test_dataset";
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
	
	
}