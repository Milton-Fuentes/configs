package com.atser.tools.atserutil.parser.excel.annotations;

import com.atser.tools.atserutil.enumerator.eExcelFieldFormat;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by dropal on 18/08/2015.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExcelField {

    int position();

    ValidationType validationType() default ValidationType.SOFT;

    boolean validate() default false;

    String regex() default ".*";

    eExcelFieldFormat format() default eExcelFieldFormat.text;
}
