/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.exception;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author droldan
 */
public class ExcelInvalidCellValuesException extends ExcelParsingException {

    List<ExcelInvalidCell> invalidCells;

    public ExcelInvalidCellValuesException(String message) {
        super(message);
        invalidCells = new ArrayList<>();
    }

    public ExcelInvalidCellValuesException(String message, Exception exception) {
        super(message, exception);
        invalidCells = new ArrayList<>();
    }

    public List<ExcelInvalidCell> getInvalidCells() {
        return invalidCells;
    }

    public void setInvalidCells(List<ExcelInvalidCell> invalidCells) {
        this.invalidCells = invalidCells;
    }

    public void addInvalidCell(ExcelInvalidCell excelInvalidCell) {
        invalidCells.add(excelInvalidCell);
    }
}
