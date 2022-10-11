/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.batch;

import java.io.Serializable;

/**
 *
 * @author droldan
 */
public class CmCorrespondenceBO implements Serializable {
                     
    private String ID;
    private String correspd_date;
    private String correspd_keyword;
    private String correspd_subject;
    private String date_due_contractor;
    private String date_sent_received;
    private String delivery_method;
    private String from_company1;
    private String from_person1;
    private String issue_id;
    private String last_modified;
    private String number;
    private String sent_received;
    private String to_person;
    private String to_company;
    private String track_no; 
    private String contract_id;
    

    public CmCorrespondenceBO() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCorrespd_date() {
        return correspd_date;
    }

    public void setCorrespd_date(String correspd_date) {
        this.correspd_date = correspd_date;
    }

    public String getCorrespd_keyword() {
        return correspd_keyword;
    }

    public void setCorrespd_keyword(String correspd_keyword) {
        this.correspd_keyword = correspd_keyword;
    }

    public String getCorrespd_subject() {
        return correspd_subject;
    }

    public void setCorrespd_subject(String correspd_subject) {
        this.correspd_subject = correspd_subject;
    }

    public String getDate_due_contractor() {
        return date_due_contractor;
    }

    public void setDate_due_contractor(String date_due_contractor) {
        this.date_due_contractor = date_due_contractor;
    }

    public String getDate_sent_received() {
        return date_sent_received;
    }

    public void setDate_sent_received(String date_sent_received) {
        this.date_sent_received = date_sent_received;
    }

    public String getDelivery_method() {
        return delivery_method;
    }

    public void setDelivery_method(String delivery_method) {
        this.delivery_method = delivery_method;
    }

    public String getFrom_company1() {
        return from_company1;
    }

    public void setFrom_company1(String from_company1) {
        this.from_company1 = from_company1;
    }

    public String getFrom_person1() {
        return from_person1;
    }

    public void setFrom_person1(String from_person1) {
        this.from_person1 = from_person1;
    }

    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public String getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(String last_modified) {
        this.last_modified = last_modified;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSent_received() {
        return sent_received;
    }

    public void setSent_received(String sent_received) {
        this.sent_received = sent_received;
    }

    public String getTo_person() {
        return to_person;
    }

    public void setTo_person(String to_person) {
        this.to_person = to_person;
    }

    public String getTo_company() {
        return to_company;
    }

    public void setTo_company(String to_company) {
        this.to_company = to_company;
    }

    public String getTrack_no() {
        return track_no;
    }

    public void setTrack_no(String track_no) {
        this.track_no = track_no;
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

}
