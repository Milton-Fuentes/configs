package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFlagsModule.class)
public abstract class GlobFlagsModule_ {

	public static volatile SingularAttribute<GlobFlagsModule, Character> usesReportCaching;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesDiscipline;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesFunction;
	public static volatile SingularAttribute<GlobFlagsModule, GlobFlags> flagId;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesContract;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesRequirescip;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesProgFirstletter;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesProjectpersonnel;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesBuckets;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesContractor;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesMultiproject;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesLab;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesNewmenu;
	public static volatile SingularAttribute<GlobFlagsModule, BigDecimal> id;
	public static volatile SingularAttribute<GlobFlagsModule, Character> usesReadonly;
	public static volatile SingularAttribute<GlobFlagsModule, GlobModule> moduleId;

	public static final String USES_REPORT_CACHING = "usesReportCaching";
	public static final String USES_DISCIPLINE = "usesDiscipline";
	public static final String USES_FUNCTION = "usesFunction";
	public static final String FLAG_ID = "flagId";
	public static final String USES_CONTRACT = "usesContract";
	public static final String USES_REQUIRESCIP = "usesRequirescip";
	public static final String USES_PROG_FIRSTLETTER = "usesProgFirstletter";
	public static final String USES_PROJECTPERSONNEL = "usesProjectpersonnel";
	public static final String USES_BUCKETS = "usesBuckets";
	public static final String USES_CONTRACTOR = "usesContractor";
	public static final String USES_MULTIPROJECT = "usesMultiproject";
	public static final String USES_LAB = "usesLab";
	public static final String USES_NEWMENU = "usesNewmenu";
	public static final String ID = "id";
	public static final String USES_READONLY = "usesReadonly";
	public static final String MODULE_ID = "moduleId";

}

