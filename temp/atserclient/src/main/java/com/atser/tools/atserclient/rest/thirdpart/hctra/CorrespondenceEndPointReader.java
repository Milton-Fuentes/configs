/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserclient.rest.thirdpart.hctra;

import com.atser.tools.atserutil.objects.bo.batch.CmCorrespondenceBO;
import com.atser.tools.atserutil.string.StringSupport;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author droldan
 */
@Stateless
public class CorrespondenceEndPointReader {

    public CorrespondenceEndPointReader() {
    }

    public List<CmCorrespondenceBO> CorrespondenceEndPointReader(String URLService, String user, String pwd, String domain) throws IOException {
        String responseText = getAuthenticatedResponse(URLService, domain, user, pwd);
        Gson gson = new Gson();
        Type type = new TypeToken<List<CmCorrespondenceBO>>() {
        }.getType();
        List<CmCorrespondenceBO> list = gson.fromJson(responseText, type);
        return list;
    }

    private static String getAuthenticatedResponse(final String urlStr, final String domain, final String userName, final String password) throws IOException {
        StringBuilder response = new StringBuilder();
        Authenticator.setDefault(new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(domain + "\\" + userName, password.toCharArray()
                );
            }
        });
        URL urlRequest = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) urlRequest.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        InputStream stream = conn.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        String str = StringSupport.STRING_EMPTY;
        while ((str = in.readLine()) != null) {
            response.append(str);
        }
        in.close();

        return response.toString();
    }

}
