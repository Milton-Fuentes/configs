package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotMarT245Dao;
import com.atser.tools.atserejb.model.DotMarT245;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotMarT245Pojo;
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
public class DotMarT245ServiceImpl implements DotMarT245Service, IBaseEJBException {

    @Inject
    private DotMarT245Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotMarT245> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotMarT245> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotMarT245> finalList = list(request);
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
    public DataTableWrapper<DotMarT245> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotMarT245> finalList = list(request);
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
        List<DotMarT245Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotMarT245_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 245 Resistance to Plastic Flow of Compacted Bituminous Mixtures Using Marshall Apparatus", DotMarT245Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotMarT245ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotMarT245Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotMarT245> filterList = list(request);
        List<DotMarT245Pojo> rList = new ArrayList<>();
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

    private DotMarT245Pojo generatePojo(DotMarT245 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotMarT245Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotMarT245Pojo populatePojo(DotMarT245 elem) {
        DotMarT245Pojo pojo = new DotMarT245Pojo();
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setMethod(elem.getMethod());
        pojo.setUnitengmet(elem.getUnitengmet());
        pojo.setRemarks(elem.getRemarks());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setSegment(elem.getSegment());
        pojo.setStationNo(elem.getStationNo());
        pojo.setMixDesignation(elem.getMixDesignation());
        pojo.setLotNo(StringSupport.getString(elem.getLotNo()));
        pojo.setNbBlows(StringSupport.getString(elem.getNbBlows()));
        pojo.setContractName(elem.getContractName());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setDepartLab(elem.getDepartLab());
        pojo.setArriveSite(elem.getArriveSite());
        pojo.setLunchHours(elem.getLunchHours());
        pojo.setLunchMins(elem.getLunchMins());
        pojo.setDepartSite(elem.getDepartSite());
        pojo.setArriveLab(elem.getArriveLab());
        pojo.setTotalHours(elem.getTotalHours());
        pojo.setTechnicianHoursOvertime(StringSupport.getString(elem.getTechnicianHoursOvertime()));
        pojo.setTrialNo(elem.getTrialNo());
        pojo.setThickness(elem.getThickness());
        pojo.setStab(elem.getStab());
        pojo.setFlow(elem.getFlow());
        pojo.setCorfactor(elem.getCorfactor());
        pojo.setStabcor(elem.getStabcor());
        pojo.setVolm(elem.getVolm());
        pojo.setTestTemperature(elem.getTestTemperature());
        pojo.setMaximumLoadDialReading(elem.getMaximumLoadDialReading());
        pojo.setAc(elem.getAc());
        pojo.setSublotNo(StringSupport.getString(elem.getSublotNo()));
        pojo.setAvgstab(elem.getAvgstab());
        pojo.setAvgflow(elem.getAvgflow());
        pojo.setBearingcap(elem.getBearingcap());
        pojo.setSpecMin(elem.getSpecMin());
        pojo.setSpecMax(elem.getSpecMax());
        pojo.setResult(elem.getResult());
        pojo.setFlowSpecMin(elem.getFlowSpecMin());
        pojo.setFlowSpecMax(elem.getFlowSpecMax());
        pojo.setFlowResult(elem.getFlowResult());
        pojo.setPassfail(elem.getPassfail());
        pojo.setTestResults(elem.getTestResults());
        pojo.setStatus(elem.getStatus());
        pojo.setTestClosed(StringSupport.getString(elem.getTestClosed()));
        pojo.setPeReview(StringSupport.getString(elem.getPeReview()));
        pojo.setpName(elem.getpName());
        pojo.setpNumber(elem.getpNumber());
        pojo.setLabname(elem.getLabname());
        pojo.setSampleNo(elem.getSampleNo());
        pojo.setEquipList(elem.getEquipList());
        pojo.setMixDesignNo(elem.getMixDesignNo());
        pojo.setTraceNo(elem.getTraceNo());
        pojo.setCmLocation(elem.getCmLocation());
        pojo.setTestNo(elem.getTestNo());
        pojo.setActive(StringSupport.getString(elem.getActive()));
        pojo.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
        pojo.setFunction(elem.getFunction());
        pojo.setAsphaltcement(elem.getAsphaltcement());
        pojo.setAdditive(elem.getAdditive());
        pojo.setTestNoLink(StringSupport.getString(elem.getTestNoLink()));
        pojo.setSampleTcn(elem.getSampleTcn());
        pojo.setTechId(elem.getTechId());
        return pojo;
    }
}
