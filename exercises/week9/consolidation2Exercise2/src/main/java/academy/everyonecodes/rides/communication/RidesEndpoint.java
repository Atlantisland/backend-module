package academy.everyonecodes.rides.communication;

import academy.everyonecodes.rides.logic.RideService;
import academy.everyonecodes.rides.persistence.domain.Driver;
import academy.everyonecodes.rides.persistence.domain.Ride;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class RidesEndpoint {

    private final RideService rideService;

    public RidesEndpoint(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    Driver post(@RequestBody Driver driver){
        return rideService.save(driver);
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    List<Driver> getDrivers(){
        return rideService.findAll();
    }

    @PostMapping("/{id}/rides")
    @Secured("ROLE_APP")
    void post(@RequestBody Ride ride, @PathVariable Long id){
        rideService.link(ride, id);
    }
}

