//package za.ac.cput.Repository;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.Entity.Supermarket;
//import za.ac.cput.Factory.SupermarketFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SupermarketRepositoryTest {
//
//    private static SupermarketRepository supermarketRepository= SupermarketRepository.getSupermarketRepository();
//    private static Supermarket mar = SupermarketFactory.buildSupermarket("Shop 3a", "FoodLovers", " Pinehurst Shop Ctr, Brackenfell Blvrd Durbanville 7550");
//    @Test
//    void create() {
//        Supermarket create = supermarketRepository.create(mar);
//        assertEquals(mar.getMarketId(), create.getMarketId());
//        System.out.println("Created: " + create);
//    }
//
//    @Test
//    void read() {
//        Supermarket read = supermarketRepository.read(mar.getMarketId());
//        assertNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void update() {
//
//        Supermarket update = new Supermarket.Builder().copy(mar)
//                .setMarketId("Shop 3a")
//                .setMarketName("FoodLovers")
//                .setMarketLocation(" Pinehurst Shop Ctr, Brackenfell Blvrd Durbanville 7550")
//                .build();
//
//        System.out.println("Update: " + update);
//    }
//
//    @Test
//    void delete() {
//        boolean delete = supermarketRepository.delete((mar.getMarketId()));
//        assertTrue(delete);
//        System.out.println("Delete: " + delete);
//    }
//
//    @Test
//    void getAll() {
//        System.out.println("Show all");
//        System.out.println(supermarketRepository.getAll());
//    }
//}