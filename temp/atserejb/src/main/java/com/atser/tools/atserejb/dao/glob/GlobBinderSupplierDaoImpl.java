/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobBinderSupplier;
import java.math.BigDecimal;
import javax.ejb.Stateless;

/**
 *
 * @author dperez
 */
@Stateless
public class GlobBinderSupplierDaoImpl extends GenericDao<BigDecimal, GlobBinderSupplier> implements GlobBinderSupplierDao {
}
