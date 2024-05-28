//package aplikacja.crud.kontroler;
//
//import aplikacja.crud.repozytorium.RepozytoriumUzytkownik;
//import aplikacja.crud.bezpieczenstwo.Uzytkownik;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Arrays;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@RestController
//public class KontrolerJwt {
//
//
//    /*
//
//    https://emn178.github.io/online-tools/sha256.html
//
//    localhost:8080/checkPass
//
//    {
//    "username":"Jan",
//    "password":"haslo123"
//    }
//
//    {
//    "username":"Anna",
//    "password":"haslo456"
//    }
//
//    */
//
//
//    @Autowired
//    private RepozytoriumUzytkownik repozytoriumUzytkownik;
//
//    @GetMapping("/uzytkownicy")
//    public List<Uzytkownik> getAllUsers() {
//        return repozytoriumUzytkownik.findAll();
//    }
//
//    @PostMapping("/checkPass")
//    public String checkPass(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
//
//
//
//        String username = body.get("imie");
//        String password = body.get("haslo");
//
//
//        Uzytkownik user = repozytoriumUzytkownik.findByUsername(username);
//
//        if (user != null && user.getPassword().equals(hashPassword(password))) {
//            List<String> roles = Arrays.asList(user.getRole().split(","));
//            String token = generateJwtToken(user.getUsername(), roles);
//            return token;
//        }
//
//        return "Brak danych";
//
//    }
//    private String generateJwtToken(String username, List<String> roles) {
//        String token = JWT.create()
//                .withIssuer(username)
//                .withArrayClaim("roles", roles.toArray(new String[0]))
//                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1 godzina ważności
//                .sign(Algorithm.HMAC256("secret"));
//        return token;
//    }
//
//    public static String hashPassword(String password) throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        byte[] hash = md.digest(password.getBytes());
//        StringBuilder sb = new StringBuilder();
//        for (byte b : hash) {
//            sb.append(String.format("%02x", b));
//        }
//        return sb.toString();
//    }
//
//    @GetMapping("/secRole1")
//    public String secRole1() {
//        return "Dostęp do secRole1 dla ROLE_USER";
//    }
//
//    @GetMapping("/secRole2")
//    public String secRole2() {
//        return "Dostęp do secRole2 dla ROLE_ADMIN";
//    }
//
//
//
//}
