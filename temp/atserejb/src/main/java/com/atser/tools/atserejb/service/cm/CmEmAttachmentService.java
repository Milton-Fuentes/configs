/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.model.CmEmAttachment;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface CmEmAttachmentService {

    CmEmAttachment findById(String id);

    BigInteger save(CmEmAttachment elem);

    void update(CmEmAttachment elem);

    void delete(ManageITBodyRequest request);

    List<CmEmAttachment> list(ManageITBodyRequest request);
    
}
