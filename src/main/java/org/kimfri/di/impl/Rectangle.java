package org.kimfri.di.impl;

import org.kimfri.di.api.Shape;

public class Rectangle implements Shape {

    @Override
    public void drawShape() {
        System.out.println("Inside Rectangle-drawshape");
    }
}
