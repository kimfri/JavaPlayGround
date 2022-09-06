package org.kimfri.prometheus;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.HTTPServer;

import java.io.IOException;

public class PrometheusUtil {

    private Counter counter;
    private HTTPServer httpServer;
    public PrometheusUtil() {
        counter = Counter.build()
                .name("total_requests")
                .labelNames("method", "even_odd")
                .help("Total requests")
                .register();
    }

    public void setUp() throws IOException {
        httpServer = new HTTPServer(4000);
    }

    public void tearDown() {
        httpServer.close();
    }

    public void updateValue() {
        counter.inc();
    }

    public void updateGetValue() {
        counter.labels("get").inc();
    }

    public void updatePutValue(String type, int value) {
        counter.labels("put", type).inc(value);
    }
}
