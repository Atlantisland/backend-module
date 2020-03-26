package academy.everyonecodes.advancedTypes.domain;

import java.util.Set;

public class CommunityEvent {

    private String name;
    private String location;
    private Set<Student> students;

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    void setLocation(String location) {
        this.location = location;
    }

    public Set<Student> getStudents() {
        return students;
    }

    void setStudents(Set<Student> students) {
        this.students = students;
    }
}
