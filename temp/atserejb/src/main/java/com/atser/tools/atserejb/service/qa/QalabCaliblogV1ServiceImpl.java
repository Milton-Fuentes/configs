/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserejb.model.QalabCaliblogV1;
import com.atser.tools.atserejb.model.QalabEquipinfoV1;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import com.atser.tools.atserejb.dao.qa.QalabCaliblogV1Dao;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;

@Stateless
public class QalabCaliblogV1ServiceImpl implements QalabCaliblogV1Service, IBaseEJBException {

    private final String rootFolderName = "Calibration";

    @Inject
    private QalabCaliblogV1Dao dao;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private QalabEquipinfoV1Service qalabEqInfoService;

    @Override
    public QalabCaliblogV1 findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public QalabCaliblogV1 findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QalabCaliblogV1 findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QalabCaliblogV1 findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QalabCaliblogV1 elem = dao.findById(id);
            if (elem.getFolderId() == null) {
                BigDecimal fId = createFolderStruct(header.getUserid(), header.getClientid(), elem);
                elem.setFolderId(fId.toBigInteger());
                dao.update(elem);
            }
            return elem;
        }
    }

    @Override
    public BigDecimal save(ManageITHeader header, QalabCaliblogV1 elem) {
        if (elem != null) {
            if (existCalibDate(elem.getLabEquipId().getId(), elem.getCalibDate())) {
                throwBaseException(Response.Status.CONFLICT, "The Calibration Date already exists.");
            }
            BigDecimal fId = createFolderStruct(header.getUserid(), header.getClientid(), elem);
            elem.setFolderId(fId.toBigInteger());
            dao.save(elem);
            updateExpirationDate(elem.getLabEquipId().getId());
        }
        return BigDecimal.ZERO;
    }

    private void updateExpirationDate(BigDecimal eqId) {
        // Update Due Date
        ManageITBodyRequest searchLog = new ManageITBodyRequest(0, 0);
        searchLog.filter("labEquipId.id", eqId);
        List<QalabCaliblogV1> filterList = list(searchLog);
        if (!filterList.isEmpty()) {
            Comparator<QalabCaliblogV1> sByCalibDate = (QalabCaliblogV1 o1, QalabCaliblogV1 o2) -> o1.getCalibDate().compareTo(o2.getCalibDate());
            filterList = filterList.stream().sorted(sByCalibDate.reversed()).collect(Collectors.toList());
            QalabCaliblogV1 modellog = filterList.get(0);
            QalabEquipinfoV1 modelInfo = qalabEqInfoService.findById(modellog.getLabEquipId().getId().toString());
            Date calibDate = modellog.getCalibDate();
            modelInfo.setLogDate(calibDate);
            modelInfo.setExpirationDate(getExpirationDate(calibDate, modelInfo.getEquipId().getIntervalM().longValue()));
            qalabEqInfoService.updateExpirationDate(modelInfo);
        } else {
            QalabEquipinfoV1 modelInfo = qalabEqInfoService.findById(eqId.toString());
            modelInfo.setLogDate(null);
            modelInfo.setExpirationDate(getExpirationDate(modelInfo.getInserviceDate(), modelInfo.getEquipId().getIntervalM().longValue()));
            qalabEqInfoService.updateExpirationDate(modelInfo);
        }
    }

    private Date getExpirationDate(Date calibDate, long interval) {
        return DateSupport.addChronoUnitToDate(calibDate, ChronoUnit.MONTHS, interval);
    }

    private Boolean existCalibDate(BigDecimal eqId, Date calibDate) {
        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("labEquipId.id", eqId);
        List<QalabCaliblogV1> filterList = list(search);
        if (!filterList.isEmpty()) {
            return filterList.stream().anyMatch(p -> p.getCalibDate().compareTo(calibDate) == 0);
        }
        return Boolean.FALSE;
    }

    @Override
    public QalabCaliblogV1 getLastCalibrationLog(BigDecimal eqId) {
        ManageITBodyRequest searchLog = new ManageITBodyRequest(0, 0);
        searchLog.filter("labEquipId.id", eqId);
        List<QalabCaliblogV1> filterList = list(searchLog);

        if (!filterList.isEmpty()) {
            Comparator<QalabCaliblogV1> sByCalibDate = (QalabCaliblogV1 o1, QalabCaliblogV1 o2) -> o1.getCalibDate().compareTo(o2.getCalibDate());
            filterList = filterList.stream().sorted(sByCalibDate.reversed()).collect(Collectors.toList());
            return filterList.get(0);
        }
        return null;
    }

    @Override
    public void update(QalabCaliblogV1 elem) {
        if (elem != null) {
            QalabCaliblogV1 model = findById(elem.getId());
            model.setCalibDate(elem.getCalibDate());
            model.setPerformedby(elem.getPerformedby());
            model.setComments(elem.getComments());
            updateFolderCalibDate(elem.getFolderId(), elem.getCalibDate());
            dao.update(model);
            updateExpirationDate(elem.getLabEquipId().getId());
        }
    }

    @Override
    public void delete(String id) {        
        if (id != null) {
            QalabCaliblogV1 elem = findById(id);
            if (elem != null) {
                GlobFolder folderId = folderService.findById(StringSupport.getString(elem.getFolderId()));
                if (folderId != null) {
                    folderService.delete(elem.getFolderId());
                }
                dao.delete(NumberSupport.getBigDecimal(id));
                updateExpirationDate(elem.getLabEquipId().getId());
            }
        }
    }

    @Override
    public void delete(BigDecimal id) {
        if (id != null) {
            delete(id.toString());
        }
    }

    @Override
    public List<QalabCaliblogV1> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<QalabCaliblogV1> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QalabCaliblogV1> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    private void updateFolderCalibDate(BigInteger folderId, Date date) {
        GlobFolder elem = folderService.findById(folderId.toString());
        elem.setFName(DateSupport.formatDate(date, DateSupport.factorySimpleDateFormat("MMddyyyy")));
        folderService.update(elem);
    }

    private BigDecimal createFolderStruct(String userId, String clientId, QalabCaliblogV1 elem) {
        if (StringSupport.isNullOrEmpty(clientId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigDecimal rootFolderId = qalabEqInfoService.createEquipFolderStruct(userId, clientId, elem.getLabEquipId().getId().toString());
        BigInteger cId = new BigInteger(clientId);
        BigInteger owner = NumberSupport.getBigInteger(userId);
        // Create Calibration Root Folder
        BigDecimal CalibRootFolderId = folderService.getFolderIdByClientBy(clientId, rootFolderName, rootFolderId.toBigInteger());
        if (CalibRootFolderId == null) {
            CalibRootFolderId = folderService.createTrackITFolder(rootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', rootFolderName, new BigInteger("2"));
        }
        String calibFolderName = DateSupport.formatDate(elem.getCalibDate(), DateSupport.factorySimpleDateFormat("MMddyyyy"));
        BigDecimal CalibDateFolderId = folderService.createTrackITFolder(CalibRootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', calibFolderName, new BigInteger("2"));
        return CalibDateFolderId;
    }

    @Override
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void update(ManageITHeader header, QalabCaliblogV1 elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataGridWrapper<QalabCaliblogV1> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
