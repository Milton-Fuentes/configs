/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.jpa;

import com.atser.tools.atserutil.annotation.QmsOldVersion;
import com.atser.tools.atserutil.objects.pojo.DefaultDefParam;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITFilter;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITPaging;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITSorted;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;

/**
 *
 * @author droldan
 * @param <PK>
 * @param <T>
 */
public abstract class GenericDao<PK extends Serializable, T> {

    @PersistenceContext(unitName = "com.atser.tools_atseree-ejb_ejb_0.1.0PU")
    EntityManager entityManager;

    @PersistenceContext(unitName = "com.atser.tools_atseree-ejb_ejb_0.2.0PU")
    EntityManager entityManagerOldVersioning;

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public GenericDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    private Field getFieldByFieldName(String fieldName) {
        Field field;
        try {
            field = persistentClass.getDeclaredField(fieldName);
            if (field != null) {
                return field;
            }
        } catch (NoSuchFieldException | SecurityException ex) {
            return null;
        }
        return null;
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected EntityManager getEntityManagerOldVersioning() {
        return this.entityManagerOldVersioning;
    }

    protected Session getSessionFromEntityManager() {
        return this.entityManager.unwrap(Session.class);
    }

    protected Session getSessionFromEntityManagerOldVersioning() {
        return this.entityManagerOldVersioning.unwrap(Session.class);
    }

    protected AuditReader getAuditReader() {
        return AuditReaderFactory.get(entityManager);
    }

    public T findById(PK key) {
        return (T) entityManager.find(persistentClass, key);
    }

    public Boolean existById(PK key) {
        return findById(key) == null ? Boolean.FALSE : Boolean.TRUE;
    }

    /**
     * Batch Persist
     *
     * @param entities
     */
    public void save(List<T> entities) {
        int batchSize = 100;
        try {
            for (int i = 0; i < entities.size(); i++) {
                if (i > 0 && i % batchSize == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
                entityManager.persist(entities.get(i));
            }

        } catch (RuntimeException e) {
            throw e;
        } finally {
            entityManager.flush();
            entityManager.clear();
        }
    }

    /**
     * Persist
     *
     * @param entity
     * @return
     */
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    /**
     * Update Entity
     *
     * @param entity
     */
    public void update(T entity) {
        if (persistentClass.isAnnotationPresent(QmsOldVersion.class)) {
            Field versionField = getFieldByFieldName("version");
            versionField.setAccessible(true);
            try {
                versionField.set(entity, StringSupport.getNextVersion(StringSupport.getString(versionField.get(entity))));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            entityManager.merge(entity);
            doOldVersioning(entity);
        } else {
            entityManager.merge(entity);
        }
    }

    public List<T> findAll() {
        return getEntityManager().createNamedQuery(this.persistentClass.getSimpleName() + ".findAll").getResultList();
    }

    /**
     * Delete
     *
     * @param entity
     */
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void delete(PK id) {
        T elem = (T) getEntityManager()
                .createNamedQuery(this.persistentClass.getSimpleName() + ".findById")
                .setParameter("id", id)
                .getSingleResult();
        delete(elem);
    }
    
    protected void initializeList(List<?> lazyList) {
        if (lazyList == null) {
            return;
        }
        lazyList.size();
    }

    public void clearAndFlushSession() {
        try {
            entityManager.flush();
        } catch (PersistenceException ex) {
            System.out.println("ERROR: PersistenceException when try to flush.");
        }        
        /*try {
            entityManager.flush();
            entityManager.clear();
        } catch (TransactionRequiredException ex) {
            entityManager.clear();
        } catch (PersistenceException ex) {
            entityManager.clear();
        }*/
    }

    /**
     * Apply Criteria Filters
     *
     * @param filter
     * @param sorted
     * @return
     */
    public List<T> filter(List<ManageITFilter<?>> filter, List<ManageITSorted> sorted) {
        return filter(filter, sorted, null);
    }

    /**
     * Apply Criteria Filters
     *
     * @param filter
     * @param sorted
     * @param paging
     * @return
     */
    public List<T> filter(List<ManageITFilter<?>> filter, List<ManageITSorted> sorted, ManageITPaging paging) {
        JPADataModel<T> jpamodel = new JPADataModel<>(getEntityManager(), persistentClass, filter, sorted);
        CriteriaQuery<T> criteriaQuery = jpamodel.createSelectCriteriaQuery();
        TypedQuery<T> query = getEntityManager().createQuery(criteriaQuery);
        List<T> data;
        if (paging == null || paging.getMaxResults() <= 0) {
            data = query.getResultList();
        } else {
            data = query.setFirstResult(paging.getStartIndex()).setMaxResults(paging.getMaxResults()).getResultList();
        }
        return data;
    }

    /**
     * Count Function using ManageITFilter
     *
     * @param filter
     * @return
     */
    public Long getTotal(List<ManageITFilter<?>> filter) {
        JPADataModel<T> jpamodel = new JPADataModel<>(getEntityManager(), persistentClass, filter, null);
        CriteriaQuery<Long> criteriaQueryCount = jpamodel.createCountCriteriaQuery();
        TypedQuery<Long> queryCount = getEntityManager().createQuery(criteriaQueryCount);
        Long total = queryCount.getSingleResult();
        return total;
    }

    /**
     * Count Function using String query
     *
     * @param query
     * @return
     */
    public Long getTotal(String query) {
        Query q = getEntityManager().createNativeQuery(query);
        try {
            BigDecimal cnt = (BigDecimal) q.getSingleResult();
            if (cnt != null) {
                return cnt.longValue();
            }
            return 0l;
        } catch (NoResultException ex) {
            return 0l;
        }
    }

    /**
     * Get Max ID
     *
     * @param filter
     * @return
     */
    public Long maxId(List<ManageITFilter<?>> filter) {
        JPADataModel<T> jpamodel = new JPADataModel<>(getEntityManager(), persistentClass, filter, null);
        CriteriaQuery<Number> criteriaQueryCount = jpamodel.createMaxIdCriteriaQuery();
        TypedQuery<Number> queryCount = getEntityManager().createQuery(criteriaQueryCount);
        Number entity = queryCount.getSingleResult();
        return entity.longValue();
    }

    /**
     * Wrap Query to Server Side
     *
     * @param query
     * @param orderLine
     * @param filters
     * @return
     */
    protected String wrapToServerSide(String query, String orderLine, DefaultDefParam filters) {
        return wrapToServerSide(query, orderLine, filters.startIndex, filters.maxResults, null);
    }

    /**
     * Wrap Query to Server Side With Extra Fields
     *
     * @param query
     * @param orderLine
     * @param filters
     * @param extraFields
     * @return
     */
    protected String wrapToServerSide(String query, String orderLine, DefaultDefParam filters, String[] extraFields) {
        return wrapToServerSide(query, orderLine, filters.startIndex, filters.maxResults, extraFields);
    }

    /**
     * Wrap Query to Server Side
     *
     * @param query
     * @param orderLine
     * @param startIndex
     * @param maxResults
     * @param extraFields
     * @return
     */
    protected String wrapToServerSide(String query, String orderLine, Integer startIndex, Integer maxResults, String[] extraFields) {
        String rquery = "select tbr_7017.* ";
        if (extraFields != null && extraFields.length > 0) {
            for (String xf : extraFields) {
                rquery += ", " + xf + " ";
            }
        }
        rquery += " , row_number() over(" + orderLine + ") as rn from (" + query + ") tbr_7017";
        rquery = "select * from (" + rquery + ") ";
        if (maxResults > 0) {
            rquery = rquery + " where rn between " + (startIndex + 1) + " and " + (startIndex + maxResults) + orderLine;
        } else {
            rquery = rquery + orderLine;
        }
        return rquery;
    }

    /*-------------------------------------------------------------------------
      ----------------- Versioning --------------------------------------------
      -------------------------------------------------------------------------*/
    public Object getVersion(Integer number) {
        try {
            return getAuditReader().createQuery().forEntitiesAtRevision(persistentClass, number).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List getRevisions(PK key) {
        List revisions = getAuditReader().createQuery().forRevisionsOfEntity(persistentClass, false, true)
                .add(AuditEntity.id().eq(key))
                .addOrder(AuditEntity.revisionNumber().asc())
                .getResultList();
        return revisions;
    }

    protected T checkRevisionByDate(PK key, java.util.Date date) {
        return getAuditReader().find(persistentClass, key, date);
    }

    /*-------------------------------------------------------------------------
      ----------------- Old Versioning -----------------------------------------
      -------------------------------------------------------------------------*/
    private void doOldVersioning(T entity) {
        try {
            Table tableDef = persistentClass.getAnnotation(Table.class);
            List<String> fields = new ArrayList<>();
            List<String> vars = new ArrayList<>();
            for (Field field : persistentClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    fields.add(column.name());
                    vars.add(":" + field.getName());
                }
            }
            String query = "INSERT INTO " + tableDef.name() + "(" + String.join(", ", fields) + ") VALUES(" + String.join(", ", vars) + ")";
            //System.out.println("QMS Versioning: " + query);
            Query q = getEntityManagerOldVersioning().createNativeQuery(query);
            for (Field field : persistentClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(Column.class)) {
                    q.setParameter(field.getName(), parseField(field.get(entity)));
                    //System.out.println("@Dayron: FIELD_TYPE: " + field.getType() + " - FIELD: " + field.getName() + " - VALUE: " + field.get(entity) + " - TYPE: " + (field.get(entity) != null ? field.get(entity).getClass() : null));
                }
            }
            q.executeUpdate();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Object parseField(Object value) {
        if (value == null) {
            return StringSupport.STRING_EMPTY;
        }
        return value;
    }

}
