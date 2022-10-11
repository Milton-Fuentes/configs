/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobNotificationTrack;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.mail.SystemMailMessage;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobNotificationTrackService {

    GlobNotificationTrack findById(String id);

    void save(GlobNotificationTrack elem);
    
    void batchSave(List<GlobNotificationTrack> elems);
    
    void save(String module, String functionality, BpmMailMessage msg);
    
    void save(String module, String functionality, SystemMailMessage msg);
    
    void save(String module, String functionality, BpmMailMessage msg, String type);
    
    void save(String module, String functionality, SystemMailMessage msg, String type);
    
    void batchSave(String module, String functionality, List<Object> msgs);

    void update(GlobNotificationTrack elem);
    
    Boolean updateTechAnswer(String token, String answer, String techid);
    
    Boolean updateBasicTechAnswer(String token, String answer, String techid);
    
    Boolean updateInspAnswer(String token, String answer, String inspid);

    void delete(String id);

    List<GlobNotificationTrack> list(ManageITBodyRequest request);
    
    List<GlobNotificationTrack> findAllByRefId(String functionality, String refid);
    
    List<GlobNotificationTrack> findAllByRefIdAndNotSended(String functionality, String refid);
    
    List<GlobNotificationTrack> findAllByRefIdAndStatus(String functionality, String refid, String status);
    
    DataTableWrapper<GlobNotificationTrack> dataTableList(ManageITBodyRequest request);
    
    DataGridWrapper<GlobNotificationTrack> dataGridList(ManageITBodyRequest request);
}
