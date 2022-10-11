/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QasoilDensityDao;
import com.atser.tools.atserejb.model.QasoilDensity;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QasoilDensityServiceImpl implements QasoilDensityService, IBaseEJBException {

    @Inject
    private QasoilDensityDao dao;

    @Override
    public QasoilDensity findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QasoilDensity findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public QasoilDensity findBySampleTestId(BigInteger id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.findBySampleTestId(id);
    }

    @Override
    public void save(ManageITHeader header, QasoilDensity elem) {
        if (elem != null) {
            elem.setCreateDate(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            elem.setCreateBy(header.getUser());
            elem.setCreateByIp(header.getModIp());
            elem.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            elem.setActive('Y');
            elem.setVersion("0");
            dao.save(elem);
        }
    }

    @Override
    public void update(ManageITHeader header, QasoilDensity elem) {
        if (elem != null) {
            QasoilDensity model = findById(elem.getId());
            model.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            model.setLastModBy(header.getUser());
            model.setLastModIp(header.getModIp());
            dao.update(populate(model, elem));
        }
    }

    private QasoilDensity populate(QasoilDensity model, QasoilDensity elem) {
        model.setCategory(elem.getCategory());
        model.setCompspec(elem.getCompspec());
        model.setMoistureTolReq(elem.getMoistureTolReq());
        model.setProctorType(elem.getProctorType());
        model.setTestinstr(elem.getTestinstr());
        model.setSerialno(elem.getSerialno());
        model.setStdctdensity(elem.getStdctdensity());
        model.setStdctmoisture(elem.getStdctmoisture());
        model.setTesttype(elem.getTesttype());
        model.setWeather(elem.getWeather());
        model.setSpecRef(elem.getSpecRef());
        model.setPage(elem.getPage());
        model.setReport(elem.getReport());
        model.setUnitengmet(elem.getUnitengmet());
        model.setCompEquipment(elem.getCompEquipment());
        model.setRemarks(elem.getRemarks());
        model.setForeman(elem.getForeman());
        model.setCategoryno(elem.getCategoryno());
        model.setRandomshtno(elem.getRandomshtno());
        model.setMaterialdesc(elem.getMaterialdesc());
        model.setGenTestloc(elem.getGenTestloc());
        model.setFarSummary(elem.getFarSummary());
        model.setAvgCompaction(elem.getAvgCompaction());
        model.setSplitno(elem.getSplitno());
        model.setSplitsample(elem.getSplitsample());
        model.setClass1(elem.getClass1());
        model.setContractName(elem.getContractName());
        model.setTestplanId(elem.getTestplanId());
        model.setCompspecMax(elem.getCompspecMax());
        model.setQuantity(elem.getQuantity());
        model.setSuperintendentId(elem.getSuperintendentId());
        model.setForemanId(elem.getForemanId());
        model.setBidItemNumber(elem.getBidItemNumber());
        model.setDbSection(elem.getDbSection());
        model.setDepartLab(elem.getDepartLab());
        model.setArriveSite(elem.getArriveSite());
        model.setLunchHours(elem.getLunchHours());
        model.setLunchMins(elem.getLunchMins());
        model.setDepartSite(elem.getDepartSite());
        model.setArriveLab(elem.getArriveLab());
        model.setTotalHours(elem.getTotalHours());
        model.setTechnicianHoursOvertime(elem.getTechnicianHoursOvertime());
        model.setMoistureTolReqPlus(elem.getMoistureTolReqPlus());
        model.setMoistureTolReqMinus(elem.getMoistureTolReqMinus());
        model.setNumPoints(elem.getNumPoints());
        model.setSoilSpecId(elem.getSoilSpecId());
        model.setChartType(elem.getChartType());
        model.setMileage(elem.getMileage());
        model.setGaugeModelNo(elem.getGaugeModelNo());
        model.setGaugeNo(elem.getGaugeNo());
        model.setDateCalibration(elem.getDateCalibration());
        model.setIsPlus10Correction(elem.getIsPlus10Correction());
        model.setTotalWeight(elem.getTotalWeight());
        model.setRetNo10(elem.getRetNo10());
        model.setPerRetNo10(elem.getPerRetNo10());
        model.setPlus10AbsorbPerc(elem.getPlus10AbsorbPerc());
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QasoilDensity> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }
}
