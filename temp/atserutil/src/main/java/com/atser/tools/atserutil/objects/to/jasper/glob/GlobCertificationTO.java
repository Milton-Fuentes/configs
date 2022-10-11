/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.glob;

/**
 *
 * @author droldan
 */
public class GlobCertificationTO {

    private String qualifyingAgency;
    private String qualification;
    private String authDate;
    private String expDate;
    private String override;
    private String ignoreProficiency;
    private String certNo;

    public GlobCertificationTO() {
    }

    public GlobCertificationTO(String qualifyingAgency, String qualification, String authDate, String expDate, String override, String ignoreProficiency, String certNo) {
        this.qualifyingAgency = qualifyingAgency;
        this.qualification = qualification;
        this.authDate = authDate;
        this.expDate = expDate;
        this.override = override;
        this.ignoreProficiency = ignoreProficiency;
        this.certNo = certNo;
    }

    public String getQualifyingAgency() {
        return qualifyingAgency;
    }

    public void setQualifyingAgency(String qualifyingAgency) {
        this.qualifyingAgency = qualifyingAgency;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAuthDate() {
        return authDate;
    }

    public void setAuthDate(String authDate) {
        this.authDate = authDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String ExpDate) {
        this.expDate = ExpDate;
    }

    public String getOverride() {
        return override;
    }

    public void setOverride(String override) {
        this.override = override;
    }

    public String getIgnoreProficiency() {
        return ignoreProficiency;
    }

    public void setIgnoreProficiency(String ignoreProficiency) {
        this.ignoreProficiency = ignoreProficiency;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }
}
