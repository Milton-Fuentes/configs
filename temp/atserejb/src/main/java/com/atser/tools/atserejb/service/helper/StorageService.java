/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.helper;

import com.atser.tools.atserutil.objects.pojo.UploadModel;
import java.io.IOException;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author droldan
 */
public interface StorageService {

    void store(MultipartFormDataInput file, String uploadFolderPath) throws IOException;

    void store(MultipartFormDataInput file, String uploadFolderPath, String keywords) throws IOException;

    void store(MultipartFormDataInput file, String uploadFolderPath, String parameterName, String keywords) throws IOException;

    UploadModel process(MultipartFormDataInput file, String uploadFolderPath) throws IOException;

    UploadModel process(MultipartFormDataInput file, String uploadFolderPath, String parameterName) throws IOException;
}
