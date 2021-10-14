package org.kimfri.di;

import com.google.inject.Inject;
import org.kimfri.di.api.Shape;

public class Drawer {

    private final Shape shape;

    @Inject
    public Drawer(Shape shape) {
        this.shape = shape;
    }

    public void print() {
        System.err.println("inside Drawer");
        shape.drawShape();
    }
}
