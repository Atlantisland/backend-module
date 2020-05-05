package academy.everyonecodes.drivers.communication;

import academy.everyonecodes.drivers.logic.DriverService;
import academy.everyonecodes.drivers.presistence.domain.Driver;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriversEndpoint {

    private final DriverService driverService;

    public DriversEndpoint(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    Driver post(@RequestBody Driver driver) {
        return driverService.save(driver);
    }

    @GetMapping("/{id}")
    @Secured("ROLE_DRIVER")
    Driver getOne(@PathVariable String id) {
        return driverService.findOne(id)
                .orElse(null);
    }

    @PutMapping("/{id}/available")
    @Secured("ROLE_DRIVER")
    Driver putAvailable(@PathVariable String id){
        return driverService.markAsAvailable(id)
                .orElse(null);
    }

    @PutMapping("/{id}/unavailable")
    @Secured("ROLE_DRIVER")
    Driver putUnavailable(@PathVariable String id){
        return driverService.markAsUnavailable(id)
                .orElse(null);
    }
}
