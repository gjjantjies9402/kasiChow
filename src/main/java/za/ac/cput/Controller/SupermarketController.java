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
import za.ac.cput.Factory.SupermarketFactory;
import za.ac.cput.Service.Interface.SupermarketService;

import java.util.List;

@Controller
@RequestMapping("/supermarket")
public class SupermarketController {

    @Autowired
    private SupermarketService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("supermarkets", service.getAll());
        return "supermarketHome";
    }
    @GetMapping("/create")
    public String getCreateForm(@ModelAttribute("supermarket") Supermarket supermarket) {
        return "supermarketAdd";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute("supermarket") Supermarket supermarket, BindingResult result, Model model) {
        if (result.hasErrors())
            return "supermarketAdd";
        Supermarket newSupermarket = SupermarketFactory.buildSupermarket(
                supermarket.getMarketId(),
                supermarket.getMarketName(),
                supermarket.getMarketLocation()
        );
        service.create(newSupermarket);
        return "redirect:/supermarket/home";
    }

    @GetMapping(value = "/read/{marketId}")
    public Supermarket read(@PathVariable String marketId) {

        return service.read(marketId);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("marketId") String marketId, Model model) {
        Supermarket supermarket = service.read(marketId);
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

    @DeleteMapping(value = "/delete/{marketId}")
    public boolean delete(@PathVariable String marketId) {
        return service.delete(marketId);
    }

    @GetMapping("/delete/{marketId}")
    public String delete(@PathVariable("marketId") String id, Model model) {
        service.delete(id);
        model.addAttribute("supermarkets", service.getAll());
        return "redirect:/supermarket/home";
    }

    @GetMapping(value = "/all")
    public List<Supermarket> getAll() {
        return service.getAll();
    }
}
