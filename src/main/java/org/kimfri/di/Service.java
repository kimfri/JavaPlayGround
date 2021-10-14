package org.kimfri.di;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Service {
    public static void main(String[] args) {
        Service service = new Service();
        service.doit();
    }

    private void doit() {
        Injector injector = Guice.createInjector();
         Drawer drawer = injector.getInstance(Drawer.class);
         drawer.print();
    }
}
