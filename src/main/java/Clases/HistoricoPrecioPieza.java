/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kur013
 */
@Entity
@Table(name = "historico_precio_pieza")

public class HistoricoPrecioPieza implements Serializable {

    @Id
    @Column(name = "id_precio_historico")
    private int idPrecioHistorico;
    @Column(name="ID_Pieza")
    private int idPieza;
    @Column(name = "fecha_inicial")
    private String fechaInicial;
    @Column(name = "fecha_final")
    private String fechaFinal;
    @Column(name = "precio")
    private double precio;
    @Column(name = "estado")
    private boolean estado;

    public int getIdPrecioHistorico() {
        return idPrecioHistorico;
    }

    public void setIdPrecioHistorico(int idPrecioHistorico) {
        this.idPrecioHistorico = idPrecioHistorico;
    }

    public int getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    
    
}
