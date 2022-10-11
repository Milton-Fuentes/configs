/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserclient.rest.wrapper.net;

import static com.atser.tools.atserutil.file.FileSupport.getFileNameMultiParts;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map.Entry;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;
import org.jboss.resteasy.plugins.providers.multipart.OutputPart;

/**
 *
 * @author droldan/david
 */
@Stateless
public class ExcelSyncfusionWrapper {

    public ExcelSyncfusionWrapper() {
    }

    private MultipartFormDataOutput fromFormDataInputToFormDataOutput(MultipartFormDataInput input) {
        /*MultipartFormDataOutput mdo = new MultipartFormDataOutput();
        int i = 0;
        for (Entry< String, List< InputPart>> inputPartEntry : input.getFormDataMap().entrySet()) {
            String partId = inputPartEntry.getKey();
            partId = partId.replaceAll("[^a-z,A-Z]", "");
            if (partId.equals("file")) {
                List< InputPart> inputParts = inputPartEntry.getValue();

                for (InputPart part : inputParts) {
                    MultivaluedMap< String, String> headers = part.getHeaders();

                    InputStream inputStream;
                    try {
                        inputStream = part.getBody(InputStream.class, null);
                        OutputPart objPart = mdo.addFormData(partId, inputStream, part.getMediaType());

                        objPart.getHeaders().putSingle(FieldName.CONTENT_DISPOSITION, "form-data; name=" + partId + "; filename=" + getFileNameMultiParts(headers));
                    } catch (IOException e) {
                        return null;
                    }
                }
                break;
            }

        }
        return mdo;*/
        return null;
    }

    /**
     * importExcelWrapper
     * @param urlWs
     * @param content
     * @return Model
     */
    public String importExcelWrapper(String urlWs, MultipartFormDataInput content) {

        Client client = ClientBuilder.newClient();

        Response resp;

        final String mediaType = MediaType.APPLICATION_JSON;
        WebTarget rxTarget = client.target(urlWs);
        resp = rxTarget.request().accept(mediaType).post(Entity.entity(fromFormDataInputToFormDataOutput(content), MediaType.MULTIPART_FORM_DATA_TYPE));

        verifyResponseRs(resp);

        String output = resp.readEntity(String.class);

        return output;
    }
    
    public String exportToExcelWrapper(String urlws, String sheetModel, String sheetData, String password, String fileName) {

        Client client = ClientBuilder.newClient();

        Response resp;

        Form form = new Form();
        form.param("sheetModel", sheetModel);
        form.param("sheetData", sheetData);
        form.param("password", password);
        form.param("fileName", fileName);
        
        final String mediaType = MediaType.APPLICATION_XML;
        WebTarget rxTarget = client.target(urlws);
        resp = rxTarget.request().accept(mediaType).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

        verifyResponseRs(resp);
        
        String output = resp.readEntity(String.class);
        
        return output;
    }

    private void verifyResponseRs(Response rsp) {
        String responseHTTP = rsp.getStatusInfo().getReasonPhrase();
        int codeResponseHTTP = rsp.getStatusInfo().getStatusCode();
        Family typeResponseHTTP = rsp.getStatusInfo().getFamily();

        if (Family.SUCCESSFUL == typeResponseHTTP) {
            System.out.println("OK");
            System.out.println(codeResponseHTTP);
            System.out.println("********");
        } else {
            System.out.println("ERROR");
            System.out.println(codeResponseHTTP);
            System.out.println(responseHTTP);

        }

    }
}
