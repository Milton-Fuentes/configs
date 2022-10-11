/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.common.interfaces.IQmsTest;
import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.common.objects.to.QaGenericTestTO;
import com.atser.tools.atserejb.model.QasteelMagneticPart;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author mfuentes
 */
public interface QasteelMagneticPartService extends ICrudService<BigDecimal, QasteelMagneticPart>, IQmsTest<QasteelMagneticPart> {

    public QaGenericTestTO<QasteelMagneticPart> findByTestIdTO(BigInteger id);

    public void updateTO(ManageITHeader header, QaGenericTestTO<QasteelMagneticPart> elem);

    QasteelMagneticPart findByTestId(BigInteger testId);

    void deleteByTestId(String id);
}
