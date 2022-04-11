package ma.enset.ap_etud.web;

import lombok.AllArgsConstructor;
import ma.enset.ap_etud.entities.Etudiant;
import ma.enset.ap_etud.repositories.EtudiantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class EtudiantController {
    private EtudiantRepository etudiantRepository;
    @GetMapping(path = "/index")
    public String etudiants(Model model,
                            @RequestParam(name = "page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "10") int size,
                            @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Etudiant> page_etudiants = etudiantRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("etudiants",page_etudiants.getContent());
        model.addAttribute("pages", new int[page_etudiants.getTotalPages()]);
        model.addAttribute("keyword",keyword);
        model.addAttribute("pageActuelle",page);
        return "etudiants";
    }

    @DeleteMapping(value = "/delete/{id}/{kw}/{page}")
    public String delete(@PathVariable Long id, @PathVariable String kw, @PathVariable int page){
        etudiantRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+kw;
    }
}
