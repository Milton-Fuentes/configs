/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.solr.others;

/*import com.atser.tools.atserutil.solr.others.AtserDoc;
import java.io.IOException;
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
/*public class SolrSample {

   
    public static void main(String[] args) {
        print("--> Starting");

        print("--> Done");
    }

    
    public static void query1() {
        try {
            // Connecting to the server.
            SolrClient client = getSolrClient();

            // Inicializing the parameters map.
            Map<String, String> queryParamMap = new HashMap<>();
            queryParamMap.put("q", "*:*");
            queryParamMap.put("fl", "id, name");
            MapSolrParams queryParams = new MapSolrParams(queryParamMap);

            // Making the request - specifying the core: "atser". 
            QueryResponse response = client.query("atser", queryParams);
            SolrDocumentList documents = response.getResults();

            // assertEquals(NUM_INDEXED_DOCUMENTS, documents.getNumFound());
            for (SolrDocument document : documents) {
                System.out.println();
                System.out.println(document);
                // System.out.println(document.getFieldNames().contains("id"));
                // System.out.println(document.getFieldNames().contains("name"));
            }

        } catch (IOException | SolrServerException e) {
            print("-> Error.");
        }

    }

    
    public static void query2() {
        try {
            // Connecting to the server.
            SolrClient client = getSolrClient();

            // Inicializing the parameters map.
            SolrQuery query = new SolrQuery("*:*");
            query.addField("id");
            query.addField("name");
            query.setRows(10);

            // Making the request - specifying the core: "atser". 
            QueryResponse response = client.query("atser", query);
            SolrDocumentList documents = response.getResults();

            // assertEquals(NUM_INDEXED_DOCUMENTS, documents.getNumFound());
            for (SolrDocument document : documents) {
                System.out.println();
                System.out.println(document);
                // System.out.println(document.getFieldNames().contains("id"));
                // System.out.println(document.getFieldNames().contains("name"));
            }

        } catch (IOException | SolrServerException e) {
            print("-> Error.");
        }

    }

   
    public static void addDocument() {
        try {
            SolrClient client = getSolrClient();

            // Creating the new document.
            AtserDoc kindle = new AtserDoc("kindle-id-4", "Amazon Kindle Paperwhite");
            UpdateResponse response = client.addBean("atser", kindle);

            // Commit.
            client.commit("atser");
        } catch (IOException | SolrServerException e) {
            print("-> Error.");
        }
    }

    
    public static void query3() {
        try {
            // Connecting to the server.
            SolrClient client = getSolrClient();

            // Inicializing the parameters map.
            SolrQuery query = new SolrQuery("*:*");
            query.addField("id");
            query.addField("name");
            query.setRows(10);

            // Making the request - specifying the core: "atser". 
            QueryResponse response = client.query("atser", query);
            List<AtserDoc> products = response.getBeans(AtserDoc.class);

            // assertEquals(NUM_INDEXED_DOCUMENTS, documents.getNumFound());
            for (AtserDoc atserDoc : products) {
                System.out.println();
                System.out.println(atserDoc);
                // System.out.println(document.getFieldNames().contains("id"));
                // System.out.println(document.getFieldNames().contains("name"));
            }

        } catch (IOException | SolrServerException e) {
            print("-> Error.");
        }

    }

    
    public static void getNodes() {
        try {
            SolrClient client = getSolrClient();
            SolrRequest request = new CollectionAdminRequest.ClusterStatus();

            NamedList<Object> response = client.request(request);
            NamedList<Object> cluster = (NamedList<Object>) response.get("cluster");
            List<String> liveNodes = (List<String>) cluster.get("live_nodes");

        } catch (IOException | SolrServerException e) {
            print("-> Error.");
        }
    }

    
    public static HttpSolrClient getSolrClient() {
        final String solrUrl = "http://localhost:8983/solr";
        return new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }

    
    public static void print(String value) {
        System.out.println();
        System.out.println(value);
    }

}*/
