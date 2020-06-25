package academy.everyonecodes.registrations.presistence.domain;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Objects;
import java.util.Set;

public class UdemyUser {

    private String id;

    @Indexed(unique = true)
    private String username;

    private Set<Course> courses;

    public UdemyUser() {
    }

    public UdemyUser(String username, Set<Course> courses) {
        this.username = username;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UdemyUser udemyUser = (UdemyUser) o;
        return Objects.equals(id, udemyUser.id) &&
                Objects.equals(username, udemyUser.username) &&
                Objects.equals(courses, udemyUser.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, courses);
    }
}
