package academy.everyonecodes.registrations.communication;

import academy.everyonecodes.registrations.logic.CourseService;
import academy.everyonecodes.registrations.presistence.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourseEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    CourseService courseService;

    String url = "/courses";

    @Test
    void get() {
        testRestTemplate.getForObject(url, Course[].class);

        verify(courseService).findAll();
    }
}