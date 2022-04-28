package au.edu.uts.isd.iotbay.configs;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((auth) -> auth.antMatchers("/", "/static/**").permitAll())
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .failureUrl("/login-failed")
                );
    }
}
