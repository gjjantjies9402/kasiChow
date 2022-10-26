/**PaymentController.java
 * Controller for Payment
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **/
package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Payment;
import za.ac.cput.Factory.PaymentFactory;
import za.ac.cput.Service.impl.PaymentServicesImpl;
import java.util.Set;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServicesImpl paymentServices;

    @GetMapping("/create")
    public String getCreateForm(@ModelAttribute("payment") Payment payment){
        return "payment";
    }
    @PostMapping("/create")
    public String create(@RequestBody Payment payment, BindingResult result) {
        if (result.hasErrors())
            return "payment";
        Payment newPayment = PaymentFactory.createPayment(payment.getPaymentID(), payment.getPaymentType(),
                payment.getNameOnCard(), payment.getCreditCardNumber(), payment.getExpMonth(), payment.getExpYear(),
                payment.getCvv());

         paymentServices.create(newPayment);
         return "redirect:/receipt/home";
    }

    @GetMapping("/read/{paymentID}")
    public Payment read(@PathVariable String paymentID) {
        return paymentServices.read(paymentID);
    }

    @PostMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        Payment update = paymentServices.update(payment);

        return update;
    }

    @DeleteMapping("/delete/{paymentID}")
    public boolean delete(@PathVariable(value = "paymentID") String paymentID) {
        return paymentServices.delete(paymentID);
    }

    @GetMapping("/getall")
    public Set<Payment> getAll() {
        return paymentServices.getAll();
    }

}
