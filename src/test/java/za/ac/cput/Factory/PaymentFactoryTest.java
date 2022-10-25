/**PaymentFactoryTest.java
 * Factory test class for Payment
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 08 April 2022
 **/
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Payment;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {
    @Test
    public void test(){
        Payment payment = PaymentFactory.createPayment(
                "1", "Card","Nikitha Mbokotwana","9715-0092-5113-6222","Dec","2025", 876);
        System.out.println(payment.toString());
        assertNotNull(payment);
    }

}