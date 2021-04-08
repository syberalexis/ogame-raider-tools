package fr.syberalexis.ogametimecalc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Collections;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fr.syberalexis.ogametimecalc.model.Coordinate;
import fr.syberalexis.ogametimecalc.model.Fleet;
import fr.syberalexis.ogametimecalc.model.PlayerClass;
import fr.syberalexis.ogametimecalc.model.ServerInfo;
import fr.syberalexis.ogametimecalc.model.Ship;

public class FleetServiceTest {
    @InjectMocks
    private FleetService service;

    @BeforeClass
    private void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @DataProvider(name = "dataSpeed")
    private Object[][] getDataSpeed() {
        return new Object[][] {
            /* *********** */
            /*  COLLECTOR  */
            /* *********** */
            // Small cargo
            // same planet
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.COLLECTOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 1),
                10,
                Duration.parse("PT9M42S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.COLLECTOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 1),
                50,
                Duration.parse("PT2M")
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.COLLECTOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 1),
                100,
                Duration.parse("PT1M3S")
            },
            /* ************ */
            /*  EXPLORATOR  */
            /* ************ */
            // Small cargo
            // same planet
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 1),
                10,
                Duration.parse("PT10M57S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 1),
                50,
                Duration.parse("PT2M15S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 1),
                100,
                Duration.parse("PT1M10S")
            },
            // same system
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 8),
                10,
                Duration.parse("PT2H36M28S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 9),
                50,
                Duration.parse("PT31M26S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 15),
                100,
                Duration.parse("PT15M59S")
            },
            // same galaxy
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 10, 1),
                10,
                Duration.parse("PT4H49M55S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 200, 1),
                50,
                Duration.parse("PT2H22M59S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 400, 1),
                100,
                Duration.parse("PT53M47S")
            },
            // other galaxy
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(2, 1, 1),
                10,
                Duration.parse("PT11H27M33S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(4, 1, 1),
                50,
                Duration.parse("PT3H58M14S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 9, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(9, 1, 1),
                100,
                Duration.parse("PT1H8M50S")
            },
            // // Large cargo
            // new Object[] {
            //     2,
            //     new Fleet(PlayerClass.COLLECTOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
            //     new Coordinate(1, 1, 1),
            //     new Coordinate(1, 1, 1),
            //     10,
            //     Duration.parse("PT1H28M1S")
            // },
            // // Light fighter
            // new Object[] {
            //     2,
            //     new Fleet(PlayerClass.COLLECTOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LIGHT_FIGHTER, 1)),
            //     new Coordinate(1, 1, 1),
            //     new Coordinate(1, 1, 1),
            //     10,
            //     Duration.parse("PT8M53S")
            // },
            // // Heavy fighter
            // new Object[] {
            //     2,
            //     new Fleet(PlayerClass.COLLECTOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.HEAVY_FIGHTER, 1)),
            //     new Coordinate(1, 1, 1),
            //     new Coordinate(1, 1, 1),
            //     10,
            //     Duration.parse("PT8M10S")
            // }
        };
    }
    
    @Test(dataProvider = "dataSpeed")
    public void testSpeed(ServerInfo serverInfo, Fleet fleet, Coordinate source, Coordinate destination, int percentage, Duration expectedDuration) {
        // When
        Duration res = service.calculateFleetDuration(serverInfo, fleet, source, destination, percentage);

        // Then
        assertEquals(expectedDuration, res);
    }
}
