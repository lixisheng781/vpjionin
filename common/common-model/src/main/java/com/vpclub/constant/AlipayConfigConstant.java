package com.vpclub.constant;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author NanZheng
 * @projectName vpclub
 * @since 2018/5/17
 * 支付宝支付的常量设置
 */
@Component
@ConfigurationProperties(prefix = "AlipayConfig")
public class AlipayConfigConstant {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id;//正式

    // 商户UID
    public static String seller_id;//正式

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key;//正式

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key;//正式

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url;//正式

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url;//正式

    // 签名方式
    public static String sign_type;

    // 字符编码格式
    public static String charset;

    // 支付宝网关
    public static String gatewayUrl;//正式

    // 支付宝网关
    public static String log_path;


    public static String getApp_id() {
        return app_id;
    }

    public static void setApp_id(String app_id) {
        AlipayConfigConstant.app_id = app_id;
    }

    public static String getSeller_id() {
        return seller_id;
    }

    public static void setSeller_id(String seller_id) {
        AlipayConfigConstant.seller_id = seller_id;
    }

    public static String getMerchant_private_key() {
        return merchant_private_key;
    }

    public static void setMerchant_private_key(String merchant_private_key) {
        AlipayConfigConstant.merchant_private_key = merchant_private_key;
    }

    public static String getAlipay_public_key() {
        return alipay_public_key;
    }

    public static void setAlipay_public_key(String alipay_public_key) {
        AlipayConfigConstant.alipay_public_key = alipay_public_key;
    }

    public static String getNotify_url() {
        return notify_url;
    }

    public static void setNotify_url(String notify_url) {
        AlipayConfigConstant.notify_url = notify_url;
    }

    public static String getReturn_url() {
        return return_url;
    }

    public static void setReturn_url(String return_url) {
        AlipayConfigConstant.return_url = return_url;
    }

    public static String getSign_type() {
        return sign_type;
    }

    public static void setSign_type(String sign_type) {
        AlipayConfigConstant.sign_type = sign_type;
    }

    public static String getCharset() {
        return charset;
    }

    public static void setCharset(String charset) {
        AlipayConfigConstant.charset = charset;
    }

    public static String getGatewayUrl() {
        return gatewayUrl;
    }

    public static void setGatewayUrl(String gatewayUrl) {
        AlipayConfigConstant.gatewayUrl = gatewayUrl;
    }

    public static String getLog_path() {
        return log_path;
    }

    public static void setLog_path(String log_path) {
        AlipayConfigConstant.log_path = log_path;
    }
}
