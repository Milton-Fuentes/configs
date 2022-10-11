package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TmpItemOrder.class)
public abstract class TmpItemOrder_ {

	public static volatile SingularAttribute<TmpItemOrder, String> createdByIp;
	public static volatile SingularAttribute<TmpItemOrder, BigInteger> clientId;
	public static volatile SingularAttribute<TmpItemOrder, String> orderNo;
	public static volatile SingularAttribute<TmpItemOrder, String> lastModBy;
	public static volatile SingularAttribute<TmpItemOrder, Date> created;
	public static volatile SingularAttribute<TmpItemOrder, String> description;
	public static volatile SingularAttribute<TmpItemOrder, Character> active;
	public static volatile SingularAttribute<TmpItemOrder, Integer> version;
	public static volatile SingularAttribute<TmpItemOrder, BigInteger> folderId;
	public static volatile SingularAttribute<TmpItemOrder, Date> orderExpDate;
	public static volatile SingularAttribute<TmpItemOrder, Character> approved;
	public static volatile SingularAttribute<TmpItemOrder, BigDecimal> orderAmount;
	public static volatile SingularAttribute<TmpItemOrder, String> lastModIp;
	public static volatile SingularAttribute<TmpItemOrder, Character> deleted;
	public static volatile SingularAttribute<TmpItemOrder, String> createdBy;
	public static volatile SingularAttribute<TmpItemOrder, BigDecimal> id;
	public static volatile SingularAttribute<TmpItemOrder, BigInteger> projectId;
	public static volatile SingularAttribute<TmpItemOrder, String> spattern;
	public static volatile SingularAttribute<TmpItemOrder, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String ORDER_NO = "orderNo";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String ORDER_EXP_DATE = "orderExpDate";
	public static final String APPROVED = "approved";
	public static final String ORDER_AMOUNT = "orderAmount";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String PROJECT_ID = "projectId";
	public static final String SPATTERN = "spattern";
	public static final String LAST_MOD = "lastMod";

}

