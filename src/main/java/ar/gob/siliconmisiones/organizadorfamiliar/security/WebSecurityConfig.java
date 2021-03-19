package ar.gob.siliconmisiones.organizadorfamiliar.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Para que autorice las peticiones. Por la api tenes los permisos, por la web
        // requiere autenticación para todas las páginas, excepto para login y logout.
        //http.authorizeRequests().antMatchers("/api/**").permitAll()
        http.authorizeRequests().antMatchers("/**").authenticated()
            .and()
                .formLogin().loginPage("/login").permitAll()
            .and()
                .logout().permitAll();

    }

}
