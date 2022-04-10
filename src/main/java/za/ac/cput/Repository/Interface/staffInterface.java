package za.ac.cput.Repository.Interface;

import za.ac.cput.Entity.staff;
import za.ac.cput.Repository.iml.iReposoitory;

import java.util.Set;

public interface staffInterface extends iReposoitory<staff, String> {

    public Set<staff> getAll();
}
