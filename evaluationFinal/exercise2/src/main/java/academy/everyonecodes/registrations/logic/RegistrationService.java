package academy.everyonecodes.registrations.logic;

import academy.everyonecodes.registrations.presistence.domain.Course;
import academy.everyonecodes.registrations.presistence.domain.Registration;
import academy.everyonecodes.registrations.presistence.domain.UdemyUser;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UdemyUserService udemyUserService;
    private final CourseService courseService;

    public RegistrationService(UdemyUserService udemyUserService,
                               CourseService courseService) {
        this.udemyUserService = udemyUserService;
        this.courseService = courseService;
    }

    public Registration link(Registration registration){
        UdemyUser udemyUser = udemyUserService.findOrCreate(registration);
        Course course = courseService.findOrCreate(registration);
        udemyUser.getCourses().add(course);
        udemyUserService.save(udemyUser);
        return registration;
    }
}
