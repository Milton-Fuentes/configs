package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmBiditUserProfile.class)
public abstract class CmBiditUserProfile_ {

	public static volatile SingularAttribute<CmBiditUserProfile, String> createdByIp;
	public static volatile SingularAttribute<CmBiditUserProfile, String> lastModBy;
	public static volatile SingularAttribute<CmBiditUserProfile, Date> created;
	public static volatile SingularAttribute<CmBiditUserProfile, Character> active;
	public static volatile SingularAttribute<CmBiditUserProfile, BigInteger> userId;
	public static volatile SingularAttribute<CmBiditUserProfile, Integer> version;
	public static volatile SingularAttribute<CmBiditUserProfile, BigInteger> folderId;
	public static volatile SingularAttribute<CmBiditUserProfile, BigInteger> companyId;
	public static volatile SingularAttribute<CmBiditUserProfile, String> lastModIp;
	public static volatile SingularAttribute<CmBiditUserProfile, Character> deleted;
	public static volatile SingularAttribute<CmBiditUserProfile, BigInteger> statusId;
	public static volatile SingularAttribute<CmBiditUserProfile, String> createdBy;
	public static volatile SingularAttribute<CmBiditUserProfile, BigInteger> prjCatgId;
	public static volatile SingularAttribute<CmBiditUserProfile, BigDecimal> id;
	public static volatile SingularAttribute<CmBiditUserProfile, Date> lastMod;

	public static final String CREATED_BY_IP = "createdByIp";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String CREATED = "created";
	public static final String ACTIVE = "active";
	public static final String USER_ID = "userId";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String COMPANY_ID = "companyId";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String DELETED = "deleted";
	public static final String STATUS_ID = "statusId";
	public static final String CREATED_BY = "createdBy";
	public static final String PRJ_CATG_ID = "prjCatgId";
	public static final String ID = "id";
	public static final String LAST_MOD = "lastMod";

}

