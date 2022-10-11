package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmContract.class)
public abstract class CmContract_ {

	public static volatile SingularAttribute<CmContract, Date> insurexpdate;
	public static volatile SingularAttribute<CmContract, String> drawgNo;
	public static volatile SingularAttribute<CmContract, Date> preConstructionMeetingDate;
	public static volatile SingularAttribute<CmContract, Double> damagesPerDay;
	public static volatile SingularAttribute<CmContract, BigInteger> cDays;
	public static volatile SingularAttribute<CmContract, String> cNumber;
	public static volatile SingularAttribute<CmContract, String> cStatus;
	public static volatile SingularAttribute<CmContract, CmProject> pNumberId;
	public static volatile SingularAttribute<CmContract, String> estimator;
	public static volatile SingularAttribute<CmContract, String> cName;
	public static volatile SingularAttribute<CmContract, String> pManager;
	public static volatile SingularAttribute<CmContract, BigDecimal> id;
	public static volatile SingularAttribute<CmContract, String> keyMap;
	public static volatile SingularAttribute<CmContract, Date> cDate;
	public static volatile SingularAttribute<CmContract, Date> drugpdate;
	public static volatile SingularAttribute<CmContract, String> inspector;
	public static volatile SingularAttribute<CmContract, Date> cutoffDate;
	public static volatile SingularAttribute<CmContract, String> wmbe;
	public static volatile SingularAttribute<CmContract, String> field1;
	public static volatile SingularAttribute<CmContract, Double> cAmount;
	public static volatile SingularAttribute<CmContract, Date> field7;
	public static volatile SingularAttribute<CmContract, Double> field6;
	public static volatile SingularAttribute<CmContract, String> preConstructionMeetingLoc;
	public static volatile SingularAttribute<CmContract, Date> field8;
	public static volatile SingularAttribute<CmContract, Date> ntpLetterDate;
	public static volatile SingularAttribute<CmContract, String> field3;
	public static volatile SingularAttribute<CmContract, Date> startingDate;
	public static volatile SingularAttribute<CmContract, Date> subcompdate;
	public static volatile SingularAttribute<CmContract, String> field2;
	public static volatile SingularAttribute<CmContract, Double> field5;
	public static volatile SingularAttribute<CmContract, String> field4;

	public static final String INSUREXPDATE = "insurexpdate";
	public static final String DRAWG_NO = "drawgNo";
	public static final String PRE_CONSTRUCTION_MEETING_DATE = "preConstructionMeetingDate";
	public static final String DAMAGES_PER_DAY = "damagesPerDay";
	public static final String C_DAYS = "cDays";
	public static final String C_NUMBER = "cNumber";
	public static final String C_STATUS = "cStatus";
	public static final String P_NUMBER_ID = "pNumberId";
	public static final String ESTIMATOR = "estimator";
	public static final String C_NAME = "cName";
	public static final String P_MANAGER = "pManager";
	public static final String ID = "id";
	public static final String KEY_MAP = "keyMap";
	public static final String C_DATE = "cDate";
	public static final String DRUGPDATE = "drugpdate";
	public static final String INSPECTOR = "inspector";
	public static final String CUTOFF_DATE = "cutoffDate";
	public static final String WMBE = "wmbe";
	public static final String FIELD1 = "field1";
	public static final String C_AMOUNT = "cAmount";
	public static final String FIELD7 = "field7";
	public static final String FIELD6 = "field6";
	public static final String PRE_CONSTRUCTION_MEETING_LOC = "preConstructionMeetingLoc";
	public static final String FIELD8 = "field8";
	public static final String NTP_LETTER_DATE = "ntpLetterDate";
	public static final String FIELD3 = "field3";
	public static final String STARTING_DATE = "startingDate";
	public static final String SUBCOMPDATE = "subcompdate";
	public static final String FIELD2 = "field2";
	public static final String FIELD5 = "field5";
	public static final String FIELD4 = "field4";

}

