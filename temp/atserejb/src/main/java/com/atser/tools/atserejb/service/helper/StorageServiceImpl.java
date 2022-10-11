/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.helper;

import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
import com.atser.tools.atserutil.string.StringSupport;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Stateless
@Slf4j
public class StorageServiceImpl implements StorageService, IBaseEJBException {

    private String UPFILE_PARAMETER_NAME = "upload";
    private final String UPFILE_PARAMETER_DATA = UPFILE_PARAMETER_NAME + "_data";

    @Inject
    private GlobFileService fileService;

    private String getUpfileParameterData(String newParam) {
        return getUpfileParameterData(newParam, true);
    }

    private String getUpfileParameterData(String newParam, boolean addSuffix) {
        if (StringSupport.isNullOrEmpty(newParam)) {
            this.UPFILE_PARAMETER_NAME = "upload";
        } else {
            this.UPFILE_PARAMETER_NAME = newParam;
        }
        if (addSuffix) {
            return UPFILE_PARAMETER_NAME + "_data";
        }
        return UPFILE_PARAMETER_NAME;
    }

    /**
     * Parse Multipart Data
     *
     * @param inputParts
     * @return
     * @throws IOException
     */
    private String getDataFormValueByName(List<InputPart> inputParts) throws IOException {
        for (InputPart inputPart : inputParts) {
            return inputPart.getBodyAsString();
        }
        return null;
    }

    @Override
    public void store(MultipartFormDataInput file, String uploadFolderPath) throws IOException {
        fileService.saveFileToDb(this.process(file, uploadFolderPath), "");
    }

    @Override
    public void store(MultipartFormDataInput file, String uploadFolderPath, String keywords) throws IOException {
        fileService.saveFileToDb(this.process(file, uploadFolderPath), keywords);
    }

    @Override
    public void store(MultipartFormDataInput file, String uploadFolderPath, String parameterName, String keywords) throws IOException {
        fileService.saveFileToDb(this.process(file, uploadFolderPath, parameterName), keywords);
    }

    @Override
    public UploadModel process(MultipartFormDataInput file, String uploadFolderPath) throws IOException {
        return process(file, uploadFolderPath, UPFILE_PARAMETER_NAME);
    }

    @Override
    public UploadModel process(MultipartFormDataInput file, String uploadFolderPath, String parameterName) throws IOException {
        String defaultParamData = getUpfileParameterData(parameterName);
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, List<InputPart>> parametersForm = file.getFormDataMap();
        Map<String, Object> params = null;
        if (parametersForm.containsKey(defaultParamData)) {
            params = gson.fromJson(getDataFormValueByName(parametersForm.get(defaultParamData)), type);
        }
        Map<String, Object> metaDataFile = null;
        if (params != null) {
            metaDataFile = processFile(file, params, uploadFolderPath);
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Missing parameters.");
        }
        return new UploadModel(params, metaDataFile);
    }

    private Map<String, Object> processFile(MultipartFormDataInput content, String uploadFolderPath) {
        return processFile(content, null, uploadFolderPath);
    }

    private Map<String, Object> processFile(MultipartFormDataInput content, Map<String, Object> params, String uploadFolderPath) {
        return processFile(content, params, UPFILE_PARAMETER_NAME, uploadFolderPath);
    }

    private Map<String, Object> processFile(MultipartFormDataInput content, Map<String, Object> params, String uploadParamName, String uploadFolderPath) {
        Map<String, List<InputPart>> uploadForm = content.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get(uploadParamName);
        for (InputPart inputPart : inputParts) {
            MultivaluedMap<String, String> headers = inputPart.getHeaders();
            String filename = FileSupport.getFileNameMultiParts(headers);
            try {
                InputStream inputStream = inputPart.getBody(InputStream.class, null);
                byte[] bytes = IOUtils.toByteArray(inputStream);
                log.info(">>> File '{}' has been read, size: #{} bytes", filename, bytes.length);
                if (filename == null || filename.isEmpty()) {
                    throwBaseException(Response.Status.NO_CONTENT, "No content");
                }
                Map<String, Object> fileInfo;
                fileInfo = FileSupport.getUploadFileMetaData(filename, uploadFolderPath, params);
                Map<String, Object> resp = FileSupport.writeFileWithBuffer(bytes, fileInfo);
                fileInfo.putAll(FileSupport.scaleFileImage(bytes, fileInfo, params));
                return resp;
            } catch (IOException e) {
                throwBaseException(Response.Status.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
        return null;
    }

}
