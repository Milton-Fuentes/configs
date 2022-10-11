/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.GlobPermsModelDoc;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.permissionmodel.GlobPermsModelDocBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobPermsModelDocSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobPermsModelDocDaoImpl extends GenericDao<BigDecimal, GlobPermsModelDoc> implements GlobPermsModelDocDao, ISearchDao<GlobPermsModelDocSearchDefParam> {

    @Override
    public void deactiveMain(BigInteger clientId) {
        if (clientId != null) {
            String query = "UPDATE GLOB_PERMS_MODEL_DOC SET main='N' WHERE CLIENT_ID=:clientId AND main = 'Y' AND DELETED = 'N'";
            Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId);
            q.executeUpdate();
        }
    }

    @Override
    public BigInteger getNextGlobalSequenceNo(BigInteger clientId) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM GLOB_PERMS_MODEL_DOC WHERE CLIENT_ID=:clientId AND deleted = 'N'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? NumberSupport.getBigInteger(result) : BigInteger.ONE;
        } catch (NoResultException ex) {
            return BigInteger.ONE;
        }

    }

    @Override
    public DataTableWrapper<GlobPermsModelDocBO> getFrontEndSearch(GlobPermsModelDocSearchDefParam filters) {
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
            List<GlobPermsModelDocBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<GlobPermsModelDocBO> populateBO(List<Object[]> objects) {
        List<GlobPermsModelDocBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            GlobPermsModelDocBO p = new GlobPermsModelDocBO();
            p.setId(NumberSupport.getBigDecimal(it[0]));
            p.setClientId(NumberSupport.getBigInteger(it[1]));
            p.setSno(NumberSupport.getBigInteger(it[2]));
            p.setVersionNo(StringSupport.emptyOnNull(it[3]));
            p.setDescription(StringSupport.emptyOnNull(it[4]));
            p.setAuthorizedBy(StringSupport.emptyOnNull(it[5]));
            p.setAuthorizedDate(it[6] != null ? DateSupport.formatUS((Date) it[6]) : null);
            p.setMain(StringSupport.getActiveAsCharacter(StringSupport.getString(it[7])));
            p.setTotalofDoc(NumberSupport.getBigInteger(it[8]));
            p.setFolderId(NumberSupport.getBigInteger(it[9]));
            p.setCreated(it[10] != null ? DateSupport.formatUS((Date) it[10]) : null);
            p.setCreatedBy(StringSupport.emptyOnNull(it[11]));
            p.setVersion(StringSupport.emptyOnNull(it[12]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    @Override
    public String buildCountQuery(GlobPermsModelDocSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM GLOB_PERMS_MODEL_DOC gpm ";
        String whereLine = " WHERE  ";
        whereLine += (!filters.showInactive) ? " gpm.active='N' " : " gpm.active='Y' ";
        whereLine += " AND gpm.deleted = 'N' AND gpm.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(GlobPermsModelDocSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
         String fieldLine = " gpm.id, gpm.client_id, gpm.sno, gpm.version_no, gpm.description, gpm.authorized_by, gpm.authorized_date, gpm.main, (SELECT count(id) FROM GLOB_FILE gfile WHERE gfile.folder_id = gpm.folder_id AND gfile.active = 'Y') as totalofdoc, gpm.folder_id, gpm.created, gpm.created_by, gpm.version ";
        String fromLine = " FROM GLOB_PERMS_MODEL_DOC gpm ";
        String whereLine = " WHERE  ";
        whereLine += (!filters.showInactive) ? " gpm.active='N' " : " gpm.active='Y' ";
        whereLine += " AND gpm.deleted = 'N' AND gpm.client_id = " + filters.clientId + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        return wrapToServerSide(query, orderLine2, filters);
    }

    @Override
    public String buildFilters(GlobPermsModelDocSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filter Created
        if (filters.isAllDateActive != null && !filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            tailLineBuilder.append("AND gpm.created between to_date('").append(filters.startDate).append("','mm-dd-yyyy') AND to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
        }

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" AND ( ");
            // Filter Description
            if (filters.dtMapSearch.containsKey("description")) {
                tailLineBuilder.append(" (gpm.description like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("description"))).append("%') ");
            }
            
            // Filter Authorized By
            if (filters.dtMapSearch.containsKey("authorizedBy")) {
                tailLineBuilder.append("or (gpm.authorized_by like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("authorizedBy"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(GlobPermsModelDocSearchDefParam filters, Integer level) {
        StringBuilder orderBuilder = new StringBuilder();
        if (StringSupport.isNullOrEmpty(filters.sortBy)) {
            if (level == 1) {
                orderBuilder.append(" order by gpm.created ");
            } else {
                orderBuilder.append(" order by created ");
            }
            return orderBuilder.toString();
        }
        switch (filters.sortBy) {
            case "description": {
                if (level == 1) {
                    orderBuilder.append(" order by gpm.description ");
                } else {
                    orderBuilder.append(" order by description ");
                }
                break;
            }
            case "authorizedBy": {
                if (level == 1) {
                    orderBuilder.append(" order by gpm.authorized_by ");
                } else {
                    orderBuilder.append(" order by authorized_by ");
                }
                break;
            }
            case "created": {
                if (level == 1) {
                    orderBuilder.append(" order by gpm.created ");
                } else {
                    orderBuilder.append(" order by created ");
                }
                break;
            }
            default: {
                if (level == 1) {
                    orderBuilder.append(" order by gpm.created ");
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
