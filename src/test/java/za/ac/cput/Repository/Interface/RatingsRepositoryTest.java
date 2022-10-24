//package za.ac.cput.Repository.Interface;
///**
// RatingsRepositoryTest.java
// TrackingRepositoryTest
// Author: Zimkhitha Nkqenkqa 216280427
// Date: 10 April 2022
// */
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.Entity.Ratings;
//import za.ac.cput.Factory.RatingsFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class RatingsRepositoryTest {
//    private static RatingsRepository ratingsRepository = RatingsRepository.getRepository();
//    private static Ratings ratings = RatingsFactory.createRatings(8868, "ORD98", 5, "Service was great!");
//
//    @Test
//    void getRepository() {
//    }
//
//    @Test
//    void create() {
//        Ratings rateCreated = ratingsRepository.create(ratings);
//        assertEquals(rateCreated.getOrderID(), ratings.getOrderID());
//        System.out.println("Created: " + rateCreated);
//    }
//
//    @Test
//    void read() {
//        Ratings read = ratingsRepository.read(ratings.getOrderID());
//        System.out.println("Read :" + read);
//    }
//
//    @Test
//    void update() {Ratings updateRate = new Ratings.Builder().copy(ratings)
//            .setOrderID("ORD98")
//            .build();
//        assertEquals(updateRatings.getOrderID(),ratings.getOrderID());
//        System.out.println("Updated rating " + updateRate);
//    }
//
//    @Test
//    void delete() {
//        ratingsRepository.delete(ratings.getOrderID());
//        assertNotNull(ratingsRepository);
//    }
//
//    @Test
//    void getAll() {
//        System.out.println("Ratings: \n" + ratingsRepository.getAll());
//    }
//}