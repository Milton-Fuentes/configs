package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VwBpmProcessBo.class)
public abstract class VwBpmProcessBo_ {

	public static volatile SingularAttribute<VwBpmProcessBo, String> prType;
	public static volatile SingularAttribute<VwBpmProcessBo, BigDecimal> clientId;
	public static volatile SingularAttribute<VwBpmProcessBo, String> projectNumber;
	public static volatile SingularAttribute<VwBpmProcessBo, String> prName;
	public static volatile SingularAttribute<VwBpmProcessBo, String> prStatus;
	public static volatile SingularAttribute<VwBpmProcessBo, BigDecimal> prId;
	public static volatile SingularAttribute<VwBpmProcessBo, String> prCode;
	public static volatile SingularAttribute<VwBpmProcessBo, BigDecimal> id;
	public static volatile SingularAttribute<VwBpmProcessBo, String> prCreated;
	public static volatile SingularAttribute<VwBpmProcessBo, String> prNumber;
	public static volatile SingularAttribute<VwBpmProcessBo, BigDecimal> projectId;

	public static final String PR_TYPE = "prType";
	public static final String CLIENT_ID = "clientId";
	public static final String PROJECT_NUMBER = "projectNumber";
	public static final String PR_NAME = "prName";
	public static final String PR_STATUS = "prStatus";
	public static final String PR_ID = "prId";
	public static final String PR_CODE = "prCode";
	public static final String ID = "id";
	public static final String PR_CREATED = "prCreated";
	public static final String PR_NUMBER = "prNumber";
	public static final String PROJECT_ID = "projectId";

}

