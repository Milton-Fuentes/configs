/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.CmFlags;
import com.atser.tools.atserejb.model.GlobClient;
import com.atser.tools.atserejb.model.QmFlags;
import com.atser.tools.atserutil.objects.pojo.glob.client.ClientConfig;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobClientDaoImpl extends GenericDao<BigDecimal, GlobClient> implements GlobClientDao {

    @Override
    public Map<String, Boolean> getCmFlags(BigDecimal clientId) {
        String query = "SELECT id, FLAG_NAME, DESCRIPTION, decode(flag_value,NULL,default_value,flag_value) AS DEFAULT_VALUE FROM cm_flags LEFT JOIN \n"
                + "(SELECT flag_id, client_id, flag_value FROM cm_flags_client WHERE client_id=:clientId) client_flags \n"
                + "ON cm_flags.id=client_flags.flag_id";
        Query q = getEntityManager().createNativeQuery(query, CmFlags.class).setParameter("clientId", clientId);
        try {
            List<CmFlags> list = q.getResultList();
            return list.stream().collect(Collectors.toMap(CmFlags::getFlagName, CmFlags::getDefaultValueAsBoolean));
        } catch (NoResultException ex) {
            return new HashMap<>();
        }
    }

    @Override
    public Map<String, Boolean> getQmFlags(BigDecimal clientId) {
        String query = "SELECT id, FLAG_NAME, DESCRIPTION, decode(flag_value,NULL,default_value,flag_value) AS DEFAULT_VALUE FROM qm_flags LEFT JOIN \n"
                + "(SELECT flag_id, client_id, flag_value FROM qm_flags_client WHERE client_id=:clientId) client_flags \n"
                + "ON qm_flags.id=client_flags.flag_id";
        Query q = getEntityManager().createNativeQuery(query, QmFlags.class).setParameter("clientId", clientId);
        try {
            List<QmFlags> list = q.getResultList();
            return list.stream().collect(Collectors.toMap(QmFlags::getFlagName, QmFlags::getDefaultValueAsBoolean));
        } catch (NoResultException ex) {
            return new HashMap<>();
        }
    }

    @Override
    public ClientConfig getClientConfig(BigDecimal clientId) {
        String query = "SELECT client_config FROM glob_client WHERE id = :clientId AND active = 'Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId);
        try {
            try {
                String json = StringSupport.getStringFromClob((Clob) q.getSingleResult());
                if (StringSupport.isNullOrEmpty(json)) {
                    return new ClientConfig();
                } else {
                    ObjectMapper oMapper = new ObjectMapper();
                    return oMapper.readValue(json, ClientConfig.class);
                }
            } catch (IOException | SQLException ex) {
                return new ClientConfig();
            }
        } catch (NoResultException ex) {
            return new ClientConfig();
        }
    }

    @Override
    public String getStringClientConfig(BigDecimal clientId) {
        String query = "SELECT client_config FROM glob_client WHERE id = :clientId AND active = 'Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId);
        try {
            try {
                return StringSupport.getStringFromClob((Clob) q.getSingleResult());
            } catch (IOException | SQLException ex) {
                return StringSupport.STRING_EMPTY;
            }
        } catch (NoResultException ex) {
            return StringSupport.STRING_EMPTY;
        }
    }

    @Override
    public List<DataSelectWrapper> getBidITClientListForDropdown() {
        List<GlobClient> clients = getEntityManager().createNamedQuery("GlobClient.showBidITList")
                .setParameter("active", 'Y')
                .setParameter("showbidit", 'Y')
                .getResultList();
        if (clients == null || clients.isEmpty()) {
            return new ArrayList<>();
        }
        return clients.stream().map(c -> new DataSelectWrapper(c.getCompanyName(), c.getName())).collect(Collectors.toList());
    }
}
