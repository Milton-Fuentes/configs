/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.cm;

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
public class CmBidITPrjCatgSearchBO {
    
    private BigInteger id;
    private BigInteger clientId;
    private BigInteger projectId;
    private String projectNumber;
    private String projectCode;
    private String spattern;
    private BigInteger sno;
    private String bpcn;
    private String bidNo;
    private String description;
    private String bidIssueDate;
    private String bidClosingDate;
    private Boolean bidClosed;
    private BigInteger bidAddendumRev;
    private String bidPublishDate;
    private Boolean bidPublished;
    private BigInteger folderId;
    private String status;
    private String created;
    private String createdBy;
    private BigInteger createdById;
    private String version;
    private Integer signTotal;
    private Integer finalSignTotal;
    
    public Boolean getIsEditable() {
        if (signTotal > 0) {
            return !(Objects.equals(signTotal, finalSignTotal));
        }
        return Boolean.TRUE;
    }
}
