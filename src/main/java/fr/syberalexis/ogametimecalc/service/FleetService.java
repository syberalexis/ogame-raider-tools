package fr.syberalexis.ogametimecalc.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import fr.syberalexis.ogametimecalc.model.Coordinate;
import fr.syberalexis.ogametimecalc.model.Fleet;
import fr.syberalexis.ogametimecalc.model.Movement;
import fr.syberalexis.ogametimecalc.model.MovementType;
import fr.syberalexis.ogametimecalc.model.ServerInfo;
import fr.syberalexis.ogametimecalc.model.UserInfo;

@Component
public class FleetService {
    public Duration calculateFleetDuration(ServerInfo serverInfo, Fleet fleet, Coordinate source, Coordinate destination, int percentage) {
        int shipSpeed = fleet.getSlowestShipSpeed();
        double basePercentage = 35000 / percentage;
        Coordinate distance = calculateDistance(serverInfo, source, destination);

        if (!destination.isSameGalaxyOf(source)) {
            return Duration.ofSeconds((10 + (long) Math.ceil(basePercentage * Math.sqrt(distance.getGalaxy() * 20000000d / shipSpeed))) / serverInfo.getFleetspeed());    
        } else if (!destination.isSameSystemOf(source)) {
            return Duration.ofSeconds((10 + (long) Math.ceil(basePercentage * Math.sqrt((2700000d + distance.getSystem() * 95000d) / shipSpeed))) / serverInfo.getFleetspeed());
        } else if (!destination.isSamePlanetOf(source)) {
            return Duration.ofSeconds((10 + (long) Math.ceil(basePercentage * Math.sqrt((1000000d + distance.getPlanet() * 5000d) / shipSpeed))) / serverInfo.getFleetspeed());
        }
        return Duration.ofSeconds((10 + (long) Math.ceil(basePercentage * Math.sqrt(5000d / shipSpeed))) / serverInfo.getFleetspeed());
    }

    public Coordinate calculateDistance(ServerInfo serverInfo, Coordinate source, Coordinate destination) {
        if (!destination.isSameGalaxyOf(source)) {
            int delta = Math.abs(source.getGalaxy() - destination.getGalaxy());
            if (serverInfo.isCircularGalaxy()) {
                int tmp = Math.abs(delta - serverInfo.getMaxGalaxies());
                if (tmp < delta) {
                    delta = tmp;
                }
            }
            return new Coordinate(delta, 0, 0);
        } else if (!destination.isSameSystemOf(source)) {
            int delta = Math.abs(source.getSystem() - destination.getSystem());
            if (serverInfo.isCircularSystem()) {
                int tmp = Math.abs(delta - serverInfo.getMaxSystems());
                if (tmp < delta) {
                    delta = tmp;
                }
            }
            return new Coordinate(0, delta, 0);
        } else if (!destination.isSamePlanetOf(source)) {
            int delta = Math.abs(source.getPlanet() - destination.getPlanet());
            return new Coordinate(0, 0, delta);
        }
        return new Coordinate(0, 0, 0);
    }
    
    public Map<Integer, LocalDateTime> findPercentage(ServerInfo serverInfo, UserInfo userInfo, Fleet fleet, Coordinate source, Coordinate destination, LocalDateTime possibleDeparture, LocalDateTime arrival) {
        Map<Integer, LocalDateTime> possiblePercentage = new LinkedHashMap<>();

        int padding = fleet.getPlayerClass().getFleetPadding();

        for (int i = 100; i > 0; i-=padding) {
            Duration fleetDuration = calculateFleetDuration(serverInfo, fleet, source, destination, i);
            
            LocalDateTime departure = arrival.minus(fleetDuration);
            if (departure.isBefore(possibleDeparture)) {
                possiblePercentage.put(i, departure);
            }
        }

        return possiblePercentage;
    }


    public LocalDateTime calculateReturn(ServerInfo serverInfo, Fleet fleet, Movement movement, LocalDateTime backTime) {
        if (movement == null || (movement.getDepartureTime() == null && movement.getArrivalTime() == null)) {
            throw new IllegalArgumentException("Impossible to calculate return less departure or arrival time !");
        }

        if (MovementType.PARK.equals(movement.getType()) && backTime == null) {
            return null;
        }

        int additionnalHour = 0;
        if (List.of(MovementType.EXPEDITION, MovementType.FRIEND_PARK).contains(movement.getType())) {
            additionnalHour = movement.getAdditionnalHour();
        }

        Duration movementDuration = calculateFleetDuration(serverInfo, fleet, movement.getSource(), movement.getDestination(), movement.getPercentage());
        
        LocalDateTime time = null; 
        if (backTime == null) {
            if (movement.getArrivalTime() != null) {
                time = movement.getArrivalTime();
            } else {
                time = movement.getDepartureTime().plus(movementDuration);
            }
            if (additionnalHour > 0) {
                time = time.plusHours(additionnalHour);
            }
        } else {
            time = backTime;
            LocalDateTime departureTime = movement.getDepartureTime();
            if (departureTime == null) {
                departureTime = movement.getArrivalTime().minus(movementDuration);
            }
            if (departureTime.plus(movementDuration).isAfter(backTime)) {
                movementDuration = Duration.between(departureTime, backTime);
            }
        }

        return time.plus(movementDuration);
    }
}
