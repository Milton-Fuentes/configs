/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dperez
 */
@Getter
@Setter
@NoArgsConstructor
public class DocumentBO implements Serializable {

    private BigInteger id;
    private String owner;
    private Integer timesShared;
    private BigInteger projectId;
    private BigInteger contractId;
    private BigInteger parentId;
    private BigInteger ownerId;
    private String name;
    private String title;
    private String path;
    private String dcn;
    private Integer version;
    private String extension;
    private BigDecimal size;
    private String uploaded;
    private String created;
    private String type;
    private String serverPath;
    private String systemPath;
    public static String folderType = "FOLDER";
    public static String fileType = "FILE";

}
