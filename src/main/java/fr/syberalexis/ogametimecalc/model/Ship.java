package fr.syberalexis.ogametimecalc.model;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Ship {
    SMALL_CARGO(
        List.of(
            new Couple<Reactor, Integer>(Reactor.COMBUSTION, 5000),
            new Couple<Reactor, Integer>(Reactor.IMPULSE, 10000)
        ),
        PlayerClass.COLLECTOR
    ),
    LARGE_CARGO(
        List.of(new Couple<Reactor, Integer>(Reactor.COMBUSTION, 7500)),
        PlayerClass.COLLECTOR
    ),
    LIGHT_FIGHTER(
        List.of(new Couple<Reactor, Integer>(Reactor.COMBUSTION, 12500)),
        PlayerClass.GENERAL
    ),
    HEAVY_FIGHTER(
        List.of(new Couple<Reactor, Integer>(Reactor.IMPULSE, 10000)),
        PlayerClass.GENERAL
    ),
    CRUISER(
        List.of(new Couple<Reactor, Integer>(Reactor.IMPULSE, 15000)),
        PlayerClass.GENERAL
    ),
    BATTLESHIP(
        List.of(new Couple<Reactor, Integer>(Reactor.HYPERSPACE, 10000)),
        PlayerClass.GENERAL
    ),
    COLONY_SHIP(
        List.of(new Couple<Reactor, Integer>(Reactor.IMPULSE, 2500)),
        null
    ),
    RECYCLER(
        List.of(
            new Couple<Reactor, Integer>(Reactor.COMBUSTION, 2000),
            new Couple<Reactor, Integer>(Reactor.IMPULSE, 4000),
            new Couple<Reactor, Integer>(Reactor.HYPERSPACE, 6000)
        ),
        PlayerClass.GENERAL
    ),
    ESPIONAGE_PROBE(
        List.of(new Couple<Reactor, Integer>(Reactor.COMBUSTION, 100000000)),
        null
    ),
    BOMBER(
        List.of(
            new Couple<Reactor, Integer>(Reactor.IMPULSE, 4000),
            new Couple<Reactor, Integer>(Reactor.HYPERSPACE, 5000)
        ),
        PlayerClass.GENERAL
    ),
    DESTROYER(
        List.of(new Couple<Reactor, Integer>(Reactor.HYPERSPACE, 5000)),
        PlayerClass.GENERAL
    ),
    DEATHSTAR(
        List.of(new Couple<Reactor, Integer>(Reactor.HYPERSPACE, 100)),
        null
    ),
    BATTLECRUISER(
        List.of(new Couple<Reactor, Integer>(Reactor.HYPERSPACE, 10000)),
        PlayerClass.GENERAL
    ),
    REAPER(
        List.of(new Couple<Reactor, Integer>(Reactor.HYPERSPACE, 7000)),
        PlayerClass.GENERAL
    ),
    PATHFINDER(
        List.of(new Couple<Reactor, Integer>(Reactor.HYPERSPACE, 12000)),
        PlayerClass.GENERAL
    ),
    ;

    private List<Couple<Reactor, Integer>> reactors;
    private PlayerClass multiplierClass;

    public int getSpeed(int combustion, int impulse, int hyperspace, PlayerClass playerClass) {
        Couple<Reactor, Integer> reactorInfo = getReactorInfoFromTech(combustion, impulse, hyperspace);
        Reactor reactor = reactorInfo.getLeft();
        int classAdditional = playerClass.equals(this.multiplierClass) ? reactorInfo.getRight() : 0;
        double reactorSpeed;

        switch(reactor) {
            case COMBUSTION:
                reactorSpeed = reactor.calculateSpeedFactor(combustion);
                break;
            case IMPULSE:
                reactorSpeed = reactor.calculateSpeedFactor(impulse);
                break;
            case HYPERSPACE:
                reactorSpeed = reactor.calculateSpeedFactor(hyperspace);
                break;
            default:
                reactorSpeed = 0;
                break;
        }

        return Double.valueOf(reactorInfo.getRight() * reactorSpeed + classAdditional).intValue();
    }

    private Couple<Reactor, Integer> getReactorInfoFromTech(int combustion, int impulse, int hyperspace) {
        switch(this) {
            case SMALL_CARGO:
                if (impulse > 5) {
                    return this.reactors.get(1);
                }
            case RECYCLER:
                if (hyperspace > 15) {
                    return this.reactors.get(2);
                } else if (impulse > 17) {
                    return this.reactors.get(1);
                }
            case BOMBER:
                if (hyperspace > 8) {
                    return this.reactors.get(1);
                }
            default:
                // Nothing
        }
        return this.reactors.get(0);
    }
}
