/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.transmittal;

import com.atser.tools.atserutil.annotation.ReportColumnDef;
import com.atser.tools.atserutil.annotation.ReportColumnMapping;
import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mfuentes
 */
@NoArgsConstructor
@Getter
@Setter
public class GlobTransmittalBO {

    private BigDecimal id;
    private BigInteger clientId;
    private BigInteger projectId;
    private BigInteger sno;
    private String transmittalNo;

    private String transmitedBy;

    private String transmitedByCompany;

    private String attention;

    private String attentionCompany;

    private Integer transmitedFor;

    private String status;

    private Integer attachment;

    private BigInteger folderId;
    @ReportColumnMapping(column = {
        @ReportColumnDef(caption = "Created")})
    private String created;
    private String createdBy;
    private String version;
}
