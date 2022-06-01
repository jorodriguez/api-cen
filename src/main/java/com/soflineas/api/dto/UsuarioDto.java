/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soflineas.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.soflineas.api.base.BaseDto;

/**
 *
 * @author jorodriguez
 */

@Getter
@Setter
@ToString
public class UsuarioDto  extends BaseDto{

    private String correo;    
    private String password;    
    private boolean eliminado;
    private String token;
    private Boolean permisoGerente;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date horaEntrada;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date horaSalida;
    private Integer minutosGraciaEntrada;
    private String foto;
    private Boolean activo;
    private String motivoBaja;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaBaja;
    private Boolean accesoSistema;
    private BigDecimal sueldoMensual;
    private BigDecimal sueldoQuincenal;
    private Boolean visibleReporte;
    private String alias;
    private String correoCopia;
    private Integer coEmpresa;
    private Integer coSucursal;           

}
