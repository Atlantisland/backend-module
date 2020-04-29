package academy.everyonecodes.languageBarriers;

import academy.everyonecodes.languageBarriers.domain.LanguageSchoolUser;
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

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ConfigurationProperties("language-school")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private List<LanguageSchoolUser> languageSchoolUsers;

    void setLanguageSchoolUsers(List<LanguageSchoolUser> languageSchoolUsers) {
        this.languageSchoolUsers = languageSchoolUsers;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
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
        List<UserDetails> users = languageSchoolUsers.stream()
                .map(toUserDetails(encoder))
                .collect(toList());
        return new InMemoryUserDetailsManager(users);
    }

    private Function<LanguageSchoolUser, UserDetails> toUserDetails(PasswordEncoder encoder) {
        return languageSchoolUser -> User.withUsername(languageSchoolUser.getUsername())
                .password(encoder.encode(languageSchoolUser.getPassword()))
                .authorities(languageSchoolUser.getAuthorities())
                .build();
    }
}

