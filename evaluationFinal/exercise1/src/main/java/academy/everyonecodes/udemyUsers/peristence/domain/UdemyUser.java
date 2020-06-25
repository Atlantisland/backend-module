package academy.everyonecodes.udemyUsers.peristence.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class UdemyUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> authorities;

    public UdemyUser() {
    }

    public UdemyUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UdemyUser(String username, String password, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UdemyUser udemyUser = (UdemyUser) o;
        return Objects.equals(id, udemyUser.id) &&
                Objects.equals(username, udemyUser.username) &&
                Objects.equals(password, udemyUser.password) &&
                Objects.equals(authorities, udemyUser.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities);
    }
}
