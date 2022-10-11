/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.glob;

import java.util.List;

/**
 *
 * @author droldan
 */
public class GlobPersonnelCertTO {

    private String contactName;
    private List<GlobCertificationTO> certifList;

    public GlobPersonnelCertTO() {
    }
    
    public GlobPersonnelCertTO(String name, List<GlobCertificationTO> list) {
        this.contactName = name;
        this.certifList = list;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public List<GlobCertificationTO> getCertifList() {
        return certifList;
    }

    public void setCertifList(List<GlobCertificationTO> certifList) {
        this.certifList = certifList;
    }
}
