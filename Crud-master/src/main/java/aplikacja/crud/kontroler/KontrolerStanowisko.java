package aplikacja.crud.kontroler;

import aplikacja.crud.repozytorium.RepozytoriumStanowisko;
import aplikacja.crud.stanowisko.Stanowisko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KontrolerStanowisko {
    private final RepozytoriumStanowisko repozytoriumStanowisko;

    @Autowired
    public KontrolerStanowisko(RepozytoriumStanowisko repozytoriumStanowisko) {
        this.repozytoriumStanowisko = repozytoriumStanowisko;
    }

    @GetMapping("/Stanowisko")
    public String showStanowiskoList(Model model) {
        List<Stanowisko> stanowiskoList = repozytoriumStanowisko.findAll();
        model.addAttribute("stanowiskoList", stanowiskoList);
        return "stanowiskoList";
    }

    @GetMapping("/deleteStanowisko/{id}")
    public String deleteStanowisko(@PathVariable Integer id) {
        repozytoriumStanowisko.deleteById(id);
        return "redirect:/Stanowisko";
    }

    @GetMapping ("/newStanowisko")
    public String newStanowisko(Model model) {
        Stanowisko stanowisko = new Stanowisko();
        model.addAttribute("stanowisko", stanowisko);
        return "newStanowisko";
    }

    @PostMapping("/saveStanowisko")
    public String saveStanowisko(@ModelAttribute Stanowisko stanowisko, Model model) {
        if (repozytoriumStanowisko.existsByNazwa(stanowisko.getNazwa())) {
            model.addAttribute("errorMessage", "Nazwa stanowiska już istnieje.");
            return "newStanowisko";
        }
        repozytoriumStanowisko.saveAndFlush(stanowisko);
        return "redirect:/Stanowisko";
    }

    @GetMapping("/editStanowisko/{id_stanowiska}")
    public String showEditStanowiskoForm(@PathVariable("id_stanowiska") Integer id_stanowiska, Model model) {
        Stanowisko stanowisko = repozytoriumStanowisko.findById(id_stanowiska)
                .orElseThrow(() -> new IllegalArgumentException("Invalid stanowisko id: " + id_stanowiska));
        model.addAttribute("stanowisko", stanowisko);
        return "editStanowisko";
    }


    @PostMapping("/updateStanowisko/{id_stanowiska}")
    public String updateStanowisko(@PathVariable("id_stanowiska") Integer id_stanowiska, @ModelAttribute Stanowisko stanowisko, Model model) {
        Stanowisko existingStanowisko = repozytoriumStanowisko.findById(id_stanowiska)
                .orElseThrow(() -> new IllegalArgumentException("Invalid stanowisko id: " + id_stanowiska));

        if (!existingStanowisko.getNazwa().equals(stanowisko.getNazwa()) && repozytoriumStanowisko.existsByNazwa(stanowisko.getNazwa())) {
            model.addAttribute("errorMessage", "Nazwa stanowiska już istnieje.");
            return "editStanowisko";
        }

        existingStanowisko.setNazwa(stanowisko.getNazwa());
        repozytoriumStanowisko.save(existingStanowisko);
        return "redirect:/Stanowisko";
    }


}
