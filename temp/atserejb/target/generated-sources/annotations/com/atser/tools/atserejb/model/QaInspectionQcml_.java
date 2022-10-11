package com.atser.tools.atserejb.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QaInspectionQcml.class)
public abstract class QaInspectionQcml_ {

	public static volatile SingularAttribute<QaInspectionQcml, String> supplierName;
	public static volatile SingularAttribute<QaInspectionQcml, BigInteger> supplierId;
	public static volatile SingularAttribute<QaInspectionQcml, BigInteger> qcmlCategoryId;
	public static volatile SingularAttribute<QaInspectionQcml, String> supplierLocation;
	public static volatile SingularAttribute<QaInspectionQcml, String> verifiedByJobtitle;
	public static volatile SingularAttribute<QaInspectionQcml, String> productBarchNo;
	public static volatile SingularAttribute<QaInspectionQcml, Date> castingDate;
	public static volatile SingularAttribute<QaInspectionQcml, BigInteger> verifiedBy;
	public static volatile SingularAttribute<QaInspectionQcml, Integer> version;
	public static volatile SingularAttribute<QaInspectionQcml, Date> approvedDate;
	public static volatile SingularAttribute<QaInspectionQcml, BigInteger> supplierLocationId;
	public static volatile SingularAttribute<QaInspectionQcml, Character> deleted;
	public static volatile SingularAttribute<QaInspectionQcml, BigInteger> subBiditemId;
	public static volatile SingularAttribute<QaInspectionQcml, Date> verifiedDate;
	public static volatile SingularAttribute<QaInspectionQcml, String> qcmlAddinfo;
	public static volatile SingularAttribute<QaInspectionQcml, BigInteger> biditemId;
	public static volatile SingularAttribute<QaInspectionQcml, String> verifiedByName;
	public static volatile SingularAttribute<QaInspectionQcml, BigInteger> wbsitemId;
	public static volatile SingularAttribute<QaInspectionQcml, String> productIdentificationNo;
	public static volatile SingularAttribute<QaInspectionQcml, QaInspection> id;
	public static volatile SingularAttribute<QaInspectionQcml, String> supplierType;
	public static volatile SingularAttribute<QaInspectionQcml, String> productType;
	public static volatile SingularAttribute<QaInspectionQcml, String> remarks;
	public static volatile SingularAttribute<QaInspectionQcml, Date> expirationDate;

	public static final String SUPPLIER_NAME = "supplierName";
	public static final String SUPPLIER_ID = "supplierId";
	public static final String QCML_CATEGORY_ID = "qcmlCategoryId";
	public static final String SUPPLIER_LOCATION = "supplierLocation";
	public static final String VERIFIED_BY_JOBTITLE = "verifiedByJobtitle";
	public static final String PRODUCT_BARCH_NO = "productBarchNo";
	public static final String CASTING_DATE = "castingDate";
	public static final String VERIFIED_BY = "verifiedBy";
	public static final String VERSION = "version";
	public static final String APPROVED_DATE = "approvedDate";
	public static final String SUPPLIER_LOCATION_ID = "supplierLocationId";
	public static final String DELETED = "deleted";
	public static final String SUB_BIDITEM_ID = "subBiditemId";
	public static final String VERIFIED_DATE = "verifiedDate";
	public static final String QCML_ADDINFO = "qcmlAddinfo";
	public static final String BIDITEM_ID = "biditemId";
	public static final String VERIFIED_BY_NAME = "verifiedByName";
	public static final String WBSITEM_ID = "wbsitemId";
	public static final String PRODUCT_IDENTIFICATION_NO = "productIdentificationNo";
	public static final String ID = "id";
	public static final String SUPPLIER_TYPE = "supplierType";
	public static final String PRODUCT_TYPE = "productType";
	public static final String REMARKS = "remarks";
	public static final String EXPIRATION_DATE = "expirationDate";

}

