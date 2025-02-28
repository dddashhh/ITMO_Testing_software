package org.dddashhh.story.entities;

import org.dddashhh.story.characteristics.Material;

public class Table {
    private Material material;

    public Table(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}