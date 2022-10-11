package com.atser.tools.atserejb.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobPhaseType.class)
public abstract class GlobPhaseType_ {

	public static volatile ListAttribute<GlobPhaseType, GlobContractor> globContractorList;
	public static volatile SingularAttribute<GlobPhaseType, GlobClient> clientId;
	public static volatile ListAttribute<GlobPhaseType, GlobFirms> globFirmsList;
	public static volatile SingularAttribute<GlobPhaseType, Short> id;
	public static volatile SingularAttribute<GlobPhaseType, String> type;

	public static final String GLOB_CONTRACTOR_LIST = "globContractorList";
	public static final String CLIENT_ID = "clientId";
	public static final String GLOB_FIRMS_LIST = "globFirmsList";
	public static final String ID = "id";
	public static final String TYPE = "type";

}

