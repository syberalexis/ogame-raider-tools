package fr.syberalexis.ogametimecalc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinate {
    private int galaxy;
    private int system;
    private int planet;

    public boolean isSameGalaxyOf(Coordinate coordinate) {
        return this.galaxy == coordinate.galaxy;
    }

    public boolean isSameSystemOf(Coordinate coordinate) {
        return isSameGalaxyOf(coordinate) && this.system == coordinate.system;
    }

    public boolean isSamePlanetOf(Coordinate coordinate) {
        return isSameSystemOf(coordinate) && this.planet == coordinate.planet;
    }
}
