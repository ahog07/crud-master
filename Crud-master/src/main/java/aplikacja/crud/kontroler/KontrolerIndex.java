package aplikacja.crud.kontroler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KontrolerIndex {

    @GetMapping("/")
    public String home() {
        return "index"; // Nazwa pliku HTML bez rozszerzenia
    }
}