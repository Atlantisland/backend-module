package academy.everyonecodes.creditCards;

import java.util.Objects;
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

    public boolean issues(String number) {
        return startsWith(number) && hasLength(number);
    }

    private boolean startsWith(String number) {
        return startsWith.stream()
                .anyMatch(number::startsWith);
    }

    private boolean hasLength(String number) {
        return lengths.stream()
                .anyMatch(length -> length == number.length());
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    void setStartsWith(Set<String> startsWith) {
        this.startsWith = startsWith;
    }

    void setLengths(Set<Integer> lengths) {
        this.lengths = lengths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issuer issuer = (Issuer) o;
        return Objects.equals(name, issuer.name) &&
                Objects.equals(startsWith, issuer.startsWith) &&
                Objects.equals(lengths, issuer.lengths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startsWith, lengths);
    }
}


