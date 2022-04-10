package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Item;
import za.ac.cput.Factory.ItemFactory;


import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    private static ItemRepository itemRepository = ItemRepository.getRepository();
    private static Item item = ItemFactory.createItem("45324565","Toppers",10);

    @Test
    void create(){
        Item create = itemRepository.create(item);
        assertEquals(item.getItemID(), create.getItemName());
        System.out.println("Created: " + create);
    }
    @Test
    void read(){
        Item read = itemRepository.read(item.getItemID());
        assertNull(read);
        System.out.println("Read: " + read);
    }
    @Test
    void update(){
        Item update = new Item.Builder().copy(item)
                .setItemID("2134578")
                .setItemName("Peaches")
                .setItemPrice(8)
                .build();
        System.out.println("Update: " + update);
    }
    @Test
    void delete() {
        boolean delete = PaymentRepository.getRepository().delete(item.getItemID());
        assertTrue(delete);
        System.out.println("Delete: " + delete);
    }

    @Test
    void getAll() {
        System.out.println("Show all");
        System.out.println(PaymentRepository.getRepository().getAll());
    }

}