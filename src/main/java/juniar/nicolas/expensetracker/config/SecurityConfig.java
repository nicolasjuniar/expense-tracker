package juniar.nicolas.expensetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // disable CSRF biar bisa test pakai Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // allow register/login tanpa auth
                        .anyRequest().authenticated() // yang lain tetap butuh auth
                )
                .httpBasic(httpBasic -> {}); // biarkan basic auth aktif sementara

        return http.build();
    }
}
