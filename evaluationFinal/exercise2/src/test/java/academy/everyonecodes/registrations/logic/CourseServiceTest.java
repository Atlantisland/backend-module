package academy.everyonecodes.registrations.logic;

import academy.everyonecodes.registrations.presistence.domain.Course;
import academy.everyonecodes.registrations.presistence.domain.Registration;
import academy.everyonecodes.registrations.presistence.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @MockBean
    CourseRepository courseRepository;

    String uuid = "uuid";
    Registration registration = new Registration("username", "course", uuid, 49.20);
    Course course = new Course("course", uuid, 49.20);

    @Test
    void findOrCreateFinds() {
        when(courseRepository.findOneByUuid(uuid))
                .thenReturn(Optional.of(course));

        courseService.findOrCreate(registration);

        verify(courseRepository).findOneByUuid(uuid);
        verifyNoMoreInteractions(courseRepository);
    }

    @Test
    void findOrCreateCreates() {
        when(courseRepository.findOneByUuid(uuid))
                .thenReturn(Optional.empty());

        courseService.findOrCreate(registration);

        verify(courseRepository).findOneByUuid(uuid);
        verify(courseRepository).save(course);
    }

    @Test
    void findAll() {
        courseService.findAll();

        verify(courseRepository).findAll();
    }
}