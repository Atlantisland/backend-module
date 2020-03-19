package academy.everyonecodes.creditCards;

import java.util.Set;

public class Issuer {
    private String name;
    private Set<String> startsWith;
    private Set<Integer> lengths;

    Issuer() {
    }

    public Issuer(String name, Set<String> startsWith, Set<Integer> lengths) {
        this.name = name;
        this.startsWith = startsWith;
        this.lengths = lengths;
    }

    public void setStartsWith(Set<String> startsWith) {
        this.startsWith = startsWith;
    }

    public void setLengths(Set<Integer> lengths) {
        this.lengths = lengths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean issues(String ccNumber) {
        return startsWith.stream()
                .anyMatch(ccNumber::startsWith)
                && lengths.stream()
                .anyMatch(length -> ccNumber.length() == length);
    }
}

