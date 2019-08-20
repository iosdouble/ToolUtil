package com.nh.code.util.net;


import com.nh.code.util.net.bean.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.UnsupportedEncodingException;
import java.util.Map;
/**
 * @Classname HttpSendBaseUtil
 * @Description TODO
 * @Date 2019/7/22 5:09 PM
 * @Created by nihui
 */

public class HttpsSendUtil extends HttpsSendBaseUtil {
    public HttpsSendUtil(CloseableHttpClient closeableHttpClient) {
        super(closeableHttpClient);
    }

    public HttpResponse sendHttpsPostContent(String httpUrl, Map<String, String> headers, String contentStr, String contentType) {
        HttpPost httpPost = new HttpPost(httpUrl);
        this.ceateHeader(httpPost, headers);
        StringEntity stringEntity = this.createBodyStringEntity(contentStr, contentType);
        httpPost.setEntity(stringEntity);
        HttpResponse httpResponse = this.sendHttpsBase(httpPost);
        return httpResponse;
    }

    public HttpResponse sendHttpsPostContent(String httpUrl, String contentStr, String contentType) {
        return this.sendHttpsPostContent(httpUrl, (Map) null, contentStr, contentType);
    }

    public HttpResponse sendHttpsPostContent(String httpUrl, String contentStr) {
        return this.sendHttpsPostContent(httpUrl, (Map) null, contentStr, (String) null);
    }

    public HttpResponse sendHttpsPostJson(String httpUrl, Map<String, String> headers, String contentJsonStr) {
        String jsonCcontentType = ContentType.APPLICATION_JSON.getMimeType();
        return this.sendHttpsPostContent(httpUrl, headers, contentJsonStr, jsonCcontentType);
    }

    public HttpResponse sendHttpsPostJson(String httpUrl, String contentJsonStr) {
        return this.sendHttpsPostJson(httpUrl, (Map) null, contentJsonStr);
    }

    public HttpResponse sendHttpsPostKeyValue(String httpUrl, Map<String, String> headers, Map<String, String> params) {
        HttpPost httpPost = new HttpPost(httpUrl);
        this.ceateHeader(httpPost, headers);
        UrlEncodedFormEntity urlEncodedFormEntity = null;

        try {
            urlEncodedFormEntity = this.createUrlEncodedFormEntity(params);
            httpPost.setEntity(urlEncodedFormEntity);
        } catch (UnsupportedEncodingException var7) {
            var7.printStackTrace();
        }

        HttpResponse httpResponse = this.sendHttpsBase(httpPost);
        return httpResponse;
    }

    public HttpResponse sendHttpsPostKeyValue(String httpUrl, Map<String, String> params) {
        return this.sendHttpsPostKeyValue(httpUrl, (Map) null, params);
    }

    public HttpResponse sendHttpsPost(String httpUrl) {
        return this.sendHttpsPostKeyValue(httpUrl, (Map) null);
    }

    public HttpResponse sendHttpsPutContent(String httpUrl, Map<String, String> headers, String contentStr, String contentType) {
        HttpPut httpPut = new HttpPut(httpUrl);
        this.ceateHeader(httpPut, headers);
        StringEntity stringEntity = this.createBodyStringEntity(contentStr, contentType);
        httpPut.setEntity(stringEntity);
        HttpResponse httpResponse = this.sendHttpsBase(httpPut);
        return httpResponse;
    }

    public HttpResponse sendHttpsPutContent(String httpUrl, String contentStr, String contentType) {
        return this.sendHttpsPutContent(httpUrl, (Map) null, contentStr, contentType);
    }

    public HttpResponse sendHttpsPutContent(String httpUrl, String contentStr) {
        return this.sendHttpsPutContent(httpUrl, (Map) null, contentStr, (String) null);
    }

    public HttpResponse sendHttpsPutJson(String httpUrl, Map<String, String> headers, String contentJsonStr) {
        String jsonCcontentType = ContentType.APPLICATION_JSON.getMimeType();
        return this.sendHttpsPutContent(httpUrl, headers, contentJsonStr, jsonCcontentType);
    }

    public HttpResponse sendHttpsPutJson(String httpUrl, String contentJsonStr) {
        return this.sendHttpsPutJson(httpUrl, (Map) null, contentJsonStr);
    }

    public HttpResponse sendHttpsPutKeyValue(String httpUrl, Map<String, String> headers, Map<String, String> params) {
        HttpPut httpPut = new HttpPut(httpUrl);
        this.ceateHeader(httpPut, headers);
        UrlEncodedFormEntity urlEncodedFormEntity = null;

        try {
            urlEncodedFormEntity = this.createUrlEncodedFormEntity(params);
            httpPut.setEntity(urlEncodedFormEntity);
        } catch (UnsupportedEncodingException var7) {
            var7.printStackTrace();
        }

        HttpResponse httpResponse = this.sendHttpsBase(httpPut);
        return httpResponse;
    }

    public HttpResponse sendHttpsPutKeyValue(String httpUrl, Map<String, String> params) {
        return this.sendHttpsPutKeyValue(httpUrl, (Map) null, params);
    }

    public HttpResponse sendHttpsPut(String httpUrl) {
        return this.sendHttpsPutKeyValue(httpUrl, (Map) null);
    }

    public HttpResponse sendHttpsPatchContent(String httpUrl, Map<String, String> headers, String contentStr, String contentType) {
        HttpPatch httpPatch = new HttpPatch(httpUrl);
        this.ceateHeader(httpPatch, headers);
        StringEntity stringEntity = this.createBodyStringEntity(contentStr, contentType);
        httpPatch.setEntity(stringEntity);
        HttpResponse httpResponse = this.sendHttpsBase(httpPatch);
        return httpResponse;
    }

    public HttpResponse sendHttpsPatchContent(String httpUrl, String contentStr, String contentType) {
        return this.sendHttpsPatchContent(httpUrl, (Map) null, contentStr, contentType);
    }

    public HttpResponse sendHttpsPatchContent(String httpUrl, String contentStr) {
        return this.sendHttpsPatchContent(httpUrl, (Map) null, contentStr, (String) null);
    }

    public HttpResponse sendHttpsPatchJson(String httpUrl, Map<String, String> headers, String contentJsonStr) {
        String jsonCcontentType = ContentType.APPLICATION_JSON.getMimeType();
        return this.sendHttpsPatchContent(httpUrl, headers, contentJsonStr, jsonCcontentType);
    }

    public HttpResponse sendHttpsPatchJson(String httpUrl, String contentJsonStr) {
        return this.sendHttpsPatchJson(httpUrl, (Map) null, contentJsonStr);
    }

    public HttpResponse sendHttpsPatchKeyValue(String httpUrl, Map<String, String> headers, Map<String, String> params) {
        HttpPatch httpPatch = new HttpPatch(httpUrl);
        this.ceateHeader(httpPatch, headers);
        UrlEncodedFormEntity urlEncodedFormEntity = null;

        try {
            urlEncodedFormEntity = this.createUrlEncodedFormEntity(params);
            httpPatch.setEntity(urlEncodedFormEntity);
        } catch (UnsupportedEncodingException var7) {
            var7.printStackTrace();
        }

        HttpResponse httpResponse = this.sendHttpsBase(httpPatch);
        return httpResponse;
    }

    public HttpResponse sendHttpsPatchKeyValue(String httpUrl, Map<String, String> params) {
        return this.sendHttpsPatchKeyValue(httpUrl, (Map) null, params);
    }

    public HttpResponse sendHttpPsatch(String httpUrl) {
        return this.sendHttpsPatchKeyValue(httpUrl, (Map) null);
    }

    public HttpResponse sendHttpsDeleteKeyValue(String httpUrl, Map<String, String> headers, Map<String, String> params) {
        String newHttpUrl = this.createUrlForParams(httpUrl, params);
        HttpDelete httpDelete = new HttpDelete(newHttpUrl);
        this.ceateHeader(httpDelete, headers);
        HttpResponse httpResponse = this.sendHttpsBase(httpDelete);
        return httpResponse;
    }

    public HttpResponse sendHttpsDeleteKeyValue(String httpUrl, Map<String, String> params) {
        HttpResponse httpResponse = this.sendHttpsDeleteKeyValue(httpUrl, (Map) null, params);
        return httpResponse;
    }

    public HttpResponse sendHttpsDelete(String httpUrl) {
        return this.sendHttpsDeleteKeyValue(httpUrl, (Map) null);
    }

    public HttpResponse sendHttpsGetKeyValue(String httpUrl, Map<String, String> headers, Map<String, String> params) {
        String newHttpUrl = this.createUrlForParams(httpUrl, params);
        HttpGet httpGet = new HttpGet(newHttpUrl);
        this.ceateHeader(httpGet, headers);
        HttpResponse httpResponse = this.sendHttpsBase(httpGet);
        return httpResponse;
    }

    public HttpResponse sendHttpsGetKeyValue(String httpUrl, Map<String, String> params) {
        return this.sendHttpsGetKeyValue(httpUrl, (Map) null, params);
    }

    public HttpResponse sendHttpsGet(String httpUrl) {
        return this.sendHttpsGetKeyValue(httpUrl, (Map) null);
    }
}