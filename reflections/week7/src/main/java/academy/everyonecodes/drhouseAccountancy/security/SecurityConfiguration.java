package academy.everyonecodes.drhouseAccountancy.security;

import academy.everyonecodes.drhouseAccountancy.persistence.domain.Credentials;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ConfigurationProperties("drhouse.accountancy")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private List<Credentials> credentials;

    void setCredentials(List<Credentials> credentials) {
        this.credentials = credentials;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(POST, "/patients").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(credentials.stream()
                .map(toUserDetails(encoder))
                .collect(toList()));
    }

    private Function<Credentials, UserDetails> toUserDetails(PasswordEncoder encoder) {
        return credentials -> User.withUsername(credentials.getUsername())
                .password(encoder.encode(credentials.getPassword()))
                .authorities(credentials.getAuthorities())
                .build();
    }
}
