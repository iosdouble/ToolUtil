package com.nh.net;

import com.nh.net.bean.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Classname HttpSendUtil
 * @Description TODO
 * @Date 2019/7/22 5:09 PM
 * @Created by nihui
 */
public class HttpSendUtil extends HttpSendBaseUtil {
    public HttpSendUtil(CloseableHttpClient closeableHttpClient) {
        super(closeableHttpClient);
    }

    public File download(String httpUrl, String fileFullName, boolean overwrite) {
        HttpGet httpGet = new HttpGet(httpUrl);
        return this.download((HttpRequestBase)httpGet, (String)fileFullName, overwrite);
    }

    public File download(String httpUrl, File file, boolean overwrite) {
        HttpGet httpGet = new HttpGet(httpUrl);
        return this.download((HttpRequestBase)httpGet, (String)file.getPath(), overwrite);
    }

    public HttpResponse upload(String httpUrl, File file, Map<String, String> headers, Map<String, String> textParams) {
        HttpPost httpPost = this.createUploadHttpPost(httpUrl, file, headers, textParams);
        HttpResponse httpResponse = this.sendHttp(httpPost);
        return httpResponse;
    }

    public HttpResponse sendHttpPostContent(String httpUrl, Map<String, String> headers, String contentStr, String contentType) {
        HttpPost httpPost = new HttpPost(httpUrl);
        this.ceateHeader(httpPost, headers);
        StringEntity stringEntity = this.createBodyStringEntity(contentStr, contentType);
        httpPost.setEntity(stringEntity);
        HttpResponse httpResponse = this.sendHttp(httpPost);
        return httpResponse;
    }

    public HttpResponse sendHttpPostContent(String httpUrl, String contentStr, String contentType) {
        return this.sendHttpPostContent(httpUrl, (Map)null, contentStr, contentType);
    }

    public HttpResponse sendHttpPostContent(String httpUrl, String contentStr) {
        return this.sendHttpPostContent(httpUrl, (Map)null, contentStr, (String)null);
    }

    public HttpResponse sendHttpPostJson(String httpUrl, Map<String, String> headers, String contentJsonStr) {
        String jsonCcontentType = ContentType.APPLICATION_JSON.getMimeType();
        return this.sendHttpPostContent(httpUrl, headers, contentJsonStr, jsonCcontentType);
    }

    public HttpResponse sendHttpPostJson(String httpUrl, String contentJsonStr) {
        return this.sendHttpPostJson(httpUrl, (Map)null, contentJsonStr);
    }

    public HttpResponse sendHttpPostKeyValue(String httpUrl, Map<String, String> headers, Map<String, String> params) {
        HttpPost httpPost = new HttpPost(httpUrl);
        this.ceateHeader(httpPost, headers);
        UrlEncodedFormEntity urlEncodedFormEntity = null;

        try {
            urlEncodedFormEntity = this.createUrlEncodedFormEntity(params);
            httpPost.setEntity(urlEncodedFormEntity);
        } catch (UnsupportedEncodingException var7) {
            var7.printStackTrace();
        }

        HttpResponse httpResponse = this.sendHttp(httpPost);
        return httpResponse;
    }

    public HttpResponse sendHttpPostKeyValue(String httpUrl, Map<String, String> params) {
        return this.sendHttpPostKeyValue(httpUrl, (Map)null, params);
    }

    public HttpResponse sendHttpPost(String httpUrl) {
        return this.sendHttpPostKeyValue(httpUrl, (Map)null);
    }

    public HttpResponse sendHttpPutContent(String httpUrl, Map<String, String> headers, String contentStr, String contentType) {
        HttpPut httpPut = new HttpPut(httpUrl);
        this.ceateHeader(httpPut, headers);
        StringEntity stringEntity = this.createBodyStringEntity(contentStr, contentType);
        httpPut.setEntity(stringEntity);
        HttpResponse httpResponse = this.sendHttp(httpPut);
        return httpResponse;
    }

    public HttpResponse sendHttpPutContent(String httpUrl, String contentStr, String contentType) {
        return this.sendHttpPutContent(httpUrl, (Map)null, contentStr, contentType);
    }

    public HttpResponse sendHttpPutContent(String httpUrl, String contentStr) {
        return this.sendHttpPutContent(httpUrl, (Map)null, contentStr, (String)null);
    }

    public HttpResponse sendHttpPutJson(String httpUrl, Map<String, String> headers, String contentJsonStr) {
        String jsonCcontentType = ContentType.APPLICATION_JSON.getMimeType();
        return this.sendHttpPutContent(httpUrl, headers, contentJsonStr, jsonCcontentType);
    }

    public HttpResponse sendHttpPutJson(String httpUrl, String contentJsonStr) {
        return this.sendHttpPutJson(httpUrl, (Map)null, contentJsonStr);
    }

    public HttpResponse sendHttpPutKeyValue(String httpUrl, Map<String, String> headers, Map<String, String> params) {
        HttpPut httpPut = new HttpPut(httpUrl);
        this.ceateHeader(httpPut, headers);
        UrlEncodedFormEntity urlEncodedFormEntity = null;

        try {
            urlEncodedFormEntity = this.createUrlEncodedFormEntity(params);
            httpPut.setEntity(urlEncodedFormEntity);
        } catch (UnsupportedEncodingException var7) {
            var7.printStackTrace();
        }

        HttpResponse httpResponse = this.sendHttp(httpPut);
        return httpResponse;
    }

    public HttpResponse sendHttpPutKeyValue(String httpUrl, Map<String, String> params) {
        return this.sendHttpPutKeyValue(httpUrl, (Map)null, params);
    }

    public HttpResponse sendHttpPut(String httpUrl) {
        return this.sendHttpPutKeyValue(httpUrl, (Map)null);
    }

    public HttpResponse sendHttpPatchContent(String httpUrl, Map<String, String> headers, String contentStr, String contentType) {
        HttpPatch httpPatch = new HttpPatch(httpUrl);
        this.ceateHeader(httpPatch, headers);
        StringEntity stringEntity = this.createBodyStringEntity(contentStr, contentType);
        httpPatch.setEntity(stringEntity);
        HttpResponse httpResponse = this.sendHttp(httpPatch);
        return httpResponse;
    }

    public HttpResponse sendHttpPatchContent(String httpUrl, String contentStr, String contentType) {
        return this.sendHttpPatchContent(httpUrl, (Map)null, contentStr, contentType);
    }

    public HttpResponse sendHttpPatchContent(String httpUrl, String contentStr) {
        return this.sendHttpPatchContent(httpUrl, (Map)null, contentStr, (String)null);
    }

    public HttpResponse sendHttpPatchJson(String httpUrl, Map<String, String> headers, String contentJsonStr) {
        String jsonCcontentType = ContentType.APPLICATION_JSON.getMimeType();
        return this.sendHttpPatchContent(httpUrl, headers, contentJsonStr, jsonCcontentType);
    }

    public HttpResponse sendHttpPatchJson(String httpUrl, String contentJsonStr) {
        return this.sendHttpPatchJson(httpUrl, (Map)null, contentJsonStr);
    }

    public HttpResponse sendHttpPatchKeyValue(String httpUrl, Map<String, String> headers, Map<String, String> params) {
        HttpPatch httpPatch = new HttpPatch(httpUrl);
        this.ceateHeader(httpPatch, headers);
        UrlEncodedFormEntity urlEncodedFormEntity = null;

        try {
            urlEncodedFormEntity = this.createUrlEncodedFormEntity(params);
            httpPatch.setEntity(urlEncodedFormEntity);
        } catch (UnsupportedEncodingException var7) {
            var7.printStackTrace();
        }

        HttpResponse httpResponse = this.sendHttp(httpPatch);
        return httpResponse;
    }

    public HttpResponse sendHttpPatchKeyValue(String httpUrl, Map<String, String> params) {
        return this.sendHttpPatchKeyValue(httpUrl, (Map)null, params);
    }

    public HttpResponse sendHttpPatch(String httpUrl) {
        return this.sendHttpPatchKeyValue(httpUrl, (Map)null);
    }

    public HttpResponse sendHttpDeleteKeyValue(String httpUrl, Map<String, String> headers, Map<String, String> params) {
        String newHttpUrl = this.createUrlForParams(httpUrl, params);
        HttpDelete httpDelete = new HttpDelete(newHttpUrl);
        this.ceateHeader(httpDelete, headers);
        HttpResponse httpResponse = this.sendHttp(httpDelete);
        return httpResponse;
    }

    public HttpResponse sendHttpDeleteKeyValue(String httpUrl, Map<String, String> params) {
        HttpResponse httpResponse = this.sendHttpDeleteKeyValue(httpUrl, (Map)null, params);
        return httpResponse;
    }

    public HttpResponse sendHttpDelete(String httpUrl) {
        return this.sendHttpDeleteKeyValue(httpUrl, (Map)null);
    }

    public HttpResponse sendHttpGetKeyValue(String httpUrl, Map<String, String> headers, Map<String, String> params) {
        String newHttpUrl = this.createUrlForParams(httpUrl, params);
        HttpGet httpGet = new HttpGet(newHttpUrl);
        this.ceateHeader(httpGet, headers);
        HttpResponse httpResponse = this.sendHttp(httpGet);
        return httpResponse;
    }

    public HttpResponse sendHttpGetKeyValue(String httpUrl, Map<String, String> params) {
        return this.sendHttpGetKeyValue(httpUrl, (Map)null, params);
    }

    public HttpResponse sendHttpGet(String httpUrl) {
        return this.sendHttpGetKeyValue(httpUrl, (Map)null);
    }
}
