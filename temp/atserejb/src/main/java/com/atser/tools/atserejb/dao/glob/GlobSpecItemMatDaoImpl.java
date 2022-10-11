/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobSpecItemMat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobSpecItemMatDaoImpl extends GenericDao<BigDecimal, GlobSpecItemMat> implements GlobSpecItemMatDao {

    @Override
    public String getSpecItemMatNameByItemNo(BigInteger projectId, String itemType, String specItemNo) {
        String query = "SELECT distinct m.material || ' (' || i.item_no || ')' as category FROM  glob_spec_book_item i ,glob_spec_book_sect s, glob_spec_book_mat m, glob_spec_item_mat imc, "
                + "glob_spec_book_proj sbp, glob_spec_book_itemtype t where  sbp.spec_book_id=s.spec_book_id and s.id = imc.section_id and imc.mat_id = m.id and imc.item_id = i.id and imc.itemtype_id = t.id "
                + "and sbp.project_id = :projectId and t.item_type = :itemType AND i.item_no = :specItemNo";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("projectId", projectId)
                .setParameter("itemType", itemType)
                .setParameter("specItemNo", specItemNo);
        try {
            return (String) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobSpecItemMat> getSpecItemMatByItemNo(BigInteger projectId, String itemType, String specItemNo) {
        String query = "SELECT DISTINCT imc.*  FROM  glob_spec_book_item i ,glob_spec_book_sect s, glob_spec_item_mat imc, glob_spec_book_itemtype t, "
                + "glob_spec_book_proj sbp WHERE s.id = imc.section_id AND imc.item_id = i.id AND t.id = imc.itemtype_id AND sbp.spec_book_id = s.spec_book_id AND sbp.project_id = :projectId AND t.item_type= :itemType "
                + "AND i.item_no = :specItemNo";
        Query q = getEntityManager().createNativeQuery(query, GlobSpecItemMat.class)
                .setParameter("projectId", projectId)
                .setParameter("itemType", itemType)
                .setParameter("specItemNo", specItemNo);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
