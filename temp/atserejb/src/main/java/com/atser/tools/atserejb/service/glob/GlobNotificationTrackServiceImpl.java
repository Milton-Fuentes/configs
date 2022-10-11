/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobDispatchcallLogDao;
import com.atser.tools.atserejb.dao.glob.GlobInspworkorderDao;
import com.atser.tools.atserejb.dao.glob.GlobNotificationTrackDao;
import com.atser.tools.atserejb.model.GlobDispatchcallLog;
import com.atser.tools.atserejb.model.GlobInspworkorder;
import com.atser.tools.atserejb.model.GlobNotificationTrack;
import com.atser.tools.atserejb.model.QmCvlFieldData;
import com.atser.tools.atserejb.service.qm.QmCvlFieldDataService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.mail.SystemMailMessage;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

@Stateless
public class GlobNotificationTrackServiceImpl implements GlobNotificationTrackService, IBaseEJBException {

    @Inject
    private GlobNotificationTrackDao dao;

    @Inject
    private GlobDispatchcallLogDao daoDispatchcallLog;

    @Inject
    private GlobInspworkorderDao daoInspWo;

    @Inject
    private QmCvlFieldDataService qmCvlFieldDataService;

    @Override
    public GlobNotificationTrack findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobNotificationTrack findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobNotificationTrack elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void batchSave(List<GlobNotificationTrack> elems) {
        if (elems != null && !elems.isEmpty()) {
            dao.save(elems);
        }
    }

    @Override
    public void batchSave(String module, String functionality, List<Object> msgs) {
        if (msgs != null && !msgs.isEmpty()) {
            List<GlobNotificationTrack> elems = new ArrayList<>();
            msgs.forEach(it -> {
                if (it != null) {
                    BpmMailMessage msg = (BpmMailMessage) it;
                    GlobNotificationTrack track = new GlobNotificationTrack();
                    track.setModule(module);
                    track.setFunctionality(functionality);
                    track.setRefid(NumberSupport.getBigInteger(msg.getRefId()));
                    Set<String> emailList = new LinkedHashSet<>(Arrays.asList(msg.getTo()));
                    track.setSentTo(StringUtils.join(emailList, ";"));
                    track.setSentFrom(msg.getFrom());
                    track.setNtfType("EMAIL");
                    track.setSubject(msg.getSubject());
                    track.setContent(msg.getMessageText());
                    if (msg.getStatus() != null && !msg.getStatus().isEmpty() && msg.getStatus().equals("WAITING")) {
                        track.setStatus("WAITING");
                        track.setUniqueToken(msg.getToken());
                    } else {
                        track.setStatus("SENDED");
                    }
                    elems.add(track);
                }
            });
            batchSave(elems);
        }
    }

    @Override
    public void save(String module, String functionality, BpmMailMessage msg) {
        save(module, functionality, msg, "EMAIL");
    }

    @Override
    public void save(String module, String functionality, BpmMailMessage msg, String type) {
        if (msg != null) {
            GlobNotificationTrack track = new GlobNotificationTrack();
            track.setModule(module);
            track.setFunctionality(functionality);
            track.setRefid(NumberSupport.getBigInteger(msg.getRefId()));
            Set<String> emailList = new LinkedHashSet<>(Arrays.asList(msg.getTo()));
            track.setSentTo(StringUtils.join(emailList, ";"));
            track.setSentFrom(msg.getFrom());
            track.setNtfType(type);
            track.setSubject(msg.getSubject());
            track.setContent(msg.getMessageText());
            if (msg.getStatus() != null && !msg.getStatus().isEmpty() && msg.getStatus().equals("WAITING")) {
                track.setStatus("WAITING");
                track.setUniqueToken(msg.getToken());
            } else {
                track.setStatus("SENDED");
            }
            this.save(track);
        }
    }

    @Override
    public void save(String module, String functionality, SystemMailMessage msg) {
        save(module, functionality, msg, "EMAIL");
    }

    @Override
    public void save(String module, String functionality, SystemMailMessage msg, String type) {
        if (msg != null) {
            GlobNotificationTrack track = new GlobNotificationTrack();
            track.setModule(module);
            track.setFunctionality(functionality);
            track.setRefid(NumberSupport.getBigInteger(msg.getRefId()));
            Set<String> emailList = new LinkedHashSet<>(Arrays.asList(msg.getTo()));
            track.setSentTo(StringUtils.join(emailList, ";"));
            track.setSentFrom(msg.getFrom());
            track.setNtfType(type);
            track.setSubject(msg.getSubject());
            track.setContent(msg.getMessageText());
            track.setProjectId(msg.getProjectId());
            track.setClientId(msg.getClientId());
            track.setSenderInfo(msg.getSenderInfo());
            if (msg.getCategoryId() != null) {
                QmCvlFieldData cvlCategory = qmCvlFieldDataService.findById(NumberSupport.getBigDecimal(msg.getCategoryId()));
                if (cvlCategory != null) {
                    track.setCategoryId(cvlCategory);
                }
            }
            if (msg.getStatus() != null && !msg.getStatus().isEmpty() && msg.getStatus().equals("WAITING")) {
                track.setStatus("WAITING");
                track.setUniqueToken(msg.getToken());
            } else {
                track.setStatus("SENDED");
            }
            this.save(track);
        }
    }

    @Override
    public void update(GlobNotificationTrack elem) {
        if (elem != null) {
            GlobNotificationTrack model = findById(elem.getId());
            model.setUniqueToken(elem.getUniqueToken());
            model.setStatus(elem.getStatus());
            model.setAnswer(elem.getAnswer());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobNotificationTrack> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Boolean updateBasicTechAnswer(String token, String answer, String techid) {
        GlobNotificationTrack track = dao.findByToken(token);
        if (track != null) {
            track.setAnswer(answer);
            track.setStatus("ANSWERED");
            track.setUniqueToken("-1");
            dao.update(track);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean updateTechAnswer(String token, String answer, String techid) {
        GlobNotificationTrack track = dao.findByToken(token);
        if (track != null) {
            track.setAnswer(answer);
            track.setStatus("ANSWERED");
            track.setUniqueToken("-1");
            dao.update(track);

            GlobDispatchcallLog req = daoDispatchcallLog.findById(NumberSupport.getBigDecimal(techid));

            if (answer.equals("N")) {
                req.setDecisionFlag(2L);
            }

            if (answer.equals("Y")) {
                req.setDecisionFlag(1L);
            }

            daoDispatchcallLog.update(req);

            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean updateInspAnswer(String token, String answer, String inspid) {
        GlobNotificationTrack track = dao.findByToken(token);
        if (track != null) {
            track.setAnswer(answer);
            track.setStatus("ANSWERED");
            track.setUniqueToken("-1");
            dao.update(track);

            GlobInspworkorder req = daoInspWo.findById(NumberSupport.getBigDecimal(inspid));

            if (answer.equals("N")) {
                req.setDecisionflag(new BigInteger("2"));
            }

            if (answer.equals("Y")) {
                req.setDecisionflag(BigInteger.ONE);
            }

            daoInspWo.update(req);

            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public List<GlobNotificationTrack> findAllByRefIdAndNotSended(String functionality, String refid) {
        return dao.findAllByRefIdAndNotSended(functionality, refid);
    }

    @Override
    public List<GlobNotificationTrack> findAllByRefIdAndStatus(String functionality, String refid, String status) {
        return dao.findAllByRefIdAndStatus(functionality, refid, status);
    }

    @Override
    public List<GlobNotificationTrack> findAllByRefId(String functionality, String refid) {
        return dao.findAllByRefId(functionality, refid);
    }

    @Override
    public DataTableWrapper<GlobNotificationTrack> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobNotificationTrack> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @Override
    public DataGridWrapper<GlobNotificationTrack> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

}
