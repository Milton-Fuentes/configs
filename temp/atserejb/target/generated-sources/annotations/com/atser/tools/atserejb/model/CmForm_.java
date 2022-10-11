package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmForm.class)
public abstract class CmForm_ {

	public static volatile SingularAttribute<CmForm, String> lastModBy;
	public static volatile SingularAttribute<CmForm, Character> bpmProcessDone;
	public static volatile SingularAttribute<CmForm, Date> timecostAppvDate;
	public static volatile SingularAttribute<CmForm, BigInteger> formTypeId;
	public static volatile SingularAttribute<CmForm, Character> active;
	public static volatile SingularAttribute<CmForm, Date> technicalAppvDate;
	public static volatile ListAttribute<CmForm, CmFormData> cmFormDataList;
	public static volatile SingularAttribute<CmForm, Character> technicalAppv;
	public static volatile SingularAttribute<CmForm, String> createByIp;
	public static volatile SingularAttribute<CmForm, BigInteger> parentId;
	public static volatile ListAttribute<CmForm, CmFormAttach> cmFormAttachList;
	public static volatile SingularAttribute<CmForm, String> createBy;
	public static volatile SingularAttribute<CmForm, String> lastModIp;
	public static volatile SingularAttribute<CmForm, Date> alerted;
	public static volatile SingularAttribute<CmForm, Character> timecostAppv;
	public static volatile SingularAttribute<CmForm, BigInteger> contractId;
	public static volatile SingularAttribute<CmForm, BigDecimal> id;
	public static volatile ListAttribute<CmForm, CmFormRouting> cmFormRoutingList;
	public static volatile SingularAttribute<CmForm, Date> lastMod;
	public static volatile SingularAttribute<CmForm, Date> alertedClose;
	public static volatile SingularAttribute<CmForm, Date> createDate;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String BPM_PROCESS_DONE = "bpmProcessDone";
	public static final String TIMECOST_APPV_DATE = "timecostAppvDate";
	public static final String FORM_TYPE_ID = "formTypeId";
	public static final String ACTIVE = "active";
	public static final String TECHNICAL_APPV_DATE = "technicalAppvDate";
	public static final String CM_FORM_DATA_LIST = "cmFormDataList";
	public static final String TECHNICAL_APPV = "technicalAppv";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String PARENT_ID = "parentId";
	public static final String CM_FORM_ATTACH_LIST = "cmFormAttachList";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String ALERTED = "alerted";
	public static final String TIMECOST_APPV = "timecostAppv";
	public static final String CONTRACT_ID = "contractId";
	public static final String ID = "id";
	public static final String CM_FORM_ROUTING_LIST = "cmFormRoutingList";
	public static final String LAST_MOD = "lastMod";
	public static final String ALERTED_CLOSE = "alertedClose";
	public static final String CREATE_DATE = "createDate";

}

