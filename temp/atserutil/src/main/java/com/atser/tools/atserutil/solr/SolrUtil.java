/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.solr;

/*import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.util.NamedList;*/

/**
 *
 * @author dperez
 */
/*public class SolrUtil {

    static String solrIp = "http://localhost";
    static String solrPort = "8983";
    static String solrName = "solr";
    
    static Integer timeout = 10000;
    static Integer socketTimeout = 6000;
        
    static HttpSolrClient client;

    private static HttpSolrClient openCnx() {

        String solrUrl = solrIp + ":" + solrPort + "/" + solrName;

        client = new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(timeout)
                .withSocketTimeout(socketTimeout)
                .build();
        
        return client;
    }

    public static SolrDocumentList search(String value, String collection) {
        try {
            // Connecting to the server.
            openCnx();

            // Inicializing the parameters map.
            SolrQuery query = new SolrQuery(value);
            query.addField("id");
            query.addField("name");
            query.setRows(10);

            // Making the request - specifying the core: "atser". 
            QueryResponse response = client.query(collection, query);
            SolrDocumentList documents = response.getResults();

            return documents;

        } catch (IOException | SolrServerException e) {
            return null;
        }
    }

   
    private static void print(String value) {
        System.out.println();
        System.out.println(value);
    }

}
*/