package academy.everyonecodes.registrations.communication;

import academy.everyonecodes.registrations.logic.CourseService;
import academy.everyonecodes.registrations.presistence.domain.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseEndpoint {

    private final CourseService courseService;

    public CourseEndpoint(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    List<Course> get() {
        return courseService.findAll();
    }
}
