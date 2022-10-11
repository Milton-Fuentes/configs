/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentBO;
import com.atser.tools.atserutil.objects.to.FolderTreeViewSyncTO;
import com.atser.tools.atserutil.objects.to.pattern.AtserFolderView;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobFolderDaoImpl extends GenericDao<BigDecimal, GlobFolder> implements GlobFolderDao {

    @Override
    public void delete(List<BigInteger> ids) {
        getEntityManager().createNativeQuery("UPDATE GLOB_FOLDER SET ACTIVE = 'N', FIELD1 = 'Y' WHERE ID IN (SELECT ID FROM GLOB_FOLDER WHERE ACTIVE = 'Y' START WITH ID IN :ids CONNECT BY PRIOR ID = PARENT_ID)").setParameter("ids", ids).executeUpdate();
        getEntityManager().createNativeQuery("UPDATE GLOB_FILE SET ACTIVE = 'N', FIELD1 = 'Y' WHERE FOLDER_ID IN (SELECT ID FROM GLOB_FOLDER WHERE ACTIVE = 'Y' START WITH ID IN :ids CONNECT BY PRIOR ID = PARENT_ID)").setParameter("ids", ids).executeUpdate();
    }

    @Override
    public String getNextFolderNumber(BigInteger parentId, String numberFormat) {
        String query = "SELECT MAX(TO_NUMBER(F_NUMBER, '9999.99')) FINALSTEP FROM GLOB_FOLDER f WHERE f.PARENT_ID = :parentId";
        NumberFormat formatter = new DecimalFormat(numberFormat);
        Query q = getEntityManager().createNativeQuery(query).setParameter("parentId", parentId);
        try {
            BigDecimal subId = (BigDecimal) q.getSingleResult();
            BigInteger result = (subId == null) ? BigInteger.ZERO : subId.toBigInteger();
            result = result.add(BigInteger.ONE);
            return formatter.format(result);
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public String getNextSpecFolderNameStep(BigInteger projectId, BigInteger contractId, String name) {
        return getNextSpecFolderNameStep(projectId, contractId, name, null);
    }

    @Override
    public String getNextSpecFolderNameStep(BigInteger projectId, BigInteger contractId, String name, String folderName) {
        String query;
        Query q;
        NumberFormat formatter;
        if (folderName == null) {
            if (contractId != null && contractId.intValue() > 0) {
                query = "SELECT MAX(TO_NUMBER(F_NAME, '9999.99')) FINALSTEP FROM GLOB_FOLDER f WHERE (SELECT isnumber(F_NAME) FROM dual) = 'Y' AND f.PARENT_ID = ( SELECT gf.ID FROM GLOB_FOLDER gf WHERE gf.ACTIVE = 'Y' AND gf.PROJECT_ID = :projectId AND gf.CONTRACT_ID = :contractId AND gf.F_NAME = :fName)";
            } else {
                query = "SELECT MAX(TO_NUMBER(F_NAME, '9999.99')) FINALSTEP FROM GLOB_FOLDER f WHERE (SELECT isnumber(F_NAME) FROM dual) = 'Y' AND f.PARENT_ID = ( SELECT gf.ID FROM GLOB_FOLDER gf WHERE gf.ACTIVE = 'Y' AND gf.PROJECT_ID = :projectId AND gf.F_NAME = :fName)";
            }
            formatter = new DecimalFormat("#0000");
        } else {
            if (contractId != null && contractId.intValue() > 0) {
                query = "SELECT MAX(TO_NUMBER(F_NAME, '9999.99')) FINALSTEP FROM GLOB_FOLDER f WHERE (SELECT isnumber(F_NAME) FROM dual) = 'Y' AND f.PARENT_ID = ( SELECT gf.ID FROM GLOB_FOLDER gf WHERE gf.ACTIVE = 'Y' AND gf.PROJECT_ID = :projectId AND gf.CONTRACT_ID = :contractId AND gf.F_NAME = :fName) AND f.F_NAME like '%" + folderName + "%'";
            } else {
                query = "SELECT MAX(TO_NUMBER(F_NAME, '9999.99')) FINALSTEP FROM GLOB_FOLDER f WHERE (SELECT isnumber(F_NAME) FROM dual) = 'Y' AND f.PARENT_ID = ( SELECT gf.ID FROM GLOB_FOLDER gf WHERE gf.ACTIVE = 'Y' AND gf.PROJECT_ID = :projectId AND gf.F_NAME = :fName) AND f.F_NAME like '%" + folderName + "%'";
            }
            formatter = new DecimalFormat("#0000.##");
        }

        if (contractId != null && contractId.intValue() > 0) {
            q = getEntityManager().createNativeQuery(query)
                    .setParameter("projectId", projectId)
                    .setParameter("contractId", contractId)
                    .setParameter("fName", name);
        } else {
            q = getEntityManager().createNativeQuery(query)
                    .setParameter("projectId", projectId)
                    .setParameter("fName", name);
        }

        try {
            BigDecimal subId = (BigDecimal) q.getSingleResult();
            if (folderName == null) {
                BigInteger result = (subId == null) ? BigInteger.ZERO : subId.toBigInteger();
                result = result.add(BigInteger.ONE);
                return formatter.format(result);
            } else {
                subId = subId.add(new BigDecimal("0.1"));
                return formatter.format(subId);
            }
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public BigDecimal getFolderIdByFolderNameByProject(BigInteger projectId, BigInteger contractId, String name) {
        return getFolderIdByFolderNameByProject(projectId, contractId, name, null);
    }

    @Override
    public BigDecimal getFolderIdByFolderNameByProject(BigInteger projectId, BigInteger contractId, String name, BigInteger parentId) {
        String hql;
        Query query;

        if (contractId != null && contractId.intValue() > 0) {
            if (parentId != null) {
                hql = "GlobFolder.findByFolderNameAndParentId";
                query = getEntityManager().createNamedQuery(hql)
                        .setParameter("projectId", projectId)
                        .setParameter("contractId", contractId)
                        .setParameter("parentId", parentId)
                        .setParameter("fName", name);
            } else {
                hql = "GlobFolder.findByFolderName";
                query = getEntityManager().createNamedQuery(hql)
                        .setParameter("projectId", projectId)
                        .setParameter("contractId", contractId)
                        .setParameter("fName", name);
            }
        } else {
            if (parentId != null) {
                hql = "GlobFolder.findByFolderNameAndProjectParentId";
                query = getEntityManager().createNamedQuery(hql)
                        .setParameter("projectId", projectId)
                        .setParameter("parentId", parentId)
                        .setParameter("fName", name);
            } else {
                hql = "GlobFolder.findByFolderNameAndProjectId";
                query = getEntityManager().createNamedQuery(hql)
                        .setParameter("projectId", projectId)
                        .setParameter("fName", name);
            }
        }

        try {
            BigDecimal subId = (BigDecimal) query.getSingleResult();
            return subId;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Boolean exists(String folderNumber, String folderName, BigInteger folderParentId) {
        String query = "SELECT F.ID FROM GLOB_FOLDER F WHERE F.F_NUMBER = :folderNumber AND F.F_NAME = :folderName AND F.ACTIVE = 'Y' AND F.PARENT_ID = :folderParentId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("folderNumber", folderNumber).setParameter("folderName", folderName).setParameter("folderParentId", folderParentId);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

    @Override
    public GlobFolder findByFName(BigInteger projectId, BigInteger contractId, String subname, String name) {
        BigDecimal fId = getFolderIdByFolderNameByProject(projectId, contractId, subname);
        try {
            GlobFolder result = (GlobFolder) getEntityManager().createNamedQuery("GlobFolder.findByFNameAndParentId")
                    .setParameter("parentId", fId.toBigInteger())
                    .setParameter("fName", name)
                    .getSingleResult();
            return result;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public BigDecimal getFolderIdByFunctionInProject(String functionName, BigInteger projectId, BigInteger clientId) {
        String query = "select f.id from glob_folder f, cm_ti_folder_map fm where fm.ti_default_id = f.default_id and fm.cm_type_name = :functionName AND fm.client_id = :clientId AND f.project_id = :projectId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("functionName", functionName)
                .setParameter("projectId", projectId)
                .setParameter("clientId", clientId);
        try {
            return (BigDecimal) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public GlobFolder getClientFolder(BigInteger clientId) {
        try {
            return (GlobFolder) getEntityManager().createNamedQuery("GlobFolder.findByParentId")
                    .setParameter("parentId", clientId)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public GlobFolder getProjectFolder(BigInteger projectId) {
        String query = "SELECT GF.ID, GF.PARENT_ID, GF.FIELD1, GF.PROJECT_ID, GF.F_DATE, GF.CREATED, GF.OWNER, GF.F_NAME, GF.DEFAULT_ID, GF.FOLDER_TYPE_ID, GF.F_NUMBER, GF.DEFAULT_GROUP_NUM, GF.CONTRACT_ID, GF.ACTIVE, GF.READ_ONLY, GF.F_DATE_TMP, GF.METADATA, GF.VISIBLE, (SELECT COUNT(*) FROM GLOB_FOLDER f WHERE f.PARENT_ID = gf.ID) as CANT_OF_CHILD, gf.PLAN_PROJECT_ID "
                + "FROM GLOB_FOLDER gf WHERE gf.PROJECT_ID = :pId AND gf.PARENT_ID = 0 AND gf.ACTIVE = 'Y' ORDER BY gf.ID ASC";
        Query q = getEntityManager().createNativeQuery(query).setParameter("pId", projectId);
        return populate(q.getSingleResult());
    }

    @Override
    public GlobFolder getPlanProjectFolder(BigInteger projectId) {
        String query = "SELECT GF.ID, GF.PARENT_ID, GF.FIELD1, GF.PROJECT_ID, GF.F_DATE, GF.CREATED, GF.OWNER, GF.F_NAME, GF.DEFAULT_ID, GF.FOLDER_TYPE_ID, GF.F_NUMBER, GF.DEFAULT_GROUP_NUM, GF.CONTRACT_ID, GF.ACTIVE, GF.READ_ONLY, GF.F_DATE_TMP, GF.METADATA, GF.VISIBLE, (SELECT COUNT(*) FROM GLOB_FOLDER f WHERE f.PARENT_ID = gf.ID) as CANT_OF_CHILD, gf.PLAN_PROJECT_ID "
                + "FROM GLOB_FOLDER gf WHERE gf.PLAN_PROJECT_ID = :pId AND gf.PARENT_ID = 0 AND gf.ACTIVE = 'Y' ORDER BY gf.ID ASC";
        Query q = getEntityManager().createNativeQuery(query).setParameter("pId", projectId);
        return populate(q.getSingleResult());
    }

    @Override
    public List<AtserFolderView> folderList(String mode, BigInteger projectId, BigInteger contractId, String name) {
        try {
            BigDecimal subId = getFolderIdByFolderNameByProject(projectId, contractId, name);

            if (subId != null && mode.equals("tree")) {
                List<AtserFolderView> roots = hierarchicalFolder(projectId, contractId, name);
                List<GlobFolder> array = getEntityManager().createNamedQuery("GlobFolder.findByParentId")
                        .setParameter("parentId", subId.toBigInteger())
                        .getResultList();
                List<AtserFolderView> childs = new ArrayList<>();

                array.forEach((globFolder) -> {
                    childs.add(new FolderTreeViewSyncTO(globFolder.getId().longValue(), globFolder.getParentId().longValue(), globFolder.getFName(), DateSupport.formatDate(globFolder.getCreated(), DateSupport.FORMAT_US), globFolder.getOwner().toString(), Boolean.FALSE, Boolean.FALSE, "fa fa-book"));
                });

                roots.addAll(childs);

                return roots;
            }
        } catch (NoResultException ex) {
            return null;
        }
        return null;
    }

    private List<AtserFolderView> hierarchicalFolder(BigInteger projectId, BigInteger contractId, String name) {
        String query;
        Query q;

        if (contractId != null && contractId.intValue() > 0) {
            query = "SELECT gf.* FROM GLOB_FOLDER gf\n"
                    + "START WITH gf.ID = (SELECT gf.ID FROM GLOB_FOLDER gf \n"
                    + "WHERE gf.ACTIVE = 'Y' AND gf.PROJECT_ID = :projectId AND gf.CONTRACT_ID = :contractId AND gf.F_NAME = :fName) \n"
                    + "CONNECT BY gf.ID = PRIOR gf.PARENT_ID AND gf.PARENT_ID != PRIOR ID\n"
                    + "ORDER SIBLINGS BY gf.ID";
            q = getEntityManager().createNativeQuery(query, GlobFolder.class)
                    .setParameter("projectId", projectId)
                    .setParameter("contractId", contractId)
                    .setParameter("fName", name);
        } else {
            query = "SELECT gf.* FROM GLOB_FOLDER gf\n"
                    + "START WITH gf.ID = (SELECT gf.ID FROM GLOB_FOLDER gf \n"
                    + "WHERE gf.ACTIVE = 'Y' AND gf.PROJECT_ID = :projectId  AND gf.F_NAME = :fName) \n"
                    + "CONNECT BY gf.ID = PRIOR gf.PARENT_ID AND gf.PARENT_ID != PRIOR ID\n"
                    + "ORDER SIBLINGS BY gf.ID";
            q = getEntityManager().createNativeQuery(query, GlobFolder.class)
                    .setParameter("projectId", projectId)
                    .setParameter("fName", name);
        }

        List<GlobFolder> array = q.getResultList();
        List<AtserFolderView> result = new ArrayList<>();
        array.forEach((globFolder) -> {
            result.add(new FolderTreeViewSyncTO(globFolder.getId().longValue(), globFolder.getParentId().longValue(), globFolder.getFName(), DateSupport.formatDate(globFolder.getCreated(), DateSupport.FORMAT_US), globFolder.getOwner().toString(), Boolean.TRUE, Boolean.TRUE, "rootFolder"));
        });
        return result;
    }

    @Override
    public List<GlobFolder> listFolderByParentId(BigInteger parentId) {
        String query = "SELECT GF.ID, GF.PARENT_ID, GF.FIELD1, GF.PROJECT_ID, GF.F_DATE, GF.CREATED, GF.OWNER, GF.F_NAME, GF.DEFAULT_ID, GF.FOLDER_TYPE_ID, GF.F_NUMBER, GF.DEFAULT_GROUP_NUM, GF.CONTRACT_ID, GF.ACTIVE, GF.READ_ONLY, GF.F_DATE_TMP, GF.METADATA, GF.VISIBLE,(SELECT COUNT(*) FROM GLOB_FOLDER F WHERE F.PARENT_ID = GF.ID) AS CANT_OF_CHILD, GF.PLAN_PROJECT_ID"
                + " FROM GLOB_FOLDER GF WHERE GF.PARENT_ID = :pId AND GF.ACTIVE = 'Y' ORDER BY TO_NUMBER(REPLACE(GF.F_NUMBER,'.','')) ASC, F_NAME ASC";
        List<Object[]> resultList = getEntityManager().createNativeQuery(query).setParameter("pId", parentId).getResultList();
        List<GlobFolder> folders = new ArrayList<>();
        resultList.stream().map((it) -> {
            return populate(it);
        }).forEachOrdered((to) -> {
            folders.add(to);
        });
        return folders;
    }

    @Override
    public List<GlobFolder> listFolderByParentIdWithRights(BigInteger parentId, BigInteger userId, String role_name) {
        String query = "SELECT * FROM ("
                + " (SELECT GF.ID, GF.PARENT_ID, GF.FIELD1, GF.PROJECT_ID, GF.F_DATE, GF.CREATED, GF.OWNER, GF.F_NAME, GF.DEFAULT_ID, GF.FOLDER_TYPE_ID, GF.F_NUMBER, GF.DEFAULT_GROUP_NUM, GF.CONTRACT_ID, GF.ACTIVE, GF.READ_ONLY, GF.F_DATE_TMP, '' METADATA, GF.VISIBLE,(SELECT COUNT(*) FROM GLOB_FOLDER F WHERE F.PARENT_ID = GF.ID) AS CANT_OF_CHILD, GF.PLAN_PROJECT_ID,"
                + " (CASE WHEN (SELECT 'Y' FROM GLOB_FOLDER_SHOW GFS WHERE GFS.TRUSTEE_ID = :uId AND GFS.TRUSTEE_TYPE = 1 AND FOLDER_ID = GF.ID) = 'Y' THEN 'Y' ELSE (CASE WHEN (SELECT R_BROWSE FROM GLOB_FOLDER_RIGHT WHERE TRUSTEE_ID = :uId AND TRUSTEE_TYPE = 1 AND FOLDER_ID = GF.ID) = 'Y' THEN 'Y' ELSE (CASE WHEN (SELECT R_BROWSE FROM GLOB_FOLDER_RIGHT WHERE TRUSTEE_ID = :uId AND TRUSTEE_TYPE = 1 AND FOLDER_ID = GF.ID) = 'N' THEN 'N' ELSE (CASE WHEN (SELECT (SELECT GR.R_BROWSE FROM GLOB_FOLDER_RIGHT GR WHERE GR.FOLDER_ID = GFF.ID AND GR.TRUSTEE_ID = :uId AND GR.TRUSTEE_TYPE = 1) AS V FROM GLOB_FOLDER GFF"
                + " WHERE GFF.ID <> GF.ID AND (SELECT GR.R_BROWSE FROM GLOB_FOLDER_RIGHT GR WHERE GR.FOLDER_ID = GFF.ID AND GR.TRUSTEE_ID = :uId AND GR.TRUSTEE_TYPE = 1) IS NOT NULL AND ROWNUM = 1 START WITH GFF.ID = GF.ID CONNECT BY PRIOR GFF.PARENT_ID = GFF.ID) = 'Y' THEN 'Y' ELSE 'N' END) END) END) END) AS IS_VISIBLE"
                + " FROM GLOB_FOLDER GF, GLOB_ROLES R"
                + " WHERE  GF.PARENT_ID = :pId AND GF.ACTIVE = 'Y')"
                + " UNION"
                + " (SELECT GF.ID, GF.PARENT_ID, GF.FIELD1, GF.PROJECT_ID, GF.F_DATE, GF.CREATED, GF.OWNER, GF.F_NAME, GF.DEFAULT_ID, GF.FOLDER_TYPE_ID, GF.F_NUMBER, GF.DEFAULT_GROUP_NUM, GF.CONTRACT_ID, GF.ACTIVE, GF.READ_ONLY, GF.F_DATE_TMP, '' METADATA, GF.VISIBLE,(SELECT COUNT(*) FROM GLOB_FOLDER f WHERE f.PARENT_ID = gf.ID) as CANT_OF_CHILD, GF.PLAN_PROJECT_ID,"
                + " (CASE WHEN (SELECT 'Y' FROM GLOB_FOLDER_SHOW GFS, GLOB_ROLES R WHERE GFS.TRUSTEE_ID(+) = R.ID AND R.ROLE_NAME = :rName AND GFS.TRUSTEE_TYPE = 2 AND FOLDER_ID = GF.ID) = 'Y' THEN 'Y' ELSE (CASE WHEN (SELECT GFR.R_BROWSE FROM GLOB_FOLDER_RIGHT GFR, GLOB_ROLES R WHERE GFR.TRUSTEE_ID(+) = R.ID AND R.ROLE_NAME = :rName AND GFR.TRUSTEE_TYPE = 2 AND GFR.FOLDER_ID = GF.ID) = 'Y' THEN 'Y' ELSE (CASE WHEN (SELECT GFR.R_BROWSE FROM GLOB_FOLDER_RIGHT GFR, GLOB_ROLES R WHERE GFR.TRUSTEE_ID(+) = R.ID AND R.ROLE_NAME = :rName AND GFR.TRUSTEE_TYPE = 2 AND FOLDER_ID = GF.ID) = 'N' THEN 'N' ELSE (CASE WHEN (SELECT (SELECT GFR.R_BROWSE FROM GLOB_FOLDER_RIGHT GFR, GLOB_ROLES R WHERE GFR.FOLDER_ID = GFF.ID AND GFR.TRUSTEE_ID(+) = R.ID AND R.ROLE_NAME = :rName AND GFR.TRUSTEE_TYPE = 2) AS V FROM GLOB_FOLDER GFF"
                + " WHERE GFF.ID <> GF.ID AND (SELECT GR.R_BROWSE FROM GLOB_FOLDER_RIGHT GR, GLOB_ROLES R WHERE GR.FOLDER_ID = GFF.ID AND GR.TRUSTEE_ID(+) = R.ID AND R.ROLE_NAME = :rName AND GR.TRUSTEE_TYPE = 2) IS NOT NULL AND ROWNUM = 1 START WITH GFF.ID = GF.ID CONNECT BY PRIOR GFF.PARENT_ID = GFF.ID) = 'Y' THEN 'Y' ELSE 'N' END) END) END) END) AS IS_VISIBLE"
                + " FROM GLOB_FOLDER GF"
                + " WHERE GF.PARENT_ID = :pId AND GF.ACTIVE = 'Y')"
                + " ) WHERE IS_VISIBLE = 'Y' ORDER BY TO_NUMBER(REPLACE(F_NUMBER,'.','')) ASC";
        List<Object[]> resultList = getEntityManager().createNativeQuery(query)
                .setParameter("pId", parentId)
                .setParameter("uId", userId)
                .setParameter("rName", role_name).getResultList();
        List<GlobFolder> folders = new ArrayList<>();
        resultList.stream().map((it) -> {
            return populate(it);
        }).forEachOrdered((to) -> {
            folders.add(to);
        });
        return folders;
    }

    @Override
    public List<GlobFolder> listFolderTreeByParentId(BigInteger parentId) {
        String query = "SELECT GF.ID, GF.PARENT_ID, GF.FIELD1, GF.PROJECT_ID, GF.F_DATE, GF.CREATED, GF.OWNER, GF.F_NAME, GF.DEFAULT_ID, GF.FOLDER_TYPE_ID, GF.F_NUMBER, GF.DEFAULT_GROUP_NUM, GF.CONTRACT_ID, GF.ACTIVE, GF.READ_ONLY, GF.F_DATE_TMP, GF.METADATA, GF.VISIBLE,(SELECT COUNT(*) FROM GLOB_FOLDER F WHERE F.PARENT_ID = GF.ID) AS CANT_OF_CHILD, GF.PLAN_PROJECT_ID"
                + " FROM GLOB_FOLDER GF WHERE GF.ACTIVE = 'Y' START WITH GF.ID = :pId CONNECT BY PRIOR GF.ID = GF.PARENT_ID";
        List<Object[]> resultList = getEntityManager().createNativeQuery(query).setParameter("pId", parentId).getResultList();
        List<GlobFolder> folders = new ArrayList<>();
        resultList.stream().map((it) -> {
            return populate(it);
        }).forEachOrdered((to) -> {
            folders.add(to);
        });
        return folders;
    }

    @Override
    public List<GlobFolder> listFolderTreeByParentIdWithRights(BigInteger parentId, BigInteger userId, String role_name) {
        String query = "SELECT * FROM ("
                + " (SELECT GF.ID, GF.PARENT_ID, GF.FIELD1, GF.PROJECT_ID, GF.F_DATE, GF.CREATED, GF.OWNER, GF.F_NAME, GF.DEFAULT_ID, GF.FOLDER_TYPE_ID, GF.F_NUMBER, GF.DEFAULT_GROUP_NUM, GF.CONTRACT_ID, GF.ACTIVE, GF.READ_ONLY, GF.F_DATE_TMP, '' METADATA, GF.VISIBLE,(SELECT COUNT(*) FROM GLOB_FOLDER F WHERE F.PARENT_ID = GF.ID) AS CANT_OF_CHILD, GF.PLAN_PROJECT_ID,"
                + " (CASE WHEN (SELECT 'Y' FROM GLOB_FOLDER_SHOW GFS WHERE GFS.TRUSTEE_ID = :uId AND GFS.TRUSTEE_TYPE = 1 AND FOLDER_ID = GF.ID) = 'Y' THEN 'Y' ELSE (CASE WHEN (SELECT R_BROWSE FROM GLOB_FOLDER_RIGHT WHERE TRUSTEE_ID = :uId AND TRUSTEE_TYPE = 1 AND FOLDER_ID = GF.ID) = 'Y' THEN 'Y' ELSE (CASE WHEN (SELECT R_BROWSE FROM GLOB_FOLDER_RIGHT WHERE TRUSTEE_ID = :uId AND TRUSTEE_TYPE = 1 AND FOLDER_ID = GF.ID) = 'N' THEN 'N' ELSE (CASE WHEN (SELECT (SELECT GR.R_BROWSE FROM GLOB_FOLDER_RIGHT GR WHERE GR.FOLDER_ID = GFF.ID AND GR.TRUSTEE_ID = :uId AND GR.TRUSTEE_TYPE = 1) AS V FROM GLOB_FOLDER GFF"
                + " WHERE GFF.ID <> GF.ID AND (SELECT GR.R_BROWSE FROM GLOB_FOLDER_RIGHT GR WHERE GR.FOLDER_ID = GFF.ID AND GR.TRUSTEE_ID = :uId AND GR.TRUSTEE_TYPE = 1) IS NOT NULL AND ROWNUM = 1 START WITH GFF.ID = GF.ID CONNECT BY PRIOR GFF.PARENT_ID = GFF.ID) = 'Y' THEN 'Y' ELSE 'N' END) END) END) END) AS IS_VISIBLE"
                + " FROM GLOB_FOLDER GF"
                + " WHERE GF.ACTIVE = 'Y'"
                + " START WITH GF.ID = :pId CONNECT BY PRIOR GF.ID = GF.PARENT_ID)"
                + " UNION"
                + " (SELECT GF.ID, GF.PARENT_ID, GF.FIELD1, GF.PROJECT_ID, GF.F_DATE, GF.CREATED, GF.OWNER, GF.F_NAME, GF.DEFAULT_ID, GF.FOLDER_TYPE_ID, GF.F_NUMBER, GF.DEFAULT_GROUP_NUM, GF.CONTRACT_ID, GF.ACTIVE, GF.READ_ONLY, GF.F_DATE_TMP, '' METADATA, GF.VISIBLE,(SELECT COUNT(*) FROM GLOB_FOLDER f WHERE f.PARENT_ID = gf.ID) as CANT_OF_CHILD, GF.PLAN_PROJECT_ID,"
                + " (CASE WHEN (SELECT 'Y' FROM GLOB_FOLDER_SHOW GFS, GLOB_ROLES R WHERE GFS.TRUSTEE_ID(+) = R.ID AND R.ROLE_NAME = :rName AND GFS.TRUSTEE_TYPE = 2 AND FOLDER_ID = GF.ID) = 'Y' THEN 'Y' ELSE (CASE WHEN (SELECT GFR.R_BROWSE FROM GLOB_FOLDER_RIGHT GFR, GLOB_ROLES R WHERE GFR.TRUSTEE_ID(+) = R.ID AND R.ROLE_NAME = :rName AND GFR.TRUSTEE_TYPE = 2 AND GFR.FOLDER_ID = GF.ID) = 'Y' THEN 'Y' ELSE (CASE WHEN (SELECT GFR.R_BROWSE FROM GLOB_FOLDER_RIGHT GFR, GLOB_ROLES R WHERE GFR.TRUSTEE_ID(+) = R.ID AND R.ROLE_NAME = :rName AND GFR.TRUSTEE_TYPE = 2 AND FOLDER_ID = GF.ID) = 'N' THEN 'N' ELSE (CASE WHEN (SELECT (SELECT GFR.R_BROWSE FROM GLOB_FOLDER_RIGHT GFR, GLOB_ROLES R WHERE GFR.FOLDER_ID = GFF.ID AND GFR.TRUSTEE_ID(+) = R.ID AND R.ROLE_NAME = :rName AND GFR.TRUSTEE_TYPE = 2) AS V FROM GLOB_FOLDER GFF"
                + " WHERE GFF.ID <> GF.ID AND (SELECT GR.R_BROWSE FROM GLOB_FOLDER_RIGHT GR, GLOB_ROLES R WHERE GR.FOLDER_ID = GFF.ID AND GR.TRUSTEE_ID(+) = R.ID AND R.ROLE_NAME = :rName AND GR.TRUSTEE_TYPE = 2) IS NOT NULL AND ROWNUM = 1 START WITH GFF.ID = GF.ID CONNECT BY PRIOR GFF.PARENT_ID = GFF.ID) = 'Y' THEN 'Y' ELSE 'N' END) END) END) END) AS IS_VISIBLE"
                + " FROM GLOB_FOLDER GF"
                + " WHERE GF.ACTIVE = 'Y'"
                + " START WITH GF.ID = :pId CONNECT BY PRIOR GF.ID = GF.PARENT_ID)"
                + " ) WHERE IS_VISIBLE = 'Y' ORDER BY TO_NUMBER(REPLACE(F_NUMBER,'.','')) ASC";
        List<Object[]> resultList = getEntityManager().createNativeQuery(query)
                .setParameter("pId", parentId)
                .setParameter("uId", userId)
                .setParameter("rName", role_name).getResultList();
        List<GlobFolder> folders = new ArrayList<>();
        resultList.stream().map((it) -> {
            return populate(it);
        }).forEachOrdered((to) -> {
            folders.add(to);
        });
        return folders;
    }

    @Override
    public List<GlobFolder> listFolderPathByParentId(BigInteger parentId) {
        List<GlobFolder> list = new ArrayList<>();
        String query = "SELECT * FROM GLOB_FOLDER START WITH ID = :pId CONNECT BY PRIOR PARENT_ID = ID AND ACTIVE = 'Y' ORDER BY ID ASC";
        list.addAll(getEntityManager().createNativeQuery(query, GlobFolder.class).setParameter("pId", parentId).getResultList());
        return list;
    }

    @Override
    public List<GlobFolder> listByIds(List<BigInteger> ids) {
        return getEntityManager().createNativeQuery("SELECT * FROM GLOB_FOLDER WHERE ID IN :ids", GlobFolder.class).setParameter("ids", ids).getResultList();
    }

    @Override
    public List<DocumentBO> listDocumentToZip(BigDecimal parentId) {
        List<GlobFolder> list = new ArrayList<>();
        String query = "SELECT FO.ID, FO.PATH, FI.F_TITLE, FI.SERVER_PATH, FI.F_NAME FROM "
                + "("
                + " SELECT "
                + "    FO.ID, "
                + "    FO.PARENT_ID,"
                + "    CONNECT_BY_ROOT FO.ID AS ROOT_ID,"
                + "    LTRIM(SYS_CONNECT_BY_PATH(decode(FO.F_NUMBER, null, '', FO.F_NUMBER || ' ') || FO.F_NAME,'-->'),'-->') AS PATH"
                + " FROM GLOB_FOLDER FO"
                + " WHERE FO.ACTIVE = 'Y'"
                //+ " START WITH FO.PARENT_ID = :pId"
                + " START WITH FO.ID = :pId"
                + " CONNECT BY FO.PARENT_ID = PRIOR FO.ID"
                + " ORDER SIBLINGS BY FO.ID "
                + ") "
                + "FO LEFT OUTER JOIN GLOB_FILE FI ON FO.ID=FI.FOLDER_ID AND FI.ACTIVE = 'Y'";

        List<Object[]> resultList = getEntityManager().createNativeQuery(query)
                .setParameter("pId", parentId)
                .getResultList();
        List<DocumentBO> documents = new ArrayList<>();
        resultList.stream().map((it) -> {
            return populateToZip(it);
        }).forEachOrdered((to) -> {
            documents.add(to);
        });
        return documents;
    }

    private GlobFolder populate(Object it) {
        if (it == null) {
            return null;
        }
        Object[] item = (Object[]) it;
        GlobFolder folder = new GlobFolder();
        folder.setId(NumberSupport.getBigDecimal(item[0]));
        folder.setParentId(NumberSupport.getBigInteger(item[1]));
        folder.setField1(StringSupport.emptyOnNull(item[2]));
        folder.setProjectId(NumberSupport.getBigInteger(item[3]));
        folder.setFDate(item[4] != null ? (Date) item[4] : null);
        folder.setCreated(item[5] != null ? (Date) item[5] : null);
        folder.setOwner(NumberSupport.getBigInteger(item[6]));
        folder.setFName(StringSupport.emptyOnNull(item[7]));
        folder.setDefaultId(NumberSupport.getBigInteger(item[8]));
        folder.setFolderTypeId(NumberSupport.getBigInteger(item[9]));
        folder.setFNumber(StringSupport.emptyOnNull(item[10]));
        folder.setDefaultGroupNum(NumberSupport.getBigInteger(item[11]));
        folder.setContractId(NumberSupport.getBigInteger(item[12]));
        folder.setActive(StringSupport.getActiveAsCharacter(StringSupport.emptyOnNull(item[13])));
        folder.setReadOnly(StringSupport.getActiveAsCharacter(StringSupport.emptyOnNull(item[14])));
        folder.setFDateTmp(item[15] != null ? DateSupport.formatUS((Date) item[15]) : null);
        folder.setMetadata(StringSupport.emptyOnNull(item[16]));
        folder.setVisible(StringSupport.emptyOnNull(item[17]));
        folder.setCantOfChild(NumberSupport.getBigInteger(item[18]));
        folder.setPlanProjectId(NumberSupport.getBigInteger(item[19]));
        return folder;
    }

    private DocumentBO populateToZip(Object it) {
        if (it == null) {
            return null;
        }
        Object[] item = (Object[]) it;
        DocumentBO obj = new DocumentBO();
        obj.setId(NumberSupport.getBigInteger(item[0]));
        obj.setTitle(StringSupport.emptyOnNull(item[2]));
        obj.setName(StringSupport.emptyOnNull(item[4]));
        obj.setServerPath(StringSupport.emptyOnNull(item[3]));
        obj.setPath(StringSupport.emptyOnNull(item[1]));
        obj.setType(StringSupport.emptyOnNull(item[3]) != null ? DocumentBO.fileType : DocumentBO.folderType);
        return obj;
    }

}
