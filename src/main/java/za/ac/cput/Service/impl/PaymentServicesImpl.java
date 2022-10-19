/**PaymentServices.java
 * Service for Payment
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **/
package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Payment;
import za.ac.cput.Repository.Interface.iPaymentRepository;
import za.ac.cput.Service.Interface.IPaymentService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PaymentServicesImpl implements IPaymentService {
    @Autowired
    private iPaymentRepository repository;

    @Override
    public Payment create(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public Payment read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Payment update(Payment payment) {
        if(this.repository.existsById(payment.getReceiptID())){
            return this.repository.save(payment);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s))
            return false;
        else
            return true;
    }

    @Override
    public Set<Payment> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());

    }
}
