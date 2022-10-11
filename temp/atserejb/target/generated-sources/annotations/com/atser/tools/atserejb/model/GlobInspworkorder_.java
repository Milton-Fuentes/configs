package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobInspworkorder.class)
public abstract class GlobInspworkorder_ {

	public static volatile SingularAttribute<GlobInspworkorder, String> inspNotes;
	public static volatile SingularAttribute<GlobInspworkorder, BigInteger> infoId;
	public static volatile SingularAttribute<GlobInspworkorder, String> lastModBy;
	public static volatile SingularAttribute<GlobInspworkorder, Date> serviceDate;
	public static volatile SingularAttribute<GlobInspworkorder, String> contactPerson;
	public static volatile SingularAttribute<GlobInspworkorder, Bpminspectordispatchbo> inspdispatchid;
	public static volatile SingularAttribute<GlobInspworkorder, String> specInstr;
	public static volatile SingularAttribute<GlobInspworkorder, String> timeatoffice;
	public static volatile SingularAttribute<GlobInspworkorder, BigInteger> activityId;
	public static volatile SingularAttribute<GlobInspworkorder, String> lastModIp;
	public static volatile SingularAttribute<GlobInspworkorder, BigDecimal> id;
	public static volatile SingularAttribute<GlobInspworkorder, BigInteger> decisionflag;
	public static volatile SingularAttribute<GlobInspworkorder, BigInteger> inspRefid;
	public static volatile SingularAttribute<GlobInspworkorder, Date> createDate;
	public static volatile SingularAttribute<GlobInspworkorder, BigDecimal> hours;
	public static volatile SingularAttribute<GlobInspworkorder, String> contactTelephone;
	public static volatile SingularAttribute<GlobInspworkorder, BigInteger> inspectionFuncid;
	public static volatile SingularAttribute<GlobInspworkorder, String> assignment;
	public static volatile SingularAttribute<GlobInspworkorder, String> wotoken;
	public static volatile SingularAttribute<GlobInspworkorder, Character> active;
	public static volatile SingularAttribute<GlobInspworkorder, String> inspector;
	public static volatile SingularAttribute<GlobInspworkorder, String> timeatsite;
	public static volatile SingularAttribute<GlobInspworkorder, String> version;
	public static volatile SingularAttribute<GlobInspworkorder, String> createByIp;
	public static volatile SingularAttribute<GlobInspworkorder, String> createBy;
	public static volatile SingularAttribute<GlobInspworkorder, String> servicesRequested;
	public static volatile SingularAttribute<GlobInspworkorder, String> wonumber;
	public static volatile SingularAttribute<GlobInspworkorder, String> cancelled;
	public static volatile SingularAttribute<GlobInspworkorder, BigInteger> projectId;
	public static volatile SingularAttribute<GlobInspworkorder, String> lastMod;
	public static volatile SingularAttribute<GlobInspworkorder, BigInteger> contactrefid;
	public static volatile SingularAttribute<GlobInspworkorder, Character> paperworkReceived;

	public static final String INSP_NOTES = "inspNotes";
	public static final String INFO_ID = "infoId";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String SERVICE_DATE = "serviceDate";
	public static final String CONTACT_PERSON = "contactPerson";
	public static final String INSPDISPATCHID = "inspdispatchid";
	public static final String SPEC_INSTR = "specInstr";
	public static final String TIMEATOFFICE = "timeatoffice";
	public static final String ACTIVITY_ID = "activityId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ID = "id";
	public static final String DECISIONFLAG = "decisionflag";
	public static final String INSP_REFID = "inspRefid";
	public static final String CREATE_DATE = "createDate";
	public static final String HOURS = "hours";
	public static final String CONTACT_TELEPHONE = "contactTelephone";
	public static final String INSPECTION_FUNCID = "inspectionFuncid";
	public static final String ASSIGNMENT = "assignment";
	public static final String WOTOKEN = "wotoken";
	public static final String ACTIVE = "active";
	public static final String INSPECTOR = "inspector";
	public static final String TIMEATSITE = "timeatsite";
	public static final String VERSION = "version";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String CREATE_BY = "createBy";
	public static final String SERVICES_REQUESTED = "servicesRequested";
	public static final String WONUMBER = "wonumber";
	public static final String CANCELLED = "cancelled";
	public static final String PROJECT_ID = "projectId";
	public static final String LAST_MOD = "lastMod";
	public static final String CONTACTREFID = "contactrefid";
	public static final String PAPERWORK_RECEIVED = "paperworkReceived";

}

