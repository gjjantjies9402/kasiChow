package za.ac.cput.Repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Payment;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;
@Repository
public interface iPaymentRepository extends JpaRepository<Payment,String> {
//    public Set<Payment> getAll();
}
