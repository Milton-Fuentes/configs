/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobClientDao;
import com.atser.tools.atserejb.model.GlobClient;
import com.atser.tools.atserejb.model.GlobFlags;
import com.atser.tools.atserejb.model.GlobModule;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.glob.client.ClientConfig;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class GlobClientServiceImpl implements GlobClientService, IBaseEJBException {

    @Inject
    private GlobClientDao dao;

    @Inject
    private GlobFlagsService globFlagsService;

    @Inject
    private GlobModuleService globModuleService;

    @Override
    public GlobClient findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobClient findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobClient elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobClient elem) {
        if (elem != null) {
            GlobClient model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobClient> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    /**
     * Find ClientId by CompanyName
     *
     * @param name
     * @return NULL is the name does not exists;
     */
    @Override
    public Optional<GlobClient> findByCompanyName(String name) {
        List<GlobClient> response = list(new ManageITBodyRequest(0, 0).filter("companyName", name));
        if (response != null & !response.isEmpty()) {
            return Optional.ofNullable(response.get(0));
        }
        return Optional.empty();
    }

    @Override
    public Map<String, Boolean> getMapFlags(String clientId) {
        return getMapFlags(clientId, null);
    }

    @Override
    public Map<String, Boolean> getMapFlags(String clientId, String moduleName) {
        if (StringSupport.isNullOrEmpty(clientId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        Map<String, Boolean> flags = new HashMap<>();
        GlobClient client = findById(clientId);
        BigDecimal moduleId = null;
        if (StringSupport.isNotNullAndNotEmpty(moduleName)) {
            GlobModule module = globModuleService.findByModuleName(moduleName);
            if (module != null) {
                moduleId = module.getId();
            }
        }
        if (client != null) {
            flags.putAll(dao.getCmFlags(NumberSupport.getBigDecimal(clientId)));
            flags.putAll(dao.getQmFlags(NumberSupport.getBigDecimal(clientId)));
            if (client.getHasFlags() == 'Y') {
                GlobFlags globFlag = globFlagsService.findById(NumberSupport.getBigDecimal(client.getFlagId()));
                if (globFlag != null) {
                    flags.putAll(globFlag.getFlagsMap(moduleId));
                }
            }
        }
        return flags;
    }

    /*
    private Map<String, Character> getGlobalFlagsModule(BigInteger flagId, String moduleName) {
        String query = "SELECT * FROM glob_flags_module WHERE flag_id = :flagId AND module_id = (SELECT id FROM glob_module WHERE module_name IN (:moduleName))";
        Query q = getEntityManager().createNativeQuery(query, CmFlags.class).setParameter("flagId", flagId).setParameter("moduleName", moduleName);
        try {
            List<CmFlags> list = q.getResultList();
            return list.stream().collect(Collectors.toMap(CmFlags::getFlagName, CmFlags::getDefaultValue));
        } catch (NoResultException ex) {
            return new HashMap<>();
        }
    }
    
     */
    /**
     * Generate Sequence Number
     *
     * @param clientId
     * @param currentNo
     * @param functionality [inspection, sample, test]
     * @return
     */
    @Override
    public String generateSequencialNumber(String clientId, BigInteger currentNo, String functionality) {
        GlobClient clientObj = findById(clientId);
        if (clientObj == null || currentNo == null || StringSupport.isNullOrEmpty(functionality)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        switch (functionality) {
            case "sample": {
                if (StringSupport.isNotNullAndNotEmpty(clientObj.getCompanyName()) && clientObj.getCompanyName().equals("massdot")) {
                    String format = new DecimalFormat("#000000").format(currentNo);
                    return (DateSupport.formatDate(new Date(), DateSupport.factorySimpleDateFormat("yyyy")) + "-" + format);
                }
                break;
            }
            case "test": {
                break;
            }
            case "inspection": {
                if (StringSupport.isNotNullAndNotEmpty(clientObj.getCompanyName()) && clientObj.getCompanyName().equals("massdot")) {
                    String format = new DecimalFormat("#000000").format(currentNo);
                    return ("I-" + DateSupport.formatDate(new Date(), DateSupport.factorySimpleDateFormat("yyyy")) + "-" + format);
                }
                break;
            }
            default: {
                String format = new DecimalFormat("#000000").format(currentNo);
                String prefix = (functionality.charAt(0) + "-").toUpperCase();
                return (prefix + DateSupport.formatDate(new Date(), DateSupport.factorySimpleDateFormat("yyyy")) + "-" + format);
            }
        }
        return null;
    }

    @Override
    public ClientConfig getClientConfig(BigDecimal clientId) {
        if (clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getClientConfig(clientId);
    }

    @Override
    public String getStringClientConfig(BigDecimal clientId) {
        if (clientId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getStringClientConfig(clientId);
    }

    @Override
    public List<DataSelectWrapper> getBidITClientListForDropdown() {
        return dao.getBidITClientListForDropdown();
    }
}
