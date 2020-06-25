package academy.everyonecodes.registrations.presistence.domain;

import java.util.Objects;

public class Registration {

    private String username;
    private String courseName;
    private String courseUUid;
    private double coursePrice;

    public Registration() {
    }

    public Registration(String username, String courseName, String courseUUid, double coursePrice) {
        this.username = username;
        this.courseName = courseName;
        this.courseUUid = courseUUid;
        this.coursePrice = coursePrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseUUid() {
        return courseUUid;
    }

    public void setCourseUUid(String courseUUid) {
        this.courseUUid = courseUUid;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration registration = (Registration) o;
        return Double.compare(registration.coursePrice, coursePrice) == 0 &&
                Objects.equals(username, registration.username) &&
                Objects.equals(courseName, registration.courseName) &&
                Objects.equals(courseUUid, registration.courseUUid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, courseName, courseUUid, coursePrice);
    }
}
