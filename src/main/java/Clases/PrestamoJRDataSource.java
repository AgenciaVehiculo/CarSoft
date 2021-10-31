/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author User
 */
public class PrestamoJRDataSource implements JRDataSource {
    
    private final Object[][] p;
    
    private int contador;

    public PrestamoJRDataSource(Object[][] e) {
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
           case "banco":valor = p[contador][1];break;
           case "cliente": valor = p[contador][2];break;
           case "monto": valor=p[contador][3];break;
           case "cuota": valor=p[contador][4];break;
           case "interes": valor=p[contador][5];break;
           case "inicio": valor=p[contador][6];break;
           case "fin": valor=p[contador][7];break;
           
       }
        
       return valor;
    }
    
    
    public static JRDataSource getDataSource(Object[][] w){
        return new PrestamoJRDataSource(w); 
    }
}
