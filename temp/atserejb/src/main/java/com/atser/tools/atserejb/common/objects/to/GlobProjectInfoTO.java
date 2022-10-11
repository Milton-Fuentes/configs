/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.objects.to;

import com.atser.tools.atserejb.model.GlobContractorPersonnel;
import com.atser.tools.atserejb.model.GlobModule;
import com.atser.tools.atserejb.model.GlobProject;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mfuentes
 */
@Data
@NoArgsConstructor
public class GlobProjectInfoTO implements Serializable {

    GlobProject globProject;
    GlobModule globModule;
    List<GlobContractorPersonnel> contractors;
    

}
