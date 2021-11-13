/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Kur013
 */
@Entity
public class informacionFiscal implements Serializable{
    @Id
    @Column(name="ID_inf")
    private int idInf;
    @Column(name="CAI")
    private String cai;
    @Column(name="fechaInicio")
    private String fechaInicio;
    @Column(name="fechaFinal")
    private String fechaFinal;
    @Column(name="inicio")
    private String inicio;
    @Column(name="fin")
    private String fin;
    @Column(name="actual")
    private String actual;
    @Column(name="estado")
    private boolean estado;

    public String getInicio() {
        return inicio;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    
    
    public boolean isEstado() {
        return estado;
    }

    
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
    
    

    public informacionFiscal() {
    }

    
    
    public int getIdInf() {
        return idInf;
    }

    public void setIdInf(int idInf) {
        this.idInf = idInf;
    }

    public String getCai() {
        return cai;
    }

    public void setCai(String cai) {
        this.cai = cai;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    
    
    
    
}
