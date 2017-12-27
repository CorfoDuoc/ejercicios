/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import WEBSERVICE.NewJerseyClient;
import vista.Vista;

/**
 *
 * @author Concepción
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new Vista().setVisible(true);
        
        //PASO 1: Puedo enviar lo que quiero al server
        //NewJerseyClient ws = new NewJerseyClient();
        //ws.colocarEnElServerConPUT("uf");
        
        
        //System.out.println(ws.traerStringDesdeElServerConGET());
        
        
        
    }
    
}
