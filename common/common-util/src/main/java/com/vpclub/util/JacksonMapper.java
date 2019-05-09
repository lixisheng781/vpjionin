package com.vpclub.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 *
 * @author yibo.liu
 */
public class JacksonMapper {
    /**
     * can reuse, share globally
     */
    private static final ObjectMapper object = new ObjectMapper();

    static {

    }


    /**
     * can reuse, share globally
     */
    private static final XmlMapper xmlMapper = new XmlMapper();

    static {
        xmlMapper.setDefaultUseWrapper(false);
        //字段为null，自动忽略，不再序列化
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //XML标签名:使用骆驼命名的属性名，
        //xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
    }


    /**
     * private constructor
     */
    private JacksonMapper() {
    }

    /**
     * return a ObjectMapper that is singleton
     * @return
     */
    public static ObjectMapper getObjectMapper() {
        return object;
    }

    /**
     * return a XmlMapper that is singleton
     * @return
     */
    public static XmlMapper getXmlMapper() {
        return xmlMapper;
    }
}
