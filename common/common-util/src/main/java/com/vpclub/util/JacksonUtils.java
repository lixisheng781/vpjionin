package com.vpclub.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 通用方法，用于转换xml到bean，或者bean 到xml
 * @author yibo.liu
 */
public class JacksonUtils {





    /**
     * XML To Object
     *
     * @param xmlString
     * @param cls
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T xmlToBean(String xmlString, Class<T> cls) throws IOException {
        XmlMapper xml = JacksonMapper.getXmlMapper();
        T obj = xml.readValue(xmlString, cls);
        return obj;
    }

    /**
     * @param xmlFile
     * @param cls
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T xmlToBean(File xmlFile, Class<T> cls) throws IOException {
        XmlMapper xml = JacksonMapper.getXmlMapper();
        T obj = xml.readValue(xmlFile, cls);
        return obj;
    }

    /**
     * @param xmlInputStream
     * @param cls
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T xmlToBean(InputStream xmlInputStream, Class<T> cls) throws IOException {
        XmlMapper xml = JacksonMapper.getXmlMapper();
        T obj = xml.readValue(xmlInputStream, cls);
        return obj;
    }

    public static <T> String beanToXml(T bean) throws JsonProcessingException {
        XmlMapper xml = JacksonMapper.getXmlMapper();
        String string = xml.writeValueAsString(bean);
        return string;
    }
}
