/*ItemFactoryTest.java
Factory test class for item
Author: Nikitha Mbokotwana (218337906)
Date: 08 April 2022
 */
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Item;

import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {

    @Test
    public void test(){
        Item item = ItemFactory.createItem("576746", "Toppers", 7);
        System.out.println(item.toString());
        assertNotNull(item);
    }

}