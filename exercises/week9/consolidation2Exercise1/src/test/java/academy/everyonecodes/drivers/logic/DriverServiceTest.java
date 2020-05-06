package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.presistence.domain.Driver;
import academy.everyonecodes.drivers.presistence.repository.DriverRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DriverServiceTest {

    @Autowired
    DriverService driverService;

    @MockBean
    DriverRepository driverRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Value("${drivers.driver.authority}")
    String authority;

    @Test
    void findOne() {
        String id = "id";
        driverService.findOne(id);
        verify(driverRepository).findById(id);
    }

    @Test
    void save() {
        Driver driver = new Driver("username", "password", "Mini", true, Set.of("ROLE_DRIVER"));
        when(passwordEncoder.encode("password"))
                .thenReturn("encrypted");
        driverService.save(driver);
    }

    @Test
    void markAsAvailableFindsEntry() {
        String id = "id";
        Optional<Driver> oDriver = Optional.of(new Driver("username", "password", "Mini", true, Set.of("ROLE_DRIVER")));
        when(driverRepository.findById(id)).thenReturn(oDriver);
        oDriver.get().setAvailable(true);
    }

    @Test
    void markAsAvailableDoesNotFindEntry() {
        String id = "id";
        Optional<Driver> oDriver = Optional.empty();
        when(driverRepository.findById(id)).thenReturn(oDriver);
        verify(driverRepository).save(oDriver.get());
    }

    @Test
    void markAsUnavailableFindsEntry() {
        String id = "id";
        Optional<Driver> oDriver = Optional.of(new Driver("username", "password", "Mini", true, Set.of("ROLE_DRIVER")));
        when(driverRepository.findById(id)).thenReturn(oDriver);
        oDriver.get().setAvailable(false);
    }

    @Test
    void markAsUnavailableDoesNotFindEntry() {
        String id = "id";
        Optional<Driver> oDriver = Optional.empty();
        when(driverRepository.findById(id)).thenReturn(oDriver);
        verify(driverRepository).save(oDriver.get());
    }
}