package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.Item;
import za.ac.cput.Repository.iml.iRepository;


import java.util.Set;

public interface iItemRepository extends iRepository<Item,String> {
    public Set<Item> getAll();
}
