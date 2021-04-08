package fr.syberalexis.ogametimecalc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlayerClass {
    UNKNOWN(10),
    COLLECTOR(10),
    GENERAL(5),
    EXPLORATOR(10),
    ;

    private int fleetPadding;
}
