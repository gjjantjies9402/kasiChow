package za.ac.cput.Controller;

import za.ac.cput.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Factory.OrderFactory;
import za.ac.cput.Service.impl.OrderService;

import java.util.Set;

@Controller
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/Create")
    @ResponseBody
    public Order create(@RequestBody Order order) {
        Order order1 = OrderFactory.createOrder(order.getOrderNr(),order.getCustID(),order.getCustIMEI(),order.getStoreRefID(),order.getOrderUpdate());
        return orderService.create(order1);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Order read(@PathVariable String id)
    {
        return orderService.read(id);
    }

    @PostMapping("/update")
    @ResponseBody
    public Order update(@RequestBody Order order)
    {
        return orderService.update(order);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id)
    {
        return orderService.delete(id);
    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Order> getAll()
    {
        return orderService.getAll();
    }

}

