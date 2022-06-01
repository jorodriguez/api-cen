/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soflineas.api.repository;

//import api.centops.app.model.CoEmpresa;
import java.util.List;
import com.soflineas.api.model.Usuario;
import com.soflineas.api.view.dto.UsuarioView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author jorodriguez
 */
@Repository
//public class UsuarioCrudRepository extends AbstractFacade<Usuario> {
public interface UsuarioCrudRepository extends CrudRepository<Usuario,Long>{ //extends CrudRepository<Usuario, Long>{
//public class UsuarioCrudRepository{
    
    /*@PersistenceContext
    private EntityManager entityManager;
    
    public List<Usuario> getUsuarios(){
        
        Query query = entityManager.createNativeQuery("Select * from usuario where eliminado = false",Usuario.class);
        
        return query.getResultList();
        
    }*/
        
    //<T> List<T> findByEliminado(Boolean eliminado, Class<T> type);   
   @Query(value = "Select * from usuario where eliminado = false and co_empresa = ?1" ,nativeQuery = true)  
   List<UsuarioView> findByCoEmpresa(Integer coEmpresa);         
   
   @Query(value = "Select * from usuario where eliminado = false and  id = ?1" ,nativeQuery = true)     
   UsuarioView findId(Long id);         
               
}
