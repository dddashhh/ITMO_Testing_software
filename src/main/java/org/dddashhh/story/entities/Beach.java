package org.dddashhh.story.entities;

import java.util.List;

public class Beach {
    private List<Pebble> pebbles;

    public Beach(List<Pebble> pebbles) {
        this.pebbles = pebbles;
    }

    public List<Pebble> getPebbles() {
        return pebbles;
    }

    public void setPebbles(List<Pebble> pebbles) {
        this.pebbles = pebbles;
    }
}