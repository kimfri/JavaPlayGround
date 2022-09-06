package org.kimfri.prometheus;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.PushGateway;

import java.io.IOException;
import java.util.Random;

public class PrometheusRemote {
    private final CollectorRegistry registry;

    private final Counter counter;
//    private static final String URL = "172.20.10.3:9091";
    private static final String URL = "192.168.1.98:9091";

    public PrometheusRemote() {
        registry = new CollectorRegistry();
        counter = Counter
                .build()
                .labelNames("type")
                .name("total_records")
                .help("Counter for total_records")
                .namespace("kimfri")
                .register(registry);
    }

    public static void main(String[] args) {
        PrometheusRemote pr = new PrometheusRemote();
        try {
//            pr.doitCounter();
//            pr.doitGauge();
            pr.doitGaugeRandom();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doitCounter() throws IOException, InterruptedException {

        for (int i = 0; i < 100; i++) {
            counter.labels("odd").inc();
            counter.labels("even").inc(2);
            PushGateway pg = new PushGateway(URL);
            pg.pushAdd(registry, "total_records");
            Thread.sleep(1000);
        }
    }

    private void doitGauge() throws IOException, InterruptedException {
        CollectorRegistry gaugeRegistry = new CollectorRegistry();
        final Gauge gauge = Gauge
                .build()
                .labelNames("type")
                .name("frequency")
                .help("Some frequency curve")
                .namespace("kimfri")
                .register(gaugeRegistry);

        for (int i = 0; i < 10; i++) {
            PushGateway pg = new PushGateway(URL);
            if (i % 2 == 0) {
                gauge.labels("odd").inc();
                gauge.labels("even").dec();
            } else {
                gauge.labels("odd").dec();
                gauge.labels("even").inc();
            }
            System.err.println("value: odd : " + gauge.labels("odd").get());
            System.err.println("value: even: " + gauge.labels("even").get());
            pg.pushAdd(gaugeRegistry, "frequency");
            Thread.sleep(60 * 1000);
        }
    }

    private void doitGaugeRandom() throws InterruptedException, IOException {
        final CollectorRegistry gaugeRegistry = new CollectorRegistry();
        final PushGateway pg = new PushGateway(URL);

        final Gauge gauge = Gauge
                .build()
                .labelNames("type")
                .name("my_stats")
                .help("Some statistics curve")
                .namespace("kimfri")
                .register(gaugeRegistry);

        final Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 900; i++) {

            gauge.labels("my_happenings").set(random.nextDouble(0, 20));
            gauge.labels("my_happenings_cars").set(random.nextDouble(20, 40));
            gauge.labels("my_happenings_bicycles").set(random.nextDouble(40, 60));
            gauge.labels("my_happenings_trains").set(random.nextDouble(60, 80));
            gauge.labels("my_happenings_planes").set(random.nextDouble(80, 100));
            gauge.labels("my_happenings_ferries").set(random.nextDouble(0, 100));
            pg.pushAdd(gaugeRegistry, "happenings");
            Thread.sleep(1000);
        }
    }
}
