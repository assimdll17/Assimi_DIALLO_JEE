package ma.enset.ap_etud.web;

import lombok.AllArgsConstructor;
import ma.enset.ap_etud.sec.entities.AppUser;
import ma.enset.ap_etud.sec.repositories.AppUserRepository;
import ma.enset.ap_etud.sec.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SecurityController {
    @Autowired
    private SecurityService securityService;

    @GetMapping("/403")
    public String notAuthorized(){
        return "403";
    }

    @GetMapping("/inscription")
    public String inscription(Model model){
        model.addAttribute("appUser",new AppUser());
        return "inscription";
    }

    @PostMapping(path = "/saveuser")
    public String save(Model model, @Valid AppUser appUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "inscription";
        securityService.saveNewUser(appUser.getUsername(),appUser.getPassword(),appUser.getPassword());
        securityService.addRoleToUser(appUser.getUsername(),"USER");
       // appUserRepository.save(appUser);
        return "redirect:/login";
    }
}
