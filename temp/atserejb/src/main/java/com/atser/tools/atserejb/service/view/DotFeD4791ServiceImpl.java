package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotFeD4791Dao;
import com.atser.tools.atserejb.model.DotFeD4791;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotFeD4791Pojo;
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
public class DotFeD4791ServiceImpl implements DotFeD4791Service, IBaseEJBException {

    @Inject
    private DotFeD4791Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotFeD4791> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotFeD4791> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotFeD4791> finalList = list(request);
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
    public DataTableWrapper<DotFeD4791> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotFeD4791> finalList = list(request);
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
        List<DotFeD4791Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotFeD4791_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "D4791 Flat or Elongated Particles in Coarse Aggregate", DotFeD4791Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotFeD4791ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotFeD4791Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotFeD4791> filterList = list(request);
        List<DotFeD4791Pojo> rList = new ArrayList<>();
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

    private DotFeD4791Pojo generatePojo(DotFeD4791 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotFeD4791Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotFeD4791Pojo populatePojo(DotFeD4791 elem) {
        DotFeD4791Pojo pojo = new DotFeD4791Pojo();
        pojo.setSieveName(elem.getSieveName());
        pojo.setSieveOrder(StringSupport.getString(elem.getSieveOrder()));
        pojo.setRunNo(StringSupport.getString(elem.getRunNo()));
        pojo.setWtret(elem.getWtret());
        pojo.setAccumwtret(elem.getAccumwtret());
        pojo.setPercentpass(elem.getPercentpass());
        pojo.setProjrequire(elem.getProjrequire());
        pojo.setGroup1No(elem.getGroup1No());
        pojo.setGroup1Mass(elem.getGroup1Mass());
        pojo.setGroup2No(elem.getGroup2No());
        pojo.setGroup2Mass(elem.getGroup2Mass());
        pojo.setGroup3No(elem.getGroup3No());
        pojo.setGroup3Mass(elem.getGroup3Mass());
        pojo.setGroup4No(elem.getGroup4No());
        pojo.setGroup4Mass(elem.getGroup4Mass());
        pojo.setIndividualPercent(StringSupport.getString(elem.getIndividualPercent()));
        pojo.setIndividualRetained(StringSupport.getString(elem.getIndividualRetained()));
        pojo.setPercentFlat(StringSupport.getString(elem.getPercentFlat()));
        pojo.setWeightFlat(StringSupport.getString(elem.getWeightFlat()));
        pojo.setWeightSample(StringSupport.getString(elem.getWeightSample()));
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
        pojo.setTotalPercentRet(StringSupport.getString(elem.getTotalPercentRet()));
        pojo.setTotalPercentRet38(StringSupport.getString(elem.getTotalPercentRet38()));
        pojo.setTotalWtAverage(StringSupport.getString(elem.getTotalWtAverage()));
        pojo.setRemarks(elem.getRemarks());
        pojo.setCategory(elem.getCategory());
        pojo.setTestMethod(elem.getTestMethod());
        pojo.setSoilclass(elem.getSoilclass());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setIdentification(elem.getIdentification());
        pojo.setUsedSieveSize(elem.getUsedSieveSize());
        pojo.setDimensionalRatio(elem.getDimensionalRatio());
        pojo.setSumNoParticles(elem.getSumNoParticles());
        pojo.setSumMassParticles(elem.getSumMassParticles());
        pojo.setSumTotalWtret(elem.getSumTotalWtret());
        pojo.setTotalPerret(elem.getTotalPerret());
        pojo.setPassfail(StringSupport.getString(elem.getPassfail()));
        pojo.setPercentret(elem.getPercentret());
        pojo.setPercentret38(elem.getPercentret38());
        pojo.setTotalWtret(elem.getTotalWtret());
        pojo.setFlatWtret(elem.getFlatWtret());
        pojo.setFlatPercent(elem.getFlatPercent());
        pojo.setElongWtret(elem.getElongWtret());
        pojo.setElongPercent(elem.getElongPercent());
        pojo.setNotfeWtret(elem.getNotfeWtret());
        pojo.setNotfePercent(elem.getNotfePercent());
        pojo.setFlatWtavgPercent(elem.getFlatWtavgPercent());
        pojo.setElongWtavgPercent(elem.getElongWtavgPercent());
        pojo.setFeWtavgPercent(elem.getFeWtavgPercent());
        pojo.setTotalPercentSieve(elem.getTotalPercentSieve());
        pojo.setTotalPercentWtavg(elem.getTotalPercentWtavg());
        return pojo;
    }
}
