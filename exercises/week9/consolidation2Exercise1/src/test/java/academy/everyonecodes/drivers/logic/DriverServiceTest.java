package academy.everyonecodes.drivers.logic;

import academy.everyonecodes.drivers.presistence.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DriverServiceTest {

    @Autowired
    DriverService driverService;

    @MockBean
    DriverRepository driverRepository;

    @MockBean
    PasswordEncoder passwordEncoder;




}