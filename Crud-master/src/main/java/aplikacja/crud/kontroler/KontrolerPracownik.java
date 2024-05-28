package aplikacja.crud.kontroler;

import aplikacja.crud.pawilon.Pawilon;
import aplikacja.crud.repozytorium.RepozytoriumPracownik;
import aplikacja.crud.repozytorium.RepozytoriumStanowisko;
import aplikacja.crud.pracownik.Pracownik;

import aplikacja.crud.stanowisko.Stanowisko;
import aplikacja.crud.zwierze.Zwierze;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Controller
public class KontrolerPracownik {

    private final RepozytoriumPracownik repozytoriumPracownik;
    private final RepozytoriumStanowisko repozytoriumStanowisko;

    @Autowired
    public KontrolerPracownik(RepozytoriumPracownik repozytoriumPracownik,
                              RepozytoriumStanowisko repozytoriumStanowisko) {
        this.repozytoriumPracownik = repozytoriumPracownik;
        this.repozytoriumStanowisko = repozytoriumStanowisko;
    }

    @GetMapping("/pracownik")
    public String showPracownikList(Model model) {
        List<Pracownik> pracownikList = repozytoriumPracownik.findAll();
        model.addAttribute("pracownikList", pracownikList);
        return "pracownikList";
    }

    @GetMapping("/pracownik/new")
    public String newPracownik(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik", pracownik);
        model.addAttribute("listaStanowisko", repozytoriumStanowisko.findAll());
        return "newPracownik";
    }

    @PostMapping("/savePracownik")
    public String savePracownik(@ModelAttribute Pracownik pracownik) {
        repozytoriumPracownik.saveAndFlush(pracownik);
        return "redirect:/pracownik";
    }

    @GetMapping("/pracownik/edit/{id_pracownika}")
    public String editPracownik(@PathVariable("id_pracownika") Integer id_pracownika, Model model) {
        Pracownik pracownik = repozytoriumPracownik.findById(id_pracownika).orElseThrow(() -> new IllegalArgumentException("Invalid pracownik Id:" + id_pracownika));
        model.addAttribute("pracownik", pracownik);
        model.addAttribute("listaStanowisko", repozytoriumStanowisko.findAll());
        return "editPracownik";
    }

    @PostMapping("/pracownik/update/{id_pracownika}")
    public String updatePracownik(@PathVariable("id_pracownika") Integer id_pracownika, @ModelAttribute Pracownik pracownik, Model model) {
            Pracownik existingPracownik = repozytoriumPracownik.findById(id_pracownika)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid pracownik id: " + id_pracownika));
        existingPracownik.setData_zatrudnienia(pracownik.getData_zatrudnienia());
        existingPracownik.setStanowisko(pracownik.getStanowisko());
        existingPracownik.setImie(pracownik.getImie());
        existingPracownik.setNazwisko(pracownik.getNazwisko());
        repozytoriumPracownik.save(existingPracownik);
        return "redirect:/pracownik";
    }

    @GetMapping("/deletePracownik/{id}")
    public String deletePracownik(@PathVariable Integer id) {
        repozytoriumPracownik.deleteById(id);
        return "redirect:/pracownik";
    }
}