package academy.everyonecodes.dorothy.endpoint;

import academy.everyonecodes.dorothy.logic.Dorothy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DorothyEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Dorothy dorothy;

    String url = "/dorothy";

    @Test
    void get() {
        String expected = "message";
        when(dorothy.findHome())
                .thenReturn(expected);

        String response = restTemplate.getForObject(url, String.class);

        assertEquals(expected, response);
        verify(dorothy).findHome();
    }
}
