package academy.everyonecodes.users.communication;

import academy.everyonecodes.users.domain.User;
import academy.everyonecodes.users.logic.UserStore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    UserStore store;

    String url = "/users";

    @Test
    void get(){
        User user1 = new User("user1", "email1", "type1");
        //Mockito.when(store.getUserByEmail("email1")).thenReturn(user1);
        testRestTemplate.getForObject(url + "/email1", User.class);

        verify(store).getUserByEmail("email1");
    }
}
