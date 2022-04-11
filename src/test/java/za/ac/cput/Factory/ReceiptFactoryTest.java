/*ReceiptFactoryTest.java
Factory test class for Receipt
Author: Nikitha Mbokotwana (218337906)
Date: 08 April 2022
 */
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Receipt;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptFactoryTest {
    @Test
    public void test(){
        Receipt receipt = ReceiptFactory.createReceipt("220475643", 12,"2245638","87467856785", 100);
        System.out.println(receipt.toString());
        assertNotNull(receipt);
    }

}