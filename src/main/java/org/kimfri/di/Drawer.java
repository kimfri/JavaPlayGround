package org.kimfri.di;

import com.google.inject.Inject;
import org.kimfri.di.api.Shape;
import org.kimfri.di.api.ShapeColor;

import java.awt.*;
import java.util.logging.Logger;

public class Drawer {

    private final Shape shape;
    private final ShapeColor shapeColor;

    @Inject
    Logger logger;

    @Inject
    public Drawer(Shape shape, ShapeColor shapeColor) {
        this.shape = shape;
        this.shapeColor = shapeColor;
    }

    public void print() {
//        System.err.println("inside Drawer");
        logger.info("info message from java.util.logger");
        shape.drawShape();
        shapeColor.setColor(Color.GREEN);
        System.out.println("Color code: " + shapeColor.getColorCode());
    }
}
