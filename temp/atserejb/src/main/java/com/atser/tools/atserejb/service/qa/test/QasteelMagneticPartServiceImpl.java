/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import com.atser.tools.atserejb.dao.qa.test.QasteelMagneticPartDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.objects.to.QaGenericTestTO;
import com.atser.tools.atserejb.model.QaSampleTestAddInfo;
import com.atser.tools.atserejb.model.QasteelMagneticPart;
import com.atser.tools.atserejb.model.QasteelMagneticPartout;
import com.atser.tools.atserejb.model.QasteelMagneticPartoutv;
import com.atser.tools.atserejb.service.qa.QaSampleTestAddInfoService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QasteelMagneticPartServiceImpl implements QasteelMagneticPartService, IBaseEJBException {

    @Inject
    private QasteelMagneticPartDao dao;
    @Inject
    QaSampleTestAddInfoService qaSampleTestAddInfoService;
    @Inject
    private QasteelMagneticPartoutService serviceOut;
    @Inject
    private QasteelMagneticPartoutvService serviceOutv;

    @Override
    public QasteelMagneticPart findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QasteelMagneticPart findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QasteelMagneticPart findByTestId(BigInteger testid) {
        return dao.findByTestId(NumberSupport.getBigInteger(testid));
    }

    @Override
    public QaGenericTestTO<QasteelMagneticPart> findByTestIdTO(BigInteger id) {
        QaGenericTestTO<QasteelMagneticPart> to = new QaGenericTestTO<>();
        to.setTest(findByTestId(id));
        to.setQaSampleTestAddInfo(qaSampleTestAddInfoService.findByTestId(id));
        return to;
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, QasteelMagneticPart elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(elem.getSampletestId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            return dao.save(elem).getId();
        }
        return null;
    }
    @Override
    public void update(ManageITHeader header, QasteelMagneticPart elem) {
        if (elem != null) {
            QasteelMagneticPart model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                populate(model, elem);
                dao.update(model);
            }       
            if (elem.getQasteelMagneticPartoutvList() != null) {
                for (QasteelMagneticPartoutv object : elem.getQasteelMagneticPartoutvList()) {
                    serviceOutv.update(header, object);
                }
            }
            if (elem.getQasteelMagneticPartoutList() != null) {
                for (QasteelMagneticPartout object : elem.getQasteelMagneticPartoutList()) {
                    if (object.getId() != null) {
                        serviceOut.update(header, object);
                    } else {
                        serviceOut.save(header, object);
                    }
                }
            }
        }
    }

    @Override
    public void updateTO(ManageITHeader header, QaGenericTestTO<QasteelMagneticPart> to) {
        if (to != null) {
            QasteelMagneticPart elem = to.getTest();
            QaSampleTestAddInfo addinfoTO = to.getQaSampleTestAddInfo();
            if (elem != null && addinfoTO != null) {
                qaSampleTestAddInfoService.update(header, addinfoTO);
                update(header, elem);
            }
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public void deleteByTestId(String id) {
        if (id != null && qaSampleTestAddInfoService.existsQaSampleTestAddInfo(NumberSupport.getBigDecimal(id))) {
            qaSampleTestAddInfoService.deleteByTestId(id);
            dao.delete(findByTestId(NumberSupport.getBigInteger(id)));

        }
    }

    @Override
    @LatencyLogger
    public List<QasteelMagneticPart> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
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
    public void delete(BigDecimal id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataGridWrapper<QasteelMagneticPart> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<QasteelMagneticPart> dataTableList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calcTest(QasteelMagneticPart model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void populate(QasteelMagneticPart model, QasteelMagneticPart elem) {
        //---commons -----------------------------------------------------------
        model.setField1(elem.getField1());
        model.setField2(elem.getField2());
        model.setField3(elem.getField3());
        model.setField4(elem.getField4());
        model.setField5(elem.getField5());
        model.setField6(elem.getField6());
        model.setField7(elem.getField7());
        model.setField8(elem.getField8());
        model.setField9(elem.getField9());
        model.setField10(elem.getField10());        
        model.setRemarks(elem.getRemarks());
        //----------------------------------------------------------------------
        //----vendor------------------------------------------------------------
        model.setLocationVendor(elem.getLocationVendor());
        model.setDateVendor(elem.getDateVendor());
        model.setPoNo(elem.getPoNo());
        model.setContractor(elem.getContractor());
        model.setReleaseNo(elem.getReleaseNo());
        model.setJobNo(elem.getJobNo());
        model.setJobDescription(elem.getJobDescription());
        model.setMaterialFurnished(elem.getMaterialFurnished());
        model.setEquipmentFurnished(elem.getEquipmentFurnished());
        model.setWorkDescription(elem.getWorkDescription());
        //----------------------------------------------------------------------
        //----test--------------------------------------------------------------
        model.setInspectionClient(elem.getInspectionClient());
        model.setInspectionDate(elem.getInspectionDate());
        model.setInspectionProject(elem.getInspectionProject());
        model.setInspectionCrew(elem.getInspectionCrew());
        model.setEquipment(elem.getEquipment());
        model.setManufacturer1(elem.getManufacturer1());
        model.setManufacturer2(elem.getManufacturer2());
        model.setSerialNo(elem.getSerialNo());
        model.setCalibrationDate(elem.getCalibrationDate());
        model.setMedia(elem.getMedia());
        model.setMethod(elem.getMethod());
        model.setYoke(elem.getYoke());
        model.setIlong(elem.getIlong());
        model.setDry(elem.getDry());
        model.setProd(elem.getProd());
        model.setCoil(elem.getCoil());
        model.setFluorescent(elem.getFluorescent());
        model.setProcedure(elem.getProcedure());
        model.setAcceptableCriteria(elem.getAcceptableCriteria());
        model.setComments(elem.getComments());
        //----------------------------------------------------------------------
        //----Test Field--------------------------------------------------------
        model.setDepartLab(elem.getDepartLab());
        model.setArriveLab(elem.getArriveLab());

    }

}
