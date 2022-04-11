package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.menu;
import za.ac.cput.Entity.orderItem;
import za.ac.cput.Repository.iml.iReposoitory;

import java.util.Set;

public interface orderItemInterface extends iReposoitory<orderItem, String> {

    public Set<orderItem> getAll();
}
