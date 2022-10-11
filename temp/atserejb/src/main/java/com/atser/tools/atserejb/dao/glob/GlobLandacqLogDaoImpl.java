/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.GlobLandacqLog;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.landacq.GlobLandacqLogBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobLandacqLogSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobLandacqLogDaoImpl extends GenericDao<BigDecimal, GlobLandacqLog> implements GlobLandacqLogDao, ISearchDao<GlobLandacqLogSearchDefParam> {

    @Inject
    private GlobProjectDao globProjectDao;

    @Override
    public BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM GLOB_LANDACQ_LOG WHERE client_id=:clientId AND spattern = :spattern";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("spattern", spattern);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? NumberSupport.getBigInteger(result) : BigInteger.ONE;
        } catch (NoResultException ex) {
            return BigInteger.ONE;
        }
    }

    @Override
    public String getNextProjectSequenceNo(BigInteger clientId, BigInteger projectId) {
        String query = "SELECT NVL(MAX(to_number(llpcn)),0) + 1 as icn FROM GLOB_LANDACQ_LOG WHERE client_id=:clientId AND project_id=:projectId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("projectId", projectId);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? StringSupport.getString(result) : "1";
        } catch (NoResultException ex) {
            return "1";
        }
    }

    ////////////////////////////////////////////////////////////////////////////    
    @Override
    public DataTableWrapper<GlobLandacqLogBO> getFrontEndSearch(GlobLandacqLogSearchDefParam filters) {
        // TailLine Definition
        String tailLine = buildFilters(filters);
        // OrderLine Definition
        String orderLine = buildSort(filters, 1);
        String orderLine2 = buildSort(filters, 2);
        String countQuery = buildCountQuery(filters, tailLine);
        String query = buildQuery(filters, tailLine, orderLine, orderLine2);
        try {
            Long count = getTotal(countQuery);
            List<Object[]> objects = getEntityManager().createNativeQuery(query).getResultList();
            List<GlobLandacqLogBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<GlobLandacqLogBO> populateBO(List<Object[]> objects) {
        List<GlobLandacqLogBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            GlobLandacqLogBO p = new GlobLandacqLogBO();
            p.setId(NumberSupport.getBigDecimal(it[0]));
            p.setClientId(NumberSupport.getBigInteger(it[1]));
            p.setProjectId(NumberSupport.getBigInteger(it[2]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[3]));
            p.setProjectCode(StringSupport.emptyOnNull(it[4]));
            p.setSpattern(StringSupport.emptyOnNull(it[5]));
            p.setSno(NumberSupport.getBigInteger(it[6]));
            p.setLlpcn(StringSupport.emptyOnNull(it[7]));
            p.setLandacqNo(StringSupport.emptyOnNull(it[8]));
            p.setRowacqNo(StringSupport.emptyOnNull(it[9]));
            p.setEnvIssues(StringSupport.getActiveAsCharacter(StringSupport.emptyOnNull(it[10])));
            p.setDateAvailable(it[11] != null ? DateSupport.formatUS((Date) it[11]) : null);
            p.setOwners(StringSupport.emptyOnNull(it[12]));
            p.setGisLocation(StringSupport.emptyOnNull(it[13]));
            p.setSiteAddress(StringSupport.emptyOnNull(it[14]));
            p.setLandType(NumberSupport.getBigInteger(it[15]));
            p.setLandTypeName(StringSupport.emptyOnNull(it[16]));
            p.setMappg(StringSupport.emptyOnNull(it[17]));
            p.setCounty(NumberSupport.getBigInteger(it[18]));
            p.setCountyName(StringSupport.emptyOnNull(it[19]));
            p.setStationing(StringSupport.emptyOnNull(it[20]));
            p.setRowCertificationNo(StringSupport.emptyOnNull(it[21]));
            p.setTypeOfContract(StringSupport.emptyOnNull(it[22]));
            p.setContactPhoneNumber(StringSupport.emptyOnNull(it[23]));
            p.setRowCertificationDate(StringSupport.emptyOnNull(it[24]));
            p.setAcquisitionType(StringSupport.emptyOnNull(it[25]));
            p.setImprovements(StringSupport.emptyOnNull(it[26]));
            p.setLandAvailable(StringSupport.getActiveAsCharacter(StringSupport.emptyOnNull(it[27])));
            p.setPropertyStatus(NumberSupport.getBigInteger(it[28]));
            p.setPropertyStatusName(StringSupport.emptyOnNull(it[29]));
            p.setOccupiedDate(it[30] != null ? DateSupport.formatUS((Date) it[30]) : null);
            p.setTypeOfUtilities(StringSupport.emptyOnNull(it[31]));
            p.setRequestForUtility(StringSupport.getActiveAsCharacter(StringSupport.emptyOnNull(it[32])));
            p.setAccessToProperty(StringSupport.emptyOnNull(it[33]));
            p.setPropertyOwnerConversations(StringSupport.emptyOnNull(it[34]));
            p.setUtDrawingNo(NumberSupport.getBigInteger(it[35]));
            p.setParcelImpact(StringSupport.emptyOnNull(it[36]));
            p.setRemarks(StringSupport.emptyOnNull(it[37]));
            p.setStatusId(NumberSupport.getBigInteger(it[38]));
            p.setFolderId(NumberSupport.getBigInteger(it[39]));
            p.setCreated(it[40] != null ? DateSupport.formatUS((Date) it[40]) : null);
            p.setCreatedBy(StringSupport.emptyOnNull(it[41]));
            p.setVersion(StringSupport.emptyOnNull(it[42]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    @Override
    public String buildCountQuery(GlobLandacqLogSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM GLOB_LANDACQ_LOG bpc "
                + "INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvllandtype ON (bpc.land_type = cvllandtype.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlcounty ON (bpc.county = cvlcounty.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlpropertystatus ON (bpc.property_status = cvlpropertystatus.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(GlobLandacqLogSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        String fieldLine = " bpc.id, bpc.client_id, bpc.project_id, gp.p_number AS project_number, gp.project_code, bpc.spattern, bpc.sno, "
                + "bpc.llpcn, bpc.landacq_no, bpc.rowacq_no, bpc.env_issues, bpc.date_available, bpc.owners, bpc.gis_location, bpc.site_address, "
                + "bpc.land_type, cvllandtype.value as land_type_name, bpc.mappg, bpc.county, cvlcounty.value as county_name, bpc.stationing, "
                + "bpc.row_certification_no, bpc.type_of_contract, bpc.contact_phone_number, bpc.row_certification_date, bpc.acquisition_type, "
                + "bpc.improvements, bpc.land_available, bpc.property_status, cvlpropertystatus.value as property_status_name, bpc.occupied_date, "
                + "bpc.type_of_utilities, bpc.request_for_utility, bpc.access_to_property, bpc.property_owner_conversations, bpc.ut_drawing_no, "
                + "bpc.parcel_impact, bpc.remarks, bpc.status_id, bpc.folder_id, bpc.created, bpc.created_by, bpc.version ";
        String fromLine = " FROM GLOB_LANDACQ_LOG bpc "
                + "INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvllandtype ON (bpc.land_type = cvllandtype.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlcounty ON (bpc.county = cvlcounty.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlpropertystatus ON (bpc.property_status = cvlpropertystatus.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        return wrapToServerSide(query, orderLine2, filters);
    }

    @Override
    public String buildFilters(GlobLandacqLogSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.projectId) && !filters.projectId.equals("-1")) {
            tailLineBuilder.append(" AND (bpc.project_id = ").append(filters.projectId).append(") ");
        } else {
            if (filters.multiproject) {
                String filter_by_profile = globProjectDao.filterByProfile(" bpc.project_id", filters.isAdmin, filters.useGlobalProfiles, filters.clientId, filters.userId);
                if (!filter_by_profile.isEmpty()) {
                    tailLineBuilder.append(" AND ( ").append(filter_by_profile).append(" ) ");
                }
            }
        }

        // Filter Created
        if (filters.isAllDateActive != null && !filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            tailLineBuilder.append("AND bpc.created between to_date('").append(filters.startDate).append("','mm-dd-yyyy') and to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
        }

        // Filter Land Type
        if (StringSupport.isNotNullAndNotEmpty(filters.landType) && !filters.landType.equals("-1")) {
            tailLineBuilder.append("AND (bpc.land_type = ").append(filters.landType).append(") ");
        }

        // Filter County
        if (StringSupport.isNotNullAndNotEmpty(filters.county) && !filters.county.equals("-1")) {
            tailLineBuilder.append("AND (bpc.county = ").append(filters.county).append(") ");
        }

        // Filter Property Status
        if (StringSupport.isNotNullAndNotEmpty(filters.propertyStatus) && !filters.propertyStatus.equals("-1")) {
            tailLineBuilder.append("AND (bpc.property_status = ").append(filters.propertyStatus).append(") ");
        }

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" AND ( ");
            // Filter Land ACQ No
            if (filters.dtMapSearch.containsKey("landacqNo")) {
                tailLineBuilder.append(" (bpc.landacq_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("landacqNo"))).append("%') ");
            }

            // Filter Row ACQ No
            if (filters.dtMapSearch.containsKey("rowacqNo")) {
                tailLineBuilder.append("or (bpc.rowacq_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("rowacqNo"))).append("%') ");
            }

            // Filter Env. Issues
            if (filters.dtMapSearch.containsKey("envIssues")) {
                tailLineBuilder.append(" or (bpc.env_issues like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("envIssues"))).append("%') ");
            }

            // Filter owners
            if (filters.dtMapSearch.containsKey("owners")) {
                tailLineBuilder.append(" or (bpc.owners like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("owners"))).append("%') ");
            }

            // Filter Gis Location
            if (filters.dtMapSearch.containsKey("gisLocation")) {
                tailLineBuilder.append(" or (bpc.gis_location like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("gisLocation"))).append("%') ");
            }

            // Filter Site Address
            if (filters.dtMapSearch.containsKey("siteAddress")) {
                tailLineBuilder.append(" or (bpc.site_address like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("siteAddress"))).append("%') ");
            }

            // Filter mappg
            if (filters.dtMapSearch.containsKey("mappg")) {
                tailLineBuilder.append(" or (bpc.mappg like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("mappg"))).append("%') ");
            }

            // Filter stationing
            if (filters.dtMapSearch.containsKey("stationing")) {
                tailLineBuilder.append(" or (bpc.stationing like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("stationing"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(GlobLandacqLogSearchDefParam filters, Integer level) {
        StringBuilder orderBuilder = new StringBuilder();
        if (StringSupport.isNullOrEmpty(filters.sortBy)) {
            if (level == 1) {
                orderBuilder.append(" order by bpc.created ");
            } else {
                orderBuilder.append(" order by created ");
            }
            return orderBuilder.toString();
        }
        switch (filters.sortBy) {
            case "landacqNo": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.landacq_no ");
                } else {
                    orderBuilder.append(" order by landacq_no ");
                }
                break;
            }
            case "projectNumber": {
                if (level == 1) {
                    orderBuilder.append(" order by gp.p_number ");
                } else {
                    orderBuilder.append(" order by project_number ");
                }
                break;
            }
            case "rowacqNo": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.rowacq_no ");
                } else {
                    orderBuilder.append(" order by rowacq_no ");
                }
                break;
            }

            case "envIssues": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.env_issues ");
                } else {
                    orderBuilder.append(" order by env_issues ");
                }
                break;
            }

            case "dateAvailable": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.date_available ");
                } else {
                    orderBuilder.append(" order by date_available ");
                }
                break;
            }

            case "owners": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.owners ");
                } else {
                    orderBuilder.append(" order by owners ");
                }
                break;
            }

            case "gisLocation": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.gis_location ");
                } else {
                    orderBuilder.append(" order by gis_location ");
                }
                break;
            }
            case "siteAddress": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.site_address ");
                } else {
                    orderBuilder.append(" order by site_address ");
                }
                break;
            }
            case "landTypeName": {
                if (level == 1) {
                    orderBuilder.append(" order by cvllandtype.value ");
                } else {
                    orderBuilder.append(" order by land_type_name ");
                }
                break;
            }
            case "mappg": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.mappg ");
                } else {
                    orderBuilder.append(" order by mappg ");
                }
                break;
            }
            case "countyName": {
                if (level == 1) {
                    orderBuilder.append(" order by cvlcounty.value ");
                } else {
                    orderBuilder.append(" order by county_name ");
                }
                break;
            }
            case "stationing": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.stationing ");
                } else {
                    orderBuilder.append(" order by stationing ");
                }
                break;
            }
            case "created": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.created ");
                } else {
                    orderBuilder.append(" order by created ");
                }
                break;
            }
            default: {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.created ");
                } else {
                    orderBuilder.append(" order by created ");
                }
                break;
            }
        }
        orderBuilder.append(filters.sortDir);
        return orderBuilder.toString();
    }

}
