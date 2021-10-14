package org.kimfri.di;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.kimfri.di.api.Shape;
import org.kimfri.di.api.ShapeColor;
import org.kimfri.di.impl.GreenColor;
import org.kimfri.di.impl.Rectangle;
import org.kimfri.di.impl.Square;

public class Service {
    public static void main(String[] args) {
        Service service = new Service();
        service.doit();
    }

    private void doit() {
//        Injector injector = Guice.createInjector(new ShapeModule());
        Injector injector = Guice.createInjector( new AbstractModule() {
            @Override
            protected void configure() {
//                bind(Shape.class).to(Rectangle.class);
                bind(Shape.class).to(Square.class);
                bind(ShapeColor.class).to(GreenColor.class);
            }
        });
         Drawer drawer = injector.getInstance(Drawer.class);
         drawer.print();
    }
}
