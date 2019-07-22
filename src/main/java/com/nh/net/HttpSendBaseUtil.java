package com.nh.net;

import com.nh.file.FileUtil;
import com.nh.file.IOUtil;
import com.nh.net.bean.HttpResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Classname HttpSendBaseUtil
 * @Description TODO
 * @Date 2019/7/22 5:09 PM
 * @Created by nihui
 */
public class HttpSendBaseUtil {
    private CloseableHttpClient closeableHttpClient;

    public HttpSendBaseUtil(CloseableHttpClient closeableHttpClient) {
        this.closeableHttpClient = closeableHttpClient;
    }

    protected HttpPost createUploadHttpPost(String httpUrl, File file, Map<String, String> headers, Map<String, String> textParams) {
        HttpPost httpPost = new HttpPost(httpUrl);
        this.ceateHeader(httpPost, headers);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", file);
        if (textParams != null) {
            Iterator var7 = textParams.keySet().iterator();

            while(var7.hasNext()) {
                String key = (String)var7.next();
                builder.addTextBody(key, (String)textParams.get(key));
            }
        }

        HttpEntity httpEntity = builder.build();
        httpPost.setEntity(httpEntity);
        return httpPost;
    }

    protected File download(HttpRequestBase httpRequestBase, String fileFullName, boolean overwrite) {
        int status = 0;
        File file = null;

        try {
            CloseableHttpResponse closeableHttpResponse = this.closeableHttpClient.execute(httpRequestBase);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            status = closeableHttpResponse.getStatusLine().getStatusCode();
            if (status == 200) {
                InputStream inputStream = httpEntity.getContent();
                if (inputStream != null) {
                    try {
                        file = FileUtil.getFileHisOrCreate(fileFullName, true, overwrite);
                        boolean result = IOUtil.inputStreamToFile(inputStream, file, true);
                        if (result) {
                            return file;
                        }

                        if (file != null) {
                            file.deleteOnExit();
                        }

                        return null;
                    } catch (IOException var10) {
                        var10.printStackTrace();
                        if (file != null) {
                            file.deleteOnExit();
                        }
                    }
                }
            }
        } catch (ClientProtocolException var11) {
            var11.printStackTrace();
        } catch (IOException var12) {
            var12.printStackTrace();
        }

        return null;
    }

    protected StringEntity createBodyStringEntity(String contentStr, String contentType) {
        if (StringUtils.isBlank(contentStr)) {
            contentStr = "";
        }

        StringEntity stringEntity = new StringEntity(contentStr, "UTF-8");
        if (contentType == null) {
            stringEntity.setContentType(ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
        } else {
            stringEntity.setContentType(contentType);
        }

        return stringEntity;
    }

    protected UrlEncodedFormEntity createUrlEncodedFormEntity(Map<String, String> params) throws UnsupportedEncodingException {
        List<NameValuePair> nameValuePairs = new ArrayList();
        if (params != null) {
            Iterator var3 = params.keySet().iterator();

            while(var3.hasNext()) {
                String key = (String)var3.next();
                nameValuePairs.add(new BasicNameValuePair(key, (String)params.get(key)));
            }
        }

        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
        urlEncodedFormEntity.setContentType(ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
        return urlEncodedFormEntity;
    }

    protected String createUrlForParams(String httpUrl, Map<String, String> params) {
        if (params != null) {
            UrlEncodedFormEntity urlEncodedFormEntity = null;
            String paramsStr = null;

            try {
                urlEncodedFormEntity = this.createUrlEncodedFormEntity(params);
                paramsStr = EntityUtils.toString(urlEncodedFormEntity);
            } catch (IOException | ParseException var6) {
                var6.printStackTrace();
            }

            if (httpUrl.indexOf("?") < 0) {
                httpUrl = httpUrl + "?" + paramsStr;
            } else {
                httpUrl = httpUrl + "&" + paramsStr;
            }
        }

        return httpUrl;
    }

    protected void ceateHeader(HttpRequestBase requestBase, Map<String, String> headers) {
        if (headers != null) {
            Iterator var3 = headers.keySet().iterator();

            while(var3.hasNext()) {
                String key = (String)var3.next();
                requestBase.addHeader(key, (String)headers.get(key));
            }
        }

    }

    protected HttpResponse sendHttps(SSLConnectionSocketFactory sslConnectionSocketFactory, HttpRequestBase httpRequestBase) {
        int status = 0;
        String responseContent = null;
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        if (sslConnectionSocketFactory != null) {
            httpClientBuilder.setSSLSocketFactory(sslConnectionSocketFactory);
        }

        try {
            CloseableHttpResponse closeableHttpResponse = this.closeableHttpClient.execute(httpRequestBase);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            responseContent = EntityUtils.toString(httpEntity, "UTF-8");
            status = closeableHttpResponse.getStatusLine().getStatusCode();
        } catch (ClientProtocolException var8) {
            var8.printStackTrace();
        } catch (IOException var9) {
            var9.printStackTrace();
        }

        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setStatus(status);
        httpResponse.setContent(responseContent);
        return httpResponse;
    }

    protected HttpResponse sendHttp(HttpRequestBase httpRequestBase) {
        HttpResponse httpResponse = this.sendHttps((SSLConnectionSocketFactory)null, httpRequestBase);
        return httpResponse;
    }

    public static String toUrlParam(List<Map.Entry<String, Object>> list) {
        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i < list.size(); ++i) {
            Map.Entry<String, Object> entry = (Map.Entry)list.get(i);
            if (i == 0) {
                stringBuffer.append((String)entry.getKey() + "=" + entry.getValue());
            } else {
                stringBuffer.append("&" + (String)entry.getKey() + "=" + entry.getValue());
            }
        }

        return stringBuffer.toString();
    }

    public static String toUrlParam(Map<String, Object> map) {
        List<Map.Entry<String, Object>> list = new ArrayList(map.entrySet());
        return toUrlParam((List)list);
    }

    public static String addUrlParam(String url, Map<String, Object> map) {
        List<Map.Entry<String, Object>> list = new ArrayList(map.entrySet());
        String param = toUrlParam((List)list);
        if (!url.contains("?") && !url.contains("&")) {
            if (!url.contains("?") && StringUtils.isNotBlank(param)) {
                url = url + "?";
            }
        } else {
            url = url + "&";
        }

        url = url + param;
        return url;
    }
}
