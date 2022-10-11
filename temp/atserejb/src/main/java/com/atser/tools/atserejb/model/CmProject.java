/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/*
, @NamedQuery(name = "CmProject.findByPNumber", query = "SELECT c FROM CmProject c WHERE c.pNumber = :pNumber")
    , @NamedQuery(name = "CmProject.findByPName", query = "SELECT c FROM CmProject c WHERE c.pName = :pName")
    , @NamedQuery(name = "CmProject.findByPDate", query = "SELECT c FROM CmProject c WHERE c.pDate = :pDate")
    , @NamedQuery(name = "CmProject.findByPType", query = "SELECT c FROM CmProject c WHERE c.pType = :pType")
    , @NamedQuery(name = "CmProject.findByBidDate", query = "SELECT c FROM CmProject c WHERE c.bidDate = :bidDate")
    , @NamedQuery(name = "CmProject.findByFileNo", query = "SELECT c FROM CmProject c WHERE c.fileNo = :fileNo")
    , @NamedQuery(name = "CmProject.findByContact", query = "SELECT c FROM CmProject c WHERE c.contact = :contact")
    , @NamedQuery(name = "CmProject.findByFundsNo", query = "SELECT c FROM CmProject c WHERE c.fundsNo = :fundsNo")
    , @NamedQuery(name = "CmProject.findByFundsSource", query = "SELECT c FROM CmProject c WHERE c.fundsSource = :fundsSource")
    , @NamedQuery(name = "CmProject.findByCouncilDist", query = "SELECT c FROM CmProject c WHERE c.councilDist = :councilDist")
    , @NamedQuery(name = "CmProject.findByAssistantDirector", query = "SELECT c FROM CmProject c WHERE c.assistantDirector = :assistantDirector")
    , @NamedQuery(name = "CmProject.findByChiefEngineer", query = "SELECT c FROM CmProject c WHERE c.chiefEngineer = :chiefEngineer")
    , @NamedQuery(name = "CmProject.findBySeniorInspector", query = "SELECT c FROM CmProject c WHERE c.seniorInspector = :seniorInspector")
    , @NamedQuery(name = "CmProject.findByCuicNo", query = "SELECT c FROM CmProject c WHERE c.cuicNo = :cuicNo")
    , @NamedQuery(name = "CmProject.findByRecievedContracts", query = "SELECT c FROM CmProject c WHERE c.recievedContracts = :recievedContracts")
    , @NamedQuery(name = "CmProject.findByAwardOrdinanceNum", query = "SELECT c FROM CmProject c WHERE c.awardOrdinanceNum = :awardOrdinanceNum")
    , @NamedQuery(name = "CmProject.findByAwardOrdinanceDate", query = "SELECT c FROM CmProject c WHERE c.awardOrdinanceDate = :awardOrdinanceDate")
    , @NamedQuery(name = "CmProject.findByField1", query = "SELECT c FROM CmProject c WHERE c.field1 = :field1")
    , @NamedQuery(name = "CmProject.findByField2", query = "SELECT c FROM CmProject c WHERE c.field2 = :field2")
    , @NamedQuery(name = "CmProject.findByField3", query = "SELECT c FROM CmProject c WHERE c.field3 = :field3")
    , @NamedQuery(name = "CmProject.findByField4", query = "SELECT c FROM CmProject c WHERE c.field4 = :field4")
    , @NamedQuery(name = "CmProject.findByField5", query = "SELECT c FROM CmProject c WHERE c.field5 = :field5")
    , @NamedQuery(name = "CmProject.findByField6", query = "SELECT c FROM CmProject c WHERE c.field6 = :field6")
    , @NamedQuery(name = "CmProject.findByField7", query = "SELECT c FROM CmProject c WHERE c.field7 = :field7")
    , @NamedQuery(name = "CmProject.findByField8", query = "SELECT c FROM CmProject c WHERE c.field8 = :field8")
    , @NamedQuery(name = "CmProject.findByPStatus", query = "SELECT c FROM CmProject c WHERE c.pStatus = :pStatus")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_PROJECT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmProject.findAll", query = "SELECT c FROM CmProject c"),
    @NamedQuery(name = "CmProject.findById", query = "SELECT c FROM CmProject c WHERE c.id = :id")})
public class CmProject implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "P_NAME")
    private String pName;
    @Column(name = "P_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pDate;
    @Size(max = 15)
    @Column(name = "P_TYPE")
    private String pType;
    @Column(name = "BID_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bidDate;
    @Size(max = 50)
    @Column(name = "FILE_NO")
    private String fileNo;
    @Size(max = 50)
    @Column(name = "CONTACT")
    private String contact;
    @Size(max = 50)
    @Column(name = "FUNDS_NO")
    private String fundsNo;
    @Size(max = 50)
    @Column(name = "FUNDS_SOURCE")
    private String fundsSource;
    @Size(max = 50)
    @Column(name = "COUNCIL_DIST")
    private String councilDist;
    @Size(max = 50)
    @Column(name = "ASSISTANT_DIRECTOR")
    private String assistantDirector;
    @Size(max = 50)
    @Column(name = "CHIEF_ENGINEER")
    private String chiefEngineer;
    @Size(max = 50)
    @Column(name = "SENIOR_INSPECTOR")
    private String seniorInspector;
    @Size(max = 25)
    @Column(name = "CUIC_NO")
    private String cuicNo;
    @Size(max = 50)
    @Column(name = "RECIEVED_CONTRACTS")
    private String recievedContracts;
    @Size(max = 25)
    @Column(name = "AWARD_ORDINANCE_NUM")
    private String awardOrdinanceNum;
    @Column(name = "AWARD_ORDINANCE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date awardOrdinanceDate;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @Size(max = 50)
    @Column(name = "FIELD5")
    private String field5;
    @Size(max = 50)
    @Column(name = "FIELD6")
    private String field6;
    @Column(name = "FIELD7")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field7;
    @Column(name = "FIELD8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field8;
    @Size(max = 50)
    @Column(name = "P_STATUS")
    private String pStatus;
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CmCompany companyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pNumberId")
    private List<CmContract> cmContractList;

    public CmProject() {
    }

    public CmProject(BigDecimal id) {
        this.id = id;
    }

    public CmProject(BigDecimal id, String pNumber, String pName) {
        this.id = id;
        this.pNumber = pNumber;
        this.pName = pName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPNumber() {
        return pNumber;
    }

    public void setPNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public Date getPDate() {
        return pDate;
    }

    public void setPDate(Date pDate) {
        this.pDate = pDate;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFundsNo() {
        return fundsNo;
    }

    public void setFundsNo(String fundsNo) {
        this.fundsNo = fundsNo;
    }

    public String getFundsSource() {
        return fundsSource;
    }

    public void setFundsSource(String fundsSource) {
        this.fundsSource = fundsSource;
    }

    public String getCouncilDist() {
        return councilDist;
    }

    public void setCouncilDist(String councilDist) {
        this.councilDist = councilDist;
    }

    public String getAssistantDirector() {
        return assistantDirector;
    }

    public void setAssistantDirector(String assistantDirector) {
        this.assistantDirector = assistantDirector;
    }

    public String getChiefEngineer() {
        return chiefEngineer;
    }

    public void setChiefEngineer(String chiefEngineer) {
        this.chiefEngineer = chiefEngineer;
    }

    public String getSeniorInspector() {
        return seniorInspector;
    }

    public void setSeniorInspector(String seniorInspector) {
        this.seniorInspector = seniorInspector;
    }

    public String getCuicNo() {
        return cuicNo;
    }

    public void setCuicNo(String cuicNo) {
        this.cuicNo = cuicNo;
    }

    public String getRecievedContracts() {
        return recievedContracts;
    }

    public void setRecievedContracts(String recievedContracts) {
        this.recievedContracts = recievedContracts;
    }

    public String getAwardOrdinanceNum() {
        return awardOrdinanceNum;
    }

    public void setAwardOrdinanceNum(String awardOrdinanceNum) {
        this.awardOrdinanceNum = awardOrdinanceNum;
    }

    public Date getAwardOrdinanceDate() {
        return awardOrdinanceDate;
    }

    public void setAwardOrdinanceDate(Date awardOrdinanceDate) {
        this.awardOrdinanceDate = awardOrdinanceDate;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public Date getField7() {
        return field7;
    }

    public void setField7(Date field7) {
        this.field7 = field7;
    }

    public Date getField8() {
        return field8;
    }

    public void setField8(Date field8) {
        this.field8 = field8;
    }

    public String getPStatus() {
        return pStatus;
    }

    public void setPStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public CmCompany getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CmCompany companyId) {
        this.companyId = companyId;
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
        if (!(object instanceof CmProject)) {
            return false;
        }
        CmProject other = (CmProject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmProject[ id=" + id + " ]";
    }

    @XmlTransient
    public List<CmContract> getCmContractList() {
        return cmContractList;
    }

    public void setCmContractList(List<CmContract> cmContractList) {
        this.cmContractList = cmContractList;
    }

}
