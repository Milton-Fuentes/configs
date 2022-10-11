/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobProjectPersonnel;
import com.atser.tools.atserutil.objects.pojo.glob.GlobSheduleSearchDefParam;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourceTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobProjectPersonnelService {

    GlobProjectPersonnel findById(String id);

    void save(GlobProjectPersonnel elem);
    
    void saveGlobal(GlobProjectPersonnel elem);

    void update(GlobProjectPersonnel elem);

    void delete(String id);

    List<GlobProjectPersonnel> list(ManageITBodyRequest request);
    
    List<String> getPersonnelIdWithWO(BigInteger projectId);
    
    List<String> getPersonnelIdWithWOForDispatchByProject(BigInteger projectId);
    
    List<String> getPersonnelIdWithWOForDispatchByClient(BigInteger clientId);
    
    List<CalendarResourceTO> getDispatchCalendarResources(String clientId, String projectId, String usersFilter);
    
    List<CalendarResourceTO> getAllDispatchCalendarResources(GlobSheduleSearchDefParam filter);
}
