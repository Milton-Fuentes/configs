/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.DotUnitwtydT121Dao;
import com.atser.tools.atserejb.model.DotUnitwtydT121;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotUnitwtydT121Pojo;
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
public class DotUnitwtydT121ServiceImpl implements DotUnitwtydT121Service, IBaseEJBException {

    @Inject
    private DotUnitwtydT121Dao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotUnitwtydT121> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotUnitwtydT121> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotUnitwtydT121> finalList = list(request);
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
    public DataTableWrapper<DotUnitwtydT121> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotUnitwtydT121> finalList = list(request);
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
        List<DotUnitwtydT121Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotUnitwtydT121_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 121/C138 Concrete Unit Weight, Yield & Air Content (Gravimetric)", DotUnitwtydT121Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(DotUnitwtydT121ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotUnitwtydT121Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotUnitwtydT121> filterList = list(request);
        List<DotUnitwtydT121Pojo> rList = new ArrayList<>();
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

    private DotUnitwtydT121Pojo generatePojo(DotUnitwtydT121 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotUnitwtydT121Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new DotUnitwtydT121Pojo();
            //response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setActive(elem.getActive());
            response.setPeReview(elem.getPeReview());
            response.setTestClosed(elem.getTestClosed());
            response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setRowntest(StringSupport.getString(elem.getRowntest()));
            response.setId(StringSupport.getString(elem.getId()));
            response.setReqAircontSpecMax(StringSupport.getString(elem.getReqAircontSpecMax()));
            response.setReqAircontSpecMin(StringSupport.getString(elem.getReqAircontSpecMin()));
            response.setTestNoLink(elem.getTestNoLink());
            response.setTestNo(elem.getTestNo());
            response.setVersion(elem.getVersion());
            response.setBiditemNo(elem.getBiditemNo());
            response.setpNumber(elem.getpNumber());
            response.setpName(elem.getpName());
            response.setCmLocation(elem.getCmLocation());
            response.setTraceNo(elem.getTraceNo());
            response.setLabname(elem.getLabname());
            response.setTechId(elem.getTechId());
            response.setStatus(elem.getStatus());
            response.setTestingTech(elem.getTestingTech());
            response.setRemarks(elem.getRemarks());
            response.setEquipList(elem.getEquipList());
            response.setVolcon(elem.getVolcon());
            response.setUnitwt(elem.getUnitwt());
            response.setYieldyd(elem.getYieldyd());
            response.setYieldmft(elem.getYieldmft());
            response.setYieldmftyd(elem.getYieldmftyd());
            response.setRelyield(elem.getRelyield());
            response.setCementcontent(elem.getCementcontent());
            response.setAircontent(elem.getAircontent());
            response.setPassfail(elem.getPassfail());
            response.setMixdesignno(elem.getMixdesignno());
            response.setTestResults(elem.getTestResults());
            response.setMassconmeas(elem.getMassconmeas());
            response.setMassmeas(elem.getMassmeas());
            response.setVolmeas(elem.getVolmeas());
            response.setTotalmass(elem.getTotalmass());
            response.setMasscement(elem.getMasscement());
            response.setLabPrep(elem.getLabPrep());
            response.setAircontentSpecMax(elem.getAircontentSpecMax());
            response.setAircontentSpecMin(elem.getAircontentSpecMin());
            response.setFunction(elem.getFunction());
            response.setTheounitwt(elem.getTheounitwt());
            response.setSampleNo(elem.getSampleNo());
            response.setSubbiditemDescript(elem.getSubbiditemDescript());
            response.setBiditemDescript(elem.getBiditemDescript());
            response.setSampleTcn(elem.getSampleTcn());
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
