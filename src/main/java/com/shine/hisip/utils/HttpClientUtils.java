package com.shine.hisip.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wl on 2017/6/9.
 */
public class HttpClientUtils {
    @Test
    public void test() {
        Header[] headers = {new BasicHeader("AccountNumber", "0647"),
                new BasicHeader("Password", "123456")};
        List<BasicNameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("AccountNumber", "0647"));  //请求参数
        list.add(new BasicNameValuePair("Password", "123456")); //请求参数
        HttpClientUtils.postExecute("http://192.168.20.21:10000/his/SignIn", headers, list);
    }

    /**
     * 同步get请求
     *
     * @param utl     请求地址
     * @param headers 请求头
     * @param params  请求参数，k-v
     * @return
     */
    public static JSONObject getExecute(String utl, Header[] headers, Map<String, Object> params) {
        String url = utl;
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (String key : params.keySet()) {
            if (i == 0)
                param.append("?");
            else
                param.append("&");
            param.append(key).append("=").append(params.get(key));
            i++;
        }
        url += param;
        CloseableHttpClient httpCilent = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)   //设置连接超时时间
                .setConnectionRequestTimeout(5000) // 设置请求超时时间
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)//默认允许自动重定向
                .build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeaders(headers);
        httpGet.setConfig(requestConfig);
        JSONObject result = null;
        try {
            HttpResponse httpResponse = httpCilent.execute(httpGet);
            result = getResult(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpCilent.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }


    /**
     * 同步get请求
     *
     * @param utl     请求URl
     * @param headers 请求头
     * @return
     */
    public static JSONObject getExecute(String utl, Header[] headers) {
        CloseableHttpClient httpCilent = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)   //设置连接超时时间
                .setConnectionRequestTimeout(5000) // 设置请求超时时间
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)//默认允许自动重定向
                .build();
        HttpGet httpGet = new HttpGet(utl);
        httpGet.setHeaders(headers);
        httpGet.setConfig(requestConfig);
        try {
            HttpResponse httpResponse = httpCilent.execute(httpGet);
            return getResult(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpCilent.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * 同步post请求
     *
     * @param utl            请求地址
     * @param header         请求头
     * @param nameValuePairs 请求参数
     * @return
     */
    public static JSONObject postExecute(String utl, Header header, List<BasicNameValuePair> nameValuePairs) {
        Header[] headers = {header};
        return postExecute(utl, headers, nameValuePairs);
    }

    /**
     * 同步post请求
     *
     * @param utl            请求地址
     * @param headerList     请求头
     * @param nameValuePairs 请求参数
     * @return
     */
    public static JSONObject postExecute(String utl, List<Header> headerList, List<BasicNameValuePair> nameValuePairs) {
        Header[] headers = new Header[headerList.size()];
        for (int i = 0; i < headerList.size(); i++) {
            headers[i] = headerList.get(i);
        }
        return postExecute(utl, headers, nameValuePairs);
    }

    /**
     * 同步post请求
     *
     * @param utl     请求地址
     * @param headers 请求头信息
     * @param params  map类型请求参数
     * @return
     */
    public static JSONObject postExecute(String utl, Header[] headers, Map<String, Object> params) {
        //获取可关闭的 httpCilent
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //配置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000)
                .setRedirectsEnabled(true)
                .build();
        //设置URL
        HttpPost httpPost = new HttpPost(utl);
        //设置请求头
        httpPost.setHeaders(headers);
        //设置超时时间
        httpPost.setConfig(requestConfig);
        JSONObject jsonObject = null;
        try {
            //装配post请求参数
            List<NameValuePair> pairList = new ArrayList<>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                        .getValue().toString());
                pairList.add(pair);
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairList, "UTF-8");
            httpPost.setEntity(entity);

            //设置post求情参数
            HttpResponse httpResponse = httpClient.execute(httpPost);
            jsonObject = getResult(httpResponse);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close(); //释放资源
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonObject;
        }
    }

    /**
     * 同步post请求
     *
     * @param utl    请求地址
     * @param params map类型请求参数
     * @return
     */
    public static JSONObject postExecute(String utl, Map<String, Object> params) {
        //获取可关闭的 httpCilent
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //配置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000)
                .setRedirectsEnabled(true)
                .build();
        //设置URL
        HttpPost httpPost = new HttpPost(utl);
        //设置超时时间
        httpPost.setConfig(requestConfig);
        JSONObject jsonObject = null;
        try {
            //装配post请求参数
            List<NameValuePair> pairList = new ArrayList<>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                        .getValue().toString());
                pairList.add(pair);
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairList, "UTF-8");
            httpPost.setEntity(entity);

            //设置post求情参数
            HttpResponse httpResponse = httpClient.execute(httpPost);
            jsonObject = getResult(httpResponse);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close(); //释放资源
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonObject;
        }
    }

    /**
     * 同步post请求
     *
     * @param utl            请求地址
     * @param headers        请求头
     * @param nameValuePairs 请求参数
     * @return
     */
    public static JSONObject postExecute(String utl, Header[] headers, List<BasicNameValuePair> nameValuePairs) {
        //获取可关闭的 httpCilent
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //配置超时时间
        RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(1000).setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000).setRedirectsEnabled(true).build();
        //设置URL
        HttpPost httpPost = new HttpPost(utl);
        //设置请求头
        httpPost.setHeaders(headers);
        //设置超时时间
        httpPost.setConfig(requestConfig);
        JSONObject jsonObject = null;
        try {
            //装配post请求参数
            if (null != nameValuePairs && nameValuePairs.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
                httpPost.setEntity(entity);
            }
            //设置post求情参数
            HttpResponse httpResponse = httpClient.execute(httpPost);
            jsonObject = getResult(httpResponse);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close(); //释放资源
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonObject;
        }
    }

    /**
     * 获取结果
     *
     * @param httpResponse
     * @return
     * @throws IOException
     */
    private static JSONObject getResult(HttpResponse httpResponse) throws IOException {
        if (httpResponse != null) {
            String strResult = EntityUtils.toString(httpResponse.getEntity());
            //一个简单方便 的方法将Json文本信息转换为JsonObject对象的同时转换为JavaBean对象！
            JSONObject jsonObject = JSON.parseObject(strResult);
            return jsonObject;
        } else {
            return null;
        }
    }

}
