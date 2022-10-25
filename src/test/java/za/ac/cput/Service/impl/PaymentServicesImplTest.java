/**PaymentServicesImplTest.java
 * Test Service for Payment
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **/
package za.ac.cput.Service.impl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Payment;
import za.ac.cput.Factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServicesImplTest {
    @Autowired
    private PaymentServicesImpl paymentServices;

    private static Payment payment1 = PaymentFactory.createPayment("1", "Card", "Nikitha Mbokotwana", "2345-5678-6754-7890", "Dec", "2025", 906);
    private static Payment payment2 = PaymentFactory.createPayment("2", "Card", "Othalive Mbokotwana", "2345-5678-6754-7897", "Dec", "2025", 907);

    @Test
    void create() {
        Payment saved = paymentServices.create(payment1);
        assertEquals(payment1.getPaymentID(), saved.getPaymentID());
        System.out.println(saved);
    }

    @Test
    void read() {
        Payment pay = paymentServices.read(payment1.getPaymentID());
        assertNotNull(pay);
        System.out.println("Read: " + pay);
        /*Payment p = payment2;
        assertNotNull(p);
        System.out.println(p);*/
    }

    @Test
    void update() {
        Payment updated = new Payment.Builder().copy(payment1).setNameOnCard("Lathitha Tempi").build();
        assertEquals(payment1.getPaymentID(), updated.getPaymentID());
        assertNotNull(paymentServices.update(updated));
        System.out.println(updated);
    }

    @Test
    void delete() {
        boolean success = paymentServices.delete(payment1.getPaymentID());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void getAll() {
        assertEquals(1, paymentServices.getAll().size());
        System.out.println("All Payments: " + paymentServices.getAll());
    }
}