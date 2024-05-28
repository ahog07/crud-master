package aplikacja.crud.kontroler;

import aplikacja.crud.pawilon.Pawilon;
import aplikacja.crud.repozytorium.RepozytoriumPawilon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KontrolerPawilon {

    private final RepozytoriumPawilon repozytoriumPawilon;

    @Autowired
    public KontrolerPawilon(RepozytoriumPawilon repozytoriumPawiolon) {
        this.repozytoriumPawilon = repozytoriumPawiolon;
    }

    @GetMapping("/Pawilon")
    public String showPawilonList(Model model) {
        List<Pawilon> pawilonList = repozytoriumPawilon.findAll();
        model.addAttribute("pawilonList", pawilonList);
        return "pawilonList";
    }

    @GetMapping("/deletePawilon/{id}")
    public String deletePawilon(@PathVariable Integer id) {
        repozytoriumPawilon.deleteById(id);
        return "redirect:/Pawilon";
    }

    @GetMapping ("/newPawilon")
    public String newPawilon(Model model) {
        Pawilon pawilon = new Pawilon();
        model.addAttribute("pawilon", pawilon);
        return "newPawilon";
    }

    @PostMapping("/savePawilon")
    public String savePawilon(@ModelAttribute Pawilon pawilon, Model model) {
        if (repozytoriumPawilon.existsByNazwa(pawilon.getNazwa())) {
            model.addAttribute("errorMessage", "Nazwa pawilonu już istnieje.");
            return "newPawilon";  // lub inna nazwa szablonu formularza
        }
        repozytoriumPawilon.saveAndFlush(pawilon);
        return "redirect:/Pawilon";
    }

    @GetMapping("/editPawilon/{id_pawilonu}")
    public String showEditPawilonForm(@PathVariable("id_pawilonu") Integer id_pawilonu, Model model) {
        Pawilon pawilon = repozytoriumPawilon.findById(id_pawilonu)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pawilon id: " + id_pawilonu));
        model.addAttribute("pawilon", pawilon);
        return "editPawilon";
    }


    @PostMapping("/updatePawilon/{id_pawilonu}")
    public String updatePawilon(@PathVariable("id_pawilonu") Integer id_pawilonu, @ModelAttribute Pawilon pawilon, Model model) {
        Pawilon existingPawilon = repozytoriumPawilon.findById(id_pawilonu)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pawilon id: " + id_pawilonu));

        if (!existingPawilon.getNazwa().equals(pawilon.getNazwa()) && repozytoriumPawilon.existsByNazwa(pawilon.getNazwa())) {
            model.addAttribute("errorMessage", "Nazwa pawilonu już istnieje.");
            return "editPawilon";  // lub inna nazwa szablonu formularza edycji
        }
        existingPawilon.setNazwa(pawilon.getNazwa());
        repozytoriumPawilon.save(existingPawilon);
        return "redirect:/Pawilon";
    }


}


