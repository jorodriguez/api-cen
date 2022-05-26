/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guides.springboot2.crud.dto;

import java.math.BigDecimal;
import java.util.Date;
import net.guides.springboot2.Crud.base.BaseDto;

/**
 *
 * @author jorodriguez
 */
public class UsuarioDto extends BaseDto{

    private String correo;
    private String password;
    private Date fechaGenero;
    private Date fechaModifico;
    private boolean eliminado;
    private String token;
    private Boolean permisoGerente;
    private Date horaEntrada;
    private Date horaSalida;
    private Integer minutosGraciaEntrada;
    private String foto;
    private Boolean activo;
    private String motivoBaja;
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
