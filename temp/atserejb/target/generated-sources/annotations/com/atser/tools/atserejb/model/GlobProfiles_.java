package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProfiles.class)
public abstract class GlobProfiles_ {

	public static volatile SingularAttribute<GlobProfiles, GlobClient> clientId;
	public static volatile SingularAttribute<GlobProfiles, GlobRoles> roleId;
	public static volatile SingularAttribute<GlobProfiles, BigInteger> contractorId;
	public static volatile SingularAttribute<GlobProfiles, GlobDisciplines> disciplineId;
	public static volatile SingularAttribute<GlobProfiles, String> isPreferred;
	public static volatile SingularAttribute<GlobProfiles, BigInteger> userId;
	public static volatile SingularAttribute<GlobProfiles, GlobFunctions> functionId;
	public static volatile SingularAttribute<GlobProfiles, Character> readonly;
	public static volatile SingularAttribute<GlobProfiles, BigInteger> labId;
	public static volatile SingularAttribute<GlobProfiles, BigInteger> contractId;
	public static volatile SingularAttribute<GlobProfiles, BigDecimal> id;
	public static volatile SingularAttribute<GlobProfiles, BigInteger> moduleId;
	public static volatile SingularAttribute<GlobProfiles, BigInteger> projectId;
	public static volatile SingularAttribute<GlobProfiles, BigInteger> contractorContractId;

	public static final String CLIENT_ID = "clientId";
	public static final String ROLE_ID = "roleId";
	public static final String CONTRACTOR_ID = "contractorId";
	public static final String DISCIPLINE_ID = "disciplineId";
	public static final String IS_PREFERRED = "isPreferred";
	public static final String USER_ID = "userId";
	public static final String FUNCTION_ID = "functionId";
	public static final String READONLY = "readonly";
	public static final String LAB_ID = "labId";
	public static final String CONTRACT_ID = "contractId";
	public static final String ID = "id";
	public static final String MODULE_ID = "moduleId";
	public static final String PROJECT_ID = "projectId";
	public static final String CONTRACTOR_CONTRACT_ID = "contractorContractId";

}

