package fr.syberalexis.ogametimecalc.model;

public enum Reactor {
    COMBUSTION{
        @Override
        public double calculateSpeedFactor(int level) {
            return 1 + level / 10d;
        }
    },
    IMPULSE{
        @Override
        public double calculateSpeedFactor(int level) {
            return 1 + 2 * level / 10d;
        }
    },
    HYPERSPACE{
        @Override
        public double calculateSpeedFactor(int level) {
            return 1 + 3 * level / 10d;
        }
    },
    ;

    public abstract double calculateSpeedFactor(int level);
}
