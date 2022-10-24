package za.ac.cput.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import za.ac.cput.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Factory.OrderFactory;
import za.ac.cput.Service.impl.OrderService;

import java.util.List;

@Controller
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("Orders", orderService.getAll());
        return "OrderHome";
    }
    @GetMapping("/create")
    public String create(@ModelAttribute("Order") Order order) {
        return "OrderAdd";
    }
    @PostMapping("/create")
    public String create (@ModelAttribute("Order") Order order, BindingResult result)
    {
        if (result.hasErrors())
            return "orderAdd";
        Order newOrder = OrderFactory.createOrder
                (
                        order.getCustID(),
                        order.getOrderID(),
                        order.getDriverID(),
                        order.getItemID(),
                        order.getTrackStatus(),
                        order.getTrackETA()
                );
        orderService.create(newOrder);
        return  "redirect:/order/home";
    }

    @GetMapping("/read/{orderID}")
    public Order read(@PathVariable String orderID)
    {
        return orderService.read(orderID);
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order order)
    {
        return orderService.update(order);
    }

    @DeleteMapping(value = "/delete/{orderID}")
    public boolean delete(@PathVariable (value = "orderID") String orderID) {
        return orderService.delete(orderID);
    }

    @GetMapping(value = "/getall")
    public List<Order> getAll()
    {
        return orderService.getAll();
    }

}