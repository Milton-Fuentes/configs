package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotCamiscT27Dao;
import com.atser.tools.atserejb.model.DotCamiscT27;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotCamiscT27Pojo;
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
public class DotCamiscT27ServiceImpl implements DotCamiscT27Service, IBaseEJBException {

    @Inject
    private DotCamiscT27Dao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotCamiscT27> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotCamiscT27> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotCamiscT27> finalList = list(request);
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
    public DataTableWrapper<DotCamiscT27> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotCamiscT27> finalList = list(request);
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
        List<DotCamiscT27Pojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotCamiscT27_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "T  27/C136 Sieve Analysis of Coarse Aggregates (Misc)", DotCamiscT27Pojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotCamiscT27ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotCamiscT27Pojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotCamiscT27> filterList = list(request);
        List<DotCamiscT27Pojo> rList = new ArrayList<>();
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

    private DotCamiscT27Pojo generatePojo(DotCamiscT27 elem, GlobProject project, BufferedImage projectLogoImage) {
        DotCamiscT27Pojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotCamiscT27Pojo populatePojo(DotCamiscT27 elem) {
        DotCamiscT27Pojo pojo = new DotCamiscT27Pojo();
        pojo.setPercentpass(elem.getPercentpass());
        pojo.setCombpct(elem.getCombpct());
        pojo.setProjrequire(elem.getProjrequire());
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
        pojo.setPercentret(StringSupport.getString(elem.getPercentret()));
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
        pojo.setSetName(elem.getSetName());
        pojo.setInitdrywt(elem.getInitdrywt());
        pojo.setTarewtt1(elem.getTarewtt1());
        pojo.setWtafterwash(elem.getWtafterwash());
        pojo.setTarewtt2(elem.getTarewtt2());
        pojo.setWtpriorwash(elem.getWtpriorwash());
        pojo.setWtafterwash200(elem.getWtafterwash200());
        pojo.setWashloss(elem.getWashloss());
        pojo.setTotalpercentpass(elem.getTotalpercentpass());
        pojo.setPan(elem.getPan());
        pojo.setTotal(elem.getTotal());
        pojo.setFinewt(elem.getFinewt());
        pojo.setFinemode(elem.getFinemode());
        pojo.setIscomb(StringSupport.getString(elem.getIscomb()));
        pojo.setUnitengmet(elem.getUnitengmet());
        pojo.setRemarks(elem.getRemarks());
        pojo.setSieveshaker(elem.getSieveshaker());
        pojo.setBalance(elem.getBalance());
        pojo.setOven(elem.getOven());
        pojo.setFarSummary(elem.getFarSummary());
        pojo.setCategory(elem.getCategory());
        pojo.setSoakTime(elem.getSoakTime());
        pojo.setTestMethod(elem.getTestMethod());
        pojo.setSoilclass(elem.getSoilclass());
        pojo.setNresults(elem.getNresults());
        pojo.setPercentLoss(elem.getPercentLoss());
        pojo.setQuantity(StringSupport.getString(elem.getQuantity()));
        pojo.setCoarseFactor(elem.getCoarseFactor());
        pojo.setFineFactor(elem.getFineFactor());
        pojo.setSplitWt(elem.getSplitWt());
        pojo.setPanCa(elem.getPanCa());
        pojo.setTotalCa(elem.getTotalCa());
        pojo.setAmountLossSieve(elem.getAmountLossSieve());
        pojo.setCorrOrigMass(elem.getCorrOrigMass());
        pojo.setPercentLossSpec(elem.getPercentLossSpec());
        pojo.setPercentLossResult(elem.getPercentLossResult());
        pojo.setPercentLossSieve(elem.getPercentLossSieve());
        pojo.setPanPr(elem.getPanPr());
        pojo.setSerialNo(elem.getSerialNo());
        pojo.setFinemodeProjrequire(elem.getFinemodeProjrequire());
        pojo.setFinemodeResult(elem.getFinemodeResult());
        pojo.setRunNo(StringSupport.getString(elem.getRunNo()));
        pojo.setSieveName(elem.getSieveName());
        pojo.setWtret(elem.getWtret());
        pojo.setAccumwtret(elem.getAccumwtret());
        return pojo;
    }
}
