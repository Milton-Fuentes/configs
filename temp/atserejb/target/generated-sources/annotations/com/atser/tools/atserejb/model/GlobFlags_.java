package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobFlags.class)
public abstract class GlobFlags_ {

	public static volatile SingularAttribute<GlobFlags, Character> usesReportCaching;
	public static volatile SingularAttribute<GlobFlags, Character> usesDiscipline;
	public static volatile SingularAttribute<GlobFlags, Character> usesFunction;
	public static volatile ListAttribute<GlobFlags, GlobFlagsModule> globFlagsModuleList;
	public static volatile SingularAttribute<GlobFlags, Character> usesContract;
	public static volatile SingularAttribute<GlobFlags, Character> usesRequirescip;
	public static volatile SingularAttribute<GlobFlags, Character> usesProgFirstletter;
	public static volatile SingularAttribute<GlobFlags, Character> usesProjectpersonnel;
	public static volatile SingularAttribute<GlobFlags, Character> usesBuckets;
	public static volatile SingularAttribute<GlobFlags, Character> usesContractor;
	public static volatile SingularAttribute<GlobFlags, Character> usesMultiproject;
	public static volatile SingularAttribute<GlobFlags, Character> usesLab;
	public static volatile SingularAttribute<GlobFlags, Character> usesNewmenu;
	public static volatile SingularAttribute<GlobFlags, BigDecimal> id;
	public static volatile SingularAttribute<GlobFlags, Character> usesReadonly;

	public static final String USES_REPORT_CACHING = "usesReportCaching";
	public static final String USES_DISCIPLINE = "usesDiscipline";
	public static final String USES_FUNCTION = "usesFunction";
	public static final String GLOB_FLAGS_MODULE_LIST = "globFlagsModuleList";
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

}

