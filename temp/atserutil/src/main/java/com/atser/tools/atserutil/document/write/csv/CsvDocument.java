/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.write.csv;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface CsvDocument {

    public String writeCsv(List<?> items) throws JsonProcessingException, IOException;
}
