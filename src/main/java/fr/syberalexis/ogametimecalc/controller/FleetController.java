package fr.syberalexis.ogametimecalc.controller;

import java.time.LocalDateTime;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.web.bind.annotation.RestController;

import fr.syberalexis.ogametimecalc.model.Coordinate;
import fr.syberalexis.ogametimecalc.model.Fleet;
import fr.syberalexis.ogametimecalc.model.ServerInfo;
import fr.syberalexis.ogametimecalc.model.UserInfo;
import fr.syberalexis.ogametimecalc.service.FleetService;
import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;

// @NoArgsConstructor
@RestController
@Path("/fleet")
@AllArgsConstructor
public class FleetController {
    @Inject
    private FleetService fleetService;

    @GET
    @Path("/time/manual")
    public LocalDateTime calculateTime(ServerInfo serverInfo, UserInfo userInfo, Fleet fleet, Coordinate source, Coordinate destination, int percentage) {
        return null;
    }

    @POST
    @Path("/back/manual")
    public LocalDateTime calculateBack(ServerInfo serverInfo, UserInfo userInfo, Fleet fleet, Coordinate source, Coordinate destination, int percentage, LocalDateTime backTime) {
        return null;
    }

    @POST
    @Path("/find/percentage/manual")
    public Map<Integer, LocalDateTime> findPercentage(ServerInfo serverInfo, UserInfo userInfo, Fleet fleet, Coordinate source, Coordinate destination, LocalDateTime possibleDeparture, LocalDateTime arrival) {
        return fleetService.findPercentage(serverInfo, userInfo, fleet, source, destination, possibleDeparture, arrival);
    }
}
