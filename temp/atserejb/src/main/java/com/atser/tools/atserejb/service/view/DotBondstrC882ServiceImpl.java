/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.DotBondstrC882Dao;
import com.atser.tools.atserejb.model.DotBondstrC882;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotBondstrC882Pojo;
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
public class DotBondstrC882ServiceImpl implements DotBondstrC882Service, IBaseEJBException {

    @Inject
    private DotBondstrC882Dao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotBondstrC882> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotBondstrC882> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotBondstrC882> finalList = list(request);
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
    public DataTableWrapper<DotBondstrC882> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotBondstrC882> finalList = list(request);
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
        List<DotBondstrC882Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotBondstrC882_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "C882 Concrete Strength with Epoxy-Resin(Slant Shear", DotBondstrC882Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(DotBondstrC882ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotBondstrC882Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotBondstrC882> filterList = list(request);
        List<DotBondstrC882Pojo> rList = new ArrayList<>();
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

    private DotBondstrC882Pojo generatePojo(DotBondstrC882 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotBondstrC882Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = new DotBondstrC882Pojo();
            response.setActive(elem.getActive());
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setId(StringSupport.getString(elem.getId()));
            response.setTestNo(elem.getTestNo());
            response.setBiditemNo(elem.getBiditemNo());
            response.setpNumber(elem.getpNumber());
            response.setpName(elem.getpName());
            response.setTraceNo(elem.getTraceNo());
            response.setCmLocation(elem.getCmLocation());
            response.setLabname(elem.getLabname());
            response.setStatus(elem.getStatus());
            response.setTestNoLink(elem.getTestNoLink());
            response.setTestingTech(elem.getTestingTech());
            response.setEquipList(elem.getEquipList());
            response.setRemarks(elem.getRemarks());
            response.setTestResults(elem.getTestResults());
            response.setLabPrep(elem.getLabPrep());
            response.setSampleNo(elem.getSampleNo());
            response.setTechId(elem.getTechId());
            response.setMixdesignno(elem.getMixdesignno());
            response.setFunction(elem.getFunction());
            response.setSpecimenNo(elem.getSpecimenNo());
            response.setPassfail(elem.getPassfail());
            response.setSpecMin(elem.getSpecMin());
            response.setSpecMax(elem.getSpecMax());
            response.setBreakPosition(elem.getBreakPosition());
            response.setBondingstrength(elem.getBondingstrength());
            response.setLoad(elem.getLoad());
            response.setBondingArea(elem.getBondingArea());
            response.setAreaVoids(elem.getAreaVoids());
            response.setNoVoids(elem.getNoVoids());
            response.setHeight(elem.getHeight());
            response.setDiameter(elem.getDiameter());
            response.setDatetest(elem.getDatetest());
            response.setTestage(elem.getTestage());
            response.setAvg28days(elem.getAvg28days());
            response.setAvg7days(elem.getAvg7days());
            response.setCuringMethod(elem.getCuringMethod());      
            response.setSamplesperset(elem.getSamplesperset());
            response.setTypeoffracture(elem.getTypeoffracture());           
            response.setSubbiditemDescript(elem.getSubbiditemDescript());
            response.setBiditemDescript(elem.getBiditemDescript());                 
            response.setSampleTcn(elem.getSampleTcn());
            response.setProjectLogo(projectLogoImage);

        }
        return response;
    }

}
