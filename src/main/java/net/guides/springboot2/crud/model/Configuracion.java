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
import javax.validation.constraints.Size;

/**
 *
 * @author jorodriguez
 */
@Entity
public class Configuracion extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 2147483647)
    private String linkDescargaAppAndroid;    
    private Boolean sistema;
    /*@Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGenero;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifico;
    */
    @Size(max = 2147483647)
    private String configuracionCorreo;
    @Size(max = 2147483647)
    private String remitenteFrom;
    
    @JoinColumn(name = "co_empresa", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)    
    private CoEmpresa coEmpresa;
    
    /*@JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)    
    private Usuario genero;
    
    @JoinColumn(name = "modifico", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)    
    private Usuario modifico;*/

    
    public Configuracion() {
    }

    public Configuracion(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkDescargaAppAndroid() {
        return linkDescargaAppAndroid;
    }

    public void setLinkDescargaAppAndroid(String linkDescargaAppAndroid) {
        this.linkDescargaAppAndroid = linkDescargaAppAndroid;
    }


    public Boolean getSistema() {
        return sistema;
    }

    public void setSistema(Boolean sistema) {
        this.sistema = sistema;
    }


    public String getConfiguracionCorreo() {
        return configuracionCorreo;
    }

    public void setConfiguracionCorreo(String configuracionCorreo) {
        this.configuracionCorreo = configuracionCorreo;
    }

    public String getRemitenteFrom() {
        return remitenteFrom;
    }

    public void setRemitenteFrom(String remitenteFrom) {
        this.remitenteFrom = remitenteFrom;
    }

    public CoEmpresa getCoEmpresa() {
        return coEmpresa;
    }

    public void setCoEmpresa(CoEmpresa coEmpresa) {
        this.coEmpresa = coEmpresa;
    }

    
    
}
