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
@Table(name = "razon_social")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RazonSocial.findAll", query = "SELECT r FROM RazonSocial r")
    , @NamedQuery(name = "RazonSocial.findByIdRazonSocial", query = "SELECT r FROM RazonSocial r WHERE r.idRazonSocial = :idRazonSocial")
    , @NamedQuery(name = "RazonSocial.findByNombre", query = "SELECT r FROM RazonSocial r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "RazonSocial.findByFechaInicio", query = "SELECT r FROM RazonSocial r WHERE r.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "RazonSocial.findByFechaFinal", query = "SELECT r FROM RazonSocial r WHERE r.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "RazonSocial.findByEstado", query = "SELECT r FROM RazonSocial r WHERE r.estado = :estado")})
public class RazonSocial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_razon_social")
    private Integer idRazonSocial;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_inicio")
    
    private String fechaInicio;
    @Column(name = "fecha_final")
    
    private String fechaFinal;
    @Column(name="rtn")
    private String rtn;
    
    @Column(name = "estado")
    private Boolean estado;

    public RazonSocial() {
    }

    public RazonSocial(Integer idRazonSocial) {
        this.idRazonSocial = idRazonSocial;
    }

    public String getRtn() {
        return rtn;
    }

    public void setRtn(String rtn) {
        this.rtn = rtn;
    }

    
    
    public Integer getIdRazonSocial() {
        return idRazonSocial;
    }

    public void setIdRazonSocial(Integer idRazonSocial) {
        this.idRazonSocial = idRazonSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRazonSocial != null ? idRazonSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RazonSocial)) {
            return false;
        }
        RazonSocial other = (RazonSocial) object;
        if ((this.idRazonSocial == null && other.idRazonSocial != null) || (this.idRazonSocial != null && !this.idRazonSocial.equals(other.idRazonSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.RazonSocial[ idRazonSocial=" + idRazonSocial + " ]";
    }
    
}
