package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobRiskRegister.class)
public abstract class GlobRiskRegister_ {

	public static volatile SingularAttribute<GlobRiskRegister, String> expectedRespImpact;
	public static volatile SingularAttribute<GlobRiskRegister, String> lastModBy;
	public static volatile SingularAttribute<GlobRiskRegister, BigInteger> positiveRiskResp;
	public static volatile SingularAttribute<GlobRiskRegister, BigInteger> negativeRiskResp;
	public static volatile SingularAttribute<GlobRiskRegister, String> riskOwner;
	public static volatile SingularAttribute<GlobRiskRegister, String> lastModIp;
	public static volatile SingularAttribute<GlobRiskRegister, String> respTrigger;
	public static volatile SingularAttribute<GlobRiskRegister, BigDecimal> id;
	public static volatile SingularAttribute<GlobRiskRegister, String> rpcn;
	public static volatile SingularAttribute<GlobRiskRegister, String> createdByIp;
	public static volatile SingularAttribute<GlobRiskRegister, BigInteger> clientId;
	public static volatile SingularAttribute<GlobRiskRegister, String> respDescription;
	public static volatile SingularAttribute<GlobRiskRegister, BigInteger> probability;
	public static volatile SingularAttribute<GlobRiskRegister, Date> created;
	public static volatile SingularAttribute<GlobRiskRegister, BigInteger> impact;
	public static volatile SingularAttribute<GlobRiskRegister, Character> active;
	public static volatile SingularAttribute<GlobRiskRegister, Integer> version;
	public static volatile SingularAttribute<GlobRiskRegister, BigInteger> folderId;
	public static volatile SingularAttribute<GlobRiskRegister, String> respOwner;
	public static volatile SingularAttribute<GlobRiskRegister, Character> deleted;
	public static volatile SingularAttribute<GlobRiskRegister, BigInteger> statusId;
	public static volatile SingularAttribute<GlobRiskRegister, BigInteger> sno;
	public static volatile SingularAttribute<GlobRiskRegister, String> riskNo;
	public static volatile SingularAttribute<GlobRiskRegister, BigInteger> riskCatg;
	public static volatile SingularAttribute<GlobRiskRegister, String> expectedResult;
	public static volatile SingularAttribute<GlobRiskRegister, String> createdBy;
	public static volatile SingularAttribute<GlobRiskRegister, String> riskTrigger;
	public static volatile SingularAttribute<GlobRiskRegister, String> risk;
	public static volatile SingularAttribute<GlobRiskRegister, String> refId;
	public static volatile SingularAttribute<GlobRiskRegister, BigInteger> projectId;
	public static volatile SingularAttribute<GlobRiskRegister, String> spattern;
	public static volatile SingularAttribute<GlobRiskRegister, Date> lastMod;

	public static final String EXPECTED_RESP_IMPACT = "expectedRespImpact";
	public static final String LAST_MOD_BY = "lastModBy";
	public static final String POSITIVE_RISK_RESP = "positiveRiskResp";
	public static final String NEGATIVE_RISK_RESP = "negativeRiskResp";
	public static final String RISK_OWNER = "riskOwner";
	public static final String LAST_MOD_IP = "lastModIp";
	public static final String RESP_TRIGGER = "respTrigger";
	public static final String ID = "id";
	public static final String RPCN = "rpcn";
	public static final String CREATED_BY_IP = "createdByIp";
	public static final String CLIENT_ID = "clientId";
	public static final String RESP_DESCRIPTION = "respDescription";
	public static final String PROBABILITY = "probability";
	public static final String CREATED = "created";
	public static final String IMPACT = "impact";
	public static final String ACTIVE = "active";
	public static final String VERSION = "version";
	public static final String FOLDER_ID = "folderId";
	public static final String RESP_OWNER = "respOwner";
	public static final String DELETED = "deleted";
	public static final String STATUS_ID = "statusId";
	public static final String SNO = "sno";
	public static final String RISK_NO = "riskNo";
	public static final String RISK_CATG = "riskCatg";
	public static final String EXPECTED_RESULT = "expectedResult";
	public static final String CREATED_BY = "createdBy";
	public static final String RISK_TRIGGER = "riskTrigger";
	public static final String RISK = "risk";
	public static final String REF_ID = "refId";
	public static final String PROJECT_ID = "projectId";
	public static final String SPATTERN = "spattern";
	public static final String LAST_MOD = "lastMod";

}

