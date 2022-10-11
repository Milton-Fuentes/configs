package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotSndsT104Dao;
import com.atser.tools.atserejb.model.DotSndsT104;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotSndsT104Pojo;
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
public class DotSndsT104ServiceImpl implements DotSndsT104Service, IBaseEJBException {

    @Inject
    private DotSndsT104Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotSndsT104> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotSndsT104> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSndsT104> finalList = list(request);
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
    public DataTableWrapper<DotSndsT104> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotSndsT104> finalList = list(request);
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
        List<DotSndsT104Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotSndsT104_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T 104 Soundness of Aggregate by Use of Sodium Sulfate or Magnesium Sulfate", DotSndsT104Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotSndsT104ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotSndsT104Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotSndsT104> filterList = list(request);
        List<DotSndsT104Pojo> rList = new ArrayList<>();
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

    private DotSndsT104Pojo generatePojo(DotSndsT104 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotSndsT104Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotSndsT104Pojo populatePojo(DotSndsT104 elem) {
        DotSndsT104Pojo pojo = new DotSndsT104Pojo();
        pojo.setNiPctRetained(elem.getNiPctRetained());
        pojo.setOrigPctRetained(elem.getOrigPctRetained());
        pojo.setMassPctLoss(elem.getMassPctLoss());
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
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setRemarks(elem.getRemarks());
        pojo.setSetName(elem.getSetName());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setCurrentGrade(elem.getCurrentGrade());
        pojo.setSpecMin(elem.getSpecMin());
        pojo.setSpecMax(elem.getSpecMax());
        pojo.setPan(elem.getPan());
        pojo.setTotalagggrading(elem.getTotalagggrading());
        pojo.setTotalwtsample(elem.getTotalwtsample());
        pojo.setTotalpercentpass(elem.getTotalpercentpass());
        pojo.setTotalpercentloss(elem.getTotalpercentloss());
        pojo.setTotalNiPctRetained(elem.getTotalNiPctRetained());
        pojo.setSoundnessLoss(elem.getSoundnessLoss());
        pojo.setAggCurrentGrade(elem.getAggCurrentGrade());
        pojo.setSolution1(elem.getSolution1());
        pojo.setSolution2(elem.getSolution2());
        pojo.setTemp1(elem.getTemp1());
        pojo.setTemp2(elem.getTemp2());
        pojo.setNewSolution1(elem.getNewSolution1());
        pojo.setNewSolution2(elem.getNewSolution2());
        pojo.setTotalMassPctLoss(elem.getTotalMassPctLoss());
        pojo.setPassfail(elem.getPassfail());
        pojo.setAggName(elem.getAggName());
        pojo.setAgggrading(elem.getAgggrading());
        pojo.setWtsample(elem.getWtsample());
        pojo.setPercentpassing(elem.getPercentpassing());
        pojo.setWtpercentloss(elem.getWtpercentloss());
        pojo.setSieveName(elem.getSieveName());
        pojo.setRunNo(StringSupport.getString(elem.getRunNo()));
        pojo.setProjrequire(elem.getProjrequire());
        pojo.setRetSieveName(elem.getRetSieveName());
        pojo.setLossOfWeight(elem.getLossOfWeight());
        return pojo;
    }
}
