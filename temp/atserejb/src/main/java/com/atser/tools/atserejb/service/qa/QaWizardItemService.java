package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QaWizardItem;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author mdelabat
 */
public interface QaWizardItemService extends ICrudService<BigDecimal, QaWizardItem>{
    public QaWizardItem findNext(ManageITBodyRequest request);

}

