/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.api.centops.service;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import net.api.centops.dto.UsuarioDto;
import net.api.centops.model.CoEmpresa;
import net.api.centops.model.CoSucursal;
import net.api.centops.model.Usuario;
import net.api.centops.projectionsDto.UsuarioView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.api.centops.repository.UsuarioCrudRepository;

/**
 *
 * @author jorodriguez
 * aqui si se puede usar un abstracto que tenga los metodos default, buscar por eliminado y empresa
 */
@Service
public class UsuarioService  {
    
    @Autowired
    private UsuarioCrudRepository usuarioRepository;
    
    public List<UsuarioView> findByEliminado(Integer coEmpresa){
        //return usuarioRepository.findByEliminadoAndCoEmpresa(eliminado,coEmpresa);
        return usuarioRepository.findByCoEmpresa(coEmpresa);
    }
        
    public UsuarioView findById(Long id){
        
        return usuarioRepository.findId(id);
        
    }
    
    public void save(UsuarioDto usuarioDto){
        
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setAccesoSistema(usuarioDto.getAccesoSistema());
        usuario.setAlias(usuarioDto.getAlias());
        usuario.setCoEmpresa(new CoEmpresa(usuarioDto.getCoEmpresa()));
        usuario.setCoSucursal(new CoSucursal(usuarioDto.getCoSucursal()));
        //usuario.setHoraEntrada(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        usuario.setHoraEntrada(new Date());
        usuario.setHoraSalida(new Date());
        usuario.setMinutosGraciaEntrada(0);
        usuario.setSueldoMensual(BigDecimal.ZERO);
        usuario.setSueldoQuincenal(BigDecimal.ZERO);                
        
        usuarioRepository.save(usuario);
        
    }
    
    
}
