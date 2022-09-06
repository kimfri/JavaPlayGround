package org.kimfri.prometheus;

import java.io.IOException;

public class PrometheusMain {
    public static void main(String[] args) throws InterruptedException {
        PrometheusMain prometheusMain = new PrometheusMain();
        prometheusMain.doit();
    }

    private void doit() throws InterruptedException {
        PrometheusUtil prometheusUtil = new PrometheusUtil();
        try {
            prometheusUtil.setUp();
        } catch (IOException e) {
            System.err.println("Error when setting up server");
        }
        for (int i = 0; i < 100; i++) {
//            prometheusUtil.updateValue();
//            prometheusUtil.updateGetValue();
            if(i % 2 == 0) {
                prometheusUtil.updatePutValue("Even", 1);
            } else {
                prometheusUtil.updatePutValue("Odd", 1);
            }
            Thread.sleep(500);
        }
        prometheusUtil.tearDown();
        System.err.println("Will end program...");
    }
}
