package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.DotEmuSampleDao;
import com.atser.tools.atserejb.model.DotEmuSample;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotEmuSamplePojo;
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
public class DotEmuSampleServiceImpl implements DotEmuSampleService, IBaseEJBException {

    @Inject
    private DotEmuSampleDao dao;
    @Inject
    private GlobProjectService projectService;
    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotEmuSample> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotEmuSample> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotEmuSample> finalList = list(request);
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
    public DataTableWrapper<DotEmuSample> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotEmuSample> finalList = list(request);
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
        List<DotEmuSamplePojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotEmuSample_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "Asphalt Emulsion Sample", DotEmuSamplePojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;
        } catch (Exception ex) {
            Logger.getLogger(DotEmuSampleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotEmuSamplePojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotEmuSample> filterList = list(request);
        List<DotEmuSamplePojo> rList = new ArrayList<>();
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

    private DotEmuSamplePojo generatePojo(DotEmuSample elem, GlobProject project, BufferedImage projectLogoImage) {
        DotEmuSamplePojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            response = populatePojo(elem);
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

    public DotEmuSamplePojo populatePojo(DotEmuSample elem) {
        DotEmuSamplePojo pojo = new DotEmuSamplePojo();
        pojo.setSampledByTitle(elem.getSampledByTitle());
        pojo.setMixType(elem.getMixType());
        pojo.setSampleType(elem.getSampleType());
        pojo.setSampleNoSeq(StringSupport.getString(elem.getSampleNoSeq()));
        pojo.setWeather(elem.getWeather());
        pojo.setMaterialLocation(elem.getMaterialLocation());
        pojo.setCostAccNo(elem.getCostAccNo());
        pojo.setFedAid(elem.getFedAid());
        pojo.setpName(elem.getpName());
        pojo.setpNumber(elem.getpNumber());
        pojo.setProjectActive(StringSupport.getString(elem.getProjectActive()));
        pojo.setProjectStatus(elem.getProjectStatus());
        pojo.setContractor(elem.getContractor());
        pojo.setTypeProject(elem.getTypeProject());
        pojo.setContractual(StringSupport.getString(elem.getContractual()));
        pojo.setDistrict(elem.getDistrict());
        pojo.setProjectCityTown(elem.getProjectCityTown());
        pojo.setNtpDate(elem.getNtpDate());
        pojo.setCompDate(elem.getCompDate());
        pojo.setResidentEng(elem.getResidentEng());
        pojo.setDmeEng(elem.getDmeEng());
        pojo.setLabname(elem.getLabname());
        pojo.setfName(elem.getfName());
        pojo.setQtyRep(StringSupport.getString(elem.getQtyRep()));
        pojo.setSampleNo(elem.getSampleNo());
        pojo.setTestNo(elem.getTestNo());
        pojo.setLoggedBy(elem.getLoggedBy());
        pojo.setLoggedDate(elem.getLoggedDate());
        pojo.setSamplenoLink(elem.getSamplenoLink());
        pojo.setTestingTech(elem.getTestingTech());
        pojo.setProposedUse(elem.getProposedUse());
        pojo.setAddInfo(elem.getAddInfo());
        pojo.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
        pojo.setFunction(elem.getFunction());
        pojo.setActive(StringSupport.getString(elem.getActive()));
        pojo.setLatGps(elem.getLatGps());
        pojo.setLonGps(elem.getLonGps());
        pojo.setAltGps(elem.getAltGps());
        pojo.setEmulsionType(elem.getEmulsionType());
        pojo.setCmLocation(elem.getCmLocation());
        pojo.setTraceNo(elem.getTraceNo());
        pojo.setWbsNo(elem.getWbsNo());
        pojo.setWbsDescript(elem.getWbsDescript());
        pojo.setBiditemNo(elem.getBiditemNo());
        pojo.setBiditemDescript(elem.getBiditemDescript());
        pojo.setSubbiditemDescript(elem.getSubbiditemDescript());
        pojo.setSamplePrepMethod(elem.getSamplePrepMethod());
        pojo.setSpecPrepMethod(elem.getSpecPrepMethod());
        pojo.setEstmQty(elem.getEstmQty());
        pojo.setUnit(elem.getUnit());
        pojo.setRmsNo(elem.getRmsNo());
        pojo.setMatSpec(elem.getMatSpec());
        pojo.setSubitemEstmQty(StringSupport.getString(elem.getSubitemEstmQty()));
        pojo.setSubitemUnit(elem.getSubitemUnit());
        pojo.setSubitemMatSpec(elem.getSubitemMatSpec());
        pojo.setEquipList(StringSupport.getString(elem.getEquipList()));
        pojo.setStatus(StringSupport.getString(elem.getStatus()));
        pojo.setPeReview(StringSupport.getString(elem.getPeReview()));
        pojo.setTestClosed(StringSupport.getString(elem.getTestClosed()));
        pojo.setCreateBy(elem.getCreateBy());
        pojo.setCreateDate(elem.getCreateDate());
        pojo.setSampleCatgId(elem.getSampleCatgId());
        pojo.setCollectionDate(DateSupport.formatDate(elem.getCollectionDate(), DateSupport.FORMAT_US));
        pojo.setArrivalTime(elem.getArrivalTime());
        pojo.setStation(elem.getStation());
        pojo.setOffset(elem.getOffset());
        pojo.setLot(elem.getLot());
        pojo.setSublot(elem.getSublot());
        pojo.setCityTown(elem.getCityTown());
        pojo.setRandomSample(elem.getRandomSample());
        pojo.setRandomNo(elem.getRandomNo());
        pojo.setProducedBy(elem.getProducedBy());
        pojo.setProducerLocation(elem.getProducerLocation());
        pojo.setBinderSupplier(elem.getBinderSupplier());
        pojo.setBinderLocation(elem.getBinderLocation());
        pojo.setBinderSupplierLocation(elem.getBinderSupplierLocation());
        pojo.setAsphaltcement(elem.getAsphaltcement());
        pojo.setAdditive(elem.getAdditive());
        pojo.setAddInfo1(elem.getAddInfo1());
        pojo.setSampleDate(DateSupport.formatDate(elem.getSampleDate(), DateSupport.FORMAT_US));
        pojo.setHasRndNo(elem.getHasRndNo());
        pojo.setRndNo(elem.getRndNo());
        pojo.setAddInfo2(elem.getAddInfo2());
        pojo.setAddInfo3(elem.getAddInfo3());
        pojo.setAdditionalInfo(elem.getAdditionalInfo());
        pojo.setQtyUnit(elem.getQtyUnit());
        return pojo;
    }
}
