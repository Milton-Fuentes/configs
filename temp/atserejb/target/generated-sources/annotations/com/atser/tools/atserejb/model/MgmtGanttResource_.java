package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MgmtGanttResource.class)
public abstract class MgmtGanttResource_ {

	public static volatile SingularAttribute<MgmtGanttResource, String> firstname;
	public static volatile SingularAttribute<MgmtGanttResource, String> code;
	public static volatile SingularAttribute<MgmtGanttResource, String> lastModBy;
	public static volatile SingularAttribute<MgmtGanttResource, Date> created;
	public static volatile SingularAttribute<MgmtGanttResource, String> description;
	public static volatile SingularAttribute<MgmtGanttResource, String> title;
	public static volatile SingularAttribute<MgmtGanttResource, String> createByIp;
	public static volatile SingularAttribute<MgmtGanttResource, String> lastname;
	public static volatile SingularAttribute<MgmtGanttResource, String> createBy;
	public static volatile SingularAttribute<MgmtGanttResource, String> lastModIp;
	public static volatile SingularAttribute<MgmtGanttResource, BigDecimal> id;
	public static volatile SingularAttribute<MgmtGanttResource, String> lastMod;
	public static volatile SingularAttribute<MgmtGanttResource, BigInteger> projectId;
	public static volatile SingularAttribute<MgmtGanttResource, Short> status;

	public static final String FIRSTNAME = "firstname";
	public static final String CODE = "code";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String TITLE = "title";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String LASTNAME = "lastname";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String PROJECT_ID = "projectId";
	public static final String STATUS = "status";

}

