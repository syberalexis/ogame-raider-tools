package fr.syberalexis.ogametimecalc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fr.syberalexis.ogametimecalc.model.Coordinate;
import fr.syberalexis.ogametimecalc.model.Fleet;
import fr.syberalexis.ogametimecalc.model.Movement;
import fr.syberalexis.ogametimecalc.model.MovementType;
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
                Duration.parse("PT3H14M32S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 9, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.SMALL_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(9, 1, 1),
                100,
                Duration.parse("PT1H8M50S")
            },
            // Large cargo
            // same planet
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 1),
                10,
                Duration.parse("PT14M51S")
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
                new Coordinate(1, 1, 1),
                new Coordinate(1, 1, 1),
                100,
                Duration.parse("PT1M34S")
            },
        };
    }
    
    @Test(dataProvider = "dataSpeed")
    public void testSpeed(ServerInfo serverInfo, Fleet fleet, Coordinate source, Coordinate destination, int percentage, Duration expectedDuration) {
        // When
        Duration res = service.calculateFleetDuration(serverInfo, fleet, source, destination, percentage);

        // Then
        assertEquals(expectedDuration, res);
    }

    @DataProvider(name = "dataCalculateReturn")
    private Object[][] getDataCalculateReturn() {
        return new Object[][] {
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
                new Movement(
                    MovementType.TRANSPORT,
                    new Coordinate(1, 1, 1),
                    new Coordinate(1, 1, 1),
                    10,
                    null,
                    LocalDateTime.of(2021, 4, 8, 17, 7, 54),
                    0
                ),
                null,
                LocalDateTime.of(2021, 4, 8, 17, 22, 45)
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
                new Movement(
                    MovementType.TRANSPORT,
                    new Coordinate(1, 1, 1),
                    new Coordinate(1, 1, 1),
                    10,
                    null,
                    LocalDateTime.of(2021, 4, 8, 17, 7, 54),
                    0
                ),
                LocalDateTime.of(2021, 4, 8, 16, 55, 54),
                LocalDateTime.of(2021, 4, 8, 16, 58, 45)
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
                new Movement(
                    MovementType.TRANSPORT,
                    new Coordinate(1, 1, 1),
                    new Coordinate(1, 1, 1),
                    10,
                    LocalDateTime.of(2021, 4, 8, 17, 9, 29),
                    LocalDateTime.of(2021, 4, 8, 17, 24, 20),
                    0
                ),
                null,
                LocalDateTime.of(2021, 4, 8, 17, 39, 11)
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
                new Movement(
                    MovementType.TRANSPORT,
                    new Coordinate(1, 1, 1),
                    new Coordinate(1, 1, 1),
                    10,
                    LocalDateTime.of(2021, 4, 8, 17, 9, 29),
                    LocalDateTime.of(2021, 4, 8, 17, 24, 20),
                    0
                ),
                LocalDateTime.of(2021, 4, 8, 17, 11, 22),
                LocalDateTime.of(2021, 4, 8, 17, 13, 15)
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
                new Movement(
                    MovementType.TRANSPORT,
                    new Coordinate(1, 1, 1),
                    new Coordinate(1, 1, 1),
                    10,
                    LocalDateTime.of(2021, 4, 8, 17, 9, 29),
                    null,
                    0
                ),
                LocalDateTime.of(2021, 4, 8, 17, 11, 22),
                LocalDateTime.of(2021, 4, 8, 17, 13, 15)
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
                new Movement(
                    MovementType.TRANSPORT,
                    new Coordinate(1, 1, 1),
                    new Coordinate(1, 1, 1),
                    10,
                    LocalDateTime.of(2021, 4, 8, 17, 9, 29),
                    null,
                    1
                ),
                LocalDateTime.of(2021, 4, 8, 17, 11, 22),
                LocalDateTime.of(2021, 4, 8, 17, 13, 15)
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
                new Movement(
                    MovementType.FRIEND_PARK,
                    new Coordinate(1, 1, 1),
                    new Coordinate(1, 1, 1),
                    10,
                    null,
                    LocalDateTime.of(2021, 4, 8, 17, 7, 54),
                    1
                ),
                null,
                LocalDateTime.of(2021, 4, 8, 18, 22, 45)
            },
            new Object[] {
                new ServerInfo(2, true, true, 5, 499),
                new Fleet(PlayerClass.EXPLORATOR, 0, 0, 0, 16, 13, 15, Collections.singletonMap(Ship.LARGE_CARGO, 1)),
                new Movement(
                    MovementType.FRIEND_PARK,
                    new Coordinate(1, 1, 1),
                    new Coordinate(1, 1, 1),
                    10,
                    LocalDateTime.of(2021, 4, 8, 17, 9, 29),
                    LocalDateTime.of(2021, 4, 8, 17, 24, 20),
                    1
                ),
                LocalDateTime.of(2021, 4, 8, 17, 30, 20),
                LocalDateTime.of(2021, 4, 8, 17, 45, 11)
            },
        };
    }

    @Test(dataProvider = "dataCalculateReturn")
    public void testCalculateReturn(ServerInfo serverInfo, Fleet fleet, Movement movement, LocalDateTime backTime, LocalDateTime expectedTime) {
        // When
        LocalDateTime returnTime = service.calculateReturn(serverInfo, fleet, movement, backTime);

        // Then
        assertEquals(expectedTime, returnTime);
    }
}
