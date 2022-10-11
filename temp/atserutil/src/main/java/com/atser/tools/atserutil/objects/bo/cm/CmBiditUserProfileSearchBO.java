/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.cm;

import java.math.BigInteger;
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
public class CmBiditUserProfileSearchBO {

    private BigInteger id;
    private BigInteger userId;
    private BigInteger prjCatgId;
    private String bidNo;
    private String bidDescription;
    private String bidIssueDate;
    private String bidClosingDate;
    private String bidPublishDate;
    private BigInteger companyId;
    private String companyTin;
    private String companyName;
    private Boolean isEngineerEstimate;
    private BigInteger folderId;
    private BigInteger statusId;
    private String status;
    private String created;
    private String createdBy;
    private String version;
    private BigInteger contactClientId;
    private Integer bidAddendumRev;
}
