/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soflineas.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;

/**
 *
 * @author jorodriguez
 */
@Getter
@Setter
@Entity

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property ="id" )
public class Usuario extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String nombre;
    @Size(max = 60)
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGenero;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifico;
    @Basic(optional = false)
    @NotNull
    private boolean eliminado;
    @Size(max = 2147483647)
    private String token;
    private Boolean permisoGerente;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIME)
    private Date horaEntrada;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    private Integer minutosGraciaEntrada;
    @Size(max = 2147483647)
    private String foto;
    private Boolean activo;
    @Size(max = 2147483647)
    private String motivoBaja;
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    private Boolean accesoSistema;
    @Basic(optional = false)
    @NotNull
    private BigDecimal sueldoMensual;
    @Basic(optional = false)
    @NotNull
    private BigDecimal sueldoQuincenal;
    private Boolean visibleReporte;
    @Size(max = 2147483647)
    private String alias;
    @Size(max = 2147483647)
    private String correoCopia;
     
    //@JoinColumn(name = "co_empresa", referencedColumnName = "id")
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_empresa", nullable = false)    
    //@ManyToOne
    private CoEmpresa coEmpresa;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_sucursal", referencedColumnName = "id")        
    private CoSucursal coSucursal;
    
    public Usuario() {
    }

    @Builder
    public Usuario(Integer id, String nombre, String correo, String password, Date fechaGenero, Date fechaModifico, boolean eliminado, String token, Boolean permisoGerente, Date horaEntrada, Date horaSalida, Integer minutosGraciaEntrada, String foto, Boolean activo, String motivoBaja, Date fechaBaja, Boolean accesoSistema, BigDecimal sueldoMensual, BigDecimal sueldoQuincenal, Boolean visibleReporte, String alias, String correoCopia, CoEmpresa coEmpresa, CoSucursal coSucursal) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.fechaGenero = fechaGenero;
        this.fechaModifico = fechaModifico;
        this.eliminado = eliminado;
        this.token = token;
        this.permisoGerente = permisoGerente;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.minutosGraciaEntrada = minutosGraciaEntrada;
        this.foto = foto;
        this.activo = activo;
        this.motivoBaja = motivoBaja;
        this.fechaBaja = fechaBaja;
        this.accesoSistema = accesoSistema;
        this.sueldoMensual = sueldoMensual;
        this.sueldoQuincenal = sueldoQuincenal;
        this.visibleReporte = visibleReporte;
        this.alias = alias;
        this.correoCopia = correoCopia;
        this.coEmpresa = coEmpresa;
        this.coSucursal = coSucursal;
    }

       
      
  
    
}
