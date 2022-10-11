/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.envers;

import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;

/**
 *
 * @author droldan
 */
public class CurrentUser {

    public static final CurrentUser INSTANCE = new CurrentUser();

    private static final ThreadLocal<ManageITHeader> storage = new ThreadLocal<>();

    public void logIn(ManageITHeader user) {
        storage.set(user);
    }

    public void logOut() {
        storage.remove();
    }

    public ManageITHeader get() {
        return storage.get();
    }
}
