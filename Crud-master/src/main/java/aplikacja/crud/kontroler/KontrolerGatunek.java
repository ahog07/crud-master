package aplikacja.crud.kontroler;

import aplikacja.crud.gatunek.Gatunek;
import aplikacja.crud.pawilon.Pawilon;
import aplikacja.crud.repozytorium.RepozytoriumGatunek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KontrolerGatunek {

    private final RepozytoriumGatunek repozytoriumGatunek;

    @Autowired
    public KontrolerGatunek(RepozytoriumGatunek repozytoriumGatunek) {
        this.repozytoriumGatunek = repozytoriumGatunek;
    }

    @GetMapping("/Gatunek")
    public String showGatunekList(Model model) {
        List<Gatunek> gatunekList = repozytoriumGatunek.findAll();
        model.addAttribute("gatunekList", gatunekList);
        return "gatunekList";
    }

    @GetMapping("/deleteGatunek/{id}")
    public String deleteGatunek(@PathVariable Integer id) {
        repozytoriumGatunek.deleteById(id);
        return "redirect:/Gatunek";
    }

    @GetMapping ("/newGatunek")
    public String newGatunek(Model model) {
        Gatunek gatunek = new Gatunek();
        model.addAttribute("gatunek", gatunek);
        return "newGatunek";
    }

    @PostMapping("/saveGatunek")
    public String saveGatunek(@ModelAttribute Gatunek gatunek, Model model) {
        if (repozytoriumGatunek.existsByNazwa(gatunek.getNazwa())) {
            model.addAttribute("errorMessage", "Nazwa gatunku już istnieje, wybierz inną.");
        }
        repozytoriumGatunek.saveAndFlush(gatunek);
        return "redirect:/Gatunek";
    }

    @GetMapping("/editGatunek/{id_gatunku}")
    public String showEditGatunekForm(@PathVariable("id_gatunku") Integer id_gatunku, Model model) {
        Gatunek gatunek = repozytoriumGatunek.findById(id_gatunku)
                .orElseThrow(() -> new IllegalArgumentException("Invalid gatunek id: " + id_gatunku));
        model.addAttribute("gatunek", gatunek);
        return "editGatunek";
    }

    @PostMapping("/updateGatunek/{id_gatunku}")
    public String updateGatunek(@PathVariable("id_gatunku") Integer id_gatunku, @ModelAttribute Gatunek gatunek, Model model) {
        Gatunek existingGatunek = repozytoriumGatunek.findById(id_gatunku)
                .orElseThrow(() -> new IllegalArgumentException("Invalid gatunek id: " + id_gatunku));
        existingGatunek.setNazwa(gatunek.getNazwa());
        repozytoriumGatunek.save(existingGatunek);
        return "redirect:/Gatunek";
    }


}


