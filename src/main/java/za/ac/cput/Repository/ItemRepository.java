package za.ac.cput.Repository;


import za.ac.cput.Entity.Item;
import za.ac.cput.Repository.Interface.iItemRepository;

import java.util.HashSet;
import java.util.Set;

public class ItemRepository implements iItemRepository {
    private static ItemRepository repository = null;
    private Set<Item> itemDB = null;

    private ItemRepository() {
        itemDB = new HashSet<Item>();
    }

    public static ItemRepository getRepository() {
        if (repository == null)
            repository = new ItemRepository();
    return repository;
}




    @Override
    public Item create(Item item) {
        return null;
    }

    @Override
    public Item read(String s) {
        return null;
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Set<Item> getAll() {
        return null;
    }
}
