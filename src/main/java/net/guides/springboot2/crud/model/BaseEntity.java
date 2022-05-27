package net.guides.springboot2.crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ihsa
*/
@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property ="id" )
public abstract class BaseEntity implements Serializable {
    
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    protected Usuario genero;
    
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    protected Date fechaGenero;

    @JoinColumn(name = "modifico", referencedColumnName = "id")
    @ManyToOne
    protected Usuario modifico;
    @Column(name = "fecha_modifico")
    @Temporal(TemporalType.DATE)
    protected Date fechaModifico;

    @Column(name = "eliminado")
    protected Boolean eliminado;

    //@JsonBackReference
    public Usuario getGenero() {
        return genero;
    }

    public void setGenero(Usuario genero) {
        this.genero = genero;
    }

    public Date getFechaGenero() {
        return fechaGenero;
    }

    public void setFechaGenero(Date fechaGenero) {
        this.fechaGenero = fechaGenero;
    }

    //@JsonBackReference
    public Usuario getModifico() {
        return modifico;
    }

    public void setModifico(Usuario modifico) {
        this.modifico = modifico;
    }

    public Date getFechaModifico() {
        return fechaModifico;
    }

    public void setFechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        return "BaseEntity{" 
                + "genero=" + (genero != null ? genero.getId():"")
                + ", fechaGenero=" + (fechaGenero != null ? fechaGenero : "")
                + ", modifico=" + (modifico != null ? modifico.getId():"")
                + ", fechaModifico=" + (fechaModifico != null ? fechaModifico : "")
                + ", eliminado=" + eliminado 
                + '}';
    }
        
    
}
