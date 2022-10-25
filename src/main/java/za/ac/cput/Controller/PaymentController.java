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
        Payment newPayment = PaymentFactory.createPayment(payment.getPaymentID(), payment.getPaymentType(), payment.getNameOnCard(), payment.getCreditCardNumber(), payment.getExpMonth(), payment.getExpYear(), payment.getCvv());

        return paymentServices.create(newPayment);
    }

    @GetMapping("/read/{paymentID}")
    public Payment read (@PathVariable String paymentID)
    {
        return paymentServices.read(paymentID);
    }

    @PostMapping ("/update")
    public Payment update (@RequestBody Payment payment)
    {
        Payment update = paymentServices.update(payment);

        return update;
    }

    @DeleteMapping ("/delete/{paymentID}")
    public boolean delete (@PathVariable(value = "paymentID") String paymentID)
    {
        return paymentServices.delete(paymentID);
    }

    @GetMapping ("/getall")
    public Set<Payment> getAll()
    {
        return paymentServices.getAll();
    }

}
