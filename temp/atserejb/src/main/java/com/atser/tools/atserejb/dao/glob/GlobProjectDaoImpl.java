/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.project.ProjectBO;
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
public class GlobProjectDaoImpl extends GenericDao<BigDecimal, GlobProject> implements GlobProjectDao {

    @Override
    public BigDecimal findIdByClientAndPNumber(BigDecimal clientId, String contractNo) {
        String query = "SELECT ID FROM GLOB_PROJECT WHERE client_id = :clientId AND p_number = :contractNo AND active = 'Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("contractNo", contractNo);
        try {
            return (BigDecimal) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    /**
     * Get Project List in Lab
     *
     * @param clientId
     * @return [ID, PROJECT_NO, PROJECT_NAME]
     */
    @Override
    public List<Object[]> getProjectListInLab(BigInteger clientId) {
        String query = "SELECT id, '('||p_number || ') ' || p_name project_no, p_name project_name FROM glob_project WHERE client_id=:clientId AND id IN (SELECT project_id FROM glob_info WHERE glob_info.lab_id IS NOT NULL) ORDER BY p_number";
        try {
            return getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    /**
     * Get Filter for Project by User
     *
     * @param parentFieldFilter (Ex: i.project_id)
     * @param isAdmin
     * @param usesGlobalProfiles
     * @param clientId
     * @param userId
     * @return Filter
     */
    @Override
    public String filterByProfile(String parentFieldFilter, boolean isAdmin, boolean usesGlobalProfiles, String clientId, String userId) {
        StringBuilder fp = new StringBuilder();
        if (!isAdmin) {
            if (usesGlobalProfiles) {
                //filter_by_profile = " (SELECT DISTINCT PROJECT_ID FROM GLOB_INFO_DETAIL rz7i WHERE rz7i.CLIENT_ID=" + clientId + " AND (rz7i.LAB_ID IN (SELECT LAB_ID FROM GLOB_PROFILES WHERE PROJECT_ID=-99 AND USER_ID=" + userId + ") " + " OR rz7i.PROJECT_ID IN (SELECT PROJECT_ID FROM GLOB_PROFILES WHERE USER_ID=" + userId + ")))";
                fp.append(parentFieldFilter).append(" IN ( SELECT DISTINCT PROJECT_ID FROM GLOB_INFO_DETAIL rz7i WHERE rz7i.CLIENT_ID=").append(clientId);
                fp.append(" AND (rz7i.LAB_ID IN (SELECT LAB_ID FROM GLOB_PROFILES WHERE PROJECT_ID=-99 AND USER_ID=").append(userId).append("))) ");
                fp.append(" OR ").append(parentFieldFilter).append(" IN (SELECT NVL(PROJECT_ID,-99) PROJECT_ID FROM GLOB_PROFILES WHERE USER_ID=").append(userId).append(" AND MODULE_ID = 21)");
            } else {
                fp.append(parentFieldFilter).append(" IN (SELECT PROJECT_ID FROM GLOB_PROFILES WHERE USER_ID=").append(userId).append(")");
            }
        }
        return fp.toString();
    }

    /**
     * Get Project List by Profile
     *
     * @param userId
     * @param clientId
     * @param currentRole
     * @param isAdmin
     * @param multiproject
     * @param project_uses_multiple_location
     * @param uses_global_profiles
     * @param ProjectSetup
     * @param uses_allow_readonly_labs
     * @param status
     * @return
     */
    @Override
    public List<ProjectBO> getFrontEndProjectListByCurrentProfile(String userId, String clientId, String currentRole, boolean isAdmin, boolean multiproject, boolean project_uses_multiple_location, boolean uses_global_profiles, boolean ProjectSetup, boolean uses_allow_readonly_labs, String status) {
        String query = buildProjectsQuery(userId, clientId, currentRole, isAdmin, multiproject, project_uses_multiple_location, uses_global_profiles, ProjectSetup, uses_allow_readonly_labs, status);
        try {
            List<Object[]> objects = getEntityManager().createNativeQuery(query).getResultList();
            return populateProjectBo(objects);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<ProjectBO> populateProjectBo(List<Object[]> objects) {
        List<ProjectBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            ProjectBO p = new ProjectBO();
            p.setRegion(StringSupport.emptyOnNull(it[0]));
            p.setDivision(StringSupport.emptyOnNull(it[1]));
            p.setLocation(StringSupport.emptyOnNull(it[2]));
            p.setId((StringSupport.isNullOrEmpty(it[3])) ? null : NumberSupport.getBigInteger(it[3]));
            p.setNumber(StringSupport.emptyOnNull(it[4]));
            p.setName(StringSupport.emptyOnNull(it[5]));
            p.setDescription(StringSupport.emptyOnNull(it[6]));
            p.setStatus(StringSupport.emptyOnNull(it[7]));
            p.setContratorName(StringSupport.emptyOnNull(it[8]));
            p.setEndDate(it[9] != null ? DateSupport.formatDate((Date) it[9], DateSupport.FORMAT_US) : "");
            p.setProjectNo(StringSupport.emptyOnNull(it[10]));
            p.setType(StringSupport.emptyOnNull(it[11]));
            p.setContractorId((StringSupport.isNullOrEmpty(it[12])) ? null : NumberSupport.getBigInteger(it[12]));
            p.setRegionId((StringSupport.isNullOrEmpty(it[13])) ? null : NumberSupport.getBigInteger(it[13]));
            p.setDivisionId((StringSupport.isNullOrEmpty(it[14])) ? null : NumberSupport.getBigInteger(it[14]));
            p.setLocationId((StringSupport.isNullOrEmpty(it[15])) ? null : NumberSupport.getBigInteger(it[15]));
            p.setProjectClientId((StringSupport.isNullOrEmpty(it[16])) ? null : NumberSupport.getBigInteger(it[16]));
            p.setDepartmentId(StringSupport.emptyOnNull(it[17]));
            p.setPersonProjectManager((StringSupport.isNullOrEmpty(it[18])) ? null : NumberSupport.getBigInteger(it[18]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    /**
     * Build the Query.
     *
     * @param userId
     * @param clientId
     * @param currentRole
     * @param isAdmin
     * @param multiproject
     * @param project_uses_multiple_location
     * @param uses_global_profiles
     * @param ProjectSetup
     * @param uses_allow_readonly_labs
     * @param status
     * @return
     */
    private String buildProjectsQuery(String userId, String clientId, String currentRole, boolean isAdmin, boolean multiproject, boolean project_uses_multiple_location, boolean uses_global_profiles, boolean ProjectSetup, boolean uses_allow_readonly_labs, String status) {
        String query = "select ";
        String fieldLine = "";
        String countOnly = "count(*) cnt ";
        String tailLine = "";
        String whereClase = "";
        if (multiproject) {
            fieldLine = "decode(cr.short_name, null,cr.name,cr.short_name || ' - ' || cr.name) as region, cd.division, p.location, p.id, p.p_number, p.p_name, p.p_description, p.active, gcp.contractor, p.end_date, p.p_job_no, p.type_project, p.contractor_id, p.region_id, cr.division_id, p.office_location, p.project_client_id, p.department_id, p.person_project_manager ";
            tailLine = "from glob_project p, glob_client_regions cr, glob_client_divisions cd, glob_client_office_location co, glob_contractor_personnel gcp ";
            whereClase = "where p.region_id=cr.id(+) and p.client_id=" + clientId + " and p.active='" + status + "' and p.contractor_id = gcp.id(+) and cr.division_id=cd.id(+) and p.office_location=co.id(+) and (p.has_lab='Y' or (p.program_id is null and p.p_type='Construction')) ";
            if (!isAdmin) {
                if (uses_global_profiles) {
                    String add_filter = (ProjectSetup) ? "i.project_id not in (select project_id from glob_info_detail where i.client_id=" + clientId + " and lab_id is not null) or " : "";
                    whereClase += " and p.id in ( select project_id from glob_info_detail i where i.client_id=" + clientId + " and (" + add_filter + " i.lab_id in (select lab_id from glob_profiles where project_id=-99 and user_id=" + userId + ") or i.project_id in ( select project_id  from glob_profiles where user_id=" + userId + " ) ) )";
                    whereClase += " and p.id not in (select project_id from global_profile_proj_no_access where user_id=" + userId + ")";
                } else {
                    whereClase += " and p.id in (select project_id from glob_profiles where user_id=" + userId + ")";
                }
            }
            if ("region_admin".equals(currentRole)) {
                whereClase += " and p.region_id=(select region_id from glob_users u, glob_contact c where u.contactid=c.id and u.id=" + userId + ")";
            }
            tailLine += whereClase;
            query = query + countOnly + " from (select distinct p.id " + tailLine + ")";
        } else if (project_uses_multiple_location) {
            fieldLine = "p.id, p.p_number, p.p_name, p.p_description, p.active, p.end_date, p.p_job_no, p.type_project, p.contractor_id, p.location ";
            tailLine = "from glob_project p ";
            whereClase = "where p.client_id=" + clientId + " and p.active='" + status + "' and (p.has_lab='Y' or (p.program_id is null and p.p_type='Construction')) ";
            if (!uses_allow_readonly_labs && !("client_admin".equals(currentRole) || "district_admin".equals(currentRole))) {
                tailLine += ", glob_profiles pr ";
                whereClase += " and p.id=pr.project_id and pr.user_id=" + userId;
            }
            tailLine += whereClase;
            query = query + countOnly + " from (select distinct p.id " + tailLine + ")";
        } else {
            fieldLine = "decode(cr.short_name, null,cr.name,cr.short_name || ' - ' || cr.name) as region, cd.division, p.location, p.id, p.p_number, p.p_name, p.p_description, p.active, gcp.contractor, p.end_date, p.p_job_no, p.type_project, p.contractor_id, p.region_id, cr.division_id, p.office_location, p.project_client_id, p.department_id, p.person_project_manager ";
            tailLine = "from glob_project p, glob_client_regions cr, glob_client_divisions cd, glob_client_office_location co, glob_contractor_personnel gcp ";
            whereClase = "where p.region_id=cr.id(+) and p.client_id=" + clientId + " and p.active='" + status + "' and p.contractor_id = gcp.id(+) and cr.division_id=cd.id(+) and p.office_location=co.id(+) and (p.has_lab='Y' or (p.program_id is null and p.p_type='Construction')) ";
            if (!uses_allow_readonly_labs && !("client_admin".equals(currentRole) || "district_admin".equals(currentRole))) {
                tailLine += ", glob_profiles pr ";
                whereClase += " and p.id=pr.project_id and pr.user_id=" + userId;
            }
            tailLine += whereClase;
            query = query + countOnly + " from (select distinct p.id " + tailLine + ")";
        }
        if (project_uses_multiple_location) {
            query = "select distinct " + fieldLine + tailLine;
            query = "select decode(cr.short_name, null,cr.name,cr.short_name || ' - ' || cr.name) as region, cd.division, p2.location, p2.id, p2.p_number, p2.p_name, p2.p_description, p2.active, gcp.contractor, p2.end_date, p2.p_job_no, p2.type_project, p2.contractor_id, p2.region_id, cr.division_id, p2.office_location, p2.project_client_id, p2.department_id, p2.person_project_manager "
                    + " from (" + query + ") p2, glob_project_location pl, glob_client_regions cr, glob_client_divisions cd, glob_client_office_location co, glob_contractor_personnel gcp "
                    + " where p2.id=pl.project_id and pl.office_location_id=co.id and co.region_id=cr.id and cr.division_id=cd.id(+) and p2.contractor_id = gcp.id(+) ";
        } else {
            query = "select distinct " + fieldLine + tailLine;
        }
        return query;
    }

    /**
     * Get Project List by Function or Project Client Name
     *
     * @param userId
     * @param clientId
     * @param isAdmin
     * @param uses_global_profiles
     * @param functionId
     * @param projectClientId
     * @return
     */
    @Override
    public List<GlobProject> getFrontEndProjectListByFunctionProfile(String userId, String clientId, boolean isAdmin, boolean uses_global_profiles, String functionId, String projectClientId) {
        String query = buildProjectClientQuery(userId, clientId, isAdmin, uses_global_profiles, functionId, projectClientId);
        try {
            Query hquery = getEntityManager().createNativeQuery(query, GlobProject.class);
            if (StringSupport.isNullOrEmpty(projectClientId)) {
                hquery.setParameter("clientId", clientId);
            } else {
                hquery.setParameter("projectClientId", projectClientId);
            }
            return hquery.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    private String buildProjectClientQuery(String userId, String clientId, boolean isAdmin, boolean uses_global_profiles, String functionId, String projectClientId) {
        StringBuilder queryBuilder = new StringBuilder();

        if (StringSupport.isNullOrEmpty(projectClientId)) {
            queryBuilder.append("select * from glob_project where client_id = :clientId and active='Y' ");
        } else {
            queryBuilder.append("select * from glob_project where project_client_id = :projectClientId and active='Y' ");
        }

        // Filter by Profile
        String filter_by_profile = filterByProfile(" id", isAdmin, uses_global_profiles, clientId, userId);
        if (!filter_by_profile.isEmpty()) {
            queryBuilder.append(" AND ( ").append(filter_by_profile).append(" ) ");
        }
        // Filter by Function
        if (StringSupport.isNotNullAndNotEmpty(functionId)) {
            queryBuilder.append(" AND ID IN (select project_id from glob_info where function_id = ").append(functionId).append(") ");
        }

        if (StringSupport.isNullOrEmpty(projectClientId)) {
            // Order By    
            queryBuilder.append("  ORDER BY office_location,department_id,project_code, p_number ");
        } else {
            // Order By    
            queryBuilder.append("  ORDER BY office_location,department_id,project_code ");
        }

        return queryBuilder.toString();
    }

    @Override
    public Boolean exists(String clientId, String pNumberCode, Boolean useProjectCode) {

        String query = "SELECT p.id FROM glob_project p WHERE  p.client_id = :clientId AND p.p_number = :pNumberCode AND p.active='Y'";
        if (useProjectCode) {      
          //some projects use p_number_code instead of p_number
            query = "SELECT p.id FROM glob_project p WHERE  p.client_id = :clientId AND p.p_number_code = :pNumberCode AND p.active='Y'";
        }
        Query q = getEntityManager().createNativeQuery(query).setParameter("pNumberCode", pNumberCode).setParameter("clientId", clientId);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }
}
