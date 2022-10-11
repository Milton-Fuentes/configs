package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmActivity.class)
public abstract class CmActivity_ {

	public static volatile SingularAttribute<CmActivity, String> lastModBy;
	public static volatile SingularAttribute<CmActivity, CmPhase> phaseId;
	public static volatile SingularAttribute<CmActivity, Character> active;
	public static volatile ListAttribute<CmActivity, CmFormType> cmFormTypeList;
	public static volatile SingularAttribute<CmActivity, BigInteger> parentId;
	public static volatile SingularAttribute<CmActivity, String> createByIp;
	public static volatile SingularAttribute<CmActivity, String> createBy;
	public static volatile SingularAttribute<CmActivity, String> lastModIp;
	public static volatile SingularAttribute<CmActivity, String> aLetter;
	public static volatile SingularAttribute<CmActivity, String> aName;
	public static volatile SingularAttribute<CmActivity, BigDecimal> id;
	public static volatile SingularAttribute<CmActivity, Date> lastMod;
	public static volatile SingularAttribute<CmActivity, String> remarks;
	public static volatile SingularAttribute<CmActivity, Date> createDate;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String PHASE_ID = "phaseId";
	public static final String ACTIVE = "active";
	public static final String CM_FORM_TYPE_LIST = "cmFormTypeList";
	public static final String PARENT_ID = "parentId";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String A_LETTER = "aLetter";
	public static final String A_NAME = "aName";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";
	public static final String REMARKS = "remarks";
	public static final String CREATE_DATE = "createDate";

}

