package ma.enset.ap_etud.web;

import lombok.AllArgsConstructor;
import ma.enset.ap_etud.entities.Etudiant;
import ma.enset.ap_etud.repositories.EtudiantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class EtudiantController {
    private EtudiantRepository etudiantRepository;
    @GetMapping(path = "/etudiants")
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

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/user/index")
    public String etudiants2(Model model,
                             @RequestParam(name = "page",defaultValue = "0") int page,
                             @RequestParam(name = "size",defaultValue = "6") int size,
                             @RequestParam(name = "keyword",defaultValue = "")String keyword){
        Page<Etudiant> page_etudiants = etudiantRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("etudiants",page_etudiants.getContent());
        model.addAttribute("pages", new int[page_etudiants.getTotalPages()]);
        model.addAttribute("keyword",keyword);
        model.addAttribute("pageActuelle",page);
        model.addAttribute("etudiant",new Etudiant());
        return "etudiants2";
    }

    @GetMapping(value = "/admin/delete")
    public String delete(@RequestParam(value = "id") Long id, @RequestParam(value = "keyword") String keyword, @RequestParam(value = "page") int page){
        etudiantRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @PostMapping(path = "/admin/save")
    public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "editEtudiant";
        etudiantRepository.save(etudiant);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editEtudiant")
    public String editEtudiant(Model model, Long id, String keyword, int page){
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if(etudiant==null) throw new RuntimeException("Patient introuvable");
        model.addAttribute("etudiant",etudiant);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editEtudiant";
    }
}
