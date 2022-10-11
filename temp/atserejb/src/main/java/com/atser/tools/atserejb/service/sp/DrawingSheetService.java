/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.sp;

import com.atser.tools.atserutil.objects.to.gateway.DrawingSheetTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface DrawingSheetService {

    List<DrawingSheetTO> filter(ManageITBodyRequest request, String serverDomain);
}
