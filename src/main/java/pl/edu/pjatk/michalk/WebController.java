package pl.edu.pjatk.michalk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping(value ="/addCat")
    public String getAddCat(Model model){
        model.addAttribute("cat", new Cat("",0));
        return "addCat";
    }

    @PostMapping(value = "/addCat")
    public String addCat(Cat cat, Model model, RedirectAttributes redirectAttributes){
        if(cat.getName().isEmpty()){
            model.addAttribute("Error Message","Name is empty");
            return "addCat";
        }
        if(cat.getAge().describeConstable().isEmpty()){
            model.addAttribute("Error Message", "Age is empty");
            return "addCat";
        }
        if(cat.getAge()<0){
            model.addAttribute("Error Message", "Age is lower than 0");
            return "addCat";
        }

        service.add(cat);
        redirectAttributes.addFlashAttribute("successMessage", "Cat added");
        return "redirect:/viewAll";
    }

    @GetMapping(value = "/updateCat")
    public String getUpdateCat(Model model){
        model.addAttribute("cat", new Cat("",0));
        return "updateCat";
    }

    @PostMapping(value = "/updateCat")
    public String updateCat(Cat cat, Model model, RedirectAttributes redirectAttributes){
        if(cat.getId().describeConstable().isEmpty()){
            model.addAttribute("Error Message", "ID is empty");
            return "updateCat";
        }
        if(cat.getAge()<0){
            model.addAttribute("Error Message", "Age is lower than 0");
            return "updateCat";
        }

        service.update(cat);
        redirectAttributes.addFlashAttribute("successMessage", "Cat updated");
        return "redirect:/viewAll";
    }

    @GetMapping(value = "/deleteCat")
    public String getDeleteCat(Model model){
        model.addAttribute("cat", new Cat("",0));
        return "deleteCat";
    }

    @PostMapping(value = "/deleteCat")
    public String deleteCat(Cat cat, Model model, RedirectAttributes redirectAttributes){
        if(cat.getId().describeConstable().isEmpty()){
            model.addAttribute("Error Message", "ID is empty");
            return "deleteCat";
        }

        service.delete(cat.getId());
        redirectAttributes.addFlashAttribute("successMessage", "Cat deleted");
        return "redirect:/viewAll";
    }

}
