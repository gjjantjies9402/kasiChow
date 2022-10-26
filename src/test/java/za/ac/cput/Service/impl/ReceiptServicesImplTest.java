/**ReceiptServicesImplTest.java
 * Test Service for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 17 October 2022
 **//*

package za.ac.cput.Service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.OrderFactory;
import za.ac.cput.Factory.ReceiptFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReceiptServicesImplTest {

    @Autowired
    private ReceiptServicesImpl receiptServices;

    //Build objects
    private static Receipt receipt1 = ReceiptFactory.createReceipt();
    private static Receipt receipt2 = ReceiptFactory.createReceipt();

    @Test
    void create() {
        Receipt saved = receiptServices.create(receipt1);
        assertEquals(receipt1.getReceiptID(), saved.getReceiptID());
        System.out.println(saved);
    }

    @Test
    void read() {
        Receipt rec = receiptServices.read(receipt1.getReceiptID());
        assertNotNull(rec);
        System.out.println("Read: " + rec);
        */
/*Payment p = payment2;
        assertNotNull(p);
        System.out.println(p);*//*

    }

    @Test
    void update() {
        Receipt updated = new Receipt.Builder().copy(receipt2).setOrder(receipt2.getOrderID()).build();
        assertEquals(receipt2.getReceiptID(), updated.getReceiptID());
        System.out.println(updated);
        //assertNotNull(receiptServices.update(updated));

        */
/*Receipt.Builder builder = new Receipt.Builder();
        builder.copy(receipt1);
        builder.setOrder(receipt1.getOrder());
        Receipt update = builder.build();
        System.out.println("Updated : " + '\n'+ update);*//*

    }

    @Test
    void delete() {
        boolean success = receiptServices.delete(receipt1.getReceiptID());
        assertTrue(success);
        System.out.println("Deleted" + success);
    }

    @Test
    void getAll() {
        Set<Receipt> receiptSet = receiptServices.getAll();
        receiptSet.forEach(employee -> System.out.println(receipt1.toString()));

        */
/*assertEquals(1, receiptServices.getAll().size());
        System.out.println("All Payments: " + receiptServices.getAll());*//*

    }
}*/
