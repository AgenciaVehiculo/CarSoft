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
@Table(name = "facturarechazada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturarechazada.findAll", query = "SELECT f FROM Facturarechazada f")
    , @NamedQuery(name = "Facturarechazada.findByIdRechazo", query = "SELECT f FROM Facturarechazada f WHERE f.idRechazo = :idRechazo")
    , @NamedQuery(name = "Facturarechazada.findByDescripcion", query = "SELECT f FROM Facturarechazada f WHERE f.descripcion = :descripcion")})
public class Facturarechazada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRechazo")
    private Integer idRechazo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name="idFactura")
    private int id;
    @Column(name="fechaRechazo")
    private String fechaRechazo;

    public Facturarechazada() {
    }

    public Facturarechazada(Integer idRechazo) {
        this.idRechazo = idRechazo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaRechazo() {
        return fechaRechazo;
    }

    public void setFechaRechazo(String fechaRechazo) {
        this.fechaRechazo = fechaRechazo;
    }

    
    
    public Integer getIdRechazo() {
        return idRechazo;
    }

    public void setIdRechazo(Integer idRechazo) {
        this.idRechazo = idRechazo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRechazo != null ? idRechazo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturarechazada)) {
            return false;
        }
        Facturarechazada other = (Facturarechazada) object;
        if ((this.idRechazo == null && other.idRechazo != null) || (this.idRechazo != null && !this.idRechazo.equals(other.idRechazo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Facturarechazada[ idRechazo=" + idRechazo + " ]";
    }
    
}
