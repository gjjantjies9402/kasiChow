package za.ac.cput.Service.Interface;

import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Orders;
import za.ac.cput.Service.IService;

import java.util.List;

@Service
public interface IOrderService extends IService<Orders, String> {
    public List<Orders> getAll();
}

