///**
// * Mandisa Msongelwa
// * 217149073
// * Group 28
// */
//package za.ac.cput.Repository;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.Entity.Menu;
//import za.ac.cput.Factory.MenuFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MenuRepositoryTest {
//    @Autowired
//    private MenuRepository menuRepo;
//    private static Menu men = MenuFactory.creatingMenu(1, "Poultry");
//    @Test
//    void create() {
//        Menu create = menuRepo.create(men);
//        assertEquals(men.getMenuID(), create.getMenuID());
//        System.out.println(create);
//
//    }
//
//    @Test
//    void read() {
//        Menu read = menuRepo.read(men.getMenuCategory());
//        assertNotNull(read);
//        System.out.println(read);
//    }
//
//    @Test
//    void update() {
//        Menu update = new Menu.Builder()
//                .setMenuCategory("Poultry")
//                .build();
//    }
//
//    @Test
//    void delete() {
//        boolean deleted = menuRepo.delete(men.getMenuCategory());
//        assertTrue(deleted);
//        System.out.println(deleted);
//    }
//
//    @Test
//    void getAll() {
//        System.out.println(menuRepo.getAll());
//    }
//}