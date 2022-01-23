package com.design.pattern.function;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorPattern {

    public static void main(String[] args) {
        DecoratorPattern.takeSnap(new Camera(Color::brighter, Color::darker, Color::brighter));

    }

    public static void takeSnap(Camera camera) {
        System.out.println(camera.getColor(new Color(125, 125, 125)));
    }


}

class Camera {
    private Function<Color, Color> filters;

    public Camera(Function<Color, Color>... filter) {
        setFilter(filter);
    }

    private void setFilter(Function<Color, Color>... filter) {
        filters = Stream.of(filter)
                .reduce(Function.identity(), Function::andThen);
    }

    public Color getColor(Color color) {
        return filters.apply(color);
    }


}
