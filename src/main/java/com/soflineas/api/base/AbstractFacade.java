package com.soflineas.api.base;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import java.util.List;
import com.soflineas.api.model.BaseEntity;
import com.soflineas.api.view.dto.BaseView;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @param <T> Clase de la entidad de JPA a administrar.
 * implements BaseCrudRepository<T,ID,V>
 */
public abstract class AbstractFacade<T,ID> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFacade.class.getName());

    @PersistenceContext()
    private EntityManager em;

    protected enum CrudActions {
        INSERTAR, GUARDAR, MODIFICAR, ELIMINAR
    }

    private Class<T> entityClass;

    public AbstractFacade() {

    }

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        return em;
    }

       
    public T find(ID id) {
         T ent = null;

        try {
            
            ent = getEntityManager().find(entityClass, id);            
            
        } catch (Exception ex) {
            LOGGER.error(null, ex);
        }

        return ent;
    }
    
    /*public List<V> findAll() {
          System.out.println("@@@@ findAll");
        List<T> ent = null;
        try {          
            
            ent = getEntityManager().createNativeQuery("Select * from "+entityClass.getName()+" where eliminado = false", entityClass).getResultList();
            //return findByEliminado(false);
            return ent
;            
        } catch (Exception ex) {
            LOGGER.error(null, ex);
        }

        return ent;
    }
*/
    public T create(T entity, Integer idUsuario) {

        completarAtributosBase(entity, CrudActions.GUARDAR);

        this.getEntityManager().persist(entity);
        
        this.getEntityManager().flush();

        return entity;
    }

    public T  edit(T entity) {
        try {
            completarAtributosBase(entity, CrudActions.MODIFICAR);

            getEntityManager().merge(entity);

            return entity;

        } catch (SecurityException | IllegalArgumentException ex) {
            LOGGER.error(null, ex);
        }
        
        return null;

    }

    public void remove(ID id) {
        T entity = find(id);
        
        completarAtributosBase(entity, CrudActions.ELIMINAR);
        
        getEntityManager().merge(entity);
        
    }


     private void completarAtributosBase(T entity, CrudActions operacion) {
        BaseEntity baseEntity = (BaseEntity) entity;
        switch (operacion) {
            case GUARDAR:           
                baseEntity.setFechaGenero(new Date());                
                baseEntity.setEliminado(Boolean.FALSE);
                break;

            case MODIFICAR:
                baseEntity.setFechaModifico(new Date());
                break;

            case ELIMINAR:
                baseEntity.setFechaModifico(new Date());
                baseEntity.setEliminado(Boolean.TRUE);
                break;
            default:
                System.out.println("La entidad no herada de la clase base");
        }
    }
    
    /*private <T> T traerPorId(ID id) {
        T ent = null;

        try {

            ent = (T) getEntityManager().find(entityClass, id);

        } catch (Exception ex) {
            LOGGER.error(null, ex);
        }

        return ent;
    }*/

}
