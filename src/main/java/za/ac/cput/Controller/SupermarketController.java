package za.ac.cput.Controller;
/*
 * Author: GAYNOR JANTJIES 213069555
 * POJO SupermarketController.java
 *  Supermarket Controller file to be implemented
 * Created: 21/08/2022
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Supermarket;
import za.ac.cput.Service.Interface.SupermarketService;

import java.util.Set;

@Controller
@RequestMapping("/supermarket")
public class SupermarketController {

    @Autowired
    private SupermarketService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("supermarkets", service.getAll());
        return "supermarket";
    }
    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("supermarketsmenu", service.getAll());
        return "supermarketMenu";
    }

    @GetMapping("/create")
    public String getCreateForm(Supermarket supermarket) {
        return "supermarketAdd";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Supermarket supermarket, BindingResult result, Model model) {
        if (result.hasErrors())
            return "supermarketAdd";
        service.create(supermarket);
        return "redirect:/supermarket/home";
    }

    @GetMapping(value = "/read/{id}")
    public Supermarket read(@PathVariable String id) {

        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        Supermarket supermarket = service.read(id);
        model.addAttribute("supermarket", supermarket);
        return "supermarketUpdate";
    }

    @PostMapping("/update")
    public String update(Supermarket supermarket, BindingResult result, Model model) {
        if (result.hasErrors())
            return "supermarketUpdate";
        service.update(supermarket);
        return "redirect:/supermarket/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        service.delete(id);
        model.addAttribute("supermarkets", service.getAll());
        return "redirect:/supermarket/home";
    }

    @GetMapping(value = "/all")
    public Set<Supermarket> getAll() {
        return service.getAll();
    }
}
