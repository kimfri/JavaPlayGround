package org.kimfri.di.impl;

import org.kimfri.di.api.Shape;

public class Square implements Shape {
    @Override
    public void drawShape() {
        System.err.println("Inside Square-DrawShape");
    }
}
