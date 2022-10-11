package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobProjContrPersonnel.class)
public abstract class GlobProjContrPersonnel_ {

	public static volatile SingularAttribute<GlobProjContrPersonnel, BigDecimal> id;
	public static volatile ListAttribute<GlobProjContrPersonnel, QmProjContrPers> qmProjContrPersList;
	public static volatile SingularAttribute<GlobProjContrPersonnel, QmCvlFieldData> contractorTypeId;
	public static volatile SingularAttribute<GlobProjContrPersonnel, GlobContractorPersonnel> contractorPersonnelId;
	public static volatile SingularAttribute<GlobProjContrPersonnel, GlobProject> projectId;
	public static volatile SingularAttribute<GlobProjContrPersonnel, BigInteger> folderId;

	public static final String ID = "id";
	public static final String QM_PROJ_CONTR_PERS_LIST = "qmProjContrPersList";
	public static final String CONTRACTOR_TYPE_ID = "contractorTypeId";
	public static final String CONTRACTOR_PERSONNEL_ID = "contractorPersonnelId";
	public static final String PROJECT_ID = "projectId";
	public static final String FOLDER_ID = "folderId";

}

