/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.jpa;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITFilter;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITSorted;
import com.atser.tools.atserutil.string.StringSupport;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import javax.persistence.EntityManager;
import javax.persistence.Lob;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

/* Conditional Methods: equal (=), notEqual (!=), gt (>), ge, lt (<), le, between, like (%=), in (:=) */
/**
 *
 * @author droldan
 * @param <T>
 *
 */
public class JPADataModel<T> {

    private final EntityManager entityManager;
    private final Class<T> entityClass;
    private final List<ManageITFilter<?>> filter;
    private final List<ManageITSorted> sorted;
    //private final String[] operatorList = new String[]{"!=", "=", ">", "<", "%=", ":="};

    /**
     * Parameters Constructor
     *
     * @param entityManager
     * @param entityClass
     * @param filter
     * @param sorted
     */
    public JPADataModel(EntityManager entityManager, Class<T> entityClass, List<ManageITFilter<?>> filter, List<ManageITSorted> sorted) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
        this.filter = filter;
        this.sorted = sorted;
    }

    private Boolean isAnnotationPresent(String fieldName, Class Annotation) {
        Field field = getFieldByFieldName(fieldName);
        if (field != null) {
            return field.isAnnotationPresent(Annotation);
        }
        return Boolean.FALSE;
    }

    private Boolean isAnnotationPresent(String fieldName, Class localEntityClass, Class Annotation) {
        Field field = getFieldByFieldName(fieldName, localEntityClass);
        if (field != null) {
            return field.isAnnotationPresent(Annotation);
        }
        return Boolean.FALSE;
    }

    /**
     * Search by Field Name
     *
     * @param fieldName
     * @return Class<?>
     */
    private Field getFieldByFieldName(String fieldName) {
        return getFieldByFieldName(fieldName, entityClass);
    }

    /**
     * Search By Field Name
     *
     * @param fieldName
     * @param localEntityClass
     * @return Class<?>
     */
    private Field getFieldByFieldName(String fieldName, Class localEntityClass) {
        Field field;
        try {
            field = localEntityClass.getDeclaredField(fieldName);
            if (field != null) {
                return field;
            }
        } catch (NoSuchFieldException | SecurityException ex) {
            return null;
        }
        return null;
    }

    /**
     * Search by Field Name
     *
     * @param fieldName
     * @return Class<?>
     */
    private Class<?> getFieldTypeByFieldName(String fieldName) {
        return getFieldTypeByFieldName(fieldName, entityClass);
    }

    /**
     * Search By Field Name
     *
     * @param fieldName
     * @param localEntityClass
     * @return Class<?>
     */
    private Class<?> getFieldTypeByFieldName(String fieldName, Class localEntityClass) {
        Field field;
        try {
            field = localEntityClass.getDeclaredField(fieldName);
            if (field != null) {
                return field.getType();
            }
        } catch (NoSuchFieldException | SecurityException ex) {
            return null;
        }
        return null;
    }

    /**
     *
     * @param fieldName
     * @param Annotation
     * @return
     */
    private Annotation getAnnotation(String fieldName, Class Annotation) {
        return getAnnotation(fieldName, entityClass, Annotation);
    }

    private Annotation getAnnotation(String fieldName, Class localEntityClass, Class Annotation) {
        Field field;
        try {
            field = localEntityClass.getDeclaredField(fieldName);
            if (field != null) {
                return field.getAnnotation(Annotation);
            }
        } catch (NoSuchFieldException | SecurityException ex) {
            return null;
        }
        return null;
    }

    /**
     * Get Entity Class
     *
     * @return Class<T>
     */
    public Class<T> getEntityClass() {
        return entityClass;
    }

    /**
     * Build the sentence for Like
     *
     * @param value
     * @return String
     */
    private static String buildLikeValue(String value) {
        return "%" + value.toLowerCase() + "%";
    }

    /**
     * Convert to RealType
     *
     * @param fieldType
     * @param filterValue
     * @return Object
     */
    private Object convertToRealType(Class<?> fieldType, Object filterValue, Class<?> fieldClazz, String propertyName) {
        if (filterValue == null) {
            return null;
        }
        String stringFilterValue = filterValue.toString();
        String type = fieldType.getTypeName();
        // Find HADateTime Annotation
        /*String annoDateFormat = null;
        HADateTime fieldDateTimeAnnotation = (HADateTime) getAnnotation(propertyName, fieldClazz, HADateTime.class);
        if (fieldDateTimeAnnotation != null) {
            annoDateFormat = fieldDateTimeAnnotation.dateFormat();
        }*/
        if (stringFilterValue.isEmpty()) {
            return null;
        } else if (stringFilterValue.toLowerCase().equals("null")) {
            return "null";
        }

        switch (type) {
            case "java.lang.String":
                return stringFilterValue;
            case "long":
            case "java.lang.Long":
                return Long.valueOf(stringFilterValue);
            case "java.lang.Character":
                return stringFilterValue.charAt(0);
            case "java.math.BigInteger":
                return NumberSupport.getBigInteger(stringFilterValue);
            case "int":
            case "java.lang.Integer":
                return Integer.valueOf(stringFilterValue);
            case "java.lang.Double":
                return Double.valueOf(stringFilterValue);
            case "java.math.BigDecimal":
                return NumberSupport.getBigDecimal(stringFilterValue);
            case "java.lang.Short":
                return Short.parseShort(stringFilterValue);
            case "boolean":
            case "java.lang.Boolean":
                return Boolean.valueOf(stringFilterValue);
            case "java.util.Date":
                return DateSupport.parseDynamicStringToDate(stringFilterValue);
            default:
                break;
        }
        return null;
    }

    /**
     * Create Select Criteria Query
     *
     * @return CriteriaQuery<T>
     */
    public CriteriaQuery<T> createSelectCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        if (sorted != null) {
            List<Order> orders = createOrders(criteriaBuilder, root);
            if (!orders.isEmpty()) {
                criteriaQuery.orderBy(orders);
            }
        }

        if (filter != null) {
            Expression<Boolean> filterCriteria = createFilterCriteria(criteriaBuilder, root);
            if (filterCriteria != null) {
                criteriaQuery.where(filterCriteria);
            }
        }

        return criteriaQuery;
    }

    /**
     * Create Count Criteria
     *
     * @return CriteriaQuery<Long>
     */
    public CriteriaQuery<Long> createCountCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(criteriaBuilder.count(root));

        if (filter != null) {
            Expression<Boolean> filterCriteria = createFilterCriteria(criteriaBuilder, root);
            if (filterCriteria != null) {
                criteriaQuery.where(filterCriteria);
            }
        }

        return criteriaQuery;
    }

    /**
     * Create Max Criteria
     *
     * @return CriteriaQuery<Long>
     */
    public CriteriaQuery<Number> createMaxIdCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Number> criteriaQuery = criteriaBuilder.createQuery(Number.class);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(criteriaBuilder.max(root.get("id")));

        if (filter != null) {
            Expression<Boolean> filterCriteria = createFilterCriteria(criteriaBuilder, root);
            if (filterCriteria != null) {
                criteriaQuery.where(filterCriteria);
            }
        }

        return criteriaQuery;
    }

    /**
     * Create Orders
     *
     * @param criteriaBuilder
     * @param root
     * @return List<Order>
     */
    private List<Order> createOrders(CriteriaBuilder criteriaBuilder, Root<T> root) {
        List<Order> orders = new ArrayList<>();
        if (sorted != null && !sorted.isEmpty()) {

            sorted.forEach((sortField) -> {
                String propertyName = sortField.getName();
                Path expression;
                if (!(propertyName == null || propertyName.isEmpty())) {
                    if (propertyName.contains(".")) {
                        String[] names = propertyName.split("\\.");
                        expression = root.get(names[0]);
                        for (int i = 1; i < names.length; i++) {
                            expression = expression.get(names[i]);
                        }
                    } else {
                        expression = root.get(propertyName);
                    }
                    Order jpaOrder;
                    if (sortField.getDirection() != null && (sortField.getDirection().trim().toLowerCase().equals("asc") || sortField.getDirection().trim().toLowerCase().equals("ascending"))) {
                        jpaOrder = criteriaBuilder.asc(expression);
                        //jpaOrder = criteriaBuilder.asc(criteriaBuilder.substring(expression, 0, 100));
                    } else if (sortField.getDirection() != null && (sortField.getDirection().trim().toLowerCase().equals("desc") || sortField.getDirection().trim().toLowerCase().equals("descending"))) {
                        jpaOrder = criteriaBuilder.desc(expression);
                        //jpaOrder = criteriaBuilder.desc(criteriaBuilder.substring(expression, 0, 100));
                    } else {
                        throw new IllegalArgumentException(sortField.getDirection());
                    }

                    orders.add(jpaOrder);
                }
            });
        }

        return orders;
    }

    /**
     * Clone List
     *
     * @param list
     * @return
     */
    private List<ManageITFilter<?>> cloneList(List<ManageITFilter<?>> list) {
        List<ManageITFilter<?>> clone = new ArrayList<>();
        list.forEach(it -> {
            clone.add(it);
        });
        return clone;
    }

    /**
     * Order Filters
     *
     * @return List<List<ManageITFilter<?>>>
     */
    private List<List<ManageITFilter<?>>> orderFilters() {
        if (filter != null && !filter.isEmpty()) {
            List<List<ManageITFilter<?>>> subsetList = new ArrayList<>();
            Predicate<ManageITFilter<?>> p1 = s -> s.getField().charAt(0) == '!';
            boolean containsOr = filter.stream().anyMatch(p1);
            if (!containsOr) {
                subsetList.add(filter);
                return subsetList;
            }
            List<ManageITFilter<?>> tmp = new ArrayList<>();
            Boolean isOpen = false;
            tmp.add(filter.get(0));
            for (int i = 1; i < filter.size(); i++) {
                Boolean isCurrentOr = filter.get(i).getField().charAt(0) == '!';
                Boolean isNextOr = false;
                if (i + 1 < filter.size()) {
                    isNextOr = filter.get(i + 1).getField().charAt(0) == '!';
                }
                if (isCurrentOr && !isOpen) {
                    isOpen = true;
                }
                if (!isCurrentOr && isNextOr) {
                    subsetList.add(cloneList(tmp));
                    tmp.clear();
                    tmp.add(filter.get(i));
                    isOpen = true;
                    continue;
                }
                if (!isOpen || (isOpen && isNextOr)) {
                    tmp.add(filter.get(i));
                }
                if ((isOpen && !isNextOr)) {
                    tmp.add(filter.get(i));
                    subsetList.add(cloneList(tmp));
                    tmp.clear();
                    isOpen = false;
                }
            }

            if (tmp.size() > 0) {
                subsetList.add(tmp);
            }
            return subsetList;
        }
        return null;
    }

    /**
     * Create SubFilter Criteria
     *
     * @param criteriaBuilder
     * @param root
     * @param subset
     * @return Expression<Boolean>
     */
    private Expression<Boolean> createSubFilterCriteria(CriteriaBuilder criteriaBuilder, Root<T> root, List<ManageITFilter<?>> subset) {
        Expression<Boolean> filterCriteria = null;
        Expression<Boolean> filterCriteriaLike = null;
        for (ManageITFilter<?> filterField : subset) {
            String propertyName = filterField.getField();
            Object filterValue = filterField.getValue();
            Boolean isOr = propertyName.charAt(0) == '!';
            propertyName = propertyName.replaceAll("!", "");
            Expression<Boolean> predicate;
            predicate = parseFilterOperation(propertyName, filterValue, filterField.getCondition(), root, criteriaBuilder);
            if (predicate == null) {
                continue;
            }
            if (filterField.getCondition().equals("%=")) {
                if (filterCriteriaLike == null) {
                    filterCriteriaLike = predicate.as(Boolean.class);
                } else {
                    filterCriteriaLike = criteriaBuilder.or(filterCriteriaLike, predicate.as(Boolean.class));
                }
            } else {
                if (filterCriteria == null) {
                    filterCriteria = predicate.as(Boolean.class);
                } else {
                    if (isOr) {
                        filterCriteria = criteriaBuilder.or(filterCriteria, predicate.as(Boolean.class));
                    } else {
                        filterCriteria = criteriaBuilder.and(filterCriteria, predicate.as(Boolean.class));
                    }
                }
            }
        }
        if (filterCriteriaLike != null && filterCriteria != null) {
            filterCriteria = criteriaBuilder.and(filterCriteria, filterCriteriaLike);
        } else if (filterCriteriaLike != null && filterCriteria == null) {
            filterCriteria = filterCriteriaLike;
        }
        return filterCriteria;
    }

    /**
     * Create Filter Criteria
     *
     * @param criteriaBuilder
     * @param root
     * @return Expression<Boolean>
     */
    private Expression<Boolean> createFilterCriteria(CriteriaBuilder criteriaBuilder, Root<T> root) {
        Expression<Boolean> filterCriteria = null;
        List<List<ManageITFilter<?>>> subsetList = orderFilters();
        if (subsetList != null && !subsetList.isEmpty()) {
            for (List<ManageITFilter<?>> it : subsetList) {
                if (it.size() > 0) {
                    if (filterCriteria == null) {
                        filterCriteria = createSubFilterCriteria(criteriaBuilder, root, it);
                    } else {
                        filterCriteria = criteriaBuilder.and(filterCriteria, createSubFilterCriteria(criteriaBuilder, root, it));
                    }
                }
            }
        }
        return filterCriteria;
    }

    /**
     * General Parser for Filters
     *
     * @param propertyName
     * @param filterValue
     * @param condition
     * @param root
     * @param criteriaBuilder
     * @return Expression<Boolean>
     */
    private Expression<Boolean> parseFilterOperation(String propertyName, Object filterValue, String condition, Root<T> root, CriteriaBuilder criteriaBuilder) {
        Path expression = null;
        Class<?> fieldClazz = null;
        String finalPropertyName = null;
        Expression<Boolean> predicate = null;
        Boolean isClog = Boolean.FALSE;
        if (propertyName == null || propertyName.isEmpty()) {
            return null;
        }
        if (propertyName.contains(".")) {
            String[] names = propertyName.split("\\.");
            expression = root.get(names[0]);
            for (int i = 1; i < names.length; i++) {
                fieldClazz = expression.getJavaType();
                finalPropertyName = names[i];
                expression = expression.get(names[i]);
            }
        } else {
            expression = root.get(propertyName);
            fieldClazz = getEntityClass();
            finalPropertyName = propertyName;
        }

        Object finalValue = convertToRealType(expression.getJavaType(), filterValue, fieldClazz, finalPropertyName);

        String type = expression.getJavaType().getTypeName();
        if (type.equals("java.lang.String")) {
            isClog = isAnnotationPresent(finalPropertyName, fieldClazz, Lob.class);
        }

        if (condition == null) {
            predicate = createFilterCriteriaEqualForField(expression, finalValue, criteriaBuilder);
        } else {
            switch (condition) {
                case "=": {
                    if (isClog) {
                        predicate = createFilterCriteriaLikeForField(expression, finalValue, criteriaBuilder);
                        break;
                    }
                    predicate = createFilterCriteriaEqualForField(expression, finalValue, criteriaBuilder);
                    break;
                }
                case "!=": {
                    predicate = createFilterCriteriaNotEqualForField(expression, finalValue, criteriaBuilder);
                    break;
                }
                case "%=": {
                    predicate = createFilterCriteriaLikeForField(expression, finalValue, criteriaBuilder);
                    break;
                }
                case "!%=": {
                    predicate = createFilterCriteriaNotLikeForField(expression, finalValue, criteriaBuilder);
                    break;
                }
                case ":=": {
                    predicate = createFilterCriteriaInForField(expression, filterValue, criteriaBuilder);
                    break;
                }
                case "<": {
                    predicate = createFilterCriteriaLtForField(expression, finalValue, criteriaBuilder);
                    break;
                }
                case ">": {
                    predicate = createFilterCriteriaGtForField(expression, finalValue, criteriaBuilder);
                    break;
                }
                case "<=": {
                    predicate = createFilterCriteriaLtOrEqualsForField(expression, finalValue, criteriaBuilder);
                    break;
                }
                case ">=": {
                    predicate = createFilterCriteriaGtOrEqualsForField(expression, finalValue, criteriaBuilder);
                    break;
                }
                default:
                    break;
            }
        }
        return predicate;
    }

    private Expression<Boolean> createDefaultDateFilterCriteria(Path expression, Object filterValue, CriteriaBuilder criteriaBuilder) {
        LocalDate currentDate = DateSupport.convertToLocalDate((Date)filterValue);
        LocalDate yesterday = DateSupport.convertToLocalDate((Date)filterValue).minusDays(1);
        javax.persistence.criteria.Predicate startDatePredicate = criteriaBuilder.greaterThanOrEqualTo(expression.as(java.util.Date.class), DateSupport.convertToDate(yesterday));
        javax.persistence.criteria.Predicate endDatePredicate = criteriaBuilder.lessThanOrEqualTo(expression.as(java.util.Date.class), DateSupport.convertToDate(currentDate));
        return criteriaBuilder.and(startDatePredicate, endDatePredicate);
    }

    /**
     * Equal (=)
     *
     * @param expression
     * @param filterValue
     * @param criteriaBuilder
     * @return Expression<Boolean>
     */
    private Expression<Boolean> createFilterCriteriaEqualForField(Path expression, Object filterValue, CriteriaBuilder criteriaBuilder) {
        if (filterValue == null || filterValue.toString().equals("null")) {
            return criteriaBuilder.isNull(expression);
        }
        switch (expression.getJavaType().getTypeName()) {
            case "java.util.Date": {
                return createDefaultDateFilterCriteria(expression, filterValue, criteriaBuilder);
            }
            default: {
                return criteriaBuilder.equal(expression, (Comparable) filterValue);
            }

        }
    }

    /**
     * Not Equal (!=)
     *
     * @param expression
     * @param filterValue
     * @param criteriaBuilder
     * @return Expression<Boolean>
     */
    private Expression<Boolean> createFilterCriteriaNotEqualForField(Path expression, Object filterValue, CriteriaBuilder criteriaBuilder) {
        if (filterValue == null || filterValue.toString().equals("null")) {
            return criteriaBuilder.isNotNull(expression);
        }
        return criteriaBuilder.notEqual(expression, filterValue);
    }

    /**
     * Like (%=)
     *
     * @param expression
     * @param filterValue
     * @param criteriaBuilder
     * @return Expression<Boolean>
     */
    private Expression<Boolean> createFilterCriteriaLikeForField(Path expression, Object filterValue, CriteriaBuilder criteriaBuilder) {
        if (StringSupport.isNotNullAndNotEmpty(filterValue)) {
            String stringFilterValue = filterValue.toString().trim().toLowerCase();
            return criteriaBuilder.like(criteriaBuilder.lower(expression.as(String.class)), buildLikeValue(stringFilterValue));
        }
        return null;
        //return criteriaBuilder.like((Expression<String>) expression, buildLikeValue(stringFilterValue));
    }

    /**
     * Not Like (!%=)
     *
     * @param expression
     * @param filterValue
     * @param criteriaBuilder
     * @return Expression<Boolean>
     */
    private Expression<Boolean> createFilterCriteriaNotLikeForField(Path expression, Object filterValue, CriteriaBuilder criteriaBuilder) {
        if (StringSupport.isNotNullAndNotEmpty(filterValue)) {
            String stringFilterValue = filterValue.toString();
            return criteriaBuilder.notLike(criteriaBuilder.lower((Expression<String>) expression), buildLikeValue(stringFilterValue));
        }
        return null;
        //return criteriaBuilder.like((Expression<String>) expression, buildLikeValue(stringFilterValue));
    }

    /**
     * In (:=)
     *
     * @param expression
     * @param filterValue
     * @param criteriaBuilder
     * @return Expression<Boolean>
     */
    private Expression<Boolean> createFilterCriteriaInForField(Path expression, Object filterValue, CriteriaBuilder criteriaBuilder) {
        List<String> lvalue = null;
        if (filterValue instanceof String) {
            lvalue = Arrays.asList(filterValue.toString().split(","));
        } else if (filterValue instanceof List) {
            lvalue = (List<String>) filterValue;
        }

        if (lvalue != null && !lvalue.isEmpty()) {
            return expression.in(lvalue);
        }
        return null;
    }

    /**
     * Greater Than (>)
     *
     * @param expression
     * @param filterValue
     * @param criteriaBuilder
     * @return Expression<Boolean>
     */
    private Expression<Boolean> createFilterCriteriaGtForField(Path expression, Object filterValue, CriteriaBuilder criteriaBuilder) {        
        if (filterValue == null || filterValue.toString().equals("null")) {
            return null;
        }
        switch (expression.getJavaType().getTypeName()) {
            case "java.util.Date": {
                LocalDate currentDate = DateSupport.convertToLocalDate((Date)filterValue);
                return criteriaBuilder.greaterThan(expression.as(java.util.Date.class), DateSupport.convertToDate(currentDate));
            }
            default: {
                return criteriaBuilder.greaterThan(expression, (Comparable) filterValue);
            }

        }
    }
    
    /**
     * Greater Than Or Equals(>=)
     * @param expression
     * @param filterValue
     * @param criteriaBuilder
     * @return Expression<Boolean>
     */
    private Expression<Boolean> createFilterCriteriaGtOrEqualsForField(Path expression, Object filterValue, CriteriaBuilder criteriaBuilder) {        
        if (filterValue == null || filterValue.toString().equals("null")) {
            return null;
        }
        switch (expression.getJavaType().getTypeName()) {
            case "java.util.Date": {
                LocalDate currentDate = DateSupport.convertToLocalDate((Date)filterValue);
                return criteriaBuilder.greaterThanOrEqualTo(expression.as(java.util.Date.class), DateSupport.convertToDate(currentDate));
            }
            default: {
                return criteriaBuilder.greaterThanOrEqualTo(expression, (Comparable) filterValue);
            }

        }
    }

    /**
     * Less Than (<)
     *
     * @param expression
     * @param filterValue
     * @param criteriaBuilder
     * @return Expression<Boolean>
     */
    private Expression<Boolean> createFilterCriteriaLtForField(Path expression, Object filterValue, CriteriaBuilder criteriaBuilder) {
        if (filterValue == null || filterValue.toString().equals("null")) {
            return null;
        }
        switch (expression.getJavaType().getTypeName()) {
            case "java.util.Date": {
                LocalDate currentDate = DateSupport.convertToLocalDate((Date)filterValue);
                return criteriaBuilder.lessThan(expression.as(java.util.Date.class), DateSupport.convertToDate(currentDate));
            }
            default: {
                return criteriaBuilder.lessThan(expression, (Comparable) filterValue);
            }

        }
    }
    
    /**
     * Less Than Or Equals(<=)
     * @param expression
     * @param filterValue
     * @param criteriaBuilder
     * @return 
     */
    private Expression<Boolean> createFilterCriteriaLtOrEqualsForField(Path expression, Object filterValue, CriteriaBuilder criteriaBuilder) {
        if (filterValue == null || filterValue.toString().equals("null")) {
            return null;
        }
        switch (expression.getJavaType().getTypeName()) {
            case "java.util.Date": {
                LocalDate currentDate = DateSupport.convertToLocalDate((Date)filterValue);
                return criteriaBuilder.lessThanOrEqualTo(expression.as(java.util.Date.class), DateSupport.convertToDate(currentDate));
            }
            default: {
                return criteriaBuilder.lessThanOrEqualTo(expression, (Comparable) filterValue);
            }

        }
    }

}
