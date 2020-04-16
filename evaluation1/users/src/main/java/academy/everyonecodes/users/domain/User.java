package academy.everyonecodes.users.domain;

import java.util.Objects;

public class User {

    private String name;
    private String email;
    private String accountType;

    User() {
    }

    public User(String name, String email, String accountType) {
        this.name = name;
        this.email = email;
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(accountType, user.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, accountType);
    }
}
