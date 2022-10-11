/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 * @param <PK>
 * @param <T>
 */
public interface ICrudDao<PK extends Serializable, T> extends IJpaRepository<PK, T> {

    T save(T elem);
    
    void clearAndFlushSession();

    void save(List<T> elem);

    void update(T elem);

    void delete(PK id);
    
    void delete(T elem);

    Object getVersion(Integer number);

    List getRevisions(BigDecimal id);

}
