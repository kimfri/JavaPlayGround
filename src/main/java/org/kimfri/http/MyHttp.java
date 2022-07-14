package org.kimfri.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttp {

    private final Logger logger = LoggerFactory.getLogger(MyHttp.class);
    private final HttpClient httpClient = HttpClient.newHttpClient();

    void getGetHttp(String uri) {
        try {
            final HttpRequest getHttpRequest = getGetHttpRequest(uri);
            final HttpResponse<String> stringHttpResponse = sendRequest(getHttpRequest);
            parseResponse(stringHttpResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseResponse(HttpResponse<String> stringHttpResponse) {
        if (stringHttpResponse.statusCode() != 200) {
            logger.info("Statuscode: {}", stringHttpResponse.statusCode());
        }
        logger.info("{}", stringHttpResponse.body());
    }

    HttpResponse<String> sendRequest(HttpRequest httpRequest)
            throws IOException, InterruptedException {
        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    HttpRequest getGetHttpRequest(String uri) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(uri))
                .GET()
                .build();
    }
}
