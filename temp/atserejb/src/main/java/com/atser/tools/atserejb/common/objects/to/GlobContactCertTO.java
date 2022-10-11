/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.objects.to;

import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobContactCert;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobCertificationTO;
import com.atser.tools.atserutil.objects.to.jasper.glob.GlobPersonnelCertTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author droldan
 */
public class GlobContactCertTO implements Serializable {

    GlobContact parent;
    List<GlobContactCert> children;

    public GlobContactCertTO(GlobContact parent, List<GlobContactCert> children) {
        this.parent = parent;
        this.children = children;
    }

    public GlobContactCertTO() {
    }

    public GlobContact getParent() {
        return parent;
    }

    public void setParent(GlobContact parent) {
        this.parent = parent;
    }

    public List<GlobContactCert> getChildren() {
        return children;
    }

    public void setChildren(List<GlobContactCert> children) {
        this.children = children;
    }

    public GlobPersonnelCertTO getTOForJasper() {
        GlobPersonnelCertTO item = new GlobPersonnelCertTO();
        item.setContactName(parent.getFullNameWithTitle());
        List<GlobCertificationTO> certifList = new ArrayList<>();
        this.children.forEach(it -> {
            GlobCertificationTO obj = new GlobCertificationTO();
            obj.setAuthDate(it.getAuthorizedDate() != null ? DateSupport.formatDate(it.getAuthorizedDate(), DateSupport.FORMAT_US) : "");
            obj.setExpDate(it.getExpirationDate() != null ? DateSupport.formatDate(it.getExpirationDate(), DateSupport.FORMAT_US) : "");
            obj.setCertNo(StringSupport.emptyOnNull(it.getCertNo()));
            obj.setIgnoreProficiency(it.getIgnoreProficiency().toString());
            obj.setOverride(it.getOverride().toString());
            obj.setQualification(it.getQualificationId() != null ? it.getQualificationId().getQualification() : "");
            obj.setQualifyingAgency(it.getQualifyingAgencyId() != null ? it.getQualifyingAgencyId().getQualifyingAgency() : "");
            certifList.add(obj);
        });
        item.setCertifList(certifList);
        return item;
    }
}
