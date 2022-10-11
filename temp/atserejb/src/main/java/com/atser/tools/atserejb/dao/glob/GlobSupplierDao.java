/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobSupplier;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobSupplierTO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobSupplierDao extends ICrudDao<BigDecimal, GlobSupplier>{
    
    GlobSupplier findByImpCode(String code);
    
    List<GlobSupplier> filterByMaterialType(BigInteger clientId, String materialType);
    
    List<GlobSupplier> filterByMaterialTypeAndProject(BigInteger clientId, BigInteger projectId, String materialType);
    
    List<GlobSupplier> filterSupplierByProject(BigInteger clientId, BigInteger projectId);

    List<Object[]> getSupplierAndLocation(BigInteger clientId, String materialType);
    
    List<Object[]> getSupplierAndLocation(BigInteger clientId, String materialType, BigDecimal supplierId);
    
    List<GlobSupplier> filterBinderSupplierByProject(BigInteger clientId, BigInteger projectId);
    
    List<GlobSupplierTO> listSupplierAndLocation(BigInteger clientId); 
    
}
