package za.ac.cput.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Service.Interface.RestaurantService;

import java.util.Set;

@Controller
@RequestMapping("/restaurant")
public class ResturantController {

    @Autowired
    private RestaurantService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("restaurants", service.getAll());
        return "restaurantsHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Restaurant store) {
        return "restaurantAdd";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Restaurant restaurant, BindingResult result, Model model) {
        if (result.hasErrors())
            return "restaurantAdd";
        service.create(restaurant);
        return "redirect:/restaurant/home";
    }

    @GetMapping(value = "/read/{id}")
    public Restaurant read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        Restaurant restaurant = service.read(id);
        model.addAttribute("restaurant", restaurant);
        return "restaurantUpdate";
    }

    @PostMapping("/update")
    public String update(Restaurant restaurant, BindingResult result, Model model) {
        if (result.hasErrors())
            return "restaurantUpdate";
        service.update(restaurant);
        return "redirect:/restaurant/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        service.delete(id);
        model.addAttribute("restaurants", service.getAll());
        return "redirect:/restaurant/home";
    }

    @GetMapping(value = "/all")
    public Set<Restaurant> getAll() {
        return service.getAll();
    }
}
