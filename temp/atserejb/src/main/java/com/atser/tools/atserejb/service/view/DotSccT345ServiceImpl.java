/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.DotSccT345Dao;
import com.atser.tools.atserejb.model.DotSccT345;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotSccT345Pojo;
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
public class DotSccT345ServiceImpl implements DotSccT345Service, IBaseEJBException {

    @Inject
    private DotSccT345Dao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotSccT345> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotSccT345> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSccT345> finalList = list(request);
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
    public DataTableWrapper<DotSccT345> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSccT345> finalList = list(request);
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
        List<DotSccT345Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotSccT345_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 345 SCC Passing Ability by J-Ring", DotSccT345Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(DotSccT345ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotSccT345Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotSccT345> filterList = list(request);
        List<DotSccT345Pojo> rList = new ArrayList<>();
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

    private DotSccT345Pojo generatePojo(DotSccT345 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotSccT345Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new DotSccT345Pojo();
            //response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setActive(elem.getActive());
            response.setPeReview(elem.getPeReview());
            response.setTestClosed(elem.getTestClosed());
            response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setId(StringSupport.getString(elem.getId()));
            response.setTestoNo(elem.getTestoNo());
            response.setBiditemNo(elem.getBiditemNo());
            response.setpNumber(elem.getpNumber());
            response.setpName(elem.getpName());
            response.setLabname(elem.getLabname());
            response.setTraceNo(elem.getTraceNo());
            response.setCmLocation(elem.getCmLocation());
            response.setStatus(elem.getStatus());
            response.setTestNoLink(elem.getTestNoLink());
            response.setTestingTech(elem.getTestingTech());
            response.setRemarks(elem.getRemarks());
            response.setEquipList(elem.getEquipList());
            response.setTechId(elem.getTechId());
            response.setFunction(elem.getFunction());
            response.setMixdesignno(elem.getMixdesignno());
            response.setSampleNo(elem.getSampleNo());
            response.setTestResults(elem.getTestResults());
            response.setPassfail(elem.getPassfail());
            response.setSpecMax(elem.getSpecMax());
            response.setStatus2(elem.getStatus2());
            response.setLabPrep(elem.getLabPrep());
            response.setSpecMin(elem.getSpecMin());
            response.setjRingTestValue(elem.getjRingTestValue());
            response.setDiffH1Ham(elem.getDiffH1Ham());
            response.setDiameterThroughJRing1(elem.getDiameterThroughJRing1());
            response.setDiameterThroughJRing2(elem.getDiameterThroughJRing2());
            response.setjRingFlow(elem.getjRingFlow());
            response.setDiameterWithoutJRing1(elem.getDiameterWithoutJRing1());
            response.setDiameterWithoutJRing2(elem.getDiameterWithoutJRing2());
            response.setSlumpFlow(elem.getSlumpFlow());
            response.setPassingAbilityScc(elem.getPassingAbilityScc());
            response.setHeightInsideJRing1(elem.getHeightInsideJRing1());
            response.setHeightInsideJRing2(elem.getHeightInsideJRing2());
            response.setHeightInsideJRing3(elem.getHeightInsideJRing3());
            response.setHeightInsideJRing4(elem.getHeightInsideJRing4());
            response.setHam(elem.getHam());
            response.setHeightOutsideJRing1(elem.getHeightOutsideJRing1());
            response.setHeightOutsideJRing2(elem.getHeightOutsideJRing2());
            response.setHeightOutsideJRing3(elem.getHeightOutsideJRing3());
            response.setHeightOutsideJRing4(elem.getHeightOutsideJRing4());
            response.setHbm(elem.getHbm());
            response.setHab(elem.getHab());
            response.setH1HeightSccCenterRing(elem.getH1HeightSccCenterRing());
            response.setSubbiditemDescript(elem.getSubbiditemDescript());
            response.setBiditemDescript(elem.getBiditemDescript());
            response.setSampleTcn(elem.getSampleTcn());

            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
