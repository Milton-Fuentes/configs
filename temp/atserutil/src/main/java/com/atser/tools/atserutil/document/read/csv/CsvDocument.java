/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.document.read.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author droldan
 */
public class CsvDocument {

    /**
     * input Reader
     */
    private Reader inputReader;

    /**
     * Constructor for Csv class
     *
     * @param file
     * @throws FileNotFoundException
     */
    public CsvDocument(File file) throws FileNotFoundException {
        inputReader = new FileReader(file);
    }

    public CsvDocument(Reader inputReader) {
        this.inputReader = inputReader;
    }

    /**
     * Close Reader
     *
     * @throws IOException
     */
    public void closeReader() throws IOException {
        if (inputReader != null) {
            inputReader.close();
        }
    }

    /**
     * Get Iterable<CSVRecord> using differents kinds of formats
     *
     * @param format (CSVFormat)
     * @return
     * @throws IOException
     */
    public Iterable<CSVRecord> getRecords(CSVFormat format) throws IOException {
        return format.parse(inputReader);
    }

    /**
     * Get Iterable<CSVRecord> using differents kinds of formats and Enum as Header
     *
     * @param format
     * @param headers
     * @return
     * @throws IOException
     */
    public Iterable<CSVRecord> getRecords(CSVFormat format, Class<? extends Enum<?>> headers) throws IOException {
        return format.withHeader(headers).parse(inputReader);
    }

    /**
     * Get Iterable<CSVRecord> using differents kinds of formats and String array as Header
     *
     * @param format
     * @param headers
     * @return
     * @throws IOException
     */
    public Iterable<CSVRecord> getRecords(CSVFormat format, String[] headers) throws IOException {
        return format.withHeader(headers).parse(inputReader);
    }

    /**
     * Get Iterable<CSVRecord> using differents kinds of formats and header auto detection
     *
     * @param format
     * @return
     * @throws IOException
     */
    public Iterable<CSVRecord> getRecordsAutoDetectionHeaders(CSVFormat format) throws IOException {
        return format.withFirstRecordAsHeader().parse(inputReader);
    }

}
