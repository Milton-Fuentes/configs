package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmChangerequest.class)
public abstract class CmChangerequest_ {

	public static volatile SingularAttribute<CmChangerequest, Date> internalApprovedDate;
	public static volatile SingularAttribute<CmChangerequest, String> closenote;
	public static volatile SingularAttribute<CmChangerequest, GlobClient> clientId;
	public static volatile SingularAttribute<CmChangerequest, Date> created;
	public static volatile SingularAttribute<CmChangerequest, String> rejectreason;
	public static volatile SingularAttribute<CmChangerequest, BigInteger> approvedBy;
	public static volatile SingularAttribute<CmChangerequest, String> description;
	public static volatile SingularAttribute<CmChangerequest, String> title;
	public static volatile SingularAttribute<CmChangerequest, BigInteger> version;
	public static volatile SingularAttribute<CmChangerequest, BigInteger> parentId;
	public static volatile SingularAttribute<CmChangerequest, Date> approvedDate;
	public static volatile SingularAttribute<CmChangerequest, String> createBy;
	public static volatile SingularAttribute<CmChangerequest, Short> cancreaterevision;
	public static volatile SingularAttribute<CmChangerequest, String> amendmentNumber;
	public static volatile SingularAttribute<CmChangerequest, BigDecimal> id;
	public static volatile SingularAttribute<CmChangerequest, BigInteger> internalApprovedBy;
	public static volatile ListAttribute<CmChangerequest, CmChangerequestTask> cmChangerequestTaskList;
	public static volatile SingularAttribute<CmChangerequest, String> status;

	public static final String INTERNAL_APPROVED_DATE = "internalApprovedDate";
	public static final String CLOSENOTE = "closenote";
	public static final String CLIENT_ID = "clientId";
	public static final String CREATED = "created";
	public static final String REJECTREASON = "rejectreason";
	public static final String APPROVED_BY = "approvedBy";
	public static final String DESCRIPTION = "description";
	public static final String TITLE = "title";
	public static final String VERSION = "version";
	public static final String PARENT_ID = "parentId";
	public static final String APPROVED_DATE = "approvedDate";
	public static final String CREATE_BY = "createBy";
	public static final String CANCREATEREVISION = "cancreaterevision";
	public static final String AMENDMENT_NUMBER = "amendmentNumber";
	public static final String ID = "id";
	public static final String INTERNAL_APPROVED_BY = "internalApprovedBy";
	public static final String CM_CHANGEREQUEST_TASK_LIST = "cmChangerequestTaskList";
	public static final String STATUS = "status";

}

