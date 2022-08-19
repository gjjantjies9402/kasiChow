package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.OrderItem;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

@Repository
public interface OrderItemInterface extends JpaRepository<OrderItem, String> {

//    public Set<OrderItem> getAll();
}
