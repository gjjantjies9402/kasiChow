package za.ac.cput.Interface;

import za.ac.cput.Entity.Payment;

import java.util.Set;

public interface iPaymentRepository extends iReposoitory<Payment,String>{
    public Set<Payment> getAll();
}
