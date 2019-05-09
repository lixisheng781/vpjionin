package com.vpclub.common;


import org.apache.commons.io.IOUtils;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

public class RequestBodyReader {

    // 字符串读取
    // 方法一
    public static String getRequestBody1(HttpServletRequest request) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    // 方法二
    public static String getRequestBody2(HttpServletRequest request) {
        InputStream is = null;
        StringBuilder sb = new StringBuilder("");
        try {
            is = request.getInputStream();
            byte[] b = new byte[4096];
            for (int n; (n = is.read(b)) != -1; ) {
                sb.append(new String(b, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    // 方法三
    public static String getRequestBody3(HttpServletRequest request) {
        String jsonBody = "";
        try {
            jsonBody = IOUtils.toString(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonBody;
    }


    // 二进制读取
    public static byte[] readAsBytes(HttpServletRequest request) {

        int len = request.getContentLength();
        byte[] buffer = new byte[len];
        ServletInputStream in = null;

        try {
            in = request.getInputStream();
            in.read(buffer, 0, len);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }

}
