/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.DotWcT318Dao;
import com.atser.tools.atserejb.model.DotWcT318;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotWcT318Pojo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;

@Stateless
public class DotWcT318ServiceImpl implements DotWcT318Service, IBaseEJBException {

    @Inject
    private DotWcT318Dao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotWcT318> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotWcT318> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotWcT318> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<DotWcT318> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotWcT318> finalList = list(request);
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
    public String generateReport(String docpathsegment, String docType, List<ReportGridColumnsTO> columns, String clientId, ManageITBodyRequest request) {
        if (request == null || columns == null || columns.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        List<DotWcT318Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotWcT318_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 318 Fresh Concrete Water Content (Microwave Oven Drying)", DotWcT318Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(DotWcT318ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotWcT318Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotWcT318> filterList = list(request);
        List<DotWcT318Pojo> rList = new ArrayList<>();
        if (filterList != null && !filterList.isEmpty()) {
            //Get Project
            GlobProject project = projectService.findById(StringSupport.emptyOnNull(filterList.get(0).getProjectId()));
            BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
            filterList.forEach((it) -> {
                rList.add(generatePojo(it, project, projectLogoImage));
            });
        }
        return rList;
    }

    private DotWcT318Pojo generatePojo(DotWcT318 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotWcT318Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new DotWcT318Pojo();
            //response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setActive(elem.getActive());
            response.setPeReview(elem.getPeReview());
            response.setTestClosed(elem.getTestClosed());
            response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setId(StringSupport.getString(elem.getId()));

            response.setBatchSize(elem.getBatchSize());
            response.setFineAgg(elem.getFineAgg());
            response.setFineAggMoist(elem.getFineAggMoist());
            response.setCoarseAgg(elem.getCoarseAgg());
            response.setCoarseAggMoist(elem.getCoarseAggMoist());
            response.setUnitWeight(elem.getUnitWeight());
            response.setTestNo(elem.getTestNo());
            response.setBiditemNo(elem.getBiditemNo());
            response.setpNumber(elem.getpNumber());
            response.setTraceNo(elem.getTraceNo());
            response.setLabname(elem.getLabname());
            response.setpName(elem.getpName());
            response.setCmLocation(elem.getCmLocation());
            response.setStatus(elem.getStatus());
            response.setTestNoLink(elem.getTestNoLink());
            response.setTestingTech(elem.getTestingTech());
            response.setEquipList(elem.getEquipList());
            response.setRemarks(elem.getRemarks());
            response.setLabPrep(elem.getLabPrep());
            response.setEstMixingWaterContent(elem.getEstMixingWaterContent());
            response.setEstAbsorbedWaterContent(elem.getEstAbsorbedWaterContent());
            response.setTechId(elem.getTechId());
            response.setFunction(elem.getFunction());
            response.setMixdesignno(elem.getMixdesignno());
            response.setSampleNo(elem.getSampleNo());
            response.setTestResults(elem.getTestResults());
            response.setPassfail(elem.getPassfail());
            response.setTrayClothWetSample(elem.getTrayClothWetSample());
            response.setResult(elem.getResult());
            response.setSampleTrayClothDrySample(elem.getSampleTrayClothDrySample());
            response.setSampleWeight1(elem.getSampleWeight1());
            response.setSampleWeight2(elem.getSampleWeight2());
            response.setSampleWeight3(elem.getSampleWeight3());
            response.setSampleWeight4(elem.getSampleWeight4());
            response.setSampleWeight5(elem.getSampleWeight5());
            response.setSampleWeight6(elem.getSampleWeight6());
            response.setSampleWeight7(elem.getSampleWeight7());
            response.setSampleWeight8(elem.getSampleWeight8());
            response.setSampleWeight9(elem.getSampleWeight9());
            response.setSpecMax(elem.getSpecMax());
            response.setSpecMin(elem.getSpecMin());
            response.setTotalMeasWaterContent(elem.getTotalMeasWaterContent());
            response.setTrayCloth(elem.getTrayCloth());
            response.setBiditemDescript(elem.getBiditemDescript());
            response.setSubbiditemDescript(elem.getSubbiditemDescript());
            response.setSampleTcn(elem.getSampleTcn());

            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
