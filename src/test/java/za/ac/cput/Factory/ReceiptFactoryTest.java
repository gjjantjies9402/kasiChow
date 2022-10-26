/**ReceiptFactoryTest.java
 * Factory test class for Receipt
 * Author: Nikitha Mbokotwana (218337906)
 * Date: 08 April 2022
 **//*

package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Receipt;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptFactoryTest {

    @Test
    void createReceipt() {
        Receipt receipt = ReceiptFactory.createReceipt("R56789",
                OrderFactory.createOrder("", "OR45",
                        CustomerFactory.createCustomer("C56",
                                DriverFactory.createDriver("D7",
                                        MenuItemFactory.createMenuItem("IM09")))));
        assertNotNull(receipt);
        System.out.println(receipt.toString());

    }
}*/
