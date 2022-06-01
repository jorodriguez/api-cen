package com.soflineas.api.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import lombok.ToString;

/**
 * Clase base para todos los DTO (data transfer object) de la aplicación.
 *
 * @author ihsa
 */
@ToString
public abstract class BaseDto implements Serializable {

    private Integer id;    
    
    private String nombre;    
    
    //@ExcluirJson 
    private Integer usuarioSesionId;
    
    //@ExcluirJson
    private Integer genero;
    
    //@ExcluirJson
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaGenero;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaModifico;    
    
    
    //@ExcluirJson
    private Integer modifico;
            
    private boolean eliminado;
    
    public BaseDto() {
    }

    public BaseDto(Integer id) {
        this.id = id;
    }
    public BaseDto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    
    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseDto other = (BaseDto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUsuarioSesionId() {
        return usuarioSesionId;
    }

    public void setUsuarioSesionId(Integer usuarioSesionId) {
        this.usuarioSesionId = usuarioSesionId;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public Date getFechaGenero() {
        return fechaGenero;
    }

    public void setFechaGenero(Date fechaGenero) {
        this.fechaGenero = fechaGenero;
    }


    public Integer getModifico() {
        return modifico;
    }

    public void setModifico(Integer modifico) {
        this.modifico = modifico;
    }

    public Date getFechaModifico() {
        return fechaModifico;
    }

    public void setFechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
    }


    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
}
