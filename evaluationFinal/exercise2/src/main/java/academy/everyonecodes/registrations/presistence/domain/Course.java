package academy.everyonecodes.registrations.presistence.domain;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Objects;

public class Course {

    private String id;
    private String courseName;

    @Indexed(unique = true)
    private String courseUuid;

    private double price;

    public Course() {
    }

    public Course(String courseName, String courseUuid, double price) {
        this.courseName = courseName;
        this.courseUuid = courseUuid;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseUuid() {
        return courseUuid;
    }

    public void setCourseUuid(String courseUuid) {
        this.courseUuid = courseUuid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Double.compare(course.price, price) == 0 &&
                Objects.equals(id, course.id) &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(courseUuid, course.courseUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, courseUuid, price);
    }
}
