/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.lab.test;

import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
public class LabT27SieveFinecoarseBO {

    private Long id;
    private String sampleid;
    private String operator;
    private String manufacturer;
    private String originalweight;
    private String pan;
    private String panAccu;
    private String total;
    private String catg;
    private List<LabT27SieveFinecoarselistBO> sieveList;
    private Long testId;
    private String status;
    private BigInteger creationdate;
    private String rejectReason;
    private String equipSerialNo;

    public LabT27SieveFinecoarseBO() {
        sieveList = new ArrayList<>();
    }

    private void calPanAccu(String v1) {
        BigDecimal a1 = StringSupport.isNullOrEmpty(v1) ? BigDecimal.ZERO : NumberSupport.getBigDecimal(v1);
        BigDecimal a2 = StringSupport.isNullOrEmpty(this.pan) ? BigDecimal.ZERO : NumberSupport.getBigDecimal(this.pan);
        BigDecimal r = a1.add(a2);
        this.panAccu = r.toString();
    }

    public void addLabT27SieveFinecoarselist(LabT27SieveFinecoarselistBO item) {
        if (sieveList != null && item != null) {
            sieveList.add(item);
        }
    }

    private String sumValues(String v1, String v2) {
        BigDecimal a1 = StringSupport.isNullOrEmpty(v1) ? BigDecimal.ZERO : NumberSupport.getBigDecimal(v1);
        BigDecimal a2 = StringSupport.isNullOrEmpty(v2) ? BigDecimal.ZERO : NumberSupport.getBigDecimal(v2);
        BigDecimal r = a1.add(a2);
        return r.toString();
    }

    public void calAccumLabT27SieveFinecoarselist() {
        this.sieveList = sieveList.stream().sorted(Comparator.comparing(LabT27SieveFinecoarselistBO::getSieveorder)).collect(Collectors.toList());
        for (int i = 0; i < this.sieveList.size(); i++) {
            if (i == 0) {
                this.sieveList.get(i).setSieveaccu(StringSupport.isNullOrEmpty(this.sieveList.get(i).getSievevalue()) ? "0" : this.sieveList.get(i).getSievevalue());
                continue;
            }
            this.sieveList.get(i).setSieveaccu(sumValues(this.sieveList.get(i - 1).getSieveaccu(), this.sieveList.get(i).getSievevalue()));
        }
        if (this.sieveList != null && !this.sieveList.isEmpty()) {
            calPanAccu(this.sieveList.get(this.sieveList.size() - 1).getSieveaccu());
        }
    }

    public String getCutSampleId() {
        try {
            return this.sampleid.substring(0, 11);
        } catch (StringIndexOutOfBoundsException ex) {
            return "";
        }
    }

    public String getCutSerialNo() {
        try {
            return this.sampleid.substring(12);
        } catch (StringIndexOutOfBoundsException ex) {
            return "";
        }
    }

}
