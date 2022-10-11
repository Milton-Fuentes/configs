/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.bpm.engine;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
@NoArgsConstructor
public class HumanTaskInstanceBO {

    private Long id;
    private String name;
    private String displayName;
    private String state;
    private Long processDefinitionId;
    private String processName;
    private String processVersion;
    private Long rootContainerId;
    private Long assigneeId;
    private String assigneeFullName;
    private String assigneeJobTitle;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
    private Date assigneeLastConnection;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
    private Date claimedDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
    private Date lastUpdateDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
    private Date reachedStateDate;
    private String priority;

}
