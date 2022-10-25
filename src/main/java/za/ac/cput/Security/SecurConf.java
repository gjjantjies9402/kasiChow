package za.ac.cput.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurConf extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("Mzi")
                .password(encoder().encode("12345"))
                .roles("Admin")
                .and()
                .withUser("Gaynor")
                .password(encoder().encode("54321"))
                .roles("User");
    }


    @Override
    protected  void configure(HttpSecurity http)throws Exception{

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/kasichow/**/create").hasRole("User")
                .antMatchers(HttpMethod.GET, "/kasichow/**/read").hasRole("User")
                .antMatchers(HttpMethod.PUT, "/kasichow/**/update").hasRole("Admin")
                .antMatchers(HttpMethod.DELETE, "/kasichow/**/delete").hasRole("Admin")
                .antMatchers(HttpMethod.GET, "/kasichow/**/all").hasRole("User")
                .and()
                .csrf().disable()
                .formLogin().disable();

    }
}
