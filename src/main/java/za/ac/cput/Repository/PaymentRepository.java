package za.ac.cput.Repository;


import za.ac.cput.Entity.Payment;
import za.ac.cput.Repository.Interface.iPaymentRepository;

import java.util.Set;

public class PaymentRepository implements iPaymentRepository {




    @Override
    public Payment create(Payment payment) {
        return null;
    }

    @Override
    public Payment read(String s) {
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Set<Payment> getAll() {
        return null;
    }
}
