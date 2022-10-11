/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.glob;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mfuentes
 */
@Data
@NoArgsConstructor
public class GlobLedgerTO {

    private String pname;
    private String name;
    private String pnumber;
    private String inspector;
    private String operationDate;
    private String description;
    private String account;
    private String income;
    private String expense;
    private String miles;
    private String mileageExpense;
    private String totalExpense;
    private String balance;
    private String created;
    private String createdBy;
    private String lastMod;
    private String lastModBy;
    private String version;
}
