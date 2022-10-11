/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobFileRevision;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobFileRevisionService {

    GlobFileRevision findById(String id);

    void save(GlobFileRevision elem);

    void update(GlobFileRevision elem);

    void delete(String id);

    void lockFile(BigDecimal fileId, BigDecimal userId);

    void unlockFile(BigDecimal fileId);

    Boolean isFileLocked(BigDecimal fileId, BigDecimal userId);

    List<GlobFileRevision> list(ManageITBodyRequest request);
}
