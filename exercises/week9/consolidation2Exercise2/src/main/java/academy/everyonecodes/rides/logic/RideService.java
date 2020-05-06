package academy.everyonecodes.rides.logic;

import academy.everyonecodes.rides.persistence.domain.Driver;
import academy.everyonecodes.rides.persistence.domain.Ride;
import academy.everyonecodes.rides.persistence.repository.DriverRepository;
import academy.everyonecodes.rides.persistence.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RideService {

    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;

    public RideService(RideRepository rideRepository, DriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.driverRepository = driverRepository;
    }

    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public void link(Ride ride, Long id) {
        Optional<Driver> oDriver = driverRepository.findById(id);
        if (oDriver.isEmpty()) {
            return;
        }
        rideRepository.save(ride);
        Driver driver = oDriver.get();
        driver.getRides().add(ride);
        driverRepository.save(driver);
    }
}
