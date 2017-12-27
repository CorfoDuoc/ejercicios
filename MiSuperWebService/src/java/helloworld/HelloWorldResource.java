package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonReader;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

//Este es el web service rest de verdad que implemente solo GET/PUT

/**
 * REST Web Service
 *
 * @author mkuchtiak
 */

//Este es el verdadero WEB SERVICE REST
//http://localhost:8080/MiSuperWebService/resources/GREETING
//Defino donde lo puedo encontrar para efectos de TEST
//Proyecto Web->boton derecho mouse->Test RESTFull Web Service
//ojo en la URL greeting va con minusculas
@Stateless
@Path("/greeting")
public class HelloWorldResource {

    //esta es la variable para la instancia singleton de la clase pojo
    //private NameStorageBean nameStorage = new NameStorageBean();
    @EJB
    private NameStorageBean nameStorage; //Singleton

    /**
     * Retrieves representation of an instance of helloworld.HelloWorldResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String traerStringDesdeElServerConGET() throws MalformedURLException, IOException {
        //return "<html><body><h1>Hello "+nameStorage.getName()+"!</h1></body></html>";
        //llamada al pojo
        //return nameStorage.getName(); //only string
        
        //Paso 4: pedir a miindicador.cl lo que corresponda
        URL url = new URL("http://www.mindicador.cl/api/" + this.nameStorage.getName());
        URLConnection uc = url.openConnection();
        uc.connect();
        //Creamos el objeto con el que vamos a leer
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String inputLine;
        String contenido = "";
        while ((inputLine = in.readLine()) != null) {
            contenido += inputLine;
        }
        in.close();
        
        
        //Paso 5: devolver al cliente la respuesta
        return contenido;

        /*
        String json = "una cadena json";
        return json;
        */
    
    }

    /**
     * PUT method for updating an instance of HelloWorldResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/plain")
    public void colocarEnElServerConPUT(String content) {
        //llmada al pojo
        nameStorage.setName(content);
    }
}
