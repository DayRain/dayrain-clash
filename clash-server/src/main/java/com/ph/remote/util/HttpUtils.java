package com.ph.remote.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpUtils {

    private static final CloseableHttpClient httpclient = HttpClients.createDefault() ;

    public HttpUtils(){}


    private final String token = "配置你自己的token";
	
    public String get(String url) {
        HttpGet httpget = new HttpGet(url);
        httpget.setHeader("Authorization", token);
        CloseableHttpResponse response = null;
        String result = null;
        try {
            //3.执行get请求并返回结果
            response = httpclient.execute(httpget);

            HttpEntity entity =  response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {

            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
