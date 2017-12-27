/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import WEBSERVICE.NewJerseyClient;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Concepción
 */
public class Indicadores {
    private ArrayList indicadores = new ArrayList();

    public ArrayList getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(ArrayList indicadores) {
        this.indicadores = indicadores;
    }
    
    public ArrayList HaceLaPegaConsulta1(String indicador)
    {
        //crearemos una conexion al webservice
        NewJerseyClient ws = new NewJerseyClient();
        
        //le mandamos el valor selecionado por el usuario 
        ws.colocarEnElServerConPUT(indicador);
        
        //pedimos la respuesta del ws que viene en un string que tienen json
        String respuestaWsJson = ws.traerStringDesdeElServerConGET();
        
        //JOptionPane.showMessageDialog(this, respuestaWsJson);
        
        //String a InputStream, para hacerlo leso
        //String respuestaWsJson -> InputStream in para hacer leso al createReader
        InputStream in = IOUtils.toInputStream(respuestaWsJson);
        
        //procesa Json                  InputStream por eso usamos IOUtils 
        JsonReader jr = Json.createReader(in);
        
        //viene objeto en el json por eso readObject
        //pongo las lecturas en funcion de lo que viene en el json
        //object-array-object en todos los casos
        JsonObject o = jr.readObject();
        
        //pido el array llamado serie del objeto que viene primero
        //en el fondo el JsonArray es como ArrayList...
        JsonArray a = o.getJsonArray("serie");
        
        //JOptionPane.showMessageDialog(this, a);
        
        
        //borro arraylist
        this.indicadores.removeAll(indicadores);
        //itero todos los objetos del array json
        Iterator it = a.iterator();
        
        while (it.hasNext())
        {
            //objecto un objeto con sabor JsonObject
            JsonObject o2 = (JsonObject) it.next();
            
            //recupero fecha y valor del json
            //o2 es json Object y me presta metodos para obtener los valores
            //usando la API del json
            JsonString fecha = o2.getJsonString("fecha");
            JsonNumber valor = o2.getJsonNumber("valor");
            
            //System.out.println (fecha.getString() + " " + valor.doubleValue());
        
            //clonar cajon de tomates
            //crear instancia de indicador segun nuestro MODELO
            Indicador uni = new Indicador();
            //llenar con seters
            uni.setFecha(fecha.getString());
            uni.setValor(valor.doubleValue());
            
            //almacenarlo en arraylist nuestro segun nuestro MODELO
            //ArrayList alst = ids.getIndicadores();
            //alst.add(uni);
            this.indicadores.add(uni);
           
        }//while serie del json, iterator
        
        return indicadores;
    }
    
    
    public double HaceLaPegaConsulta2(int dia1, int dia2)
    {
        //dia1 y dia2 cero based vienen listos
        Indicador i1 = (Indicador)this.indicadores.get(dia1);
        Indicador i2 = (Indicador)this.indicadores.get(dia2);
        
        double r = i2.getValor()-i1.getValor();
        return r;
    }
    
    public int HaceLaPegaConsulta3()
    {
        int dia = 11;
        Indicador i = (Indicador)this.indicadores.get(dia); //dia 10
        
        //puedo hacer lo que quiere
        System.out.println(i);
        
        return dia;
    }
    
}
