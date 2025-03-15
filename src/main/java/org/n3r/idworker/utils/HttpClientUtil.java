package org.n3r.idworker.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientUtil {

    /**
     * postFromUrlEncoded 传参为map
     *
     * @param url
     * @param paramMap
     * @return
     * @throws IOException
     */
    public String postFromUrlEncodedHeaders(String url, Map<String, String> paramMap, Map<String, String> headers) throws URISyntaxException, IOException {

        URI uri = new URIBuilder(url).setParameters(generateParams(paramMap)).build();

        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).setConnectTimeout(1000).setSocketTimeout(4000).build();
        HttpUriRequest request = RequestBuilder.post().setUri(uri).setConfig(requestConfig).build();
        for(String key : headers.keySet()) {
            request.setHeader(key, headers.get(key));
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(request);
        String getResp = EntityUtils.toString(response.getEntity(), "UTF-8");

        System.out.println("响应内容："+getResp);

        return getResp;
    }

    /**
     * get请求带header
     * @param url
     * @param params
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public String getSetHeaders(String url, Map<String,String> params, Header[] headers) throws URISyntaxException, IOException {
        URIBuilder uriBuilder = new URIBuilder(url);

        List<NameValuePair> nvps = new ArrayList<>();
        Set<String> keySet = params.keySet();
        for(String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }

        uriBuilder.setParameters(nvps);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeaders(headers);
        // 传输的类型
        System.out.println("请求链接:"+httpGet.getURI());

        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        response.close();
        httpclient.close();
        System.out.println("响应内容："+result);
        return result;
    }

    private List<NameValuePair> generateParams(Map<String,String> inParams){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if(inParams==null)
            return params;

        for(Map.Entry<String,String> entry : inParams.entrySet()){
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return params;
    }
}
