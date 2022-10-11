/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.jpa;

import java.io.Serializable;

/**
 *
 * @author droldan
 * @param <PK>
 * @param <T>
 */
public interface IViewDao<PK extends Serializable, T> extends IJpaRepository<PK, T> {
}
