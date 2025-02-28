package org.dddashhh.story.entities;

import org.dddashhh.story.characteristics.Color;

public class Pebble {
    private Color color;
    private boolean isPrecious;

    public Pebble(Color color, boolean isPrecious) {
        this.color = color;
        this.isPrecious = isPrecious;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isPrecious() {
        return isPrecious;
    }

    public void setPrecious(boolean precious) {
        isPrecious = precious;
    }
}