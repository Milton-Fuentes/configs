/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserutil.objects.to.GlobUsersLogTo;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobUserLogDao {
    
    List<GlobUsersLogTo> findAll();
    
    List<GlobUsersLogTo> findAllActualDay();
    
    GlobUsersLogTo findBySessionId(String sessionid);
    
}
