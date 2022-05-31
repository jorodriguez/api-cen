/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.api.centops.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jorodriguez
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property ="id" )
public class CoSucursal extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String nombre;
    @Size(max = 2147483647)
    private String direccion;
    /*@Temporal(TemporalType.TIMESTAMP)
    private Date fechaGenero;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifico;
    @Basic(optional = false)
    @NotNull
    private boolean eliminado;*/
    @Size(max = 2147483647)
    private String classColor;
    @Size(max = 2147483647)
    private String foto;
    private Boolean calcularRecargos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String folio;
    @Size(max = 2147483647)
    private String telefono;
    private Boolean enviarReciboCorreo;
    private Boolean pagoPendiente;
    @Size(max = 2147483647)
    private String pagoPendienteImagen;
    @Size(max = 2147483647)
    private String pagoPendienteFondo;
    private Boolean pagoPendienteBloquear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)    
    private String nombreFolder;
    
    @JoinColumn(name = "co_empresa", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)    
    private CoEmpresa coEmpresa;
    
  /*  @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)    
    private Usuario genero;
    
    @JoinColumn(name = "modifico", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)    
    private Usuario modifico;*/

    public CoSucursal() {
    }

    public CoSucursal(Integer id) {
        this.id = id;
    }

    public CoSucursal(Integer id, String nombre,  String folio, String nombreFolder) {
        this.id = id;
        this.nombre = nombre;
        this.folio = folio;
        this.nombreFolder = nombreFolder;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getClassColor() {
        return classColor;
    }

    public void setClassColor(String classColor) {
        this.classColor = classColor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getCalcularRecargos() {
        return calcularRecargos;
    }

    public void setCalcularRecargos(Boolean calcularRecargos) {
        this.calcularRecargos = calcularRecargos;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEnviarReciboCorreo() {
        return enviarReciboCorreo;
    }

    public void setEnviarReciboCorreo(Boolean enviarReciboCorreo) {
        this.enviarReciboCorreo = enviarReciboCorreo;
    }

    public Boolean getPagoPendiente() {
        return pagoPendiente;
    }

    public void setPagoPendiente(Boolean pagoPendiente) {
        this.pagoPendiente = pagoPendiente;
    }

    public String getPagoPendienteImagen() {
        return pagoPendienteImagen;
    }

    public void setPagoPendienteImagen(String pagoPendienteImagen) {
        this.pagoPendienteImagen = pagoPendienteImagen;
    }

    public String getPagoPendienteFondo() {
        return pagoPendienteFondo;
    }

    public void setPagoPendienteFondo(String pagoPendienteFondo) {
        this.pagoPendienteFondo = pagoPendienteFondo;
    }

    public Boolean getPagoPendienteBloquear() {
        return pagoPendienteBloquear;
    }

    public void setPagoPendienteBloquear(Boolean pagoPendienteBloquear) {
        this.pagoPendienteBloquear = pagoPendienteBloquear;
    }

    public String getNombreFolder() {
        return nombreFolder;
    }

    public void setNombreFolder(String nombreFolder) {
        this.nombreFolder = nombreFolder;
    }

    public CoEmpresa getCoEmpresa() {
        return coEmpresa;
    }

    public void setCoEmpresa(CoEmpresa coEmpresa) {
        this.coEmpresa = coEmpresa;
    }


}
