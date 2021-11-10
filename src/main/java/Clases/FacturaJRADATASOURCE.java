/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Kur013
 */
public class FacturaJRADATASOURCE implements JRDataSource {

    private final Object[][] p;
    
    private int contador;

    public FacturaJRADATASOURCE(Object[][] e) {
        this.p=e;
        this.contador=-1;
    }
    

    

    @Override
    public boolean next() throws JRException {
        contador++;
        return (contador<p.length);
        
    }

   
    
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
       Object valor = null;
       
       String nombreCampo = jrf.getName();
       switch(nombreCampo){
           case "id": valor=p[contador][0];break;
           case "descripcion":valor = p[contador][1];break;
           case "Precio_Unit": valor = p[contador][2];break;
           case "cantidad": valor=p[contador][3];break;
           case "subtotal": valor=p[contador][4];break;
           
       }
        
       return valor;
    }
    
    
    public static JRDataSource getDataSource(Object[][] w){
        return new FacturaJRADATASOURCE(w); 
    }
    
}
