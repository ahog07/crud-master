//package aplikacja.crud.bezpieczenstwo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class Bezpieczenstwo {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests( //konfiguruje zabezpieczenia HTTP dla aplikacji
//                auth -> auth
//                        .requestMatchers(HttpMethod.POST,"/checkPass").permitAll()
//                        .requestMatchers("/secRole1").hasAuthority("ROLE_USER")
//                        .requestMatchers("/secRole2").hasAuthority("ROLE_ADMIN")
//                        .anyRequest().authenticated()
//
//        ) ;
//        http.csrf(csrf -> csrf.disable());
//        http.addFilterBefore(new Token(), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//}
