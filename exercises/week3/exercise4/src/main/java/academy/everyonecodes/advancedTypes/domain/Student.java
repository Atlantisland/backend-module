package academy.everyonecodes.advancedTypes.domain;

import java.util.Set;

public class Student {

    private String name;
    private Set<String> languages;

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    void setLanguages(Set<String> languages) {
        this.languages = languages;
    }
}
