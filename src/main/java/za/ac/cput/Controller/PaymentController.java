/**PaymentController.java
 * Controller for Payment
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **/
package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Payment;
import za.ac.cput.Factory.PaymentFactory;
import za.ac.cput.Service.impl.PaymentServicesImpl;

import java.util.Set;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentServicesImpl paymentServices;

    @PostMapping("/create")
    public Payment create (@RequestBody Payment payment)
    {
        Payment newPayment = PaymentFactory.createPayment(payment.getPaymentType(), payment.getReceiptID());
        return paymentServices.create(newPayment);
    }

    @GetMapping("/read/{paymentType}")
    public Payment read (@PathVariable String paymentType)
    {
        return paymentServices.read(paymentType);
    }

    @PostMapping ("/update")
    public Payment update (@RequestBody Payment payment)
    {
        Payment update = paymentServices.update(payment);

        return update;
    }

    @DeleteMapping ("/delete/{paymentType}")
    public boolean delete (@PathVariable(value = "paymentType") String paymentType)
    {
        return paymentServices.delete(paymentType);
    }

    @GetMapping ("/findAll")
    public Set<Payment> getAll()
    {
        return paymentServices.getAll();
    }



}
