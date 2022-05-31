package net.api.centops.base;

import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import net.api.centops.model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @param <T> Clase de la entidad de JPA a administrar.
 */
public abstract class AbstractFacade<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFacade.class.getName());

    @PersistenceContext
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

    public T find(Object id) {
        T ent = null;

        try {
            ent = getEntityManager().find(entityClass, id);
        } catch (Exception ex) {
            LOGGER.error(null, ex);
        }

        return ent;
    }
    
      public List<T> findAll() {
          System.out.println("@@@@ findAll");
        List<T> ent = null;
        try {
            
            ent = getEntityManager().createNativeQuery("Select * from "+entityClass.getName()+" where eliminado = false", entityClass).getResultList();
            
        } catch (Exception ex) {
            LOGGER.error(null, ex);
        }

        return ent;
    }
    

    /**
     *
     * @param entity
     * @param idUsuario
     * @return El ID de la llave primaria generada para la entidad creada.
     */
    public T create(T entity, Integer idUsuario) {

        int entityId = -1;

        completarAtributosBase(entity, CrudActions.GUARDAR);
        this.getEntityManager().persist(entity);
        this.getEntityManager().flush();
        //entityId = (Integer) getId(entity);
        //guardarLog(EVENTO_CREAR, idUsuario, entityId, "", entity.toString());

        return entity;
    }

    public T  edit(T entity, Integer idUsuario) {
        try {
            T entityToStr = traerPorId(getId(entity));

            final String srtOriginal = entityToStr != null ? entityToStr.toString() : "";

            completarAtributosBase(entity, CrudActions.MODIFICAR);

            getEntityManager().merge(entity);

            //Object id = getId(entity);

//            guardarLog(Constantes.EVENTO_MODIFICAR, idUsuario, id, srtOriginal, entity.toString());

            return entity;

        } catch (SecurityException | IllegalArgumentException ex) {
            LOGGER.error(null, ex);
        }
        
        return null;

    }

    public void remove(T entity, Integer idUsuario) {
        T entityToStr = traerPorId(getId(entity));
        final String srtOriginal = entityToStr != null ? entityToStr.toString() : "";
        completarAtributosBase(entity, CrudActions.ELIMINAR);
        getEntityManager().merge(entity);
        //guardarLog(Constantes.EVENTO_ELIMINAR, idUsuario, getId(entity), srtOriginal, entity.toString());
    }

    // - - - - - - -METODOS DE COMPLEMENTO  - - - - - - - -    
   /* private void guardarLog(Integer operacion, Integer idUsuario, Object idRegistro, String toStringAntes, String toStringDespues)
            throws CamposRequeridosFaltantesException {
        OmitirLog omitirLog = entityClass.getAnnotation(OmitirLog.class);
        if (omitirLog == null) {
            siLogService.create(
                    new LogDto(
                            entityClass.getName(),
                            (Integer) idRegistro,
                            new Date(),
                            new Date(),
                            toStringAntes,
                            toStringDespues,
                            operacion,
                            idUsuario
                    )
            );
        }
    }*/

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

    /*
     * Metodo que obtiene un id fuera del contexto 
     <T>
     */
    private <T> T traerPorId(Object id) {
        T ent = null;

        try {

            ent = (T) getEntityManager().find(entityClass, id);

        } catch (Exception ex) {
            LOGGER.error(null, ex);
        }

        return ent;
    }

    /*
     * Obtener Id de la entidad
     */
    private Object getId(T entity) {
        Field[] campos = entity.getClass().getDeclaredFields();
        Object idEncontrado = null;
        try {
            for (Field campo : campos) {
                Id idEntity = campo.getAnnotation(Id.class); //Id es la interfaz de la anotacion @Id de persistence
                if (idEntity != null) {
                    idEncontrado = getPropertyValue(entity, campo.getName());
                    break;
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException
                | IntrospectionException
                | InvocationTargetException ex) {
            LOGGER.error(null, ex);
        }
        return idEncontrado;
    }

    /**
     *
     * @param dtos
     * @return
     */
    protected List<Integer> obtenerIds(List<? extends BaseDto> dtos) {

        List<Integer> ids = new ArrayList<>(dtos.size());

        for (BaseDto dto : dtos) {
            ids.add(dto.getId());
        }

        LOGGER.debug("IDs de entidades = {}", ids);

        return ids;

    }

    private Object getPropertyValue(final Object bean, final String property)
            throws IntrospectionException, IllegalArgumentException, 
            IllegalAccessException, InvocationTargetException {
        
        final Class<?> beanClass = bean.getClass();
        final PropertyDescriptor propertyDescriptor = 
                getPropertyDescriptor(beanClass, property);
        
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException("No such property " + property
                    + " for " + beanClass + " exists");
        }

        final Method readMethod = propertyDescriptor.getReadMethod();
        
        if (readMethod == null) {
            throw new IllegalStateException("No getter available for property "
                    + property + " on " + beanClass);
        }
        
        return readMethod.invoke(bean);
    }

    private PropertyDescriptor getPropertyDescriptor(final Class<?> beanClass, final String propertyname) 
            throws IntrospectionException {

        final BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
        final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        PropertyDescriptor propertyDescriptor = null;

        for (final PropertyDescriptor currentPropertyDescriptor : propertyDescriptors) {
            if (currentPropertyDescriptor.getName().equals(propertyname)) {
                propertyDescriptor = currentPropertyDescriptor;
            }
        }
        return propertyDescriptor;
    }

}
