package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.Payment;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface iPaymentRepository extends iRepository<Payment,String> {
    public Set<Payment> getAll();
}
