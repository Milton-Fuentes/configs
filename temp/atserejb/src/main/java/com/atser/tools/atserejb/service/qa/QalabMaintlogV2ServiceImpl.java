/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.qa.QalabMaintlogV2Dao;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserejb.model.QalabMaintlogV2;
import com.atser.tools.atserejb.model.QalabMainttypeV2;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QalabMaintlogV2ServiceImpl implements QalabMaintlogV2Service, IBaseEJBException {

    private final String rootFolderName = "Maintenance";

    @Inject
    private QalabMaintlogV2Dao dao;

    @Inject
    private QalabMainttypeV2Service qalabMainttypeService;

    @Inject
    private GlobFolderService folderService;

    @Inject
    private QalabEquipinfoV2Service qalabEqInfoService;

    @Override
    public QalabMaintlogV2 findById(String id) {
        return findById(null, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QalabMaintlogV2 findById(BigDecimal id) {
        return findById(null, id);
    }

    @Override
    public QalabMaintlogV2 findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public QalabMaintlogV2 findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            QalabMaintlogV2 elem = dao.findById(id);
            if (elem.getFolderId() == null) {
                BigDecimal fId = createFolderStruct(header.getUserid(), header.getClientid(), elem);
                elem.setFolderId(fId.toBigInteger());
                dao.update(elem);
            }
            return elem;
        }
    }

    @Override
    public BigDecimal save(ManageITHeader header, QalabMaintlogV2 elem) {
        if (elem != null) {
            if (existMaintDate(elem.getEquipInfoid().getId(), elem.getEquipMaintTypeid().getId(), elem.getMaintDate())) {
                throwBaseException(Response.Status.CONFLICT, "The Maintenance Date already exists.");
            }
            BigDecimal fId = createFolderStruct(header.getUserid(), header.getClientid(), elem);
            elem.setFolderId(fId.toBigInteger());
            elem.setMaintDueDate(getMaintDueDate(elem));
            dao.save(elem);
        }
        return BigDecimal.ZERO;
    }

    private Boolean existMaintDate(BigDecimal eqId, BigDecimal eqMPartId, Date maintDate) {
        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("equipInfoid.id", eqId).filter("equipMaintTypeid.id", eqMPartId);
        List<QalabMaintlogV2> filterList = list(search);
        if (!filterList.isEmpty()) {
            return filterList.stream().anyMatch(p -> p.getMaintDate().compareTo(maintDate) == 0);
        }
        return Boolean.FALSE;
    }

    private Date getMaintDueDate(QalabMaintlogV2 elem) {
        QalabMainttypeV2 mtype = qalabMainttypeService.findById(elem.getEquipMaintTypeid().getId().toString());
        Date dueDate = DateSupport.addChronoUnitToDate(elem.getMaintDate(), ChronoUnit.MONTHS, mtype.getIntervalM().longValue());
        return dueDate;
    }

    @Override
    public void update(QalabMaintlogV2 elem) {
        if (elem != null) {
            QalabMaintlogV2 model = findById(elem.getId());
            model.setEquipMaintTypeid(elem.getEquipMaintTypeid());
            model.setMaintDate(elem.getMaintDate());
            model.setPerformedby(elem.getPerformedby());
            model.setDescription(elem.getDescription());
            model.setMaintDueDate(getMaintDueDate(elem));
            updateMaintFolderDate(elem.getFolderId(), elem.getMaintDate());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            QalabMaintlogV2 elem = findById(id);
            if (elem != null) {
                GlobFolder folderId = folderService.findById(StringSupport.getString(elem.getFolderId()));
                if (folderId != null) {
                    folderService.delete(elem.getFolderId());
                }
                dao.delete(NumberSupport.getBigDecimal(id));
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
    public List<QalabMaintlogV2> list(ManageITBodyRequest request) {
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
    public DataTableWrapper<QalabMaintlogV2> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QalabMaintlogV2> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    private void updateMaintFolderDate(BigInteger folderId, Date date) {
        GlobFolder elem = folderService.findById(folderId.toString());
        elem.setFName(DateSupport.formatDate(date, DateSupport.factorySimpleDateFormat("MMddyyyy")));
        folderService.update(elem);
    }

    private BigDecimal createFolderStruct(String userId, String clientId, QalabMaintlogV2 elem) {
        if (StringSupport.isNullOrEmpty(clientId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigDecimal rootFolderId = qalabEqInfoService.createEquipFolderStruct(userId, clientId, elem.getEquipInfoid().getId().toString());
        BigInteger cId = new BigInteger(clientId);
        BigInteger owner = NumberSupport.getBigInteger(userId);
        // Create Maintenance Root Folder
        BigDecimal MRootFolderId = folderService.getFolderIdByClientBy(clientId, rootFolderName, rootFolderId.toBigInteger());
        if (MRootFolderId == null) {
            MRootFolderId = folderService.createTrackITFolder(rootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', rootFolderName, new BigInteger("2"));
        }
        String MFolderName = DateSupport.formatDate(elem.getMaintDate(), DateSupport.factorySimpleDateFormat("MMddyyyy"));
        BigDecimal MDateFolderId;
        MDateFolderId = folderService.getFolderIdByClientBy(clientId, MFolderName, MRootFolderId.toBigInteger());
        if (MDateFolderId == null) {
            return folderService.createTrackITFolder(MRootFolderId, cId.negate(), owner, BigInteger.ZERO, 'Y', "Y", 'N', MFolderName, new BigInteger("2"));
        }
        return MDateFolderId;
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
    public void update(ManageITHeader header, QalabMaintlogV2 elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataGridWrapper<QalabMaintlogV2> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
