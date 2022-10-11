package com.atser.tools.atserutil.parser.excel;

/**
 * Created by dropal.
 */
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.MappedExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import com.atser.tools.atserutil.parser.excel.bridge.HSSFBridge;
import com.atser.tools.atserutil.string.StringSupport;
import org.apache.poi.ss.usermodel.Sheet;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SheetParser {

    private HSSFBridge hssfbridge;
    private Map<String, Map<Integer, Field>> excelMapCache;

    public SheetParser() {
        hssfbridge = new HSSFBridge();
        excelMapCache = new HashMap<>();
    }
    
    public <T> List<T> createEntity(Sheet sheet, String sheetName, Class<T> clazz, int allowNullLines)
            throws ExcelParsingException {
        List<T> list = new ArrayList<>();
        ExcelObject excelObject = getExcelObject(clazz);
        int emptyCount = 0;
        for (int currentLocation = excelObject.start(); currentLocation <= excelObject.end(); currentLocation++) {
            T object = getNewInstance(sheet, sheetName, clazz, excelObject.parseType(), currentLocation, excelObject.zeroIfNull());
            if (object != null) {
                List<Field> mappedExcelFields = getMappedExcelObjects(clazz);
                emptyCount = 0;
                for (Field mappedField : mappedExcelFields) {
                    Class<?> fieldType = mappedField.getType();
                    //List<?> fieldValue = createEntity(sheet, sheetName, fieldType.equals(List.class) ? getFieldType(mappedField): fieldType);
                    Class<?> clazz1 = fieldType.equals(List.class) ? getFieldType(mappedField) : fieldType;
                    List<?> fieldValue = createEntity(sheet, sheetName, clazz1);
                    if (fieldType.equals(List.class)) {
                        setFieldValue(mappedField, object, fieldValue);
                    } else if (!fieldValue.isEmpty()) {
                        setFieldValue(mappedField, object, fieldValue.get(0));
                    }
                }
                list.add(object);
            } else {
                emptyCount++;
            }
            if (emptyCount > allowNullLines) {
                return list;
            }
        }
        return list;
    }

    public <T> List<T> createEntity(Sheet sheet, String sheetName, Class<T> clazz)
            throws ExcelParsingException {
        return createEntity(sheet, sheetName, clazz, 2);
    }

    private Class<?> getFieldType(Field field) {
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            return (Class<?>) pt.getActualTypeArguments()[0];
        }

        return null;
    }

    private <T> List<Field> getMappedExcelObjects(Class<T> clazz) {
        List<Field> fieldList = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            MappedExcelObject mappedExcelObject = field.getAnnotation(MappedExcelObject.class);
            if (mappedExcelObject != null) {
                field.setAccessible(true);
                fieldList.add(field);
            }
        }
        return fieldList;
    }

    private <T> ExcelObject getExcelObject(Class<T> clazz) throws ExcelParsingException {
        ExcelObject excelObject = clazz.getAnnotation(ExcelObject.class);
        if (excelObject == null) {
            throw new ExcelParsingException("Invalid class configuration - ExcelObject annotation missing - "
                    + clazz.getSimpleName());
        }
        return excelObject;
    }

    private <T> T getNewInstance(Sheet sheet, String sheetName, Class<T> clazz, ParseType parseType,
            Integer currentLocation, boolean zeroIfNull) throws ExcelParsingException {
        T object = getInstance(clazz);
        Map<Integer, Field> excelPositionMap = getExcelFieldPositionMap(clazz);
        int emptyCount = 0;
        for (Integer position : excelPositionMap.keySet()) {
            Field field = excelPositionMap.get(position);
            Object cellValue;
            if (ParseType.ROW == parseType) {
                cellValue = hssfbridge.getCellValue(sheet, sheetName, field.getType(), currentLocation, position, zeroIfNull);
            } else {
                cellValue = hssfbridge.getCellValue(sheet, sheetName, field.getType(), position, currentLocation, zeroIfNull);
            }
            if (StringSupport.isNullOrEmpty(cellValue)) {
                emptyCount++;
            }
            setFieldValue(field, object, cellValue);
        }

        if (emptyCount == excelPositionMap.size()) {
            return null;
        }

        return object;
    }

    private <T> T getInstance(Class<T> clazz) throws ExcelParsingException {
        T object = null;
        try {
            object = clazz.newInstance();
        } catch (Exception e) {
            throw new ExcelParsingException("Exception occured while instantiating the class " + clazz.getName(), e);
        }
        return object;
    }

    private <T> void setFieldValue(Field field, T object, Object cellValue) throws ExcelParsingException {
        try {
            field.set(object, cellValue);
        } catch (IllegalArgumentException e) {
            throw new ExcelParsingException("Exception occured while setting field value ", e);
        } catch (IllegalAccessException e) {
            throw new ExcelParsingException("Exception occured while setting field value ", e);
        }
    }

    private <T> Map<Integer, Field> getExcelFieldPositionMap(Class<T> clazz) {
        Map<Integer, Field> existingMap = excelMapCache.get(clazz.getName());
        return existingMap == null ? loadCache(clazz) : existingMap;
    }

    /**
     * Load cached for the given class.
     *
     * @param clazz
     * Class object to investigate.
     * @return Map.
     */
    private <T> Map<Integer, Field> loadCache(Class<T> clazz) {
        Map<Integer, Field> fieldMap = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            ExcelField excelField = field.getAnnotation(ExcelField.class);
            if (excelField != null) {
                field.setAccessible(true);
                fieldMap.put(excelField.position(), field);
            }
        }
        excelMapCache.put(clazz.getName(), fieldMap);
        return fieldMap;
    }
}
