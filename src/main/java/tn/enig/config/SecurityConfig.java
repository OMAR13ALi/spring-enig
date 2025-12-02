package tn.enig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder crypt = cryptageMP();

        auth.inMemoryAuthentication()
                .withUser("user")
                .password(crypt.encode("user123"))
                .roles("USER");

        auth.inMemoryAuthentication()
                .withUser("agent")
                .password(crypt.encode("agent123"))
                .roles("AGENT");

        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(crypt.encode("admin123"))
                .roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .defaultSuccessUrl("/listeslivre",true);

        http.authorizeRequests()
                .antMatchers("/ajoutlivre","savelivre").hasRole("ADMIN")
                .antMatchers("/ajoutemprunt","saveemprunt").hasRole("ADMIN")
                .antMatchers("/deletelivre/**","/deleteemprunt/**").hasRole("ADMIN")

                .antMatchers("/listesadherant","/empruntsadherant/**","/empruntslivre/**").hasRole("ADMIN")
                .antMatchers("/listeslivre").authenticated()

                .anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");

        http.logout().logoutSuccessUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll();

        http.csrf();


    }

    @Bean
    public PasswordEncoder cryptageMP() {
        return new BCryptPasswordEncoder();
    }




}
