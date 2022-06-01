/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soflineas.api.base;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jorodriguez
 */
public interface BaseCrudRepository<T,ID,V> extends CrudRepository<T,ID>{
          
   List<V> findByEliminado(Integer coEmpresa);       
   
   //V findById(ID id);       
    
}
