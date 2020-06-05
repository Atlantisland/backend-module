package academy.everyonecodes.wizard.logic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class WizardTest {

    @Autowired
    Wizard wizard;

    @Value("${home.url}")
    String homeUrl;

    @Test
    void getHomeUrl(){
        String result = wizard.getHomeUrl();

        assertEquals(homeUrl, result);
    }
}