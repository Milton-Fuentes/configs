package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.qa.QaWizardItemDao;
import com.atser.tools.atserejb.model.QaWizardItem;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author mdelabat
 */
@Stateless
@Slf4j
public class QaWizardItemServiceImpl implements QaWizardItemService, IBaseEJBException {

    @Inject
    QaWizardItemDao dao;

    @Override
    public QaWizardItem findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QaWizardItem findById(BigDecimal id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BigDecimal save(ManageITHeader header, QaWizardItem elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ManageITHeader header, QaWizardItem elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BigDecimal id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QaWizardItem> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QaWizardItem> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<QaWizardItem> dataTableList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getVersion(Integer number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getRevisions(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QaWizardItem findNext(ManageITBodyRequest request) {
        try {
            List<QaWizardItem> col = null;
            if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
                col = new ArrayList(list(request));
                List<QaWizardItem> w = dao.findAll();
                for (int i = 0; i < w.size(); i++) {
                    if (w.get(i).getOrder() == col.get(0).getOrder() + 1) {
                        return w.get(i);
                    }
                }
            }
        } catch (Exception e) {

        }

        return null;
    }

}
