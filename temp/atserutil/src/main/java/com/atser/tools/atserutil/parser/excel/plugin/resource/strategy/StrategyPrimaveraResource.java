/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.resource.strategy;

import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.parser.excel.plugin.resource.model.ResourceModel;

/**
 *
 * @author droldan
 */
public class StrategyPrimaveraResource extends GanttResourceStrategy {

    public StrategyPrimaveraResource() {
        super();
    }

    @Override
    public ResourceModel getResourceData() throws TemplateDifferentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getObjectName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
