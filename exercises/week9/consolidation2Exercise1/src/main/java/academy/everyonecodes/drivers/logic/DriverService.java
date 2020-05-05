package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.presistence.domain.Driver;
import academy.everyonecodes.drivers.presistence.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final PasswordEncoder passwordEncoder;
    private final Set<String> authorities;

    public DriverService(DriverRepository driverRepository, PasswordEncoder passwordEncoder, @Value("${drivers.driver.authority}") Set<String> authorities) {
        this.driverRepository = driverRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorities = authorities;
    }

    public Optional<Driver> findOne(String id){
        return driverRepository.findById(id);
    }

    public Optional<Driver> findByUsername(String username){
        return driverRepository.findOneByUsername(username);
    }

    public Driver save(Driver driver){
        String password = driver.getPassword();
        String encoded = passwordEncoder.encode(password);
        driver.setPassword(encoded);
        driver.setAuthorities(authorities);
        return driverRepository.save(driver);
    }

    public Optional<Driver> markAsAvailable(String id){
        Optional<Driver> oDriver = driverRepository.findById(id);
        if(oDriver.isEmpty()){
            return Optional.empty();
        }
        Driver driver = oDriver.get();
        driver.setAvailable(true);
        driverRepository.save(driver);
        return Optional.of(driver);
    }

    public Optional<Driver> markAsUnavailable(String id){
        Optional<Driver> oDriver = driverRepository.findById(id);
        if(oDriver.isEmpty()){
            return Optional.empty();
        }
        Driver driver = oDriver.get();
        driver.setAvailable(false);
        driverRepository.save(driver);
        return Optional.of(driver);
    }

}
