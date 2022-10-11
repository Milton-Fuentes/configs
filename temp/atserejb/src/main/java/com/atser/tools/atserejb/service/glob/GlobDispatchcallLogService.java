/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobDispatchcallLog;
import com.atser.tools.atserejb.model.QaTestImagestore;
import com.atser.tools.atserutil.objects.pojo.glob.GlobSheduleSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourceTO;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourcesDataTO;
import com.atser.tools.atserutil.objects.to.dispatch.DispatchRequestTO;
import com.atser.tools.atserutil.objects.to.dispatch.WorkOrderTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author droldan
 */
public interface GlobDispatchcallLogService {

    GlobDispatchcallLog findById(String id);

    DispatchRequestTO findDispatchRequestTOById(ManageITHeader header, String id);

    BigInteger save(ManageITHeader header, GlobDispatchcallLog elem);

    BigInteger save(GlobDispatchcallLog elem);

    void update(GlobDispatchcallLog elem);

    void delete(String id);

    void saveDispatchRequestTO(ManageITHeader header, DispatchRequestTO elem);

    void updateDispatchRequestTO(ManageITHeader header, DispatchRequestTO elem);

    void saveCalendarResourcesDataTO(ManageITHeader header, CalendarResourcesDataTO elem);

    void updateCalendarResourcesDataTO(ManageITHeader header, CalendarResourcesDataTO elem);

    List<GlobDispatchcallLog> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    /* Particular Querys */
    void updateDecisionFlag(GlobDispatchcallLog elem);

    void createWoWithNumbers(String callId);

    List<GlobDispatchcallLog> findByRequestOrigID(BigInteger id);

    List<GlobDispatchcallLog> findByProjectID(BigInteger id);

    GlobDispatchcallLog findByWOID(BigInteger id);

    List<WorkOrderTO> listTo(ManageITBodyRequest request);

    DataTableWrapper<WorkOrderTO> dataTableList(ManageITBodyRequest request);

    void notifyTechnicians(ManageITBodyRequest request, String server_domain, TemplateEngine engine);

    void discardNotification(ManageITBodyRequest request);

    String generateExternalWoReport(String reportId, String tplbasePath, String docpathsegment, String woToken, String docType, String clientId) throws IOException, Exception;

    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);

    String generateScheduleReport(String tplbasePath, String docpathsegment, ManageITHeader header, GlobSheduleSearchDefParam defParam);

    List<CalendarResourceTO> buildDispatchCalendarResources(ManageITHeader header, ManageITBodyRequest<Object> request);

    List<CalendarResourceTO> buildAllDispatchCalendarResources(ManageITHeader header, GlobSheduleSearchDefParam defParam);

    List<CalendarResourcesDataTO> buildDispatchCalendar(ManageITHeader header, ManageITBodyRequest<Object> request);

    List<CalendarResourcesDataTO> buildDispatchSchedule(ManageITHeader header, GlobSheduleSearchDefParam defParam);

    void updateWoFromDispatchRequestTO(ManageITHeader header, DispatchRequestTO elem);

    void cancelCallLog(ManageITHeader header, String callId, String value);

    void moveWOSchedule(ManageITHeader header, String id, String startTime, BigDecimal hours, BigInteger ownerId, String event);

    void cancelWo(ManageITHeader header, String callId, String value, String cancelReason);

    String generateCalendarReport(String tplbasePath, String tplpath, String docpathsegment, ManageITBodyRequest<Object> request, ManageITHeader header);

    void woCompleted(ManageITHeader header, String callId, String value);
    
    String generateGlobalBarcodes(String tplbasePath, String docpathsegment, ManageITHeader header, ManageITBodyRequest<Object> body);

    String generateScheduleBarcodeReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request, String reqId, String setNo, String specNo);

    BigDecimal copyRequest(ManageITHeader header, String id);

    List<QaTestImagestore> getImageListByWoToken(String wotoken);
    
    List<DataSelectWrapper> getDispatchSelectList(BigInteger clientId);
}
