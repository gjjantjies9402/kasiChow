package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.staff;
import za.ac.cput.Repository.iml.iRepository;

import java.util.Set;

public interface staffInterface extends iRepository<staff, String> {

    public Set<staff> getAll();
}
