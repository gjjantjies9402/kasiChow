/**ReceiptFactoryTest.java
 * Factory test class for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 08 April 2022
 **/
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Receipt;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptFactoryTest {

    @Test
    void createReceipt() {
        Receipt receipt = ReceiptFactory.createReceipt("R123456",
                OrderFactory.createOrder(25,"OR12345","D56",10,"Pending","11:00"));
        assertNotNull(receipt);
        System.out.println(receipt.toString());

    }
}