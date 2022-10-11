/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobFolderDefaultLink;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobFolderDefaultLinkDaoImpl extends GenericDao<BigDecimal, GlobFolderDefaultLink> implements GlobFolderDefaultLinkDao {

    @Override
    public GlobFolderDefaultLink getByFolderIdAndGroup(BigInteger folderId, BigInteger groupNumber) {
        String query = "select fdl.* from glob_folder f "
                + "inner join glob_folder_default fd on f.default_id = fd.id "
                + "inner join glob_folder_default_link fdl on fd.id = fdl.child_id and fdl.parent_id = (select default_id from glob_folder where id = f.parent_id)"
                + "where f.id = :fId and fdl.group_number = :fGroup";
        Query q = getEntityManager().createNativeQuery(query, GlobFolderDefaultLink.class)
                .setParameter("fId", folderId)
                .setParameter("fGroup", groupNumber);
        try {
            return (GlobFolderDefaultLink) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
