package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.DeliveryAddress;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryAddressFactoryTest {

    @Test
    void createDeliveryAddress() {

        DeliveryAddress deliveryAddress = DeliveryAddressFactory.createDeliveryAddress("0236", "9532 College Street Cape Town 8000");
        assertNotNull(deliveryAddress);
        System.out.println("Delivery Address Created: "+deliveryAddress);
    }

}