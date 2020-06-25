package academy.everyonecodes.udemyUsers.logic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class LoginUdemyServiceTest {

    @Autowired
    LoginUdemyService loginUdemyService;

    @Value("${users.login.message}")
    String message;

    @Test
    void login() {
        String result = loginUdemyService.login();

        assertEquals(message, result);
    }
}