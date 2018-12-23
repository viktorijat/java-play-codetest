package steps.utilities;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class HttpRequest {

    private static final String JSON_CHARSET_UTF_8 = MediaType.APPLICATION_JSON + "; charset=UTF-8";
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequest.class);


    public static String post(String url, String data) throws IOException {

        HttpPost post = new HttpPost(url);
        post.setHeader(HttpHeader.CONTENT_TYPE.value(), JSON_CHARSET_UTF_8);
        post.setEntity(new StringEntity(data, StandardCharsets.UTF_8));
        HttpResponse response;
        try {
            response = getClient().execute(post);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to obtain response for url: " + url, e);
        }
        Integer statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            LOGGER.error("Response code for url: " + url + " was " + url);
            return null;
        }
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    private enum HttpHeader {
        CONTENT_TYPE("Content-type");
        String value;

        HttpHeader(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    private static HttpClient getClient() {
        return HttpClientBuilder.create().build();
    }
}