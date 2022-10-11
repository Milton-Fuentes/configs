package com.atser.tools.atserutil.parser.excel.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by dropal on 12/08/2015.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD })
public @interface MappedExcelObject {
}
