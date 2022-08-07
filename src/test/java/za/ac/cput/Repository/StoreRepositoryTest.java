//package za.ac.cput.Repository;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.Entity.Store;
//import za.ac.cput.Factory.StoreFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class StoreRepositoryTest {
//
//    private static StoreRepository storeRepository = StoreRepository.getStoreRepository();
//    private static Store stor = StoreFactory.buildStore("012","KFC-023","SPAR-055" );
//    @Test
//    void create() {
//        Store create = storeRepository.create(stor);
//        assertEquals(stor.getStoreId(), create.getStoreId());
//        System.out.println("Created: " + create);
//    }
//
//    @Test
//    void read() {
//        Store read = storeRepository.read(stor.getStoreId());
//        assertNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void update() {
//
//        Store update = new Store.Builder().copy(stor)
//                .setStoreId("012")
//                .setRestaurantId("KFC-023")
//                .setMarketId("SPAR-055")
//                .build();
//
//        System.out.println("Update: " + update);
//    }
//
//    @Test
//    void delete() {
//        boolean delete = storeRepository.delete((stor.getStoreId()));
//        assertTrue(delete);
//        System.out.println("Delete: " + delete);
//    }
//
//    @Test
//    void getAll() {
//        System.out.println("Show all");
//        System.out.println(storeRepository.getAll());
//    }
//}