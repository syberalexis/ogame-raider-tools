package fr.syberalexis.ogametimecalc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServerInfo {
    private int fleetspeed;
    private boolean circularGalaxy;
    private boolean circularSystem;
    private int maxGalaxies;
    private int maxSystems;
}
