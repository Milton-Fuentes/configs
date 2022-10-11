/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.qa.mixdesign;

import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.GradationPojo;
import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.JmfMasterPojo;
import java.util.List;

/**
 *
 * @author droldan
 */
public class QaaspmMixDesignsTO {

    private String mixdesignNo;
    private String parentMixdesignNo;
    private String catg;
    private String supplier;
    private String supplierLoc;
    private String mixdesignType;
    private String mixdesignDescription;
    private String mixdesignRemark;
    private String nmasId;
    private String gyrationsId;
    private String trafficLevelId;
    private String pgBinderGradeId;
    private String pgBinderAdditiveId;
    private String additivePct;
    private String recycleTypeId;
    private String wmaTechtypeId;
    private String wmaTechnologyId;
    private String techPct;
    private String gsb;
    private String bulkSgGmb;
    private String gmm;
    private String desac;
    private String minac;
    private String maxac;
    private String minengac;
    private String maxengac;
    private String desvtm;
    private String minvtm;
    private String maxvtm;
    private String minengvtm;
    private String maxengvtm;
    private String desvma;
    private String minvma;
    private String maxvma;
    private String minengvma;
    private String maxengvma;
    private String desvfa;
    private String minvfa;
    private String maxvfa;
    private String minengvfa;
    private String maxengvfa;
    private String gse;
    private String gasp;
    private String pba;
    private String pbe;
    private String desdpbr;
    private String mindpbr;
    private String maxdpbr;
    private String minengdpbr;
    private String maxengdpbr;
    private String mincompfd;
    private String maxcompfd;
    private String descompfd;
    private String blows;
    private String minstability;
    private String maxstability;
    private String desstability;
    private String minflow;
    private String maxflow;
    private String desflow;
    private String minjointden;
    private String maxjointden;
    private String desjointden;
    private String minmatden;
    private String maxmatden;
    private String desmatden;
    private String minhveemstability;
    private String maxhveemstability;
    private String deshveemstability;
    private String mintsr;
    private String maxtsr;
    private String destsr;
    private String descompfdpcf;
    private String desmaxtheodens;
    private String tolminac;
    private String tolmaxac;
    private String tolminvtm;
    private String tolmaxvtm;
    private String tolminvma;
    private String tolmaxvma;
    private String tolminvfa;
    private String tolmaxvfa;
    private String tolmindpbr;
    private String tolmaxdpbr;
    private String tolminengac;
    private String tolmaxengac;
    private String tolminengvtm;
    private String tolmaxengvtm;
    private String tolminengvma;
    private String tolmaxengvma;
    private String tolminengvfa;
    private String tolmaxengvfa;
    private String tolminengdpbr;
    private String tolmaxengdpbr;
    private String tolminhveemstability;
    private String tolmaxhveemstability;
    private String tolmincompfd;
    private String tolmaxcompfd;
    private String dessieve200;
    private String minsieve200;
    private String maxsieve200;
    private String tolminsieve200;
    private String tolmaxsieve200;
    private String currentJmfNo;
    private String rapPct;
    private String pressCorrFactor;
    private String pressIdSerialNo;
    private String g1SpecGravAsp;
    private String acCorrFactor;
    private String ltmfDate;
    private String setId;
    private String itemId; // fill
    private String matId; // fill
    private String approvedDate;
    private String expirationDate;
    private String status;
    private String mixStatus;
    private String created;
    private String pNumber;
    private JmfMasterPojo mainJmf;
    private List<GradationPojo> gradationList;

    public QaaspmMixDesignsTO() {
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

    public String getAdditivePct() {
        return additivePct;
    }

    public void setAdditivePct(String additivePct) {
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

    public String getTechPct() {
        return techPct;
    }

    public void setTechPct(String techPct) {
        this.techPct = techPct;
    }

    public String getGsb() {
        return gsb;
    }

    public void setGsb(String gsb) {
        this.gsb = gsb;
    }

    public String getBulkSgGmb() {
        return bulkSgGmb;
    }

    public void setBulkSgGmb(String bulkSgGmb) {
        this.bulkSgGmb = bulkSgGmb;
    }

    public String getGmm() {
        return gmm;
    }

    public void setGmm(String gmm) {
        this.gmm = gmm;
    }

    public String getDesac() {
        return desac;
    }

    public void setDesac(String desac) {
        this.desac = desac;
    }

    public String getMinac() {
        return minac;
    }

    public void setMinac(String minac) {
        this.minac = minac;
    }

    public String getMaxac() {
        return maxac;
    }

    public void setMaxac(String maxac) {
        this.maxac = maxac;
    }

    public String getMinengac() {
        return minengac;
    }

    public void setMinengac(String minengac) {
        this.minengac = minengac;
    }

    public String getMaxengac() {
        return maxengac;
    }

    public void setMaxengac(String maxengac) {
        this.maxengac = maxengac;
    }

    public String getDesvtm() {
        return desvtm;
    }

    public void setDesvtm(String desvtm) {
        this.desvtm = desvtm;
    }

    public String getMinvtm() {
        return minvtm;
    }

    public void setMinvtm(String minvtm) {
        this.minvtm = minvtm;
    }

    public String getMaxvtm() {
        return maxvtm;
    }

    public void setMaxvtm(String maxvtm) {
        this.maxvtm = maxvtm;
    }

    public String getMinengvtm() {
        return minengvtm;
    }

    public void setMinengvtm(String minengvtm) {
        this.minengvtm = minengvtm;
    }

    public String getMaxengvtm() {
        return maxengvtm;
    }

    public void setMaxengvtm(String maxengvtm) {
        this.maxengvtm = maxengvtm;
    }

    public String getDesvma() {
        return desvma;
    }

    public void setDesvma(String desvma) {
        this.desvma = desvma;
    }

    public String getMinvma() {
        return minvma;
    }

    public void setMinvma(String minvma) {
        this.minvma = minvma;
    }

    public String getMaxvma() {
        return maxvma;
    }

    public void setMaxvma(String maxvma) {
        this.maxvma = maxvma;
    }

    public String getMinengvma() {
        return minengvma;
    }

    public void setMinengvma(String minengvma) {
        this.minengvma = minengvma;
    }

    public String getMaxengvma() {
        return maxengvma;
    }

    public void setMaxengvma(String maxengvma) {
        this.maxengvma = maxengvma;
    }

    public String getDesvfa() {
        return desvfa;
    }

    public void setDesvfa(String desvfa) {
        this.desvfa = desvfa;
    }

    public String getMinvfa() {
        return minvfa;
    }

    public void setMinvfa(String minvfa) {
        this.minvfa = minvfa;
    }

    public String getMaxvfa() {
        return maxvfa;
    }

    public void setMaxvfa(String maxvfa) {
        this.maxvfa = maxvfa;
    }

    public String getMinengvfa() {
        return minengvfa;
    }

    public void setMinengvfa(String minengvfa) {
        this.minengvfa = minengvfa;
    }

    public String getMaxengvfa() {
        return maxengvfa;
    }

    public void setMaxengvfa(String maxengvfa) {
        this.maxengvfa = maxengvfa;
    }

    public String getGse() {
        return gse;
    }

    public void setGse(String gse) {
        this.gse = gse;
    }

    public String getGasp() {
        return gasp;
    }

    public void setGasp(String gasp) {
        this.gasp = gasp;
    }

    public String getPba() {
        return pba;
    }

    public void setPba(String pba) {
        this.pba = pba;
    }

    public String getPbe() {
        return pbe;
    }

    public void setPbe(String pbe) {
        this.pbe = pbe;
    }

    public String getDesdpbr() {
        return desdpbr;
    }

    public void setDesdpbr(String desdpbr) {
        this.desdpbr = desdpbr;
    }

    public String getMindpbr() {
        return mindpbr;
    }

    public void setMindpbr(String mindpbr) {
        this.mindpbr = mindpbr;
    }

    public String getMaxdpbr() {
        return maxdpbr;
    }

    public void setMaxdpbr(String maxdpbr) {
        this.maxdpbr = maxdpbr;
    }

    public String getMinengdpbr() {
        return minengdpbr;
    }

    public void setMinengdpbr(String minengdpbr) {
        this.minengdpbr = minengdpbr;
    }

    public String getMaxengdpbr() {
        return maxengdpbr;
    }

    public void setMaxengdpbr(String maxengdpbr) {
        this.maxengdpbr = maxengdpbr;
    }

    public String getMincompfd() {
        return mincompfd;
    }

    public void setMincompfd(String mincompfd) {
        this.mincompfd = mincompfd;
    }

    public String getMaxcompfd() {
        return maxcompfd;
    }

    public void setMaxcompfd(String maxcompfd) {
        this.maxcompfd = maxcompfd;
    }

    public String getDescompfd() {
        return descompfd;
    }

    public void setDescompfd(String descompfd) {
        this.descompfd = descompfd;
    }

    public String getBlows() {
        return blows;
    }

    public void setBlows(String blows) {
        this.blows = blows;
    }

    public String getMinstability() {
        return minstability;
    }

    public void setMinstability(String minstability) {
        this.minstability = minstability;
    }

    public String getMaxstability() {
        return maxstability;
    }

    public void setMaxstability(String maxstability) {
        this.maxstability = maxstability;
    }

    public String getDesstability() {
        return desstability;
    }

    public void setDesstability(String desstability) {
        this.desstability = desstability;
    }

    public String getMinflow() {
        return minflow;
    }

    public void setMinflow(String minflow) {
        this.minflow = minflow;
    }

    public String getMaxflow() {
        return maxflow;
    }

    public void setMaxflow(String maxflow) {
        this.maxflow = maxflow;
    }

    public String getDesflow() {
        return desflow;
    }

    public void setDesflow(String desflow) {
        this.desflow = desflow;
    }

    public String getMinjointden() {
        return minjointden;
    }

    public void setMinjointden(String minjointden) {
        this.minjointden = minjointden;
    }

    public String getMaxjointden() {
        return maxjointden;
    }

    public void setMaxjointden(String maxjointden) {
        this.maxjointden = maxjointden;
    }

    public String getDesjointden() {
        return desjointden;
    }

    public void setDesjointden(String desjointden) {
        this.desjointden = desjointden;
    }

    public String getMinmatden() {
        return minmatden;
    }

    public void setMinmatden(String minmatden) {
        this.minmatden = minmatden;
    }

    public String getMaxmatden() {
        return maxmatden;
    }

    public void setMaxmatden(String maxmatden) {
        this.maxmatden = maxmatden;
    }

    public String getDesmatden() {
        return desmatden;
    }

    public void setDesmatden(String desmatden) {
        this.desmatden = desmatden;
    }

    public String getMinhveemstability() {
        return minhveemstability;
    }

    public void setMinhveemstability(String minhveemstability) {
        this.minhveemstability = minhveemstability;
    }

    public String getMaxhveemstability() {
        return maxhveemstability;
    }

    public void setMaxhveemstability(String maxhveemstability) {
        this.maxhveemstability = maxhveemstability;
    }

    public String getDeshveemstability() {
        return deshveemstability;
    }

    public void setDeshveemstability(String deshveemstability) {
        this.deshveemstability = deshveemstability;
    }

    public String getMintsr() {
        return mintsr;
    }

    public void setMintsr(String mintsr) {
        this.mintsr = mintsr;
    }

    public String getMaxtsr() {
        return maxtsr;
    }

    public void setMaxtsr(String maxtsr) {
        this.maxtsr = maxtsr;
    }

    public String getDestsr() {
        return destsr;
    }

    public void setDestsr(String destsr) {
        this.destsr = destsr;
    }

    public String getDescompfdpcf() {
        return descompfdpcf;
    }

    public void setDescompfdpcf(String descompfdpcf) {
        this.descompfdpcf = descompfdpcf;
    }

    public String getDesmaxtheodens() {
        return desmaxtheodens;
    }

    public void setDesmaxtheodens(String desmaxtheodens) {
        this.desmaxtheodens = desmaxtheodens;
    }

    public String getTolminac() {
        return tolminac;
    }

    public void setTolminac(String tolminac) {
        this.tolminac = tolminac;
    }

    public String getTolmaxac() {
        return tolmaxac;
    }

    public void setTolmaxac(String tolmaxac) {
        this.tolmaxac = tolmaxac;
    }

    public String getTolminvtm() {
        return tolminvtm;
    }

    public void setTolminvtm(String tolminvtm) {
        this.tolminvtm = tolminvtm;
    }

    public String getTolmaxvtm() {
        return tolmaxvtm;
    }

    public void setTolmaxvtm(String tolmaxvtm) {
        this.tolmaxvtm = tolmaxvtm;
    }

    public String getTolminvma() {
        return tolminvma;
    }

    public void setTolminvma(String tolminvma) {
        this.tolminvma = tolminvma;
    }

    public String getTolmaxvma() {
        return tolmaxvma;
    }

    public void setTolmaxvma(String tolmaxvma) {
        this.tolmaxvma = tolmaxvma;
    }

    public String getTolminvfa() {
        return tolminvfa;
    }

    public void setTolminvfa(String tolminvfa) {
        this.tolminvfa = tolminvfa;
    }

    public String getTolmaxvfa() {
        return tolmaxvfa;
    }

    public void setTolmaxvfa(String tolmaxvfa) {
        this.tolmaxvfa = tolmaxvfa;
    }

    public String getTolmindpbr() {
        return tolmindpbr;
    }

    public void setTolmindpbr(String tolmindpbr) {
        this.tolmindpbr = tolmindpbr;
    }

    public String getTolmaxdpbr() {
        return tolmaxdpbr;
    }

    public void setTolmaxdpbr(String tolmaxdpbr) {
        this.tolmaxdpbr = tolmaxdpbr;
    }

    public String getTolminengac() {
        return tolminengac;
    }

    public void setTolminengac(String tolminengac) {
        this.tolminengac = tolminengac;
    }

    public String getTolmaxengac() {
        return tolmaxengac;
    }

    public void setTolmaxengac(String tolmaxengac) {
        this.tolmaxengac = tolmaxengac;
    }

    public String getTolminengvtm() {
        return tolminengvtm;
    }

    public void setTolminengvtm(String tolminengvtm) {
        this.tolminengvtm = tolminengvtm;
    }

    public String getTolmaxengvtm() {
        return tolmaxengvtm;
    }

    public void setTolmaxengvtm(String tolmaxengvtm) {
        this.tolmaxengvtm = tolmaxengvtm;
    }

    public String getTolminengvma() {
        return tolminengvma;
    }

    public void setTolminengvma(String tolminengvma) {
        this.tolminengvma = tolminengvma;
    }

    public String getTolmaxengvma() {
        return tolmaxengvma;
    }

    public void setTolmaxengvma(String tolmaxengvma) {
        this.tolmaxengvma = tolmaxengvma;
    }

    public String getTolminengvfa() {
        return tolminengvfa;
    }

    public void setTolminengvfa(String tolminengvfa) {
        this.tolminengvfa = tolminengvfa;
    }

    public String getTolmaxengvfa() {
        return tolmaxengvfa;
    }

    public void setTolmaxengvfa(String tolmaxengvfa) {
        this.tolmaxengvfa = tolmaxengvfa;
    }

    public String getTolminengdpbr() {
        return tolminengdpbr;
    }

    public void setTolminengdpbr(String tolminengdpbr) {
        this.tolminengdpbr = tolminengdpbr;
    }

    public String getTolmaxengdpbr() {
        return tolmaxengdpbr;
    }

    public void setTolmaxengdpbr(String tolmaxengdpbr) {
        this.tolmaxengdpbr = tolmaxengdpbr;
    }

    public String getTolminhveemstability() {
        return tolminhveemstability;
    }

    public void setTolminhveemstability(String tolminhveemstability) {
        this.tolminhveemstability = tolminhveemstability;
    }

    public String getTolmaxhveemstability() {
        return tolmaxhveemstability;
    }

    public void setTolmaxhveemstability(String tolmaxhveemstability) {
        this.tolmaxhveemstability = tolmaxhveemstability;
    }

    public String getTolmincompfd() {
        return tolmincompfd;
    }

    public void setTolmincompfd(String tolmincompfd) {
        this.tolmincompfd = tolmincompfd;
    }

    public String getTolmaxcompfd() {
        return tolmaxcompfd;
    }

    public void setTolmaxcompfd(String tolmaxcompfd) {
        this.tolmaxcompfd = tolmaxcompfd;
    }

    public String getDessieve200() {
        return dessieve200;
    }

    public void setDessieve200(String dessieve200) {
        this.dessieve200 = dessieve200;
    }

    public String getMinsieve200() {
        return minsieve200;
    }

    public void setMinsieve200(String minsieve200) {
        this.minsieve200 = minsieve200;
    }

    public String getMaxsieve200() {
        return maxsieve200;
    }

    public void setMaxsieve200(String maxsieve200) {
        this.maxsieve200 = maxsieve200;
    }

    public String getTolminsieve200() {
        return tolminsieve200;
    }

    public void setTolminsieve200(String tolminsieve200) {
        this.tolminsieve200 = tolminsieve200;
    }

    public String getTolmaxsieve200() {
        return tolmaxsieve200;
    }

    public void setTolmaxsieve200(String tolmaxsieve200) {
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

    public String getG1SpecGravAsp() {
        return g1SpecGravAsp;
    }

    public void setG1SpecGravAsp(String g1SpecGravAsp) {
        this.g1SpecGravAsp = g1SpecGravAsp;
    }

    public String getAcCorrFactor() {
        return acCorrFactor;
    }

    public void setAcCorrFactor(String acCorrFactor) {
        this.acCorrFactor = acCorrFactor;
    }

    public String getLtmfDate() {
        return ltmfDate;
    }

    public void setLtmfDate(String ltmfDate) {
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

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMixStatus() {
        return mixStatus;
    }

    public void setMixStatus(String mixStatus) {
        this.mixStatus = mixStatus;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public JmfMasterPojo getMainJmf() {
        return mainJmf;
    }

    public void setMainJmf(JmfMasterPojo mainJmf) {
        this.mainJmf = mainJmf;
    }

    public List<GradationPojo> getGradationList() {
        return gradationList;
    }

    public void setGradationList(List<GradationPojo> gradationList) {
        this.gradationList = gradationList;
    }

    public String getRapPct() {
        return rapPct;
    }

    public void setRapPct(String rapPct) {
        this.rapPct = rapPct;
    }
}
