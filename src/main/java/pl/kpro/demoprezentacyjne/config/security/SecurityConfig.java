package pl.kpro.demoprezentacyjne.config.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests(authorize -> authorize
                .antMatchers("/secure").authenticated()
                .antMatchers("/logout").authenticated()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
        ).formLogin();
    }
}
