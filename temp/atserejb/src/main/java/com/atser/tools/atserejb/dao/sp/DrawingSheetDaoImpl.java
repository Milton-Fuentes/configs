/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.sp;

import com.atser.tools.atserutil.objects.to.gateway.DrawingSheetTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DrawingSheetDaoImpl implements DrawingSheetDao {

    @PersistenceContext(unitName = "com.atser.tools_atseree-ejb_ejb_0.1.0PU")
    EntityManager em;

    @Override
    public List<DrawingSheetTO> filter(String pNumber, String serverDomain) {
        String query = "SELECT t.sheet_no,t.group_name,t.brg_no catg,t.sheet_title, t.subgroup_name,t.omitted,t.ifc_rev,t.sheet_rev,t.ndc_no, t.client_id, t.project_id, t.pkg_id, t.orgsheet_id_ref sheet_id, t.last_mod, t.pkg_name "
                + "FROM vw_dwg_sheets t WHERE t.p_number=:pNumber ORDER BY group_order, to_number(substr(regexp_replace(ltrim(replace(t.sheet_no,'_','.'),'0'), '[^0-9-.]', NULL),0,9)), t.sheet_no, decode(ltrim(t.brg_no) ,null,'0',t.brg_no) , "
                + "decode(ltrim(t.subgroup_name) ,null,'0',t.subgroup_name)";

        List<Object[]> objects = em.createNativeQuery(query)
                .setParameter("pNumber", pNumber)
                .getResultList();
        return populateDataTO(objects, serverDomain);
    }
    
    private List<DrawingSheetTO> populateDataTO(List<Object[]> objects, String serverDomain) {
        List<DrawingSheetTO> list = new ArrayList<>();
        String baselink = serverDomain + "/cc/cm/dwg_sheet_version.jsp?";
        objects.stream().map((it) -> {
            DrawingSheetTO to = new DrawingSheetTO();
            to.setSheetNo(StringSupport.emptyOnNull(it[0]));
            to.setGroupName(StringSupport.emptyOnNull(it[1]));
            to.setCatg(StringSupport.emptyOnNull(it[2]));
            to.setSheetTitle(StringSupport.emptyOnNull(it[3]));
            to.setSubGroupName(StringSupport.emptyOnNull(it[4]));
            to.setOmitted(StringSupport.emptyOnNull(it[5]));
            to.setIfcRev(StringSupport.emptyOnNull(it[6]));
            to.setSheetRev(StringSupport.emptyOnNull(it[7]));
            to.setNdcNo(StringSupport.emptyOnNull(it[8]));
            to.setClientId(StringSupport.emptyOnNull(it[9]));
            to.setProjectId(StringSupport.emptyOnNull(it[10]));
            to.setPkgId(StringSupport.emptyOnNull(it[11]));
            to.setSheetId(StringSupport.emptyOnNull(it[12]));
            to.setLastMod(StringSupport.emptyOnNull(it[13]));
            to.setPkgName(StringSupport.emptyOnNull(it[14]));
            to.buildSheetLink(baselink);
            return to;
        }).forEachOrdered((to) -> {
            list.add(to);
        });

        return list;
    }

}
