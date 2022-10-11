/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.section.SectionAspmMixDesign;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author droldan
 */
public class AspmMixDesignDef implements Serializable {

    @Expose
    private String mixdesignNo;
    @Expose
    private String parentMixdesignNo;
    private String catg;
    @Expose
    private String supplier;
    @Expose
    private String supplierLoc;
    @Expose
    private String mixdesignType;
    private String mixdesignDescription;
    private String mixdesignRemark;
    @Expose
    private String nmasId;
    @Expose
    private String gyrationsId;
    @Expose
    private String trafficLevelId;
    @Expose
    private String pgBinderGradeId;
    @Expose
    private String pgBinderAdditiveId;
    @Expose
    private Double additivePct;
    @Expose
    private String recycleTypeId;
    @Expose
    private Double rapPct;
    @Expose
    private String wmaTechtypeId;
    @Expose
    private String wmaTechnologyId;
    @Expose
    private Double techPct;
    @Expose
    private Double gsb;
    @Expose
    private Double bulkSgGmb;
    @Expose
    private Double gmm;
    @Expose
    private Double desac;
    @Expose
    private Double minac;
    @Expose
    private Double maxac;
    @Expose
    private Double minengac;
    @Expose
    private Double maxengac;
    @Expose
    private Double desvtm;
    @Expose
    private Double minvtm;
    @Expose
    private Double maxvtm;
    @Expose
    private Double minengvtm;
    @Expose
    private Double maxengvtm;
    @Expose
    private Double desvma;
    @Expose
    private Double minvma;
    @Expose
    private Double maxvma;
    @Expose
    private Double minengvma;
    @Expose
    private Double maxengvma;
    @Expose
    private Double desvfa;
    @Expose
    private Double minvfa;
    @Expose
    private Double maxvfa;
    @Expose
    private Double minengvfa;
    @Expose
    private Double maxengvfa;
    @Expose
    private Double gse;
    @Expose
    private Double gasp;
    @Expose
    private Double pba;
    @Expose
    private Double pbe;
    @Expose
    private Double desdpbr;
    @Expose
    private Double mindpbr;
    @Expose
    private Double maxdpbr;
    @Expose
    private Double minengdpbr;
    @Expose
    private Double maxengdpbr;
    private Double mincompfd;
    private Double maxcompfd;
    private Double descompfd;
    private Double blows;
    private Double minstability;
    private Double maxstability;
    private Double desstability;
    private Double minflow;
    private Double maxflow;
    private Double desflow;
    private Double minjointden;
    private Double maxjointden;
    private Double desjointden;
    private Double minmatden;
    private Double maxmatden;
    private Double desmatden;
    private Double minhveemstability;
    private Double maxhveemstability;
    private Double deshveemstability;
    private Double mintsr;
    private Double maxtsr;
    private Double destsr;
    private Double descompfdpcf;
    private Double desmaxtheodens;
    @Expose
    private Double tolminac;
    @Expose
    private Double tolmaxac;
    @Expose
    private Double tolminvtm;
    @Expose
    private Double tolmaxvtm;
    @Expose
    private Double tolminvma;
    @Expose
    private Double tolmaxvma;
    @Expose
    private Double tolminvfa;
    @Expose
    private Double tolmaxvfa;
    @Expose
    private Double tolmindpbr;
    @Expose
    private Double tolmaxdpbr;
    @Expose
    private Double tolminengac;
    @Expose
    private Double tolmaxengac;
    @Expose
    private Double tolminengvtm;
    @Expose
    private Double tolmaxengvtm;
    @Expose
    private Double tolminengvma;
    @Expose
    private Double tolmaxengvma;
    @Expose
    private Double tolminengvfa;
    @Expose
    private Double tolmaxengvfa;
    @Expose
    private Double tolminengdpbr;
    @Expose
    private Double tolmaxengdpbr;
    private Double tolminhveemstability;
    private Double tolmaxhveemstability;
    private Double tolmincompfd;
    private Double tolmaxcompfd;
    private Double dessieve200;
    private Double minsieve200;
    private Double maxsieve200;
    private Double tolminsieve200;
    private Double tolmaxsieve200;
    @Expose
    private String currentJmfNo;
    private String pressCorrFactor;
    private String pressIdSerialNo;
    private Double g1SpecGravAsp;
    private Double acCorrFactor;
    @Expose
    private Date ltmfDate;
    @Expose
    private String setId;
    private String itemId;
    private String matId;
    @Expose
    private Date approvedDate;
    @Expose
    private Date expirationDate;
    @Expose
    private String status;
    private List<Double> gradationList;

    public AspmMixDesignDef() {
        this.status = "PENDING";
        this.gradationList = new ArrayList<>();
    }

    public AspmMixDesignDef(final SectionAspmMixDesign elem) {
        this.status = "PENDING";
        this.gradationList = new ArrayList<>();
        this.mixdesignNo = elem.getMixdesignNo();
        this.supplier = elem.getSupplier();
        this.supplierLoc = elem.getSupplierLoc();
        this.mixdesignType = elem.getMixdesignType();
        this.nmasId = elem.getNmasId();
        this.gyrationsId = elem.getGyrationsId();
        this.trafficLevelId = elem.getTrafficLevelId();
        this.pgBinderGradeId = elem.getPgBinderGradeId();
        this.pgBinderAdditiveId = elem.getPgBinderAdditiveId();
        this.additivePct = elem.getAdditivePct();
        this.recycleTypeId = elem.getRecycleTypeId();
        this.rapPct = elem.getRapPct();
        this.wmaTechtypeId = elem.getWmaTechtypeId();
        this.wmaTechnologyId = elem.getWmaTechnologyId();
        this.techPct = elem.getTechPct();
        this.gsb = elem.getGsb();
        this.bulkSgGmb = elem.getBulkSgGmb();
        this.gmm = elem.getGmm();
        this.desac = elem.getDesac();
        this.desvtm = elem.getDesvtm();
        this.desvma = elem.getDesvma();
        this.desvfa = elem.getDesvfa();
        this.gse = elem.getGse();
        this.gasp = elem.getGasp();
        this.pba = elem.getPba();
        this.pbe = elem.getPbe();
        this.desdpbr = elem.getDesdpbr();
        this.tolminac = elem.getTolminac();
        this.tolmaxac = elem.getTolminac();
        this.tolminvtm = elem.getTolminvtm();
        this.tolmaxvtm = elem.getTolminvtm();
        this.tolminvma = elem.getTolminvma();
        this.tolmaxvma = elem.getTolminvma();
        this.tolminvfa = elem.getTolminvfa();
        this.tolmaxvfa = elem.getTolminvfa();
        this.tolmindpbr = elem.getTolmindpbr();
        this.tolmaxdpbr = elem.getTolmindpbr();
        this.tolminengac = elem.getTolminengac();
        this.tolmaxengac = elem.getTolminengac();
        this.tolminengvtm = elem.getTolminengvtm();
        this.tolmaxengvtm = elem.getTolminengvtm();
        this.tolminengvma = elem.getTolminengvma();
        this.tolmaxengvma = elem.getTolminengvma();
        this.tolminengvfa = elem.getTolminengvfa();
        this.tolmaxengvfa = elem.getTolminengvfa();
        this.tolminengdpbr = elem.getTolminengdpbr();
        this.tolmaxengdpbr = elem.getTolminengdpbr();
        this.currentJmfNo = "1";
        this.ltmfDate = elem.getLtmfDate();
        this.approvedDate = elem.getApprovedDate();
        this.expirationDate = elem.getExpirationDate();
        populateLimits();
        populateGradation(elem);
    }

    private void populateLimits() {
        setMinac(calculateLimit(getDesac(), getTolminac(), "lower"));
        setMaxac(calculateLimit(getDesac(), getTolmaxac(), "upper"));
        setMinengac(calculateLimit(getDesac(), getTolminengac(), "lower"));
        setMaxengac(calculateLimit(getDesac(), getTolmaxengac(), "upper"));
        setMinvtm(calculateLimit(getDesvtm(), getTolminvtm(), "lower"));
        setMaxvtm(calculateLimit(getDesvtm(), getTolmaxvtm(), "upper"));
        setMinengvtm(calculateLimit(getDesvtm(), getTolminengvtm(), "lower"));
        setMaxengvtm(calculateLimit(getDesvtm(), getTolmaxengvtm(), "upper"));
        setMinvma(calculateLimit(getDesvma(), getTolminvma(), "lower"));
        setMaxvma(calculateLimit(getDesvma(), getTolmaxvma(), "upper"));
        setMinengvma(calculateLimit(getDesvma(), getTolminengvma(), "lower"));
        setMaxengvma(calculateLimit(getDesvma(), getTolmaxengvma(), "upper"));
        setMinvfa(calculateLimit(getDesvfa(), getTolminvfa(), "lower"));
        setMaxvfa(calculateLimit(getDesvfa(), getTolmaxvfa(), "upper"));
        setMinengvfa(calculateLimit(getDesvfa(), getTolminengvfa(), "lower"));
        setMaxengvfa(calculateLimit(getDesvfa(), getTolmaxengvfa(), "upper"));
        setMindpbr(calculateLimit(getDesdpbr(), getTolmindpbr(), "lower"));
        setMaxdpbr(calculateLimit(getDesdpbr(), getTolmaxdpbr(), "upper"));
        setMinengdpbr(calculateLimit(getDesdpbr(), getTolminengdpbr(), "lower"));
        setMaxengdpbr(calculateLimit(getDesdpbr(), getTolmaxengdpbr(), "upper"));
    }

    private void populateGradation(final SectionAspmMixDesign elem) {
        try {
            for (Field it : elem.getClass().getDeclaredFields()) {
                if (it.getName().contains("gtc")) {
                    it.setAccessible(true);
                    gradationList.add((Double) it.get(elem));
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(AspmMixDesignDef.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Double calculateLimit(Double target, Double tol, String dir) {
        if (target == null) {
            return 0d;
        }
        if (tol == null) {
            return 0d;
        }
        if (StringSupport.isNullOrEmpty(dir)) {
            return 0d;
        }
        switch (dir) {
            case "lower":
                return target - tol;
            case "upper":
                return target + tol;
        }
        return 0d;
    }

    public String getMixdesignNo() {
        return mixdesignNo;
    }

    public void setMixdesignNo(String mixdesignNo) {
        this.mixdesignNo = mixdesignNo;
    }

    public String getParentMixdesignNo() {
        return parentMixdesignNo;
    }

    public void setParentMixdesignNo(String parentMixdesignNo) {
        this.parentMixdesignNo = parentMixdesignNo;
    }

    public String getCatg() {
        return catg;
    }

    public void setCatg(String catg) {
        this.catg = catg;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierLoc() {
        return supplierLoc;
    }

    public void setSupplierLoc(String supplierLoc) {
        this.supplierLoc = supplierLoc;
    }

    public String getMixdesignType() {
        return mixdesignType;
    }

    public void setMixdesignType(String mixdesignType) {
        this.mixdesignType = mixdesignType;
    }

    public String getMixdesignDescription() {
        return mixdesignDescription;
    }

    public void setMixdesignDescription(String mixdesignDescription) {
        this.mixdesignDescription = mixdesignDescription;
    }

    public String getMixdesignRemark() {
        return mixdesignRemark;
    }

    public void setMixdesignRemark(String mixdesignRemark) {
        this.mixdesignRemark = mixdesignRemark;
    }

    public String getNmasId() {
        return nmasId;
    }

    public void setNmasId(String nmasId) {
        this.nmasId = nmasId;
    }

    public String getGyrationsId() {
        return gyrationsId;
    }

    public void setGyrationsId(String gyrationsId) {
        this.gyrationsId = gyrationsId;
    }

    public String getTrafficLevelId() {
        return trafficLevelId;
    }

    public void setTrafficLevelId(String trafficLevelId) {
        this.trafficLevelId = trafficLevelId;
    }

    public String getPgBinderGradeId() {
        return pgBinderGradeId;
    }

    public void setPgBinderGradeId(String pgBinderGradeId) {
        this.pgBinderGradeId = pgBinderGradeId;
    }

    public String getPgBinderAdditiveId() {
        return pgBinderAdditiveId;
    }

    public void setPgBinderAdditiveId(String pgBinderAdditiveId) {
        this.pgBinderAdditiveId = pgBinderAdditiveId;
    }

    public Double getAdditivePct() {
        return additivePct;
    }

    public void setAdditivePct(Double additivePct) {
        this.additivePct = additivePct;
    }

    public String getRecycleTypeId() {
        return recycleTypeId;
    }

    public void setRecycleTypeId(String recycleTypeId) {
        this.recycleTypeId = recycleTypeId;
    }

    public String getWmaTechtypeId() {
        return wmaTechtypeId;
    }

    public void setWmaTechtypeId(String wmaTechtypeId) {
        this.wmaTechtypeId = wmaTechtypeId;
    }

    public String getWmaTechnologyId() {
        return wmaTechnologyId;
    }

    public void setWmaTechnologyId(String wmaTechnologyId) {
        this.wmaTechnologyId = wmaTechnologyId;
    }

    public Double getTechPct() {
        return techPct;
    }

    public void setTechPct(Double techPct) {
        this.techPct = techPct;
    }

    public Double getGsb() {
        return gsb;
    }

    public void setGsb(Double gsb) {
        this.gsb = gsb;
    }

    public Double getBulkSgGmb() {
        return bulkSgGmb;
    }

    public void setBulkSgGmb(Double bulkSgGmb) {
        this.bulkSgGmb = bulkSgGmb;
    }

    public Double getGmm() {
        return gmm;
    }

    public void setGmm(Double gmm) {
        this.gmm = gmm;
    }

    public Double getDesac() {
        return desac;
    }

    public void setDesac(Double desac) {
        this.desac = desac;
    }

    public Double getMinac() {
        return minac;
    }

    public void setMinac(Double minac) {
        this.minac = minac;
    }

    public Double getMaxac() {
        return maxac;
    }

    public void setMaxac(Double maxac) {
        this.maxac = maxac;
    }

    public Double getMinengac() {
        return minengac;
    }

    public void setMinengac(Double minengac) {
        this.minengac = minengac;
    }

    public Double getMaxengac() {
        return maxengac;
    }

    public void setMaxengac(Double maxengac) {
        this.maxengac = maxengac;
    }

    public Double getDesvtm() {
        return desvtm;
    }

    public void setDesvtm(Double desvtm) {
        this.desvtm = desvtm;
    }

    public Double getMinvtm() {
        return minvtm;
    }

    public void setMinvtm(Double minvtm) {
        this.minvtm = minvtm;
    }

    public Double getMaxvtm() {
        return maxvtm;
    }

    public void setMaxvtm(Double maxvtm) {
        this.maxvtm = maxvtm;
    }

    public Double getMinengvtm() {
        return minengvtm;
    }

    public void setMinengvtm(Double minengvtm) {
        this.minengvtm = minengvtm;
    }

    public Double getMaxengvtm() {
        return maxengvtm;
    }

    public void setMaxengvtm(Double maxengvtm) {
        this.maxengvtm = maxengvtm;
    }

    public Double getDesvma() {
        return desvma;
    }

    public void setDesvma(Double desvma) {
        this.desvma = desvma;
    }

    public Double getMinvma() {
        return minvma;
    }

    public void setMinvma(Double minvma) {
        this.minvma = minvma;
    }

    public Double getMaxvma() {
        return maxvma;
    }

    public void setMaxvma(Double maxvma) {
        this.maxvma = maxvma;
    }

    public Double getMinengvma() {
        return minengvma;
    }

    public void setMinengvma(Double minengvma) {
        this.minengvma = minengvma;
    }

    public Double getMaxengvma() {
        return maxengvma;
    }

    public void setMaxengvma(Double maxengvma) {
        this.maxengvma = maxengvma;
    }

    public Double getDesvfa() {
        return desvfa;
    }

    public void setDesvfa(Double desvfa) {
        this.desvfa = desvfa;
    }

    public Double getMinvfa() {
        return minvfa;
    }

    public void setMinvfa(Double minvfa) {
        this.minvfa = minvfa;
    }

    public Double getMaxvfa() {
        return maxvfa;
    }

    public void setMaxvfa(Double maxvfa) {
        this.maxvfa = maxvfa;
    }

    public Double getMinengvfa() {
        return minengvfa;
    }

    public void setMinengvfa(Double minengvfa) {
        this.minengvfa = minengvfa;
    }

    public Double getMaxengvfa() {
        return maxengvfa;
    }

    public void setMaxengvfa(Double maxengvfa) {
        this.maxengvfa = maxengvfa;
    }

    public Double getGse() {
        return gse;
    }

    public void setGse(Double gse) {
        this.gse = gse;
    }

    public Double getGasp() {
        return gasp;
    }

    public void setGasp(Double gasp) {
        this.gasp = gasp;
    }

    public Double getPba() {
        return pba;
    }

    public void setPba(Double pba) {
        this.pba = pba;
    }

    public Double getPbe() {
        return pbe;
    }

    public void setPbe(Double pbe) {
        this.pbe = pbe;
    }

    public Double getDesdpbr() {
        return desdpbr;
    }

    public void setDesdpbr(Double desdpbr) {
        this.desdpbr = desdpbr;
    }

    public Double getMindpbr() {
        return mindpbr;
    }

    public void setMindpbr(Double mindpbr) {
        this.mindpbr = mindpbr;
    }

    public Double getMaxdpbr() {
        return maxdpbr;
    }

    public void setMaxdpbr(Double maxdpbr) {
        this.maxdpbr = maxdpbr;
    }

    public Double getMinengdpbr() {
        return minengdpbr;
    }

    public void setMinengdpbr(Double minengdpbr) {
        this.minengdpbr = minengdpbr;
    }

    public Double getMaxengdpbr() {
        return maxengdpbr;
    }

    public void setMaxengdpbr(Double maxengdpbr) {
        this.maxengdpbr = maxengdpbr;
    }

    public Double getMincompfd() {
        return mincompfd;
    }

    public void setMincompfd(Double mincompfd) {
        this.mincompfd = mincompfd;
    }

    public Double getMaxcompfd() {
        return maxcompfd;
    }

    public void setMaxcompfd(Double maxcompfd) {
        this.maxcompfd = maxcompfd;
    }

    public Double getDescompfd() {
        return descompfd;
    }

    public void setDescompfd(Double descompfd) {
        this.descompfd = descompfd;
    }

    public Double getBlows() {
        return blows;
    }

    public void setBlows(Double blows) {
        this.blows = blows;
    }

    public Double getMinstability() {
        return minstability;
    }

    public void setMinstability(Double minstability) {
        this.minstability = minstability;
    }

    public Double getMaxstability() {
        return maxstability;
    }

    public void setMaxstability(Double maxstability) {
        this.maxstability = maxstability;
    }

    public Double getDesstability() {
        return desstability;
    }

    public void setDesstability(Double desstability) {
        this.desstability = desstability;
    }

    public Double getMinflow() {
        return minflow;
    }

    public void setMinflow(Double minflow) {
        this.minflow = minflow;
    }

    public Double getMaxflow() {
        return maxflow;
    }

    public void setMaxflow(Double maxflow) {
        this.maxflow = maxflow;
    }

    public Double getDesflow() {
        return desflow;
    }

    public void setDesflow(Double desflow) {
        this.desflow = desflow;
    }

    public Double getMinjointden() {
        return minjointden;
    }

    public void setMinjointden(Double minjointden) {
        this.minjointden = minjointden;
    }

    public Double getMaxjointden() {
        return maxjointden;
    }

    public void setMaxjointden(Double maxjointden) {
        this.maxjointden = maxjointden;
    }

    public Double getDesjointden() {
        return desjointden;
    }

    public void setDesjointden(Double desjointden) {
        this.desjointden = desjointden;
    }

    public Double getMinmatden() {
        return minmatden;
    }

    public void setMinmatden(Double minmatden) {
        this.minmatden = minmatden;
    }

    public Double getMaxmatden() {
        return maxmatden;
    }

    public void setMaxmatden(Double maxmatden) {
        this.maxmatden = maxmatden;
    }

    public Double getDesmatden() {
        return desmatden;
    }

    public void setDesmatden(Double desmatden) {
        this.desmatden = desmatden;
    }

    public Double getMinhveemstability() {
        return minhveemstability;
    }

    public void setMinhveemstability(Double minhveemstability) {
        this.minhveemstability = minhveemstability;
    }

    public Double getMaxhveemstability() {
        return maxhveemstability;
    }

    public void setMaxhveemstability(Double maxhveemstability) {
        this.maxhveemstability = maxhveemstability;
    }

    public Double getDeshveemstability() {
        return deshveemstability;
    }

    public void setDeshveemstability(Double deshveemstability) {
        this.deshveemstability = deshveemstability;
    }

    public Double getMintsr() {
        return mintsr;
    }

    public void setMintsr(Double mintsr) {
        this.mintsr = mintsr;
    }

    public Double getMaxtsr() {
        return maxtsr;
    }

    public void setMaxtsr(Double maxtsr) {
        this.maxtsr = maxtsr;
    }

    public Double getDestsr() {
        return destsr;
    }

    public void setDestsr(Double destsr) {
        this.destsr = destsr;
    }

    public Double getDescompfdpcf() {
        return descompfdpcf;
    }

    public void setDescompfdpcf(Double descompfdpcf) {
        this.descompfdpcf = descompfdpcf;
    }

    public Double getDesmaxtheodens() {
        return desmaxtheodens;
    }

    public void setDesmaxtheodens(Double desmaxtheodens) {
        this.desmaxtheodens = desmaxtheodens;
    }

    public Double getTolminac() {
        return tolminac;
    }

    public void setTolminac(Double tolminac) {
        this.tolminac = tolminac;
    }

    public Double getTolmaxac() {
        return tolmaxac;
    }

    public void setTolmaxac(Double tolmaxac) {
        this.tolmaxac = tolmaxac;
    }

    public Double getTolminvtm() {
        return tolminvtm;
    }

    public void setTolminvtm(Double tolminvtm) {
        this.tolminvtm = tolminvtm;
    }

    public Double getTolmaxvtm() {
        return tolmaxvtm;
    }

    public void setTolmaxvtm(Double tolmaxvtm) {
        this.tolmaxvtm = tolmaxvtm;
    }

    public Double getTolminvma() {
        return tolminvma;
    }

    public void setTolminvma(Double tolminvma) {
        this.tolminvma = tolminvma;
    }

    public Double getTolmaxvma() {
        return tolmaxvma;
    }

    public void setTolmaxvma(Double tolmaxvma) {
        this.tolmaxvma = tolmaxvma;
    }

    public Double getTolminvfa() {
        return tolminvfa;
    }

    public void setTolminvfa(Double tolminvfa) {
        this.tolminvfa = tolminvfa;
    }

    public Double getTolmaxvfa() {
        return tolmaxvfa;
    }

    public void setTolmaxvfa(Double tolmaxvfa) {
        this.tolmaxvfa = tolmaxvfa;
    }

    public Double getTolmindpbr() {
        return tolmindpbr;
    }

    public void setTolmindpbr(Double tolmindpbr) {
        this.tolmindpbr = tolmindpbr;
    }

    public Double getTolmaxdpbr() {
        return tolmaxdpbr;
    }

    public void setTolmaxdpbr(Double tolmaxdpbr) {
        this.tolmaxdpbr = tolmaxdpbr;
    }

    public Double getTolminengac() {
        return tolminengac;
    }

    public void setTolminengac(Double tolminengac) {
        this.tolminengac = tolminengac;
    }

    public Double getTolmaxengac() {
        return tolmaxengac;
    }

    public void setTolmaxengac(Double tolmaxengac) {
        this.tolmaxengac = tolmaxengac;
    }

    public Double getTolminengvtm() {
        return tolminengvtm;
    }

    public void setTolminengvtm(Double tolminengvtm) {
        this.tolminengvtm = tolminengvtm;
    }

    public Double getTolmaxengvtm() {
        return tolmaxengvtm;
    }

    public void setTolmaxengvtm(Double tolmaxengvtm) {
        this.tolmaxengvtm = tolmaxengvtm;
    }

    public Double getTolminengvma() {
        return tolminengvma;
    }

    public void setTolminengvma(Double tolminengvma) {
        this.tolminengvma = tolminengvma;
    }

    public Double getTolmaxengvma() {
        return tolmaxengvma;
    }

    public void setTolmaxengvma(Double tolmaxengvma) {
        this.tolmaxengvma = tolmaxengvma;
    }

    public Double getTolminengvfa() {
        return tolminengvfa;
    }

    public void setTolminengvfa(Double tolminengvfa) {
        this.tolminengvfa = tolminengvfa;
    }

    public Double getTolmaxengvfa() {
        return tolmaxengvfa;
    }

    public void setTolmaxengvfa(Double tolmaxengvfa) {
        this.tolmaxengvfa = tolmaxengvfa;
    }

    public Double getTolminengdpbr() {
        return tolminengdpbr;
    }

    public void setTolminengdpbr(Double tolminengdpbr) {
        this.tolminengdpbr = tolminengdpbr;
    }

    public Double getTolmaxengdpbr() {
        return tolmaxengdpbr;
    }

    public void setTolmaxengdpbr(Double tolmaxengdpbr) {
        this.tolmaxengdpbr = tolmaxengdpbr;
    }

    public Double getTolminhveemstability() {
        return tolminhveemstability;
    }

    public void setTolminhveemstability(Double tolminhveemstability) {
        this.tolminhveemstability = tolminhveemstability;
    }

    public Double getTolmaxhveemstability() {
        return tolmaxhveemstability;
    }

    public void setTolmaxhveemstability(Double tolmaxhveemstability) {
        this.tolmaxhveemstability = tolmaxhveemstability;
    }

    public Double getTolmincompfd() {
        return tolmincompfd;
    }

    public void setTolmincompfd(Double tolmincompfd) {
        this.tolmincompfd = tolmincompfd;
    }

    public Double getTolmaxcompfd() {
        return tolmaxcompfd;
    }

    public void setTolmaxcompfd(Double tolmaxcompfd) {
        this.tolmaxcompfd = tolmaxcompfd;
    }

    public Double getDessieve200() {
        return dessieve200;
    }

    public void setDessieve200(Double dessieve200) {
        this.dessieve200 = dessieve200;
    }

    public Double getMinsieve200() {
        return minsieve200;
    }

    public void setMinsieve200(Double minsieve200) {
        this.minsieve200 = minsieve200;
    }

    public Double getMaxsieve200() {
        return maxsieve200;
    }

    public void setMaxsieve200(Double maxsieve200) {
        this.maxsieve200 = maxsieve200;
    }

    public Double getTolminsieve200() {
        return tolminsieve200;
    }

    public void setTolminsieve200(Double tolminsieve200) {
        this.tolminsieve200 = tolminsieve200;
    }

    public Double getTolmaxsieve200() {
        return tolmaxsieve200;
    }

    public void setTolmaxsieve200(Double tolmaxsieve200) {
        this.tolmaxsieve200 = tolmaxsieve200;
    }

    public String getCurrentJmfNo() {
        return currentJmfNo;
    }

    public void setCurrentJmfNo(String currentJmfNo) {
        this.currentJmfNo = currentJmfNo;
    }

    public String getPressCorrFactor() {
        return pressCorrFactor;
    }

    public void setPressCorrFactor(String pressCorrFactor) {
        this.pressCorrFactor = pressCorrFactor;
    }

    public String getPressIdSerialNo() {
        return pressIdSerialNo;
    }

    public void setPressIdSerialNo(String pressIdSerialNo) {
        this.pressIdSerialNo = pressIdSerialNo;
    }

    public Double getG1SpecGravAsp() {
        return g1SpecGravAsp;
    }

    public void setG1SpecGravAsp(Double g1SpecGravAsp) {
        this.g1SpecGravAsp = g1SpecGravAsp;
    }

    public Double getAcCorrFactor() {
        return acCorrFactor;
    }

    public void setAcCorrFactor(Double acCorrFactor) {
        this.acCorrFactor = acCorrFactor;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLtmfDate() {
        return ltmfDate;
    }

    public void setLtmfDate(Date ltmfDate) {
        this.ltmfDate = ltmfDate;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getMatId() {
        return matId;
    }

    public void setMatId(String matId) {
        this.matId = matId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Double> getGradationList() {
        return gradationList;
    }

    public void setGradationList(List<Double> gradationList) {
        this.gradationList = gradationList;
    }

    public Double getRapPct() {
        return rapPct;
    }

    public void setRapPct(Double rapPct) {
        this.rapPct = rapPct;
    }
}
