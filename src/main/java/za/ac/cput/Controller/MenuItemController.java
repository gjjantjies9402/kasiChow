package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.MenuItem;
import za.ac.cput.Factory.MenuItemFactory;
import za.ac.cput.Service.impl.MenuItemService;
import java.util.Set;
//
//@Controller
@RestController
@RequestMapping("/menuItem")
public class MenuItemController {
//
    @Autowired
    private MenuItemService service;

    @PostMapping("/create")
public MenuItem create (@RequestBody MenuItem menuItem) {
    MenuItem newMenuItem = MenuItemFactory.createMenuItem (
            menuItem.getItemID(),
            menuItem.getMenuCategory(),
            menuItem.getItemName(),
            menuItem.getItemPrice()

    );
    return service.create(newMenuItem);
}

//
    @GetMapping(value = "/read/{id}")
    public MenuItem read (@PathVariable String id) {return service.read(id);}
//
    @GetMapping("/update")
    public MenuItem update(@RequestBody MenuItem menuItem) {
        MenuItem update = service.update(menuItem);

        return update;
    }

//
    @DeleteMapping(value = "/delete/{id}")
    public boolean delete (@PathVariable(value = "Id") String Id)
    {
        return service.delete(Id);
    }

//
    @GetMapping(value = "/all")
    public Set<MenuItem> getAll() {return service.getAll();}
}
//
