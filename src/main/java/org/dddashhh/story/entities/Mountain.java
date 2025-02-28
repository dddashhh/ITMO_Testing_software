package org.dddashhh.story.entities;

import org.dddashhh.story.characteristics.Color;

public class Mountain {
    private Color peakColor;

    public Mountain(Color peakColor) {
        this.peakColor = peakColor;
    }

    public Color getPeakColor() {
        return peakColor;
    }

    public void setPeakColor(Color peakColor) {
        this.peakColor = peakColor;
    }
}