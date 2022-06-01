/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soflineas.api.base;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.soflineas.api.model.BaseEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jorodriguez
 */
public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> {
 
  
  //@PersistenceContext
  protected EntityManager entityManager;
  
  public enum CrudActions {
        INSERTAR, GUARDAR, MODIFICAR, ELIMINAR
  }
  
   private Class<T> entityClass;

  BaseRepositoryImpl(JpaEntityInformation entityInformation,EntityManager entityManager) {
      
    super(entityInformation, entityManager);

    // Keep the EntityManager around to used from the newly introduced methods.
    this.entityManager = entityManager;
  }


  @Transactional
  public T create(T entity) {

      System.out.println("======CREATE");
        int entityId = -1;

        completarAtributosBase(entity, CrudActions.GUARDAR);
        entityManager.persist(entity);
        entityManager.flush();
        //entityId = (Integer) getId(entity);
        
        //guardarLog(EVENTO_CREAR, idUsuario, entityId, "", entity.toString());

        return entity;
  }

    @Override
    public List<T> findAll() {            
        System.out.println("@findAll override "+this.entityClass.getName());
        return entityManager.createNativeQuery("select * from "+entityClass.getClass().getName()+" where eliminado = false",entityClass).getResultList();
    }
  
  
   public <T> T find(Object id) {
       System.out.println("@======find");
        T ent = null;

        try {
            ent = (T) entityManager.find(entityClass,id);
        } catch (Exception ex) {
            System.out.println(" ERROR EN EL FIND"+ex.getMessage());
        }

        return ent;
    }
   
   
   
       private void completarAtributosBase(T entity, CrudActions operacion) {
        BaseEntity baseEntity = (BaseEntity) entity;
        switch (operacion) {
            case GUARDAR:
        //        baseEntity.setGenero(new Usuario(idUsuario));
                baseEntity.setFechaGenero(new Date());                
                baseEntity.setEliminado(Boolean.FALSE);
                break;

            case MODIFICAR:
          //      baseEntity.setModifico(new Usuario(idUsuario));
                baseEntity.setFechaModifico(new Date());
                break;

            case ELIMINAR:
            //    baseEntity.setModifico(new Usuario(idUsuario));
                baseEntity.setFechaModifico(new Date());
                baseEntity.setEliminado(Boolean.TRUE);
                break;
            default:
                System.out.println("La entidad no herada de la clase base");
        }

    }
   
}
