package com.vpclub.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomUtils {
    private static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETTER_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER_CHAR = "0123456789";

    private static final DateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");

    private static final DateFormat timeFormater = new SimpleDateFormat("HHmmss");

    private static final DateFormat datetimeFormater = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final DateFormat datetimeWithMsFormater = new SimpleDateFormat("yyyyMMddHHmmssSSS");


    public static String generateDatetimePerfix() {
        return datetimeFormater.format(new Date());
    }


    public static String generateDatetimeWithMsPerfix() {
        return datetimeWithMsFormater.format(new Date());
    }






    /**
     * 获取定长的随机数，包含大小写、数字
     *
     * @param length 随机数长度
     */
    public static String generateString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (; length > 0; length--) {
            sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 获取定长的随机数，包含大小写、数字(安全类型)
     *
     * @param length 随机数长度
     */
    public static String generateSafeString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (; length > 0; length--) {
            sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 获取定长的随机数，包含大小写字母
     *
     * @param length 随机数长度
     */
    public static String generateMixString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (; length > 0; length--) {
            sb.append(LETTER_CHAR.charAt(random.nextInt(LETTER_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 获取定长的随机数，只包含小写字母
     *
     * @param length 随机数长度
     */
    public static String generateLowerString(int length) {
        return generateMixString(length).toLowerCase();
    }

    /**
     * 获取定长的随机数，只包含大写字母
     *
     * @param length 随机数长度
     */
    public static String generateUpperString(int length) {
        return generateMixString(length).toUpperCase();
    }

    /**
     * 获取定长的随机数，只包含数字
     *
     * @param length 随机数长度
     */
    public static String generateNumberString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (; length > 0; length--) {
            sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
        }
        return sb.toString();
    }

}
