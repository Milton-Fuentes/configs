/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobFile;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentBO;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobFileDaoImpl extends GenericDao<BigDecimal, GlobFile> implements GlobFileDao {

    @Override
    public void delete(BigDecimal id) {
        GlobFile elem = (GlobFile) getEntityManager()
                .createNamedQuery("GlobFile.findById")
                .setParameter("id", id)
                .getSingleResult();
        /*try {
            FileSupport.removeFile(elem.getServerPath());
        } catch (IOException ex) {
            Logger.getLogger(GlobFileDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        delete(elem);
    }

    @Override
    public void delete(List<BigInteger> ids) {
        getEntityManager().createNativeQuery("UPDATE GLOB_FILE SET ACTIVE = 'N', FIELD1 = 'Y' WHERE ID IN :ids").setParameter("ids", ids).executeUpdate();
    }

    @Override
    public List<GlobFile> findAByFolder(BigDecimal folderId) {
        try {
            List<GlobFile> array = getEntityManager().createNamedQuery("GlobFile.findByFolder")
                    .setParameter("folderId", folderId)
                    .getResultList();
            return array;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public String getNextDCNByClient(BigInteger clientId) {
        String query = "select nvl(max(to_number(dcn)) + 1, 1) dcn_max"
                + " from glob_file inner join glob_folder on glob_folder.id = glob_file.folder_id"
                + " where(glob_folder.project_id in"
                + " (select id from glob_project where client_id = :cId union select :ncId from dual)"
                + " or glob_folder.plan_project_id in "
                + " (select id from plan_projects where client_id = :cId union select :ncId from dual))";
        NumberFormat formatter = new DecimalFormat("#0000000");
        Query q = getEntityManager().createNativeQuery(query);
        q.setParameter("cId", clientId);
        q.setParameter("ncId", clientId.negate());
        BigDecimal dcn = (BigDecimal) q.getSingleResult();
        if (dcn == null) {
            dcn = BigDecimal.ONE;
        }
        return formatter.format(dcn);
    }

    @Override
    public String getNextDCNByProject(BigInteger projectId) {
        String query = "SELECT MAX(to_number(DCN)) + 1 DCN_MAX FROM GLOB_FILE WHERE project_id = :projectId";
        NumberFormat formatter = new DecimalFormat("#0000000");
        Query q = getEntityManager().createNativeQuery(query);
        q.setParameter("projectId", projectId);
        BigDecimal dcn = (BigDecimal) q.getSingleResult();
        if (dcn == null) {
            dcn = BigDecimal.ONE;
        }
        return formatter.format(dcn);
    }
    
    @Override
    public String getNextDCNByPlanProject(BigInteger projectId) {
        String query = "SELECT MAX(to_number(DCN)) + 1 DCN_MAX FROM GLOB_FILE WHERE PLAN_PROJECT_ID = :projectId";
        NumberFormat formatter = new DecimalFormat("#0000000");
        Query q = getEntityManager().createNativeQuery(query);
        q.setParameter("projectId", projectId);
        BigDecimal dcn = (BigDecimal) q.getSingleResult();
        if (dcn == null) {
            dcn = BigDecimal.ONE;
        }
        return formatter.format(dcn);
    }

    @Override
    public DataTableWrapper<DocumentBO> getFrontEndSearch(DocumentSearchDefParam filters, Boolean wrap) {
        // TailLine Definition
        String tailLine = buildFilters(filters);
        // OrderLine Definition
        String orderLine = buildSort(filters, 1);
        String orderLine2 = buildSort(filters, 2);
        String countQuery = buildCountQuery(filters, tailLine);
        String query = buildQuery(filters, tailLine, orderLine, orderLine2, wrap);
        try {
            Long count = getTotal(countQuery);
            List<Object[]> objects = getEntityManager().createNativeQuery(query).getResultList();
            List<DocumentBO> data = populateBO(objects);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<DocumentBO> populateBO(List<Object[]> objects) {
        List<DocumentBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            DocumentBO p = new DocumentBO();
            p.setOwner(StringSupport.emptyOnNull(it[0]));
            p.setTimesShared(NumberSupport.getInteger(it[1]));
            p.setId(NumberSupport.getBigInteger(it[2]));
            p.setTitle(StringSupport.emptyOnNull(it[3]));
            p.setName(StringSupport.emptyOnNull(it[4]));
            p.setCreated(it[6] != null ? DateSupport.formatUS((Date) it[5]) : null);
            p.setUploaded(it[7] != null ? DateSupport.formatUS((Date) it[6]) : null);
            p.setExtension(StringSupport.emptyOnNull(it[7]));
            p.setSize(NumberSupport.getBigDecimal(it[8]));
            p.setOwnerId(NumberSupport.getBigInteger(it[9]));
            p.setPath(StringSupport.emptyOnNull(it[10]));
            p.setVersion(NumberSupport.getInteger(it[11]));
            p.setDcn(StringSupport.emptyOnNull(it[12]));
            p.setParentId(NumberSupport.getBigInteger(it[13]));
            p.setProjectId(NumberSupport.getBigInteger(it[14]));
            p.setContractId(NumberSupport.getBigInteger(it[15]));
            p.setSystemPath(StringSupport.emptyOnNull(it[16]));
            p.setType("DOC");

            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    private String buildCountQuery(DocumentSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM GLOB_FILE gfi INNER JOIN GLOB_USERS gus ON (GFI.OWNER = GUS.ID) INNER JOIN GLOB_CONTACT gct ON (GUS.CONTACTID = GCT.ID) "
                + " LEFT JOIN (select tk.file_id, count(tk.id) total from glob_file_tk tk group by tk.file_id) ftk on ftk.file_id = gfi.ID "
                + " LEFT JOIN (select fd.file_id, count(tk.id) total from glob_file_tk tk, glob_file_tk_mul fd where tk.id = fd.file_tk_id group by fd.file_id) ftkm on ftkm.file_id = gfi.ID ";
        String whereLine = " WHERE gfi.ACTIVE='Y' AND gfi.FOLDER_ID = " + StringSupport.sanitizeStringForSql(filters.folderId) + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    private String buildQuery(DocumentSearchDefParam filters, String tailLine, String orderLine, String orderLine2, Boolean wrap) {
        String fieldLine = " (GCT.FIRSTNAME || ' ' || GCT.LASTNAME) AS C_OWNER,"
                + "NVL(FTK.TOTAL, 0) + NVL(FTKM.TOTAL, 0) C_SHT,"
                + "GFI.ID AS C_ID, GFI.F_TITLE AS C_TITLE, GFI.F_NAME AS C_SERVER_NAME, GFI.UPLOADED AS C_CREATED,"
                + "GFI.F_DATE AS C_DATE, GFI.EXTENSION AS C_EXTENSION, GFI.F_SIZE AS C_SIZE, GFI.OWNER AS C_OWNER_ID,"
                + "GFI.SERVER_PATH AS C_PATH, GFI.VERSION AS C_VERSION, GFI.DCN AS C_DCN, GFI.FOLDER_ID AS PARENT_ID,"
                + "GFI.PROJECT_ID AS PROJECT_ID,GFI.CONTRACT_ID AS CONTRACT_ID, GFI.SYSTEM_PATH ";
        String fromLine = " FROM GLOB_FILE gfi INNER JOIN GLOB_USERS gus ON (GFI.OWNER = GUS.ID) INNER JOIN GLOB_CONTACT gct ON (GUS.CONTACTID = GCT.ID) "
                + " LEFT JOIN (SELECT TK.FILE_ID, COUNT(TK.ID) TOTAL FROM GLOB_FILE_TK TK GROUP BY TK.FILE_ID) FTK ON FTK.FILE_ID = GFI.ID "
                + " LEFT JOIN (SELECT FD.FILE_ID, COUNT(TK.ID) TOTAL FROM GLOB_FILE_TK TK, GLOB_FILE_TK_MUL FD WHERE TK.ID = FD.FILE_TK_ID GROUP BY FD.FILE_ID) FTKM ON FTKM.FILE_ID = GFI.ID ";
        String whereLine = " WHERE GFI.ACTIVE='Y' AND GFI.FOLDER_ID = " + StringSupport.sanitizeStringForSql(filters.folderId) + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        if(wrap) {
            return wrapToServerSide(query, orderLine2, filters);
        } else {
            return query;
        }
    }

    private String buildFilters(DocumentSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" AND ( ");
            // Filter
            if (filters.dtMapSearch.containsKey("dcn")) {
                tailLineBuilder.append("(GFI.DCN LIKE '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("dcn"))).append("%') ");
            }
            if (filters.dtMapSearch.containsKey("title")) {
                tailLineBuilder.append("OR (UPPER(GFI.F_TITLE) LIKE '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("title")).toUpperCase()).append("%') ");
            }
            if (filters.dtMapSearch.containsKey("owner")) {
                tailLineBuilder.append("OR (UPPER((GCT.FIRSTNAME || ' ' || GCT.LASTNAME)) LIKE '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("owner")).toUpperCase()).append("%') ");
            }
            if (filters.dtMapSearch.containsKey("timesShared")) {
                tailLineBuilder.append("OR (NVL(FTK.TOTAL, 0) + NVL(FTKM.TOTAL, 0) LIKE '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("timesShared"))).append("%') ");
            }
            if (filters.dtMapSearch.containsKey("uploaded")) {
                tailLineBuilder.append("OR (GFI.F_DATE LIKE '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("uploaded"))).append("%') ");
            }
            if (filters.dtMapSearch.containsKey("extension")) {
                tailLineBuilder.append("OR (GFI.EXTENSION LIKE '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("extension"))).append("%') ");
            }
            if (filters.dtMapSearch.containsKey("size")) {
                tailLineBuilder.append("OR (GFI.F_SIZE LIKE '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("size"))).append("%') ");
            }
            if (filters.dtMapSearch.containsKey("version")) {
                tailLineBuilder.append("OR (GFI.VERSION LIKE '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("version"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    private String buildSort(DocumentSearchDefParam filters, Integer level) {
        StringBuilder orderBuilder = new StringBuilder();
        if (StringSupport.isNullOrEmpty(filters.sortBy)) {
            if (level == 1) {
                orderBuilder.append(" order by gfi.id ");
            } else {
                orderBuilder.append(" order by c_id ");
            }
            return orderBuilder.toString();
        }
        switch (filters.sortBy) {
            case "dcn": {
                if (level == 1) {
                    orderBuilder.append(" order by gfi.dcn ");
                } else {
                    orderBuilder.append(" order by c_dcn ");
                }
                break;
            }
            case "title": {
                if (level == 1) {
                    orderBuilder.append(" order by gfi.f_title ");
                } else {
                    orderBuilder.append(" order by c_title ");
                }
                break;
            }
            case "owner": {
                if (level == 1) {
                    orderBuilder.append(" order by gct.firstname || ' ' || gct.lastname ");
                } else {
                    orderBuilder.append(" order by c_owner ");
                }
                break;
            }
            case "timesShared": {
                if (level == 1) {
                    orderBuilder.append(" order by (nvl(ftk.total, 0) + nvl(ftkm.total, 0)) ");
                } else {
                    orderBuilder.append(" order by C_SHT ");
                }
                break;
            }
            case "uploaded": {
                if (level == 1) {
                    orderBuilder.append(" order by gfi.f_date ");
                } else {
                    orderBuilder.append(" order by c_date ");
                }
                break;
            }
            case "size": {
                if (level == 1) {
                    orderBuilder.append(" order by gfi.f_size ");
                } else {
                    orderBuilder.append(" order by c_size ");
                }
                break;
            }
            case "version": {
                if (level == 1) {
                    orderBuilder.append(" order by gfi.version ");
                } else {
                    orderBuilder.append(" order by c_version ");
                }
                break;
            }
            default: {
                if (level == 1) {
                    orderBuilder.append(" order by gfi.id ");
                } else {
                    orderBuilder.append(" order by c_id ");
                }
                break;
            }
        }
        orderBuilder.append(filters.sortDir);
        return orderBuilder.toString();
    }

    @Override
    public void lockFile(BigDecimal fileId, BigDecimal userId) {
        getEntityManager().createNativeQuery("UPDATE GLOB_FILE SET CHECKOUT_ID = :uId, CHECKOUT_TIME = SYSDATE WHERE ID = :fId")
                .setParameter("fId", fileId)
                .setParameter("uId", userId)
                .executeUpdate();
    }

    @Override
    public void unlockFile(BigDecimal fileId) {
        String query = "UPDATE GLOB_FILE SET CHECKOUT_ID = 0 WHERE CHECKOUT_ID <> 0";
        Query q;
        if (fileId == null) {
            query += " AND (SELECT (SYSDATE - CHECKOUT_TIME) * 24 * 60 FROM DUAL) >= 2";
            q = getEntityManager().createNativeQuery(query);
        } else {
            query += " AND ID = :fId";
            q = getEntityManager().createNativeQuery(query).setParameter("fId", fileId);
        }
        q.executeUpdate();
    }

    @Override
    public Boolean isFileLocked(BigDecimal fileId, BigDecimal userId) {
        Query q = getEntityManager().createNativeQuery("SELECT CHECKOUT_ID FROM GLOB_FILE WHERE ID = :fId");
        q.setParameter("fId", fileId);
        BigDecimal checkoutId = (BigDecimal) q.getSingleResult();

        if (checkoutId == null || checkoutId == BigDecimal.ZERO || checkoutId.equals(userId)) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public List<GlobFile> listByIds(List<BigInteger> ids) {
        return getEntityManager().createNativeQuery("SELECT * FROM GLOB_FILE WHERE ID IN :ids", GlobFile.class).setParameter("ids", ids).getResultList();
    }
    
    //--[ Advancec Search ]-----------------------------------------------------
    @Override
    public DataTableWrapper<DocumentBO> getFrontEndSearchAdvance(DocumentSearchDefParam filters, AtserLinkedHashMap<String, Object> sParam, Boolean wrap) {
        // TailLine Definition
        String tailLine = buildFilters(filters);
        // OrderLine Definition
        String orderLine = buildSort(filters, 1);
        String orderLine2 = buildSort(filters, 2);
        String filter = buildFilterAdvance(sParam);
        String countQuery = buildCountQueryAdvance(filters, filter, tailLine);
        String query = buildQueryAdvance(filters, tailLine, filter, orderLine, orderLine2, wrap);
        try {
            Long count = getTotal(countQuery);
            List<Object[]> objects = getEntityManager().createNativeQuery(query).getResultList();
            List<DocumentBO> data = populateBO(objects);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    private String buildQueryAdvance(DocumentSearchDefParam filters, String tailLine, String filter, String orderLine, String orderLine2, Boolean wrap) {
        String fieldLine = " (GCT.FIRSTNAME || ' ' || GCT.LASTNAME) AS C_OWNER,"
                + "NVL(FTK.TOTAL, 0) + NVL(FTKM.TOTAL, 0) C_SHT,"
                + "GFI.ID AS C_ID, GFI.F_TITLE AS C_TITLE, GFI.F_NAME AS C_SERVER_NAME, GFI.UPLOADED AS C_CREATED,"
                + "GFI.F_DATE AS C_DATE, GFI.EXTENSION AS C_EXTENSION, GFI.F_SIZE AS C_SIZE, GFI.OWNER AS C_OWNER_ID,"
                + "GFI.SERVER_PATH AS C_PATH, GFI.VERSION AS C_VERSION, GFI.DCN AS C_DCN, GFI.FOLDER_ID AS PARENT_ID,"
                + "GFI.PROJECT_ID AS PROJECT_ID,GFI.CONTRACT_ID AS CONTRACT_ID, GFI.SYSTEM_PATH ";
        String fromLine = " FROM GLOB_FILE gfi INNER JOIN GLOB_USERS gus ON (GFI.OWNER = GUS.ID) INNER JOIN GLOB_CONTACT gct ON (GUS.CONTACTID = GCT.ID) "
                + " LEFT JOIN (SELECT TK.FILE_ID, COUNT(TK.ID) TOTAL FROM GLOB_FILE_TK TK GROUP BY TK.FILE_ID) FTK ON FTK.FILE_ID = GFI.ID "
                + " LEFT JOIN (SELECT FD.FILE_ID, COUNT(TK.ID) TOTAL FROM GLOB_FILE_TK TK, GLOB_FILE_TK_MUL FD WHERE TK.ID = FD.FILE_TK_ID GROUP BY FD.FILE_ID) FTKM ON FTKM.FILE_ID = GFI.ID ";
        String whereLine = " WHERE GFI.ACTIVE='Y' AND GFI.FOLDER_ID IN (SELECT ID FROM GLOB_FOLDER WHERE ACTIVE = 'Y' START WITH ID = " + StringSupport.sanitizeStringForSql(filters.folderId) + " CONNECT BY PRIOR ID = PARENT_ID) ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + filter + orderLine;
        if(wrap) {
            return wrapToServerSide(query, orderLine2, filters);
        } else {
            return query;
        }
    }
    
    private String buildFilterAdvance(AtserLinkedHashMap<String, Object> sParam) {
        List<String> filters = new ArrayList<>();
        
        // sName
        if(StringSupport.isNotNullAndNotEmpty(sParam.get("sName"))) {
            filters.add("LOWER(F_TITLE) LIKE '%" + StringSupport.sanitizeStringForSql(sParam.get("sName").toString().toLowerCase()) + "%' ");
        }
        
        // sExtensions
        if(StringSupport.isNotNullAndNotEmpty(sParam.get("sExtension"))) {
            filters.add("EXTENSION IN (" + "'" + String.join("','", (ArrayList<String>)sParam.get("sExtension")) + "'" + ")");
        }
        
        // sOwner
        if(StringSupport.isNotNullAndNotEmpty(sParam.get("sOwnerId"))) {
            filters.add("OWNER = " + StringSupport.sanitizeStringForSql(sParam.get("sOwnerId").toString()));
        }
        
        // sVersion
        if(StringSupport.isNotNullAndNotEmpty(sParam.get("sVersion"))) {
            filters.add("VERSION = " + StringSupport.sanitizeStringForSql(sParam.get("sVersion").toString()));
        }
        
        // sSize
        if(StringSupport.isNotNullAndNotEmpty(sParam.get("sSizeFrom")) && StringSupport.isNotNullAndNotEmpty(sParam.get("sSizeEnd"))) {
            filters.add("F_SIZE > " + StringSupport.sanitizeStringForSql(sParam.get("sSizeFrom").toString()) + " AND F_SIZE < " + StringSupport.sanitizeStringForSql(sParam.get("sSizeEnd").toString()));
        } else if(StringSupport.isNotNullAndNotEmpty(sParam.get("sSizeFrom")) && !StringSupport.isNotNullAndNotEmpty(sParam.get("sSizeEnd"))) {
            filters.add("F_SIZE > " + StringSupport.sanitizeStringForSql(sParam.get("sSizeFrom").toString()));
        } else if(!StringSupport.isNotNullAndNotEmpty(sParam.get("sSizeFrom")) && StringSupport.isNotNullAndNotEmpty(sParam.get("sSizeEnd"))) {
            filters.add("F_SIZE < " + StringSupport.sanitizeStringForSql(sParam.get("sSizeEnd").toString()));
        }
        
        // sCrtDate
        if(StringSupport.isNotNullAndNotEmpty(sParam.get("sCrtDate"))) {
            filters.add("EXTRACT(YEAR FROM UPLOADED) = " + StringSupport.sanitizeStringForSql(sParam.get("sCrtDate").toString()));
        }
        
        // sUploadedDate
        if(StringSupport.isNotNullAndNotEmpty(sParam.get("sUploadedDateFrom")) && StringSupport.isNotNullAndNotEmpty(sParam.get("sUploadedDateEnd"))) {
            filters.add("TRUNC(UPLOADED) >= to_date('" + StringSupport.sanitizeStringForSql(sParam.get("sUploadedDateFrom").toString()) + "','MM/DD/YYYY') AND TRUNC(UPLOADED) <= to_date('" + StringSupport.sanitizeStringForSql(sParam.get("sUploadedDateEnd").toString()) + "','MM/DD/YYYY')");
        } else if(StringSupport.isNotNullAndNotEmpty(sParam.get("sUploadedDateFrom")) && !StringSupport.isNotNullAndNotEmpty(sParam.get("sUploadedDateEnd"))) {
            filters.add("TRUNC(UPLOADED) >= to_date('" + StringSupport.sanitizeStringForSql(sParam.get("sUploadedDateEnd").toString()) + "','MM/DD/YYYY')");
        } else if(!StringSupport.isNotNullAndNotEmpty(sParam.get("sUploadedDateFrom")) && StringSupport.isNotNullAndNotEmpty(sParam.get("sUploadedDateEnd"))) {
            filters.add("TRUNC(UPLOADED) <= to_date('" + StringSupport.sanitizeStringForSql(sParam.get("sUploadedDateEnd").toString()) + "','MM/DD/YYYY')");
        }
        
        // sModificationDate
        if(StringSupport.isNotNullAndNotEmpty(sParam.get("sModDateFrom")) && StringSupport.isNotNullAndNotEmpty(sParam.get("sModDateEnd"))) {
            filters.add("TRUNC(F_DATE) >= to_date('" + StringSupport.sanitizeStringForSql(sParam.get("sModDateFrom").toString()) + "','MM/DD/YYYY') AND TRUNC(F_DATE) <= to_date('" + StringSupport.sanitizeStringForSql(sParam.get("sModDateEnd").toString()) + "','MM/DD/YYYY')");
        } else if(StringSupport.isNotNullAndNotEmpty(sParam.get("sModDateFrom")) && !StringSupport.isNotNullAndNotEmpty(sParam.get("sModDateEnd"))) {
            filters.add("TRUNC(F_DATE) >= to_date('" + StringSupport.sanitizeStringForSql(sParam.get("sModDateFrom").toString()) + "','MM/DD/YYYY')");
        } else if(!StringSupport.isNotNullAndNotEmpty(sParam.get("sModDateEnd")) && StringSupport.isNotNullAndNotEmpty(sParam.get("sModDateEnd"))) {
            filters.add("TRUNC(F_DATE) <= to_date('" + StringSupport.sanitizeStringForSql(sParam.get("sModDateEnd").toString()) + "','MM/DD/YYYY')");
        }
        // --------------------------------------------------------------------------------------
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filters By Search
        if(StringSupport.isNotNullAndNotEmpty(sParam.get("sQuickSearch"))) {
            filters.add("(GFI.DCN LIKE '%" + StringSupport.sanitizeStringForSql(sParam.get("sQuickSearch").toString()) + "%' " +
            "OR GFI.F_TITLE LIKE '%" + StringSupport.sanitizeStringForSql(sParam.get("sQuickSearch").toString()) + "%' " +
            "OR GFI.EXTENSION LIKE '%" + StringSupport.sanitizeStringForSql(sParam.get("sQuickSearch").toString()) + "%' " +
            "OR TO_CHAR(GFI.F_DATE,'MM/DD/YYYY') LIKE '%" + StringSupport.sanitizeStringForSql(sParam.get("sQuickSearch").toString()) + "%' " +
            "OR GFI.VERSION LIKE '%" + StringSupport.sanitizeStringForSql(sParam.get("sQuickSearch").toString()) + "%' " +
            "OR NVL(FTK.TOTAL, 0) + NVL(FTKM.TOTAL, 0) LIKE '%" + StringSupport.sanitizeStringForSql(sParam.get("sQuickSearch").toString()) + "%' " +
            "OR (GCT.FIRSTNAME || ' ' || GCT.LASTNAME) LIKE '%" + StringSupport.sanitizeStringForSql(sParam.get("sQuickSearch").toString()) + "%')");
        }

        // --------------------------------------------------------------------------------------
        // Result filter.
        String filterResult = "";
        if (filters.size() == 1) {
            filterResult =  " AND " + filters.get(0);
        } else if (filters.size() > 1) {
            filterResult = filters.stream().map(filter -> " AND " + filter).reduce(filterResult, String::concat);
        }
        return filterResult;
    }

    private String buildCountQueryAdvance(DocumentSearchDefParam filters, String filter, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM GLOB_FILE gfi INNER JOIN GLOB_USERS gus ON (GFI.OWNER = GUS.ID) INNER JOIN GLOB_CONTACT gct ON (GUS.CONTACTID = GCT.ID) "
                + " LEFT JOIN (select tk.file_id, count(tk.id) total from glob_file_tk tk group by tk.file_id) ftk on ftk.file_id = gfi.ID "
                + " LEFT JOIN (select fd.file_id, count(tk.id) total from glob_file_tk tk, glob_file_tk_mul fd where tk.id = fd.file_tk_id group by fd.file_id) ftkm on ftkm.file_id = gfi.ID ";
        String whereLine = " WHERE GFI.ACTIVE='Y' AND GFI.FOLDER_ID IN (SELECT ID FROM GLOB_FOLDER WHERE ACTIVE = 'Y' START WITH ID = " + StringSupport.sanitizeStringForSql(filters.folderId) + " CONNECT BY PRIOR ID = PARENT_ID) ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

}
