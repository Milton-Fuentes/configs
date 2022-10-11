package com.atser.tools.atserejb.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionCertofsrc.class)
public abstract class QaInspectionCertofsrc_ {

	public static volatile SingularAttribute<QaInspectionCertofsrc, BigInteger> supplierId;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> inspAddinfo;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> fabricatorLocation;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> fabricatorName;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> productName;
	public static volatile SingularAttribute<QaInspectionCertofsrc, BigInteger> totalItemOnContract;
	public static volatile SingularAttribute<QaInspectionCertofsrc, Character> sampleTest;
	public static volatile SingularAttribute<QaInspectionCertofsrc, Date> verifiedDate;
	public static volatile SingularAttribute<QaInspectionCertofsrc, QaInspection> id;
	public static volatile SingularAttribute<QaInspectionCertofsrc, Character> certOfCompliance;
	public static volatile SingularAttribute<QaInspectionCertofsrc, Character> srcHasBeenVerified;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> supplierName;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> supplierLocation;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> verifiedByJobtitle;
	public static volatile SingularAttribute<QaInspectionCertofsrc, Character> doNotUse;
	public static volatile SingularAttribute<QaInspectionCertofsrc, BigInteger> verifiedBy;
	public static volatile SingularAttribute<QaInspectionCertofsrc, Integer> version;
	public static volatile SingularAttribute<QaInspectionCertofsrc, BigInteger> supplierLocationId;
	public static volatile SingularAttribute<QaInspectionCertofsrc, Character> deleted;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> application;
	public static volatile SingularAttribute<QaInspectionCertofsrc, BigInteger> subBiditemId;
	public static volatile SingularAttribute<QaInspectionCertofsrc, BigInteger> biditemId;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> verifiedByName;
	public static volatile SingularAttribute<QaInspectionCertofsrc, BigInteger> wbsitemId;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> supplierType;
	public static volatile SingularAttribute<QaInspectionCertofsrc, String> remarks;

	public static final String SUPPLIER_ID = "supplierId";
	public static final String INSP_ADDINFO = "inspAddinfo";
	public static final String FABRICATOR_LOCATION = "fabricatorLocation";
	public static final String FABRICATOR_NAME = "fabricatorName";
	public static final String PRODUCT_NAME = "productName";
	public static final String TOTAL_ITEM_ON_CONTRACT = "totalItemOnContract";
	public static final String SAMPLE_TEST = "sampleTest";
	public static final String VERIFIED_DATE = "verifiedDate";
	public static final String ID = "id";
	public static final String CERT_OF_COMPLIANCE = "certOfCompliance";
	public static final String SRC_HAS_BEEN_VERIFIED = "srcHasBeenVerified";
	public static final String SUPPLIER_NAME = "supplierName";
	public static final String SUPPLIER_LOCATION = "supplierLocation";
	public static final String VERIFIED_BY_JOBTITLE = "verifiedByJobtitle";
	public static final String DO_NOT_USE = "doNotUse";
	public static final String VERIFIED_BY = "verifiedBy";
	public static final String VERSION = "version";
	public static final String SUPPLIER_LOCATION_ID = "supplierLocationId";
	public static final String DELETED = "deleted";
	public static final String APPLICATION = "application";
	public static final String SUB_BIDITEM_ID = "subBiditemId";
	public static final String BIDITEM_ID = "biditemId";
	public static final String VERIFIED_BY_NAME = "verifiedByName";
	public static final String WBSITEM_ID = "wbsitemId";
	public static final String SUPPLIER_TYPE = "supplierType";
	public static final String REMARKS = "remarks";

}

