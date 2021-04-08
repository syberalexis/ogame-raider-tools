package fr.syberalexis.ogametimecalc.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movement {
    private MovementType type;
    private Coordinate source;
    private Coordinate destination;
    private int percentage;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int additionnalHour;
}
