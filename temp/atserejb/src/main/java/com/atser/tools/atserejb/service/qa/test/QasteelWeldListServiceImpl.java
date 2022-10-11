/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.dao.qa.test.QasteelWeldListDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.model.QasteelWeldList;
import com.atser.tools.atserejb.model.QasteelWeldListout;
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
public class QasteelWeldListServiceImpl implements QasteelWeldListService, IBaseEJBException {

    @Inject
    private QasteelWeldListDao dao;
    @Inject
    QaSampleTestAddInfoService qaSampleTestAddInfoService;
    @Inject
    private QasteelWeldListoutService serviceOut;

    @Override
    public QasteelWeldList findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QasteelWeldList findByTestId(BigInteger testid) {
        return dao.findByTestId(NumberSupport.getBigInteger(testid));
    }

    @Override
    public QasteelWeldList findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, QasteelWeldList elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(elem.getSampletestId())) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            return dao.save(elem).getId();
        }
        return null;
    }

    @Override
    public void update(ManageITHeader header, QasteelWeldList elem) {
        if (elem != null) {
            QasteelWeldList model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                model = populate(model, elem);
                dao.update(model);
            }
            if (model.getQasteelWeldListoutList() != null) {
                for (QasteelWeldListout object : model.getQasteelWeldListoutList()) {
                    if (object.getId() != null) {
                        serviceOut.update(header, object);
                    } else {
                        serviceOut.save(header, object);
                    }

                }
            }

        }
    }

    private QasteelWeldList populate(QasteelWeldList model, QasteelWeldList elem) {
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
        //----test--------------------------------------------------------------
        model.setApplAccepStandard(elem.getApplAccepStandard());
        model.setNextSpecNo(elem.getNextSpecNo());

        //----Test Field--------------------------------------------------------
        model.setDepartLab(elem.getDepartLab());
        model.setArriveLab(elem.getArriveLab());
        return model;
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
    public List<QasteelWeldList> list(ManageITBodyRequest request) {
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
    public void calcTest(QasteelWeldList model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BigDecimal id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataGridWrapper<QasteelWeldList> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<QasteelWeldList> dataTableList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
