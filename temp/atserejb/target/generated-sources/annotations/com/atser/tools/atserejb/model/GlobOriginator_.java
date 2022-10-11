package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobOriginator.class)
public abstract class GlobOriginator_ {

	public static volatile SingularAttribute<GlobOriginator, Date> temp;
	public static volatile SingularAttribute<GlobOriginator, String> lastModBy;
	public static volatile SingularAttribute<GlobOriginator, String> tempTmp;
	public static volatile SingularAttribute<GlobOriginator, String> createDateTmp;
	public static volatile SingularAttribute<GlobOriginator, Character> active;
	public static volatile SingularAttribute<GlobOriginator, String> createByIp;
	public static volatile SingularAttribute<GlobOriginator, String> createBy;
	public static volatile SingularAttribute<GlobOriginator, String> lastModIp;
	public static volatile SingularAttribute<GlobOriginator, Character> standardOrig;
	public static volatile ListAttribute<GlobOriginator, GlobSpecification> globSpecificationList;
	public static volatile SingularAttribute<GlobOriginator, String> lastModTmp;
	public static volatile SingularAttribute<GlobOriginator, BigDecimal> id;
	public static volatile SingularAttribute<GlobOriginator, String> oName;
	public static volatile SingularAttribute<GlobOriginator, Date> lastMod;
	public static volatile SingularAttribute<GlobOriginator, Date> createDate;

	public static final String TEMP = "temp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String TEMP_TMP = "tempTmp";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String ACTIVE = "active";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String STANDARD_ORIG = "standardOrig";
	public static final String GLOB_SPECIFICATION_LIST = "globSpecificationList";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String ID = "id";
	public static final String O_NAME = "oName";
	public static final String LAST_MOD = "lastMod";
	public static final String CREATE_DATE = "createDate";

}

