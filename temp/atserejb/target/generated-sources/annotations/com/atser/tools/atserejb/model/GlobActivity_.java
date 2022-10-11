package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobActivity.class)
public abstract class GlobActivity_ {

	public static volatile SingularAttribute<GlobActivity, String> startDateTmp;
	public static volatile SingularAttribute<GlobActivity, Date> endDate;
	public static volatile SingularAttribute<GlobActivity, String> description;
	public static volatile SingularAttribute<GlobActivity, String> cell;
	public static volatile ListAttribute<GlobActivity, GlobActivityInspection> globActivityInspectionList;
	public static volatile SingularAttribute<GlobActivity, BigInteger> segmentId;
	public static volatile SingularAttribute<GlobActivity, String> contact;
	public static volatile SingularAttribute<GlobActivity, BigDecimal> id;
	public static volatile SingularAttribute<GlobActivity, String> fax;
	public static volatile SingularAttribute<GlobActivity, String> email;
	public static volatile SingularAttribute<GlobActivity, String> phase;
	public static volatile SingularAttribute<GlobActivity, Date> actualEnd;
	public static volatile SingularAttribute<GlobActivity, Character> active;
	public static volatile SingularAttribute<GlobActivity, String> areaofwork;
	public static volatile SingularAttribute<GlobActivity, String> estimatedCost;
	public static volatile SingularAttribute<GlobActivity, String> picture;
	public static volatile SingularAttribute<GlobActivity, String> phone;
	public static volatile SingularAttribute<GlobActivity, String> name;
	public static volatile SingularAttribute<GlobActivity, String> endDateTmp;
	public static volatile SingularAttribute<GlobActivity, String> lastModTmp;
	public static volatile SingularAttribute<GlobActivity, String> stageofwork;
	public static volatile SingularAttribute<GlobActivity, String> location;
	public static volatile SingularAttribute<GlobActivity, BigInteger> projectId;
	public static volatile SingularAttribute<GlobActivity, Date> actualStart;
	public static volatile SingularAttribute<GlobActivity, Date> lastMod;
	public static volatile SingularAttribute<GlobActivity, Date> startDate;

	public static final String START_DATE_TMP = "startDateTmp";
	public static final String END_DATE = "endDate";
	public static final String DESCRIPTION = "description";
	public static final String CELL = "cell";
	public static final String GLOB_ACTIVITY_INSPECTION_LIST = "globActivityInspectionList";
	public static final String SEGMENT_ID = "segmentId";
	public static final String CONTACT = "contact";
	public static final String ID = "id";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String PHASE = "phase";
	public static final String ACTUAL_END = "actualEnd";
	public static final String ACTIVE = "active";
	public static final String AREAOFWORK = "areaofwork";
	public static final String ESTIMATED_COST = "estimatedCost";
	public static final String PICTURE = "picture";
	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String END_DATE_TMP = "endDateTmp";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String STAGEOFWORK = "stageofwork";
	public static final String LOCATION = "location";
	public static final String PROJECT_ID = "projectId";
	public static final String ACTUAL_START = "actualStart";
	public static final String LAST_MOD = "lastMod";
	public static final String START_DATE = "startDate";

}

