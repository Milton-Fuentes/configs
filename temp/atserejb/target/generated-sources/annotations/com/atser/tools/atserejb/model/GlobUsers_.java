package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobUsers.class)
public abstract class GlobUsers_ {

	public static volatile ListAttribute<GlobUsers, CmEmEmail> cmEmEmailList;
	public static volatile SingularAttribute<GlobUsers, String> lastModBy;
	public static volatile SingularAttribute<GlobUsers, String> createDateTmp;
	public static volatile SingularAttribute<GlobUsers, String> tempTmp;
	public static volatile SingularAttribute<GlobUsers, GlobContact> contactid;
	public static volatile SingularAttribute<GlobUsers, String> userid;
	public static volatile SingularAttribute<GlobUsers, Date> lockedTime;
	public static volatile SingularAttribute<GlobUsers, String> lastModIp;
	public static volatile SingularAttribute<GlobUsers, Date> lastAction;
	public static volatile ListAttribute<GlobUsers, GlobCorrespd> globCorrespdList;
	public static volatile SingularAttribute<GlobUsers, String> station;
	public static volatile SingularAttribute<GlobUsers, String> localIp;
	public static volatile SingularAttribute<GlobUsers, BigDecimal> id;
	public static volatile SingularAttribute<GlobUsers, BigInteger> defaultProject;
	public static volatile SingularAttribute<GlobUsers, String> locked;
	public static volatile SingularAttribute<GlobUsers, CmPersoninfo> personinfoId;
	public static volatile SingularAttribute<GlobUsers, Character> resetPass;
	public static volatile SingularAttribute<GlobUsers, Date> createDate;
	public static volatile ListAttribute<GlobUsers, GlobFolderSubscribeAll> globFolderSubscribeAllList;
	public static volatile ListAttribute<GlobUsers, GlobCorrespd> globCorrespdList2;
	public static volatile SingularAttribute<GlobUsers, Date> temp;
	public static volatile ListAttribute<GlobUsers, GlobCorrespd> globCorrespdList1;
	public static volatile ListAttribute<GlobUsers, GlobFolderSubscribe> globFolderSubscribeList;
	public static volatile SingularAttribute<GlobUsers, String> pass;
	public static volatile ListAttribute<GlobUsers, GlobFileSubscribe> globFileSubscribeList;
	public static volatile SingularAttribute<GlobUsers, Character> active;
	public static volatile ListAttribute<GlobUsers, CmEmGroup> cmEmGroupList;
	public static volatile SingularAttribute<GlobUsers, BigInteger> defaultProfile;
	public static volatile SingularAttribute<GlobUsers, BigInteger> badAuthAttempts;
	public static volatile SingularAttribute<GlobUsers, String> createByIp;
	public static volatile SingularAttribute<GlobUsers, Date> passChangedOn;
	public static volatile SingularAttribute<GlobUsers, String> bookmark;
	public static volatile SingularAttribute<GlobUsers, String> createBy;
	public static volatile SingularAttribute<GlobUsers, String> passBak;
	public static volatile SingularAttribute<GlobUsers, Date> inactiveSince;
	public static volatile SingularAttribute<GlobUsers, String> emailSent;
	public static volatile SingularAttribute<GlobUsers, String> usergroup;
	public static volatile SingularAttribute<GlobUsers, String> lastModTmp;
	public static volatile SingularAttribute<GlobUsers, Short> passValidDays;
	public static volatile SingularAttribute<GlobUsers, String> userFilter;
	public static volatile SingularAttribute<GlobUsers, String> lastMod;
	public static volatile SingularAttribute<GlobUsers, Short> status;

	public static final String CM_EM_EMAIL_LIST = "cmEmEmailList";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATE_DATE_TMP = "createDateTmp";
	public static final String TEMP_TMP = "tempTmp";
	public static final String CONTACTID = "contactid";
	public static final String USERID = "userid";
	public static final String LOCKED_TIME = "lockedTime";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String LAST_ACTION = "lastAction";
	public static final String GLOB_CORRESPD_LIST = "globCorrespdList";
	public static final String STATION = "station";
	public static final String LOCAL_IP = "localIp";
	public static final String ID = "id";
	public static final String DEFAULT_PROJECT = "defaultProject";
	public static final String LOCKED = "locked";
	public static final String PERSONINFO_ID = "personinfoId";
	public static final String RESET_PASS = "resetPass";
	public static final String CREATE_DATE = "createDate";
	public static final String GLOB_FOLDER_SUBSCRIBE_ALL_LIST = "globFolderSubscribeAllList";
	public static final String GLOB_CORRESPD_LIST2 = "globCorrespdList2";
	public static final String TEMP = "temp";
	public static final String GLOB_CORRESPD_LIST1 = "globCorrespdList1";
	public static final String GLOB_FOLDER_SUBSCRIBE_LIST = "globFolderSubscribeList";
	public static final String PASS = "pass";
	public static final String GLOB_FILE_SUBSCRIBE_LIST = "globFileSubscribeList";
	public static final String ACTIVE = "active";
	public static final String CM_EM_GROUP_LIST = "cmEmGroupList";
	public static final String DEFAULT_PROFILE = "defaultProfile";
	public static final String BAD_AUTH_ATTEMPTS = "badAuthAttempts";
	public static final String CREATE_BY_IP = "createByIp";
	public static final String PASS_CHANGED_ON = "passChangedOn";
	public static final String BOOKMARK = "bookmark";
	public static final String CREATE_BY = "createBy";
	public static final String PASS_BAK = "passBak";
	public static final String INACTIVE_SINCE = "inactiveSince";
	public static final String EMAIL_SENT = "emailSent";
	public static final String USERGROUP = "usergroup";
	public static final String LAST_MOD_TMP = "lastModTmp";
	public static final String PASS_VALID_DAYS = "passValidDays";
	public static final String USER_FILTER = "userFilter";
	public static final String LAST_MOD = "lastMod";
	public static final String STATUS = "status";

}

