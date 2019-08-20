package com.nh.code.util.net;

import com.nh.code.util.net.bean.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @Classname HttpsSendBaseUtil
 * @Description TODO
 * @Date 2019/7/22 5:10 PM
 * @Created by nihui
 */
public class HttpsSendBaseUtil extends HttpSendBaseUtil {
    public HttpsSendBaseUtil(CloseableHttpClient closeableHttpClient) {
        super(closeableHttpClient);
    }

    protected HostnameVerifier getHostnameVerifier4AllAllow() {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        return hostnameVerifier;
    }

    protected HostnameVerifier getHostnameVerifier4Default() {
        HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.getDefaultHostnameVerifier();
        return hostnameVerifier;
    }

    protected HostnameVerifier getHostnameVerifier4Uri(final String uri) {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                HostnameVerifier hostnameVerifier = HttpsSendBaseUtil.this.getHostnameVerifier4Default();
                boolean result = hostnameVerifier.verify(uri, session);
                return result;
            }
        };
        return hostnameVerifier;
    }

    protected TrustStrategy getTrustStrategy4AllAllow() {
        TrustStrategy trustStrategy = new TrustStrategy() {
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        };
        return trustStrategy;
    }

    protected TrustStrategy getTrustStrategy4SelfSigned() {
        TrustStrategy trustStrategy = new TrustSelfSignedStrategy();
        return trustStrategy;
    }

    protected TrustStrategy getTrustStrategy4Default() {
        return this.getTrustStrategy4SelfSigned();
    }

    protected HttpResponse sendHttps(SSLContext sslContext, String[] supportedProtocols, String[] supportedCipherSuites, HostnameVerifier hostnameVerifier, HttpRequestBase httpRequestBase) {
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, supportedProtocols, supportedCipherSuites, hostnameVerifier);
        HttpResponse httpResponse = this.sendHttps(sslConnectionSocketFactory, httpRequestBase);
        return httpResponse;
    }

    protected HttpResponse sendHttps(KeyStore keyStore, TrustStrategy trustStrategy, String[] supportedProtocols, String[] supportedCipherSuites, HostnameVerifier hostnameVerifier, HttpRequestBase httpRequestBase) {
        SSLContext sslContext = null;

        try {
            if (keyStore != null) {
                sslContext = SSLContexts.custom().loadTrustMaterial(keyStore, trustStrategy).build();
            } else {
                sslContext = SSLContexts.custom().loadTrustMaterial(trustStrategy).build();
            }
        } catch (KeyManagementException var9) {
            var9.printStackTrace();
        } catch (NoSuchAlgorithmException var10) {
            var10.printStackTrace();
        } catch (KeyStoreException var11) {
            var11.printStackTrace();
        }

        HttpResponse httpResponse = this.sendHttps(sslContext, supportedProtocols, supportedCipherSuites, hostnameVerifier, httpRequestBase);
        return httpResponse;
    }

    protected HttpResponse sendHttps(String keyStoreType, File keyStoreFile, String keyStorePassword, TrustStrategy trustStrategy, String[] supportedProtocols, String[] supportedCipherSuites, HostnameVerifier hostnameVerifier, HttpRequestBase httpRequestBase) {
        KeyStore keyStore = null;
        if (keyStoreType != null && keyStoreFile != null && keyStorePassword != null) {
            try {
                keyStore = KeyStore.getInstance(keyStoreType);
                FileInputStream fileInputStream = new FileInputStream(keyStoreFile);
                keyStore.load(fileInputStream, keyStorePassword.toCharArray());
            } catch (Exception var11) {
                var11.printStackTrace();
            }
        }

        HttpResponse httpResponse = this.sendHttps(keyStore, trustStrategy, supportedProtocols, supportedCipherSuites, hostnameVerifier, httpRequestBase);
        return httpResponse;
    }

    protected HttpResponse sendHttpsBase(String keyStoreFilePath, String keyStorePassword, HttpRequestBase httpRequestBase) {
        String keyStoreType = null;
        File keyStoreFile = null;
        if (keyStoreFilePath != null) {
            keyStoreType = KeyStore.getDefaultType();
            keyStoreFile = new File(keyStoreFilePath);
        }

        TrustStrategy trustStrategy = this.getTrustStrategy4Default();
        String[] supportedProtocols = new String[]{"TLSv1"};
        String[] supportedCipherSuites = null;
        HostnameVerifier hostnameVerifier = this.getHostnameVerifier4Default();
        HttpResponse httpResponse = this.sendHttps(keyStoreType, keyStoreFile, keyStorePassword, trustStrategy, supportedProtocols, (String[])supportedCipherSuites, hostnameVerifier, httpRequestBase);
        return httpResponse;
    }

    protected HttpResponse sendHttpsBase(HttpRequestBase httpRequestBase) {
        String keyStoreFilePath = null;
        String keyStorePassword = null;
        String keyStoreType = KeyStore.getDefaultType();
        File keyStoreFile = new File((String)keyStoreFilePath);
        TrustStrategy trustStrategy = this.getTrustStrategy4Default();
        String[] supportedProtocols = new String[]{"TLSv1"};
        String[] supportedCipherSuites = null;
        HostnameVerifier hostnameVerifier = this.getHostnameVerifier4Default();
        HttpResponse httpResponse = this.sendHttps(keyStoreType, keyStoreFile, (String)keyStorePassword, trustStrategy, supportedProtocols, (String[])supportedCipherSuites, hostnameVerifier, httpRequestBase);
        return httpResponse;
    }
}
