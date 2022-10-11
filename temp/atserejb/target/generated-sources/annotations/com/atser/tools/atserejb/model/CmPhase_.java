package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmPhase.class)
public abstract class CmPhase_ {

	public static volatile SingularAttribute<CmPhase, String> lastModBy;
	public static volatile SingularAttribute<CmPhase, Character> active;
	public static volatile SingularAttribute<CmPhase, String> createByIp;
	public static volatile SingularAttribute<CmPhase, String> createBy;
	public static volatile SingularAttribute<CmPhase, String> lastModIp;
	public static volatile SingularAttribute<CmPhase, String> pName;
	public static volatile SingularAttribute<CmPhase, String> pType;
	public static volatile SingularAttribute<CmPhase, String> pLetter;
	public static volatile SingularAttribute<CmPhase, BigDecimal> id;
	public static volatile ListAttribute<CmPhase, CmActivity> cmActivityList;
	public static volatile SingularAttribute<CmPhase, Date> lastMod;
	public static volatile SingularAttribute<CmPhase, String> remarks;
	public static volatile SingularAttribute<CmPhase, Date> createDate;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String ACTIVE = "active";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String P_NAME = "pName";
	public static final String P_TYPE = "pType";
	public static final String P_LETTER = "pLetter";
	public static final String ID = "id";
	public static final String CM_ACTIVITY_LIST = "cmActivityList";
	public static final String LAST_MOD = "lastMod";
	public static final String REMARKS = "remarks";
	public static final String CREATE_DATE = "createDate";

}

