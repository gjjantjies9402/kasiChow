//package za.ac.cput.Repository.Interface;
///**
// TrackingRepositoryTest.java
// TrackingRepositoryTest
// Author: Zimkhitha Nkqenkqa 216280427
// Date: 10 April 2022
// */
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.Entity.Tracking;
//import za.ac.cput.Factory.TrackingFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class TrackingRepositoryTest {
//    private static TrackingRepository trackingRepository = TrackingRepository.getRepository();
//    private static Tracking tracking = TrackingFactory.createTracking("ORD98", 2568, "Complete");
//
//    @Test
//    void getRepository() {
//    }
//
//    @Test
//    void create() {
//        Tracking trackingCreated = trackingRepository.create(tracking);
//        assertEquals(trackingCreated.getOrderNr(), tracking.getOrderNr());
//        System.out.println("Created: " + trackingCreated);
//    }
//
//    @Test
//    void read() {
//        Tracking read = trackingRepository.read(tracking.getOrderNr());
//        System.out.println("Read :" + read);
//    }
//
//    @Test
//    void update() {Tracking updateTracking = new Tracking.Builder().copy(tracking)
//            .setOrderNr("ORD98")
//            .build();
//        assertEquals(updateTracking.getOrderNr(),tracking.getOrderNr());
//        System.out.println("Updated Tracking " + updateTracking);
//    }
//
//    @Test
//    void delete() {
//        trackingRepository.delete(tracking.getOrderNr());
//        assertNotNull(trackingRepository);
//    }
//
//    @Test
//    void getAll() {
//        System.out.println("Tracking: \n" + trackingRepository.getAll());
//    }
//}