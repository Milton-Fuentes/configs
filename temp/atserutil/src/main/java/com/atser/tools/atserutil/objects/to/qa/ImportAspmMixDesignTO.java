/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.qa;

import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.model.AspmMixDesignDef;
import java.util.List;

/**
 *
 * @author droldan
 */
public class ImportAspmMixDesignTO {

    private String clientId;
    private String setId;
    private List<AspmMixDesignDef> mixes;

    public ImportAspmMixDesignTO() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public List<AspmMixDesignDef> getMixes() {
        return mixes;
    }

    public void setMixes(List<AspmMixDesignDef> mixes) {
        this.mixes = mixes;
    }
}
