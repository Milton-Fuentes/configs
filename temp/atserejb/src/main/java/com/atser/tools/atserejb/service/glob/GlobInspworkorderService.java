/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobInspworkorder;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.dispatch.InspWorkOrderTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobInspworkorderService {

    GlobInspworkorder findById(String id);

    GlobInspworkorder findByWoToken(String tk);

    BigInteger save(GlobInspworkorder elem);

    void update(GlobInspworkorder elem);

    void delete(String id);

    List<GlobInspworkorder> list(ManageITBodyRequest request);

    List<InspWorkOrderTO> listTo(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    /* Particular Querys */
    void updateDecisionFlag(GlobInspworkorder elem);

    List<GlobInspworkorder> findByInspDispatchID(BigDecimal id);

    List<GlobInspworkorder> findByProjectID(BigInteger id);

    String getNextWorkOrderNumber(BigInteger projectId);

    DataTableWrapper<InspWorkOrderTO> dataTableList(ManageITBodyRequest request);

    List<String> getListActivityNo(BigInteger projectId);
}
