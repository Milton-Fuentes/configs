/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobProjectPersonnel;
import com.atser.tools.atserutil.objects.pojo.glob.GlobSheduleSearchDefParam;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourceTO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobProjectPersonnelDao extends ICrudDao<BigDecimal, GlobProjectPersonnel>{
    
    List<String> getPersonnelIdWithWO(BigInteger projectId);
    
    List<String> getPersonnelIdWithWOForDispatchByProject(BigInteger projectId);
    
    List<String> getPersonnelIdWithWOForDispatchByClient(BigInteger clientId);
    
    Boolean existsGlobalProject(BigInteger contactId);
    
    void inactiveAllProjectWhenGlobal(BigInteger clientId, BigInteger contactId);
    
    List<CalendarResourceTO> getDispatchCalendarResources(String clientId, String projectId, String usersFilter);
    
    List<CalendarResourceTO> getAllDispatchCalendarResources(GlobSheduleSearchDefParam filters);
}
