package org.kimfri.di.moretests;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.doit();
    }

    private void doit() {
        Injector injector = Guice.createInjector(new BaseModule());
        MyWorker myWorker = injector.getInstance(MyWorker.class);

        myWorker.parse();
        final List<List<List<MyData>>> myDatas = myWorker.getMyDatas();
        System.err.println("amount; " + myDatas.size());
        myDatas.forEach(it -> {

        });
    }

    private class BaseModule extends AbstractModule {
        @Override
        protected void configure() {
//            binder.bind(new TypeLiteral<List<MultiValue>>(){})
//                    .toProvider(new Provider<List<MultiValue>>() {
//            bind(TypeLiteral<List<MyData>>(){}).
        }
    }
}
