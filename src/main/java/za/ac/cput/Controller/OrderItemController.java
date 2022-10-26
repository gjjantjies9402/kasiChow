package za.ac.cput.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.OrderItem;
import za.ac.cput.Factory.OrderItemFactory;
import za.ac.cput.Service.impl.OrderItemService;

import java.util.Set;


@RestController
@Controller
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

        @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("orderItems", orderItemService.getAll());
        return "orderItemsHome";
    }

    @PostMapping("/create")
    public OrderItem create (@RequestBody OrderItem orderItem) {
        OrderItem newOrderItem = OrderItemFactory.createOrderItem (
                orderItem.getItemID(),
                orderItem.getQuantity(),
                orderItem.getTotalAmount()
        );
        return orderItemService.create(newOrderItem);
    }

    @GetMapping("/create")
    public String create(@ModelAttribute OrderItem orderItem, BindingResult result, Model model) {
        if (result.hasErrors())
            return "orderItemAdd";
        orderItemService.create(orderItem);
        return "redirect:/orderItem/home";
    }


    @GetMapping(value = "/read/{id}")
    public OrderItem read (@PathVariable String id) {return orderItemService.read(id);}

    @GetMapping("/update")
    public OrderItem update (@RequestBody OrderItem orderItem) {
        OrderItem update = orderItemService.update(orderItem);

        return update;
    }

    @PostMapping("/update")
    public String update(OrderItem orderItem, BindingResult result, Model model) {
        if (result.hasErrors())
            return "orderItemUpdate";
        orderItemService.update(orderItem);
        return "redirect:/orderItem/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@RequestBody OrderItem orderItem) {
        if (orderItemService.delete(orderItem.getItemID()))
            return "Delete";
        else
            return "Not Deleted";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        orderItemService.delete(id);
        model.addAttribute("orderItems", orderItemService.getAll());
        return "redirect:/orderItem/home";
    }

    @GetMapping(value = "/getall")
    public Set<OrderItem> getAll() {return orderItemService.getAll();}
}

