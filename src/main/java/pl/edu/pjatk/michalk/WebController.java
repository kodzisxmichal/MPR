package pl.edu.pjatk.michalk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private final CatService service;

    public WebController(CatService service) {
        this.service = service;
    }

    @GetMapping(value = "/welcome")
    public String getWelcomeView(){return "welcome";}

    @GetMapping(value = "/viewAll")
    public String getViewAll(Model model){
        model.addAttribute("cats",service.findAll());
        return "viewAll";
    }

}
