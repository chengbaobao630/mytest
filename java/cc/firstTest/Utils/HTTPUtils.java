package cc.firstTest.Utils;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2016/3/11 0011.
 */
public class HTTPUtils {
        private static HttpPost httppost;
        private static HttpGet httpGet;
        private static JSONObject result;

        public static JSONObject invokeGet(String url) {
            httpGet = new HttpGet(url);
            return send(url);
        }

        public static JSONObject invokePost(String url,Map<String, String> map) {
            httppost = new HttpPost(url);
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            for (String key : map.keySet()) {
                formparams.add(new BasicNameValuePair(key, map.get(key)));
            }
            UrlEncodedFormEntity uefEntity;
            try {
                uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex.getMessage(), ex);
            }
            httppost.setEntity(uefEntity);
            return send(url);
        }

        private static JSONObject send(String url) {

            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

            HttpResponse response = null;
            try {
                HttpClient httpClient = httpClientBuilder.build();
                if (StringUtils.startsWith(url, "https")) {
                    SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                        //信任所有
                        public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                            return true;
                        }
                    }).build();
                    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
                    httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
                }

                response = httpClient.execute(httpGet != null ? httpGet : httppost);
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage(), ex);
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try {
                    result = JSONObject.fromObject(EntityUtils.toString(entity, "UTF-8"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex.getMessage(), ex);
                }
                return result;
            }
            return result;
        }

        public JSONObject getResult() {
            return result;
        }

        public void setResult(JSONObject result) {
            this.result = result;
        }


}
