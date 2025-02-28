package org.dddashhh.story.entities;

import org.dddashhh.story.characteristics.Color;
import org.dddashhh.story.characteristics.Material;

public class Sunshade {
    private Color color;
    private boolean hasFringes;
    private Material fringesMaterial;

    public Sunshade(Color color, boolean hasFringes, Material fringesMaterial) {
        this.color = color;
        this.hasFringes = hasFringes;
        this.fringesMaterial = fringesMaterial;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean hasFringes() {
        return hasFringes;
    }

    public void setHasFringes(boolean hasFringes) {
        this.hasFringes = hasFringes;
    }

    public Material getFringesMaterial() {
        return fringesMaterial;
    }

    public void setFringesMaterial(Material fringesMaterial) {
        this.fringesMaterial = fringesMaterial;
    }
}