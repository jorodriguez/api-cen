/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soflineas.api.view.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author jorodriguez
 */
public interface UsuarioView {
    String getId();    
    String getNombre();    
    String getAlias();   
    String getCorreo();            
    Date getHoraEntrada();
    Date getHoraSalida();
    Integer getMinutosGraciaEntrada();
    String getFoto();
    Boolean getActivo();
    String getMotivoBaja();
    Date getFechaBaja();        
    Boolean getAccesoSistema();
    BigDecimal getSueldoMensual();
    BigDecimal getSueldoQuincenal();
    Boolean getVisibleReporte();        
    String getCorreoCopia();
    Integer getCoEmpresa();
    Integer getCoSucursal();    
    Date getFechaGenero();
    Date getFechaModifico();    
}
