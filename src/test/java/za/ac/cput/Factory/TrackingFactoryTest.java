package za.ac.cput.Factory;
/**
 TrackingFactoryTest.java
 TrackingFactoryTest
 Author: Zimkhitha Nkqenkqa 216280427
 Date: 10 April 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Tracking;

import static org.junit.jupiter.api.Assertions.*;

class TrackingFactoryTest {

    @Test
    void createTracking() {
        Tracking tracking = TrackingFactory.createTracking("ORD98", 2568, "Complete");
        System.out.println(tracking);
        assertNotNull(tracking);
    }
}