package za.ac.cput.Controller;
/*
 * Author: GAYNOR JANTJIES 213069555
 * POJO RestaurantController.java
 *  Restaurant Controller file to be implemented
 * Created: 21/08/2022
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Restaurant;
import za.ac.cput.Factory.RestaurantFactory;
import za.ac.cput.Service.Interface.RestaurantService;

import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("restaurants", service.getAll());
        return "restaurantHome";
    }
    @GetMapping("/home/customers")
    public String homeC(Model model) {
        model.addAttribute("restaurants", service.getAll());
        return "RestaurantCustomer";
    }

    @GetMapping("/create")
    public String getCreateForm(@ModelAttribute("restaurant") Restaurant restaurant){
        return "restaurantAdd";
    }


    @PostMapping(value = "/create")
    public String create (@ModelAttribute("restaurant") Restaurant restaurant, BindingResult result)
    {
        if (result.hasErrors())
            return "restaurantAdd";
        Restaurant newRestaurant = RestaurantFactory.buildRestaurant(
                restaurant.getRestaurantId(),
                restaurant.getRestaurantName(),
                restaurant.getRestaurantLocation()
        );
        service.create(newRestaurant);
        return "redirect:/restaurant/home";
    }
    @GetMapping(value = "/read/{restaurantId}")
    public Restaurant read(@PathVariable String restaurantId) {
        return service.read(restaurantId);
    }

    @GetMapping("/update/{restaurantId}")
    public String getUpdateForm(@PathVariable("restaurantId") String restaurantId, Model model) {
        Restaurant restaurant = service.read(restaurantId);
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

    @DeleteMapping(value = "/delete/{restaurantId}")
    public boolean delete(@PathVariable(value = "restaurantId") String restaurantId) {
        return service.delete(restaurantId);
    }

    @GetMapping("/delete/{restaurantId}")
    public String delete(@PathVariable("restaurantId") String restaurantId, Model model) {
        service.delete(restaurantId);
        model.addAttribute("restaurants", service.getAll());
        return "redirect:/restaurant/home";
    }

    @GetMapping(value = "/all")
    public List<Restaurant> getAll() {
        return service.getAll();
    }
}
