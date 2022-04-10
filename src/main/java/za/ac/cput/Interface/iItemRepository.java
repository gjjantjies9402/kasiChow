package za.ac.cput.Interface;

import za.ac.cput.Entity.Item;

import java.util.Set;

public interface iItemRepository extends iReposoitory<Item,String>{
    public Set<Item> getAll();
}
