/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guides.springboot2.crud.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorodriguez
 */
@Entity
@XmlRootElement
public class CoEmpresa extends BaseEntity{

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
    @Size(max = 2147483647)
    private String telefono;
    @Size(max = 2147483647)
    private String nombreRepresentante;
    /*
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGenero;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifico;
    @Basic(optional = false)
    @NotNull
    private boolean eliminado;
    */
    @Basic(optional = false)
    @NotNull
    private boolean activa;
    @Size(max = 2147483647)
    @Size(max = 2147483647)
    private String paginaOficial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String folio;
    @Size(max = 2147483647)
    private String rfc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String nombreFolder;
    @Size(max = 2147483647)
    private String copiaOculta;
    
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "co_template", referencedColumnName = "id")
    private CoTemplate coTemplate;
    
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "configuracion", referencedColumnName = "id")
    private Configuracion configuracion;
    
    
    /*@JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)        
    private Usuario genero;
    
    @JoinColumn(name = "modifico", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)    
    private Usuario modifico;*/
    
    public CoEmpresa() {
    }

    public CoEmpresa(Integer id) {
        this.id = id;
    }

    public CoEmpresa(Integer id, String nombre, boolean eliminado, boolean activa, String folio, String nombreFolder) {
        this.id = id;
        this.nombre = nombre;
        this.activa = activa;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }


    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getPaginaOficial() {
        return paginaOficial;
    }

    public void setPaginaOficial(String paginaOficial) {
        this.paginaOficial = paginaOficial;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombreFolder() {
        return nombreFolder;
    }

    public void setNombreFolder(String nombreFolder) {
        this.nombreFolder = nombreFolder;
    }

    public String getCopiaOculta() {
        return copiaOculta;
    }

    public void setCopiaOculta(String copiaOculta) {
        this.copiaOculta = copiaOculta;
    }

    public CoTemplate getCoTemplate() {
        return coTemplate;
    }

    public void setCoTemplate(CoTemplate coTemplate) {
        this.coTemplate = coTemplate;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    
    
}
