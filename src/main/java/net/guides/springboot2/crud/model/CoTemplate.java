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

/**
 *
 * @author jorodriguez
 */
@Entity
public class CoTemplate extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 2147483647)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String encabezado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String pie;
   /* @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGenero;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifico;
    @Basic(optional = false)
    @NotNull
    private boolean eliminado;*/
    @Size(max = 2147483647)
    private String anexoPieCorreo;
    @Size(max = 2147483647)
    private String anexoReciboPago;
    @Size(max = 2147483647)
    private String logoCorreo;
    @Size(max = 2147483647)
    private String templateReciboPago;
    @Size(max = 2147483647)
    private String templateCorteDia;
    @Size(max = 2147483647)
    private String templateCorreoBienvenida;
    @Size(max = 2147483647)
    private String templateTicketVenta;
  
        
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "co_empresa", referencedColumnName = "id")    
    private CoEmpresa coEmpresa;
    
    /*@JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)    
    private Usuario genero;
    
    @JoinColumn(name = "modifico", referencedColumnName = "id")    
    @ManyToOne(fetch = FetchType.EAGER)    
    private Usuario modifico;*/

    

    public CoTemplate() {
    }

    public CoTemplate(Integer id) {
        this.id = id;
    }

    public CoTemplate(Integer id, String encabezado, String pie) {
        this.id = id;
        this.encabezado = encabezado;
        this.pie = pie;
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

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getPie() {
        return pie;
    }

    public void setPie(String pie) {
        this.pie = pie;
    }


    public String getAnexoPieCorreo() {
        return anexoPieCorreo;
    }

    public void setAnexoPieCorreo(String anexoPieCorreo) {
        this.anexoPieCorreo = anexoPieCorreo;
    }

    public String getAnexoReciboPago() {
        return anexoReciboPago;
    }

    public void setAnexoReciboPago(String anexoReciboPago) {
        this.anexoReciboPago = anexoReciboPago;
    }

    public String getLogoCorreo() {
        return logoCorreo;
    }

    public void setLogoCorreo(String logoCorreo) {
        this.logoCorreo = logoCorreo;
    }

    public String getTemplateReciboPago() {
        return templateReciboPago;
    }

    public void setTemplateReciboPago(String templateReciboPago) {
        this.templateReciboPago = templateReciboPago;
    }

    public String getTemplateCorteDia() {
        return templateCorteDia;
    }

    public void setTemplateCorteDia(String templateCorteDia) {
        this.templateCorteDia = templateCorteDia;
    }

    public String getTemplateCorreoBienvenida() {
        return templateCorreoBienvenida;
    }

    public void setTemplateCorreoBienvenida(String templateCorreoBienvenida) {
        this.templateCorreoBienvenida = templateCorreoBienvenida;
    }

    public String getTemplateTicketVenta() {
        return templateTicketVenta;
    }

    public void setTemplateTicketVenta(String templateTicketVenta) {
        this.templateTicketVenta = templateTicketVenta;
    }

    public CoEmpresa getCoEmpresa() {
        return coEmpresa;
    }

    public void setCoEmpresa(CoEmpresa coEmpresa) {
        this.coEmpresa = coEmpresa;
    }


}
