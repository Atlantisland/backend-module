package academy.everyonecodes.registrations.logic;

import academy.everyonecodes.registrations.presistence.domain.Course;
import academy.everyonecodes.registrations.presistence.domain.Registration;
import academy.everyonecodes.registrations.presistence.domain.UdemyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class RegistrationServiceTest {

    @Autowired
    RegistrationService registrationService;

    @MockBean
    UdemyUserService udemyUserService;

    @MockBean
    CourseService courseService;

    @Test
    void link(){
        Registration registration = new Registration("username", "course", "uuid", 49.20);
        UdemyUser udemyUser = new UdemyUser("username", new HashSet<>());
        Course course = new Course("course", "uuid", 49.20);
        when(udemyUserService.findOrCreate(registration)).thenReturn(udemyUser);
        when(courseService.findOrCreate(registration)).thenReturn(course);

        registrationService.link(registration);

        verify(udemyUserService).findOrCreate(registration);
        verify(courseService).findOrCreate(registration);
        UdemyUser expected = new UdemyUser("username", Set.of(course));
        verify(udemyUserService).save(expected);
    }
}