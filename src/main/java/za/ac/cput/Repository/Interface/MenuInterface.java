package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.Menu;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface MenuInterface extends iRepository<Menu, String> {

    public Set<Menu> getAll();
}
