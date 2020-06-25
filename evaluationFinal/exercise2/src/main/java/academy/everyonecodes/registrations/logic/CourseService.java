package academy.everyonecodes.registrations.logic;

import academy.everyonecodes.registrations.presistence.domain.Course;
import academy.everyonecodes.registrations.presistence.domain.Registration;
import academy.everyonecodes.registrations.presistence.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course findOrCreate(Registration registration) {
        return courseRepository.findOneByUuid(registration.getCourseUUid())
                .orElseGet(() -> createCourse(registration));
    }

    private Course createCourse(Registration registration) {
        Course course = new Course(registration.getCourseName(),
                registration.getCourseUUid(),
                registration.getCoursePrice());
        return courseRepository.save(course);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}



