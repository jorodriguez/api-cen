/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guides.springboot2.crud.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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

/**
 *
 * @author jorodriguez
 */
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

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nombre, String password, Date horaEntrada, Date horaSalida, BigDecimal sueldoMensual, BigDecimal sueldoQuincenal) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.sueldoMensual = sueldoMensual;
        this.sueldoQuincenal = sueldoQuincenal;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getPermisoGerente() {
        return permisoGerente;
    }

    public void setPermisoGerente(Boolean permisoGerente) {
        this.permisoGerente = permisoGerente;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Integer getMinutosGraciaEntrada() {
        return minutosGraciaEntrada;
    }

    public void setMinutosGraciaEntrada(Integer minutosGraciaEntrada) {
        this.minutosGraciaEntrada = minutosGraciaEntrada;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Boolean getAccesoSistema() {
        return accesoSistema;
    }

    public void setAccesoSistema(Boolean accesoSistema) {
        this.accesoSistema = accesoSistema;
    }

    public BigDecimal getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(BigDecimal sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public BigDecimal getSueldoQuincenal() {
        return sueldoQuincenal;
    }

    public void setSueldoQuincenal(BigDecimal sueldoQuincenal) {
        this.sueldoQuincenal = sueldoQuincenal;
    }

    public Boolean getVisibleReporte() {
        return visibleReporte;
    }

    public void setVisibleReporte(Boolean visibleReporte) {
        this.visibleReporte = visibleReporte;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCorreoCopia() {
        return correoCopia;
    }

    public void setCorreoCopia(String correoCopia) {
        this.correoCopia = correoCopia;
    }

    public CoEmpresa getCoEmpresa() {
        return coEmpresa;
    }

    public void setCoEmpresa(CoEmpresa coEmpresa) {
        this.coEmpresa = coEmpresa;
    }

    public CoSucursal getCoSucursal() {
        return coSucursal;
    }

    public void setCoSucursal(CoSucursal coSucursal) {
        this.coSucursal = coSucursal;
    }

      
  
    
}
