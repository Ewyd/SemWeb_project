# SemWeb_project

This repository contains the files that answer the project of Semantic Web 2020, class followed with teacher Mr Antoine Zimmermann

## Goals

Make a Web application that integrates geospatial data from mutiple sources.

This project indexes **all train stations** in France. They can be **ordered by department** if need. Moreover, the user can **search the nearest station** of its position by entering geographic coordinates.

## Datasets
### Java project *database*

The main [dataset](https://github.com/Ewyd/SemWeb_project/blob/main/donnees/referentiel-gares-voyageurs.csv) that was used for this project contains some information on the train stations like their name or ID as well as geographic information like their department or their coordinates.

We used departements names and numbers to offer a classification of stations.

Then, concerning the data that only concern one station, they are displayed on their web pages. Finally, to expand the impact of data, we resort to another [dataset](https://github.com/Ewyd/SemWeb_project/blob/main/donnees/horaires-des-gares1.csv) to display opening hours.

The project [dataset](https://github.com/Ewyd/SemWeb_project/dataset) processes the csv files and uploads their contents as triples in a jena fuseki triplestore.

## Semantic Web application
### Java project *SemWebApp*

This project [SemWebApp](https://github.com/Ewyd/SemWeb_project/SemWebApp) creates the web application and allows us to run it. It's a maven project, working with the maven-tomcat plugin. 

There are three types of files in this Java project.

1. Java files in the "beans" folder

    These files are responsible of making requests to the server. That includes the SPARQL queries to acquire information. These requests includes the SPARQL queries and the storage of these pieces of information that are picked up.

2. JSP files in the "webapp" folder

    These files are written in a mix of Java and HTML and are used to displayed the information on the web pages as well as making links between the different pages.

3. Java files in the "servlet" folder

    These files are servlets, that make the link between the two previous kind of files.


## Tutorial

To test the project and search for train stations, you must follow the next steps:
- Clone this GitHub repository.
- Import both projects *database* and *SemWebApp* in Java IDE.
- Launch Jena Fuseki, create a database "DB_TrSt".
- Launch database.main from your Java IDE.
- Execute the Web application: here is a [tutorial](https://o7planning.org/fr/10133/executez-l-application-web-java-maven-dans-tomcat-maven-plugin) if don't know how to use Tomcat.
- Go to the following webpage: **localhost:8080/SemWebApp**.

If everything worked well, you should now be on the "Train stations localisation web app" webpage


## Contributors
COTTARD Marion, BRENNAN Damien
