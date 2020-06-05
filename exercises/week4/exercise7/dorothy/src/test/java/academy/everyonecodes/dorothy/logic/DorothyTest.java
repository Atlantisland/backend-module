package academy.everyonecodes.dorothy.logic;

import academy.everyonecodes.dorothy.client.HomeClient;
import academy.everyonecodes.dorothy.client.WizardClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

class DorothyTest {

    @Autowired
    Dorothy dorothy;

    @MockBean
    WizardClient wizardClient;

    @MockBean
    HomeClient homeClient;

    @Value("${dorothy.message}")
    String message;

    @Test
    void getHomeUrl(){
        String homeUrl = "homeUrl";
        when(wizardClient.getHomeUrl())
                .thenReturn(homeUrl);
        String homeMessage = "homeMessage";
        when(homeClient.getHomeMessage(homeUrl))
                .thenReturn(homeMessage);

        String result = dorothy.getMessage();

        String expected = message + homeMessage;
        assertEquals(expected, result);
    }
}
