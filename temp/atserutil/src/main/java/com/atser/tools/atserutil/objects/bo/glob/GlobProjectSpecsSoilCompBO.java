/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob;

/**
 *
 * @author droldan
 */
public class GlobProjectSpecsSoilCompBO {

    private String typeMaterial;
    private String compaction;
    private String astmProctor;
    private String moistureReq;

    public GlobProjectSpecsSoilCompBO() {
    }

    public GlobProjectSpecsSoilCompBO(String typeMaterial, String compaction, String astmProctor, String moistureReq) {
        this.typeMaterial = typeMaterial;
        this.compaction = compaction;
        this.astmProctor = astmProctor;
        this.moistureReq = moistureReq;
    }

    public String getTypeMaterial() {
        return typeMaterial;
    }

    public void setTypeMaterial(String typeMaterial) {
        this.typeMaterial = typeMaterial;
    }

    public String getCompaction() {
        return compaction;
    }

    public void setCompaction(String compaction) {
        this.compaction = compaction;
    }

    public String getAstmProctor() {
        return astmProctor;
    }

    public void setAstmProctor(String astmProctor) {
        this.astmProctor = astmProctor;
    }

    public String getMoistureReq() {
        return moistureReq;
    }

    public void setMoistureReq(String moistureReq) {
        this.moistureReq = moistureReq;
    }
}
