/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserclient.test.clientcx;

import com.atser.tools.atserutil.objects.pojo.security.Credentials;

/**
 *
 * @author droldan
 */
public class RestEndPointReaderTest {

    public static void main(String[] args) {
        String serverUrl = "https://massdottest.atser.com/ws/rs/auth/external/login";
        Credentials credentials = new Credentials("umassdotapi", "SjM3Mkhka3c0MllUdzIzRWRrUTNLVGVtbQ==");
    }
}
