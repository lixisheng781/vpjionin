import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestUUUI {


    private static String WX_B_CODE_URL = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN"; //不限次数 scene长度为32个字符

    public void test(){

    }

    /**
     * B接口生成小程序码
     * @param access_token
     * @param page
     * @param scene
     */
    public String createBCode(String access_token,String page,String scene){
        String url = WX_B_CODE_URL.replace("ACCESS_TOKEN", access_token);
        Map<String,Object> param = new HashMap<>();
        param.put("page", page);
        param.put("scene", scene);
        param.put("width", "100");
        param.put("auto_color", false);
        Map<String,Object> line_color = new HashMap<>();
        line_color.put("r", 0);
        line_color.put("g", 0);
        line_color.put("b", 0);
        param.put("line_color", line_color);
        try {
            String imageUrl = httpPostWithJSON2(url, JSON.toJSONString(param), "e:abc.png");
            return imageUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回图片地址
    public String httpPostWithJSON2(String url, String json,String imagePath)
            throws Exception {
        String result = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");

        StringEntity se = new StringEntity(json);
        se.setContentType("application/json");
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"UTF-8"));
        httpPost.setEntity(se);
        HttpResponse response = httpClient.execute(httpPost);
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                InputStream instreams = resEntity.getContent();
                //上传至资源服务器生成url
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bs = new byte[1024];//缓冲数组
                int len = -1;
                while ((len = instreams.read(bs)) != -1) {
                    byteArrayOutputStream.write(bs, 0, len);
                }
                byte b[] = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                instreams.close();
                //将byte字节数组上传至资源服务器返回图片地址
                // ......
            }
        }
        httpPost.abort();
        return result;
    }

}
