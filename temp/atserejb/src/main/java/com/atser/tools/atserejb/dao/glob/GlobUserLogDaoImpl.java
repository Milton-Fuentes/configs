/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.to.GlobUsersLogTo;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GlobUserLogDaoImpl implements GlobUserLogDao {

    @PersistenceContext(unitName = "com.atser.tools_atseree-ejb_ejb_0.1.0PU")
    EntityManager em;

    @Override
    public List<GlobUsersLogTo> findAll() {

        List<GlobUsersLogTo> list = new ArrayList<>();

        @SuppressWarnings("unchecked")
        List<Object> objs = em.createNativeQuery("SELECT t.* FROM glob_user_log t").getResultList();
        objs.forEach((obj) -> {
            list.add(createDto(obj));
        });
        return list;
    }

    private GlobUsersLogTo createDto(Object... items) {
        Object[] obj = (Object[]) items[0];
        GlobUsersLogTo item = new GlobUsersLogTo();
        item.setUserid(String.valueOf(obj[0]));
        if (obj != null && obj.length > 1 && obj[1] != null && !Objects.toString(obj[1]).isEmpty()) {
            item.setLogged_on(DateSupport.getDateFromTimeStamp((Timestamp) obj[1]));
        }

        item.setSession_id(String.valueOf(obj[2]));

        if (obj != null && obj.length > 2 && obj[3] != null && !Objects.toString(obj[3]).isEmpty()) {
            item.setLogged_off(DateSupport.getDateFromTimeStamp((Timestamp) obj[3]));
        }

        if (obj != null && obj.length > 3 && obj[4] != null && !Objects.toString(obj[4]).isEmpty()) {
            item.setLogged_off_timeout(DateSupport.getDateFromTimeStamp((Timestamp) obj[4]));
        }
        return item;
    }

    @Override
    public List<GlobUsersLogTo> findAllActualDay() {
        List<GlobUsersLogTo> list = new ArrayList<>();

        @SuppressWarnings("unchecked")
        List<Object> objs = em.createNativeQuery("SELECT t.* FROM glob_user_log t where t.LOGGED_ON > (SYSDATE-1)").getResultList();
        objs.forEach((obj) -> {
            list.add(createDto(obj));
        });
        return list;
    }

    @Override
    public GlobUsersLogTo findBySessionId(String sessionid) {
        List<Object> objs = em.createNativeQuery("SELECT t.* FROM glob_user_log t where t.SESSION_ID = '" + sessionid + "' AND t.LOGGED_OFF IS NULL AND TRUNC(t.LOGGED_ON) = TRUNC(SYSDATE) ORDER BY t.LOGGED_ON DESC").getResultList();
        if (objs != null && objs.size() > 0) {
            return createDto(objs.get(0));
        }
        return null;
    }

}
