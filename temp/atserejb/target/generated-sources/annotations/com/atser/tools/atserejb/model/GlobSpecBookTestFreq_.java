package com.atser.tools.atserejb.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobSpecBookTestFreq.class)
public abstract class GlobSpecBookTestFreq_ {

	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigInteger> specBookTestId;
	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigInteger> freqOvt;
	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigInteger> freqIat;
	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigInteger> ovtUomId;
	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigInteger> qaUomId;
	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigInteger> iatUomId;
	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigInteger> uomId;
	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigDecimal> id;
	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigInteger> freqQa;
	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigInteger> qcUomId;
	public static volatile SingularAttribute<GlobSpecBookTestFreq, BigInteger> freqQc;

	public static final String SPEC_BOOK_TEST_ID = "specBookTestId";
	public static final String FREQ_OVT = "freqOvt";
	public static final String FREQ_IAT = "freqIat";
	public static final String OVT_UOM_ID = "ovtUomId";
	public static final String QA_UOM_ID = "qaUomId";
	public static final String IAT_UOM_ID = "iatUomId";
	public static final String UOM_ID = "uomId";
	public static final String ID = "id";
	public static final String FREQ_QA = "freqQa";
	public static final String QC_UOM_ID = "qcUomId";
	public static final String FREQ_QC = "freqQc";

}

