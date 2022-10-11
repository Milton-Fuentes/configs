package com.atser.tools.atserutil.parser.excel.plugin.task.builder;


import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.SheetParser;
import com.atser.tools.atserutil.parser.excel.plugin.task.model.GModel;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author droldan
 */
public abstract class BaseBuilder {
    protected GModel data;
    protected SheetParser parser;
    protected Sheet sheet;

    public BaseBuilder(Sheet page) {
        parser = new SheetParser();
        sheet = page;
    }

    public GModel getData() {
        return data;
    }

    public abstract void buildTasks() throws ExcelParsingException;

}
