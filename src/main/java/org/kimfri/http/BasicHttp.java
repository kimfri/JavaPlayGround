package org.kimfri.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicHttp {
    private static final Logger logger = LoggerFactory.getLogger(BasicHttp.class);

    public static void main(String[] args) {
        final List<String> names = Arrays.asList("kim", "maria", "wille", "theo");
        doit(names);
    }

    private static void doit(List<String> names) {
        List<Exception> exceptions = new ArrayList<>();
        names.forEach(name -> {
            try {
                sendClientCall(name);
            } catch (Exception e) {
                exceptions.add(e);
            }
        });
        for (Exception exception : exceptions) {
            exception.printStackTrace();
        }
    }

    private static void sendClientCall(String name) throws
            URISyntaxException,
            IOException,
            InterruptedException {
        final String url = "https://api.agify.io?name=";
        final URI uri = new URI(url + name);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        final HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        logger.info("responseCode: {}", response.statusCode());
        logger.info(response.body());
    }
}
