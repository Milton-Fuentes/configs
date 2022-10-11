/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.sp;

import com.atser.tools.atserutil.objects.to.gateway.NcrLogTO;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface NcrLogDao {

    List<NcrLogTO> filter(String pNumber);
}
