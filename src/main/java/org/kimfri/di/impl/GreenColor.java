package org.kimfri.di.impl;

import org.kimfri.di.api.ShapeColor;

import java.awt.*;

public class GreenColor implements ShapeColor {

    private Color color;
    public GreenColor() {
    }

    @Override
    public String printColor() {
        if(color == null) {
            return "No Color";
        } else {
            return "Color: " + color.getRGB();
        }
    }
}
