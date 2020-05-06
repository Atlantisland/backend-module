package academy.everyonecodes.rides.logic;

import academy.everyonecodes.rides.persistence.domain.Driver;
import academy.everyonecodes.rides.persistence.repository.DriverRepository;
import academy.everyonecodes.rides.persistence.repository.RideRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class RideServiceTest {

    @Autowired
    RideService rideService;

    @MockBean
    DriverRepository driverRepository;

    @MockBean
    RideRepository rideRepository;


    @MockBean
    PasswordEncoder passwordEncoder;

    @Value("${uber.credentials.authorities}")
    String authority;

    @Test
    void save() {
        Driver driver = new Driver();
        when(passwordEncoder.encode("password"))
                .thenReturn("encrypted");
        rideService.save(driver);
    }

    @Test
    void findAll() {
        String id = "id";
        rideService.findAll();
        verify(driverRepository).findAll();
    }

}