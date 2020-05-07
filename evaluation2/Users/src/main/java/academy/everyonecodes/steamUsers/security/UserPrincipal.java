package academy.everyonecodes.steamUsers.security;

import academy.everyonecodes.steamUsers.peristence.domain.SteamUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class UserPrincipal implements UserDetails {

    private final SteamUser steamUser;

    public UserPrincipal(SteamUser steamUser) {
        this.steamUser = steamUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<String> authorities = steamUser.getAuthorities();
        return AuthorityUtils.createAuthorityList(authorities.toArray(new String[authorities.size()]));
    }

    @Override
    public String getPassword() {
        return steamUser.getPassword();
    }

    @Override
    public String getUsername() {
        return steamUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
