
package net.guides.springboot2.Crud.base;

import java.util.List;

/**
 * 
 * Interfaz genérica que provee las operaciones básicas de persistencia.
 *
 * @author ihsa
 * @param <T> Tipo concreto del DTO a administrar.
 */
public interface BaseCrudDao<T> {
    
    List<T> findAll(T dto);
    
    T findId(Integer dtoId);
    
    int insert(T dto);
    
    void update(T dto);
    
    void delete(T dto);
    
}
