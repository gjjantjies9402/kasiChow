//package za.ac.cput.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import za.ac.cput.Entity.MenuItem;
//import za.ac.cput.Service.impl.MenuItemService;
//import java.util.Set;
//
//@Controller
//@RequestMapping("/orderItem")
//public class MenuItemController {
//
//    @Autowired
//    private MenuItemService service;
//
//    @GetMapping("/home")
//    public String home(Model model) {
//        model.addAttribute("menuItems", service.getAll());
//        return "menuItemsHome";
//    }
//
//    @GetMapping("/create")
//    public String create(@ModelAttribute MenuItem menuItem, BindingResult result, Model model) {
//        if (result.hasErrors())
//            return "menuItemAdd";
//        service.create(menuItem);
//        return "redirect:/menuItem/home";
//    }
//
//    @GetMapping(value = "/read/{id}")
//    public MenuItem read (@PathVariable String id) {return service.read(id);}
//
//    @GetMapping("/update/{id}")
//    public String getUpdateForm(@PathVariable("id") String id, Model model) {
//        MenuItem menuItem = service.read(id);
//        model.addAttribute("menuItem", menuItem);
//        return "menuItemUpdate";
//    }
//
//    @PostMapping("/update")
//    public String update(MenuItem menuItem, BindingResult result, Model model) {
//        if (result.hasErrors())
//            return "menuItemUpdate";
//        service.update(menuItem);
//        return "redirect:/menuItem/home";
//    }
//
//    @DeleteMapping(value = "/delete/{id}")
//    public boolean delete(@PathVariable String id) {return service.delete(id);}
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") String id, Model model) {
//        service.delete(id);
//        model.addAttribute("menuItems", service.getAll());
//        return "redirect:/menuItem/home";
//    }
//
//    @GetMapping(value = "/all")
//    public Set<MenuItem> getAll() {return service.getAll();}
//}
//
