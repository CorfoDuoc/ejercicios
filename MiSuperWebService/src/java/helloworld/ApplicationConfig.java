package helloworld;

import javax.ws.rs.core.Application;

//Aqui definimos donde esta el webservice para poder llamarlo
//http://localhost:8080/MiSuperWebService/RESOURCES/greeting
//Defino donde lo puedo encontrar para efectos de TEST
//Proyecto Web->boton derecho mouse->Test RESTFull Web Service
//ojo en la URL resources va con minusculas
@javax.ws.rs.ApplicationPath("resources")
public class ApplicationConfig extends Application {

}