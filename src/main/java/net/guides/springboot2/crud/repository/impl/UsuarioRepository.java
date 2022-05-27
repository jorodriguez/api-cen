/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guides.springboot2.crud.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import net.guides.springboot2.Crud.base.AbstractFacade;
import net.guides.springboot2.Crud.base.BaseCrudDao;
import net.guides.springboot2.Crud.base.BaseRepositoryImpl;
import net.guides.springboot2.crud.dto.UsuarioDto;
import net.guides.springboot2.crud.exception.CamposRequeridosFaltantesException;
import net.guides.springboot2.crud.model.Usuario;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jorodriguez
 */
@Repository
//public class UsuarioRepository extends AbstractFacade<Usuario> {
public class UsuarioRepository {// extends BaseRepositoryImpl<Usuario, Long> {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Usuario> getUsuarios(){
        Query query = entityManager.createNativeQuery("Select * from usuario where eliminado = false",Usuario.class);
        
        return query.getResultList();
        
    }

    
    
        
    
}
