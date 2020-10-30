package com.lc.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpUtils {

    private PoolingHttpClientConnectionManager pool;

    public HttpUtils() {
        pool = new PoolingHttpClientConnectionManager();
        //设置最大连接数
        pool.setMaxTotal(100);
        //最大主机连接数
        pool.setDefaultMaxPerRoute(10);
    }

    //下载html页面
    public String doGetHtml(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(pool).build();
        boolean flag = false;
        HttpGet httpGet = new HttpGet(url);
        httpGet.getConfig().custom().setSocketTimeout(10000)
                .setConnectTimeout(1000)
                .setConnectionRequestTimeout(500).build();

        CloseableHttpResponse response = null;
        String content = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                if (response.getEntity() != null) {
                    content = EntityUtils.toString(response.getEntity(), "utf8");
                    flag = true;
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
            httpClient.close();
        }

        if (flag) {
            return content;
        } else {
            return null;
        }

    }

    //下载图片
    public String doGetImage(String url) {

        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(pool).build();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response;
        try {
            response = httpClient.execute(httpGet);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
