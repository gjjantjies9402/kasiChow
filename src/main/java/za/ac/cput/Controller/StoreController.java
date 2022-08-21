package za.ac.cput.Controller;
/*
 * Author: GAYNOR JANTJIES 213069555
 * POJO StoreController.java
 *  Store Controller file to be implemented
 * Created: 21/08/2022
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Store;
import za.ac.cput.Service.Interface.StoreService;

import java.util.Set;


@Controller
@RequestMapping("/store")
public class StoreController {


    @Autowired
    private StoreService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("stores", service.getAll());
        return "storesHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Store store) {
        return "storeAdd";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Store store, BindingResult result, Model model) {
        if (result.hasErrors())
            return "storeAdd";
        service.create(store);
        return "redirect:/store/home";
    }

    @GetMapping(value = "/read/{id}")
    public Store read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        Store store = service.read(id);
        model.addAttribute("store", store);
        return "storeUpdate";
    }

    @PostMapping("/update")
    public String update(Store store, BindingResult result, Model model) {
        if (result.hasErrors())
            return "storeUpdate";
        service.update(store);
        return "redirect:/store/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        service.delete(id);
        model.addAttribute("stores", service.getAll());
        return "redirect:/store/home";
    }

    @GetMapping(value = "/all")
    public Set<Store> getAll() {
        return service.getAll();
    }
}

