/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.qa;

import java.math.BigInteger;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@NoArgsConstructor
@Getter
@Setter
public class QaInspectionSearchBO {

    private BigInteger id;
    private BigInteger clientId;
    private BigInteger projectId;
    private BigInteger labId;
    private BigInteger sno;
    private String inspNo;
    private String icn;
    private String remarks;
    private BigInteger folderId;
    private String created;
    private String createdBy;
    private String version;
    private BigInteger typeId;
    private String status;
    private String typeName;
    private String typeShortName;
    private String catCode;
    private String catName;
    private String catShortName;
    private String projectNumber;
    private BigInteger regionId;
    private String regionName;
    private String officeLocation;
    private String departmentId;
    private String projectCode;
    private Integer signTotal;
    private Integer finalSignTotal;
    private String bidItemNo;

    public Boolean getIsEditable() {
        if (signTotal > 0) {
            return !(Objects.equals(signTotal, finalSignTotal));
        }
        return Boolean.TRUE;
    }
}
