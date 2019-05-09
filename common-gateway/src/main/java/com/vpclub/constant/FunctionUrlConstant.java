package com.vpclub.constant;

import java.util.List;

/**
 * 功能URL
 *
 * @author
 * @date 12/25
 */
public class FunctionUrlConstant {
    public static List<String> ignoreUrl;

    public static List<String> getIgnoreUrl() {
        return ignoreUrl;
    }

    public static void setIgnoreUrl(List<String> ignoreUrl) {
        FunctionUrlConstant.ignoreUrl = ignoreUrl;
    }
}
