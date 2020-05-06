package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.presistence.domain.Driver;
import academy.everyonecodes.drivers.presistence.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final PasswordEncoder passwordEncoder;
    private final String authority;

    public DriverService(DriverRepository driverRepository, PasswordEncoder passwordEncoder, @Value("${drivers.driver.authority}") String authority) {
        this.driverRepository = driverRepository;
        this.passwordEncoder = passwordEncoder;
        this.authority = authority;
    }

    public Optional<Driver> findOne(String id){
        return driverRepository.findById(id);
    }

    public Driver save(Driver driver){
        Optional<Driver> oDriver = driverRepository.findOneByUsername(driver.getUsername());
        if(oDriver.isPresent()){
            return oDriver.get();
        }
        driver.getAuthorities().add(authority);
        String password = driver.getPassword();
        String encoded = passwordEncoder.encode(password);
        driver.setPassword(encoded);
        return driverRepository.save(driver);
    }

    public void markAsAvailable(String id){
        Optional<Driver> oDriver = driverRepository.findById(id);
        if(oDriver.isEmpty()){
            return;
        }
        Driver driver = oDriver.get();
        driver.setAvailable(true);
        driverRepository.save(driver);
    }

    public void markAsUnavailable(String id){
        Optional<Driver> oDriver = driverRepository.findById(id);
        if(oDriver.isEmpty()){
            return;
        }
        Driver driver = oDriver.get();
        driver.setAvailable(false);
        driverRepository.save(driver);
    }
}
