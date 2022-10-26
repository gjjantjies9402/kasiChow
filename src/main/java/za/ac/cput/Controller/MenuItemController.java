package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.MenuItem;
import za.ac.cput.Factory.MenuItemFactory;
import za.ac.cput.Service.impl.MenuItemService;
import java.util.Set;
//

@Controller
@RestController
@RequestMapping("/menuItem")
public class MenuItemController {
//
    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("menuItems", menuItemService.getAll());
        return "menuItemsHome";
    }


    @PostMapping("/create")
public MenuItem create (@RequestBody MenuItem menuItem) {
    MenuItem newMenuItem = MenuItemFactory.createMenuItem (
            menuItem.getItemID(),
            menuItem.getMenuCategory(),
            menuItem.getItemName(),
            menuItem.getItemPrice()

    );
    return menuItemService.create(newMenuItem);
}

    @GetMapping("/create")
    public String create(@ModelAttribute MenuItem menuItem, BindingResult result, Model model) {
        if (result.hasErrors())
            return "menuItemAdd";
        menuItemService.create(menuItem);
        return "redirect:/menuItem/home";
    }

//
    @GetMapping(value = "/read/{id}")
    public MenuItem read (@PathVariable String id) {return menuItemService.read(id);}
//
    @GetMapping("/update")
    public MenuItem update(@RequestBody MenuItem menuItem) {
        MenuItem update = menuItemService.update(menuItem);

        return update;
    }

    @PostMapping("/update")
    public String update(MenuItem menuItem, BindingResult result, Model model) {
        if (result.hasErrors())
            return "menuItemUpdate";
        menuItemService.update(menuItem);
        return "redirect:/menuItem/home";
    }

//
    @DeleteMapping(value = "/delete/{id}")
    public boolean delete (@PathVariable(value = "Id") String Id)
    {
        return menuItemService.delete(Id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        menuItemService.delete(id);
        model.addAttribute("menuItems", menuItemService.getAll());
        return "redirect:/menuItem/home";
    }

//
    @GetMapping(value = "/all")
    public Set<MenuItem> getAll() {return menuItemService.getAll();}
}
//
