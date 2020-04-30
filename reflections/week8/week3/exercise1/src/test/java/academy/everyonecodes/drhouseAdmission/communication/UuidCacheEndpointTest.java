package academy.everyonecodes.drhouseAdmission.communication;

import academy.everyonecodes.drhouseAdmission.logic.UUIDProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UuidCacheEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    UUIDProvider uuidProvider;

    String url = "/uuids";

    @Test
    void getAll() {
        restTemplate.getForObject(url, HashMap.class);

        verify(uuidProvider).getCacheSnapshot();
    }

    @Test
    void getOne() {
        String patientName = "test";

        restTemplate.getForObject(url + "/" + patientName, String.class);

        verify(uuidProvider).findUUID(patientName);
    }
}

