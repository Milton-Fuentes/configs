/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.write.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author droldan
 */
public class BuildCsv implements CsvDocument {
    
    private final String targetPath;
    private final Class targetClass;

    public BuildCsv(String targetPath, Class targetClass) {
        this.targetPath = targetPath;
        this.targetClass = targetClass;
    }

    @Override
    public String writeCsv(List<?> items) throws JsonProcessingException, IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);        
        CsvSchema schema = mapper.schemaFor(targetClass);
        Writer writer = Files.newBufferedWriter(Paths.get(targetPath));
        mapper.writer(schema.withUseHeader(true)).writeValue(writer, items);
        return targetPath;
    }

}
