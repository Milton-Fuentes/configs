/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.BpmProcessInstance;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.bpm.BpmProcessInstanceDao;
import com.atser.tools.atserejb.model.BpmProcess;
import com.atser.tools.atserejb.model.BpmTaskMatrix;
import com.atser.tools.atserejb.model.Bpmcorrespondencebo;
import com.atser.tools.atserejb.model.Bpmrfibo;
import com.atser.tools.atserejb.model.Bpmsubmittalbo;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.thymeleaf.TemplateEngine;

@Stateless
public class BpmProcessInstanceServiceImpl implements BpmProcessInstanceService, IBaseEJBException {

    @Inject
    private BpmProcessInstanceDao dao;

    @Inject
    BpmProcessService processService;

    @Inject
    BpmProcessInstanceService processInstanceService;

    @Inject
    BpmTaskMatrixService taskMatrixService;

    @Inject
    BpmTaskService taskService;

    @Inject
    BpmTaskInstanceService taskInstanceService;

    @Inject
    BpmRFIService rfiService;

    @Inject
    BpmSubmittalService submittalService;

    @Inject
    BpmCorrespondenceService correspondenceService;

    @Override
    public BpmProcessInstance findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public BpmProcessInstance findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(BpmProcessInstance elem) {
        return save(null, elem);
    }

    @Override
    public BigDecimal save(ManageITHeader header, BpmProcessInstance elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(BpmProcessInstance elem) {
        update(null, elem);
    }

    @Override
    public void update(ManageITHeader header, BpmProcessInstance elem) {
        if (elem != null) {
            BpmProcessInstance model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(id);
    }

    @Override
    public List<BpmProcessInstance> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<BpmProcessInstance> dataGridList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataTableWrapper<BpmProcessInstance> dataTableList(ManageITBodyRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getVersion(Integer number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getRevisions(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private BpmProcessInstance populate(BpmProcessInstance model, BpmProcessInstance elem) {
//        model.setFirstName(elem.getFirstName());
//        model.setLastName(elem.getLastName());
//        model.setEmail(elem.getEmail());
//        model.setContactNo(elem.getContactNo());
//        model.setLastMod(elem.getLastMod());
//        model.setLastModBy(elem.getLastModBy());
//        model.setLastModByIp(elem.getLastModByIp());
        return model;
    }

    @Override
    public void startProcess(ManageITHeader header, TemplateEngine engine, String processCode, BigDecimal modelId, BigDecimal projectId, BigDecimal clientId) {
        // Get process.
        BpmProcess process = processService.findByCode(processCode);

        // Create process instance.
        BigDecimal processInstanceId = createProcessInstance(process, projectId, clientId, modelId);

        // Get first process task.
        BpmTaskMatrix taskMatrix = taskMatrixService.getFirstTaskByProcessId(process.getId());

        // Create task instance.
        taskInstanceService.createTaskInstance(header, engine, taskMatrix.getTrgTaskId(), processInstanceId, modelId);
    }

    @Override
    public BigDecimal createProcessInstance(BpmProcess process, BigDecimal projectId, BigDecimal clientId, BigDecimal modelId) {
        BpmProcessInstance processInstance = new BpmProcessInstance();
        processInstance.setProcessId(process);
        processInstance.setProjectId(projectId);
        processInstance.setClientId(clientId);
        processInstance.setRefId(modelId);
        processInstance.setState("READY");
        return processInstanceService.save(processInstance);
    }

    @Override
    public void closeProcessInstance(BigDecimal id) {
        BpmProcessInstance processInstance = processInstanceService.findById(id);
        processInstance.setState("COMPLETED");
        processInstanceService.update(processInstance);
    }
    
    @Override
    public Map<String, BigDecimal> getTotalOverdue(BigDecimal clientId, BigDecimal projectId, String processCode) {
        Map<String, BigDecimal> result = new HashMap<>();
        result.put("1 to 3 Days", dao.getTotalOverdue(clientId, projectId, 1, 3, processCode));
        result.put("4 to 7 Days", dao.getTotalOverdue(clientId, projectId, 4, 7, processCode));
        result.put("> 7 Days", dao.getTotalOverdue(clientId, projectId, 7, null, processCode));
        return result;
    }
    
    @Override
    public Map<String, Long> getDaysByProcess(ManageITBodyRequest request) {
        // Validate and Get needed parameter [processCode].
        if (!request.getParams().isContainsAllKeys(new String[]{"pc"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String processCode = request.getParams().get("pc").toString();

        // Init result.
        Map<String, Long> daysByProcess = new HashMap<String, Long>();

       // Load process list.
        List<BpmProcessInstance> list = list(request);
        
        // Get process number.
        String prcNumber = "";
        for (BpmProcessInstance item : list) {
            if (null != processCode) switch (processCode) {
                case "BPM_RFI":{
                    Bpmrfibo model = rfiService.findById(item.getRefId().toString());
                    prcNumber = model.getRfinumber();
                        break;
                    }
                case "BPM_SUBMITTAL":{
                    Bpmsubmittalbo model = submittalService.findById(item.getRefId().toString());
                    prcNumber = model.getSubnumber();
                        break;
                    }
                case "BPM_CORRESPONDENCE":{
                    Bpmcorrespondencebo model = correspondenceService.findById(item.getRefId().toString());
                    prcNumber = model.getCornumber();
                        break;
                    }
                default:
                    break;
            }
            
            // Get total days
            Date endDate;
            if("COMPLETED".equals(item.getState())) {
                endDate = item.getLastMod();
            } else {
                 endDate = new Date();
            }
            Long days = DateSupport.daysBeetwenDates(item.getCreated(), endDate);
            
            // Set information.
            daysByProcess.put(prcNumber, days);
        }
        return daysByProcess;
    }
    
    /***
     * Average Days By Process.
     * 
     * Return the average days by each type of already completed process (RFI, Submittal, Correspondence). 
     * @param request
     * @return 
     */
    @Override
    public Map<String, Double> getDaysAvgByProcess(ManageITBodyRequest request) {
        request.filter("state", "COMPLETED");
        List<BpmProcessInstance> list = list(request);
        
        Map<String, Double> avgDaysByProcess = new HashMap<>();
        Double rfiDays = 0.0;
        Integer rfiCount = 0;
        Double subDays = 0.0;
        Integer subCount = 0;
        Double corDays = 0.0;
        Integer corCount = 0;
        for (BpmProcessInstance item : list) {
            Date endDate = item.getLastMod();
            switch (item.getProcessId().getCode()) {
                case "BPM_RFI":
                   rfiCount++;
                   rfiDays += DateSupport.daysBeetwenDates(item.getCreated(), endDate);
                    break;
                case "BPM_SUBMITTAL":
                   subCount++;
                   subDays += DateSupport.daysBeetwenDates(item.getCreated(), endDate);
                   break;
                case "BPM_CORRESPONDENCE":
                    corCount++;
                    corDays += DateSupport.daysBeetwenDates(item.getCreated(), endDate);
                    break;
                default:
                    break;
            }
        }
        avgDaysByProcess.put("RFI", rfiCount != 0 ? (new BigDecimal(rfiDays/rfiCount).setScale(2, RoundingMode.HALF_UP).doubleValue()) : 0);
        avgDaysByProcess.put("Submittal", subCount != 0 ? (new BigDecimal(subDays/subCount).setScale(2, RoundingMode.HALF_UP).doubleValue()) : 0);
        avgDaysByProcess.put("Correspondence", corCount!= 0 ? (new BigDecimal(Double.toString(corDays/corCount)).setScale(2, RoundingMode.HALF_UP).doubleValue()) : 0);
        return avgDaysByProcess;
    }

//
//    public List<ChartColumnSeriesTO> generateChartDataOverdueProcess(BigDecimal clientId, String processCode) {
//        List<ChartColumnSeriesTO> chartSerieList = new ArrayList<>();
//
//        BigDecimal totalOverdueProcess = dao.getTotalOverdueProcess(clientId, 1, 3, processCode);
//        ChartColumnSeriesTO serie = new ChartColumnSeriesTO("1 to 3 Days", new ChartColumnPointTO("1 to 3 Days", String.valueOf(totalOverdueProcess)));
//        chartSerieList.add(serie);
//
//        totalOverdueProcess = dao.getTotalOverdueProcess(clientId, 4, 7, processCode);
//        serie = new ChartColumnSeriesTO("4 to 7 Days", new ChartColumnPointTO("4 to 7 Days", String.valueOf(totalOverdueProcess)));
//        chartSerieList.add(serie);
//
//        totalOverdueProcess = dao.getTotalOverdueProcess(clientId, 7, 10, processCode);
//        serie = new ChartColumnSeriesTO("7 to 10 Days", new ChartColumnPointTO("7 to 10 Days", String.valueOf(totalOverdueProcess)));
//        chartSerieList.add(serie);
//
//        return chartSerieList;
//    }

  
    
}
