//package aplikacja.crud.bezpieczenstwo;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Token extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        String header = request.getHeader("Authorization");
//
//        if (header != null && header.startsWith("Bearer ")) {
//            String token = header.substring(7);
//            try {
//                DecodedJWT jwt = JWT.require(Algorithm.HMAC256("secret"))
//                        .build()
//                        .verify(token);
//                List<String> roles = jwt.getClaim("roles").asList(String.class);
//                List<SimpleGrantedAuthority> authorities = roles.stream()
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                        jwt.getSubject(), null, authorities);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            } catch (Exception e) {
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Nieautoryzowany dostęp");
//                return;
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
