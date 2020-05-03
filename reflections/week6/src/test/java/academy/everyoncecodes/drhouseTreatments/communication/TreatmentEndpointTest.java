package academy.everyoncecodes.drhouseTreatments.communication;

import academy.everyoncecodes.drhouseTreatments.logic.TreatmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TreatmentEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TreatmentService service;

    String url = "/treatments";

    @Test
    void get(){
        testRestTemplate.getForObject(url, ArrayList.class);

        verify(service).findAll();
    }

    @Test
    void getByUuid(){
        String uuid = "uuid";

        testRestTemplate.getForObject(url + "/" + uuid, ArrayList.class);

        verify(service).findByUuid(uuid);
    }
}