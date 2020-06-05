package academy.everyonecodes.dorothy.endpoint;

import academy.everyonecodes.dorothy.logic.Dorothy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DorothyEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Dorothy dorothy;

    String url = "/dorothy";

    @Test
    void get() {
        testRestTemplate.getForObject(url, String.class);

        verify(dorothy).getMessage();
    }
}
