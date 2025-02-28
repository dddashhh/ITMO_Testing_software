package org.dddashhh.story;

import org.dddashhh.story.entities.*;

import java.util.List;

public class World {
    private Sea sea;
    private Beach beach;
    private List<Mountain> mountains;
    private Table table;
    private Sunshade sunshade;

    public World(Sea sea, Beach beach, List<Mountain> mountains, Table table, Sunshade sunshade) {
        this.sea = sea;
        this.beach = beach;
        this.mountains = mountains;
        this.table = table;
        this.sunshade = sunshade;
    }

    public Sea getSea() {
        return sea;
    }

    public void setSea(Sea sea) {
        this.sea = sea;
    }

    public Beach getBeach() {
        return beach;
    }

    public void setBeach(Beach beach) {
        this.beach = beach;
    }

    public List<Mountain> getMountains() {
        return mountains;
    }

    public void setMountains(List<Mountain> mountains) {
        this.mountains = mountains;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Sunshade getSunshade() {
        return sunshade;
    }

    public void setSunshade(Sunshade sunshade) {
        this.sunshade = sunshade;
    }
}