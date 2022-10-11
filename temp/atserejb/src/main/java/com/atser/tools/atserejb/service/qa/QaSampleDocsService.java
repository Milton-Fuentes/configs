/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QaSampleDocs;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author dperez
 */
public interface QaSampleDocsService extends ICrudService<BigDecimal, QaSampleDocs> {

    void save(Map<String, Object> metaDataFile, Map<String, Object> params);
}
