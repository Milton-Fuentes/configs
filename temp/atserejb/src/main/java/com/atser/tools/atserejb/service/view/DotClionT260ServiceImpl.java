/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.DotClionT260Dao;
import com.atser.tools.atserejb.model.DotClionT260;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotClionT260Pojo;
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
public class DotClionT260ServiceImpl implements DotClionT260Service, IBaseEJBException {

    @Inject
    private DotClionT260Dao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotClionT260> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotClionT260> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotClionT260> finalList = list(request);
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
    public DataTableWrapper<DotClionT260> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotClionT260> finalList = list(request);
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
        List<DotClionT260Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotClionT260_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 260 Concrete and Concrete Raw Materials Testing for Chloride Ion", DotClionT260Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(DotClionT260ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotClionT260Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotClionT260> filterList = list(request);
        List<DotClionT260Pojo> rList = new ArrayList<>();
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

    private DotClionT260Pojo generatePojo(DotClionT260 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotClionT260Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new DotClionT260Pojo();
            //response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setActive(elem.getActive());
            response.setPeReview(elem.getPeReview());
            response.setTestClosed(elem.getTestClosed());
            response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setId(StringSupport.getString(elem.getId()));
            response.setTestNo(elem.getTestNo());
            response.setBiditemNo(elem.getBiditemNo());
            response.setMethodChoosenName(elem.getMethodChoosenName());
            response.setpNumber(elem.getpNumber());
            response.setTechId(elem.getTechId());
            response.setLabname(elem.getLabname());
            response.setCmLocation(elem.getCmLocation());
            response.setTraceNo(elem.getTraceNo());
            response.setpName(elem.getpName());
            response.setStatus(elem.getStatus());
            response.setTestNoLink(elem.getTestNoLink());
            response.setTestingTech(elem.getTestingTech());
            response.setRemarks(elem.getRemarks());
            response.setEquipList(elem.getEquipList());
            response.setAaCl(elem.getAaCl());
            response.setAaClPct(elem.getAaClPct());
            response.setTestResults(elem.getTestResults());
            response.setSampleNo(elem.getSampleNo());
            response.setMixdesignno(elem.getMixdesignno());
            response.setFunction(elem.getFunction());
            response.setLabPrep(elem.getLabPrep());
            response.setMethodChoosen(elem.getMethodChoosen());
            response.setSpecMin(elem.getSpecMin());
            response.setSpecMax(elem.getSpecMax());
            response.setPassfail(elem.getPassfail());
            response.setSpecimenNo(elem.getSpecimenNo());
            response.setN1(elem.getN1());
            response.setN13(elem.getN13());
            response.setwMass(elem.getwMass());
            response.setV1(elem.getV1());
            response.setN2(elem.getN2());
            response.setV2(elem.getV2());
            response.setPercentCl(elem.getPercentCl());
            response.setGpEndPointFromGraph(elem.getGpEndPointFromGraph());
            response.setGpMassOfSolution(elem.getGpMassOfSolution());
            response.setGpMassSample(elem.getGpMassSample());
            response.setGpNormalitySolution(elem.getGpNormalitySolution());
            response.setGpActualEndPoint(elem.getGpActualEndPoint());
            response.setPtNormality(elem.getPtNormality());
            response.setPtMassOriginalSample(elem.getPtMassOriginalSample());
            response.setPtEndPoint(elem.getPtEndPoint());
            response.setPtVolumeSolutionAdded(elem.getPtVolumeSolutionAdded());
            response.setPtNormalitySolution(elem.getPtNormalitySolution());
            response.setPtClPct(elem.getPtClPct());
            response.setAtNormality(elem.getAtNormality());
            response.setAtMassOriginalSample(elem.getAtMassOriginalSample());
            response.setAtEndPoint(elem.getAtEndPoint());
            response.setAtVolumeSolutionAdded(elem.getAtVolumeSolutionAdded());
            response.setAtNormalitySolution(elem.getAtNormalitySolution());
            response.setAtClPct(elem.getAtClPct());
            response.setGpClPct(elem.getGpClPct());
            response.setClPct(elem.getClPct());
            response.setUnitMass(elem.getUnitMass());
            response.setCl(elem.getCl());
            response.setAaVolumeOfAliquot(elem.getAaVolumeOfAliquot());
            response.setAaMassOriginalSample(elem.getAaMassOriginalSample());
            response.setBiditemDescript(elem.getBiditemDescript());
            response.setSubbiditemDescript(elem.getSubbiditemDescript());
            response.setSampleTcn(elem.getSampleTcn());
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
