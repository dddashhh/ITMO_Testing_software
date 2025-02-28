package org.dddashhh.story;

import org.dddashhh.story.characteristics.*;
import org.dddashhh.story.entities.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {

    @Nested
    @DisplayName("Sea Tests")
    class SeaTest {
        private Sea sea;

        @BeforeEach
        void setUp() {
            sea = new Sea(Color.PURPLE);
        }

        @Test
        @DisplayName("Sea Creation")
        void testSeaCreation() {
            assertEquals(Color.PURPLE, sea.getColor());
        }

        @Test
        @DisplayName("Set Sea Color")
        void testSetSeaColor() {
            sea.setColor(Color.GREEN);
            assertEquals(Color.GREEN, sea.getColor());
        }
    }

    @Nested
    @DisplayName("Beach Tests")
    class BeachTest {
        private Beach beach;
        private List<Pebble> pebbles;

        @BeforeEach
        void setUp() {
            pebbles = Arrays.asList(
                    new Pebble(Color.YELLOW, true),
                    new Pebble(Color.GREEN, false)
            );
            beach = new Beach(pebbles);
        }

        @Test
        @DisplayName("Beach Creation")
        void testBeachCreation() {
            assertEquals(2, beach.getPebbles().size());
            assertTrue(beach.getPebbles().get(0).isPrecious());
            assertFalse(beach.getPebbles().get(1).isPrecious());
        }

        @Test
        @DisplayName("Set Beach Pebbles")
        void testSetBeachPebbles() {
            List<Pebble> newPebbles = Arrays.asList(new Pebble(Color.RED, true));
            beach.setPebbles(newPebbles);
            assertEquals(1, beach.getPebbles().size());
            assertEquals(Color.RED, beach.getPebbles().get(0).getColor());
        }
    }

    @Nested
    @DisplayName("Pebble Tests")
    class PebbleTest {
        private Pebble pebble;

        @BeforeEach
        void setUp() {
            pebble = new Pebble(Color.YELLOW, true);
        }

        @Test
        @DisplayName("Pebble Creation")
        void testPebbleCreation() {
            assertEquals(Color.YELLOW, pebble.getColor());
            assertTrue(pebble.isPrecious());
        }

        @Test
        @DisplayName("Set Pebble Color")
        void testSetPebbleColor() {
            pebble.setColor(Color.GREEN);
            assertEquals(Color.GREEN, pebble.getColor());
        }

        @Test
        @DisplayName("Set Pebble Precious")
        void testSetPebblePrecious() {
            pebble.setPrecious(false);
            assertFalse(pebble.isPrecious());
        }
    }

    @Nested
    @DisplayName("Mountain Tests")
    class MountainTest {
        private Mountain mountain;

        @BeforeEach
        void setUp() {
            mountain = new Mountain(Color.RED);
        }

        @Test
        @DisplayName("Mountain Creation")
        void testMountainCreation() {
            assertEquals(Color.RED, mountain.getPeakColor());
        }

        @Test
        @DisplayName("Set Mountain Peak Color")
        void testSetMountainPeakColor() {
            mountain.setPeakColor(Color.SILVER);
            assertEquals(Color.SILVER, mountain.getPeakColor());
        }
    }

    @Nested
    @DisplayName("Table Tests")
    class TableTest {
        private Table table;

        @BeforeEach
        void setUp() {
            table = new Table(Material.SILVER);
        }

        @Test
        @DisplayName("Table Creation")
        void testTableCreation() {
            assertEquals(Material.SILVER, table.getMaterial());
        }

        @Test
        @DisplayName("Set Table Material")
        void testSetTableMaterial() {
            table.setMaterial(Material.WOOD);
            assertEquals(Material.WOOD, table.getMaterial());
        }
    }

    @Nested
    @DisplayName("Sunshade Tests")
    class SunshadeTest {
        private Sunshade sunshade;

        @BeforeEach
        void setUp() {
            sunshade = new Sunshade(Color.LILAC, true, Material.SILVER);
        }

        @Test
        @DisplayName("Sunshade Creation")
        void testSunshadeCreation() {
            assertEquals(Color.LILAC, sunshade.getColor());
            assertTrue(sunshade.hasFringes());
            assertEquals(Material.SILVER, sunshade.getFringesMaterial());
        }

        @Test
        @DisplayName("Set Sunshade Color")
        void testSetSunshadeColor() {
            sunshade.setColor(Color.PURPLE);
            assertEquals(Color.PURPLE, sunshade.getColor());
        }

        @Test
        @DisplayName("Set Sunshade hasFringes")
        void testSetSunshadeHasFringes() {
            sunshade.setHasFringes(false);
            assertFalse(sunshade.hasFringes());
        }

        @Test
        @DisplayName("Set Sunshade Fringes Material")
        void testSetSunshadeFringesMaterial() {
            sunshade.setFringesMaterial(Material.SILVER);
            assertEquals(Material.SILVER, sunshade.getFringesMaterial());
        }
    }

    @Nested
    @DisplayName("World Tests")
    class WorldTestClass {
        private World world;
        private Sea sea;
        private Beach beach;
        private List<Mountain> mountains;
        private Table table;
        private Sunshade sunshade;

        @BeforeEach
        void setUp() {
            sea = new Sea(Color.PURPLE);
            List<Pebble> pebbles = Arrays.asList(new Pebble(Color.YELLOW, true));
            beach = new Beach(pebbles);
            mountains = Arrays.asList(new Mountain(Color.RED));
            table = new Table(Material.SILVER);
            sunshade = new Sunshade(Color.LILAC, true, Material.SILVER);

            world = new World(sea, beach, mountains, table, sunshade);
        }

        @Test
        @DisplayName("World Creation")
        void testWorldCreation() {
            assertEquals(sea, world.getSea());
            assertEquals(beach, world.getBeach());
            assertEquals(mountains, world.getMountains());
            assertEquals(table, world.getTable());
            assertEquals(sunshade, world.getSunshade());
        }

        @Test
        @DisplayName("Set World Sea")
        void testSetWorldSea() {
            Sea newSea = new Sea(Color.GREEN);
            world.setSea(newSea);
            assertEquals(newSea, world.getSea());
        }

        @Test
        @DisplayName("Set World Beach")
        void testSetWorldBeach() {
            Beach newBeach = new Beach(Arrays.asList(new Pebble(Color.GREEN, false)));
            world.setBeach(newBeach);
            assertEquals(newBeach, world.getBeach());
        }

        @Test
        @DisplayName("Set World Mountains")
        void testSetWorldMountains() {
            List<Mountain> newMountains = Arrays.asList(new Mountain(Color.SILVER));
            world.setMountains(newMountains);
            assertEquals(newMountains, world.getMountains());
        }

        @Test
        @DisplayName("Set World Table")
        void testSetWorldTable() {
            Table newTable = new Table(Material.SILVER);
            world.setTable(newTable);
            assertEquals(newTable, world.getTable());
        }

        @Test
        @DisplayName("Set World Sunshade")
        void testSetWorldSunshade() {
            Sunshade newSunshade = new Sunshade(Color.GREEN, false, Material.SILVER);
            world.setSunshade(newSunshade);
            assertEquals(newSunshade, world.getSunshade());
        }
    }
}
