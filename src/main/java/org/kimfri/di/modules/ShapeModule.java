package org.kimfri.di.modules;

import com.google.inject.AbstractModule;
import org.kimfri.di.api.Shape;
import org.kimfri.di.impl.Square;

public class ShapeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Shape.class).to(Square.class);
    }
}
