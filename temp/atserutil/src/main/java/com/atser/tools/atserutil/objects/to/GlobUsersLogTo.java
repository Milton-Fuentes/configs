/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to;

import java.util.Date;

/**
 *
 * @author droldan
 */
public class GlobUsersLogTo {
    private String userid;
    private Date logged_on;
    private String session_id;
    private Date logged_off;
    private Date logged_off_timeout;

    public GlobUsersLogTo() {
        this.userid = null;
        this.logged_on = null;
        this.session_id = null;
        this.logged_off = null;
        this.logged_off_timeout = null;
    }

    public GlobUsersLogTo(String userid, Date logged_on, String session_id, Date logged_off, Date logged_off_timeout) {
        this.userid = userid;
        this.logged_on = logged_on;
        this.session_id = session_id;
        this.logged_off = logged_off;
        this.logged_off_timeout = logged_off_timeout;
    }
    
    

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getLogged_on() {
        return logged_on;
    }

    public void setLogged_on(Date logged_on) {
        this.logged_on = logged_on;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public Date getLogged_off() {
        return logged_off;
    }

    public void setLogged_off(Date logged_off) {
        this.logged_off = logged_off;
    }

    public Date getLogged_off_timeout() {
        return logged_off_timeout;
    }

    public void setLogged_off_timeout(Date logged_off_timeout) {
        this.logged_off_timeout = logged_off_timeout;
    }
    
    
}
