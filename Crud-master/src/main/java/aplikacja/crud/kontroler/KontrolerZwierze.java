package aplikacja.crud.kontroler;

import aplikacja.crud.zwierze.Zwierze;
import aplikacja.crud.repozytorium.RepozytoriumZwierze;
import aplikacja.crud.repozytorium.RepozytoriumGatunek;
import aplikacja.crud.repozytorium.RepozytoriumPawilon;
import aplikacja.crud.repozytorium.RepozytoriumPracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KontrolerZwierze {

    private final RepozytoriumZwierze repozytoriumZwierze;
    private final RepozytoriumGatunek repozytoriumGatunek;
    private final RepozytoriumPawilon repozytoriumPawilon;
    private final RepozytoriumPracownik repozytoriumPracownik;

    @Autowired
    public KontrolerZwierze(RepozytoriumZwierze repozytoriumZwierze,
                            RepozytoriumGatunek repozytoriumGatunek,
                            RepozytoriumPawilon repozytoriumPawilon,
                            RepozytoriumPracownik repozytoriumPracownik) {
        this.repozytoriumZwierze = repozytoriumZwierze;
        this.repozytoriumGatunek = repozytoriumGatunek;
        this.repozytoriumPawilon = repozytoriumPawilon;
        this.repozytoriumPracownik = repozytoriumPracownik;
    }

    @GetMapping("/Zwierze")
    public String showZwierzeList(Model model) {
        List<Zwierze> zwierzeList = repozytoriumZwierze.findAll();
        model.addAttribute("zwierzeList", zwierzeList);
        return "zwierzeList";
    }

    @GetMapping("/deleteZwierze/{id}")
    public String deleteZwierze(@PathVariable Integer id) {
        repozytoriumZwierze.deleteById(id);
        return "redirect:/Zwierze";
    }

    @GetMapping("/newZwierze")
    public String newZwierze(Model model) {
        Zwierze zwierze = new Zwierze();
        model.addAttribute("zwierze", zwierze);
        model.addAttribute("listaGatunkow", repozytoriumGatunek.findAll());
        model.addAttribute("listaPawilon", repozytoriumPawilon.findAll());
        model.addAttribute("listaPracownik", repozytoriumPracownik.findAll());
        return "newZwierze";
    }

    @PostMapping("/saveZwierze")
    public String saveZwierze(@ModelAttribute Zwierze zwierze) {
        repozytoriumZwierze.saveAndFlush(zwierze);
        return "redirect:/Zwierze";
    }

    @GetMapping("/editZwierze/{id_zwierzaka}")
    public String showEditZwierzeForm(@PathVariable("id_zwierzaka") Integer id_zwierzaka, Model model) {
        Zwierze zwierze = repozytoriumZwierze.findById(id_zwierzaka)
                .orElseThrow(() -> new IllegalArgumentException("Invalid zwierze id: " + id_zwierzaka));
        model.addAttribute("zwierze", zwierze);
        model.addAttribute("listaGatunkow", repozytoriumGatunek.findAll());
        model.addAttribute("listaPracownik", repozytoriumPracownik.findAll());
        model.addAttribute("listaPawilon", repozytoriumPawilon.findAll());
        return "editZwierze";
    }

    @PostMapping("/updateZwierze/{id_zwierzaka}")
    public String updateZwierze(@PathVariable("id_zwierzaka") Integer id_zwierzaka, @ModelAttribute Zwierze zwierze, Model model) {
        Zwierze existingZwierze = repozytoriumZwierze.findById(id_zwierzaka)
                .orElseThrow(() -> new IllegalArgumentException("Invalid zwierze id: " + id_zwierzaka));

        existingZwierze.setImie(zwierze.getImie());
        existingZwierze.setGatunek(zwierze.getGatunek());
        existingZwierze.setPracownik(zwierze.getPracownik());
        existingZwierze.setWiekM(zwierze.getWiekM());
        existingZwierze.setPlec(zwierze.getPlec());
        existingZwierze.setPawilon(zwierze.getPawilon());
        repozytoriumZwierze.save(existingZwierze);
        return "redirect:/Zwierze";
    }
}
