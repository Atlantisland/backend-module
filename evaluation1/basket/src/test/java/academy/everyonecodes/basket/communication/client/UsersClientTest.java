package academy.everyonecodes.basket.communication.client;

import academy.everyonecodes.basket.domain.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UsersClientTest {

    @Autowired
    UsersClient client;

    @MockBean
    RestTemplate restTemplate;

    @Value("${users.url.userUrl}")
    String url;

    @Test
    void getUser(){
        String email = "email";
        Mockito.when(restTemplate.getForObject(url + "/" + email, User.class)).thenReturn(new User());
        client.getUser(email);
        verify(restTemplate).getForObject(url + "/" + email, User.class);
    }
}