/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.qa;

import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.model.ConcMixDesignDef;
import java.util.List;

/**
 *
 * @author droldan
 */
public class ImportConcMixDesignTO {

    private String clientId;
    private List<ConcMixDesignDef> mixes;

    public ImportConcMixDesignTO() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<ConcMixDesignDef> getMixes() {
        return mixes;
    }

    public void setMixes(List<ConcMixDesignDef> mixes) {
        this.mixes = mixes;
    }
}
