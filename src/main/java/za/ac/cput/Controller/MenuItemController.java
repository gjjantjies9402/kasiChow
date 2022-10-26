package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.MenuItem;
import za.ac.cput.Entity.OrderItem;
import za.ac.cput.Factory.MenuItemFactory;
import za.ac.cput.Factory.OrderItemFactory;
import za.ac.cput.Service.impl.MenuItemService;
import za.ac.cput.Service.impl.OrderItemService;

import java.util.List;
//
@Controller
//@RestController
@RequestMapping("/menuItem")
public class MenuItemController {
//
    @Autowired
    private MenuItemService service;
    @Autowired
    private OrderItemService orderService;

    @GetMapping("/restaurant")
    public String restaurant(Model model) {
        model.addAttribute("menuItems", service.getAll());
        return "menuItemR";
    }
    @GetMapping("/supermarket")
    public String supermarket(Model model) {
        model.addAttribute("menuItems", service.getAll());
        return "menuItemS";
    }

    @GetMapping("/create")
    public String getCreateForm(@ModelAttribute("menuitem") OrderItem orderItem){
        return "menuItemS";
    }


    @PostMapping("/create")
    public OrderItem create (@ModelAttribute("menuitem") OrderItem orderItem) {
        OrderItem newOrderItem = OrderItemFactory.createOrderItem(

                orderItem.getItemID(),
                orderItem.getQuantity(),
                orderItem.getTotalAmount()
        );

        return orderService.create(newOrderItem);
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
    public List<MenuItem> getAll() {return service.getAll();}
}
//
