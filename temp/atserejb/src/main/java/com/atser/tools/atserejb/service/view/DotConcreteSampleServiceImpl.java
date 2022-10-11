/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.DotConcreteSampleDao;
import com.atser.tools.atserejb.model.DotConcreteSample;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.document.write.jasper.template.JasperDesignGridLetterSimple;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.objects.pojo.jasper.qm.dotsummaryreport.DotConcreteSamplePojo;
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
public class DotConcreteSampleServiceImpl implements DotConcreteSampleService, IBaseEJBException {

    @Inject
    private DotConcreteSampleDao dao;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public List<DotConcreteSample> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<DotConcreteSample> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public DataTableWrapper<DotConcreteSample> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<DotConcreteSample> finalList = list(request);
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
        List<DotConcreteSamplePojo> ds = generatePrintLogData(request);
        String targetPath = docpathsegment + "SummaryReport_DotConcreteSample_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            JasperDesignGridLetterSimple jd = new JasperDesignGridLetterSimple(UUID.randomUUID().toString(), OrientationEnum.LANDSCAPE, 792, 612, 752, 20, extension, Boolean.TRUE);
            JasperDesign tpl = jd.buildTemplate("Test Results Summary Report", "Concrete Sample", DotConcreteSamplePojo.class, columns);
            targetPath = pdf.exportDocument(tpl, null, ds, targetPath, extension.getValue(), Boolean.FALSE);
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(DotConcreteSampleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<DotConcreteSamplePojo> generatePrintLogData(ManageITBodyRequest request) {
        List<DotConcreteSample> filterList = list(request);
        List<DotConcreteSamplePojo> rList = new ArrayList<>();
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

    private DotConcreteSamplePojo generatePojo(DotConcreteSample elem, GlobProject project, BufferedImage projectLogoImage) {
        DotConcreteSamplePojo response = null;
        if (elem == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        if (Objects.nonNull(project)) {
            //response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setProjectActive(elem.getProjectActive());
            response.setContractual(elem.getContractual());
            response.setTestClosed(elem.getTestClosed());
            response.setPeReview(elem.getPeReview());
            response.setActive(elem.getActive());
            response.setEquipList(elem.getEquipList());
            response.setStatus(elem.getStatus());
            response.setEstmQty(StringSupport.getString(elem.getEstmQty()));
            response.setQtyRep(StringSupport.getString(elem.getQtyRep()));
            response.setSubitemEstmQty(StringSupport.getString(elem.getSubitemEstmQty()));
            response.setTechId(StringSupport.getString(elem.getTechId()));
            response.setSampleNoSeq(StringSupport.getString(elem.getSampleNoSeq()));
            response.setNtpDate(elem.getNtpDate());
            response.setCompDate(elem.getCompDate());
            response.setSublot(elem.getSublot());
            response.setDesignStrength(elem.getDesignStrength());
            response.setLoggedBy(elem.getLoggedBy());
            response.setLatGps(elem.getLatGps());
            response.setLonGps(elem.getLonGps());
            response.setAltGps(elem.getAltGps());
            response.setUnit(elem.getUnit());
            response.setSubitemUnit(elem.getSubitemUnit());
            response.setCreateBy(elem.getCreateBy());
            response.setTicketNo(elem.getTicketNo());
            response.setMatSpec(elem.getMatSpec());
            response.setSubitemMatSpec(elem.getSubitemMatSpec());
            response.setCurRangeTemp(elem.getCurRangeTemp());
            response.setTruckNo(elem.getTruckNo());
            response.setWaterAdded(elem.getWaterAdded());
            response.setBatchSize(elem.getBatchSize());
            response.setCostAccNo(elem.getCostAccNo());
            response.setSampleTime(elem.getSampleTime());
            response.setTotalDischargeTime(elem.getTotalDischargeTime());
            response.setTestNoLink(elem.getTestNoLink());
            response.setProposedUse(elem.getProposedUse());
            response.setRmsNo(elem.getRmsNo());
            response.setBiditemNo(elem.getBiditemNo());
            response.setFedAid(elem.getFedAid());
            response.setpNumber(elem.getpNumber());
            response.setProducerLocation(elem.getProducerLocation());
            response.setTypeProject(elem.getTypeProject());
            response.setProducedBy(elem.getProducedBy());
            response.setCityTown(elem.getCityTown());
            response.setStation(elem.getStation());
            response.setSampleLocation(elem.getSampleLocation());
            response.setCmLocation(elem.getCmLocation());
            response.setpName(elem.getpName());
            response.setTraceNo(elem.getTraceNo());
            response.setResidentEng(elem.getResidentEng());
            response.setTestingTech(elem.getTestingTech());
            response.setDmeEng(elem.getDmeEng());
            response.setProjectCityTown(elem.getProjectCityTown());
            response.setAdditionalInfo(elem.getAdditionalInfo());
            response.setAddInfo(elem.getAddInfo());
            response.setContractor(elem.getContractor());
            response.setCuringMaxtemp(elem.getCuringMaxtemp());
            response.setLabname(elem.getLabname());
            response.setfName(elem.getfName());
            response.setSampleNo(elem.getSampleNo());
            response.setTestNo(elem.getTestNo());
            response.setLoggedDate(elem.getLoggedDate());
            response.setMixdesignno(elem.getMixdesignno());
            response.setFunction(elem.getFunction());
            response.setDistrict(elem.getDistrict());
            response.setCuringMintemp(elem.getCuringMintemp());
            response.setCuringMethod(elem.getCuringMethod());
            response.setSpecimenCovered(elem.getSpecimenCovered());
            response.setCreateDate(elem.getCreateDate());
            response.setArrivalTime(elem.getArrivalTime());
            response.setOffset(elem.getOffset());
            response.setLot(elem.getLot());
            response.setRandomSample(elem.getRandomSample());
            response.setRandomNo(elem.getRandomNo());
            response.setQtyUnit(elem.getQtyUnit());
            response.setSampledByTitle(elem.getSampledByTitle());
            response.setLoadno(elem.getLoadno());
            response.setLabprepOther(elem.getLabprepOther());
            response.setMixType(elem.getMixType());
            response.setSampleType(elem.getSampleType());
            response.setWeather(elem.getWeather());
            response.setMaterialLocation(elem.getMaterialLocation());
            response.setAirTemperature(elem.getAirTemperature());
            response.setAggSize(elem.getAggSize());
            response.setTotalCementitious(elem.getTotalCementitious());
            response.setBatchweight(elem.getBatchweight());
            response.setAdditionalAdmixtureF(elem.getAdditionalAdmixtureF());
            response.setBatchStartTime(elem.getBatchStartTime());
            response.setBatchEndTime(elem.getBatchEndTime());
            response.setSpecimenShape(elem.getSpecimenShape());
            response.setDischargeEndTime(elem.getDischargeEndTime());
            response.setSpecPrepMethod(elem.getSpecPrepMethod());
            response.setSamplePrepMethod(elem.getSamplePrepMethod());
            response.setSubbiditemDescript(elem.getSubbiditemDescript());
            response.setBiditemDescript(elem.getBiditemDescript());
            response.setProjectStatus(elem.getProjectStatus());
            response.setDateoftest(DateSupport.formatDate(elem.getDateoftest(), DateSupport.FORMAT_US));
            response.setCollectionDate(DateSupport.formatDate(elem.getCollectionDate(), DateSupport.FORMAT_US));
            response.setProjectLogo(projectLogoImage);
        }
        return response;
    }

}
