package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmBiditPrjCatg.class)
public abstract class CmBiditPrjCatg_ {

	public static volatile SingularAttribute<CmBiditPrjCatg, String> lastModBy;
	public static volatile SingularAttribute<CmBiditPrjCatg, Date> bidIssueDate;
	public static volatile SingularAttribute<CmBiditPrjCatg, BigInteger> bidAddendumRev;
	public static volatile SingularAttribute<CmBiditPrjCatg, Character> bidPublished;
	public static volatile SingularAttribute<CmBiditPrjCatg, String> bidNo;
	public static volatile SingularAttribute<CmBiditPrjCatg, String> description;
	public static volatile SingularAttribute<CmBiditPrjCatg, String> lastModIp;
	public static volatile SingularAttribute<CmBiditPrjCatg, String> bpcn;
	public static volatile SingularAttribute<CmBiditPrjCatg, BigDecimal> id;
	public static volatile SingularAttribute<CmBiditPrjCatg, BigInteger> createdById;
	public static volatile SingularAttribute<CmBiditPrjCatg, String> createdByIp;
	public static volatile SingularAttribute<CmBiditPrjCatg, BigInteger> clientId;
	public static volatile SingularAttribute<CmBiditPrjCatg, Date> bidClosingDate;
	public static volatile SingularAttribute<CmBiditPrjCatg, Date> created;
	public static volatile SingularAttribute<CmBiditPrjCatg, Date> bidPublishDate;
	public static volatile SingularAttribute<CmBiditPrjCatg, Character> active;
	public static volatile SingularAttribute<CmBiditPrjCatg, Integer> version;
	public static volatile SingularAttribute<CmBiditPrjCatg, BigInteger> folderId;
	public static volatile SingularAttribute<CmBiditPrjCatg, Character> deleted;
	public static volatile SingularAttribute<CmBiditPrjCatg, BigInteger> statusId;
	public static volatile SingularAttribute<CmBiditPrjCatg, BigInteger> sno;
	public static volatile SingularAttribute<CmBiditPrjCatg, String> createdBy;
	public static volatile SingularAttribute<CmBiditPrjCatg, BigInteger> projectId;
	public static volatile SingularAttribute<CmBiditPrjCatg, String> spattern;
	public static volatile SingularAttribute<CmBiditPrjCatg, Date> lastMod;
	public static volatile SingularAttribute<CmBiditPrjCatg, Character> bidClosed;
	public static volatile ListAttribute<CmBiditPrjCatg, CmBiditPrjItems> cmBiditPrjItemsList;

	public static final String LAST_MOD_BY = "lastModBy";
	public static final String BID_ISSUE_DATE = "bidIssueDate";
	public static final String BID_ADDENDUM_REV = "bidAddendumRev";
	public static final String BID_PUBLISHED = "bidPublished";
	public static final String BID_NO = "bidNo";
	public static final String DESCRIPTION = "description";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String BPCN = "bpcn";
	public static final String ID = "id";
	public static final String CREATED_BY_ID = "createdById";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String BID_CLOSING_DATE = "bidClosingDate";
	public static final String CREATED = "created";
	public static final String BID_PUBLISH_DATE = "bidPublishDate";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String DELETED = "deleted";
	public static final String STATUS_ID = "statusId";
	public static final String SNO = "sno";
	public static final String CREATED_BY = "createdBy";
	public static final String PROJECT_ID = "projectId";
	public static final String SPATTERN = "spattern";
	public static final String LAST_MOD = "lastMod";
	public static final String BID_CLOSED = "bidClosed";
	public static final String CM_BIDIT_PRJ_ITEMS_LIST = "cmBiditPrjItemsList";

}

