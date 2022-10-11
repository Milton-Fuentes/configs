/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.DotConCoreBeanT24Dao;
import com.atser.tools.atserejb.model.DotConCoreBeanT24;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotConCoreBeanT24Pojo;
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
public class DotConCoreBeanT24ServiceImpl implements DotConCoreBeanT24Service, IBaseEJBException {

    @Inject
    private DotConCoreBeanT24Dao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotConCoreBeanT24> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotConCoreBeanT24> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConCoreBeanT24> finalList = list(request);
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
    public DataTableWrapper<DotConCoreBeanT24> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConCoreBeanT24> finalList = list(request);
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
        List<DotConCoreBeanT24Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotConCoreBeanT24_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 24/C42 Drilled Cores and Sawed Concrete Beams Testing", DotConCoreBeanT24Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(DotConCoreBeanT24ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotConCoreBeanT24Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotConCoreBeanT24> filterList = list(request);
        List<DotConCoreBeanT24Pojo> rList = new ArrayList<>();
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

    private DotConCoreBeanT24Pojo generatePojo(DotConCoreBeanT24 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotConCoreBeanT24Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new DotConCoreBeanT24Pojo();
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            response.setpName(elem.getpName());
            response.setpNumber(elem.getpNumber());
            response.setSampleNo(elem.getSampleNo());
            response.setEquipList(elem.getEquipList());
            response.setPassfail(elem.getPassfail());
            response.setTraceNo(elem.getTraceNo());
            response.setCmLocation(elem.getCmLocation());
            response.setTestNo(elem.getTestNo());
            response.setActive(elem.getActive());
            response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setMixdesignno(elem.getMixdesignno());
            response.setFunction(elem.getFunction());
            response.setTestno(elem.getTestNoLink());
            response.setSampleTestno(elem.getSampleTestno());
            response.setSampleTcn(elem.getSampleTcn());
            response.setTechId(elem.getTechId());
            response.setTestingTech(elem.getTestingTech());
            response.setBiditemNo(elem.getBiditemNo());
            response.setBiditemDescript(elem.getBiditemDescript());
            response.setSubbiditemDescript(elem.getSubbiditemDescript());
            response.setSamplesperset(elem.getSamplesperset());
            response.setAverage(elem.getAverage());
            response.setAveragePct(elem.getAveragePct());
            response.setRemarks(elem.getRemarks());
            response.setLabPrep(elem.getLabPrep());
            response.setAverageSpec(elem.getAverageSpec());
            response.setSpecMin(elem.getSpecMin());
            response.setSpecMax(elem.getSpecMax());
            response.setResult(elem.getResult());
            response.setSampleidno(elem.getSampleidno());
            response.setNo(elem.getNo());
            response.setLength(elem.getLength());
            response.setDiameter(elem.getDiameter());
            response.setLengthDiameter(elem.getLengthDiameter());
            response.setWeight(elem.getWeight());
            response.setCorrFactor(elem.getCorrFactor());
            response.setDensity(elem.getDensity());
            response.setArea(elem.getArea());
            response.setLoad(elem.getLoad());
            response.setCorrectedStrength(elem.getCorrectedStrength());
            response.setTypeoffracture(elem.getTypeoffracture());
            response.setPctF(elem.getPctF());
            response.setSpecPctF(elem.getSpecPctF());
            response.setTestResults(elem.getTestResults());
            response.setStatus(elem.getStatus());
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
