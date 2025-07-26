package blog.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                                .requestMatchers(HttpMethod.GET, "/users").permitAll()
                                .requestMatchers(HttpMethod.GET, "/users/{id}").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/users").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/users/{id}").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/usuarios").authenticated() // Listar requer autenticação
//                        .requestMatchers("/api/usuarios/**").hasRole("ADMIN") // Endpoints específicos para ADMIN
                        .anyRequest().authenticated() // Todas outras requisições exigem autenticação
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Para API REST
                );
//                .addFilterBefore(new JwtTokenFilter(), UsernamePasswordAuthenticationFilter.class); // Se for usar JWT depois

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
