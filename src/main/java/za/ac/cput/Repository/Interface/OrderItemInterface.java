package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.OrderItem;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface OrderItemInterface extends iRepository<OrderItem, String> {

    public Set<OrderItem> getAll();
}
