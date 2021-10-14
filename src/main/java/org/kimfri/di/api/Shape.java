package org.kimfri.di.api;

import com.google.inject.ImplementedBy;
import org.kimfri.di.impl.Square;

@ImplementedBy(Square.class)
public interface Shape {
    void drawShape();
}
