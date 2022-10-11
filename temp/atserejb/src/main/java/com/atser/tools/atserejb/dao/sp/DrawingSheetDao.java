/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.sp;

import com.atser.tools.atserutil.objects.to.gateway.DrawingSheetTO;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface DrawingSheetDao {

    List<DrawingSheetTO> filter(String pNumber, String serverDomain);
}
