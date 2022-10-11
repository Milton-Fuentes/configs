/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.model.CmEmGroup;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface CmEmGroupService {

    CmEmGroup findById(BigDecimal id);
    
    CmEmGroup findById(String id);

    void save(CmEmGroup elem);

    void update(CmEmGroup elem);

    void delete(String id);

    List<CmEmGroup> findAll();
}
