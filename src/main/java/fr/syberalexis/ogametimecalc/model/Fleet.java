package fr.syberalexis.ogametimecalc.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fleet {
    private PlayerClass playerClass;
    private int weapon;
    private int shield;
    private int armour;
    private int combustion;
    private int impulse;
    private int hyperspace;
    private Map<Ship, Integer> ships;

    public Ship getSlowestShip() {
        Ship slowest = null;
        int slowestSpeed = Integer.MAX_VALUE;
        for (Map.Entry<Ship, Integer> entry : ships.entrySet()) {
            if (slowest == null) {
                slowest = entry.getKey();
                continue;
            }

            int speed = entry.getKey().getSpeed(combustion, impulse, hyperspace, playerClass);
            if (slowestSpeed > speed) {
                slowest = entry.getKey();
                slowestSpeed = speed;
            }
        }
        return slowest;
    }

    public int getSlowestShipSpeed() {
        return getSlowestShip().getSpeed(combustion, impulse, hyperspace, playerClass);
    }
}
