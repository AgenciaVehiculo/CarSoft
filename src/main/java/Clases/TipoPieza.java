/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kur013
 */
@Entity
@Table(name = "tipo_pieza")

public class TipoPieza implements Serializable {

    @Id
    @Column(name = "ID_tipo_pieza")
    private int iDtipopieza;
    @Column(name = "Tipo_pieza")
    private String tipopieza;
    @Column(name = "estado")
    private boolean estado;

    public int getIDtipopieza() {
        return iDtipopieza;
    }

    public void setiDtipopieza(int iDtipopieza) {
        this.iDtipopieza = iDtipopieza;
    }

    public String getTipopieza() {
        return tipopieza;
    }

    public void setTipopieza(String tipopieza) {
        this.tipopieza = tipopieza;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
}
