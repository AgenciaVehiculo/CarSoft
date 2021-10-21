/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kur013
 */
public class Validaciones {
    
    
    public boolean validacionTresLetras(String aux){
         Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*|.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*|.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");
            Matcher mat = pat.matcher(aux);
            
            if(mat.matches()){
                //JOptionPane.showMessageDialog(null, "Por favor, ingrese la marca valida","Error",JOptionPane.ERROR_MESSAGE);
                return true;   
            }
            else{
               return false; 
            }
    }
    
    public static boolean validacionTarjetas(String texto){
        Pattern pat = Pattern.compile("^(?:4\\d([\\- ])?\\d{6}\\1\\d{5}|(?:4\\d{3}|5[1-5]\\d{2}|6011)([\\- ])?\\d{4}\\d{4}\\d{4})$");
        Matcher mat = pat.matcher(texto);
        
        if(mat.matches()){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public static boolean validacionDecimales(String texto){
        Pattern pat = Pattern.compile("^\\d*\\.?\\d*$");
        Matcher mat = pat.matcher(texto);
       
        if(mat.matches()){
            return true;
        }
        else{
            return false;
        }
       
    }
    
    public static boolean ValidacionNombreMayusculaYDemasMinus(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?=.{3,40}$)[A-ZÑÁÉÍÓÚ][a-zñáéíóú]+(?: [a-zñáéíóúA-ZÑÁÉÍÓÚ]+)?+(?: [a-zñáéíóúA-ZÑÁÉÍÓÚ]+)?$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
}
    
    
    
}
