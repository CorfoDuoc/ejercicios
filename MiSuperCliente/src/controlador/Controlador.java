/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Indicadores;

/**
 *
 * @author Concepción
 */
public class Controlador {
    
    private Indicadores ids = new Indicadores();

    //Lo ocupo en consulta2 en jbutton Vista
    public Indicadores getIds() {
        return ids;
    }
    
    //Un metodo x caso de uso
    public ArrayList consulta1(String indicador)
    {
        return ids.HaceLaPegaConsulta1(indicador);
    }
    
    public double consulta2(int dia1, int dia2)
    {
        return ids.HaceLaPegaConsulta2(dia1, dia2);
    }
    
    public int consulta3()
    {
        return ids.HaceLaPegaConsulta3();
    }
    
    public void consulta4()
    {
    }
    
    
}
