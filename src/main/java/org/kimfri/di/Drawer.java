package org.kimfri.di;

import com.google.inject.Inject;
import org.kimfri.di.api.Shape;
import org.slf4j.Logger;

public class Drawer {

    private final Shape shape;
    @Inject
    private Logger logger;

    @Inject
    public Drawer(Shape shape) {
        this.shape = shape;
    }

    public void print() {
        System.err.println("inside Drawer");
        logger.debug("inside Drawer from a logger");
        shape.drawShape();
    }
}
