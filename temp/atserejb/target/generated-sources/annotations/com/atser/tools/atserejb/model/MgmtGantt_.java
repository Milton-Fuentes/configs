package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MgmtGantt.class)
public abstract class MgmtGantt_ {

	public static volatile SingularAttribute<MgmtGantt, String> openBy;
	public static volatile SingularAttribute<MgmtGantt, String> lastModBy;
	public static volatile SingularAttribute<MgmtGantt, BigInteger> clientId;
	public static volatile SingularAttribute<MgmtGantt, String> data;
	public static volatile SingularAttribute<MgmtGantt, Date> created;
	public static volatile SingularAttribute<MgmtGantt, String> description;
	public static volatile SingularAttribute<MgmtGantt, String> createByIp;
	public static volatile SingularAttribute<MgmtGantt, String> createBy;
	public static volatile SingularAttribute<MgmtGantt, String> lastModIp;
	public static volatile SingularAttribute<MgmtGantt, String> name;
	public static volatile SingularAttribute<MgmtGantt, BigDecimal> id;
	public static volatile SingularAttribute<MgmtGantt, String> lastMod;
	public static volatile SingularAttribute<MgmtGantt, BigInteger> projectId;
	public static volatile SingularAttribute<MgmtGantt, Short> open;
	public static volatile SingularAttribute<MgmtGantt, Short> status;

	public static final String OPEN_BY = "openBy";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CLIENT_ID = "clientId";
	public static final String DATA = "data";
	public static final String CREATED = "created";
	public static final String DESCRIPTION = "description";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String PROJECT_ID = "projectId";
	public static final String OPEN = "open";
	public static final String STATUS = "status";

}

