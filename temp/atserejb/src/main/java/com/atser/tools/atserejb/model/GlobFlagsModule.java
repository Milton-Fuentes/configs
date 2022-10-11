/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobFlagsModule.findByUsesBuckets", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesBuckets = :usesBuckets")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesDiscipline", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesDiscipline = :usesDiscipline")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesContract", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesContract = :usesContract")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesContractor", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesContractor = :usesContractor")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesFunction", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesFunction = :usesFunction")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesLab", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesLab = :usesLab")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesMultiproject", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesMultiproject = :usesMultiproject")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesNewmenu", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesNewmenu = :usesNewmenu")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesProjectpersonnel", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesProjectpersonnel = :usesProjectpersonnel")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesRequirescip", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesRequirescip = :usesRequirescip")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesProgFirstletter", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesProgFirstletter = :usesProgFirstletter")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesReadonly", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesReadonly = :usesReadonly")
    , @NamedQuery(name = "GlobFlagsModule.findByUsesReportCaching", query = "SELECT g FROM GlobFlagsModule g WHERE g.usesReportCaching = :usesReportCaching")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FLAGS_MODULE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFlagsModule.findAll", query = "SELECT g FROM GlobFlagsModule g")
    , @NamedQuery(name = "GlobFlagsModule.findById", query = "SELECT g FROM GlobFlagsModule g WHERE g.id = :id")})
public class GlobFlagsModule implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "USES_BUCKETS")
    private Character usesBuckets;
    @Column(name = "USES_DISCIPLINE")
    private Character usesDiscipline;
    @Column(name = "USES_CONTRACT")
    private Character usesContract;
    @Column(name = "USES_CONTRACTOR")
    private Character usesContractor;
    @Column(name = "USES_FUNCTION")
    private Character usesFunction;
    @Column(name = "USES_LAB")
    private Character usesLab;
    @Column(name = "USES_MULTIPROJECT")
    private Character usesMultiproject;
    @Column(name = "USES_NEWMENU")
    private Character usesNewmenu;
    @Column(name = "USES_PROJECTPERSONNEL")
    private Character usesProjectpersonnel;
    @Column(name = "USES_REQUIRESCIP")
    private Character usesRequirescip;
    @Column(name = "USES_PROG_FIRSTLETTER")
    private Character usesProgFirstletter;
    @Column(name = "USES_READONLY")
    private Character usesReadonly;
    @Column(name = "USES_REPORT_CACHING")
    private Character usesReportCaching;
    @JoinColumn(name = "FLAG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobFlags flagId;
    @JoinColumn(name = "MODULE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobModule moduleId;

    public GlobFlagsModule() {
    }

    public GlobFlagsModule(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Character getUsesBuckets() {
        return usesBuckets;
    }

    public void setUsesBuckets(Character usesBuckets) {
        this.usesBuckets = usesBuckets;
    }

    public Character getUsesDiscipline() {
        return usesDiscipline;
    }

    public void setUsesDiscipline(Character usesDiscipline) {
        this.usesDiscipline = usesDiscipline;
    }

    public Character getUsesContract() {
        return usesContract;
    }

    public void setUsesContract(Character usesContract) {
        this.usesContract = usesContract;
    }

    public Character getUsesContractor() {
        return usesContractor;
    }

    public void setUsesContractor(Character usesContractor) {
        this.usesContractor = usesContractor;
    }

    public Character getUsesFunction() {
        return usesFunction;
    }

    public void setUsesFunction(Character usesFunction) {
        this.usesFunction = usesFunction;
    }

    public Character getUsesLab() {
        return usesLab;
    }

    public void setUsesLab(Character usesLab) {
        this.usesLab = usesLab;
    }

    public Character getUsesMultiproject() {
        return usesMultiproject;
    }

    public void setUsesMultiproject(Character usesMultiproject) {
        this.usesMultiproject = usesMultiproject;
    }

    public Character getUsesNewmenu() {
        return usesNewmenu;
    }

    public void setUsesNewmenu(Character usesNewmenu) {
        this.usesNewmenu = usesNewmenu;
    }

    public Character getUsesProjectpersonnel() {
        return usesProjectpersonnel;
    }

    public void setUsesProjectpersonnel(Character usesProjectpersonnel) {
        this.usesProjectpersonnel = usesProjectpersonnel;
    }

    public Character getUsesRequirescip() {
        return usesRequirescip;
    }

    public void setUsesRequirescip(Character usesRequirescip) {
        this.usesRequirescip = usesRequirescip;
    }

    public Character getUsesProgFirstletter() {
        return usesProgFirstletter;
    }

    public void setUsesProgFirstletter(Character usesProgFirstletter) {
        this.usesProgFirstletter = usesProgFirstletter;
    }

    public Character getUsesReadonly() {
        return usesReadonly;
    }

    public void setUsesReadonly(Character usesReadonly) {
        this.usesReadonly = usesReadonly;
    }

    public Character getUsesReportCaching() {
        return usesReportCaching;
    }

    public void setUsesReportCaching(Character usesReportCaching) {
        this.usesReportCaching = usesReportCaching;
    }

    public GlobFlags getFlagId() {
        return flagId;
    }

    public void setFlagId(GlobFlags flagId) {
        this.flagId = flagId;
    }

    public GlobModule getModuleId() {
        return moduleId;
    }

    public void setModuleId(GlobModule moduleId) {
        this.moduleId = moduleId;
    }
    
    public Map<String, Boolean> getFlagsMap() {
        Map<String, Boolean> flags = new HashMap<>();
        flags.put("USES_BUCKETS", StringSupport.getBoolean(this.getUsesBuckets()));
        flags.put("USES_DISCIPLINE", StringSupport.getBoolean(this.getUsesDiscipline()));
        flags.put("USES_CONTRACT", StringSupport.getBoolean(this.getUsesContract()));
        flags.put("USES_CONTRACTOR", StringSupport.getBoolean(this.getUsesContractor()));
        flags.put("USES_FUNCTION", StringSupport.getBoolean(this.getUsesFunction()));
        flags.put("USES_LAB", StringSupport.getBoolean(this.getUsesLab()));
        flags.put("USES_MULTIPROJECT", StringSupport.getBoolean(this.getUsesMultiproject()));
        flags.put("USES_NEWMENU", StringSupport.getBoolean(this.getUsesNewmenu()));
        flags.put("USES_PROJECTPERSONNEL", StringSupport.getBoolean(this.getUsesProjectpersonnel()));
        flags.put("USES_REQUIRESCIP", StringSupport.getBoolean(this.getUsesRequirescip()));
        flags.put("USES_PROG_FIRSTLETTER", StringSupport.getBoolean(this.getUsesProgFirstletter()));
        flags.put("USES_READONLY", StringSupport.getBoolean(this.getUsesReadonly()));
        flags.put("USES_REPORT_CACHING", StringSupport.getBoolean(this.getUsesReportCaching()));
        return flags;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobFlagsModule)) {
            return false;
        }
        GlobFlagsModule other = (GlobFlagsModule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFlagsModule[ id=" + id + " ]";
    }
    
}
