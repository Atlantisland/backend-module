package academy.everyonecodes.registrations.presistence.repository;

import academy.everyonecodes.registrations.presistence.domain.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CourseRepository extends MongoRepository<Course, String> {
    Optional<Course> findOneByUuid(String uuid);
}
